package com.judysen.enities;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 车位信息
 * Created by judysen on 2017/10/6.
 */
public class StationInfo {
    @Id
    String stationInfoId;
    int stationNo;
    Date startTime;
    Date endTime;
    boolean parking;
    String ownUserId;
    String ownVillageInfoId;

    public String getStationInfoId() {
        return stationInfoId;
    }

    public void setStationInfoId(String stationInfoId) {
        this.stationInfoId = stationInfoId;
    }

    public int getStationNo() {
        return stationNo;
    }

    public void setStationNo(int stationNo) {
        this.stationNo = stationNo;
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

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public String getOwnUserId() {
        return ownUserId;
    }

    public void setOwnUserId(String ownUserId) {
        this.ownUserId = ownUserId;
    }

    public String getOwnVillageInfoId() {
        return ownVillageInfoId;
    }

    public void setOwnVillageInfoId(String ownVillageInfoId) {
        this.ownVillageInfoId = ownVillageInfoId;
    }
}
