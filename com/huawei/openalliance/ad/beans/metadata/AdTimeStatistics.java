package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/AdTimeStatistics.class */
public class AdTimeStatistics implements Serializable {
    private static final long serialVersionUID = 5562197861234973073L;
    long adInfoPrepEndTS;
    long adLoadEndTS;
    long adLoadStartTS;
    long adNetReqEndTS;
    long adNetReqStartTS;
    long adPhyReqEndTS;
    long adPhyReqStartTS;
    long adRspParseEndTS;
    long adRspParseStartTS;
    long kitSdkIPCEndTS;
    long kitSdkIPCStartTS;
    long sdkKitIPCEndTS;
    long sdkKitIPCStartTS;
    long splashAdDownloadTS;
    long splashAdMaterialLoadedTS;

    public long B() {
        return this.adPhyReqEndTS;
    }

    public void B(long j) {
        this.adPhyReqEndTS = j;
    }

    public long C() {
        return this.adNetReqStartTS;
    }

    public void C(long j) {
        this.adNetReqStartTS = j;
    }

    public long Code() {
        return this.adLoadStartTS;
    }

    public void Code(long j) {
        this.adLoadStartTS = j;
    }

    public long D() {
        return this.adRspParseEndTS;
    }

    public void D(long j) {
        this.adRspParseEndTS = j;
    }

    public long F() {
        return this.adRspParseStartTS;
    }

    public void F(long j) {
        this.adRspParseStartTS = j;
    }

    public long I() {
        return this.adInfoPrepEndTS;
    }

    public void I(long j) {
        this.adInfoPrepEndTS = j;
    }

    public long L() {
        return this.sdkKitIPCStartTS;
    }

    public void L(long j) {
        this.sdkKitIPCStartTS = j;
    }

    public long S() {
        return this.adNetReqEndTS;
    }

    public void S(long j) {
        this.adNetReqEndTS = j;
    }

    public long V() {
        return this.adLoadEndTS;
    }

    public void V(long j) {
        this.adLoadEndTS = j;
    }

    public long Z() {
        return this.adPhyReqStartTS;
    }

    public void Z(long j) {
        this.adPhyReqStartTS = j;
    }

    public long a() {
        return this.sdkKitIPCEndTS;
    }

    public void a(long j) {
        this.sdkKitIPCEndTS = j;
    }

    public long b() {
        return this.kitSdkIPCStartTS;
    }

    public void b(long j) {
        this.kitSdkIPCStartTS = j;
    }

    public long c() {
        return this.kitSdkIPCEndTS;
    }

    public void c(long j) {
        this.kitSdkIPCEndTS = j;
    }

    public long d() {
        return this.splashAdDownloadTS;
    }

    public void d(long j) {
        this.splashAdDownloadTS = j;
    }

    public long e() {
        return this.splashAdMaterialLoadedTS;
    }

    public void e(long j) {
        this.splashAdMaterialLoadedTS = j;
    }
}
