package controller;

import app.controllers.AccountController;
import app.controllers.EmployerController;
import app.service.AccountService;
import app.service.EmployerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployerController.class)
public class EmployerControllerTest {
    @MockBean
    private EmployerService employerService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    void getEmployerById( ) {

    }

    void getAllEmployers() {

    }


    void saveEmployer( ) {

    }
}
