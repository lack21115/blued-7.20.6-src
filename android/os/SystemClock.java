package android.os;

import android.app.IAlarmManager;
import android.util.Slog;

/* loaded from: source-9557208-dex2jar.jar:android/os/SystemClock.class */
public final class SystemClock {
    private static final String TAG = "SystemClock";

    private SystemClock() {
    }

    public static native long currentThreadTimeMicro();

    public static native long currentThreadTimeMillis();

    public static native long currentTimeMicro();

    public static native long elapsedRealtime();

    public static native long elapsedRealtimeNanos();

    public static boolean setCurrentTimeMillis(long j) {
        IAlarmManager asInterface = IAlarmManager.Stub.asInterface(ServiceManager.getService("alarm"));
        if (asInterface == null) {
            return false;
        }
        try {
            return asInterface.setTime(j);
        } catch (RemoteException e) {
            Slog.e(TAG, "Unable to set RTC", e);
            return false;
        } catch (SecurityException e2) {
            Slog.e(TAG, "Unable to set RTC", e2);
            return false;
        }
    }

    public static void sleep(long j) {
        boolean z;
        long uptimeMillis;
        long uptimeMillis2 = uptimeMillis();
        long j2 = j;
        boolean z2 = false;
        do {
            try {
                Thread.sleep(j2);
                z = z2;
            } catch (InterruptedException e) {
                z = true;
            }
            uptimeMillis = (uptimeMillis2 + j) - uptimeMillis();
            j2 = uptimeMillis;
            z2 = z;
        } while (uptimeMillis > 0);
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static native long uptimeMillis();
}
