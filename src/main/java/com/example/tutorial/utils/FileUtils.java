package com.example.tutorial.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileUtils {
//    public static String FOLDER_IMAGE = "C:\\Users\\GDCV_User\\Desktop\\relearnT3h\\LOCAL_IMAGE\\";
    public static String FOLDER_IMAGE = "C:\\Users\\TAV\\OneDrive\\Desktop\\LOCAL_PHOTO\\";

    public static String saveFile(MultipartFile file) {
        File folder = new File(FOLDER_IMAGE);
        if (!folder.exists()) folder.mkdirs();
        Path path = Paths.get(FOLDER_IMAGE);
        try {
            String fileImage = System.currentTimeMillis() + file.getOriginalFilename();
            Files.copy(file.getInputStream(), path.resolve(fileImage));
            return fileImage;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isTypeFileOfImage(MultipartFile file) {
        String typeFile = Objects.requireNonNull(file.getContentType()).toLowerCase();
        return typeFile.contains("jpeg") || typeFile.contains("png");
    }
}
