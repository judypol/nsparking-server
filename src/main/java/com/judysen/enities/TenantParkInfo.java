package com.judysen.enities;

import java.util.Date;

/**
 * Created by judysen on 2017/10/7.
 */
public class TenantParkInfo {
    String tenantUserId;
    Date startTime;
    Date endTime;
    String stationInfoId;

    public String getTenantUserId() {
        return tenantUserId;
    }

    public void setTenantUserId(String tenantUserId) {
        this.tenantUserId = tenantUserId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStationInfoId() {
        return stationInfoId;
    }

    public void setStationInfoId(String stationInfoId) {
        this.stationInfoId = stationInfoId;
    }
}
