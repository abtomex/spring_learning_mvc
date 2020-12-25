package ru.specialist.DAO.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.specialist.DAO.base.BaseServiceImpl;
import ru.specialist.DAO.course.Course;

@Repository
@Transactional
@Service("teacherService")
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherRepository getRepository() {
        return teacherRepository;
    }
}