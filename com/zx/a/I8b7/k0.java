package com.zx.a.I8b7;

import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/k0.class */
public class k0 {

    /* renamed from: a  reason: collision with root package name */
    public m0 f42142a = new m0();
    public h0 b;

    /* renamed from: c  reason: collision with root package name */
    public j0 f42143c;
    public u d;
    public y e;
    public x f;

    public k0(Context context) {
        j0 j0Var = new j0(new i0());
        this.f42143c = j0Var;
        h0 h0Var = new h0(j0Var);
        this.b = h0Var;
        this.f42142a.a(h0Var);
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            x xVar = new x(applicationContext);
            this.f = xVar;
            y yVar = new y(xVar);
            this.e = yVar;
            u uVar = new u(applicationContext, yVar);
            this.d = uVar;
            this.f42142a.a(uVar);
        }
    }

    public void a(int i) {
        int i2 = i + 8;
        this.f42143c.f42137c = i2;
        y yVar = this.e;
        if (yVar != null) {
            yVar.d = i2;
        }
    }

    public void a(String str) {
        this.f42142a.a(2, null, str, null);
    }

    public void a(boolean z) {
        this.b.b = z;
    }

    public void b(String str) {
        u uVar = this.d;
        if (uVar != null) {
            uVar.a(str);
        }
    }

    public void c(String str) {
        this.f42143c.b = str;
        y yVar = this.e;
        if (yVar != null) {
            yVar.f42230c = str;
        }
    }

    public void d(String str) {
        x xVar = this.f;
        if (xVar != null) {
            xVar.b = xVar.f42226c.getPackageName() + "-" + str + "-" + new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()) + com.anythink.china.common.a.a.f;
            xVar.f42225a = new File("sdcard/libs", xVar.b);
        }
    }
}
