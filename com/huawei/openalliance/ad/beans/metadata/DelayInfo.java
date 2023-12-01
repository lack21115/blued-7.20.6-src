package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/DelayInfo.class */
public class DelayInfo implements Serializable {
    private static final int AD_LOAD_TIMEOUT_AFTER_RESPONSE = 20;
    private static final int AD_LOAD_TIMEOUT_BEFORE_RESPONSE = 10;
    private static final long serialVersionUID = 5993297861234973073L;
    private Integer adAmount;
    private Long adContentRspParseDuration;
    private Long adFilterDuration;
    private List<String> adIds;
    private long adLoadEndTimestamp;
    private Long adRequestBeforeCost;
    private Long adRequestDuration;
    private long adResponseTime;
    private String contentDownMethod;
    private List<String> contentIds;
    private String costFromServer;
    private Integer creativeType;
    private Integer detailedRetCode;
    private Long e2eDuration;
    private int exSplashFlag;
    private Long resDownloadDuration;
    private int resultCode;
    private Long splashContentLoadedCost;
    private Long splashLoadDuration;
    private Long splashLoadMaterialCost;
    private String splashShowMode;
    private Long threadSwitchCost;
    private long uiThreadSwithCostTime;
    private boolean isSpare = false;
    private AdTimeStatistics timeStatistics = new AdTimeStatistics();

    private Long B(long j, long j2) {
        if (j == 0 || j >= j2) {
            return null;
        }
        return Long.valueOf(j2 - j);
    }

    public long B() {
        Long l = this.threadSwitchCost;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void B(long j) {
        this.adContentRspParseDuration = Long.valueOf(j);
    }

    public long C() {
        Long l = this.adContentRspParseDuration;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void C(long j) {
        this.resDownloadDuration = Long.valueOf(j);
    }

    public Long Code() {
        return B(this.timeStatistics.Code(), this.timeStatistics.V());
    }

    public void Code(int i) {
        this.adAmount = Integer.valueOf(i);
    }

    public void Code(long j) {
        this.adRequestDuration = Long.valueOf(j);
    }

    public void Code(long j, long j2) {
        this.splashLoadDuration = B(j, j2);
        this.timeStatistics.d(j2);
        this.timeStatistics.c(j2);
    }

    public void Code(AdTimeStatistics adTimeStatistics) {
        this.timeStatistics = adTimeStatistics;
    }

    public void Code(Integer num) {
        this.creativeType = num;
    }

    public void Code(Long l) {
        this.e2eDuration = l;
    }

    public void Code(String str) {
        this.splashShowMode = str;
    }

    public void Code(List<String> list) {
        this.adIds = list;
    }

    public void Code(boolean z) {
        this.isSpare = z;
    }

    public int D() {
        Integer num = this.adAmount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void D(long j) {
        this.uiThreadSwithCostTime = j;
    }

    public List<String> F() {
        return this.contentIds;
    }

    public void F(long j) {
        this.adResponseTime = j;
    }

    public long I() {
        Long l = this.adFilterDuration;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void I(int i) {
        this.resultCode = i;
    }

    public void I(long j) {
        this.adRequestBeforeCost = Long.valueOf(j);
    }

    public void I(long j, long j2) {
        this.splashLoadMaterialCost = B(j, j2);
        this.timeStatistics.e(j2);
    }

    public void I(String str) {
        this.costFromServer = str;
    }

    public long L() {
        Long l = this.splashLoadDuration;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void L(long j) {
        this.adLoadEndTimestamp = j;
    }

    public List<String> S() {
        return this.adIds;
    }

    public void S(long j) {
        this.e2eDuration = Long.valueOf(j);
    }

    public long V() {
        Long l = this.adRequestDuration;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void V(int i) {
        this.exSplashFlag = i;
    }

    public void V(long j) {
        this.adFilterDuration = Long.valueOf(j);
    }

    public void V(long j, long j2) {
        this.adLoadEndTimestamp = j2;
        this.e2eDuration = B(j, j2);
        this.timeStatistics.Code(j);
        this.timeStatistics.V(j2);
    }

    public void V(Integer num) {
        this.detailedRetCode = num;
    }

    public void V(Long l) {
        this.splashLoadDuration = l;
    }

    public void V(String str) {
        this.contentDownMethod = str;
    }

    public void V(List<String> list) {
        this.contentIds = list;
    }

    public long Z() {
        Long l = this.adRequestBeforeCost;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void Z(long j) {
        this.threadSwitchCost = Long.valueOf(j);
    }

    public void Z(long j, long j2) {
        if (j <= 0 || j >= j2) {
            return;
        }
        this.splashContentLoadedCost = Long.valueOf(j2 - j);
    }

    public String a() {
        return this.splashShowMode;
    }

    public String b() {
        return this.contentDownMethod;
    }

    public long c() {
        Long l = this.resDownloadDuration;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public long d() {
        Long l = this.splashLoadMaterialCost;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public int e() {
        return this.exSplashFlag;
    }

    public int f() {
        return this.resultCode;
    }

    public Long g() {
        return Long.valueOf(this.adResponseTime);
    }

    public boolean h() {
        return this.isSpare;
    }

    public int i() {
        long j = this.adLoadEndTimestamp;
        if (j != 0) {
            long j2 = this.adResponseTime;
            if (j2 == 0) {
                return 0;
            }
            return j <= j2 ? 10 : 20;
        }
        return 0;
    }

    public AdTimeStatistics j() {
        return this.timeStatistics;
    }

    public Integer k() {
        return this.creativeType;
    }

    public Integer l() {
        return this.detailedRetCode;
    }

    public String m() {
        return this.costFromServer;
    }

    public long n() {
        return this.uiThreadSwithCostTime;
    }

    public long o() {
        return this.adLoadEndTimestamp;
    }
}
