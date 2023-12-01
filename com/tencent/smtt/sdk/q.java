package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/q.class */
class q {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f38875a;
    private Object b = null;

    public q(DexLoader dexLoader) {
        this.f38875a = null;
        this.f38875a = dexLoader;
    }

    public Object a(Context context, Object obj, Bundle bundle) {
        DexLoader dexLoader = this.f38875a;
        if (dexLoader != null) {
            this.b = dexLoader.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[]{Context.class, Object.class, Bundle.class}, context, obj, bundle);
        }
        return this.b;
    }

    public void a() {
        DexLoader dexLoader = this.f38875a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
        }
    }

    public void a(boolean z) {
        DexLoader dexLoader = this.f38875a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void b() {
        DexLoader dexLoader = this.f38875a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
        }
    }

    public void c() {
        DexLoader dexLoader = this.f38875a;
        if (dexLoader != null) {
            dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
        }
    }

    public long d() {
        DexLoader dexLoader = this.f38875a;
        if (dexLoader != null) {
            Object invokeMethod = dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
            if (invokeMethod instanceof Long) {
                return ((Long) invokeMethod).longValue();
            }
            return 0L;
        }
        return 0L;
    }

    public int e() {
        DexLoader dexLoader = this.f38875a;
        if (dexLoader != null) {
            Object invokeMethod = dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                return ((Integer) invokeMethod).intValue();
            }
            return 0;
        }
        return 0;
    }

    public int f() {
        DexLoader dexLoader = this.f38875a;
        if (dexLoader != null) {
            Object invokeMethod = dexLoader.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                return ((Integer) invokeMethod).intValue();
            }
            return 0;
        }
        return 0;
    }
}
