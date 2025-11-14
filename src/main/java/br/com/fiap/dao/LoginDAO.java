package br.com.fiap.dao;

import br.com.fiap.TO.Login;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public boolean autenticar(Login login){
        String sql = "SELECT * FROM USER_ACCOUNT WHERE CPF_USER = ? AND BIRTH_DATE = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, login.getCpf());
            ps.setDate(2, Date.valueOf(login.getPassword()));
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection();
        }
    }
}
