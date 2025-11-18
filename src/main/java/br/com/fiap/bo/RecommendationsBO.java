package br.com.fiap.bo;

import br.com.fiap.TO.Recommendations;
import br.com.fiap.dao.RecommendationsDAO;
import br.com.fiap.utils.IdGenerator;

import java.util.ArrayList;

public class RecommendationsBO {
    RecommendationsDAO recommendationsDAO;

    public ArrayList<Recommendations> findAll() {
        recommendationsDAO = new RecommendationsDAO();
        return recommendationsDAO.findAll();
    }

    public Recommendations findById(Long id) {
        recommendationsDAO = new RecommendationsDAO();
        return recommendationsDAO.findById(id);
    }

    public Recommendations save(Recommendations recommendations) {
        recommendationsDAO = new RecommendationsDAO();
        Long id = IdGenerator.generate("recomendacoes", "id_recomendacao");
        recommendations.setIdRecommendation(id);
        return recommendationsDAO.save(recommendations);
    }

    public boolean delete(Long id) {
        recommendationsDAO = new RecommendationsDAO();
        return recommendationsDAO.delete(id);
    }

    public Recommendations update(Recommendations recommendations) {
        recommendationsDAO = new RecommendationsDAO();
        return recommendationsDAO.update(recommendations);
    }
}
