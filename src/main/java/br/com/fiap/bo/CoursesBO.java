package br.com.fiap.bo;

import br.com.fiap.TO.Courses;
import br.com.fiap.dao.CoursesDAO;

import java.util.ArrayList;

public class CoursesBO {
    private CoursesDAO coursesDAO;

    public ArrayList<Courses> find() {
        coursesDAO = new CoursesDAO();
        return coursesDAO.findAll();
    }

    public Courses findById(Long id) {
        coursesDAO = new CoursesDAO();
        return coursesDAO.findById(id);
    }

    public Courses save(Courses courses) {
        coursesDAO = new CoursesDAO();
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
