package com.sercabo.backend.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PdfService {

    public Resource loadPdf(String fileName) throws Exception {
        Path filePath = Paths.get("src/main/resources/temario").resolve(fileName).normalize();
        return new UrlResource(filePath.toUri());
    }
}