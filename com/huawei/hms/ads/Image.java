package com.huawei.hms.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/Image.class */
public abstract class Image {
    public abstract Drawable getDrawable();

    public int getHeight() {
        return -1;
    }

    public abstract double getScale();

    public abstract Uri getUri();

    public int getWidth() {
        return -1;
    }
}
