package student_system.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import student_system.dao.ClazzDAO;
import student_system.entity.Clazz;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ClazzSeroveImpl implements ClazzSerive{

    @Resource
    private ClazzDAO clazzDAO;


    @Override
    public List<Clazz> findAll() {
        return clazzDAO.findAll();
    }

    @Override
    public void save(Clazz clazz) {
        clazzDAO.save(clazz);
    }
}
