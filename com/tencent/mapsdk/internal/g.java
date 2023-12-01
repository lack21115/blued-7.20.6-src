package com.tencent.mapsdk.internal;

import java.io.InputStream;
import java.util.Properties;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f23760a;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static String f23761c;

    static {
        try {
            InputStream resourceAsStream = g.class.getResourceAsStream("/com/qq/jce/wup/wup.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            resourceAsStream.close();
            f23760a = properties.getProperty("client.info");
            b = properties.getProperty("client.built");
            f23761c = properties.getProperty("client.number");
        } catch (Throwable th) {
        }
        if (f23760a == null) {
            f23760a = "Tencent Taf";
        }
        if (b == null) {
            b = "unknown";
        }
        if (f23761c == null) {
            f23761c = "unknown";
        }
    }

    public static String a() {
        return b;
    }

    public static String b() {
        return f23760a;
    }

    public static String c() {
        return f23761c;
    }

    public static String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client version: " + b() + "\n");
        sb.append("Client built:   " + a() + "\n");
        sb.append("Client number:  " + c() + "\n");
        sb.append("OS Name:        " + System.getProperty("os.name") + "\n");
        sb.append("OS Version:     " + System.getProperty("os.version") + "\n");
        sb.append("Architecture:   " + System.getProperty("os.arch") + "\n");
        sb.append("JVM Version:    " + System.getProperty("java.runtime.version") + "\n");
        sb.append("JVM Vendor:     " + System.getProperty("java.vm.vendor") + "\n");
        return sb.toString();
    }
}
