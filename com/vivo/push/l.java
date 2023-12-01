package com.vivo.push;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/l.class */
public abstract class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f27414a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private o f27415c;

    public l(o oVar) {
        this.b = -1;
        this.f27415c = oVar;
        int b = oVar.b();
        this.b = b;
        if (b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f27414a = e.a().h();
    }

    public final int a() {
        return this.b;
    }

    protected abstract void a(o oVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f27414a;
        if (context != null && !(this.f27415c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f27415c);
        }
        a(this.f27415c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        o oVar = this.f27415c;
        sb.append(oVar == null ? "[null]" : oVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
