package com.ob.moneyhub.service;

import com.ob.moneyhub.entity.Account;
import com.ob.moneyhub.model.MoneyHubAccountsResponse;
import com.ob.moneyhub.repository.MoneyHubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MoneyHubService {

    private final MoneyHubRepository moneyHubRepository;
    public MoneyHubService(MoneyHubRepository moneyHubRepository) {
        this.moneyHubRepository = moneyHubRepository;
    }

    public MoneyHubAccountsResponse getAllAccounts() {
        var moneyHubAccountsResponse = new MoneyHubAccountsResponse();
        List<Account> accountList = moneyHubRepository.findAll();
        moneyHubAccountsResponse.setData(accountList);
        return moneyHubAccountsResponse;
    }

    public Account getAccountById(long id) {
        return moneyHubRepository.findById(id).orElse(null);
    }

    public Account createAccount(Account account) {
        return moneyHubRepository.save(account);
    }

    public Account updateAccount(long id, Account account) {
        Account existingAccount = moneyHubRepository.findById(id).orElse(null);
        if (existingAccount != null) {
            existingAccount.setAccountName(account.getAccountName());
            existingAccount.setAccountType(account.getAccountType());
            return moneyHubRepository.save(existingAccount);
        }
        return null;
    }

    public void deleteAccount(long id) {
        moneyHubRepository.deleteById(id);
    }

    public void deleteAllAccounts() {
        moneyHubRepository.deleteAll();
    }

 /*   public List<Account> findByPublished(boolean published) {
        return moneyHubRepository.findByPublished(published);
    }

    public List<Account> findByTitleContaining(String title) {
        return moneyHubRepository.findByTitleContaining(title);
    }*/
}