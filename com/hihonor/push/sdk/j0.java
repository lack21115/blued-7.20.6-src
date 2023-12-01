package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Incorrect class signature, class is equals to this class: <TResult:Ljava/lang/Object;>Lcom/hihonor/push/sdk/j0<TTResult;>; */
/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/j0.class */
public final class j0<TResult> {
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public TResult f22308c;
    public Exception d;

    /* renamed from: a  reason: collision with root package name */
    public final Object f22307a = new Object();
    public List<t<TResult>> e = new ArrayList();

    public final j0<TResult> a(t<TResult> tVar) {
        synchronized (this.f22307a) {
            if (this.b) {
                tVar.a(this);
            } else {
                this.e.add(tVar);
            }
        }
        return this;
    }

    public final void a() {
        synchronized (this.f22307a) {
            for (t<TResult> tVar : this.e) {
                try {
                    tVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.e = null;
        }
    }

    public final Exception b() {
        Exception exc;
        synchronized (this.f22307a) {
            exc = this.d;
        }
        return exc;
    }

    public final TResult c() {
        TResult tresult;
        synchronized (this.f22307a) {
            if (this.d != null) {
                throw new RuntimeException(this.d);
            }
            tresult = this.f22308c;
        }
        return tresult;
    }

    public final boolean d() {
        synchronized (this.f22307a) {
        }
        return false;
    }

    public final boolean e() {
        boolean z;
        synchronized (this.f22307a) {
            if (this.b) {
                d();
                if (this.d == null) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
