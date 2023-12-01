package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/MapFontSize.class */
public enum MapFontSize {
    tiny(0, 4),
    small(1, 3),
    normal(2, 0),
    large(3, 1),
    huge(4, 2);
    
    private int engineCode;
    private int fontSize;

    MapFontSize(int i, int i2) {
        this.fontSize = i;
        this.engineCode = i2;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public int getValue() {
        return this.engineCode;
    }
}
