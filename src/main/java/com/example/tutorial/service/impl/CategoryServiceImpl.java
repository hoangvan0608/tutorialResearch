package com.example.tutorial.service.impl;

import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.entity.CategoryEntity;
import com.example.tutorial.repository.CategoryRepository;
import com.example.tutorial.service.CategoryService;
import com.example.tutorial.utils.MessageResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CategoryDTO categoryRequest, RedirectAttributes model) {
        if (StringUtils.isEmpty(categoryRequest.getName()) ||
                StringUtils.isEmpty(categoryRequest.getDescription())) {
            MessageResponse.dangerAlert(model, "Cần điền đầy đủ tất cả thông tin để tạo mới");
        }
        try {
            CategoryEntity category = new CategoryEntity();
            BeanUtils.copyProperties(categoryRequest, category);
            categoryRepository.save(category);
            if (categoryRequest.getId() == null) {
                MessageResponse.successAlert(model, "Thêm mới thành công");
            } else {
                MessageResponse.successAlert(model, "Sửa thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, "Đã có lỗi xảy ra");
        }
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> entityList = categoryRepository.findAll();
        return modelMapper.map(entityList, new TypeToken<List<CategoryDTO>>() {
        }.getType());
    }

    @Override
    public CategoryDTO findOne(Long id) {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            CategoryEntity category = optionalCategory.get();
            return modelMapper.map(category, new TypeToken<CategoryDTO>() {
            }.getType());
        }
        return null;
    }

    @Override
    public void deleteById(Long id, RedirectAttributes model) {
        CategoryEntity category = categoryRepository.findById(id).get();
        if (category != null) {
            try {
                categoryRepository.delete(category);
                MessageResponse.successAlert(model, "Xóa thành công");
                return;
            } catch (Exception e) {
                MessageResponse.warningAlert(model, "Xóa thất bại");
                return;
            }
        }
        MessageResponse.dangerAlert(model, "Đã có lỗi xảy ra");
    }
}
