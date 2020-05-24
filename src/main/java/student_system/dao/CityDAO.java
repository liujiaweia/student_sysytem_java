package student_system.dao;

import org.apache.ibatis.annotations.Mapper;
import student_system.entity.City;

@Mapper
public interface CityDAO extends BaseDAO<City,String>{

}
