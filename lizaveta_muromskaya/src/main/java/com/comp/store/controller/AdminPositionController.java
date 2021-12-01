package com.comp.store.controller;

import com.comp.store.dto.PositionDto;
import com.comp.store.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/addPosition", method = RequestMethod.GET)
    public String addPosition(Model model) {
        PositionDto dto = new PositionDto();
        model.addAttribute("position", dto);
        return "admin/addPosition";
    }

    @RequestMapping(value = "/addPosition", method = RequestMethod.POST)
    public String addPosition(@ModelAttribute PositionDto dto, BindingResult errors, Model model) throws Exception {
        positionService.add(dto);
        return "redirect:/all/positions";
    }

    @RequestMapping(value = "/editPosition", method = RequestMethod.GET)
    public String editPosition(@RequestParam(value = "id", required = true) Long id, Model model) {
        PositionDto dto = positionService.getById(id);
        model.addAttribute("position", dto);
        return "admin/editPosition";
    }

    @RequestMapping(value = "/editPosition", method = RequestMethod.POST)
    public String editPosition(@ModelAttribute PositionDto dto, BindingResult errors, Model model) throws Exception {
        positionService.edit(dto);
        return "redirect:/all/positions";
    }

    @RequestMapping(value = "/deletePosition", method = RequestMethod.GET)
    public String deletePosition(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id != null) {
            PositionDto dto = positionService.getById(id);
            positionService.delete(dto);
        }
        List<PositionDto> positions = positionService.allPositions();
        model.addAttribute("positions", positions);
        return "admin/deletePosition";
    }

    @RequestMapping(value="positionschart", method = RequestMethod.GET)
    public String chart(Model model){
        ArrayList<Long> list = new ArrayList<Long>();
        Long[] arr = new Long[]{
            positionService.getCountBySalary(0l, 500l),
            positionService.getCountBySalary(501l, 1000l),
            positionService.getCountBySalary(1001l, 2000l),
            positionService.getCountBySalary(2001l, 500000000l)
        };
        model.addAttribute("arr", arr);
        return "chart/positionschart";
    }


}
