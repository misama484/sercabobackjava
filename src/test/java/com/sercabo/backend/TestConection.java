package com.sercabo.backend;


import java.sql.Connection;
import java.sql.DriverManager;

public class TestConection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://db.uqxjageqttvoaiixvaza.supabase.co:5432/postgres";
        String username = "postgres";
        String password = "Rockola2postgres";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }
}