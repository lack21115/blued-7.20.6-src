package com.tencent.youtu.ytposedetect.data;

import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytposedetect/data/YTActRefImage.class */
public class YTActRefImage {
    public String checksum;
    public byte[] image;
    public float[] xys;

    public String toString() {
        return "YTActRefImage{image=" + Arrays.toString(this.image) + ", xys=" + Arrays.toString(this.xys) + ", checksum='" + this.checksum + "'}";
    }
}
