package com.tencent.mapsdk.internal;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ej.class */
public class ej implements de {

    /* renamed from: a  reason: collision with root package name */
    private Context f23731a;
    private final mc b;

    /* renamed from: c  reason: collision with root package name */
    private String f23732c;

    public ej(Context context, String str) {
        if (context == null) {
            this.b = null;
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f23731a = applicationContext;
        this.b = mc.b(applicationContext);
        this.f23732c = str;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String a() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String b() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String c() {
        mc mcVar = this.b;
        if (mcVar != null) {
            return mcVar.g();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String d() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String e() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String f() {
        mc mcVar = this.b;
        if (mcVar != null) {
            return mcVar.a(this.f23732c);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String g() {
        mc mcVar = this.b;
        if (mcVar != null) {
            return mcVar.f();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String h() {
        mc mcVar = this.b;
        if (mcVar != null) {
            return mcVar.d();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String i() {
        mc mcVar = this.b;
        if (mcVar != null) {
            return mcVar.d(this.f23732c);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.de
    public String j() {
        mc mcVar = this.b;
        if (mcVar != null) {
            return mcVar.c(this.f23732c);
        }
        return null;
    }
}
