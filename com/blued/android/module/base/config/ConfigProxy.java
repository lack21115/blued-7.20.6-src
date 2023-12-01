package com.blued.android.module.base.config;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/config/ConfigProxy.class */
public class ConfigProxy implements IConfig {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigProxy f10427a = new ConfigProxy();
    private IConfig b = null;

    private ConfigProxy() {
    }

    public static ConfigProxy a() {
        return f10427a;
    }

    public void a(IConfig iConfig) {
        this.b = iConfig;
    }
}
