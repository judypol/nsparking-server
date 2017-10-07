package com.judysen.repository;

import com.judysen.enities.StationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by judysen on 2017/10/7.
 */
public interface StationInfoRepository extends MongoRepository<StationInfo,String> {
}
