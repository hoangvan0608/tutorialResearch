package com.example.tutorial.controller;

import com.example.tutorial.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private static String url = "jdbc:mysql://localhost:3306/t3htutorial";
    private static String username = "root";
    private static String password = "2306";

    @GetMapping("/list")
    public String getListUser(Model model) {
        List<UserDTO> userDTOList = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/t3htutorial";
            String user = "root";
            String password = "2306";
            connection = DriverManager.getConnection(url, user, password);
            if(connection != null) {
                String sql = "Select * from user";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(resultSet.getLong("id"));
                    userDTO.setEmail(resultSet.getString("email"));
                    userDTO.setFullName(resultSet.getString("fullname"));
                    userDTO.setPassword(resultSet.getString("password"));
                    userDTO.setRole(resultSet.getString("role"));
                    userDTO.setRepass(null);
                    userDTOList.add(userDTO);
                }

                connection.close();
                preparedStatement.close();
            }
            model.addAttribute("users", userDTOList);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        return "user_list";
    }

    @GetMapping("/{userId}")
    public String userDetail(@PathVariable Long userId, Model model) {
        Connection connection = null;
        UserDTO userDTO = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/t3htutorial";
            String user = "root";
            String password = "2306";
            connection = DriverManager.getConnection(url, user, password);
            if(connection != null) {
                String sql = "Select * from user where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    userDTO = new UserDTO();
                    userDTO.setId(resultSet.getLong("id"));
                    userDTO.setEmail(resultSet.getString("email"));
                    userDTO.setFullName(resultSet.getString("fullname"));
                    userDTO.setPassword(resultSet.getString("password"));
                    userDTO.setRole(resultSet.getString("role"));
                    userDTO.setRepass(null);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("user", userDTO);
        return "user_detail";
    }
}
