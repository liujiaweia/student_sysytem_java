package student_system.dao;

import org.apache.ibatis.annotations.Mapper;
import student_system.entity.Group;

import java.util.List;

@Mapper
public interface GroupDAO extends BaseDAO<Group,String> {
    List<Group> findByClazzId(String id);
}
