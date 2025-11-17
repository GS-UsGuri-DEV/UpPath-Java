package br.com.fiap.dao;

import br.com.fiap.TO.Login;
import br.com.fiap.utils.Password;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public boolean autenticar(Login login) {

        String sql = "SELECT 1 FROM usuario WHERE email = ? AND senha_hash = ?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {

            ps.setString(1, login.getEmail());
            ps.setString(2, Password.valid(login.getPassword()));

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
            return false;
        }
    }
}
