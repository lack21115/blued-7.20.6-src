package com.tencent.map.lib.models;

import com.igexin.push.core.b;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/PolygonInfo.class */
public class PolygonInfo {
    public int borderColor;
    public int borderLineId;
    public float borderWidth;
    public int color;
    public int minScaleLevel;
    public int[] pattern;
    public LatLng[] points;
    public int polygonId;
    public String textureName;
    public int textureSpacing;
    public float zIndex = 0.0f;
    public int level = 2;
    public int maxScaleLevel = 30;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Polygon2D{");
        stringBuffer.append(", color=");
        stringBuffer.append(this.color);
        stringBuffer.append(", borderColor=");
        stringBuffer.append(this.borderColor);
        stringBuffer.append(", borderWidth=");
        stringBuffer.append(this.borderWidth);
        stringBuffer.append(", points=");
        LatLng[] latLngArr = this.points;
        stringBuffer.append(latLngArr == null ? b.l : Integer.valueOf(latLngArr.length));
        stringBuffer.append(", polygonId=");
        stringBuffer.append(this.polygonId);
        stringBuffer.append(", borderLineId=");
        stringBuffer.append(this.borderLineId);
        stringBuffer.append(", zIndex=");
        stringBuffer.append(this.zIndex);
        stringBuffer.append(", level=");
        stringBuffer.append(this.level);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
