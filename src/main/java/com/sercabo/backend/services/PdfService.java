package com.sercabo.backend.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class PdfService {

    public Resource loadPdf(String fileName) throws Exception {
        Resource resource = new ClassPathResource("temario/" + fileName);
        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new FileNotFoundException("Archivo no encontrado o no legible: " + fileName);
        }
    }
}