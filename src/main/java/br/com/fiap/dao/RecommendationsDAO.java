package br.com.fiap.dao;

import br.com.fiap.TO.Recommendations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RecommendationsDAO {
    public ArrayList<Recommendations> findAll (){
        ArrayList<Recommendations> list = new ArrayList<>();
        String sql = "SELECT * FROM recomendacoes ORDER BY id_recomendacao";
        try (PreparedStatement ps= ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (ps != null) {
                while (rs.next()) {
                    Recommendations recommendation = new Recommendations();
                    recommendation.setIdRecommendation(rs.getLong("id_recomendacao"));
                    recommendation.setIdUser(rs.getLong("id_usuario"));
                    recommendation.setType(rs.getString("tipo"));
                    recommendation.setIdReference(rs.getLong("id_referencia"));
                    recommendation.setMessage(rs.getString("motivo"));
                    recommendation.setDateRecommendation(rs.getDate("date_recomendacao").toLocalDate());
                    list.add(recommendation);
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

    public Recommendations findById(Long id) {
        Recommendations recommendation = null;
        String sql = "SELECT * FROM recomendacoes WHERE id_recomendacao = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                recommendation = new Recommendations();
                recommendation.setIdRecommendation(rs.getLong("id_recomendacao"));
                recommendation.setIdUser(rs.getLong("id_usuario"));
                recommendation.setType(rs.getString("tipo"));
                recommendation.setIdReference(rs.getLong("id_referencia"));
                recommendation.setMessage(rs.getString("motivo"));
                recommendation.setDateRecommendation(rs.getDate("date_recomendacao").toLocalDate());
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return recommendation;
    }

    public Recommendations save(Recommendations recommendation) {
        String sql = "INSERT INTO recomendacoes (id_usuario, tipo, id_referencia, motivo, date_recomendacao) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, recommendation.getIdUser());
            ps.setString(2, recommendation.getType());
            ps.setLong(3, recommendation.getIdReference());
            ps.setString(4, recommendation.getMessage());
            ps.setDate(5, java.sql.Date.valueOf(recommendation.getDateRecommendation()));
            ps.executeUpdate();

            if(ps.executeUpdate() > 0){
                return recommendation;
            }else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return recommendation;
    }
    public Recommendations delete(Long id) {
        Recommendations recommendation = findById(id);
        String sql = "DELETE FROM recomendacoes WHERE id_recomendacao = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return recommendation;
    }

    public Recommendations update(Recommendations recommendation) {
        String sql = "UPDATE recomendacoes SET id_usuario = ?, tipo = ?, id_referencia = ?, motivo = ?, date_recomendacao = ? WHERE id_recomendacao = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, recommendation.getIdUser());
            ps.setString(2, recommendation.getType());
            ps.setLong(3, recommendation.getIdReference());
            ps.setString(4, recommendation.getMessage());
            ps.setDate(5, java.sql.Date.valueOf(recommendation.getDateRecommendation()));
            ps.setLong(6, recommendation.getIdRecommendation());

            if (ps.executeUpdate() > 0) {
                return recommendation;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return recommendation;
    }
}
