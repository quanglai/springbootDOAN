package com.example.demo.RestControllerIpm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@RestController
public class uploadFileImage {
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("uploadfile") MultipartFile uploadfile) {
        System.out.println("da vao roi nhe");

        try {
            // Get the filename and build the local file path
            String filename = uploadfile.getOriginalFilename();
            String filepath = new File("/home/quanglai/QuangLai/IdeaProjects/demo/src/main/resources/static/images/").getAbsolutePath()+"/" + filename;
            System.out.println(filepath);
            // Save the file locally
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(filepath));
            System.out.println(stream);
            stream.write(uploadfile.getBytes());
            stream.close();

        }
        catch (Exception e) {
            System.out.println("lai===="+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    } // method uploadFile
}
