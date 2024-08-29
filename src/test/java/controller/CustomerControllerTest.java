package controller;

import app.controllers.AccountController;
import app.controllers.CustomerController;
import app.dto.AccountRequest;
import app.dto.CustomerRequest;
import app.dto.CustomerResponse;
import app.model.Customer;
import app.service.AccountService;
import app.service.CustomerService;
import app.utils.CustomCurrency;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @MockBean
    private CustomerService customerService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void getCustomerById() {

    }
    @Test
    void getAllCustomers() {
    }
    @Test
    public void saveCustomer() {
    }
    @Test
    void changeCustomer() {

    }
    @Test
    public void deleteCustomer() {

    }
    @Test
    public void createAccountForCustomer() {

    }
    @Test
    public void deleteAccountForCustomer() {

    }


}


