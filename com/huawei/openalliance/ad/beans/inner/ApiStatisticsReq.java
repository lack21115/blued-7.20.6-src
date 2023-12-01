package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.beans.metadata.DelayInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/inner/ApiStatisticsReq.class */
public class ApiStatisticsReq {
    private String additionId;
    private String apiName;
    private String contentId;
    private long costTime;
    private DelayInfo delayInfo;
    private String isLimitTracking;
    private String oaid;
    private String params;
    private String requestId;
    private int result;
    private int resultCode;
    private String service;
    private long callTime = System.currentTimeMillis();
    private int adType = -1;

    public long B() {
        return this.callTime;
    }

    public void B(String str) {
        this.oaid = str;
    }

    public long C() {
        return this.costTime;
    }

    public void C(String str) {
        this.isLimitTracking = str;
    }

    public String Code() {
        return this.service;
    }

    public void Code(int i) {
        this.result = i;
    }

    public void Code(long j) {
        this.callTime = j;
    }

    public void Code(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }

    public void Code(String str) {
        this.service = str;
    }

    public String D() {
        return this.oaid;
    }

    public String F() {
        return this.additionId;
    }

    public void F(String str) {
        this.contentId = str;
    }

    public int I() {
        return this.result;
    }

    public void I(int i) {
        this.adType = i;
    }

    public void I(String str) {
        this.params = str;
    }

    public String L() {
        return this.isLimitTracking;
    }

    public String S() {
        return this.params;
    }

    public void S(String str) {
        this.requestId = str;
    }

    public String V() {
        return this.apiName;
    }

    public void V(int i) {
        this.resultCode = i;
    }

    public void V(long j) {
        this.costTime = j;
    }

    public void V(String str) {
        this.apiName = str;
    }

    public int Z() {
        return this.resultCode;
    }

    public void Z(String str) {
        this.additionId = str;
    }

    public String a() {
        return this.requestId;
    }

    public int b() {
        return this.adType;
    }

    public String c() {
        return this.contentId;
    }

    public DelayInfo d() {
        return this.delayInfo;
    }
}
