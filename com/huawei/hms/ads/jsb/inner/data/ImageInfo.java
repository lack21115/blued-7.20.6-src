package com.huawei.hms.ads.jsb.inner.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bm;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/inner/data/ImageInfo.class */
public class ImageInfo {
    private int fileSize;
    private int height;
    private String imageType;
    private String url;
    private int width;

    public ImageInfo(com.huawei.openalliance.ad.beans.metadata.ImageInfo imageInfo) {
        this.width = 0;
        this.height = 0;
        if (imageInfo != null) {
            String I = imageInfo.I();
            this.url = I;
            if (!TextUtils.isEmpty(I) && !this.url.startsWith(bm.HTTP.toString()) && !this.url.startsWith(bm.HTTPS.toString())) {
                this.url = imageInfo.F();
            }
            this.width = imageInfo.Z();
            this.height = imageInfo.B();
            this.imageType = imageInfo.V();
            this.fileSize = imageInfo.C();
        }
    }
}
