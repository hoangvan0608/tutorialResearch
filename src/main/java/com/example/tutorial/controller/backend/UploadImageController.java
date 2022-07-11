package com.example.tutorial.controller.backend;

import com.example.tutorial.service.IImageService;
import com.example.tutorial.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadImageController {
    @Autowired
    IImageService imageService;
    @PostMapping("/upload/storage")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
        if (!FileUtils.isTypeFileOfImage(file)) {
            return "Vui lòng tải  đúng định dạng của file ảnh! (jpeg, png)";
        }
//        return FileUtils.saveFile(file);
        String fileName = imageService.save(file);

        String imageUrl = imageService.getImageUrl(fileName);
        return  imageUrl;
    }



}
