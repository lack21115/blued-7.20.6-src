package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.am;
import com.baidu.mobads.sdk.internal.d;
import com.baidu.mobads.sdk.internal.r;
import dalvik.system.DexClassLoader;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/AdservRemoteLoaderImpl.class */
public class AdservRemoteLoaderImpl implements r {
    @Override // com.baidu.mobads.sdk.internal.r
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        return d.a().a(str, str2, str3, classLoader);
    }

    @Override // com.baidu.mobads.sdk.internal.r
    public void startLoadRemotePhp(double d, am.b bVar) {
        d.a().a(d, bVar);
    }
}
