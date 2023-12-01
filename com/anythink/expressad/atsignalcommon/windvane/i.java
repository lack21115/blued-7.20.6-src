package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Class> f4269a = new HashMap<>();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Object f4270c;
    private WindVaneWebView d;

    public i(Context context, WindVaneWebView windVaneWebView) {
        this.b = context;
        this.d = windVaneWebView;
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.bridge.BannerJSPlugin"));
        } catch (ClassNotFoundException e) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.video.signal.communication.RewardJs"));
        } catch (ClassNotFoundException e2) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.video.signal.communication.VideoBridge"));
        } catch (ClassNotFoundException e3) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.mraid.MraidJSBridge"));
        } catch (ClassNotFoundException e4) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.splash.js.SplashJs"));
        } catch (ClassNotFoundException e5) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.webEnvCheck.WebGLCheckjs"));
        } catch (ClassNotFoundException e6) {
        }
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = f4269a.get(str);
        if (cls != null) {
            try {
                if (l.class.isAssignableFrom(cls)) {
                    l lVar = (l) cls.newInstance();
                    lVar.initialize(context, windVaneWebView);
                    lVar.initialize(this.f4270c, windVaneWebView);
                    return lVar;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static void a() {
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.bridge.BannerJSPlugin"));
        } catch (ClassNotFoundException e) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.video.signal.communication.RewardJs"));
        } catch (ClassNotFoundException e2) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.video.signal.communication.VideoBridge"));
        } catch (ClassNotFoundException e3) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.mraid.MraidJSBridge"));
        } catch (ClassNotFoundException e4) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.splash.js.SplashJs"));
        } catch (ClassNotFoundException e5) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.webEnvCheck.WebGLCheckjs"));
        } catch (ClassNotFoundException e6) {
        }
    }

    public static void a(Class cls) {
        if (f4269a == null) {
            f4269a = new HashMap<>();
        }
        f4269a.put(cls.getSimpleName(), cls);
    }

    private static void b(String str) {
        if (f4269a == null) {
            f4269a = new HashMap<>();
        }
        f4269a.remove(str);
    }

    public final Object a(String str) {
        if (f4269a == null) {
            f4269a = new HashMap<>();
        }
        return a(str, this.d, this.b);
    }

    public final void a(Context context) {
        this.b = context;
    }

    public final void a(Object obj) {
        this.f4270c = obj;
    }
}
