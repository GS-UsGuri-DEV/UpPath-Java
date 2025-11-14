package br.com.fiap.bo;

import br.com.fiap.TO.WellBeing;
import br.com.fiap.dao.WellBeingDAO;
import br.com.fiap.service.IdGenerator;

import java.util.ArrayList;

public class WellBeingBO {
    private WellBeingDAO wBdao;

    public ArrayList<WellBeing> findAll() {
        wBdao = new WellBeingDAO();
        return wBdao.findAll();
    }

    public WellBeing findById(long id) {
        wBdao = new WellBeingDAO();
        return wBdao.findById(id);
    }

    public WellBeing save(WellBeing wB) {
        wBdao = new WellBeingDAO();
        Long id = IdGenerator.generate("BEM_estar", "id_registro");
        wB.setIdWellBeing(id);
        return wBdao.save(wB);
    }

    public boolean delete(long id) {
        wBdao = new WellBeingDAO();
        return wBdao.delete(id);
    }
    public WellBeing update(WellBeing wB) {
        wBdao = new WellBeingDAO();
        return wBdao.update(wB);
    }
}
