package student_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import student_system.entity.Student;
import student_system.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @RequestMapping("findAll")
    public String findAll(Integer pageNow,Integer rows,String searchCol,String searchValue,Model model){
        pageNow = pageNow==null?1:pageNow;
        rows = rows==null?4:rows;

        List<Student> students = studentService.findAll(pageNow,rows,searchCol,searchValue);

        Integer counts = studentService.totalCounts(searchCol,searchValue);
        //计算总也数
        int totalPage = counts%rows==0?counts/rows:counts/rows+1;


        model.addAttribute("totalPage",totalPage);
        model.addAttribute("pageNow",pageNow);

        model.addAttribute("students",students);
        model.addAttribute("searchValue",searchValue);
        model.addAttribute("searchCol",searchCol);
        return "back/student/index";
    }

    @RequestMapping("save")
    public String save(Student student,String[] tagIds){
        studentService.save(student,tagIds);
        return "redirect:/student/findAll";
    }
}
