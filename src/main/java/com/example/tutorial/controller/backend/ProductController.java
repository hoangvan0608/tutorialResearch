package com.example.tutorial.controller.backend;

import com.example.tutorial.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/backend/product/")
public class ProductController {

    @GetMapping("create")
    public String createProductPage() {
        return "backend/product/saveOrEdit";
    }

    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file) throws Exception{
        if (!FileUtils.isTypeFileOfImage(file)) {
            return "Vui lòng tải  đúng định dạng của file ảnh! (jpeg, png)";
        }
        return FileUtils.saveFile(file);
    }
}
