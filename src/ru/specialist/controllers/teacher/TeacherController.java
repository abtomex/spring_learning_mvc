package ru.specialist.controllers.teacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.specialist.DAO.teacher.Teacher;
import ru.specialist.DAO.teacher.TeacherService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teachers/")
public class TeacherController {
    private final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    private TeacherService teacherService;
    private MessageSource messageSource;

    @Autowired
    public void setContactService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing teachers");
        List<Teacher> teachers = teacherService.findAll();
        uiModel.addAttribute ("teachers", teachers);
        logger.info("No. of teachers: " + teachers.size());
        return "teachers/list";
    }

    //@PreAuthorize("isAuthenticated()")
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, Model uiModel) {
        if (teacherService.findById(id)!=null)
            teacherService.delete(id);
        logger.info("Delete teacher: " + id);
        return "redirect:/teachers/";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") int id, Model uiModel) {
        uiModel.addAttribute ("teacher", teacherService.findById(id));
        return "teachers/edit";
    }
    @RequestMapping(value = "update/0",method = RequestMethod.GET)
    public String newForm( Model uiModel) {
        return "teachers/edit";
    }

    //@PreAuthorize("isAuthenticated()")
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(Teacher teacher, BindingResult bindingResult,
                         Model uiModel, HttpServletRequest httpServletRequest,
                         RedirectAttributes redirectAttributes) {
        logger.info("Updating contact");
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("teacher", teacher);
            return "teachers/update";
        }
        teacherService.save(teacher);
        return "redirect:/teachers/";
    }






}
