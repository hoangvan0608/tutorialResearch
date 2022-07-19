package com.example.tutorial.service.impl;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.dto.ProductDTO;
import com.example.tutorial.entity.*;
import com.example.tutorial.repository.*;
import com.example.tutorial.service.MediaRepository;
import com.example.tutorial.service.ProductService;
import com.example.tutorial.utils.MessageResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    UserDetailsService userDetailsService;
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

    @Autowired
    MediaRepository mediaRepository;

    @Override
    public List<ProductDTO> getAll() {
        List<ProductEntity> entityList = productRepository.findAll();
        return modelMapper.map(entityList, new TypeToken<List<ProductDTO>>() {
        }.getType());
    }


    @Override
    public void save(ProductDTO dto, RedirectAttributes model) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(dto, productEntity);
        productEntity.setInsertTime(Timestamp.valueOf(LocalDateTime.now()));
        productEntity.setInsertId(dto.getUserId());
        try {
            productRepository.save(productEntity);
            if (dto.getPaths().size() > 0) {
                List<String> stringList = dto.getPaths();
                for (String s : stringList) {
                    MediaEntity mediaEntity = new MediaEntity();
                    mediaEntity.setProductId(productEntity.getId());
                    mediaEntity.setPath(s);
                    mediaRepository.save(mediaEntity);
                }
            }
            MessageResponse.successAlert(model, messageConfig.getMessage("save.success"));
        } catch (Exception e) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ProductDTO dto, RedirectAttributes model) {
        Optional<ProductEntity> productOpt = productRepository.findById(dto.getId());
        if (!productOpt.isPresent()) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("id_not_found"));
            return;
        }
        ProductEntity productEntity = new ProductEntity();
        mediaRepository.deleteAllByProductId(dto.getId());
        BeanUtils.copyProperties(dto, productEntity);
        productEntity.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        productEntity.setUpdateId(dto.getUserId());
        try {
            productRepository.save(productEntity);
            if (dto.getPaths().size() > 0) {
                List<String> stringList = dto.getPaths();
                for (String s : stringList) {
                    MediaEntity mediaEntity = new MediaEntity();
                    mediaEntity.setProductId(productEntity.getId());
                    mediaEntity.setPath(s);
                    mediaRepository.save(mediaEntity);
                }
            }
            MessageResponse.successAlert(model, messageConfig.getMessage("update.success"));
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

        List<MediaEntity> mediaEntities = mediaRepository.findAllByProductId(id);
        List<String> paths = new ArrayList<>();
        for (MediaEntity m :
                mediaEntities) {
            if (m != null) {
                paths.add(m.getPath());
            }
        }
        if (paths.size() > 0) {
            dto.setPaths(paths);
            dto.setSize(paths.size());
        }
        BeanUtils.copyProperties(productEntity, dto);
        return dto;
    }

    @Override
    public void deleteById(Long id, RedirectAttributes attributes) {
        try {
            productRepository.deleteById(id);
            mediaRepository.deleteAllByProductId(id);
            MessageResponse.successAlert(attributes, messageConfig.getMessage("delete.success"));
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(attributes, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public void findAll(Integer page, Integer perPage, String searchKey, Model model) {
        Page<ProductEntity> pages = productRepository.findAll(PageRequest.of(page - 1, perPage));
        model.addAttribute("products", pages.getContent());
        model.addAttribute("page", page);
        model.addAttribute("perPage", perPage);
        model.addAttribute("total", pages.getTotalPages());
    }
}
