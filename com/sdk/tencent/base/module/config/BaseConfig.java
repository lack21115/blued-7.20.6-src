package com.sdk.tencent.base.module.config;

import com.sdk.tencent.f.b;
import com.sdk.tencent.k.a;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/module/config/BaseConfig.class */
public class BaseConfig implements b {
    public static String apk = "com.cucc.sdk.api_key";

    /* renamed from: c  reason: collision with root package name */
    public static int f28025c = 46;
    public static String cm = "CUCC";
    public static String n = "SDKFactory";
    public static String v = "安卓4.0.2专业版Z21022214";
    public long r = System.currentTimeMillis();

    public String getApiKey() {
        return apk;
    }

    public String getCM() {
        return cm;
    }

    public String toJsonString() {
        return a.a(this);
    }
}
