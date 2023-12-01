package com.tencent.map.sdk.comps.indoor;

import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/indoor/IIndoor.class */
public interface IIndoor {
    @Deprecated
    String getActivedIndoorBuilding(LatLng latLng);

    String[] getActivedIndoorFloorNames();

    int getIndoorFloorId();

    void resetIndoorCellInfo();

    void setIndoorCellInfo(List<IndoorCellInfo> list);

    void setIndoorEnabled(boolean z);

    void setIndoorFloor(int i);

    void setIndoorFloor(String str, String str2);

    void setIndoorMaskColor(int i);

    void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener);
}
