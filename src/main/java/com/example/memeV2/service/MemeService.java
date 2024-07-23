package com.example.memeV2.service;

import com.example.memeV2.entity.MemeEntity;

import java.util.List;
import java.util.Optional;

public interface MemeService {
    MemeEntity createMeme(MemeEntity memeEntity);
    List<MemeEntity> getMemes();
    Optional<MemeEntity> getMemeById(String id);

}
