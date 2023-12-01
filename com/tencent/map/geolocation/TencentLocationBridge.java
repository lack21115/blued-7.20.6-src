package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentLocationBridge.class */
public interface TencentLocationBridge {
    String getBuild();

    int getCoordinateType();

    TencentLocation getLastKnownLocation();

    TencentLocation getPosition();

    String getVersion();

    void init(Context context);

    boolean isSupport();

    void removeUpdates(TencentLocationListener tencentLocationListener);

    int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper);

    int requestLocationWithScene(int i, TencentLocationListener tencentLocationListener);

    int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper);

    void setCoordinateType(int i);

    void setDebuggable(boolean z);

    void setDeviceID(Context context, String str);

    int startDrEngine(int i);

    boolean startIndoorLocation();

    boolean stopIndoorLocation();

    void stopLocationWithScene(int i, TencentLocationListener tencentLocationListener);

    void terminateDrEngine();

    void triggerCodeGuarder(boolean z);
}
