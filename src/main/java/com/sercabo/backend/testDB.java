package com.sercabo.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testDB {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://zcanqqpbfnekmfvwosww.supabase.co:5432/postgres?sslmode=require";
        String user = "postgres";
        String password = "Rockola2postgres";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Conexión exitosa a Supabase");
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión:");
            e.printStackTrace();
        }
    }
}



