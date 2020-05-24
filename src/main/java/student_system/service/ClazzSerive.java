package student_system.service;

import student_system.entity.Clazz;

import java.util.List;

public interface ClazzSerive {
    List<Clazz> findAll();

    void save(Clazz clazz);
}
