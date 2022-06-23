package com.example.tutorial.service.impl;

import com.example.tutorial.dto.ProductDTO;
import com.example.tutorial.entity.ProductEntity;
import com.example.tutorial.payload.request.NewProductRequest;
import com.example.tutorial.repository.ProductRepository;
import com.example.tutorial.service.ProductService;
import com.example.tutorial.utils.MessageResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getAll() {
        List<ProductEntity> entityList = productRepository.findAll();
        return modelMapper.map(entityList, new
                TypeToken<List<ProductDTO>>() {
                }.getType());
    }

    @Override
    public void save(NewProductRequest productRequest, RedirectAttributes model) {
        ProductEntity productEntity = ProductEntity.builder()
                .categoryId(productRequest.getCategoryId())
                .colorId(productRequest.getColorId())
                .memoryId(productRequest.getMemoryId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .image(productRequest.getImage())
                .price(productRequest.getPrice())
                .id(productRequest.getId())
                .build();
        try {
            productRepository.save(productEntity);
            if (productRequest.getId() == null) {
                MessageResponse.successAlert(model, "Thêm mới thành công");
            } else {
                MessageResponse.successAlert(model, "Sửa thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, "Đã có lỗi xảy ra");
        }
    }


}
