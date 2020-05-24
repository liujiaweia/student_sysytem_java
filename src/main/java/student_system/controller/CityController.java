package student_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import student_system.entity.City;
import student_system.service.CityService;

import java.util.List;

@Controller
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<City> cities = cityService.findAll();
        model.addAttribute("citys",cities);
        return "back/city/index";
    }

    @RequestMapping("save")
    public String save(City city){
        cityService.save(city);
        return "redirect:/city/findAll";

    }

    @RequestMapping("findAllJSON")
    @ResponseBody
    public List<City> findAllJSON(){
        return  cityService.findAll();

    }
}
