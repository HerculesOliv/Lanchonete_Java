package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String URL = "jdbc:postgresql://localhost/Lanchonete";
    private static final String USER = "hercules_oliveira";
    private static final String PASS = "99166465";
    public static Connection getConeConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na Conexão com o Banco de Dados", ex);
        }
    }
}