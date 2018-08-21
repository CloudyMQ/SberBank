package com.example.demo2.service;

import com.example.demo2.entity.Accounts;
import com.example.demo2.model.RemittanceModel;
import com.example.demo2.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RemittanceServiceImpl implements RemittanceService{


    @Autowired
    AccountsRepository accountsRepository;

    public void remittance(RemittanceModel remittanceModel) {
        Accounts fromAccounts = accountsRepository.getByAccount(remittanceModel.getRemitter());
        Accounts toAccounts = accountsRepository.getByAccount(remittanceModel.getRecipient());
        fromAccounts.setAmount(fromAccounts.getAmount().subtract(remittanceModel.getAmount()));
        accountsRepository.save(fromAccounts);
        toAccounts.setAmount(toAccounts.getAmount().add(remittanceModel.getAmount()));
        accountsRepository.save(toAccounts);
    }

}
