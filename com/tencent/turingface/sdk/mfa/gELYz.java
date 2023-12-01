package com.tencent.turingface.sdk.mfa;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Window;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/gELYz.class */
public final class gELYz {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26265a = false;
    public static wmqhz b;
    public static WT9z5 e;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<yMdp8> f26266c = new CopyOnWriteArraySet();
    public static final Set<Ww1Z6> d = new CopyOnWriteArraySet();
    public static boolean f = false;
    public static final Set<String> g = new HashSet();
    public static final spXPg h = new spXPg();
    public static final SkEpO i = new SkEpO();
    public static final ShGzN j = new ShGzN();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/gELYz$ShGzN.class */
    public final class ShGzN implements Ww1Z6 {
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set<com.tencent.turingface.sdk.mfa.Ww1Z6>, java.util.concurrent.CopyOnWriteArraySet] */
        @Override // com.tencent.turingface.sdk.mfa.Ww1Z6
        public final void a(String str) {
            Iterator it = gELYz.d.iterator();
            while (it.hasNext()) {
                ((Ww1Z6) it.next()).a(str);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/gELYz$SkEpO.class */
    public final class SkEpO implements hxUS9 {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/gELYz$spXPg.class */
    public final class spXPg extends yLOCn {
        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
        @Override // com.tencent.turingface.sdk.mfa.yLOCn
        public final void a(Activity activity) {
            if (gELYz.g.contains(activity.getClass().getName()) || gELYz.f) {
                try {
                    SkEpO skEpO = gELYz.i;
                    Window window = activity.getWindow();
                    String name = activity.getClass().getName();
                    Window.Callback callback = window.getCallback();
                    if (callback != null && !(callback instanceof FxCVY)) {
                        window.setCallback(new FxCVY(callback, skEpO, name));
                    }
                    Window window2 = activity.getWindow();
                    window2.getDecorView().getViewTreeObserver().addOnPreDrawListener(new FP21m(window2, activity.getClass().getName(), gELYz.j));
                } catch (Throwable th) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            gELYz.e.onActivityPaused(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            a(activity);
            gELYz.e.onActivityResumed(activity);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/gELYz$wmqhz.class */
    public static final class wmqhz extends Handler {
        public wmqhz(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Type inference failed for: r0v9, types: [java.util.Set<com.tencent.turingface.sdk.mfa.yMdp8>, java.util.concurrent.CopyOnWriteArraySet] */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            if (message.what == 1 && (obj = message.obj) != null && (obj instanceof QmgHg)) {
                QmgHg qmgHg = (QmgHg) obj;
                Iterator it = gELYz.f26266c.iterator();
                while (it.hasNext()) {
                    ((yMdp8) it.next()).a(qmgHg);
                }
                if (qmgHg.e) {
                    throw new IllegalStateException("Already recycled.");
                }
                synchronized (QmgHg.f26222c) {
                    qmgHg.f = 0;
                    qmgHg.g = 0;
                    qmgHg.h = 0;
                    qmgHg.i = 0.0f;
                    qmgHg.j = 0.0f;
                    qmgHg.k = 0.0f;
                    qmgHg.l = 0.0f;
                    qmgHg.m = "";
                    int i = QmgHg.b;
                    if (i < 20) {
                        qmgHg.d = QmgHg.f26221a;
                        qmgHg.e = true;
                        QmgHg.f26221a = qmgHg;
                        QmgHg.b = i + 1;
                    }
                }
            }
        }
    }

    public static void a(Context context, WT9z5 wT9z5) {
        e = wT9z5;
        if (f26265a) {
            return;
        }
        f26265a = true;
        synchronized (gELYz.class) {
            try {
                HandlerThread handlerThread = new HandlerThread("TuringDispatch");
                handlerThread.start();
                b = new wmqhz(handlerThread.getLooper());
            } catch (Throwable th) {
                throw th;
            }
        }
        Application application = (Application) context;
        synchronized (gELYz.class) {
            try {
                spXPg spxpg = h;
                application.unregisterActivityLifecycleCallbacks(spxpg);
                application.registerActivityLifecycleCallbacks(spxpg);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
