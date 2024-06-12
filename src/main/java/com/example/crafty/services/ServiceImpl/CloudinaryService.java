package com.example.crafty.services.ServiceImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.crafty.services.Service.ImageStorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
@AllArgsConstructor

@Service
public class CloudinaryService implements ImageStorageService {

    private Cloudinary cloudinary;
    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        File convertedFile = convert(file);
        try{
            Map uploadResult = cloudinary.uploader().upload(convertedFile, ObjectUtils.emptyMap());
            return uploadResult.get("url").toString();
        }finally{
            convertedFile.delete();
        }
    }
    private File convert(MultipartFile file) throws IOException {
        // Crear un archivo temporal con el nombre original del archivo
        File convFile = new File(System.getProperty("java.io.tmpdir"), Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        }
        return convFile;
    }
}
