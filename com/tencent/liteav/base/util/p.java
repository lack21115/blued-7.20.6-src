package com.tencent.liteav.base.util;

import android.text.TextUtils;
import java.util.concurrent.Callable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/p.class */
public final class p<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f36343a;
    private Callable<T> b;

    public p(Callable<T> callable) {
        this.b = callable;
    }

    public final T a() {
        T t = this.f36343a;
        if (t instanceof String) {
            if (!TextUtils.isEmpty((CharSequence) t)) {
                return this.f36343a;
            }
        } else if (t != null) {
            return t;
        }
        synchronized (this) {
            if (this.f36343a instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) this.f36343a)) {
                    return this.f36343a;
                }
            } else if (this.f36343a != null) {
                return this.f36343a;
            }
            try {
                this.f36343a = this.b.call();
            } catch (Exception e) {
                e.printStackTrace();
                LiteavLog.e("Stash", "Get value failed. msg:" + e.getMessage());
            }
            return this.f36343a;
        }
    }

    public final void a(T t) {
        synchronized (this) {
            this.f36343a = t;
        }
    }
}
