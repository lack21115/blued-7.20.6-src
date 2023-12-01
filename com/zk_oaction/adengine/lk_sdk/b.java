package com.zk_oaction.adengine.lk_sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.zk_oaction.adengine.lk_view.g;
import com.zk_oaction.adengine.lk_view.m;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f41929a;

    public b(Context context, com.zk_oaction.adengine.lk_interfaces.a aVar) {
        this.f41929a = new c(context, aVar);
    }

    public View a(String str) {
        return this.f41929a.b(str);
    }

    public View a(String str, com.zk_oaction.adengine.lk_interfaces.c cVar) {
        return this.f41929a.a(str, cVar);
    }

    public void a() {
        this.f41929a.d();
    }

    public void a(int i) {
        this.f41929a.a(i);
    }

    public void a(View view, String str) {
        if (view == null || !(view instanceof m)) {
            return;
        }
        ((m) view).h_(str);
    }

    public void a(View view, String str, Bitmap bitmap) {
        if (view == null || !(view instanceof g)) {
            return;
        }
        ((g) view).a(str, bitmap);
    }

    public void a(com.zk_oaction.adengine.lk_interfaces.b bVar) {
        this.f41929a.a(bVar);
    }

    public void a(String str, String str2) {
        com.zk_oaction.adengine.lk_variable.g gVar = this.f41929a.n;
        if (gVar != null) {
            gVar.a(str, str2);
        }
    }

    public void a(boolean z) {
        this.f41929a.a(z);
    }

    public String b(String str) {
        com.zk_oaction.adengine.lk_variable.g gVar = this.f41929a.n;
        if (gVar != null) {
            return gVar.b(str);
        }
        return null;
    }

    public void b() {
        this.f41929a.e();
    }

    public void b(int i) {
        this.f41929a.b(i);
    }

    public void b(String str, String str2) {
        this.f41929a.b(str, str2);
    }

    public void c() {
        this.f41929a.f();
    }

    public float d() {
        return this.f41929a.t;
    }

    public int e() {
        return this.f41929a.D;
    }

    public int f() {
        return this.f41929a.E;
    }
}
