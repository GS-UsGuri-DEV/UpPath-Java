package br.com.fiap.bo;

import br.com.fiap.TO.Empresa;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.utils.IdGenerator;

import java.util.ArrayList;

public class EmpresaBO {
    private EmpresaDAO empresaDAO;

    public ArrayList<Empresa> findAll() {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.findAll();
    }

    public Empresa findById(Long id) {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.findById(id);
    }

    public Empresa save(Empresa empresa) {
        empresaDAO = new EmpresaDAO();
        long id = IdGenerator.generate("EMPRESAS", "id_empresa");
        empresa.setIdEmpresa(id);
        return empresaDAO.save(empresa);
    }
    public boolean delete(Long id) {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.delete(id);
    }

    public Empresa update(Empresa empresa) {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.update(empresa);
    }
}
