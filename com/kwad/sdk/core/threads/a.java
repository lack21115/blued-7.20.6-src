package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.kwad.sdk.utils.bm;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/a.class */
public final class a {
    private static Map<String, WeakReference<C0566a>> amk = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/a$a.class */
    public static final class C0566a {
        private HandlerThread aml;
        private Handler mHandler;

        public C0566a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.aml = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.aml.getLooper());
        }

        public final bm b(bm.a aVar) {
            return new bm(aVar, this.aml.getLooper());
        }

        public final Handler getHandler() {
            return this.mHandler;
        }
    }

    public static bm a(bm.a aVar) {
        bm b;
        synchronized (a.class) {
            try {
                b = cJ("commonHT").b(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    private static C0566a cJ(String str) {
        WeakReference<C0566a> weakReference = amk.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0566a c0566a = new C0566a(str);
            amk.put(str, new WeakReference<>(c0566a));
            return c0566a;
        }
        return weakReference.get();
    }

    public static Handler xI() {
        Handler handler;
        synchronized (a.class) {
            try {
                handler = cJ("commonHT").getHandler();
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public static Handler xJ() {
        Handler handler;
        synchronized (a.class) {
            try {
                handler = cJ("reportHT").getHandler();
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}
