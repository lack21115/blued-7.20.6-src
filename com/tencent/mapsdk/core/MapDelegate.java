package com.tencent.mapsdk.core;

import android.view.ViewGroup;
import com.tencent.mapsdk.internal.x1;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/MapDelegate.class */
public interface MapDelegate<C extends TencentMapContext, M extends TencentMap, V extends x1> extends BaseMapView.MapViewProxy {
    M createMap(C c2);

    V createMapView(C c2, ViewGroup viewGroup);

    C getMapContext();

    V getMapRenderView();
}
