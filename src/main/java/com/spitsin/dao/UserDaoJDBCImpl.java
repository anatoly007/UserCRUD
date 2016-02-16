package com.spitsin.dao;

import com.spitsin.main.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aser on 15.02.2016.
 */
public class UserDaoJDBCImpl implements UserDao {
    private Connection connection;
    private static final String GET_ALL = "SELECT * FROM person";

    public UserDaoJDBCImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAll() throws Exception {
        ArrayList<User> list;
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(GET_ALL);
            list = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                list.add(user);
            }
        }
        return list;
    }

//    @Override
//    public User getById(int id) throws Exception {
//        User user;
//        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE person_id = ?")) {
//            statement.setString(1, String.valueOf(id));
//            ResultSet rs = statement.executeQuery();
//            rs.next();
//            user = new User();
//            user.setFname(rs.getString("fname"));
//        }
//        return user;
//    }

    @Override
    public User getById(int id) throws Exception {
        User user;
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM person WHERE person_id = " + id);
            rs.next();
            user = new User();
            user.setId(rs.getInt("person_id"));
            user.setFname(rs.getString("fname"));
            user.setLname(rs.getString("lname"));
            user.setBirthDate(rs.getDate("birth_date"));
        }
        return user;
    }

    @Override
    public User getByName(String name) throws Exception {
        User user;
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM person where name = " + name);
            rs.next();
            user = new User();
            user.setId(rs.getInt("person_id"));
            user.setFname(rs.getString("fname"));
            user.setLname(rs.getString("lname"));
            user.setBirthDate(rs.getDate("birth_date"));
        }
        return user;
    }

    @Override
    public int deleteById(int id) throws Exception {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate("DELETE FROM person WHERE person_id = " + id);
        }
    }

    @Override
    public void insert(User user) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO person ( person_id, fname, lname, birth_date, city )"
                                                                        + "VALUES (null, ?, ?, ?, ?)")) {
            statement.setString(1, user.getFname());
            statement.setString(2, user.getLname());
            statement.setString(3, user.getBirthDate());
            statement.setString(3, user.getCity());
        }

    }
}

