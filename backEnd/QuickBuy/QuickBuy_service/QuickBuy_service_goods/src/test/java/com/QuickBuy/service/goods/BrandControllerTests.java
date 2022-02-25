package com.QuickBuy.service.goods;

//import com.QuickBuy.service.goods.controller.BrandController;

import com.QuickBuy.goods.pojo.Brand;
import org.junit.Before;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Ruilin Cheng
 * @create 2022-02-23 9:55
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        //此种方式可通过spring上下文来自动配置一个或多个controller
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        //此种方式，手工指定想要的controller, 行不通，应该是项目的包结构有问题！！！！
//        mockMvc = MockMvcBuilders.standaloneSetup(new BrandController()).build();
    }

    @Test
    public void testfindList() throws Exception {
        mockMvc.perform(get("/brand/"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testfindById() throws Exception {
        // only use id 1528 for test
        mockMvc.perform(get("/brand/1528"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testadd() throws Exception {
        RequestBuilder request = null;
        request = post("/brand/");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testupdate() throws Exception {
        RequestBuilder request = null;
        request = put("/brand/00000000");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testdelete() throws Exception {
        RequestBuilder request = null;
        request = delete("/brand/00000000");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testsearch() throws Exception {
        RequestBuilder request = null;
        request = get("/brand/search");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }
}
