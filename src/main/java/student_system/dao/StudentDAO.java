package student_system.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import student_system.entity.Student;

import java.util.List;

@Mapper
public interface StudentDAO extends BaseDAO<Student,String> {
    List<Student> find(@Param("col") String searchCol,@Param("val") String searchValue);

    List<Student> findByLikePage(@Param("start") Integer start,@Param("rows") Integer rows, @Param("col") String searchCol,@Param("val") String searchValue);

    Integer totalCounts(@Param("col") String searchCol,@Param("val") String searchValue);

    List<Student> findByGroupId(String id);
}
