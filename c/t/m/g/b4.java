package c.t.m.g;

import android.content.Context;
import android.os.PowerManager;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b4.class */
public abstract class b4 {

    /* renamed from: a  reason: collision with root package name */
    public static PowerManager.WakeLock f3714a;

    public static void a() {
        PowerManager.WakeLock wakeLock = f3714a;
        if (wakeLock != null && wakeLock.isHeld()) {
            f3714a.release();
        }
        f3714a = null;
    }

    public static void a(Context context) throws Exception {
        PowerManager.WakeLock wakeLock = f3714a;
        if (wakeLock != null && wakeLock.isHeld()) {
            f3714a.release();
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService(Context.POWER_SERVICE)).newWakeLock(1, "WakeLocker");
        f3714a = newWakeLock;
        newWakeLock.acquire(5000L);
    }
}
