package com.onlinebanking.ICINBank.tests;

import com.onlinebanking.ICINBank.controllers.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {

        @LocalServerPort
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void checkIfUserCanLogin() throws Exception {
            assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                    String.class)).contains("Login");
        }


}
