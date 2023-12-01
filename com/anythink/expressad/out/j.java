package com.anythink.expressad.out;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES30;
import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/out/j.class */
public class j implements com.anythink.expressad.e.b, com.anythink.expressad.foundation.g.d.c, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final long f8073a = 1;
    public static final int cR = 1;
    public static final int cS = 2;
    public static final int cT = 3;
    public String cU;
    private double j;
    private Object l;
    private String n;
    private Drawable o;
    private Drawable p;
    private q q;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f8074c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private long i = 0;
    private int k = GLES30.GL_R32I;
    private int m = 1;
    private int r = 0;
    private int s = 0;
    private int t = 0;

    private Drawable a() {
        return this.o;
    }

    private static Drawable a(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    private void a(int i) {
        this.r = i;
    }

    private void a(Drawable drawable) {
        this.o = drawable;
    }

    private void a(q qVar) {
        this.q = qVar;
        if (TextUtils.isEmpty(this.g)) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.g, this);
    }

    private void a(Object obj) {
        this.l = obj;
    }

    private void a(String str) {
        this.n = str;
    }

    private Drawable b() {
        return this.p;
    }

    private void b(int i) {
        this.s = i;
    }

    private void b(Drawable drawable) {
        this.p = drawable;
    }

    private void b(q qVar) {
        this.q = qVar;
        if (TextUtils.isEmpty(this.h)) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.n.a().g()).a(this.h, this);
    }

    private Object c() {
        return this.l;
    }

    private void c(q qVar) {
        this.q = qVar;
    }

    private String d() {
        return this.cU;
    }

    private int e() {
        return this.r;
    }

    private int f() {
        return this.s;
    }

    private String g() {
        return this.n;
    }

    public final void A(String str) {
        this.h = str;
    }

    public final void B(String str) {
        this.f = str;
    }

    public final void a(double d) {
        this.j = d;
    }

    public final void a(long j) {
        this.i = j;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(Bitmap bitmap, String str) {
        String str2;
        if (!TextUtils.isEmpty(this.h) && this.h.equals(str) && bitmap != null) {
            this.p = a(bitmap);
            if (this.q != null) {
                a(bitmap);
            }
        }
        if (TextUtils.isEmpty(this.g) || (str2 = this.g) == null || !str2.equals(str) || bitmap == null) {
            return;
        }
        this.o = a(bitmap);
        if (this.q != null) {
            a(bitmap);
        }
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(String str, String str2) {
    }

    public final double aX() {
        return this.j;
    }

    public final int aY() {
        return this.k;
    }

    public final String aZ() {
        return this.b;
    }

    public final String ba() {
        return this.f8074c;
    }

    public final String bb() {
        return this.d;
    }

    public final String bc() {
        return this.e;
    }

    public final String bd() {
        return this.g;
    }

    public final String be() {
        return this.h;
    }

    public final int bf() {
        return this.m;
    }

    public final long bg() {
        return this.i;
    }

    public final String bh() {
        return this.f;
    }

    public final int bi() {
        return this.t;
    }

    public final void o(int i) {
        this.k = i;
    }

    public void o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.cU = str;
    }

    public final void p(int i) {
        this.m = i;
    }

    public final void q(int i) {
        this.t = i;
    }

    public final void v(String str) {
        this.b = str;
    }

    public final void w(String str) {
        this.f8074c = str;
    }

    public final void x(String str) {
        this.d = str;
    }

    public final void y(String str) {
        this.e = str;
    }

    public final void z(String str) {
        this.g = str;
    }
}
