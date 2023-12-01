package com.bytedance.bdtracker;

import android.accounts.Account;
import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/p0.class */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile r2 f21283a;
    public Account b;

    /* renamed from: c  reason: collision with root package name */
    public s1 f21284c;

    public r2 a(Context context, m0 m0Var) {
        if (this.f21283a == null) {
            synchronized (p0.class) {
                try {
                    if (this.f21283a == null) {
                        if (context == null) {
                            throw new IllegalArgumentException("context == null");
                        }
                        if (this.f21284c == null) {
                            this.f21284c = new s1(context);
                        }
                        if (this.f21283a == null) {
                            this.f21283a = new n2(context, m0Var, this.f21284c);
                            if (this.b != null) {
                                ((n2) this.f21283a).a(this.b);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f21283a;
    }
}
