package org.example;

import java.sql.*;

public class DB {
    private Connection con;

    public DB() throws SQLException {
        this.con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/cadastro_escolar",
                "root",
                "MinhaSenha123!"
        );
    }

    public Connection getConnection(){
        return this.con;
    }
}
