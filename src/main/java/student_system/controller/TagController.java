package student_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import student_system.entity.Tag;
import student_system.service.TagService;

import java.util.List;

@Controller
@RequestMapping("tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("findAll")
    public String findAll(Model model) {
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags",tags);
        return "back/tag/index";
    }

    @RequestMapping("save")
    public String save(Tag tag){
        tagService.save(tag);
        return "redirect:/tag/findAll";

    }

    @RequestMapping("findByType")
    @ResponseBody
    public List<Tag> findByType(String type){
        return tagService.findByType(type);

    }
}
