package br.com.fiap.utils;

import br.com.fiap.dao.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IdGenerator {

    public static long generate(String table, String idColumn) {
        long id;
        do {
            id = (long)(Math.random() * 200L) + 1;
        } while (exists(table, idColumn, id));

        return id;
    }

    private static boolean exists(String table, String idColumn, long id) {
        String sql = "SELECT 1 FROM " + table + " WHERE " + idColumn + " = ?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (Exception e) {
            System.out.println("Erro ao verificar ID: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return false;
    }
}
