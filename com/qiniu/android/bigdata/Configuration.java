package com.qiniu.android.bigdata;

import com.qiniu.android.http.ProxyConfiguration;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/bigdata/Configuration.class */
public final class Configuration implements Cloneable {
    public ProxyConfiguration proxy;
    public String pipelineHost = "https://pipeline.qiniu.com";
    public int connectTimeout = 3;
    public int responseTimeout = 10;

    public static Configuration copy(Configuration configuration) {
        if (configuration == null) {
            return new Configuration();
        }
        try {
            return configuration.m5462clone();
        } catch (CloneNotSupportedException e) {
            return new Configuration();
        }
    }

    /* renamed from: clone */
    public Configuration m5462clone() throws CloneNotSupportedException {
        return (Configuration) super.clone();
    }
}
