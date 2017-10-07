package com.judysen.repository;

import com.judysen.enities.VillageInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by judysen on 2017/10/7.
 */
public interface VillageInfoRepository extends MongoRepository<VillageInfo,String> {
}
