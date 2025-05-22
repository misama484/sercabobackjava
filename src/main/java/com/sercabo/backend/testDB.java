package com.sercabo.backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class testDB {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://zcanqqpbfnekmfvwosww.supabase.co:5432/postgres?sslmode=require";
            String user = "postgres";
            String password = "Rockola2postgres";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

