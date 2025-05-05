package org.attractor.edu_food.controller;

import lombok.RequiredArgsConstructor;
import org.attractor.edu_food.service.impl.ImageServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageServiceImpl imageService;

    @GetMapping({"{imageName}"})
    public ResponseEntity<?> getImage(@PathVariable("imageName") String imageName) {
        return imageService.findByName(imageName);
    }
}
