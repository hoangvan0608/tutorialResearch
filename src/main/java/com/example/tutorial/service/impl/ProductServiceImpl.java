package com.example.tutorial.service.impl;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.dto.ProductDTO;
import com.example.tutorial.dto.ResponseDto;
import com.example.tutorial.entity.ProductEntity;
import com.example.tutorial.repository.ProductRepository;
import com.example.tutorial.service.ProductService;
import com.example.tutorial.utils.MessageResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    MessageConfig messageConfig;

    @Override
    public List<ProductDTO> getAll() {
        List<ProductEntity> entityList = productRepository.findAll();
        return modelMapper.map(entityList, new TypeToken<List<ProductDTO>>() {
        }.getType());
    }


    @Override
    public void save(ProductDTO productRequest, RedirectAttributes model) {
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
                MessageResponse.successAlert(model, messageConfig.getMessage("product.save.success"));
            } else {
                MessageResponse.successAlert(model, messageConfig.getMessage("product.edit.success"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("product.error"));
        }
    }

    @Override
    public ProductDTO findOneById(Long id) {
        ProductDTO dto = new ProductDTO();
        Optional<ProductEntity> optional = productRepository.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        ProductEntity productEntity = optional.get();
        BeanUtils.copyProperties(productEntity, dto);
        return dto;
    }

    @Override
    public void deleteById(Long id, RedirectAttributes attributes) {
        try {
            productRepository.deleteById(id);
            MessageResponse.successAlert(attributes, messageConfig.getMessage("product.delete.success"));
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(attributes, messageConfig.getMessage("product.error"));
        }
    }
}
