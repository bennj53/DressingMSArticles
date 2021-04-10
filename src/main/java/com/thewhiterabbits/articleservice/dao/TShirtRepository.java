package com.thewhiterabbits.articleservice.dao;

import com.thewhiterabbits.articleservice.entity.TShirt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TShirtRepository extends MongoRepository<TShirt, String> {
}
