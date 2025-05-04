package com.nitelife.nitelife.account;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Account>> getAccounts() {
        return ResponseEntity
                .ok()
                .body(accountService.getAccounts());
    }

    @PostMapping()
    public void signUpAccount(@Valid @RequestBody AccountSignUpRequest accountSignUpRequest) {
        accountService.signUpAccount(accountSignUpRequest);
    }

    @GetMapping("password-reset")
    public void passwordReset(@RequestParam String email) {
        System.out.println("Password reset");
        accountService.resetPassword(email);
    }
}
