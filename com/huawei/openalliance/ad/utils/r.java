package com.huawei.openalliance.ad.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/r.class */
public class r {
    private Handler Code;

    public r(Handler handler) {
        this.Code = handler;
    }

    private boolean Code() {
        Looper looper;
        Handler handler = this.Code;
        boolean z = false;
        if (handler == null || (looper = handler.getLooper()) == null) {
            return false;
        }
        if (Thread.currentThread() == looper.getThread()) {
            z = true;
        }
        return z;
    }

    public void Code(Runnable runnable) {
        Code(runnable, null, 0L);
    }

    public void Code(Runnable runnable, long j) {
        Code(runnable, null, j);
    }

    public void Code(Runnable runnable, String str) {
        Code(runnable, str, 0L);
    }

    public void Code(Runnable runnable, String str, long j) {
        if (this.Code == null || runnable == null) {
            return;
        }
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        az azVar = new az(runnable);
        if (j2 == 0 && Code()) {
            azVar.run();
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() + j2;
        if (Build.VERSION.SDK_INT >= 22) {
            try {
                Message obtain = Message.obtain(this.Code, azVar);
                obtain.setAsynchronous(true);
                obtain.obj = str;
                this.Code.sendMessageAtTime(obtain, uptimeMillis);
                return;
            } catch (Throwable th) {
            }
        }
        this.Code.postAtTime(azVar, str, uptimeMillis);
    }

    public void Code(String str) {
        Handler handler = this.Code;
        if (handler == null || str == null) {
            return;
        }
        handler.removeCallbacksAndMessages(str);
    }
}
