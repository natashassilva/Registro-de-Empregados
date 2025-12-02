package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://projeto-27052025-natashassilva-5a70.i.aivencloud.com:25658/Empresa";
    private static final String user = "avnadmin";
    private static final String password = "AVNS_NJutqLlA2aR2LKq6Xz8";

    private static Connection conexao;

    public static Connection getConexao() {
       try {
        if (conexao == null) {
            conexao = DriverManager.getConnection(URL, user, password);
            return conexao;
        }
        else {
            return conexao;
        }
       } catch (SQLException e){
        //Todo auto generated catch block
        e.printStackTrace();
        return null;
       }    
    }
}
