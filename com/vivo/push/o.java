package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/o.class */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private int f27421a;
    private String b;

    public o(int i) {
        this.f27421a = -1;
        if (i < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f27421a = i;
    }

    private void e(a aVar) {
        aVar.a(IntentConstant.COMMAND, this.f27421a);
        aVar.a("client_pkgname", this.b);
        c(aVar);
    }

    public final String a() {
        return this.b;
    }

    public final void a(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a2);
        Bundle b = a2.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void a(a aVar) {
        String a2 = p.a(this.f27421a);
        String str = a2;
        if (a2 == null) {
            str = "";
        }
        aVar.a("method", str);
        e(aVar);
    }

    public final void a(String str) {
        this.b = str;
    }

    public final int b() {
        return this.f27421a;
    }

    public final void b(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a2.a("method", this.f27421a);
        e(a2);
        Bundle b = a2.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void b(a aVar) {
        String a2 = aVar.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = aVar.a("client_pkgname");
        }
        this.b = a2;
        d(aVar);
    }

    protected abstract void c(a aVar);

    public boolean c() {
        return false;
    }

    protected abstract void d(a aVar);

    public String toString() {
        return getClass().getSimpleName();
    }
}
