package com.tencent.map.geolocation;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentGeofence.class */
public class TencentGeofence {

    /* renamed from: a  reason: collision with root package name */
    public final int f37247a;
    public final double b;

    /* renamed from: c  reason: collision with root package name */
    public final double f37248c;
    public final float d;
    public final long e;
    public final String f;
    public final long g;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/TencentGeofence$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public double f37249a;
        public double b;

        /* renamed from: c  reason: collision with root package name */
        public float f37250c;
        public long d;
        public String e;

        public static void a(double d, double d2) {
            if (d > 90.0d || d < -90.0d) {
                throw new IllegalArgumentException("invalid latitude: " + d);
            } else if (d2 > 180.0d || d2 < -180.0d) {
                throw new IllegalArgumentException("invalid longitude: " + d2);
            }
        }

        public static void a(float f) {
            if (f > 0.0f) {
                return;
            }
            throw new IllegalArgumentException("invalid radius: " + f);
        }

        public static void a(long j) {
            if (j >= 0) {
                return;
            }
            throw new IllegalArgumentException("invalid duration: " + j);
        }

        public TencentGeofence build() {
            return new TencentGeofence(0, this.f37249a, this.b, this.f37250c, this.d, this.e);
        }

        public Builder setCircularRegion(double d, double d2, float f) {
            a(f);
            a(d, d2);
            this.f37249a = d;
            this.b = d2;
            this.f37250c = f;
            return this;
        }

        public Builder setExpirationDuration(long j) {
            a(j);
            this.d = j;
            return this;
        }

        public Builder setTag(String str) {
            if (TextUtils.isEmpty(str)) {
                throw null;
            }
            this.e = str;
            return this;
        }
    }

    public TencentGeofence(int i, double d, double d2, float f, long j, String str) {
        this.f37247a = i;
        this.b = d;
        this.f37248c = d2;
        this.d = f;
        this.g = j;
        this.e = SystemClock.elapsedRealtime() + j;
        this.f = str;
    }

    public static void a(int i) {
        if (i == 0) {
            return;
        }
        throw new IllegalArgumentException("invalid type: " + i);
    }

    public static String b(int i) {
        if (i != 0) {
            a(i);
            return null;
        }
        return "CIRCLE";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TencentGeofence.class == obj.getClass()) {
            TencentGeofence tencentGeofence = (TencentGeofence) obj;
            if (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(tencentGeofence.b) && Double.doubleToLongBits(this.f37248c) == Double.doubleToLongBits(tencentGeofence.f37248c)) {
                String str = this.f;
                return str == null ? tencentGeofence.f == null : str.equals(tencentGeofence.f);
            }
            return false;
        }
        return false;
    }

    public long getDuration() {
        return this.g;
    }

    public long getExpireAt() {
        return this.e;
    }

    public double getLatitude() {
        return this.b;
    }

    public double getLongitude() {
        return this.f37248c;
    }

    public float getRadius() {
        return this.d;
    }

    public String getTag() {
        return this.f;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.f37248c);
        int i2 = (int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32));
        String str = this.f;
        return ((((i + 31) * 31) + i2) * 31) + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return String.format(Locale.US, "TencentGeofence[tag=%s, type=%s, loc=(%.6f, %.6f), radius=%.2fm life=%.2fs]", this.f, b(this.f37247a), Double.valueOf(this.b), Double.valueOf(this.f37248c), Float.valueOf(this.d), Double.valueOf((this.e - SystemClock.elapsedRealtime()) / 1000.0d));
    }
}
