package com.example.tutorial.service.impl;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.entity.ColorEntity;
import com.example.tutorial.repository.ColorRepository;
import com.example.tutorial.service.ColorService;
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
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    MessageConfig messageConfig;

    @Override
    public void save(ColorEntity brand, RedirectAttributes model) {
        if (StringUtils.isEmpty(brand.getName())) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("data.error"));
        }
        try {
            if (brand.getId() == null) {
                MessageResponse.successAlert(model, messageConfig.getMessage("save.success"));
            } else {
                MessageResponse.successAlert(model, messageConfig.getMessage("update.success"));
            }
            colorRepository.save(brand);
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public void findAll(Integer page, Integer perPage, String searchKey, Model model) {
        Page<ColorEntity> pages = colorRepository.findAll(PageRequest.of(page - 1, perPage));
        model.addAttribute("colors", pages.getContent());
        model.addAttribute("page", page);
        model.addAttribute("perPage", perPage);
        model.addAttribute("total", pages.getTotalPages());
    }

    @Override
    public ColorEntity findOne(Long id) {
        return colorRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id, RedirectAttributes model) {
        try {
            colorRepository.deleteById(id);
            MessageResponse.successAlert(model, messageConfig.getMessage("delete.success"));
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public List<ColorEntity> findAll() {
        return colorRepository.findAll();
    }
}
