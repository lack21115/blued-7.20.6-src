package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.c;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/v3/openrtb/Image.class */
public class Image implements Serializable {
    private static final long serialVersionUID = 3793768731771300290L;
    @c(Code = "Ext")
    private ImageExt ext;
    @c(Code = "H")
    private int height;
    private String localPath;
    private String url;
    @c(Code = "W")
    private int width;

    public String B() {
        return this.localPath;
    }

    public String Code() {
        return this.url;
    }

    public void Code(int i) {
        this.width = i;
    }

    public void Code(ImageExt imageExt) {
        this.ext = imageExt;
    }

    public void Code(String str) {
        this.url = str;
    }

    public int I() {
        return this.height;
    }

    public int V() {
        return this.width;
    }

    public void V(int i) {
        this.height = i;
    }

    public void V(String str) {
        this.localPath = str;
    }

    public ImageExt Z() {
        return this.ext;
    }
}
