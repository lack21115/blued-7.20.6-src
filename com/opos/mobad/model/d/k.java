package com.opos.mobad.model.d;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private String f12750a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f12751c = SystemClock.elapsedRealtime();
    private p d = new p();

    public k(String str, String str2) {
        this.b = str;
        this.f12750a = str2;
    }

    public void a(int i) {
        this.d.a("1", i);
    }

    public void a(Context context, int i, String str, boolean z, String str2) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, this.f12750a, i, SystemClock.elapsedRealtime() - this.f12751c, z, com.opos.cmn.i.n.a(this.d.a()), str2);
    }

    public void a(Context context, String str, boolean z, String str2, int i) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, str, this.f12750a, SystemClock.elapsedRealtime() - this.f12751c, z, com.opos.cmn.i.n.a(this.d.a()), str2, i);
    }

    public void b(int i) {
        this.d.a("2", i);
    }

    public void c(int i) {
        this.d.a("3", i);
    }

    public void d(int i) {
        this.d.a("4", i);
    }
}
