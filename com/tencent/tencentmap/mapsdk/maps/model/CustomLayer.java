package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/CustomLayer.class */
public interface CustomLayer extends Removable, IOverlay {
    void clearDiskCache();

    void reload();
}
