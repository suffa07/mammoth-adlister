package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DelMonroe on 6/12/17.
 */
public class MySQLUsersDao implements Users {
    private Connection connection = null;
    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<User> all() {
        PreparedStatement stmt;
        try {
            String sql = "SELECT * FROM users";
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            return createUsersFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all users", e);
        }
    }

    @Override
    public User findByUsername(String user) {
        PreparedStatement stmt;
        try {
            String sql = "SELECT username, password FROM users WHERE username = '"+user+"'";
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

           return createUserFromResults(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user", e);
        }

    }

    @Override
    public String insert(User user) {
        long id;
        String insert = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {

            PreparedStatement pstmt = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());


            id = pstmt.executeUpdate();


            user.setId(id);

            return String.valueOf(id);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(extractUser(rs));
        }
        return users;
    }

    private User createUserFromResults(ResultSet rs) throws SQLException {
        User user = new User();
        while (rs.next()) {
            user = extractUser(rs);
        }
        return user;
    }


}


