package student_system.dao;

import org.apache.ibatis.annotations.Mapper;
import student_system.entity.Clazz;

@Mapper
public interface ClazzDAO extends BaseDAO<Clazz,String>{
}
