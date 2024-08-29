package org.example.intern.util;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
public class FileUploadUtil {

    private final Path root = Paths.get("uploads");

    public String saveFile(String fileName, MultipartFile multipartFile) throws IOException {
        if (!Files.exists(root)) {
            Files.createDirectories(root);
            log.info("Tạo thư muc thành công");
        }
        try {
            String nameFile = UUID.randomUUID() + multipartFile.getOriginalFilename();
            Files.copy(multipartFile.getInputStream(), this.root.resolve(nameFile));
            log.info("Lưu {} ảnh thành công", fileName);
            return nameFile;
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
