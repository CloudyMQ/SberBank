package com.example.demo2.service;

import com.example.demo2.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AccountsServiceImpl implements AccountsService{

    @Autowired
    AccountsRepository accountsRepository;


    public boolean isExist(String account){
        return accountsRepository.existByAccount(account);
    }

}

