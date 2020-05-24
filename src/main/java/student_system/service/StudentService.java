package student_system.service;

import student_system.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    List<Student> findAll(String searchCol, String searchValue);

    List<Student> findAll(Integer pageNow, Integer rows, String searchCol, String searchValue);

    Integer totalCounts(String searchCol, String searchValue);
    void save(Student student,String[] tagIds);
}
