package com.example.crafty.services.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageStorageService {

    String uploadImage(MultipartFile file) throws IOException;

}
