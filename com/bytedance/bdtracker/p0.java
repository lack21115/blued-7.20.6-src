package com.bytedance.bdtracker;

import android.accounts.Account;
import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/p0.class */
public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public volatile r2 f7677a;
    public Account b;

    /* renamed from: c  reason: collision with root package name */
    public s1 f7678c;

    public r2 a(Context context, m0 m0Var) {
        if (this.f7677a == null) {
            synchronized (p0.class) {
                try {
                    if (this.f7677a == null) {
                        if (context == null) {
                            throw new IllegalArgumentException("context == null");
                        }
                        if (this.f7678c == null) {
                            this.f7678c = new s1(context);
                        }
                        if (this.f7677a == null) {
                            this.f7677a = new n2(context, m0Var, this.f7678c);
                            if (this.b != null) {
                                ((n2) this.f7677a).a(this.b);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f7677a;
    }
}
