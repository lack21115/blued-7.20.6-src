package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/Stats.class */
public class Stats {
    private Long bytesProcessed;
    private Long bytesReturned;
    private Long bytesScanned;

    public Stats(Long l, Long l2, Long l3) {
        this.bytesScanned = l;
        this.bytesProcessed = l2;
        this.bytesReturned = l3;
    }

    public Long getBytesProcessed() {
        return this.bytesProcessed;
    }

    public Long getBytesReturned() {
        return this.bytesReturned;
    }

    public Long getBytesScanned() {
        return this.bytesScanned;
    }

    public void setBytesProcessed(Long l) {
        this.bytesProcessed = l;
    }

    public void setBytesReturned(Long l) {
        this.bytesReturned = l;
    }

    public void setBytesScanned(Long l) {
        this.bytesScanned = l;
    }

    public Stats withBytesProcessed(Long l) {
        setBytesProcessed(l);
        return this;
    }

    public Stats withBytesReturned(Long l) {
        setBytesReturned(l);
        return this;
    }

    public Stats withBytesScanned(Long l) {
        setBytesScanned(l);
        return this;
    }
}
