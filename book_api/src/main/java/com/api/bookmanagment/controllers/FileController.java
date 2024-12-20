package com.api.bookmanagment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.bookmanagment.FileManagment.FileManagmentHelper;

//Control all api requests related to file upload
@RestController
public class FileController {
    //Inject FileManagmentHelper bean
    @Autowired
    FileManagmentHelper fileManagmentHelper;
    
    //Upload file
    @PostMapping("/file-upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        //Upload file using FileManagmentHelper and return responseEntity
        return ResponseEntity.status(HttpStatus.OK).body(fileManagmentHelper.uploadFile(file));
    }
}
