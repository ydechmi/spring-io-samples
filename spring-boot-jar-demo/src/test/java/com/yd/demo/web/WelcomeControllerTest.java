package com.yd.demo.web;

        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.boot.test.SpringApplicationConfiguration;
        import org.springframework.http.MediaType;
        import org.springframework.mock.web.MockServletContext;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
        import org.springframework.test.context.web.WebAppConfiguration;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.setup.MockMvcBuilders;

        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ydechmi on 25/05/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class WelcomeControllerTest {

    private MockMvc mvc;


    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new WelcomeController()).build();
    }

    @Test
    public void testIndex() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spring-boot-jar-demo/welcome").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }
}