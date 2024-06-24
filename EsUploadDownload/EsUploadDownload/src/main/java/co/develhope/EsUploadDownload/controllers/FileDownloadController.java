package co.develhope.EsUploadDownload.controllers;

import co.develhope.EsUploadDownload.services.FileStorageService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/download")
public class FileDownloadController {

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    public byte[] download(@RequestParam String file, HttpServletResponse response) throws IOException {
        String fileExtension = FilenameUtils.getExtension(file);
        switch (fileExtension){
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
            case "jpeg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; filename=\""+file+"\"");
        return fileStorageService.download(file);
    }
}
