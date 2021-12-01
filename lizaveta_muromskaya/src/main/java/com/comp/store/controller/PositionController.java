package com.comp.store.controller;

import com.comp.store.dto.PositionDto;
import com.comp.store.dto.PositionNameDto;
import com.comp.store.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/all")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value="/positions", method = RequestMethod.GET)
    public String getAllPositions(Model model){
        List<PositionDto> positions = positionService.allPositions();
        model.addAttribute("positions", positions);
        return "position/positions";
    }

    @RequestMapping(value = "/findPosition", method = RequestMethod.GET)
    public String showPositionsByName(@RequestParam(value = "search", required = false, defaultValue = "") String name, Model model) {
        List<PositionDto> positions =  positionService.getPositionsByName(name);
        model.addAttribute("result", positions);
        model.addAttribute("search", name);
        return "position/findPosition";
    }
}
