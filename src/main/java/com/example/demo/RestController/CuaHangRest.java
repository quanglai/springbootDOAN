package com.example.demo.RestController;

import com.example.demo.Dto.CuaHangDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface CuaHangRest  extends RestController<CuaHangDto>{
    }
