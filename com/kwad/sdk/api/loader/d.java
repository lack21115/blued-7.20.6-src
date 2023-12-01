package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/d.class */
public class d implements Thread.UncaughtExceptionHandler {
    private static d Zq;
    private Thread.UncaughtExceptionHandler Zr;
    private int Zs;
    private long Zu;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean Zt = new AtomicBoolean();

    private d(Context context) {
        this.mContext = context;
    }

    public static d an(Context context) {
        if (Zq == null) {
            synchronized (d.class) {
                try {
                    if (Zq == null) {
                        Zq = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Zq;
    }

    public final void aS(int i) {
        this.Zu = System.currentTimeMillis();
        this.Zs = i;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.Zt.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.Zr = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.Zu + ",mMaxDuration:" + this.Zs + ",mIsCancel:" + this.Zt.get());
            }
            if (!this.Zt.get() && this.Zu > 0 && System.currentTimeMillis() - this.Zu <= this.Zs) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.a("filterStack", th);
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                if (this.mContext != null && booleanValue) {
                    t.a(this.mContext, g.ZA, true);
                }
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.Zr;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.Zr;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
