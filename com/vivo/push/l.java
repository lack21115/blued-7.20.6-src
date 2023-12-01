package com.vivo.push;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/l.class */
public abstract class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f41105a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private o f41106c;

    public l(o oVar) {
        this.b = -1;
        this.f41106c = oVar;
        int b = oVar.b();
        this.b = b;
        if (b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f41105a = e.a().h();
    }

    public final int a() {
        return this.b;
    }

    protected abstract void a(o oVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f41105a;
        if (context != null && !(this.f41106c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f41106c);
        }
        a(this.f41106c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        o oVar = this.f41106c;
        sb.append(oVar == null ? "[null]" : oVar.toString());
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }
}
