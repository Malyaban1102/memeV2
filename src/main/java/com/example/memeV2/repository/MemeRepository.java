package com.example.memeV2.repository;

import com.example.memeV2.entity.MemeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemeRepository extends MongoRepository<MemeEntity,String> {
     Optional<MemeEntity> findByNameAndUrlAndCaption(String name, String url, String caption);
     Page<MemeEntity> findAllByOrderByIdDesc(Pageable pageable);

}
