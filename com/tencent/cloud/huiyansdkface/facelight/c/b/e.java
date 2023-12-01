package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/e.class */
public class e {

    /* renamed from: c  reason: collision with root package name */
    private static PowerManager.WakeLock f35557c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f35558a = new Handler(Looper.getMainLooper());
    private int b;
    private PowerManager d;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/e$a.class */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<PowerManager.WakeLock> f35559a;

        private a() {
            this.f35559a = new WeakReference<>(e.f35557c);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f35559a.get() == null || !this.f35559a.get().isHeld()) {
                return;
            }
            this.f35559a.get().release();
        }
    }

    public e(int i) {
        this.b = 60000;
        this.b = i;
    }

    public void a() {
        PowerManager.WakeLock wakeLock = f35557c;
        if (wakeLock != null && wakeLock.isHeld()) {
            f35557c.release();
            f35557c = null;
        }
        if (this.d != null) {
            this.d = null;
        }
    }

    public void a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        this.d = powerManager;
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "cameraFace");
            f35557c = newWakeLock;
            newWakeLock.acquire();
            this.f35558a.postDelayed(new a(), this.b);
        }
    }
}
