package com.QuickBuy.service.order;


import com.QuickBuy.Order.OrderApplication;
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
 * @create 2022-02-23 14:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class LogControllerTests {
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
    public void testfindAll() throws Exception {
        mockMvc.perform(get("/log"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testfindById() throws Exception {
        mockMvc.perform(get("/log/000000"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testadd() throws Exception {
        mockMvc.perform(post("/log"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testupdate() throws Exception {
        mockMvc.perform(put("/log/000000"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testdelete() throws Exception {
        mockMvc.perform(delete("/log/000000"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testfindList() throws Exception {
        mockMvc.perform(get("/log/search"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
