package br.com.fiap.bo;

import br.com.fiap.TO.Login;
import br.com.fiap.dao.LoginDAO;
import br.com.fiap.utils.Password;

public class LoginBO {

    public boolean autenticar(Login login) {
        if (Password.valid(login.getPassword()) == null) {
            return false;
        }

        return new LoginDAO().autenticar(login);
    }

}
