package com.tencent.rtmp;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXBitrateItem.class */
public class TXBitrateItem implements Comparable<TXBitrateItem> {
    public int bitrate;
    public int height;
    public int index;
    public int width;

    @Override // java.lang.Comparable
    public int compareTo(TXBitrateItem tXBitrateItem) {
        return this.bitrate - tXBitrateItem.bitrate;
    }
}
