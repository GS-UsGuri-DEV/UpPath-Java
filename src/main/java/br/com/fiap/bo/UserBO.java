package br.com.fiap.bo;

import br.com.fiap.TO.User;
import br.com.fiap.dao.UserDAO;
import br.com.fiap.utils.Password;
import br.com.fiap.utils.IdGenerator;

import java.util.ArrayList;

public class UserBO {
    UserDAO userDAO;
    String hashed;

    public ArrayList<User> findAll() {
        userDAO = new UserDAO();
        return userDAO.findAll();
    }
    public User findById(Long id) {
        userDAO = new UserDAO();
        return userDAO.findById(id);
    }
    public User save(User user) {
        userDAO = new UserDAO();

        hashed = Password.valid(user.getPassword());
        if (hashed == null) return null;

        Long id = IdGenerator.generate("usuarios", "id_usuario");
        user.setIdUser(id);
        return userDAO.save(user);
    }
    public boolean delete(Long id) {
        userDAO = new UserDAO();
        return userDAO.delete(id);
    }
    public User update(User user) {
        userDAO = new UserDAO();

        hashed = Password.valid(user.getPassword());
        if (hashed == null) return null;

        return userDAO.update(user);
    }
}
