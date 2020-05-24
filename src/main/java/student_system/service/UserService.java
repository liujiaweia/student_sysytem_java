package student_system.service;
import student_system.entity.User;


public interface UserService {

    void register(User user);
    User login(User user);
}
