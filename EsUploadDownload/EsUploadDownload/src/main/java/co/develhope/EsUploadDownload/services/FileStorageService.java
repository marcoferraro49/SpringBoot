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

    @Value("${fileFolder}")
    private String fileFolder;

    public String upload(MultipartFile file) throws IOException {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString() + "." + fileExtension;
        File destinationFile = new File(fileFolder + newFileName);

        File parentDir = destinationFile.getParentFile();

        if (!parentDir.exists()) {
            if(!parentDir.mkdir()){
                throw new IOException("Failed to create directory");
            }
        }
        file.transferTo(destinationFile);
        return newFileName;
    }

    public byte[] download(String file) throws IOException {
        File fileFromRepo = new File(fileFolder + File.separator + file);
        if (!fileFromRepo.exists()) throw new IOException("File does not exist");
        return IOUtils.toByteArray(new FileInputStream(fileFromRepo));
    }
}
