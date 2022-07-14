package com.example.tutorial.service.impl;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.entity.HashTagEntity;
import com.example.tutorial.repository.HashTagRepository;
import com.example.tutorial.service.HashtagService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class HashtagServiceImpl implements HashtagService {
    @Autowired
    HashTagRepository hashTagRepository;
    @Autowired
    MessageConfig messageConfig;
    @Override
    public void save(HashTagEntity brand, RedirectAttributes model) {
        if (StringUtils.isEmpty(brand.getName())) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("data.error"));
        }
        try {
            if (brand.getId() == null) {
                MessageResponse.successAlert(model, messageConfig.getMessage("save.success"));
            } else {
                MessageResponse.successAlert(model, messageConfig.getMessage("update.success"));
            }
            hashTagRepository.save(brand);
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public void findAll(Integer page, Integer perPage, String searchKey, Model model) {
        Page<HashTagEntity> pages = hashTagRepository.findAll(PageRequest.of(page - 1, perPage));
        model.addAttribute("hashtags", pages.getContent());
        model.addAttribute("page", page);
        model.addAttribute("perPage", perPage);
        model.addAttribute("total", pages.getTotalPages());
    }

    @Override
    public HashTagEntity findOne(Long id) {
        return hashTagRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id, RedirectAttributes model) {
        try {
            hashTagRepository.deleteById(id);
            MessageResponse.successAlert(model, messageConfig.getMessage("delete.success"));
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }
}
