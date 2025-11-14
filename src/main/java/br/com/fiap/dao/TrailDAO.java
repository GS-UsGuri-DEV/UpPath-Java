package br.com.fiap.dao;

import br.com.fiap.TO.Trail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TrailDAO {

    public ArrayList<Trail> findAll() {
        ArrayList<Trail> list = new ArrayList<>();
        String sql = "SELECT * FROM Trilhas ORDER BY id_trilha";
        try (PreparedStatement ps= ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (ps != null) {
                while (rs.next()) {
                    Trail trail = new Trail();
                    trail.setIdTrial(rs.getLong("id_trilha"));
                    trail.setTitle(rs.getString("nome_trilha"));
                    trail.setDescription(rs.getString("descricao_trilha"));
                    trail.setImage(rs.getBytes("imagem_trilha"));
                    trail.setImageName(rs.getString("imagem_trilha_nome"));
                    trail.setImageMime(rs.getString("imagem_trilha_mime"));
                    trail.setImageSize(rs.getInt("imagem_trilha_tamanho"));
                    trail.setImageAlt(rs.getString("imagem_trilha_alt"));
                    trail.setImageThumb(rs.getBytes("imagem_trilha_thumb"));
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
                trail.setDescription(rs.getString("descricao_trilha"));
                trail.setImage(rs.getBytes("imagem_trilha"));
                trail.setImageName(rs.getString("imagem_trilha_nome"));
                trail.setImageMime(rs.getString("imagem_trilha_mime"));
                trail.setImageSize(rs.getInt("imagem_trilha_tamanho"));
                trail.setImageAlt(rs.getString("imagem_trilha_alt"));
                trail.setImageThumb(rs.getBytes("imagem_trilha_thumb"));
                trail.setCategory(rs.getString("categoria"));
                trail.setDifficultyLevel(rs.getString("nivel_dificuldade"));
                trail.setCreationDate(rs.getDate("data_criacao").toLocalDate());
            } else {
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
        String sql = "INSERT INTO Trilhas (id_trilha, nome_trilha, descricao_trilha, imagem_trilha, imagem_trilha_nome, imagem_trilha_mime, imagem_trilha_tamanho, imagem_trilha_alt, imagem_trilha_thumb, categoria, nivel_dificuldade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {

            ps.setLong(1, trail.getIdTrial());
            ps.setString(2, trail.getTitle());
            ps.setString(3, trail.getDescription());
            ps.setBytes(4, trail.getImage());
            ps.setString(5, trail.getImageName());
            ps.setString(6, trail.getImageMime());
            ps.setInt(7, trail.getImageSize());
            ps.setString(8, trail.getImageAlt());
            ps.setBytes(9, trail.getImageThumb());
            ps.setString(10, trail.getCategory());
            ps.setString(11, trail.getDifficultyLevel());

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
        String sql = "UPDATE Trilhas SET nome_trilha = ?, descricao_trilha = ?, imagem_trilha = ?, imagem_trilha_nome = ?, imagem_trilha_mime = ?, imagem_trilha_tamanho = ?, imagem_trilha_alt = ?, imagem_trilha_thumb = ?, categoria = ?, nivel_dificuldade = ? WHERE id_trilha = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {

            ps.setString(1, trail.getTitle());
            ps.setString(2, trail.getDescription());
            ps.setBytes(3, trail.getImage());
            ps.setString(4, trail.getImageName());
            ps.setString(5, trail.getImageMime());
            ps.setInt(6, trail.getImageSize());
            ps.setString(7, trail.getImageAlt());
            ps.setBytes(8, trail.getImageThumb());
            ps.setString(9, trail.getCategory());
            ps.setString(10, trail.getDifficultyLevel());
            ps.setLong(11, trail.getIdTrial());

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
