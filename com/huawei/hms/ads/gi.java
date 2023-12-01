package com.huawei.hms.ads;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gi.class */
public abstract class gi {
    public static final int Code = 3;
    public static final int I = 5;
    public static final int V = 4;
    public static final int Z = 6;

    public static String Code(int i) {
        return i != 3 ? i != 4 ? i != 5 ? i != 6 ? String.valueOf(i) : ExifInterface.LONGITUDE_EAST : "W" : "I" : "D";
    }
}
