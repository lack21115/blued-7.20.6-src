package com.tencent.map.sdk.comps.mylocation;

import android.location.Location;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/mylocation/IMyLocation.class */
public interface IMyLocation {
    Location getMyLocation();

    boolean isMyLocationEnabled();

    void setLocationSource(LocationSource locationSource);

    void setMyLocationClickListener(TencentMap.OnMyLocationClickListener onMyLocationClickListener);

    void setMyLocationEnabled(boolean z);

    void setMyLocationStyle(MyLocationStyle myLocationStyle);

    void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener);
}
