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

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testall() throws Exception {
        RequestBuilder request = null;
        request = get("/product");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testId() throws Exception {
        RequestBuilder request = null;
        request = get("/product/05071001");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testcategory() throws Exception {
        RequestBuilder request = null;
        request = get("/product/category?category_id=1");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testname() throws Exception {
        RequestBuilder request = null;
        request = get("/product/name?name=bana");

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

}
