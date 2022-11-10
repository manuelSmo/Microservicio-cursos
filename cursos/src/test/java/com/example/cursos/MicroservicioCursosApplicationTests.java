package com.example.cursos;

import com.example.cursos.controller.CursosController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = CursosController.class)
class MicroservicioCursosApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testCurso() throws Exception {
		mockMvc.perform(get("/buscarCurso/{name}","Python"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Python"));;
	}

}
