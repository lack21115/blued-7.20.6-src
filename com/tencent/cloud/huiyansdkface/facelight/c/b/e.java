package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/e.class */
public class e {

    /* renamed from: c  reason: collision with root package name */
    private static PowerManager.WakeLock f21866c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f21867a = new Handler(Looper.getMainLooper());
    private int b;
    private PowerManager d;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/e$a.class */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<PowerManager.WakeLock> f21868a;

        private a() {
            this.f21868a = new WeakReference<>(e.f21866c);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21868a.get() == null || !this.f21868a.get().isHeld()) {
                return;
            }
            this.f21868a.get().release();
        }
    }

    public e(int i) {
        this.b = 60000;
        this.b = i;
    }

    public void a() {
        PowerManager.WakeLock wakeLock = f21866c;
        if (wakeLock != null && wakeLock.isHeld()) {
            f21866c.release();
            f21866c = null;
        }
        if (this.d != null) {
            this.d = null;
        }
    }

    public void a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        this.d = powerManager;
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "cameraFace");
            f21866c = newWakeLock;
            newWakeLock.acquire();
            this.f21867a.postDelayed(new a(), this.b);
        }
    }
}
