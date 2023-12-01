package com.sdk.tencent.m;

import com.sdk.tencent.base.module.manager.SDKManager;
import com.sdk.tencent.f.c;
import com.sdk.tencent.n.b;
import java.util.Properties;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/m/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14373a = "a";
    public static final boolean b = c.b;

    public static String a(String str, String str2) {
        if (b.a(str2).booleanValue()) {
            return null;
        }
        Properties properties = new Properties();
        try {
            properties.load(SDKManager.getContext().getAssets().open(str));
        } catch (Exception e) {
            String str3 = f14373a;
            b.a(str3, "域名读取失败！《" + str2 + "+》", Boolean.valueOf(b));
        }
        return properties.getProperty(str2);
    }
}
