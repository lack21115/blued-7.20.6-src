package com.autonavi.base.amap.mapcore;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/FPoint3.class */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public FPoint3(float f, float f2, int i) {
        super(f, f2);
        this.colorIndex = -1;
        this.colorIndex = i;
    }

    public void setColorIndex(int i) {
        this.colorIndex = i;
    }
}
