package com.autonavi.aps.amapapi.filters;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.utils.i;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/filters/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    com.autonavi.aps.amapapi.model.a f6396a = null;
    long b = 0;

    /* renamed from: c  reason: collision with root package name */
    long f6397c = 0;
    private boolean h = true;
    int d = 0;
    long e = 0;
    AMapLocation f = null;
    long g = 0;

    private com.autonavi.aps.amapapi.model.a b(com.autonavi.aps.amapapi.model.a aVar) {
        if (i.a(aVar)) {
            if (!this.h || !com.autonavi.aps.amapapi.utils.a.a(aVar.getTime())) {
                aVar.setLocationType(this.d);
            } else if (aVar.getLocationType() == 5 || aVar.getLocationType() == 6) {
                aVar.setLocationType(4);
                return aVar;
            }
        }
        return aVar;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (i.a(aMapLocation)) {
            long b = i.b();
            long j = this.g;
            this.g = i.b();
            if (b - j > 5000) {
                return aMapLocation;
            }
            AMapLocation aMapLocation2 = this.f;
            if (aMapLocation2 == null) {
                this.f = aMapLocation;
                return aMapLocation;
            } else if (1 != aMapLocation2.getLocationType() && !"gps".equalsIgnoreCase(this.f.getProvider())) {
                this.f = aMapLocation;
                return aMapLocation;
            } else if (this.f.getAltitude() == aMapLocation.getAltitude() && this.f.getLongitude() == aMapLocation.getLongitude()) {
                this.f = aMapLocation;
                return aMapLocation;
            } else {
                long abs = Math.abs(aMapLocation.getTime() - this.f.getTime());
                if (30000 < abs) {
                    this.f = aMapLocation;
                    return aMapLocation;
                }
                if (i.a(aMapLocation, this.f) > (((this.f.getSpeed() + aMapLocation.getSpeed()) * ((float) abs)) / 2000.0f) + ((this.f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
                    return this.f;
                }
                this.f = aMapLocation;
                return aMapLocation;
            }
        }
        return aMapLocation;
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        if (i.b() - this.e > 30000) {
            this.f6396a = aVar;
            this.e = i.b();
            return this.f6396a;
        }
        this.e = i.b();
        if (!i.a(this.f6396a) || !i.a(aVar)) {
            this.b = i.b();
            this.f6396a = aVar;
            return aVar;
        } else if (aVar.getTime() != this.f6396a.getTime() || aVar.getAccuracy() >= 300.0f) {
            if ("gps".equals(aVar.getProvider())) {
                this.b = i.b();
                this.f6396a = aVar;
                return aVar;
            } else if (aVar.c() != this.f6396a.c()) {
                this.b = i.b();
                this.f6396a = aVar;
                return aVar;
            } else if (aVar.getBuildingId() != null && !aVar.getBuildingId().equals(this.f6396a.getBuildingId()) && !TextUtils.isEmpty(aVar.getBuildingId())) {
                this.b = i.b();
                this.f6396a = aVar;
                return aVar;
            } else {
                this.d = aVar.getLocationType();
                float a2 = i.a(aVar, this.f6396a);
                float accuracy = this.f6396a.getAccuracy();
                float accuracy2 = aVar.getAccuracy();
                float f = accuracy2 - accuracy;
                long b = i.b();
                long j = this.b;
                boolean z = true;
                boolean z2 = accuracy <= 100.0f && accuracy2 > 299.0f;
                int i = (accuracy > 299.0f ? 1 : (accuracy == 299.0f ? 0 : -1));
                if (i <= 0 || accuracy2 <= 299.0f) {
                    z = false;
                }
                if (z2 || z) {
                    long j2 = this.f6397c;
                    if (j2 == 0) {
                        this.f6397c = b;
                    } else if (b - j2 > 30000) {
                        this.b = b;
                        this.f6396a = aVar;
                        this.f6397c = 0L;
                        return aVar;
                    }
                    com.autonavi.aps.amapapi.model.a b2 = b(this.f6396a);
                    this.f6396a = b2;
                    return b2;
                } else if (accuracy2 < 100.0f && i > 0) {
                    this.b = b;
                    this.f6396a = aVar;
                    this.f6397c = 0L;
                    return aVar;
                } else {
                    if (accuracy2 <= 299.0f) {
                        this.f6397c = 0L;
                    }
                    if (a2 >= 10.0f || a2 <= 0.1d || accuracy2 <= 5.0f) {
                        if (f < 300.0f) {
                            this.b = i.b();
                            this.f6396a = aVar;
                            return aVar;
                        } else if (b - j >= 30000) {
                            this.b = i.b();
                            this.f6396a = aVar;
                            return aVar;
                        } else {
                            com.autonavi.aps.amapapi.model.a b3 = b(this.f6396a);
                            this.f6396a = b3;
                            return b3;
                        }
                    } else if (f >= -300.0f) {
                        com.autonavi.aps.amapapi.model.a b4 = b(this.f6396a);
                        this.f6396a = b4;
                        return b4;
                    } else if (accuracy / accuracy2 >= 2.0f) {
                        this.b = b;
                        this.f6396a = aVar;
                        return aVar;
                    } else {
                        com.autonavi.aps.amapapi.model.a b5 = b(this.f6396a);
                        this.f6396a = b5;
                        return b5;
                    }
                }
            }
        } else {
            return aVar;
        }
    }

    public final void a() {
        this.f6396a = null;
        this.b = 0L;
        this.f6397c = 0L;
        this.f = null;
        this.g = 0L;
    }

    public final void a(boolean z) {
        this.h = z;
    }
}
