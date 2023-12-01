package com.blued.android.module.base.config;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/config/ConfigProxy.class */
public class ConfigProxy implements IConfig {
    private static ConfigProxy a = new ConfigProxy();
    private IConfig b = null;

    private ConfigProxy() {
    }

    public static ConfigProxy a() {
        return a;
    }

    public void a(IConfig iConfig) {
        this.b = iConfig;
    }
}
