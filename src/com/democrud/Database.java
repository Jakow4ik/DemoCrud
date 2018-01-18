package com.democrud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private final static String URL = "jdbc:mysql://localhost:3306/servletdb";
    private final static String USER = "ivan";
    private final static String PASS = "pass";
    private final static String DRIVER ="com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (Exception e) {
            System.out.println("Database.getConnection() Error -->" + e.getMessage());
            System.out.println("Error ggggggggggggggggggggggggggggggggggggggggg");
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Connection.close() Error -->" + e.getMessage());
        }
    }
}
