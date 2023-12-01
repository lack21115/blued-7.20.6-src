package com.kwad.sdk.utils;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import java.io.Closeable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bi.class */
public final class bi {
    private static final Handler aBx = new Handler(Looper.getMainLooper());
    private static long ka = 400;

    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, ka);
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(aBx, runnable);
        obtain.obj = null;
        aBx.sendMessageDelayed(obtain, j);
    }

    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || al.al(context, Manifest.permission.VIBRATE) != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void b(Runnable runnable) {
        aBx.removeCallbacks(runnable);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void postOnUiThread(Runnable runnable) {
        aBx.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aBx.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        aBx.postDelayed(runnable, j);
    }

    public static void vibrate(Context context, Vibrator vibrator, long j) {
        if (vibrator != null) {
            try {
                if (al.al(context, Manifest.permission.VIBRATE) == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                    } else {
                        vibrator.vibrate(j);
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }
}
