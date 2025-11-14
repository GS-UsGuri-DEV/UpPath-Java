package br.com.fiap.dao;

import br.com.fiap.TO.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
    public ArrayList<User> findAll() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from usuarios order by id_usuario";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    User user = new User();
                    user.setIdUser(rs.getLong("id_usuario"));
                    user.setIdEmpresa(rs.getLong("id_empresa"));
                    user.setName(rs.getString("nome_completo"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("senha_hash"));
                    user.setNivelCarreira(rs.getString("nivel_carreira"));
                    user.setOccupation(rs.getString("ocupacao"));
                    user.setGender(rs.getString("genero"));
                    user.setBirthDate(rs.getDate("DATA_NASCIMENTO").toLocalDate());
                    user.setDateRegistered(rs.getDate("data_cadastro").toLocalDate());
                    list.add(user);
                }
            }else {
                return null;
            }
        }catch (Exception e){
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return list;
    }

    public User findById(Long id) {
        User user = new User();
        String sql = "select * from usuarios where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setIdUser(rs.getLong("id_usuario"));
                user.setIdEmpresa(rs.getLong("id_empresa"));
                user.setName(rs.getString("nome_completo"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("senha_hash"));
                user.setNivelCarreira(rs.getString("nivel_carreira"));
                user.setOccupation(rs.getString("ocupacao"));
                user.setGender(rs.getString("genero"));
                user.setBirthDate(rs.getDate("DATA_NASCIMENTO").toLocalDate());
                user.setDateRegistered(rs.getDate("data_cadastro").toLocalDate());
            }else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return user;
    }

    public User save(User user) {
        String sql = "insert into usuarios (id_usuario, id_empresa, nome_completo, email, senha_hash, nivel_carreira, ocupacao, genero, DATA_NASCIMENTO) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, user.getIdUser());
            ps.setLong(2, user.getIdEmpresa());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getNivelCarreira());
            ps.setString(7, user.getOccupation());
            ps.setString(8, user.getGender());
            ps.setDate(9, Date.valueOf(user.getBirthDate()));

            if (ps.executeUpdate() > 0) {
                return user;
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
    public boolean delete(Long id) {
        String sql = "delete from usuarios where id_usuario = ?";
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

    public User update(User user) {
        String sql = "update usuarios set id_empresa = ?, nome_completo = ?, email = ?, senha_hash = ?, nivel_carreira = ?, ocupacao = ?, genero = ?, DATA_NASCIMENTO = ? where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, user.getIdEmpresa());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getNivelCarreira());
            ps.setString(6, user.getOccupation());
            ps.setString(7, user.getGender());
            ps.setDate(8, Date.valueOf(user.getBirthDate()));
            ps.setLong(9, user.getIdUser());

            if (ps.executeUpdate() > 0) {
                return user;
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
