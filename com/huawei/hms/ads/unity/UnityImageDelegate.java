package com.huawei.hms.ads.unity;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.huawei.hms.ads.Image;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/unity/UnityImageDelegate.class */
public class UnityImageDelegate {
    private Image Code;
    private Drawable V;

    public UnityImageDelegate(Image image) {
        this.Code = image;
    }

    public Drawable getDrawable() {
        return this.V;
    }

    public Uri getUri() {
        Image image = this.Code;
        if (image != null) {
            return image.getUri();
        }
        return null;
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.V = drawable;
        }
    }
}
