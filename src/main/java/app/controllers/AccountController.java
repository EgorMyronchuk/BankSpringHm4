package app.controllers;

import app.facade.CustomerFacade;
import app.utils.CustomCurrency;
import lombok.RequiredArgsConstructor;
import app.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import app.service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("deposit")
    public ResponseEntity<?> deposit (@RequestParam String cardNumber ,@RequestParam  Double amount) {
      Optional<Account> account = accountService.deposit(cardNumber , amount);

      if (account.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(account.get());
      else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card with this number not found");
    }

    @PostMapping("withdraw")
    public ResponseEntity<?> withdraw (@RequestParam String cardNumber ,@RequestParam  Double amount) {
        Optional<Account> account = accountService.withdraw(cardNumber , amount);

        if (account.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(account.get());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card with this number not found");
    }

    @PostMapping("transfer")
    public ResponseEntity<?> transfer (@RequestParam String cardNumberFrom ,@RequestParam  String cardNumberTo ,@RequestParam  Double amount) {
        Optional<List<Account>> account = accountService.transfer(cardNumberFrom, cardNumberTo , amount);
        if (account.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(account.get());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card with this number not found or Not enough money to transfer");
    }


}
