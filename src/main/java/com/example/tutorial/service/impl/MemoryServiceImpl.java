package com.example.tutorial.service.impl;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.entity.MemoryEntity;
import com.example.tutorial.repository.MemoryRepository;
import com.example.tutorial.service.MemoryService;
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
public class MemoryServiceImpl implements MemoryService {
    @Autowired
    private MemoryRepository memoryRepository;
    @Autowired
    MessageConfig messageConfig;

    @Override
    public void save(MemoryEntity entity, RedirectAttributes model) {
        if (StringUtils.isEmpty(entity.getName())) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("data.error"));
        }
        try {
            if (entity.getId() == null) {
                MessageResponse.successAlert(model, messageConfig.getMessage("save.success"));
            } else {
                MessageResponse.successAlert(model, messageConfig.getMessage("update.success"));
            }
            memoryRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public void findAll(Integer page, Integer perPage, String searchKey, Model model) {
        Page<MemoryEntity> pages = memoryRepository.findAll(PageRequest.of(page - 1, perPage));
        model.addAttribute("memories", pages.getContent());
        model.addAttribute("page", page);
        model.addAttribute("perPage", perPage);
        model.addAttribute("total", pages.getTotalPages());
    }

    @Override
    public MemoryEntity findOne(Long id) {
        return memoryRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id, RedirectAttributes model) {
        try {
            memoryRepository.deleteById(id);
            MessageResponse.successAlert(model, messageConfig.getMessage("delete.success"));
        } catch (Exception e) {
            e.printStackTrace();
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public List<MemoryEntity> findAll() {
        return memoryRepository.findAll();
    }
}
