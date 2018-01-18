package com.democrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection connection;

    public UserDao() {
        connection = Database.getConnection();
    }


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM user_login");

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("pass_h"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getInt("phone"));
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error fffffffffffffffffffffffffffffffffffffffff");
            e.printStackTrace();
        }

        return users;
    }

    public void deleteUser(String userId) {
        String sql = "DELETE FROM user_login WHERE id=" + userId;
        try{
           Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e) {
            System.out.println("Error delete user by ID");
            e.getMessage();
            //e.printStackTrace();
        }
    }

    public User getUserById(String userId) {
        User user = new User();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_login WHERE id=?");
            statement.setInt(1, Integer.parseInt(userId));
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("pass_h"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getInt("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO user_login(login, pass_h, email, phone) VALUES (?,?,?,?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getPhone());
            statement.executeUpdate();

            System.out.println("metod ADD user");

        } catch (SQLException e) {
            System.out.println("ERROR update-------------------------------------- ");
            e.printStackTrace();

        }

    }

    public void updateUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE user_login SET login=?, pass_h=?, email=?, phone=? WHERE id=?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getPhone());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
            System.out.println("Update user X");
        }catch (SQLException e) {
            System.out.println("ERROR update");
            e.printStackTrace();
        }
    }

}
