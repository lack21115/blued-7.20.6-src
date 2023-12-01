package com.tencent.thumbplayer.e;

import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/e/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f25609a;
    private b b;

    public a(b bVar) {
        this.b = bVar;
        this.f25609a = bVar.a();
    }

    public a(b bVar, String str) {
        b bVar2 = new b(bVar, str);
        this.b = bVar2;
        this.f25609a = bVar2.a();
    }

    public b a() {
        return this.b;
    }

    public void a(b bVar) {
        if (bVar == null) {
            this.b = new b(this.f25609a);
        } else {
            this.b = bVar;
        }
    }

    public void a(Exception exc) {
        TPLogUtil.e(this.b.a(), exc);
    }

    public void a(String str) {
        this.b.a(str);
    }

    public String b() {
        return this.b.a();
    }

    public void b(String str) {
        TPLogUtil.d(this.b.a(), str);
    }

    public void c(String str) {
        TPLogUtil.i(this.b.a(), str);
    }

    public void d(String str) {
        TPLogUtil.w(this.b.a(), str);
    }

    public void e(String str) {
        TPLogUtil.e(this.b.a(), str);
    }
}
