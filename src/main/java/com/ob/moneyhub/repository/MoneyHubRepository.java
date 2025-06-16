package com.ob.moneyhub.repository;

import com.ob.moneyhub.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoneyHubRepository extends JpaRepository<Account, Long> {
    /*List<Account> findByPublished(boolean published);
    List<Account> findByTitleContaining(String title);*/
}