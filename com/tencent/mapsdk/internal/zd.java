package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/zd.class */
public interface zd {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38161a = "compass.png";
    public static final String b = "compass_dark.png";

    String a(GeoPoint geoPoint);

    void a(String str, IconImageInfo iconImageInfo);

    void setOptionalResourcePath(String str);
}
