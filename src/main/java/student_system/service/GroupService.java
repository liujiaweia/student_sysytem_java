package student_system.service;

import student_system.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    void save(Group group);

    List<Group> findByClazzId(String id);
}
