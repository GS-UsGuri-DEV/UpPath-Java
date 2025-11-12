package br.com.fiap.dao;

import br.com.fiap.TO.Courses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CoursesDAO {
    public ArrayList<Courses> findAll() {
        ArrayList<Courses> list = new ArrayList<>();
        String sql = "SELECT * FROM Cursos ORDER BY id_curso";
        try (PreparedStatement ps= ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (ps != null) {
                while (rs.next()) {
                    Courses course = new Courses();
                    course.setIdCourse(rs.getLong("id_curso"));
                    course.setIdTrial(rs.getLong("id_trilha"));
                    course.setCourseName(rs.getString("titulo"));
                    course.setPlatform(rs.getString("plataforma"));
                    course.setUrl(rs.getString("link_curso"));
                    course.setDurationHours(rs.getInt("duracao_horas"));
                    list.add(course);
                }
            }else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return list;
    }

    public Courses findById(Long id){
        Courses course = new Courses();
        String sql = "SELECT * FROM CURSOS WHERE id_curso = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                course.setIdCourse(rs.getLong("id_curso"));
                course.setIdTrial(rs.getLong("id_trilha"));
                course.setCourseName(rs.getString("titulo"));
                course.setPlatform(rs.getString("plataforma"));
                course.setUrl(rs.getString("link_curso"));
                course.setDurationHours(rs.getInt("duracao_horas"));
            }

        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return course;
    }

    public Courses save(Courses course) {
        String sql = "INSERT INTO CURSOS (id_trilha, titulo, plataforma, link_curso, duracao_horas) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, course.getIdTrial());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getPlatform());
            ps.setString(4, course.getUrl());
            ps.setInt(5, course.getDurationHours());
            ps.executeUpdate();

            if(ps.executeUpdate() > 0){
                return course;
            }else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro ao salvar o curso: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public Boolean delete(Long id) {
        String sql = "DELETE FROM CURSOS WHERE id_curso = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao deletar o curso: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public Courses update(Courses course) {
        String sql = "UPDATE CURSOS SET id_trilha = ?, titulo = ?, plataforma = ?, link_curso = ?, duracao_horas = ? WHERE id_curso = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, course.getIdTrial());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getPlatform());
            ps.setString(4, course.getUrl());
            ps.setInt(5, course.getDurationHours());
            ps.setLong(6, course.getIdCourse());

            if (ps.executeUpdate() > 0) {
                return course;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o curso: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
