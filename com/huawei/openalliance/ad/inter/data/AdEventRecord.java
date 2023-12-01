package com.huawei.openalliance.ad.inter.data;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/AdEventRecord.class */
public class AdEventRecord {
    private d ad;
    private long endTime;
    private Long eventTime;
    private String eventType;
    private long startTime;

    public AdEventRecord() {
    }

    public AdEventRecord(c cVar, long j, long j2, String str, Long l) {
        this.ad = cVar;
        this.startTime = j;
        this.endTime = j2;
        this.eventType = str;
        this.eventTime = l;
    }

    public Long B() {
        return this.eventTime;
    }

    public d Code() {
        return this.ad;
    }

    public void Code(long j) {
        this.startTime = j;
    }

    public void Code(d dVar) {
        this.ad = dVar;
    }

    public void Code(Long l) {
        this.eventTime = l;
    }

    public void Code(String str) {
        this.eventType = str;
    }

    public long I() {
        return this.endTime;
    }

    public long V() {
        return this.startTime;
    }

    public void V(long j) {
        this.endTime = j;
    }

    public String Z() {
        return this.eventType;
    }
}
