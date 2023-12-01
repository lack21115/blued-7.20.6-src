package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Byte, e> f8122a = new ConcurrentHashMap<>();

    public final e a(byte b) {
        if (!this.f8122a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                this.f8122a.putIfAbsent(Byte.valueOf(b), new g());
            } else if (b != 2) {
                Log.w("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)));
            } else {
                this.f8122a.putIfAbsent(Byte.valueOf(b), new d());
            }
        }
        return this.f8122a.get(Byte.valueOf(b));
    }
}
