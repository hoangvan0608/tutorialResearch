package com.example.tutorial.controller.backend;

import com.example.tutorial.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadImageController {
    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
        if (!FileUtils.isTypeFileOfImage(file)) {
            return "Vui lòng tải  đúng định dạng của file ảnh! (jpeg, png)";
        }
        return FileUtils.saveFile(file);
    }
}
