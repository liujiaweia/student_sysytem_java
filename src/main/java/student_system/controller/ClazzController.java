package student_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import student_system.entity.Clazz;
import student_system.service.ClazzSerive;

import java.util.List;

@Controller
@RequestMapping("clazz")
public class ClazzController {

    @Autowired
    private ClazzSerive clazzSerive;

    @RequestMapping("findAll")
    public String findAll(Model model){
       List<Clazz> clazzes = clazzSerive.findAll();
       model.addAttribute("clazzs",clazzes);
       return "back/clazz/index";
    }

    @RequestMapping("save")
    public String Save(Clazz clazz){
        clazzSerive.save(clazz);
        return "redirect:/clazz/findAll";

    }
    @RequestMapping("findAllClazzJSON")
    @ResponseBody
    public List<Clazz> findAllClazzJSON(){
        return clazzSerive.findAll();
    }

}
