package com.example.demo.RestControllerIpm;

import com.example.demo.Dto.ImageDto;
import com.example.demo.RestController.ImageRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/image")
public class ImageRestIpm implements ImageRest {
    @Override
    public List<ImageDto> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<ImageDto> findOne(@PathVariable(name = "id")Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ImageDto> save(@RequestBody ImageDto imageDto) {
        return null;
    }

    @Override
    public ResponseEntity<ImageDto> delete(@PathVariable (name = "id") Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ImageDto> update(@RequestBody ImageDto imageDto) {
        return null;
    }
}
