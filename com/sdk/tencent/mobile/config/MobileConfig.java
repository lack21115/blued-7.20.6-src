package com.sdk.tencent.mobile.config;

import com.sdk.tencent.base.module.config.BaseConfig;
import com.sdk.tencent.f.b;
import com.sdk.tencent.k.a;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/mobile/config/MobileConfig.class */
public class MobileConfig implements b {
    public String apk = BaseConfig.apk;
    public String cm = BaseConfig.cm;

    /* renamed from: c  reason: collision with root package name */
    public int f28062c = 1;
    public String v = "1.0";
    public String n = "ZzxOAuth";
    public long r = System.currentTimeMillis();

    public String getApiKey() {
        return this.apk;
    }

    public String getCM() {
        return this.cm;
    }

    public String toJsonString() {
        return a.a(this);
    }
}
