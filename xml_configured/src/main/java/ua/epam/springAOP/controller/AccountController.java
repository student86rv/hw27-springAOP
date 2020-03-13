package ua.epam.springAOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ua.epam.springAOP.model.Account;
import ua.epam.springAOP.service.AccountService;

import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{id}")
    public Account get(@PathVariable(value = "id") Long id) {
        return accountService.get(id);
    }

    @GetMapping("/accounts")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping("/accounts")
    public ResponseEntity add(@RequestBody Account account) {
        accountService.add(account);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody Account account) {
        accountService.update(id, account);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        accountService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
