package student_system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import student_system.dao.TagDAO;
import student_system.entity.Tag;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService{

    @Resource
    private TagDAO tagDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Tag> findAll() {
        return tagDAO.findAll();
    }

    @Override
    public void save(Tag tag) {
        tag.setCreatetime(new Date());
        tagDAO.save(tag);
    }

    @Override
    public List<Tag> findByType(String type) {
        return tagDAO.findByType(type);
    }
}
