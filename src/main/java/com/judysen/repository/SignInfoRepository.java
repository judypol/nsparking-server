package com.judysen.repository;

import com.judysen.enities.SignInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by judysen on 2017/10/7.
 */
public interface SignInfoRepository extends MongoRepository<SignInfo,String> {
}
