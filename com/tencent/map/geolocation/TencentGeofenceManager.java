package com.tencent.map.geolocation;

import android.app.PendingIntent;
import android.content.Context;
import c.t.m.g.a4;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentGeofenceManager.class */
public class TencentGeofenceManager {

    /* renamed from: a  reason: collision with root package name */
    public a4 f23560a;

    public TencentGeofenceManager(Context context) {
        if (TencentLocationManager.getUserAgreePrivacy()) {
            this.f23560a = new a4(context);
        }
    }

    public void addFence(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        if (TencentLocationManager.getUserAgreePrivacy()) {
            this.f23560a.a(tencentGeofence, pendingIntent);
        }
    }

    public void destroy() {
        if (TencentLocationManager.getUserAgreePrivacy()) {
            this.f23560a.d();
        }
    }

    public void removeAllFences() {
        if (TencentLocationManager.getUserAgreePrivacy()) {
            this.f23560a.h();
        }
    }

    public void removeFence(TencentGeofence tencentGeofence) {
        if (TencentLocationManager.getUserAgreePrivacy()) {
            this.f23560a.a(tencentGeofence);
        }
    }

    public void removeFence(String str) {
        if (TencentLocationManager.getUserAgreePrivacy()) {
            this.f23560a.c(str);
        }
    }
}
