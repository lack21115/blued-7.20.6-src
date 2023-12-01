package com.zx.a.I8b7;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/u0.class */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    public b1 f28514a;
    public w1 b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28515c;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/u0$a.class */
    public final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                throw null;
            } finally {
            }
        }
    }

    public u0(w1 w1Var, b1 b1Var) {
        this.b = w1Var;
        this.f28514a = b1Var;
    }

    public e1 a() throws Exception {
        synchronized (this) {
            if (this.f28515c) {
                throw new IllegalStateException("Already Executed");
            }
            this.f28515c = true;
        }
        try {
            q qVar = this.b.f28529a;
            synchronized (qVar) {
                qVar.d.add(this);
            }
            return b();
        } finally {
            q qVar2 = this.b.f28529a;
            qVar2.a(qVar2.d, this, false);
        }
    }

    public e1 b() throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.b.b);
        this.f28514a.getClass();
        arrayList.add(new f());
        arrayList.add(new j(this.b));
        arrayList.add(new g());
        b1 b1Var = this.f28514a;
        if (arrayList.size() > 0) {
            v0 v0Var = new v0(arrayList, null, 1, b1Var);
            g0 g0Var = (g0) arrayList.get(0);
            e1 a2 = g0Var.a(v0Var);
            if (a2 == null) {
                throw new NullPointerException("interceptor " + g0Var + " returned null");
            } else if (a2.e != null) {
                return a2;
            } else {
                throw new IllegalStateException("interceptor " + g0Var + " returned a response with no body");
            }
        }
        throw new AssertionError();
    }
}
