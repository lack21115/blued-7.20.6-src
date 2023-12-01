package com.tencent.youtu.ytposedetect.data;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytposedetect/data/YTActRefData.class */
public class YTActRefData {
    public YTActRefImage best;
    public YTActRefImage eye;
    public YTActRefImage mouth;

    public boolean isEmpty() {
        return this.eye == null && this.mouth == null && this.best == null;
    }

    public String toString() {
        return "YTActRefData{eye=" + this.eye + ", mouth=" + this.mouth + ", best=" + this.best + '}';
    }
}
