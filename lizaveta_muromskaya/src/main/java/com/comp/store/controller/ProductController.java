package com.comp.store.controller;

import com.comp.store.dto.ProductDto;
import com.comp.store.dto.ProductNameDto;
import com.comp.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/all")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value="/products", method = RequestMethod.GET)
    public String allProducts(Model model){
        List<ProductDto> products = productService.allProducts();
        model.addAttribute("products", products);
        return "product/products";
    }

    @RequestMapping(value = "/findProduct", method = RequestMethod.GET)
    public String showProductsByName(@RequestParam (value = "search", required = false, defaultValue = "") String name, Model model) {
        List<ProductDto> products =  productService.getProductsByName(name);
        model.addAttribute("result", products);
        model.addAttribute("search", name);
        return "product/findProduct";
    }

}
