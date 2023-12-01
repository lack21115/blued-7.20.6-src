package com.anythink.expressad.foundation.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4912a = a.class.getSimpleName();
    private static volatile a b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4913c;
    private String d;
    private String e;
    private JSONObject g;
    private boolean i;
    private WeakReference<Context> j;
    private WeakReference<Activity> k;
    private int f = 0;
    private boolean h = false;

    private a() {
    }

    private void a(int i) {
        this.f = i;
    }

    private void a(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public final String a() {
        try {
            if (this.f4913c != null) {
                return this.f4913c.getPackageName();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a(Context context) {
        this.f4913c = context;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void b(Context context) {
        this.j = new WeakReference<>(context);
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void c() {
        if (this.h) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.g = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final Context d() {
        return this.f4913c;
    }

    public final String e() {
        return !TextUtils.isEmpty(this.d) ? this.d : "";
    }

    public final String f() {
        return !TextUtils.isEmpty(this.e) ? this.e : "";
    }

    public final Context g() {
        WeakReference<Context> weakReference = this.j;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final int h() {
        return this.f;
    }

    public final JSONObject i() {
        return this.g;
    }
}
