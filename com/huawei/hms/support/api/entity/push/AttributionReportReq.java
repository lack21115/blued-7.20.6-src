package com.huawei.hms.support.api.entity.push;

import com.alipay.sdk.util.i;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/entity/push/AttributionReportReq.class */
public class AttributionReportReq implements IMessageEntity {
    @Packed
    String appVersion;
    @Packed
    String campaignId;
    @Packed
    int eventId;
    @Packed
    String haStorageId;
    @Packed
    String msgId;
    @Packed
    String pkgName;
    @Packed
    String reqPermission;
    @Packed
    long timeStamp;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public int getEventId() {
        return this.eventId;
    }

    public String getHaStorageId() {
        return this.haStorageId;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getReqPermission() {
        return this.reqPermission;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }

    public void setEventId(int i) {
        this.eventId = i;
    }

    public void setHaStorageId(String str) {
        this.haStorageId = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setReqPermission(String str) {
        this.reqPermission = str;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public String toString() {
        return " { eventId:" + this.eventId + " pkgName:" + this.pkgName + i.d;
    }
}
