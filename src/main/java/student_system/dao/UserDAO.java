package student_system.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import student_system.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDAO {
    void save(User user);
    User findByName(String name);
}
