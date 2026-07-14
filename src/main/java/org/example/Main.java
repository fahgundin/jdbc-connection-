package org.example;

import DAO.AlunoDAO;
import DAO.ProfessorDAO;
import Entity.Aluno;
import Entity.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {

        DB db = new DB();
        AlunoDAO alunoDAO = new AlunoDAO(db.getConnection());
        ProfessorDAO professorDAO = new ProfessorDAO(db.getConnection());

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("3 - Excluir Aluno ");
            System.out.println("4 - Cadastrar Professor");
            System.out.println("5 - Listar Professores");
            System.out.println("6 - Excluir Professor");
            System.out.println("0 - Sair");
            int opcao = sc.nextInt();
            if (opcao == 0){
                break;
            }
            sc.nextLine();
            switch (opcao){
                case(1):
                    Aluno aluno = new Aluno();
                    System.out.println("\n Insira nome do aluno");
                    aluno.setNome(sc.nextLine());
                    System.out.println("\n Insira rga do aluno");
                    aluno.setRga(sc.nextLine());
                    System.out.println("\n Insira email do aluno");
                    aluno.setEmail(sc.nextLine());
                    System.out.println("\n Insira curso do luno");
                    aluno.setCurso(sc.nextLine());
                    alunoDAO.cadastrar(aluno);
                    break;
                case(2):
                    ArrayList<Aluno> alunos = alunoDAO.listarAlunos();
                    System.out.println("| Id | Nome | Rga | Email | Curso |");
                    for (Aluno alunoDaLista : alunos){
                        System.out.println("|" + alunoDaLista.getId() + "|" + alunoDaLista.getNome() + "|" + alunoDaLista.getRga() + "|" + alunoDaLista.getEmail() + "|" + alunoDaLista.getCurso() + "|");
                    }

                    break;
                case(3):
                    System.out.println("Informe o id do aluno");
                    int aluno_id = sc.nextInt();
                    alunoDAO.deletar(aluno_id);
                    break;
                case(4):
                    Professor professor = new Professor();
                    System.out.println("Insira Nome do professor");
                    professor.setNome(sc.nextLine());
                    System.out.println("Insira SIAPE do professor");
                    professor.setSiape(sc.nextLine());
                    System.out.println("Insira Unidade acadêmica do professor");
                    professor.setUnidade_academica(sc.nextLine());
                    System.out.println("Insira o Curso do Professor");
                    professor.setCurso(sc.nextLine());
                    professorDAO.cadastrar(professor);
                    break;
                case(5):
                    ArrayList<Professor> professores = professorDAO.listarProfessores();
                    System.out.println("| Id | Nome | SIAPE | UNIDADE ACADEMICA | Curso |");
                    for (Professor professorDaLista: professores){
                        System.out.println("|" + professorDaLista.getId() + "|" + professorDaLista.getNome() + "|" + professorDaLista.getSiape() + "|" + professorDaLista.getUnidade_academica() + "|" + professorDaLista.getCurso() + "|");
                    }
                    break;
                case(6):
                    System.out.println("Informe o id do professor");
                    int professor_id = sc.nextInt();
                    professorDAO.deletar(professor_id);
                    break;
            }
        }

    }
}
