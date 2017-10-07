package com.judysen.repository;

import com.judysen.enities.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by judysen on 2017/10/6.
 */
public interface AccountRepository extends MongoRepository<UserInfo,String> {
    UserInfo findByMobile(String mobile);
}
