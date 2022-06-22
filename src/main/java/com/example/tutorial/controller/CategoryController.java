package com.example.tutorial.controller;

import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("backend/category")
public class CategoryController {
    String url = "jdbc:mysql://localhost:3306/t3htutorial";
    String user = "root";
    String password = "2306";

    @GetMapping("/create")
    public String createPage() {
        return "backend/category/saveOrEdit";
    }

    @PostMapping(path = "/save")
    public String saveCategory(CategoryDTO categoryDTO, RedirectAttributes model) {
        Connection con = null;
        try {
            con = getConnection();
            if (con != null) {
                String sql = "INSERT INTO `category` (`name`, `description`) VALUES (?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, categoryDTO.getName());
                statement.setString(2, categoryDTO.getDescription());
                int result = statement.executeUpdate();
                if (result > 0) {
                    MessageResponse.successAlert(model, "Thêm mới thành công");
                } else {
                    MessageResponse.warningAlert(model, "Thêm mới thất bại");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model,"Đã xảy ra lỗi! Vui lòng thử lại");
        }
        return "redirect:/backend/category/create";
    }

    @GetMapping(path = "/list")
    public String getCategories(Model model) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<CategoryDTO> list = new ArrayList<>();
        try {
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
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
        return "backend/category/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Connection connection = null;
        CategoryDTO dto = null;
        try {
            String url = "jdbc:mysql://localhost:3306/t3htutorial";
            String user = "root";
            String password = "2306";
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
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
        }
        model.addAttribute("category", dto);
        return "backend/category/saveOrEdit";
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public CategoryDTO findById(Long id) throws SQLException {
        CategoryDTO categoryDTO = null;
        Connection connection = getConnection();
        String sql = "select * from category where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            categoryDTO = new CategoryDTO(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("description"));
            if (categoryDTO.getId() != null)
                break;
        }
        return categoryDTO;
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable Long id, CategoryDTO categoryDTO, RedirectAttributes model) throws SQLException {
        try {
            Connection connection = getConnection();
            CategoryDTO categoryDTO1 = findById(id);
            if(categoryDTO1 != null) {
                String sql = "update category set name = ? , description = ? where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, categoryDTO.getName());
                preparedStatement.setString(2, categoryDTO.getDescription());
                preparedStatement.setLong(3, id);
                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    MessageResponse.alert(model,"Cập nhật thành công", "success");
                } else {
                    MessageResponse.alert(model, "Cập nhật thất bại", "warning");
                }
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, "Đã xảy ra lỗi");
        }
        return "redirect:/backend/category/update/{id}";
    }

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable Long id, RedirectAttributes model) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM category WHERE id = ?");
        preparedStatement.setLong(1, id);
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            MessageResponse.successAlert(model, "Xóa thành công");
        } else {
            MessageResponse.warningAlert(model,"Xóa thất bại");
        }
        return "redirect:/backend/category/list";
    }



}
