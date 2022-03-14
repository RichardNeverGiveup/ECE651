package com.QuickBuy.service.order;
import com.QuickBuy.OrderApplication;
import org.junit.Before;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Yijia Zhang
 * @create 2022-02-25 09:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class OrderItemTests {
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
        mockMvc.perform(get("/orderItem"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testfindById() throws Exception {
        mockMvc.perform(get("/orderItem"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testadd() throws Exception {
        mockMvc.perform(post("/orderItem"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testupdate() throws Exception {
        mockMvc.perform(put("/orderItem/000000"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testdelete() throws Exception {
        mockMvc.perform(delete("/orderItem/000000"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testfindList() throws Exception {
        mockMvc.perform(get("/orderItem/search"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

