package com.anythink.core.common;

import android.content.Context;
import java.lang.reflect.Method;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/s.class */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6917a = 35;
    public static final String b = "isDefaultOffer";
    private static volatile s g;

    /* renamed from: c  reason: collision with root package name */
    Method f6918c;
    Method d;
    Method e;
    Method f;

    private s() {
        try {
            Class<?> cls = Class.forName("com.anythink.network.myoffer.MyOfferAPI");
            this.f6918c = cls.getDeclaredMethod("preloadTopOnOffer", Context.class, com.anythink.core.common.e.t.class);
            this.d = cls.getDeclaredMethod("getOutOfCapOfferIds", Context.class);
            this.e = cls.getDeclaredMethod("getDefaultOfferId", Context.class, String.class);
            this.f = cls.getDeclaredMethod("checkOffersOutOfCap", Context.class, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static s a() {
        if (g == null) {
            synchronized (s.class) {
                try {
                    if (g == null) {
                        g = new s();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }

    public final JSONArray a(Context context) {
        try {
            if (this.d != null) {
                return new JSONArray(this.d.invoke(null, context).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public final void a(Context context, String str) {
        try {
            if (this.f6918c != null) {
                com.anythink.core.common.e.t tVar = new com.anythink.core.common.e.t();
                tVar.f6677a = str;
                this.f6918c.invoke(null, context, tVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String b(Context context, String str) {
        try {
            return this.e != null ? this.e.invoke(null, context, str).toString() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final boolean c(Context context, String str) {
        try {
            if (this.f != null) {
                return ((Boolean) this.f.invoke(null, context, str)).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
