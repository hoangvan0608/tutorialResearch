package com.example.tutorial.controller;

import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @GetMapping("/create")
    public String createPage() {
        return "category/saveOrEdit";
    }

    @PostMapping(path = "/save")
    public String saveCategory(CategoryDTO categoryDTO, RedirectAttributes model) {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/t3htutorial";
            String user = "root";
            String password = "2306";
            con = DriverManager.getConnection(url, user, password);
            if(con != null) {
                String sql = "INSERT INTO `category` (`name`, `description`) VALUES (?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,categoryDTO.getName());
                statement.setString(2, categoryDTO.getDescription());
                int result = statement.executeUpdate();
                if(result > 0) {
                    model.addFlashAttribute("message", "Thêm mới thành công");
                    model.addFlashAttribute("alert", "success");
                } else {
                    model.addFlashAttribute("message", "Thêm mới thất bại");
                    model.addFlashAttribute("alert", "warning");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            model.addFlashAttribute("message", "System Errors");
            model.addFlashAttribute("alert", "danger");
        }
        return "redirect:/category/create";
    }

    @GetMapping(path = "/list")
    public String getCategories(Model model) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<CategoryDTO> list = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/t3htutorial";
            String user = "root";
            String password = "2306";
            con = DriverManager.getConnection(url, user, password);
            if(con != null) {
                String sql = "SELECT * FROM `category`";
                statement = con.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CategoryDTO dto = new CategoryDTO();
                    dto.setId(resultSet.getLong("id"));
                    dto.setDescription(resultSet.getString("description"));
                    dto.setName(resultSet.getString("name"));

                    list.add(dto);
                }

            }
        } finally {
            con.close();
            statement.close();
        }
        model.addAttribute("categories", list);
        return "category/list";
    }

    @GetMapping("/{id}")
    public String getCategory(@PathVariable Long id, Model model) {
        Connection connection = null;
        CategoryDTO dto = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/t3htutorial";
            String user = "root";
            String password = "2306";
            connection = DriverManager.getConnection(url, user, password);
            if(connection != null) {
                String sql = "Select * from category where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    dto = new CategoryDTO();
                    dto.setId(resultSet.getLong("id"));
                    dto.setName(resultSet.getString("name"));
                    dto.setDescription(resultSet.getString("description"));
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
        model.addAttribute("category", dto);
        return "category/saveOrEdit";
    }

}
