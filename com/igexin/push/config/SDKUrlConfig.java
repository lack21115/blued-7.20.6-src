package com.igexin.push.config;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/SDKUrlConfig.class */
public class SDKUrlConfig {
    private static String[] b;
    private static final String d = "socket://sdk.open.talk.igexin.com:5224";
    private static final String e = "socket://sdk.open.talk.getui.net:5224";
    private static final String f = "socket://sdk.open.talk.gepush.com:5224";
    private static volatile String h;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f23359a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static String f23360c = "HZ";
    private static String[] g = {"socket://sdk.open.talk.igexin.com:5224", "socket://sdk.open.talk.getui.net:5224", "socket://sdk.open.talk.gepush.com:5224"};
    public static String[] XFR_ADDRESS_BAK = {com.igexin.push.a.m};
    public static String[] BI_ADDRESS_IPS = {com.igexin.push.a.g};
    public static String[] CONFIG_ADDRESS_IPS = {com.igexin.push.a.h};
    public static String[] LOG_ADDRESS_IPS = {com.igexin.push.a.l};

    public static String getBiUploadServiceUrl() {
        return BI_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getConfigServiceUrl() {
        return CONFIG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getConnectAddress() {
        return h == null ? g[0] : h;
    }

    public static List<String> getDefaultXfrList() {
        String[] xfrAddress = getXfrAddress();
        ArrayList arrayList = new ArrayList();
        int length = xfrAddress.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            String str = xfrAddress[i2];
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
            i = i2 + 1;
        }
    }

    public static String[] getIdcConfigUrl() {
        return b;
    }

    public static String getLocation() {
        return f23360c;
    }

    public static String getLogServiceUrl() {
        return LOG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String[] getXfrAddress() {
        String[] strArr;
        synchronized (f23359a) {
            strArr = g;
        }
        return strArr;
    }

    public static boolean hasMultipleXfr() {
        return getDefaultXfrList().size() > 1;
    }

    public static void setConnectAddress(String str) {
        com.igexin.c.a.c.a.a("set cm address : ".concat(String.valueOf(str)), new Object[0]);
        h = str;
    }

    public static void setIdcConfigUrl(String[] strArr) {
        b = strArr;
    }

    public static void setLocation(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.push.core.e.f = str;
        f23360c = str;
    }

    public static void setXfrAddressIps(String[] strArr) {
        synchronized (f23359a) {
            g = strArr;
        }
    }
}
