package com.tencent.liteav.base.util;

import android.text.TextUtils;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/p.class */
public final class p<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f22652a;
    private Callable<T> b;

    public p(Callable<T> callable) {
        this.b = callable;
    }

    public final T a() {
        T t = this.f22652a;
        if (t instanceof String) {
            if (!TextUtils.isEmpty((CharSequence) t)) {
                return this.f22652a;
            }
        } else if (t != null) {
            return t;
        }
        synchronized (this) {
            if (this.f22652a instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) this.f22652a)) {
                    return this.f22652a;
                }
            } else if (this.f22652a != null) {
                return this.f22652a;
            }
            try {
                this.f22652a = this.b.call();
            } catch (Exception e) {
                e.printStackTrace();
                LiteavLog.e("Stash", "Get value failed. msg:" + e.getMessage());
            }
            return this.f22652a;
        }
    }

    public final void a(T t) {
        synchronized (this) {
            this.f22652a = t;
        }
    }
}
