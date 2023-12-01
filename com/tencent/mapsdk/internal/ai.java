package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.media.tv.TvContract;
import com.heytap.mcssdk.constant.IntentConstant;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ai.class */
public class ai extends JsonComposer {
    private static final String j = "default";
    private static final int k = 0;
    private static final int l = 1;
    @Json(name = IntentConstant.RULE)

    /* renamed from: a  reason: collision with root package name */
    private int f37298a = 0;
    @Json(name = "priority")
    private int b = 0;
    @Json(name = "frontier")

    /* renamed from: c  reason: collision with root package name */
    private String f37299c = "default";
    @Json(name = "logo_name")
    private String d = "";
    @Json(name = TvContract.Channels.Logo.CONTENT_DIRECTORY)
    private String e = "";
    @Json(name = "logo_night")
    private String f;
    @Json(ignore = true)
    private Bitmap g;
    @Json(ignore = true)
    private Bitmap h;
    private boolean i;

    private boolean a(w5 w5Var) {
        if ("default".equals(this.f37299c)) {
            return true;
        }
        if (w5Var == null) {
            return false;
        }
        return th.a(w5Var.b(), th.b().c(this.f37299c));
    }

    private boolean b(w5 w5Var) {
        if ("default".equals(this.f37299c)) {
            return true;
        }
        if (w5Var == null) {
            return false;
        }
        x5[] c2 = th.b().c(this.f37299c);
        x5[] c3 = w5Var.c();
        if (c3 == null || c2 == null) {
            return true;
        }
        return th.a(c3, c2);
    }

    public Bitmap a(boolean z) {
        return z ? this.h : this.g;
    }

    public String a() {
        return this.d;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(Bitmap bitmap) {
        this.g = bitmap;
    }

    public void a(String str) {
        this.f37299c = str;
    }

    public String b() {
        return this.f;
    }

    public void b(int i) {
        this.f37298a = i;
    }

    public void b(Bitmap bitmap) {
        this.h = bitmap;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public String c() {
        return this.e;
    }

    public void c(String str) {
        this.f = str;
    }

    public boolean c(w5 w5Var) {
        int i = this.f37298a;
        boolean b = i != 0 ? i != 1 ? false : b(w5Var) : a(w5Var);
        boolean z = b;
        if (e()) {
            z = !b;
        }
        return z;
    }

    public int d() {
        return (this.f37298a * 10) + this.b;
    }

    public void d(String str) {
        this.e = str;
    }

    public boolean e() {
        return this.i;
    }
}
