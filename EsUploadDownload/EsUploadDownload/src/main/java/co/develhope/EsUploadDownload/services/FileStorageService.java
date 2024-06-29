package co.develhope.EsUploadDownload.services;

import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${fileRepoFolder}")
    private String fileFolder;

    public String upload(MultipartFile file) throws IOException {
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString()+"."+ext;
        File finalDest = new File(fileFolder + "\\" + newFileName);
        if(finalDest.exists()) throw new IOException("Folder does not exist");
        file.transferTo(finalDest);
        return newFileName;
    }

    public byte[] download(String file) throws IOException {
        File fileFromRepo = new File(fileFolder + "\\"+file);
        if(!fileFromRepo.exists()) throw new IOException("File does not exist");
        return IOUtils.toByteArray(new FileInputStream(fileFromRepo));
    }
}
