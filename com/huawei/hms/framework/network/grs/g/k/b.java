package com.huawei.hms.framework.network.grs.g.k;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/g/k/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f9108a;
    private final long b = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.f9108a = future;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f9108a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= 300000;
    }
}
