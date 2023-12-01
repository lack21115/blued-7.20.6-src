package com.autonavi.base.ae.gmap;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/AMapAppResourceItem.class */
public class AMapAppResourceItem {
    public static final int RESOURCE_TYPE_ABSPATH = 4;
    public static final int RESOURCE_TYPE_BINARY = 3;
    public static final int RESOURCE_TYPE_IMAGE = 1;
    public static final int RESOURCE_TYPE_NONE = 0;
    public static final int RESOURCE_TYPE_SVG = 2;
    private byte[] data;
    private long size;
    private int resourceType = 0;
    private boolean preAlpha = false;
    private int imageWidth = 0;
    private int imageHeight = 0;
    private float imageScale = 1.0f;

    public byte[] getData() {
        return this.data;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public float getImageScale() {
        return this.imageScale;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isPreAlpha() {
        return this.preAlpha;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setImageHeight(int i) {
        this.imageHeight = i;
    }

    public void setImageScale(float f) {
        this.imageScale = f;
    }

    public void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public void setPreAlpha(boolean z) {
        this.preAlpha = z;
    }

    public void setResourceType(int i) {
        this.resourceType = i;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
