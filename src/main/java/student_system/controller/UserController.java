package student_system.controller;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import student_system.entity.User;
import student_system.result.Result;
import student_system.service.UserService;
import student_system.utils.VerifyCodeUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/back/login.jsp";
    }

    @RequestMapping("login")
    @ResponseBody
    public Result login(User user,String code,HttpSession session){
        Result result = new Result();
        String Imgcode = (String) session.getAttribute("code");
        try{
            if(StringUtils.equals(Imgcode,code)){
                User userDB = userService.login(user);
                session.setAttribute("user",userDB);
                return result.setMag("登陆成功").setStatus(true);
            }
            throw new RuntimeException("验证码错误");
        }catch (Exception e){
            e.printStackTrace();
            result.setMag("登录失败"+e.getMessage());
        }

        return result;
    }


    @RequestMapping("register")
    @ResponseBody
    public Result register(User user,String code,HttpSession session){
        Result result = new Result();
        try{
            String Imgcode = (String) session.getAttribute("code");
            if(Imgcode.equalsIgnoreCase(code))
            {
                userService.register(user);
                return result.setMag("注册成功").setStatus(true);
            }
            throw new RuntimeException("注册失败：验证码输入错误");
        }catch (Exception e){
            e.printStackTrace();
            result.setMag("注册失败"+e.getMessage()).setStatus(false);
        }
        return result;
    }

    @RequestMapping("getImage")
    private void getImage(HttpSession session, HttpServletResponse response)throws IOException {
        //随机数 数字放入sesson 生成图片
        String code = VerifyCodeUtils.generateVerifyCode( 4);
        session.setAttribute("code",code);
        VerifyCodeUtils.outputImage(220,60,response.getOutputStream(),code);

    }

}
