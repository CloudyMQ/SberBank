package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferManager {

    @Autowired
    RemittanceRepository remittanceRepository;

    @RequestMapping(value="/remittance", method=RequestMethod.GET)
    public String remittanceForm(Model model){
        Accounts accounts = remittanceRepository.getOne(1);
        return "remittance";
    }

//    @RequestMapping(value="/remittance", method=RequestMethod.POST)
//    public String remittanceSubmit(@ModelAttribute Remittance remittance, Model model){
//        model.addAttribute("remittance", remittance);
//        return "remittance";
//    }

}
