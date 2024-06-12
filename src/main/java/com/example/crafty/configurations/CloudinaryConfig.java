package com.example.crafty.configurations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    //Para cargar variables de entorno desde un archivo .env
    private final Dotenv dotenv = Dotenv.load();
    @Bean
    public Cloudinary cloudinary(){

            return new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", dotenv.get("CLOUDINARY_CLOUD_NAME"),
                    "api_key", dotenv.get("CLOUDINARY_API_KEY"),
                    "api_secret", dotenv.get("CLOUDINARY_API_SECRET")
            ));
    }
}
