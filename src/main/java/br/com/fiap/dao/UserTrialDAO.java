package br.com.fiap.dao;

import br.com.fiap.TO.UserTrial;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserTrialDAO {

    public ArrayList<UserTrial> findAll() {
        ArrayList<UserTrial> list = new ArrayList<>();
        String sql = "SELECT * FROM usuario_trilha ORDER BY id_usuario";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    UserTrial userTrial = new UserTrial();
                    userTrial.setIdUser(rs.getLong("id_usuario"));
                    userTrial.setIdTrial(rs.getLong("id_trilha"));
                    userTrial.setStartDate(rs.getTimestamp("data_inicio").toLocalDateTime().toLocalDate());
                    userTrial.setProgressPercentage(rs.getInt("progresso_percentual"));
                    userTrial.setStatus(rs.getString("status"));
                    list.add(userTrial);
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

    public UserTrial findById(long idUser, long idTrial) {
        UserTrial userTrial = new UserTrial();
        String sql = "SELECT * FROM usuario_trilha WHERE id_usuario = ? AND id_trilha = ?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUser);
            ps.setLong(2, idTrial);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userTrial.setIdUser(rs.getLong("id_usuario"));
                userTrial.setIdTrial(rs.getLong("id_trilha"));
                userTrial.setStartDate(rs.getTimestamp("data_inicio").toLocalDateTime().toLocalDate());
                userTrial.setProgressPercentage(rs.getInt("progresso_percentual"));
                userTrial.setStatus(rs.getString("status"));
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return userTrial;
    }

    public UserTrial save(UserTrial userTrial) {
        String sql = "INSERT INTO usuario_trilha (id_usuario, id_trilha, progresso_percentual, status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, userTrial.getIdUser());
            ps.setLong(2, userTrial.getIdTrial());
            ps.setInt(3, userTrial.getProgressPercentage());
            ps.setString(4, userTrial.getStatus());

            if (ps.executeUpdate() > 0) {
                return userTrial;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return null;
    }

    public Boolean delete(long idUser, long idTrial) {
        String sql = "DELETE FROM usuario_trilha WHERE id_usuario = ? AND id_trilha = ?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUser);
            ps.setLong(2, idTrial);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return false;
    }

    public UserTrial update(UserTrial userTrial) {
        String sql = "UPDATE usuario_trilha SET progresso_percentual = ?, status = ? WHERE id_usuario = ? AND id_trilha = ?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1, userTrial.getProgressPercentage());
            ps.setString(2, userTrial.getStatus());
            ps.setLong(3, userTrial.getIdUser());
            ps.setLong(4, userTrial.getIdTrial());

            if (ps.executeUpdate() > 0) {
                return userTrial;
            } else {
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
