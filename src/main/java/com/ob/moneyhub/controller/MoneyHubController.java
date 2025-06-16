package com.ob.moneyhub.controller;

import com.ob.moneyhub.entity.Account;
import com.ob.moneyhub.model.MoneyHubAccountsResponse;
import com.ob.moneyhub.service.MoneyHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moneyhub")
public class MoneyHubController {

    private final MoneyHubService moneyHubService;
    public MoneyHubController(MoneyHubService moneyHubService){
        this.moneyHubService = moneyHubService;
    }

    @GetMapping("/")
    public ResponseEntity<MoneyHubAccountsResponse> getAccounts() {
      var moneyHubAccountsResponse  = moneyHubService.getAllAccounts();
        return ResponseEntity.ok().body(moneyHubAccountsResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") long id) {
        Account account = moneyHubService.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(moneyHubService.createAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") long id, @RequestBody Account account) {
        Account updatedAccount = moneyHubService.updateAccount(id, account);
        if (updatedAccount != null) {
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") long id) {
        moneyHubService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllAccounts() {
        moneyHubService.deleteAllAccounts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

/*    @GetMapping("/published")
    public ResponseEntity<List<Account>> findByPublished() {
        return new ResponseEntity<>(moneyHubService.findByPublished(true), HttpStatus.OK);
    }*/
}
