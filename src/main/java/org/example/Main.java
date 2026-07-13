package org.example;

import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        String statement = "SELECT nome, rga FROM Aluno";
        try{
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/cadastro_escolar",
                    "root",
                    "MinhaSenha123!"
            );
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(statement);
            while(res.next()){
                String aluno_str = res.getString("nome");
                IO.println(aluno_str);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Scanner sc = new Scanner(System.in);
        while(true){
            int opcao = sc.nextInt();
            if (opcao == 0){
                break;
            }
            switch (opcao){
                case(1):
                    break;
                case(2):
                    break;
                case(3):
                    break;
                case(4):
                    break;
                case(5):
                    break;
                case(6):
                    break;
            }


        }

    }
}
