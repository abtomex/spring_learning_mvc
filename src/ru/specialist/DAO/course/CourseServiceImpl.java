package ru.specialist.DAO.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.specialist.DAO.base.BaseServiceImpl;

@Repository
@Transactional
@Service("courseService")
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService {


    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseRepository getRepository() {
        return courseRepository;
    }
}