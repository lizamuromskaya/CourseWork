package com.comp.store.controller;

import com.comp.store.dto.*;
import com.comp.store.service.ActService;
import com.comp.store.service.BuyerService;
import com.comp.store.service.ProductService;
import com.comp.store.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/seller")
public class ActController {

    @Autowired
    private ActService actService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value="/acts", method = RequestMethod.GET)
    public String getAllActs(Model model){
        List<ActViewDto> acts = actService.allActsView();
        model.addAttribute("acts", acts);
        return "act/acts";
    }

    @RequestMapping(value = "/findAct", method = RequestMethod.GET)
    public String showActsByName(@RequestParam(value = "search", required = false, defaultValue = "") String name, Model model) {
        List<ActViewDto> acts =  actService.getActsByParam(name);
        List<ProductDto> products = productService.allProducts();
        List<SellerDto> sellers = sellerService.allSellers();
        List<BuyerDto> buyers = buyerService.allBuyers();
        model.addAttribute("sellers", sellers);
        model.addAttribute("products", products);
        model.addAttribute("buyers", buyers);
        model.addAttribute("result", acts);
        model.addAttribute("search", name);
        return "act/findAct";
    }

    @RequestMapping(value="/addAct", method = RequestMethod.GET)
    public String addAct(Model model){
        ActDto act = new ActDto();
        List<ProductDto> products = productService.allProducts();
        List<SellerDto> sellers = sellerService.allSellers();
        List<BuyerDto> buyers = buyerService.allBuyers();
        model.addAttribute("sellers", sellers);
        model.addAttribute("products", products);
        model.addAttribute("buyers", buyers);
        model.addAttribute("act", act);
        return "act/addAct";
    }

    @RequestMapping(value="/addAct", method = RequestMethod.POST)
    public String addAct(@ModelAttribute ActDto dto, BindingResult errors, Model model) throws Exception {
        actService.add(dto);
        return "redirect:/seller/acts";
    }

    @RequestMapping(value = "/editAct", method = RequestMethod.GET)
    public String editAct(@RequestParam(value = "id", required = true) Long id, Model model) {
        ActViewDto dtoView = actService.getViewById(id);
        ActDto dto = actService.getById(id);
        List<ProductDto> products = productService.allProducts();
        List<SellerDto> sellers = sellerService.allSellers();
        List<BuyerDto> buyers = buyerService.allBuyers();
        model.addAttribute("sellers", sellers);
        model.addAttribute("products", products);
        model.addAttribute("buyers", buyers);
        model.addAttribute("act", dto);
        model.addAttribute("actView", dtoView);
        return "act/editAct";
    }

    @RequestMapping(value = "/deleteAct", method = RequestMethod.GET)
    public String deleteAct(@RequestParam (value = "id", required = false) Long id,  Model model) throws Exception {
        if(id != null){
            ActDto dto = actService.getById(id);
            actService.delete(dto);
        }
        List<ActViewDto> acts = actService.allActsView();
        model.addAttribute("acts", acts);
        return "act/deleteAct";
    }

    @RequestMapping(value="/editAct", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute ActDto dto, BindingResult errors, Model model) throws Exception {
        actService.edit(dto);
        return "redirect:/seller/acts";
    }

    @RequestMapping(value = "/saveFile", method = RequestMethod.GET)
    public String saveFile(@RequestParam (value = "id", required = true) Long id, Model model){
        if(id != null){
            ActDto dto = actService.getById(id);

        }
        return "fdsfd";
    }

}
