package com.example.memeV2.service;

import com.example.memeV2.entity.MemeEntity;
import com.example.memeV2.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemeServiceImpl implements MemeService{
    @Autowired
    private MemeRepository memeRepository;


    @Override
    public MemeEntity createMeme(MemeEntity memeEntity) {
        Optional<MemeEntity> existingMeme= memeRepository.findByNameAndUrlAndCaption(memeEntity.getName(),memeEntity.getUrl(),memeEntity.getCaption());
        if(existingMeme.isPresent()){
            throw new RuntimeException("Duplicate meme");
        }
        return memeRepository.save(memeEntity);
    }

    @Override
    public List<MemeEntity> getMemes() {
        Pageable pageable= PageRequest.of(0,100);
        return memeRepository.findAllByOrderByIdDesc(pageable).getContent();
    }

    @Override
    public Optional<MemeEntity> getMemeById(String id) {
        return memeRepository.findById(id);
    }
}
