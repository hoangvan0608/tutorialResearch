package com.example.tutorial.service.impl;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.dto.ProductDTO;
import com.example.tutorial.entity.*;
import com.example.tutorial.repository.*;
import com.example.tutorial.service.ProductService;
import com.example.tutorial.utils.MessageResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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
    MemoryRepository memoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    HashTagRepository hashTagRepository;

    @Autowired
    MessageConfig messageConfig;

    @Override
    public List<ProductDTO> getAll() {
        List<ProductEntity> entityList = productRepository.findAll();
        return modelMapper.map(entityList, new TypeToken<List<ProductDTO>>() {
        }.getType());
    }


    @Override
    public void save(ProductDTO dto, RedirectAttributes model) {
       ProductEntity productEntity = null;
       if(dto.getId() == null)
       {
           productEntity = new ProductEntity();
       }
       else {
           productEntity = productRepository.findById(dto.getId()).get();
       }
        productEntity.setName(dto.getName());
        productEntity.setDescription(dto.getDescription());
        productEntity.setImage(dto.getImage());
        productEntity.setPrice(dto.getPrice());
        productEntity.setBrandId(dto.getBrandId());
        productEntity.setCategoryId(dto.getCategoryId());
        productEntity.setColorId(dto.getColorId());
        productEntity.setMemoryId(dto.getMemoryId());
        try {
            productRepository.save(productEntity);
            if (dto.getId() == null) {
                MessageResponse.successAlert(model, messageConfig.getMessage("save.success"));
            } else {
                MessageResponse.successAlert(model, messageConfig.getMessage("update.success"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
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
            MessageResponse.successAlert(attributes, messageConfig.getMessage("delete.success"));
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(attributes, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public void findAll(Integer page, Integer perPage, String searchKey, Model model) {
        List<ProductEntity> list = productRepository.findAll();
        Page<ProductEntity> pages = productRepository.findAll(PageRequest.of(page - 1, perPage));
        model.addAttribute("products", pages.getContent());
        model.addAttribute("page", page);
        model.addAttribute("perPage", perPage);
        model.addAttribute("total", pages.getTotalPages());
    }
}
