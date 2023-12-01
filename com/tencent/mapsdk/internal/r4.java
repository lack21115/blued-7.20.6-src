package com.tencent.mapsdk.internal;

import android.view.View;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r4.class */
public interface r4 extends u4 {

    /* renamed from: c  reason: collision with root package name */
    public static final String f37733c = "tencent_map_infowindow_view";
    public static final String d = "tencent_map_infowindow_content_title";
    public static final String e = "tencent_map_infowindow_content_snippet";

    void a(MarkerOptions markerOptions);

    void e(boolean z);

    void k();

    View o();

    boolean r();

    void setAnchor(float f, float f2);

    void setFixingPoint(int i, int i2);

    void setFixingPointEnable(boolean z);

    void setPosition(LatLng latLng);

    void u();

    void w();
}
