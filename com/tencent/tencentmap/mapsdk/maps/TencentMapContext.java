package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/TencentMapContext.class */
public interface TencentMapContext extends TencentMapComponent, TencentMapResource {
    Context getContext();

    TencentMapComponent getMapComponent();

    TencentMapResource getMapResource();
}
