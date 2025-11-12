package br.com.fiap.dao;

import br.com.fiap.TO.WellBeing;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WellBeingDAO {
    public ArrayList<WellBeing> findAll() {
        ArrayList <WellBeing> list = new ArrayList<>();
        String sql = "SELECT * FROM bem_estar ORDER BY id_registro";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (ps != null) {
                while (rs.next()) {
                   WellBeing wb = new WellBeing();
                   wb.setIdWellBeing(rs.getLong("id_registro"));
                   wb.setIdUser(rs.getLong("id_usuario"));
                   wb.setDateRecorded(rs.getDate("DATE_registro").toLocalDate());
                   wb.setStressLevel(rs.getInt("nivel_estresse"));
                   wb.setMotivationLevel(rs.getInt("nivel_motivacao"));
                   wb.setSleepQuality(rs.getInt("qualidade_sono"));
                   wb.setObservations(rs.getString("observacao"));
                   list.add(wb);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return list;
    }

    public WellBeing findById(long id) {
        WellBeing wb = new WellBeing();
        String sql = "SELECT * FROM bem_estar WHERE id_registro = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                wb.setIdWellBeing(rs.getLong("id_registro"));
                wb.setIdUser(rs.getLong("id_usuario"));
                wb.setDateRecorded(rs.getDate("DATE_registro").toLocalDate());
                wb.setStressLevel(rs.getInt("nivel_estresse"));
                wb.setMotivationLevel(rs.getInt("nivel_motivacao"));
                wb.setSleepQuality(rs.getInt("qualidade_sono"));
                wb.setObservations(rs.getString("observacao"));
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return wb;
    }

    public WellBeing save(WellBeing wb) {
        String sql = "INSERT INTO bem_estar (id_usuario, DATE_registro, nivel_estresse, nivel_motivacao, qualidade_sono, observacao) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, wb.getIdUser());
            ps.setDate(2, Date.valueOf(wb.getDateRecorded()));
            ps.setInt(3, wb.getStressLevel());
            ps.setInt(4, wb.getMotivationLevel());
            ps.setInt(5, wb.getSleepQuality());
            ps.setString(6, wb.getObservations());

            if (ps.executeUpdate() > 0) {
                return wb;
            }else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(long id) {
        String sql = "DELETE FROM bem_estar WHERE id_registro = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public WellBeing update(WellBeing wb) {
        String sql = "UPDATE bem_estar SET id_usuario = ?, DATE_registro = ?, nivel_estresse = ?, nivel_motivacao = ?, qualidade_sono = ?, observacao = ? WHERE id_registro = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, wb.getIdUser());
            ps.setDate(2, Date.valueOf(wb.getDateRecorded()));
            ps.setInt(3, wb.getStressLevel());
            ps.setInt(4, wb.getMotivationLevel());
            ps.setInt(5, wb.getSleepQuality());
            ps.setString(6, wb.getObservations());
            ps.setLong(7, wb.getIdWellBeing());

            if (ps.executeUpdate() > 0) {
                return wb;
            }else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
