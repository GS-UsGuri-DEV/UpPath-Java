package br.com.fiap.dao;

import br.com.fiap.TO.Trail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TrailDAO {
    public ArrayList<Trail> findAll() {;
        ArrayList<Trail> list = new ArrayList<>();
        String sql = "SELECT * FROM Trilhas ORDER BY id_trilha";
        try (PreparedStatement ps= ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (ps != null) {
                while (rs.next()) {
                    Trail trail = new Trail();
                    trail.setIdTrial(rs.getLong("id_trilha"));
                    trail.setTitle(rs.getString("nome_trilha"));
                    trail.setDescription(rs.getString("descricao"));
                    trail.setCategory(rs.getString("categoria"));
                    trail.setDifficultyLevel(rs.getString("nivel_dificuldade"));
                    trail.setCreationDate(rs.getDate("data_criacao").toLocalDate());
                    list.add(trail);
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

    public Trail findById(long id) {
        Trail trail = new Trail();
        String sql = "SELECT * FROM Trilhas WHERE id_trilha = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                trail.setIdTrial(rs.getLong("id_trilha"));
                trail.setTitle(rs.getString("nome_trilha"));
                trail.setDescription(rs.getString("descricao"));
                trail.setCategory(rs.getString("categoria"));
                trail.setDifficultyLevel(rs.getString("nivel_dificuldade"));
                trail.setCreationDate(rs.getDate("data_criacao").toLocalDate());
            }else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return trail;
    }

    public Trail save(Trail trail) {
        String sql = "INSERT INTO Trilhas (nome_trilha, descricao, categoria, nivel_dificuldade, data_criacao) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, trail.getTitle());
            ps.setString(2, trail.getDescription());
            ps.setString(3, trail.getCategory());
            ps.setString(4, trail.getDifficultyLevel());
            ps.setDate(5, java.sql.Date.valueOf(trail.getCreationDate()));

            if (ps.executeUpdate() > 0) {
                return trail;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar a trilha: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM Trilhas WHERE id_trilha = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Erro ao deletar a trilha: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public Trail update(Trail trail) {
        String sql = "UPDATE Trilhas SET nome_trilha = ?, descricao = ?, categoria = ?, nivel_dificuldade = ?, data_criacao = ? WHERE id_trilha = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, trail.getTitle());
            ps.setString(2, trail.getDescription());
            ps.setString(3, trail.getCategory());
            ps.setString(4, trail.getDifficultyLevel());
            ps.setDate(5, java.sql.Date.valueOf(trail.getCreationDate()));
            ps.setLong(6, trail.getIdTrial());

            if (ps.executeUpdate() > 0) {
                return trail;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a trilha: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
