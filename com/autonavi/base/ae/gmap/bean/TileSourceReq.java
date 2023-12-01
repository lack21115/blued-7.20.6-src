package com.autonavi.base.ae.gmap.bean;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/bean/TileSourceReq.class */
public class TileSourceReq {
    public int sourceType;
    public int x;
    public int y;
    public int zoom;

    public String toString() {
        return "TileSourceReq{x=" + this.x + ", y=" + this.y + ", zoom=" + this.zoom + ", sourceId=" + this.sourceType + '}';
    }
}
