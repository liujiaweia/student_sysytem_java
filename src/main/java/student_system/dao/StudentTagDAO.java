package student_system.dao;

import org.apache.ibatis.annotations.Mapper;
import student_system.entity.StudentTag;

@Mapper
public interface StudentTagDAO extends BaseDAO<StudentTag,String> {
}
