package br.com.fiap.bo;

import br.com.fiap.TO.Courses;
import br.com.fiap.dao.CoursesDAO;
import br.com.fiap.service.IdGenerator;

import java.util.ArrayList;

public class CoursesBO {
    private CoursesDAO coursesDAO;

    public ArrayList<Courses> findAll() {
        coursesDAO = new CoursesDAO();
        return coursesDAO.findAll();
    }

    public Courses findById(Long id) {
        coursesDAO = new CoursesDAO();
        return coursesDAO.findById(id);
    }

    public Courses save(Courses courses) {
        coursesDAO = new CoursesDAO();
        long id = IdGenerator.generate("CURSOS", "id_curso");
        courses.setIdCourse(id);
        return coursesDAO.save(courses);
    }

    public boolean delete(Long id) {
        coursesDAO = new CoursesDAO();
        return coursesDAO.delete(id);
    }

    public Courses update(Courses courses) {
        coursesDAO = new CoursesDAO();
        return coursesDAO.update(courses);
    }
}
