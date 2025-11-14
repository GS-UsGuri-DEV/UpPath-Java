package br.com.fiap.dao;

import br.com.fiap.TO.Recommendations;

import java.sql.Date;
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
                    recommendation.setDateRecommendation(rs.getDate("data_recomendacao").toLocalDate());
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
                recommendation.setDateRecommendation(rs.getDate("data_recomendacao").toLocalDate());
            }else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return recommendation;
    }

    public Recommendations save(Recommendations recommendation) {
        String sql = "INSERT INTO recomendacoes (id_recomendacao,id_usuario, tipo, id_referencia, motivo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, recommendation.getIdRecommendation());
            ps.setLong(2, recommendation.getIdUser());
            ps.setString(3, recommendation.getType());
            ps.setLong(4, recommendation.getIdReference());
            ps.setString(5, recommendation.getMessage());

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
        return null;
    }

    public boolean delete(Long id) {
        Recommendations recommendation = findById(id);
        String sql = "DELETE FROM recomendacoes WHERE id_recomendacao = ?";
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

    public Recommendations update(Recommendations recommendation) {
        String sql = "UPDATE recomendacoes SET id_usuario = ?, tipo = ?, id_referencia = ?, motivo = ? WHERE id_recomendacao = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, recommendation.getIdUser());
            ps.setString(2, recommendation.getType());
            ps.setLong(3, recommendation.getIdReference());
            ps.setString(4, recommendation.getMessage());
            ps.setLong(5, recommendation.getIdRecommendation());

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
        return null;
    }
}
