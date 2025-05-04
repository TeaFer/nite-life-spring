package com.nitelife.nitelife.account;

import com.nitelife.nitelife.mail.MailService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final MailService mailService;

    public AccountService(AccountRepository accountRepository, MailService mailService) {
        this.accountRepository = accountRepository;
        this.mailService = mailService;
    }

    public Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void signUpAccount(@Valid AccountSignUpRequest accountSignUpRequest) {
        Account account = Account.builder().
                username(accountSignUpRequest.getUsername()).
                password(accountSignUpRequest.getPassword()).
                displayName(accountSignUpRequest.getDisplayName()).
                fullName(accountSignUpRequest.getFullName()).
                gender(accountSignUpRequest.getGender()).
                build();

        accountRepository.save(account);
    }

    public void resetPassword(String email) {
        if (accountRepository.existsByEmail(email) | email.length() != 0) {
            mailService.sendMail("fnuferry6@gmail.com", "Password reset", "Password reset");
        }
    }

}
