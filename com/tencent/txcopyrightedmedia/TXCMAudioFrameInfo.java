package com.tencent.txcopyrightedmedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/TXCMAudioFrameInfo.class */
public class TXCMAudioFrameInfo {
    final int REUSE_TIMES;
    public String frameId;
    public int size;
    public long timestamp;

    public TXCMAudioFrameInfo() {
        this.REUSE_TIMES = 1;
    }

    public TXCMAudioFrameInfo(int i) {
        this.REUSE_TIMES = i;
    }
}
