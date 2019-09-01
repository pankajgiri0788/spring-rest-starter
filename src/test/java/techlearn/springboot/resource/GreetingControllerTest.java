package techlearn.springboot.resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations="classpath:test.properties")
class GreetingControllerTest {

    @InjectMocks
    public GreetingController greetingController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();;
    }

    @DisplayName("Test Greet Controller - with query param")
    @Test
    void greet() throws Exception {
        mockMvc.perform(get("/api/hello")
                .accept(MediaType.ALL_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Pankaj"));
    }
}