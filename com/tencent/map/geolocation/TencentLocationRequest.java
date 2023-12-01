package com.tencent.map.geolocation;

import android.os.Bundle;
import android.text.TextUtils;
import c.t.m.g.h5;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentLocationRequest.class */
public final class TencentLocationRequest {
    public static final int GNSS_SOURCE_BEIDOU_FIRST = 21;
    public static final int GNSS_SOURCE_GPS_FIRST = 20;
    public static final int HIGH_ACCURACY_MODE = 10;
    public static final int ONLY_GPS_MODE = 12;
    public static final int ONLY_GPS_TIME_OUT = 8000;
    public static final int ONLY_NETWORK_MODE = 11;
    public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
    public static final int REQUEST_LEVEL_GEO = 0;
    public static final int REQUEST_LEVEL_NAME = 1;
    public static final int REQUEST_LEVEL_POI = 4;

    /* renamed from: a  reason: collision with root package name */
    public long f23565a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23566c;
    public boolean d;
    public boolean e;
    public boolean f;
    public long g;
    public int h;
    public int i;
    public String j;
    public String k;
    public Bundle l;
    public int m;
    public boolean n;
    public int o;

    public TencentLocationRequest() {
    }

    public TencentLocationRequest(TencentLocationRequest tencentLocationRequest) {
        this.f23565a = tencentLocationRequest.f23565a;
        this.b = tencentLocationRequest.b;
        this.d = tencentLocationRequest.d;
        this.e = tencentLocationRequest.e;
        this.g = tencentLocationRequest.g;
        this.h = tencentLocationRequest.h;
        this.f23566c = tencentLocationRequest.f23566c;
        this.i = tencentLocationRequest.i;
        this.f = tencentLocationRequest.f;
        this.k = tencentLocationRequest.k;
        this.j = tencentLocationRequest.j;
        Bundle bundle = new Bundle();
        this.l = bundle;
        bundle.putAll(tencentLocationRequest.l);
        setLocMode(tencentLocationRequest.m);
        this.n = tencentLocationRequest.n;
        this.o = tencentLocationRequest.o;
    }

    public static void copy(TencentLocationRequest tencentLocationRequest, TencentLocationRequest tencentLocationRequest2) {
        tencentLocationRequest.f23565a = tencentLocationRequest2.f23565a;
        tencentLocationRequest.b = tencentLocationRequest2.b;
        tencentLocationRequest.d = tencentLocationRequest2.d;
        tencentLocationRequest.e = tencentLocationRequest2.e;
        tencentLocationRequest.g = tencentLocationRequest2.g;
        tencentLocationRequest.i = tencentLocationRequest2.i;
        tencentLocationRequest.h = tencentLocationRequest2.h;
        tencentLocationRequest.f = tencentLocationRequest2.f;
        tencentLocationRequest.f23566c = tencentLocationRequest2.f23566c;
        tencentLocationRequest.k = tencentLocationRequest2.k;
        tencentLocationRequest.j = tencentLocationRequest2.j;
        tencentLocationRequest.l.clear();
        tencentLocationRequest.l.putAll(tencentLocationRequest2.l);
        tencentLocationRequest.m = tencentLocationRequest2.m;
        tencentLocationRequest.n = tencentLocationRequest2.n;
        tencentLocationRequest.o = tencentLocationRequest2.o;
    }

    public static TencentLocationRequest create() {
        TencentLocationRequest tencentLocationRequest = new TencentLocationRequest();
        tencentLocationRequest.f23565a = 5000L;
        tencentLocationRequest.b = 3;
        tencentLocationRequest.d = true;
        tencentLocationRequest.e = false;
        tencentLocationRequest.i = 20;
        tencentLocationRequest.f = false;
        tencentLocationRequest.g = Long.MAX_VALUE;
        tencentLocationRequest.h = Integer.MAX_VALUE;
        tencentLocationRequest.f23566c = true;
        tencentLocationRequest.k = "";
        tencentLocationRequest.j = "";
        tencentLocationRequest.l = new Bundle();
        tencentLocationRequest.m = 10;
        tencentLocationRequest.n = false;
        tencentLocationRequest.o = 5000;
        return tencentLocationRequest;
    }

    public Bundle getExtras() {
        return this.l;
    }

    public int getGnssSource() {
        return this.i;
    }

    public int getGpsFirstTimeOut() {
        return this.o;
    }

    public long getInterval() {
        return this.f23565a;
    }

    public int getLocMode() {
        return this.m;
    }

    public String getPhoneNumber() {
        String string = this.l.getString("phoneNumber");
        String str = string;
        if (string == null) {
            str = "";
        }
        return str;
    }

    public String getQQ() {
        return this.k;
    }

    public int getRequestLevel() {
        return this.b;
    }

    public String getSmallAppKey() {
        return this.j;
    }

    public boolean isAllowCache() {
        return this.d;
    }

    public boolean isAllowDirection() {
        return this.e;
    }

    public boolean isAllowGPS() {
        return this.f23566c;
    }

    public boolean isGpsFirst() {
        return this.n;
    }

    public boolean isIndoorLocationMode() {
        return this.f;
    }

    public TencentLocationRequest setAllowCache(boolean z) {
        this.d = z;
        return this;
    }

    public TencentLocationRequest setAllowDirection(boolean z) {
        this.e = z;
        return this;
    }

    public TencentLocationRequest setAllowGPS(boolean z) {
        if (this.b == 10) {
            this.f23566c = z;
        }
        return this;
    }

    public TencentLocationRequest setGnssSource(int i) {
        if (i == 21 || i == 20) {
            this.i = i;
            return this;
        }
        throw new IllegalArgumentException("gnss_source: " + i + " not supported!");
    }

    public TencentLocationRequest setGpsFirst(boolean z) {
        this.n = z;
        this.f23566c = z || this.f23566c;
        return this;
    }

    public TencentLocationRequest setGpsFirstTimeOut(int i) {
        if (i >= 60000) {
            this.o = 60000;
            return this;
        } else if (i >= 0) {
            this.o = i;
            return this;
        } else {
            throw new IllegalArgumentException("GpsFirstTimeOut illegalArgument, time should 0");
        }
    }

    public TencentLocationRequest setIndoorLocationMode(boolean z) {
        this.f = z;
        return this;
    }

    public TencentLocationRequest setInterval(long j) {
        if (j >= 0) {
            this.f23565a = j;
            return this;
        }
        throw new IllegalArgumentException("interval should >= 0");
    }

    public TencentLocationRequest setLocMode(int i) {
        if (!h5.b(i)) {
            throw new IllegalArgumentException("locMode: " + i + " not supported!");
        }
        this.m = i;
        if (i == 11) {
            this.f23566c = false;
            return this;
        }
        if (i == 12) {
            this.f23566c = true;
        }
        return this;
    }

    public TencentLocationRequest setPhoneNumber(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        this.l.putString("phoneNumber", str2);
        return this;
    }

    public TencentLocationRequest setQQ(String str) {
        this.k = str;
        return this;
    }

    public TencentLocationRequest setRequestLevel(int i) {
        if (h5.a(i)) {
            this.b = i;
            return this;
        }
        throw new IllegalArgumentException("request_level: " + i + " not supported!");
    }

    public TencentLocationRequest setSmallAppKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.j = str;
        }
        return this;
    }

    public String toString() {
        return "TencentLocationRequest {interval = " + this.f23565a + "ms , level = " + this.b + ", LocMode = " + this.m + ", allowGps = " + this.f23566c + ", isGPsFirst = " + this.n + ", GpsFirstTimeOut = " + this.o + ", allowDirection = " + this.e + ", isIndoorMode = " + this.f + ", QQ = " + this.k + "}";
    }
}
