package student_system.service;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import student_system.dao.UserDAO;
import student_system.entity.User;

import javax.annotation.Resource;
import java.util.Date;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        User userDB = userDAO.findByName(user.getName());
        if(userDB != null)
        {
           throw new RuntimeException("该用户名已存在，请修改");
        }
        user.setRegtime(new Date());
        user.setStatus("激活");
        userDAO.save(user);

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userDB = userDAO.findByName(user.getName());
        if(userDB!=null){
            if(StringUtils.equals(userDB.getPassword(),user.getPassword()));
            return userDB;
        }
        throw new RuntimeException("用户名字或密码错误");
    }
}
