package student_system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import student_system.dao.CityDAO;
import student_system.dao.StudentDAO;
import student_system.dao.StudentTagDAO;
import student_system.entity.City;
import student_system.entity.Student;
import student_system.entity.StudentTag;
import student_system.utils.DateUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class StudentSeriveImpl implements StudentService {

    @Resource
    private StudentDAO studentDAO;

    @Resource
    private StudentTagDAO studentTagDAO;

    @Resource
    private CityDAO cityDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findAll(String searchCol, String searchValue) {
        return studentDAO.find(searchCol, searchValue);
    }

    @Override
    public List<Student> findAll(Integer pageNow, Integer rows, String searchCol, String searchValue) {
        int start = (pageNow - 1) * rows;
        return studentDAO.findByLikePage(start, rows, searchCol, searchValue);
    }

    @Override
    public Integer totalCounts(String searchCol, String searchValue) {
        return studentDAO.totalCounts(searchCol, searchValue);
    }

    @Override
    public void save(Student student, String[] tagIds) {
        int age = DateUtil.getAge(student.getBir());
        student.setAge(age);
        //计算生肖和星座
        String attr = DateUtil.getYear(Integer.valueOf(new SimpleDateFormat("yyyy").format(student.getBir())));
        student.setAttr(attr);
        String starts = DateUtil.getConstellation(student.getBir());
        student.setStarts(starts);
        studentDAO.save(student);
        for (String tagId : tagIds) {
            StudentTag studentTag = new StudentTag();
            studentTag.setStudentid(student.getId());
            studentTag.setTagid(tagId);
            studentTagDAO.save(studentTag);
        }

        City city = cityDAO.findById(student.getCityid());
        city.setNumbers(city.getNumbers()+1);
        cityDAO.update(city);
    }

}
