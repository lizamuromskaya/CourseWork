package com.comp.store.controller;

import com.comp.store.dto.BuyerDto;
import com.comp.store.service.BuyerService;
import com.comp.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired
    private UserService service;

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public String register(Model model){
        BuyerDto dto = new BuyerDto();
        model.addAttribute("usr", dto);
        return "main/registration";
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute BuyerDto dto, BindingResult errors, Model model) throws Exception {
        dto.setRoleName("ROLE_BUYER");
        if(service.getByUserName(dto.getUserName()) == null){
            buyerService.add(dto);
        }
        return "redirect:/login";
    }
}
