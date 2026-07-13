package org.example;

import java.sql.*;
import java.util.ArrayList;

public class AlunoDAO {

    private Connection con;

    public AlunoDAO(Connection con){
        this.con = con;

    }

    public String cadastrar(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO Aluno (nome, rga, email, curso) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = this.con.prepareStatement(sql)){
            stmt.setString(1,aluno.getNome());
            stmt.setString(2,aluno.getRga());
            stmt.setString(3,aluno.getEmail());
            stmt.setString(4,aluno.getCurso());
            stmt.executeUpdate();
            return "Cadastro realizado com sucesso";
        } catch (Exception e) {
            return "Cadastro falhou";
        }
    }
    public ArrayList<Aluno> listarAlunos(){
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT * FROM Aluno";
        try(Statement smt = this.con.createStatement()){
            ResultSet rs = smt.executeQuery(sql);
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRga(rs.getString("rga"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCurso(rs.getString("Curso"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

}
