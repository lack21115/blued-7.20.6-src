package com.tencent.qimei.y;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f24751a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public b f24752c;
    public final com.tencent.qimei.j.f d;

    public a(String str) {
        Object obj = new Object();
        this.f24751a = obj;
        this.b = str;
        this.f24752c = null;
        this.d = new com.tencent.qimei.j.f(obj, 30000);
    }

    public b a() {
        return this.f24752c;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b() {
        this.d.b();
    }

    @JavascriptInterface
    public void callback(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.f24752c = new b(str, this.b, str2, str3);
        }
        this.d.a();
    }
}
