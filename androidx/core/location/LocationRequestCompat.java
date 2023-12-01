package androidx.core.location;

import android.location.LocationRequest;
import android.os.Build;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationRequestCompat.class */
public final class LocationRequestCompat {
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Method k;
    private static Method l;

    /* renamed from: a  reason: collision with root package name */
    final int f2500a;
    final long b;

    /* renamed from: c  reason: collision with root package name */
    final long f2501c;
    final long d;
    final int e;
    final float f;
    final long g;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationRequestCompat$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f2502a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private long f2503c;
        private int d;
        private long e;
        private float f;
        private long g;

        public Builder(long j) {
            setIntervalMillis(j);
            this.b = 102;
            this.f2503c = Long.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            this.e = -1L;
            this.f = 0.0f;
            this.g = 0L;
        }

        public Builder(LocationRequestCompat locationRequestCompat) {
            this.f2502a = locationRequestCompat.b;
            this.b = locationRequestCompat.f2500a;
            this.f2503c = locationRequestCompat.d;
            this.d = locationRequestCompat.e;
            this.e = locationRequestCompat.f2501c;
            this.f = locationRequestCompat.f;
            this.g = locationRequestCompat.g;
        }

        public LocationRequestCompat build() {
            Preconditions.checkState((this.f2502a == Long.MAX_VALUE && this.e == -1) ? false : true, "passive location requests must have an explicit minimum update interval");
            long j = this.f2502a;
            return new LocationRequestCompat(j, this.b, this.f2503c, this.d, Math.min(this.e, j), this.f, this.g);
        }

        public Builder clearMinUpdateIntervalMillis() {
            this.e = -1L;
            return this;
        }

        public Builder setDurationMillis(long j) {
            this.f2503c = Preconditions.checkArgumentInRange(j, 1L, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        public Builder setIntervalMillis(long j) {
            this.f2502a = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long j) {
            this.g = j;
            this.g = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        public Builder setMaxUpdates(int i) {
            this.d = Preconditions.checkArgumentInRange(i, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float f) {
            this.f = f;
            this.f = Preconditions.checkArgumentInRange(f, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long j) {
            this.e = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        public Builder setQuality(int i) {
            Preconditions.checkArgument(i == 104 || i == 102 || i == 100, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i));
            this.b = i;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationRequestCompat$Quality.class */
    public @interface Quality {
    }

    LocationRequestCompat(long j2, int i2, long j3, int i3, long j4, float f, long j5) {
        this.b = j2;
        this.f2500a = i2;
        this.f2501c = j4;
        this.d = j3;
        this.e = i3;
        this.f = f;
        this.g = j5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationRequestCompat) {
            LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
            return this.f2500a == locationRequestCompat.f2500a && this.b == locationRequestCompat.b && this.f2501c == locationRequestCompat.f2501c && this.d == locationRequestCompat.d && this.e == locationRequestCompat.e && Float.compare(locationRequestCompat.f, this.f) == 0 && this.g == locationRequestCompat.g;
        }
        return false;
    }

    public long getDurationMillis() {
        return this.d;
    }

    public long getIntervalMillis() {
        return this.b;
    }

    public long getMaxUpdateDelayMillis() {
        return this.g;
    }

    public int getMaxUpdates() {
        return this.e;
    }

    public float getMinUpdateDistanceMeters() {
        return this.f;
    }

    public long getMinUpdateIntervalMillis() {
        long j2 = this.f2501c;
        long j3 = j2;
        if (j2 == -1) {
            j3 = this.b;
        }
        return j3;
    }

    public int getQuality() {
        return this.f2500a;
    }

    public int hashCode() {
        int i2 = this.f2500a;
        long j2 = this.b;
        int i3 = (int) (j2 ^ (j2 >>> 32));
        long j3 = this.f2501c;
        return (((i2 * 31) + i3) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    public LocationRequest toLocationRequest() {
        return new LocationRequest.Builder(this.b).setQuality(this.f2500a).setMinUpdateIntervalMillis(this.f2501c).setDurationMillis(this.d).setMaxUpdates(this.e).setMinUpdateDistanceMeters(this.f).setMaxUpdateDelayMillis(this.g).build();
    }

    public LocationRequest toLocationRequest(String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return toLocationRequest();
        }
        try {
            if (h == null) {
                Method declaredMethod = LocationRequest.class.getDeclaredMethod("createFromDeprecatedProvider", String.class, Long.TYPE, Float.TYPE, Boolean.TYPE);
                h = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            LocationRequest locationRequest = (LocationRequest) h.invoke(null, str, Long.valueOf(this.b), Float.valueOf(this.f), false);
            if (locationRequest == null) {
                return null;
            }
            if (i == null) {
                Method declaredMethod2 = LocationRequest.class.getDeclaredMethod("setQuality", Integer.TYPE);
                i = declaredMethod2;
                declaredMethod2.setAccessible(true);
            }
            i.invoke(locationRequest, Integer.valueOf(this.f2500a));
            if (getMinUpdateIntervalMillis() != this.b) {
                if (j == null) {
                    Method declaredMethod3 = LocationRequest.class.getDeclaredMethod("setFastestInterval", Long.TYPE);
                    j = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                j.invoke(locationRequest, Long.valueOf(this.f2501c));
            }
            if (this.e < Integer.MAX_VALUE) {
                if (k == null) {
                    Method declaredMethod4 = LocationRequest.class.getDeclaredMethod("setNumUpdates", Integer.TYPE);
                    k = declaredMethod4;
                    declaredMethod4.setAccessible(true);
                }
                k.invoke(locationRequest, Integer.valueOf(this.e));
            }
            if (this.d < Long.MAX_VALUE) {
                if (l == null) {
                    Method declaredMethod5 = LocationRequest.class.getDeclaredMethod("setExpireIn", Long.TYPE);
                    l = declaredMethod5;
                    declaredMethod5.setAccessible(true);
                }
                l.invoke(locationRequest, Long.valueOf(this.d));
            }
            return locationRequest;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (this.b != Long.MAX_VALUE) {
            sb.append("@");
            TimeUtils.formatDuration(this.b, sb);
            int i2 = this.f2500a;
            if (i2 == 100) {
                sb.append(" HIGH_ACCURACY");
            } else if (i2 == 102) {
                sb.append(" BALANCED");
            } else if (i2 == 104) {
                sb.append(" LOW_POWER");
            }
        } else {
            sb.append("PASSIVE");
        }
        if (this.d != Long.MAX_VALUE) {
            sb.append(", duration=");
            TimeUtils.formatDuration(this.d, sb);
        }
        if (this.e != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.e);
        }
        long j2 = this.f2501c;
        if (j2 != -1 && j2 < this.b) {
            sb.append(", minUpdateInterval=");
            TimeUtils.formatDuration(this.f2501c, sb);
        }
        if (this.f > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.f);
        }
        if (this.g / 2 > this.b) {
            sb.append(", maxUpdateDelay=");
            TimeUtils.formatDuration(this.g, sb);
        }
        sb.append(']');
        return sb.toString();
    }
}
