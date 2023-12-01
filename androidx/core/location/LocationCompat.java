package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationCompat.class */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";

    /* renamed from: a  reason: collision with root package name */
    private static Method f2438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationCompat$Api17Impl.class */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static long a(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationCompat$Api18Impl.class */
    static class Api18Impl {
        private Api18Impl() {
        }

        static boolean a(Location location) {
            return location.isFromMockProvider();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/location/LocationCompat$Api26Impl.class */
    static class Api26Impl {
        private Api26Impl() {
        }

        static void a(Location location, float f) {
            location.setVerticalAccuracyMeters(f);
        }

        static boolean a(Location location) {
            return location.hasVerticalAccuracy();
        }

        static float b(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        static void b(Location location, float f) {
            location.setSpeedAccuracyMetersPerSecond(f);
        }

        static void c(Location location, float f) {
            location.setBearingAccuracyDegrees(f);
        }

        static boolean c(Location location) {
            return location.hasSpeedAccuracy();
        }

        static float d(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        static boolean e(Location location) {
            return location.hasBearingAccuracy();
        }

        static float f(Location location) {
            return location.getBearingAccuracyDegrees();
        }
    }

    private LocationCompat() {
    }

    private static Method a() throws NoSuchMethodException {
        if (f2438a == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            f2438a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f2438a;
    }

    public static float getBearingAccuracyDegrees(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.f(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    }

    public static long getElapsedRealtimeMillis(Location location) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TimeUnit.NANOSECONDS.toMillis(Api17Impl.a(location));
        }
        long currentTimeMillis = System.currentTimeMillis() - location.getTime();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (currentTimeMillis < 0) {
            return elapsedRealtime;
        }
        if (currentTimeMillis > elapsedRealtime) {
            return 0L;
        }
        return elapsedRealtime - currentTimeMillis;
    }

    public static long getElapsedRealtimeNanos(Location location) {
        return Build.VERSION.SDK_INT >= 17 ? Api17Impl.a(location) : TimeUnit.MILLISECONDS.toNanos(getElapsedRealtimeMillis(location));
    }

    public static float getSpeedAccuracyMetersPerSecond(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.d(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    }

    public static float getVerticalAccuracyMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    }

    public static boolean hasBearingAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.e(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.containsKey(EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.c(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.containsKey(EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.containsKey(EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(Location location) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.getBoolean(EXTRA_IS_MOCK, false);
    }

    public static void setBearingAccuracyDegrees(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.c(location, f);
            return;
        }
        Bundle extras = location.getExtras();
        Bundle bundle = extras;
        if (extras == null) {
            location.setExtras(new Bundle());
            bundle = location.getExtras();
        }
        bundle.putFloat(EXTRA_BEARING_ACCURACY, f);
    }

    public static void setMock(Location location, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                a().invoke(location, Boolean.valueOf(z));
                return;
            } catch (IllegalAccessException e) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e);
                throw illegalAccessError;
            } catch (NoSuchMethodException e2) {
                NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
                noSuchMethodError.initCause(e2);
                throw noSuchMethodError;
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            if (z) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(EXTRA_IS_MOCK, true);
                location.setExtras(bundle);
            }
        } else if (z) {
            extras.putBoolean(EXTRA_IS_MOCK, true);
        } else {
            extras.remove(EXTRA_IS_MOCK);
            if (extras.isEmpty()) {
                location.setExtras(null);
            }
        }
    }

    public static void setSpeedAccuracyMetersPerSecond(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.b(location, f);
            return;
        }
        Bundle extras = location.getExtras();
        Bundle bundle = extras;
        if (extras == null) {
            location.setExtras(new Bundle());
            bundle = location.getExtras();
        }
        bundle.putFloat(EXTRA_SPEED_ACCURACY, f);
    }

    public static void setVerticalAccuracyMeters(Location location, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.a(location, f);
            return;
        }
        Bundle extras = location.getExtras();
        Bundle bundle = extras;
        if (extras == null) {
            location.setExtras(new Bundle());
            bundle = location.getExtras();
        }
        bundle.putFloat(EXTRA_VERTICAL_ACCURACY, f);
    }
}
