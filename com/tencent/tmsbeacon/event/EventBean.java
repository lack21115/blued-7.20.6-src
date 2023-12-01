package com.tencent.tmsbeacon.event;

import java.io.Serializable;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/EventBean.class */
public final class EventBean implements Serializable {
    private static final long serialVersionUID = 1;
    private String apn;
    private String appKey;
    private byte[] byteValue;
    private String eventCode;
    private long eventTime;
    private int eventType;
    private Map<String, String> eventValue;
    private String reserved;
    private String srcIp;
    private int valueType;
    private long cid = -1;
    private boolean eventResult = true;

    public String getApn() {
        return this.apn;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public byte[] getByteValue() {
        return this.byteValue;
    }

    public long getCid() {
        return this.cid;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public boolean getEventResult() {
        return this.eventResult;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public int getEventType() {
        return this.eventType;
    }

    public Map<String, String> getEventValue() {
        return this.eventValue;
    }

    public String getReserved() {
        return this.reserved;
    }

    public String getSrcIp() {
        return this.srcIp;
    }

    public int getValueType() {
        return this.valueType;
    }

    public void setApn(String str) {
        this.apn = str;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setByteValue(byte[] bArr) {
        this.byteValue = bArr;
    }

    public void setCid(long j) {
        this.cid = j;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventResult(boolean z) {
        this.eventResult = z;
    }

    public void setEventTime(long j) {
        this.eventTime = j;
    }

    public void setEventType(int i) {
        this.eventType = i;
    }

    public void setEventValue(Map<String, String> map) {
        this.eventValue = map;
    }

    public void setReserved(String str) {
        this.reserved = str;
    }

    public void setSrcIp(String str) {
        this.srcIp = str;
    }

    public void setValueType(int i) {
        this.valueType = i;
    }
}
