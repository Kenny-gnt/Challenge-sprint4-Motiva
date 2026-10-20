
package br.com.motiva;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MotivaApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void deveListarTrechos() throws Exception {
        mockMvc.perform(get("/api/trechos"))
                .andExpect(status().isOk());
    }

    @Test
    void deveRetornar404ParaTrechoInexistente() throws Exception {
        mockMvc.perform(get("/api/trechos/9999"))
                .andExpect(status().isNotFound());
    }
}
