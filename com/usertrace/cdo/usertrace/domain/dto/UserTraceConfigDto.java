package com.usertrace.cdo.usertrace.domain.dto;

import io.protostuff.Tag;

/* loaded from: source-8829756-dex2jar.jar:com/usertrace/cdo/usertrace/domain/dto/UserTraceConfigDto.class */
public class UserTraceConfigDto {
    @Tag(3)
    private long beginTime;
    @Tag(4)
    private long endTime;
    @Tag(5)
    private int force;
    @Tag(2)
    private String imei;
    @Tag(7)
    private String openId;
    @Tag(8)
    private String registrationId;
    @Tag(1)
    private long traceId;
    @Tag(6)
    private String tracePkg;

    public long getBeginTime() {
        return this.beginTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getForce() {
        return this.force;
    }

    public String getImei() {
        return this.imei;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getRegistrationId() {
        return this.registrationId;
    }

    public long getTraceId() {
        return this.traceId;
    }

    public String getTracePkg() {
        return this.tracePkg;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setForce(int i) {
        this.force = i;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public void setRegistrationId(String str) {
        this.registrationId = str;
    }

    public void setTraceId(long j) {
        this.traceId = j;
    }

    public void setTracePkg(String str) {
        this.tracePkg = str;
    }

    public String toString() {
        return "UserTraceConfigDto{traceId=" + this.traceId + ", imei='" + this.imei + "', beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", force=" + this.force + ", tracePkg='" + this.tracePkg + "', openId='" + this.openId + "'}";
    }
}
