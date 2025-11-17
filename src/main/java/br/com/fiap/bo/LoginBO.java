package br.com.fiap.bo;

import br.com.fiap.TO.Login;
import br.com.fiap.dao.LoginDAO;
import br.com.fiap.utils.Password;

public class LoginBO {

    public boolean autenticar(Login login) {

        String hash = Password.valid(login.getPassword());

        if (hash == null) {
            return false;
        }
        login.setPassword(hash);

        return new LoginDAO().autenticar(login);
    }
}
