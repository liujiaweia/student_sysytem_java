package student_system.dao;

import org.apache.ibatis.annotations.Mapper;
import student_system.entity.Tag;

import java.util.List;

@Mapper
public interface TagDAO extends BaseDAO<Tag,String> {
    List<Tag> findByType(String type);
}
