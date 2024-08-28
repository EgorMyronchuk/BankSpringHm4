package app.controllers;

import app.dto.AccountRequest;
import app.dto.CustomerRequest;
import app.dto.CustomerResponse;
import app.facade.AccountFacade;
import app.facade.CustomerFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import app.model.Account;
import app.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import app.service.CustomerService;
import app.utils.CustomCurrency;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerFacade customerFacade;
    private final AccountFacade accountFacade;

    @GetMapping("{id}")
    public CustomerResponse getCustomerById(@PathVariable Long id) {
        return customerFacade.convertToResponse(customerService.getCustomerById(id));
    }

    @GetMapping
    public Page<CustomerResponse> getAllCustomers(
            @RequestParam(defaultValue = "0" ) int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Customer> pagedCustomers = customerService.getAllCustomers(page , size);
       // pagedCustomers.get().map(customerFacade::convertToResponse).collect(Collectors.toList()); Потрібно повертати List<Customer> чи , всеж таки Page<CustomerResponse>?
        return pagedCustomers.map(customerFacade::convertToResponse);
    }

    @PostMapping
    public void saveCustomer(@Valid @RequestBody CustomerRequest customer) {
        customerService.saveCustomer(customerFacade.convertToEntity(customer));
    }

    @PutMapping("{id}")
    public void changeCustomer(@PathVariable Long id, @RequestBody CustomerRequest customer) {
        customerService.changeCustomer(id, customerFacade.convertToEntity(customer));
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @PostMapping("{id}/accounts")
    public void createAccountForCustomer(@PathVariable Long id, @RequestParam CustomCurrency currency) {
        customerService.createAccountForCustomer(id, currency);
    }

    @DeleteMapping("{id}/accounts")
    public void deleteAccountForCustomer(@PathVariable Long id, @RequestBody AccountRequest account) {
        customerService.deleteAccountForCustomer(id,accountFacade.convertToEntity(account));
    }
}
