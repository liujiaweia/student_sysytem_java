package student_system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import student_system.dao.GroupDAO;
import student_system.dao.StudentDAO;
import student_system.entity.Group;
import student_system.entity.Student;
import student_system.entity.Tag;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GroupSeriveImpl implements GroupService {

    @Resource
    private GroupDAO groupDAO;


    @Resource
    private StudentDAO studentDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Group> findAll() {
        List<Group> groups = groupDAO.findAll();
        groups.forEach(group -> {
            Map<String,Integer> result = new HashMap<>();
            List<Student> students=studentDAO.findByGroupId(group.getId());
            students.forEach(student ->{
                List<Tag> tags = student.getTags();
                tags.forEach(tag->{
                    if(result.containsKey(tag.getName())){
                        result.put(tag.getName(),result.get(tag.getName())+1);
                    }else{
                        result.put(tag.getName(),1);
                    }
                });
            });
            result.forEach((k,v)->{
                if(students.size()==v){
                    group.getTags().add(k);
                }
            });
        });
        return groupDAO.findAll();
    }

    @Override
    public void save(Group group) {
        groupDAO.save(group);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Group> findByClazzId(String id) {
        return groupDAO.findByClazzId(id);
    }
}
