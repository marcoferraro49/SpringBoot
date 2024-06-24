package co.develhope.EsUploadDownload.controllers;

import co.develhope.EsUploadDownload.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping
    public String upload(@RequestParam MultipartFile multipartFile) throws IOException {
        return fileStorageService.upload(multipartFile);
    }
}
