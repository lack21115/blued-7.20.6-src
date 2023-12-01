package com.autonavi.base.ae.gmap;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/AMapAppRequestParam.class */
public class AMapAppRequestParam {
    public static final int RESOURCE_TYPE_ABSPATH = 4;
    public static final int RESOURCE_TYPE_BINARY = 3;
    public static final int RESOURCE_TYPE_IMAGE = 1;
    public static final int RESOURCE_TYPE_NONE = 0;
    public static final int RESOURCE_TYPE_SVG = 2;
    private ResourceCallback callback;
    private String url;
    private int resourceType = 0;
    private long contextId = 0;
    private int expectWidth = 0;
    private int expectHeight = 0;

    public void generateCallback(long j, int i) {
        this.callback = new ResourceCallback(j, i);
    }

    public ResourceCallback getCallback() {
        return this.callback;
    }

    public long getContextId() {
        return this.contextId;
    }

    public int getExpectHeight() {
        return this.expectHeight;
    }

    public int getExpectWidth() {
        return this.expectWidth;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCallback(ResourceCallback resourceCallback) {
        this.callback = resourceCallback;
    }

    public void setContextId(long j) {
        this.contextId = j;
    }

    public void setExpectHeight(int i) {
        this.expectHeight = i;
    }

    public void setExpectWidth(int i) {
        this.expectWidth = i;
    }

    public void setResourceType(int i) {
        this.resourceType = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
