package com.example.demo2.controller;

import com.example.demo2.entity.Accounts;
import com.example.demo2.model.RemittanceModel;
import com.example.demo2.repository.AccountsRepository;
import com.example.demo2.service.AccountsService;
import com.example.demo2.service.RemittanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class RemittanceManager {

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    AccountsService accountsService;

    @Autowired
    RemittanceService remittanceService;

    @GetMapping("/remittance")
    public String remittance(Model model){
        Accounts accounts = accountsRepository.getOne(1);
        RemittanceModel remittanceModel = new RemittanceModel();
        model.addAttribute("remittanceModel", remittanceModel);
        return "remittance";
    }

    @PostMapping("/remittance")
    public ModelAndView remittance(@Valid @ModelAttribute RemittanceModel remittanceModel,
                                   BindingResult bindingResult,
                                   ModelAndView modelAndView) {
        List<String> messages = new ArrayList<>();
        Accounts fromAccounts = accountsRepository.getByAccount(remittanceModel.getRemitter());
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else if (!accountsService.isExist(remittanceModel.getRemitter())) {
        messages.add("Отправителя с таким счетом не существует!");
        if (!accountsService.isExist(remittanceModel.getRecipient())){
            messages.add("Получателя с таким счетом не существует!");
        }
        } else if(remittanceModel.getAmount().compareTo(fromAccounts.getAmount())>0){
            messages.add("Недостаточно средств!");
        } else {
        remittanceService.remittance(remittanceModel);
        messages.add("Перевод выполнен успешно!");
    }
        modelAndView.setViewName("remittance");
        modelAndView.addObject("messages", messages);
        return modelAndView;
    }
}
