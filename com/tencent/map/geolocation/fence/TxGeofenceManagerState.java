package com.tencent.map.geolocation.fence;

import com.tencent.map.geolocation.TencentLocation;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/fence/TxGeofenceManagerState.class */
public interface TxGeofenceManagerState {
    void add(int i, TencentLocation tencentLocation);

    long getLastInterval();

    TencentLocation getLastLocation();

    long getLastLocationTime();

    Map<String, String> getLastSummary();

    String getLocationTimes();

    List<TencentLocation> getLocations();

    long getNextLocationTime();

    double getSpeed();

    List<Map<String, String>> getSummary();

    void reset();
}
