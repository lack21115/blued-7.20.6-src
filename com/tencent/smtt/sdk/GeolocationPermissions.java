package com.tencent.smtt.sdk;

import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/GeolocationPermissions.class */
public class GeolocationPermissions {

    /* renamed from: a  reason: collision with root package name */
    private static GeolocationPermissions f38701a;

    private static GeolocationPermissions a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            try {
                if (f38701a == null) {
                    f38701a = new GeolocationPermissions();
                }
                geolocationPermissions = f38701a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return geolocationPermissions;
    }

    public static GeolocationPermissions getInstance() {
        return a();
    }

    public void allow(String str) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        } else {
            a2.c().g(str);
        }
    }

    public void clear(String str) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        } else {
            a2.c().f(str);
        }
    }

    public void clearAll() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        } else {
            a2.c().o();
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        } else {
            a2.c().c(str, valueCallback);
        }
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        } else {
            a2.c().b(valueCallback);
        }
    }
}
