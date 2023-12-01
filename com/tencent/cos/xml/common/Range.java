package com.tencent.cos.xml.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/Range.class */
public class Range {
    private long end;
    private long start;

    public Range(long j) {
        this(j, -1L);
    }

    public Range(long j, long j2) {
        this.start = j;
        this.end = j2;
    }

    public long getEnd() {
        return this.end;
    }

    public String getRange() {
        long j = this.start;
        long j2 = this.end;
        return String.format("bytes=%s-%s", Long.valueOf(j), j2 == -1 ? "" : String.valueOf(j2));
    }

    public long getStart() {
        return this.start;
    }
}
