package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.v;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/inner/AdEventReport.class */
public class AdEventReport {
    private String activityName;
    private int adType;
    private int apiVer;
    private Integer clickX;
    private Integer clickY;
    private String contentId;
    private String creativeSize;
    private String customData;
    private String destination;
    private Integer endProgress;
    private Long endTime;
    private Long eventTime;
    private String eventType;
    private List<FeedbackInfo> feedbackInfoList;
    private Integer intentDest;
    private Integer intentFailReason;
    private String isAdContainerSizeMatched;
    private Boolean isReportNow;
    private List<String> keyWords;
    private boolean mute;
    private boolean phyShow;
    private String requestId;
    private Integer screenOrientation;
    private Integer screenX;
    private Integer screenY;
    private Long showDuration;
    private Integer showRatio;
    private String slotId;
    private Integer source;
    private Integer startProgress;
    private long startShowTime;
    private Long startTime;
    private String templateId;
    private String userId;
    private int x;
    private int y;
    private String showId = String.valueOf(v.Code());
    @d
    private boolean isFromExSplash = false;

    public String A() {
        return this.templateId;
    }

    public Integer B() {
        return this.showRatio;
    }

    public void B(Integer num) {
        this.intentDest = num;
    }

    public void B(String str) {
        this.requestId = str;
    }

    public Integer C() {
        return this.source;
    }

    public void C(Integer num) {
        this.intentFailReason = num;
    }

    public void C(String str) {
        this.customData = str;
    }

    public String Code() {
        return this.contentId;
    }

    public void Code(int i) {
        this.adType = i;
    }

    public void Code(long j) {
        this.startShowTime = j;
    }

    public void Code(Boolean bool) {
        this.isReportNow = bool;
    }

    public void Code(Integer num) {
        this.showRatio = num;
    }

    public void Code(Long l) {
        this.showDuration = l;
    }

    public void Code(String str) {
        this.contentId = str;
    }

    public void Code(List<String> list) {
        this.keyWords = list;
    }

    public void Code(boolean z) {
        this.phyShow = z;
    }

    public Long D() {
        return this.startTime;
    }

    public void D(Integer num) {
        this.screenX = num;
    }

    public void D(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public String E() {
        return this.slotId;
    }

    public String F() {
        return this.eventType;
    }

    public void F(Integer num) {
        this.clickY = num;
    }

    public void F(String str) {
        this.activityName = str;
    }

    public void I(int i) {
        this.y = i;
    }

    public void I(Integer num) {
        this.startProgress = num;
    }

    public void I(Long l) {
        this.endTime = l;
    }

    public void I(String str) {
        this.destination = str;
    }

    public void I(boolean z) {
        this.isFromExSplash = z;
    }

    public boolean I() {
        return this.phyShow;
    }

    public Long L() {
        return this.endTime;
    }

    public void L(Integer num) {
        this.screenY = num;
    }

    public void L(String str) {
        this.creativeSize = str;
    }

    public void S(Integer num) {
        this.clickX = num;
    }

    public void S(String str) {
        this.userId = str;
    }

    public boolean S() {
        return this.mute;
    }

    public int V() {
        return this.adType;
    }

    public void V(int i) {
        this.x = i;
    }

    public void V(Integer num) {
        this.source = num;
    }

    public void V(Long l) {
        this.startTime = l;
    }

    public void V(String str) {
        this.eventType = str;
    }

    public void V(List<FeedbackInfo> list) {
        this.feedbackInfoList = list;
    }

    public void V(boolean z) {
        this.mute = z;
    }

    public Long Z() {
        return this.showDuration;
    }

    public void Z(int i) {
        this.apiVer = i;
    }

    public void Z(Integer num) {
        this.endProgress = num;
    }

    public void Z(Long l) {
        this.eventTime = l;
    }

    public void Z(String str) {
        this.showId = str;
    }

    public Integer a() {
        return this.startProgress;
    }

    public void a(Integer num) {
        this.screenOrientation = num;
    }

    public void a(String str) {
        this.templateId = str;
    }

    public Integer b() {
        return this.endProgress;
    }

    public void b(String str) {
        this.slotId = str;
    }

    public int c() {
        return this.x;
    }

    public int d() {
        return this.y;
    }

    public String e() {
        return this.destination;
    }

    public List<String> f() {
        return this.keyWords;
    }

    public Integer g() {
        return this.intentDest;
    }

    public Integer h() {
        return this.intentFailReason;
    }

    public String i() {
        return this.showId;
    }

    public String j() {
        return this.requestId;
    }

    public String k() {
        return this.customData;
    }

    public String l() {
        return this.userId;
    }

    public String m() {
        return this.activityName;
    }

    public String n() {
        return this.isAdContainerSizeMatched;
    }

    public Integer o() {
        return this.clickX;
    }

    public Integer p() {
        return this.clickY;
    }

    public String q() {
        return this.creativeSize;
    }

    public boolean r() {
        return this.isFromExSplash;
    }

    public Long s() {
        return this.eventTime;
    }

    public Boolean t() {
        return this.isReportNow;
    }

    public Integer u() {
        return this.screenX;
    }

    public Integer v() {
        return this.screenY;
    }

    public Integer w() {
        return this.screenOrientation;
    }

    public long x() {
        return this.startShowTime;
    }

    public List<FeedbackInfo> y() {
        return this.feedbackInfoList;
    }

    public int z() {
        return this.apiVer;
    }
}
