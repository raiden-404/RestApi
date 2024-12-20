package com.api.bookmanagment.FileManagment;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
//Declearing the class as a bean
@Component
public class FileManagmentHelper {
    private String UPLOAD_DIR="";
        
        //Upload File Method
        public String uploadFile(MultipartFile multipartFile){
    
            //Upload Directory Path- Static and Dynamic
    
            //Static path for the directory where the file will be uploaded
            //private final String UPLOAD_DIR = "D:\STUDY\Java FullStack development\Spring & SpringBoot\SpringBoot_Codes_Projects\RestApi\book_api\src\main\resources\static\images";
            
            //Dynamic path for the directory where the file will be uploaded
            try{
                //Create a classPathResource object and pointing to the desired resource
                Resource resources = new ClassPathResource("static/images");
        
                //Convert the resource object to file object
                File file = resources.getFile();
        
                UPLOAD_DIR = file.getAbsolutePath();
    
        }catch(IOException e){
            e.printStackTrace();
        }
        //Get File Name Using its mehod
        String fileName = multipartFile.getOriginalFilename();
        
        //checking if file is empty
        if(multipartFile.isEmpty()){
            return "Provide File to upload";
        }

        //Checking if file is jpeg - not other file types are allowed or null
        String contentType = multipartFile.getContentType();
        if(contentType == null || !contentType.equals("image/jpeg")){
            return "Only jpeg files are allowed";
        }

        //When all the conditions are true then upload the file
        try{

            //Method 1 - By creating File object and then saving the file
            //Create a file object
            File file = new File(UPLOAD_DIR + File.separator + fileName);
            //Save the file
            multipartFile.transferTo(file);
            


            /*
            //Method 2 - By using Files.copy method where arguments are as follow(inputStream, Path, StandardCopyOption)
            //or THis way
            Files.copy(multipartFile.getInputStream(),Path.of(UPLOAD_DIR+File.separator+fileName),StandardCopyOption.REPLACE_EXISTING);
             */

        }catch(Exception e){
            e.printStackTrace();
            return "Error while uploading file";
        }
        //When File is Uploaded - Return its URL
        //ServletUriComponentsBuilder is used to get the current context path 
        //then we are appending the path of the file to be uploaded
        //toUriString() is used to convert the path to string
        @SuppressWarnings({"null"})
        String fileUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(multipartFile.getOriginalFilename()).toUriString();
        return fileUrl;
    }
}
