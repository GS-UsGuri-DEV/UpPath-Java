package br.com.fiap.dao;

import br.com.fiap.TO.Empresa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpresaDAO {
    public ArrayList<Empresa> findAll() {
        ArrayList<Empresa> list = new ArrayList<>();
        String sql = "SELECT * FROM Empresa ORDER BY id_empresa";
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
        Empresa empresa = null;
        String sql = "SELECT * FROM Empresa WHERE id_empresa = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empresa = new Empresa();
                empresa.setIdEmpresa(rs.getLong("id_empresa"));
                empresa.setName(rs.getString("nome_empresa"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setEmail(rs.getString("email_contato"));
                empresa.setDataCadastro(rs.getDate("DATA_CADASTRO").toLocalDate());
            }

        } catch (Exception e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return empresa;
    }

    public Empresa save(Empresa empresa) {
        String sql = "INSERT INTO Empresa (nome_empresa, cnpj, email_contato) VALUES (?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, empresa.getName());
            ps.setString(2, empresa.getCnpj());
            ps.setString(3, empresa.getEmail());

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

    public Boolean delete(Empresa empresa) {
        String sql = "DELETE FROM Empresa WHERE id_empresa = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, empresa.getIdEmpresa());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Erro ao deletar empresa: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public Empresa update(Empresa empresa) {
        String sql = "UPDATE Empresa SET nome_empresa = ?, cnpj = ?, email_contato = ? WHERE id_empresa = ?";
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
