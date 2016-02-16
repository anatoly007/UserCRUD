package com.spitsin.main;

import com.spitsin.dao.UserDaoJDBCImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by aser on 15.02.2016.
 */
public class Main {
//    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/persondb";
//    private static final String MYSQL_LOGIN = "anatoly";
//    private static final String MYSQL_PSSWD = "default";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            System.out.println("Connection Error");
        }

        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl(conn);
        try {
            User user = userDao.getById(1);
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Connection getConnection() throws SQLException {
//        Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_LOGIN, MYSQL_PSSWD);

        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader("src/main/resources/mysql.properties");
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("File exception");
        } catch (IOException e) {
            System.out.println("Load exception");
        }
        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("login"), properties.getProperty("password"));
        return conn;
    }
}

