package com.QuickBuy.service.goods;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ruilin Cheng
 * @create 2022-02-23 13:36
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginControllerTest {
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
    public void testadd() throws Exception {
        RequestBuilder request = null;
        request = post("/user/add");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testupdate() throws Exception {
        RequestBuilder request = null;
        request = post("/user/update");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testlogin() throws Exception {
        RequestBuilder request = null;
        request = post("/user/login");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }
}
