package student_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import student_system.dao.CityDAO;
import student_system.entity.City;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Resource
    private CityDAO cityDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    public void save(City city) {
        //处理下时间
        city.setCreatetime(new Date());
        city.setNumbers(0);
        cityDAO.save(city);
    }
}
