package com.comp.store.controller;

import com.comp.store.dto.BuyerDto;
import com.comp.store.dto.SellerDto;
import com.comp.store.service.BuyerService;
import com.comp.store.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value = "/blockBuyer", method = RequestMethod.GET)
    public String blockBuyer(@RequestParam(value = "id", required = false) Long id, Model model){
        if(id != null){
            BuyerDto dto = buyerService.getById(id);
            dto.setRoleName("ROLE_BLOCKED");
            buyerService.edit(dto);
        }
        List<BuyerDto> buyers = buyerService.allBuyers();
        model.addAttribute("buyers", buyers);
        return "admin/blockBuyer";
    }

    @RequestMapping(value = "/unblockBuyer", method = RequestMethod.GET)
    public String unblockBuyer(@RequestParam(value = "id", required = false) Long id, Model model){
        if(id != null){
            BuyerDto dto = buyerService.getById(id);
            dto.setRoleName("ROLE_BUYER");
            buyerService.edit(dto);
        }
        List<BuyerDto> buyers = buyerService.allBuyers();
        model.addAttribute("buyers", buyers);
        return "admin/blockBuyer";
    }

    @RequestMapping(value = "/blockSeller", method = RequestMethod.GET)
    public String blockSeller(@RequestParam(value = "id", required = false) Long id, Model model){
        if(id != null){
            SellerDto dto = sellerService.getById(id);
            dto.setRoleName("ROLE_BLOCKED");
            sellerService.edit(dto);
        }
        List<SellerDto> sellers = sellerService.allSellers();
        model.addAttribute("sellers", sellers);
        return "admin/blockSeller";
    }

    @RequestMapping(value = "/unblockSeller", method = RequestMethod.GET)
    public String unblockSeller(@RequestParam(value = "id", required = false) Long id, Model model){
        if(id != null){
            SellerDto dto = sellerService.getById(id);
            dto.setRoleName("ROLE_SELLER");
            sellerService.edit(dto);
        }
        List<SellerDto> sellers = sellerService.allSellers();
        model.addAttribute("sellers", sellers);
        return "admin/blockSeller";
    }
}
