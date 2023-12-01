package com.huawei.hms.ads.consent.bean.network;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/consent/bean/network/ApiStatisticsReq.class */
public class ApiStatisticsReq {
    private String apiName;
    private long callTime = System.currentTimeMillis();
    private long costTime;
    private String params;
    private int result;
    private int resultCode;
    private String service;

    public String getApiName() {
        return this.apiName;
    }

    public long getCallTime() {
        return this.callTime;
    }

    public long getCostTime() {
        return this.costTime;
    }

    public String getParams() {
        return this.params;
    }

    public int getResult() {
        return this.result;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getService() {
        return this.service;
    }

    public void setApiName(String str) {
        this.apiName = str;
    }

    public void setCallTime(long j) {
        this.callTime = j;
    }

    public void setCostTime(long j) {
        this.costTime = j;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setService(String str) {
        this.service = str;
    }
}
