package student_system.service;

import student_system.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();
    void save(Tag tag);

    List<Tag> findByType(String type);
}
