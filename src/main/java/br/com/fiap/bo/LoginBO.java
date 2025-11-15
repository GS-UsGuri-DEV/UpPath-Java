package br.com.fiap.bo;

import br.com.fiap.TO.Login;
import br.com.fiap.dao.LoginDAO;

public class LoginBO {

    public boolean autenticar(Login login) {

        if (!isValid(login)) {
            return false;
        }
        return new LoginDAO().autenticar(login);
    }
    private boolean isValid(Login login) {

        if (login == null) {
            return false;
        }

        if (isBlank(login.getEmail()) || isBlank(login.getPassword())) {
            return false;
        }
        return Login.validaSenha(login.getPassword());
    }
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
