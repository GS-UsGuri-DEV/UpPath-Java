package br.com.fiap.dao;

import br.com.fiap.TO.Courses;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CoursesDAO {
    public ArrayList<Courses> findAll() {
        ArrayList<Courses> list = new ArrayList<>();
        String sql = "SELECT * FROM CURSOS ORDER BY id_curso";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (ps != null) {
                while (rs.next()) {
                    Courses course = new Courses();
                    course.setIdCourse(rs.getLong("id_curso"));
                    course.setIdTrial(rs.getLong("id_trilha"));
                    course.setCourseName(rs.getString("titulo"));
                    course.setDescription(rs.getString("descricao_curso"));
                    course.setImgCourse(rs.getBytes("imagem_curso"));
                    course.setImgCourseName(rs.getString("imagem_curso_nome"));
                    course.setImgCourseMime(rs.getString("imagem_curso_mime"));
                    course.setImgCourseSize(rs.getInt("imagem_curso_tamanho"));
                    course.setImgCourseAlt(rs.getString("imagem_curso_alt"));
                    course.setImgCourseThumb(rs.getBytes("imagem_curso_thumb"));
                    course.setPlatform(rs.getString("plataforma"));
                    course.setUrl(rs.getString("link_curso"));
                    course.setDurationHours(rs.getInt("duracao_horas"));
                    list.add(course);
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

    public Courses findById(Long id) {
        Courses course = new Courses();
        String sql = "SELECT * FROM CURSOS WHERE id_curso = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                course.setIdCourse(rs.getLong("id_curso"));
                course.setIdTrial(rs.getLong("id_trilha"));
                course.setCourseName(rs.getString("titulo"));
                course.setDescription(rs.getString("descricao_curso"));
                course.setImgCourse(rs.getBytes("imagem_curso"));
                course.setImgCourseName(rs.getString("imagem_curso_nome"));
                course.setImgCourseMime(rs.getString("imagem_curso_mime"));
                course.setImgCourseSize(rs.getInt("imagem_curso_tamanho"));
                course.setImgCourseAlt(rs.getString("imagem_curso_alt"));
                course.setImgCourseThumb(rs.getBytes("imagem_curso_thumb"));
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
        String sql = "INSERT INTO CURSOS (id_curso, id_trilha, titulo, descricao_curso, imagem_curso, imagem_curso_nome, imagem_curso_mime, imagem_curso_tamanho, imagem_curso_alt, imagem_curso_thumb, plataforma, link_curso, duracao_horas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, course.getIdCourse());
            ps.setLong(2, course.getIdTrial());
            ps.setString(3, course.getCourseName());
            ps.setString(4, course.getDescription());
            ps.setBinaryStream(5, new ByteArrayInputStream(course.getImgCourse()));
            ps.setString(6, course.getImgCourseName());
            ps.setString(7, course.getImgCourseMime());
            ps.setInt(8, course.getImgCourseSize());
            ps.setString(9, course.getImgCourseAlt());
            ps.setBinaryStream(10, new ByteArrayInputStream(course.getImgCourseThumb()));
            ps.setString(11, course.getPlatform());
            ps.setString(12, course.getUrl());
            ps.setInt(13, course.getDurationHours());

            if (ps.executeUpdate() > 0) {
                return course;
            } else {
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
        String sql = "UPDATE CURSOS SET id_trilha = ?, titulo = ?, descricao_curso = ?, imagem_curso = ?, imagem_curso_nome = ?, imagem_curso_mime = ?, imagem_curso_tamanho = ?, imagem_curso_alt = ?, imagem_curso_thumb = ?, plataforma = ?, link_curso = ?, duracao_horas = ? WHERE id_curso = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, course.getIdTrial());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getDescription());
            ps.setBinaryStream(4, new ByteArrayInputStream(course.getImgCourse()));
            ps.setString(5, course.getImgCourseName());
            ps.setString(6, course.getImgCourseMime());
            ps.setInt(7, course.getImgCourseSize());
            ps.setString(8, course.getImgCourseAlt());
            ps.setBinaryStream(9, new ByteArrayInputStream(course.getImgCourseThumb()));
            ps.setString(10, course.getPlatform());
            ps.setString(11, course.getUrl());
            ps.setInt(12, course.getDurationHours());
            ps.setLong(13, course.getIdCourse());

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
