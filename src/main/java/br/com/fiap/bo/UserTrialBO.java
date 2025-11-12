package br.com.fiap.bo;

import br.com.fiap.TO.UserTrial;
import br.com.fiap.dao.UserTrialDAO;

import java.util.ArrayList;

public class UserTrialBO {
    UserTrialDAO userDAO;

    public ArrayList<UserTrial> findAll() {
        userDAO = new UserTrialDAO();
        return userDAO.findAll();
    }

    public UserTrial findById(Long id) {
        userDAO = new UserTrialDAO();
        return userDAO.findById(id);
    }

    public UserTrial save(UserTrial userTrial) {
        userDAO = new UserTrialDAO();
        return userDAO.save(userTrial);
    }

    public Boolean delete(Long id) {
        userDAO = new UserTrialDAO();
        return userDAO.delete(id);
    }
     public UserTrial update(UserTrial userTrial) {
        userDAO = new UserTrialDAO();
        return userDAO.update(userTrial);
     }
}
