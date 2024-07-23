package com.example.memeV2.controller;

import com.example.memeV2.entity.MemeEntity;
import com.example.memeV2.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemeController {

    @Autowired
    private MemeService memeService;

    @PostMapping("/memes")
    public ResponseEntity<?> createMeme(@RequestBody MemeEntity memeEntity){
       try{
           if(memeEntity.getName()==null||memeEntity.getName().trim().isEmpty()
                   ||memeEntity.getUrl()==null||memeEntity.getUrl().trim().isEmpty()
                   ||memeEntity.getCaption()==null||memeEntity.getCaption().trim().isEmpty()){
               throw new RuntimeException("Name, URL, and Caption are required");
           }
           MemeEntity savedMeme=memeService.createMeme(memeEntity);
           return new ResponseEntity<>(savedMeme, HttpStatus.CREATED);
       }catch(RuntimeException e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/memes")
    public List<MemeEntity> getMemes(){
       return memeService.getMemes();
    }

    @GetMapping("/memes/{id}")
    public ResponseEntity<?> getMemeById(@PathVariable String id){
        Optional<MemeEntity> meme=memeService.getMemeById(id);
        if(meme.isPresent()){
            return new ResponseEntity<>(meme.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Meme not found",HttpStatus.NOT_FOUND);
        }
    }
}
