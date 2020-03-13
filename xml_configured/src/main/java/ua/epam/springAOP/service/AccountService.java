package ua.epam.springAOP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.springAOP.exception.EntityNotFoundException;
import ua.epam.springAOP.model.Account;
import ua.epam.springAOP.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account get(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public void add(Account account) {
        accountRepository.save(account);
    }

    public void update(Long id, Account newAccount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        account.setName(newAccount.getName());
        account.setBalance(newAccount.getBalance());
        account.setEmail(newAccount.getEmail());

        accountRepository.save(account);
    }

    public void delete(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        accountRepository.delete(account);
    }
}
