package br.com.fiap.dao;

import br.com.fiap.TO.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpresaDAO {
    public ArrayList<Empresa> findAll() {
        ArrayList<Empresa> list = new ArrayList<>();
        String sql = "SELECT * FROM Empresas ORDER BY id_empresa";
        try (PreparedStatement ps= ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while (rs.next()){
                    Empresa empresa = new Empresa();
                    empresa.setIdEmpresa(rs.getLong("id_empresa"));
                    empresa.setName(rs.getString("nome_empresa"));
                    empresa.setCnpj(rs.getString("cnpj"));
                    empresa.setEmail(rs.getString("email_contato"));
                    empresa.setDataCadastro(rs.getDate("DATA_CADASTRO").toLocalDate());
                    empresa.setSenha(rs.getString("senha_hash_empresa"));
                    list.add(empresa);
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

    public Empresa findById(Long id) {
        Empresa empresa = new Empresa();
        String sql = "SELECT * FROM Empresas WHERE id_empresa = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empresa.setIdEmpresa(rs.getLong("id_empresa"));
                empresa.setName(rs.getString("nome_empresa"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setEmail(rs.getString("email_contato"));
                empresa.setDataCadastro(rs.getDate("DATA_CADASTRO").toLocalDate());
                empresa.setSenha(rs.getString("senha_hash_empresa"));
            }else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return empresa;
    }

    public Empresa save(Empresa empresa) {
        String sql = "INSERT INTO Empresas (id_empresa, nome_empresa, cnpj, email_contato,senha_hash_empresa) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, empresa.getIdEmpresa());
            ps.setString(2, empresa.getName());
            ps.setString(3, empresa.getCnpj());
            ps.setString(4, empresa.getEmail());
            ps.setString(5, empresa.getSenha());

            if (ps.executeUpdate() > 0) {
                return empresa;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar empresa: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public Boolean delete(Long id) {
        String sql = "DELETE FROM Empresas WHERE id_empresa = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao deletar empresa: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public Empresa update(Empresa empresa) {
        String sql = "UPDATE Empresas SET nome_empresa = ?, cnpj = ?, email_contato = ? WHERE id_empresa = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, empresa.getName());
            ps.setString(2, empresa.getCnpj());
            ps.setString(3, empresa.getEmail());
            ps.setLong(4, empresa.getIdEmpresa());

            if (ps.executeUpdate() > 0) {
                return empresa;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar empresa: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return empresa;
    }
}
