package org.attractor.edu_food.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.util.FileUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.userdetails.User;


@Service
@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl{
    private final FileUtil fileUtil;

    public ResponseEntity<?> findByName(String fileName) {
        log.info("Fetching image by fileName={}", fileName);
        return fileUtil.getOutputFile(fileName, "images/", MediaType.IMAGE_JPEG);
    }

}
