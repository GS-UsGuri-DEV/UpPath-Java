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

    public UserTrial findById(Long idUser, Long idTrial) {
        userDAO = new UserTrialDAO();
        return userDAO.findById(idUser, idTrial);
    }

    public UserTrial save(UserTrial userTrial) {
        userDAO = new UserTrialDAO();
        return userDAO.save(userTrial);
    }

    public Boolean delete(Long idUser, Long idTrial) {
        userDAO = new UserTrialDAO();
        return userDAO.delete(idUser, idTrial);
    }

    public UserTrial update(UserTrial userTrial) {
        userDAO = new UserTrialDAO();
        return userDAO.update(userTrial);
    }
}
