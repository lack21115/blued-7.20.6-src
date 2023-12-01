package com.getui.gtc.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.getui.gtc.api.GtcIdCallback;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.e.c;
import com.getui.gtc.e.d;
import com.getui.gtc.h.c;
import com.getui.gtc.server.ServerManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/c/b.class */
public final class b {
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    public static String f21921c;
    public static volatile String d;
    public static String e;
    public static String f;
    public static String g;

    /* renamed from: a  reason: collision with root package name */
    public static String f21920a = GtcProvider.context().getPackageName();
    private static final List<GtcIdCallback> j = new ArrayList();
    public static String h = com.igexin.push.a.k;
    public static String i = com.igexin.push.a.j;

    public static void a() {
        List asList;
        List asList2;
        List asList3;
        String str;
        c cVar;
        c cVar2;
        c cVar3;
        try {
            ApplicationInfo applicationInfo = GtcProvider.context().getPackageManager().getApplicationInfo(GtcProvider.context().getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                String string = applicationInfo.metaData.getString("GTC_C");
                if (!TextUtils.isEmpty(string)) {
                    e = string;
                }
                String string2 = applicationInfo.metaData.getString("GTC_B");
                if (!TextUtils.isEmpty(string2)) {
                    f = string2;
                }
                String string3 = applicationInfo.metaData.getString("GTC_A");
                if (!TextUtils.isEmpty(string3)) {
                    g = string3;
                }
                String string4 = applicationInfo.metaData.getString("GTC_P");
                if (!TextUtils.isEmpty(string4)) {
                    h = string4;
                }
                String string5 = applicationInfo.metaData.getString("GTC_K");
                if (!TextUtils.isEmpty(string5)) {
                    i = string5;
                }
                String string6 = applicationInfo.metaData.getString("GETUI_APPID");
                if (TextUtils.isEmpty(string6)) {
                    string6 = applicationInfo.metaData.getString("GETUI_APP_ID");
                    if (TextUtils.isEmpty(string6)) {
                        string6 = applicationInfo.metaData.getString(com.igexin.push.core.b.b);
                        if (TextUtils.isEmpty(string6)) {
                            string6 = applicationInfo.metaData.getString("GI_APPID");
                            if (TextUtils.isEmpty(string6)) {
                                string6 = applicationInfo.metaData.getString("GI_APP_ID");
                                if (TextUtils.isEmpty(string6)) {
                                    string6 = applicationInfo.metaData.getString("GS_APPID");
                                    if (TextUtils.isEmpty(string6)) {
                                        string6 = applicationInfo.metaData.getString("GS_APP_ID");
                                        if (TextUtils.isEmpty(string6)) {
                                            string6 = applicationInfo.metaData.getString("GY_APPID");
                                            if (TextUtils.isEmpty(string6)) {
                                                String string7 = applicationInfo.metaData.getString("GY_APP_ID");
                                                if (!TextUtils.isEmpty(string7)) {
                                                    f21920a = string7;
                                                }
                                                String string8 = applicationInfo.metaData.getString("com.sdk.plus.appid");
                                                if (!TextUtils.isEmpty(string8)) {
                                                    f21920a = string8;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                f21920a = string6;
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
        HashMap hashMap = new HashMap();
        try {
            asList = Arrays.asList(e.split(","));
        } catch (Throwable th2) {
            try {
                asList = Arrays.asList("https://c-gtc.getui.net,https://c-gtc.gepush.com".split(","));
            } catch (Throwable th3) {
                hashMap.put("gtc.cs", Arrays.asList(new String[0]));
                throw th3;
            }
        }
        hashMap.put("gtc.cs", asList);
        try {
            asList2 = Arrays.asList(g.split(","));
        } catch (Throwable th4) {
            try {
                asList2 = Arrays.asList("https://gtc.getui.net,https://gtc.gepush.com".split(","));
            } catch (Throwable th5) {
                hashMap.put("gtc.as", Arrays.asList(new String[0]));
                throw th5;
            }
        }
        hashMap.put("gtc.as", asList2);
        try {
            asList3 = Arrays.asList(f.split(","));
        } catch (Throwable th6) {
            try {
                asList3 = Arrays.asList("https://b-gtc.getui.net,https://b-gtc.gepush.com".split(","));
            } catch (Throwable th7) {
                hashMap.put("gtc.bs", Arrays.asList(new String[0]));
                throw th7;
            }
        }
        hashMap.put("gtc.bs", asList3);
        ServerManager.addBuildInServerMap(hashMap);
        if (TextUtils.isEmpty(d)) {
            cVar3 = c.a.f21997a;
            d = cVar3.f21995a.f21999c;
        }
        if (TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(f21921c)) {
                cVar2 = c.a.f21997a;
                f21921c = cVar2.f21995a.d;
            }
            if (TextUtils.isEmpty(f21921c)) {
                if (TextUtils.isEmpty(b)) {
                    Context context = GtcProvider.context();
                    String a2 = com.getui.gtc.b.a.a(context);
                    String str2 = a2;
                    if (TextUtils.isEmpty(a2)) {
                        str2 = context.getSharedPreferences("GINSIGHT-SDK-PREFERENCE", 0).getString("gicid", null);
                    }
                    b = str2;
                }
                if (TextUtils.isEmpty(b)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("gtc_");
                    long currentTimeMillis = System.currentTimeMillis();
                    String packageName = GtcProvider.context().getPackageName();
                    String a3 = com.getui.gtc.i.a.a.a(UUID.randomUUID().toString() + "-" + currentTimeMillis + "-" + packageName);
                    sb.append(a3);
                    char charAt = a3.charAt(a3.length() - 1);
                    if (charAt < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(charAt));
                    f21921c = sb.toString();
                    cVar = c.a.f21997a;
                    d dVar = cVar.f21995a;
                    String str3 = f21921c;
                    if (dVar.a(9, str3)) {
                        dVar.d = str3;
                    }
                } else {
                    str = b;
                    d = str;
                    a(str);
                }
            }
            str = f21921c;
            d = str;
            a(str);
        }
        ServerManager.updateConfigServerMap();
        Log.d("GTC", "gtcid is " + d);
    }

    public static void a(GtcIdCallback gtcIdCallback) throws RemoteException {
        if (gtcIdCallback != null) {
            gtcIdCallback.onSuccess(d);
            j.add(gtcIdCallback);
        }
    }

    private static void a(final String str) {
        com.getui.gtc.h.c.a(str, new c.a() { // from class: com.getui.gtc.c.b.1
            @Override // com.getui.gtc.h.c.a
            public final void a(String str2) {
                com.getui.gtc.e.c cVar;
                b.d = str2;
                if (!TextUtils.equals(String.this, str2)) {
                    try {
                        Log.d("GTC", "gtcid changed to " + b.d);
                        for (GtcIdCallback gtcIdCallback : b.j) {
                            gtcIdCallback.onSuccess(b.d);
                        }
                    } catch (Throwable th) {
                        com.getui.gtc.i.c.a.a(th);
                    }
                }
                b.j.clear();
                cVar = c.a.f21997a;
                d dVar = cVar.f21995a;
                String str3 = b.d;
                if (dVar.a(4, str3)) {
                    dVar.f21999c = str3;
                }
            }
        });
    }
}
