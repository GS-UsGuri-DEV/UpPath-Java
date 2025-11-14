package br.com.fiap.bo;

import br.com.fiap.TO.Login;
import br.com.fiap.dao.LoginDAO;

public class LoginBO {
    public boolean autenticar(Login login) {

        if (login.getCpf() == null || login.getCpf().isEmpty()) {
            System.out.println("CPF não informado");
            return false;
        }

        if (login.getPassword() == null) {
            System.out.println("Data de nascimento não informada");
            return false;
        }
        LoginDAO dao = new LoginDAO();
        return dao.autenticar(login);
    }
}
