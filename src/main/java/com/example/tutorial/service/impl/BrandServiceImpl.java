package com.example.tutorial.service.impl;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.entity.BrandEntity;
import com.example.tutorial.repository.BrandRepository;
import com.example.tutorial.service.BrandService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    MessageConfig messageConfig;

    @Override
    public void save(BrandEntity brand, RedirectAttributes model) {
        if (StringUtils.isEmpty(brand.getName()) ) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("data.error"));
        }
        try {
            if (brand.getId() == null) {
                MessageResponse.successAlert(model, messageConfig.getMessage("save.success"));
            } else {
                MessageResponse.successAlert(model, messageConfig.getMessage("update.success"));
            }
            brandRepository.save(brand);
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public void findAll(Integer page, Integer perPage, String searchKey, Model model) {
        Page<BrandEntity> pages = brandRepository.findAll(PageRequest.of(page - 1, perPage));
        model.addAttribute("brands", pages.getContent());
        model.addAttribute("page", page);
        model.addAttribute("perPage", perPage);
        model.addAttribute("total", pages.getTotalPages());

    }

    @Override
    public BrandEntity findOne(Long id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id, RedirectAttributes model) {
        try {
            brandRepository.deleteById(id);
            MessageResponse.successAlert(model, messageConfig.getMessage("delete.success"));
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public List<BrandEntity> findAll() {
        return brandRepository.findAll();
    }
}
