package com.sparta.pbl_week2.controller;

import com.sparta.pbl_week2.responseEntity.ResponseBody;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CORSController {

    @GetMapping("/cors/test")
    public ResponseEntity<ResponseBody> getCors() {
        return new ResponseEntity<>(new ResponseBody("success", "CORS GET PASS"), HttpStatus.ACCEPTED);
    }

    @GetMapping("/cors/test/2")
    public ResponseEntity<ResponseBody> getCors2() {
        return new ResponseEntity<>(new ResponseBody("success", "CORS GET PASS 2"), HttpStatus.ACCEPTED);
    }

    @PostMapping("/cors/test")
    public ResponseEntity<ResponseBody> postCors() {
        return new ResponseEntity<>(new ResponseBody("success", "CORS POST PASS"), HttpStatus.ACCEPTED);
    }

    @PutMapping("/cors/test")
    public ResponseEntity<ResponseBody> putCors() {
        return new ResponseEntity<>(new ResponseBody("success", "CORS PUT PASS"), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/cors/test")
    public ResponseEntity<ResponseBody> deleteCors() {
        return new ResponseEntity<>(new ResponseBody("success", "CORS DELETE PASS"), HttpStatus.ACCEPTED);
    }
}
