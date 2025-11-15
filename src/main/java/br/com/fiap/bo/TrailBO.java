package br.com.fiap.bo;

import br.com.fiap.TO.Trail;
import br.com.fiap.dao.TrailDAO;
import br.com.fiap.utils.IdGenerator;

import java.util.ArrayList;

public class TrailBO {
    private TrailDAO trailDAO;

    public ArrayList<Trail> findAll() {
        trailDAO = new TrailDAO();
        return trailDAO.findAll();
    }

    public Trail findById(Long id) {
        trailDAO = new TrailDAO();
        return trailDAO.findById(id);
    }
    public Trail save(Trail trail) {
        trailDAO = new TrailDAO();
        Long id = IdGenerator.generate("trilhas", "id_trilha");
        trail.setIdTrial(id);
        return trailDAO.save(trail);
    }
    public boolean delete(Long id) {
        trailDAO = new TrailDAO();
        return trailDAO.delete(id);
    }
    public Trail update(Trail trail) {
        trailDAO = new TrailDAO();
        return trailDAO.update(trail);
    }
}
