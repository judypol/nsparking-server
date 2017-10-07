package com.judysen.enities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * 小区信息
 * Created by judysen on 2017/10/7.
 */
@Setter
@Getter
public class VillageInfo {
    @Id
    String villageInfoId;
    String villageName;
    String address;

}
