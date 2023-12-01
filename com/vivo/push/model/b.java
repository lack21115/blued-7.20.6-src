package com.vivo.push.model;

import android.text.TextUtils;
import com.alipay.sdk.util.i;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/model/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f41110a;
    private String d;
    private long b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f41111c = -1;
    private boolean e = false;
    private boolean f = false;

    public b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f41110a = str;
    }

    public final String a() {
        return this.f41110a;
    }

    public final void a(int i) {
        this.f41111c = i;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final long b() {
        return this.b;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final boolean c() {
        return this.e;
    }

    public final boolean d() {
        return this.f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f41110a + ", mPushVersion=" + this.b + ", mPackageVersion=" + this.f41111c + ", mInBlackList=" + this.e + ", mPushEnable=" + this.f + i.d;
    }
}
