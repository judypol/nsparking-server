package com.judysen.repository;

import com.judysen.enities.TenantParkInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by judysen on 2017/10/7.
 */
public interface TenantParkInfoRepository extends MongoRepository<TenantParkInfo,String> {
}
