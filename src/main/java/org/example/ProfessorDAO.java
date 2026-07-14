package org.example;

import java.sql.*;
import java.util.ArrayList;

public class ProfessorDAO {

    private Connection con;

    public ProfessorDAO(Connection con){
        this.con = con;
    }

    public String cadastrar(Professor professor) throws SQLException {
        String sql = "INSERT INTO Professor (nome, siape, unidade_academica, curso) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = this.con.prepareStatement(sql)){
            stmt.setString(1,professor.getNome());
            stmt.setString(2, professor.getSiape());
            stmt.setString(3, professor.getUnidade_academica());
            stmt.setString(4, professor.getCurso());
            stmt.executeUpdate();
            return "\n Cadastro realizado com sucesso \n";
        } catch (Exception e) {
            return "\n Cadastro falhou \n";
        }
    }
    public ArrayList<Professor> listarProfessores(){
        ArrayList<Professor> lista = new ArrayList<Professor>();
        String sql = "SELECT * FROM Professor";
        try(Statement smt = this.con.createStatement()){
            ResultSet rs = smt.executeQuery(sql);
            while(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setSiape(rs.getString("siape"));
                professor.setUnidade_academica(rs.getString("unidade_academica"));
                professor.setCurso(rs.getString("curso"));
                lista.add(professor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public String deletar(int id_professor){
        String sql = "DELETE FROM Professor WHERE id = ?";
        try(PreparedStatement stmt = this.con.prepareStatement(sql)){
            stmt.setInt(1, id_professor);
            stmt.executeUpdate();
            return "Deletado com sucesso";
        } catch (SQLException e) {
            return "Falha ao deletar";
        }

    }

}
