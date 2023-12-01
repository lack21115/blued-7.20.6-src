package com.opos.mobad.cmn.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.oplus.quickgame.sdk.hall.Constant;
import com.opos.acs.st.STManager;
import com.opos.mobad.activity.VideoActivity;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.provider.statistic.StatisticModelIdentify;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b/d.class */
public final class d {
    private static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        boolean z = true;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    z = true;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    z = false;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    z = true;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    z = true;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    z = true;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    z = true;
                    break;
                }
                break;
        }
        if (z) {
            str2 = "3";
            if (!z) {
                return !z ? !z ? !z ? !z ? "" : "9" : "8" : "7" : "10";
            }
        } else {
            str2 = "1";
        }
        return str2;
    }

    public static Map<String, String> a(long j, long j2) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("vDrt", j2 + "");
            hashMap.put("vedioduration", j2 + "");
            hashMap.put("vPlyPos", j + "");
            hashMap.put("currentPos", j + "");
            return hashMap;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
            return hashMap;
        }
    }

    public static Map<String, String> a(String str, long j, long j2) {
        HashMap hashMap = new HashMap();
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                Map<String, String> a2 = a(j, j2);
                if (a2 != null && a2.size() > 0) {
                    hashMap.putAll(a2);
                }
                hashMap.put("vPrs", str);
                hashMap.put("playProgress", str);
                return hashMap;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
        }
        return hashMap;
    }

    public static void a(final Context context, final AdItemData adItemData, final MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.j(b, "lm-click");
                    d.h(b, AdItemData.this.g());
                    b.put("evtType", "6");
                    d.b(b);
                    b.put("valid", "1");
                    b.put("dlChannel", materialData.t());
                    d.b(AdItemData.this, materialData, b);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdInstallCompleteEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final AdItemData adItemData, final MaterialData materialData, final String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    b.put(STManager.KEY_DATA_TYPE, "lm-common");
                    b.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                    d.b(b);
                    b.put("valid", "1");
                    d.b(AdItemData.this, materialData, b);
                    b.put("dlChannel", materialData.t());
                    b.put("data_event", "1");
                    b.put("status", "2");
                    if (!TextUtils.isEmpty(str)) {
                        b.put("errormsg", str);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderFailEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr) {
        a(context, adItemData, materialData, z, iArr, (Map<String, String>) null);
    }

    public static void a(final Context context, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.j(b, "lm-click");
                    d.h(b, AdItemData.this.g());
                    b.put("valid", z ? "1" : "0");
                    b.put("evtType", "7");
                    b.put("dlChannel", materialData.t());
                    d.b(AdItemData.this, materialData, b);
                    d.b(iArr, b);
                    d.b(b);
                    if (map != null && map.size() > 0) {
                        b.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdLaunchAppHomePageEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final AdItemData adItemData, final MaterialData materialData, final int i) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    b.put(STManager.KEY_DATA_TYPE, "lm-feedback");
                    b.put(STManager.KEY_AD_POS_ID, str);
                    b.put("uSdkVC", f.h() + "");
                    b.put("fbContent", i + "");
                    d.b(AdItemData.this, materialData, b);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFeedbackEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int i, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.j(b, "lm-expose");
                    d.h(b, str);
                    b.put("valid", z ? "1" : "0");
                    b.put("sspWinPrice", i + "");
                    d.b(b);
                    d.b(AdItemData.this, materialData, b);
                    if (map != null && map.size() > 0) {
                        b.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final String str2, final int i) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Map b = d.b(Context.this);
                    d.j(b, "lm-play");
                    d.h(b, str);
                    d.b(b);
                    b.put("valid", z ? "1" : "0");
                    if (!TextUtils.isEmpty(str2)) {
                        b.put("clientTemplateId", str2);
                    }
                    d.b(adItemData, materialData, b);
                    d.b(i, b);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b);
                    d.b(Context.this, materialData != null ? materialData.r() : "", b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, Map<String, String> map) {
        a(context, str, adItemData, materialData, z, 0, map);
    }

    public static void a(final Context context, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.j(b, "lm-click");
                    d.h(b, str);
                    b.put("evtType", "1");
                    b.put("valid", z ? "1" : "0");
                    d.b(AdItemData.this, materialData, b);
                    d.b(iArr, b);
                    d.b(b);
                    if (map != null && map.size() > 0) {
                        b.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(Context context, String str, AdItemData adItemData, MaterialData materialData, int[] iArr, boolean z) {
        HashMap hashMap = new HashMap();
        a(hashMap, z ? "5" : "4");
        a(context, str, false, adItemData, materialData, (Map<String, String>) hashMap, iArr);
    }

    public static void a(final Context context, final String str, final String str2, final int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("STEventUtils", "report null");
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.16
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-activation");
                        b.put(STManager.KEY_AD_POS_ID, str);
                        b.put(Constant.ParamObjKey.KEY_EXTERNAL_TARGET_PKG, str2 == null ? "" : str2);
                        b.put("code", String.valueOf(i));
                        d.b(Context.this, (String) null, b);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("STEventUtils", "", e);
                    }
                }
            });
        }
    }

    public static void a(final Context context, final String str, final String str2, final int i, final long j) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        b.put(STManager.KEY_AD_POS_ID, str);
                        d.i(b, str2);
                        b.put("rsCode", String.valueOf(i));
                        b.put("rt", String.valueOf(j));
                        b.put("uSdkVC", f.h() + "");
                        b.put("type", "1");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final int i, final long j, final boolean z, final String str3, final String str4) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b.put(STManager.KEY_AD_POS_ID, str);
                        b.put("adSource", "");
                        d.i(b, str2);
                        b.put("rt", String.valueOf(j));
                        b.put("uSdkVC", f.h() + "");
                        b.put("ret", "2");
                        d.g(b, "");
                        HashMap hashMap = new HashMap();
                        hashMap.put("rsCode", "" + i);
                        b.put("cache", z ? "1" : "0");
                        b.put(UMModuleRegister.PROCESS, str3 != null ? str3 : "");
                        b.put("classifyByAge", str4 != null ? str4 : "");
                        if (hashMap.size() > 0) {
                            b.putAll(hashMap);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final int i, final String str3, final long j) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        b.put("rsCode", String.valueOf(i));
                        b.put(STManager.KEY_AD_POS_ID, str);
                        d.i(b, str2);
                        b.put("rt", String.valueOf(j));
                        b.put("uSdkVC", f.h() + "");
                        b.put("type", "2");
                        b.put("adStates", str3 != null ? str3 : "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCatchFetchEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final int i, final String str3, final long j, final String str4, final boolean z) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        b.put(STManager.KEY_AD_POS_ID, str);
                        d.i(b, str2);
                        b.put("rsCode", String.valueOf(i));
                        b.put("ret", "2");
                        b.put("rt", String.valueOf(j));
                        b.put("uSdkVC", f.h() + "");
                        b.put("type", z ? "2" : "1");
                        b.put("filteIds", str3 != null ? str3 : "");
                        b.put("st", str4 != null ? str4 : "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final int i, final String str3, final long j, final boolean z, final String str4, final String str5) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b.put(STManager.KEY_AD_POS_ID, str);
                        b.put("adSource", "");
                        d.i(b, str2);
                        b.put("rt", String.valueOf(j));
                        b.put("uSdkVC", f.h() + "");
                        b.put("ret", "2");
                        d.g(b, "");
                        HashMap hashMap = new HashMap();
                        hashMap.put("rsCode", "" + i);
                        b.put("cache", z ? "1" : "0");
                        b.put("filteIds", str3 != null ? str3 : "");
                        b.put("st", str4 != null ? str4 : "");
                        b.put("classifyByAge", str5 != null ? str5 : "");
                        if (hashMap.size() > 0) {
                            b.putAll(hashMap);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final long j, final boolean z, final String str4, final String str5, final int i) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b.put(STManager.KEY_AD_POS_ID, str);
                        b.put("adSource", "");
                        d.i(b, str3);
                        b.put("rt", String.valueOf(j));
                        b.put("uSdkVC", f.h() + "");
                        b.put("ret", "1");
                        b.put(UMModuleRegister.PROCESS, str4 != null ? str4 : "");
                        d.g(b, str2);
                        b.put("cache", z ? "1" : "0");
                        b.put("classifyByAge", str5 != null ? str5 : "");
                        b.put("ecpm", i + "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final String str4, final long j, final String str5, final boolean z) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        b.put(STManager.KEY_AD_POS_ID, str);
                        d.i(b, str2);
                        b.put("ret", str3);
                        b.put("rt", String.valueOf(j));
                        b.put("uSdkVC", f.h() + "");
                        b.put("type", z ? "2" : "1");
                        b.put("filteIds", str4 != null ? str4 : "");
                        b.put("st", str5 != null ? str5 : "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final String str4, final long j, final boolean z, final String str5, final String str6, final int i) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b.put(STManager.KEY_AD_POS_ID, str);
                        b.put("adSource", "");
                        d.i(b, str3);
                        b.put("rt", String.valueOf(j));
                        b.put("uSdkVC", f.h() + "");
                        b.put("ret", "1");
                        b.put("filteIds", str4 != null ? str4 : "");
                        b.put("st", str5 != null ? str5 : "");
                        d.g(b, str2);
                        b.put("cache", z ? "1" : "0");
                        b.put("classifyByAge", str6 != null ? str6 : "");
                        b.put("ecpm", i + "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final String str2, final String str3, final String str4, final String str5, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(Context.this, str2)) {
                        Map b = d.b(Context.this);
                        b.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b.put(STManager.KEY_AD_POS_ID, str2);
                        b.put("adSource", str);
                        d.i(b, str5);
                        b.put("ret", str3);
                        d.g(b, str4);
                        if (map != null && map.size() > 0) {
                            b.putAll(map);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b);
                        d.b(Context.this, b);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(final Context context, final String str, final boolean z, final AdItemData adItemData, final MaterialData materialData, final Map<String, String> map, final int[] iArr) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                String str2 = "2";
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.j(b, "lm-click");
                    b.put("evtType", "2");
                    d.h(b, str);
                    d.b(AdItemData.this, materialData, b);
                    d.b(iArr, b);
                    if (z) {
                        str2 = "3";
                    } else if (1 != AdItemData.this.k()) {
                        if (2 == AdItemData.this.k()) {
                        }
                        d.b(b);
                        if (map != null && map.size() > 0) {
                            b.putAll(map);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCloseEvent map=", b);
                        d.b(context, materialData.r(), b);
                    } else {
                        str2 = "1";
                    }
                    d.a(b, str2);
                    d.b(b);
                    if (map != null) {
                        b.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCloseEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void a(View view, Map<String, String> map) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            map.put("expCoordinate", iArr[0] + "-" + iArr[1]);
            int height = view.getHeight();
            int width = view.getWidth();
            map.put("expSize", width + "-" + height);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
        }
    }

    public static void a(Map<String, String> map, String str) {
        if (map != null) {
            map.put("clsType", str);
            map.put("handleObj", "12");
            map.put("handleValue", b(str));
        }
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map != null) {
            try {
                map.put("actSource", str);
                map.put("handleObj", a(str));
                map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, String.valueOf(str2));
                map.put("handleValue", String.valueOf(str2));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
            }
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        boolean z = true;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    z = true;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    z = true;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    z = false;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    z = true;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    z = true;
                    break;
                }
                break;
        }
        return z ? !z ? !z ? !z ? !z ? "" : "24" : "25" : "22" : "21" : "23";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> b(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", f.a());
        hashMap.put("phBrand", com.opos.cmn.an.b.a.a(context));
        hashMap.put("phMaker", com.opos.cmn.an.b.c.e());
        hashMap.put("aid", com.opos.mobad.service.e.a.a().e());
        hashMap.put("ua", f.i());
        hashMap.put("ouidStatus", com.opos.mobad.service.e.a.a().j() ? "1" : "0");
        hashMap.put("appOuidStatus", com.opos.mobad.service.e.a.a().d() ? "1" : "0");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, Map<String, String> map) {
        try {
            map.put("vPlyRet", i + "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
        }
    }

    public static void b(final Context context, final AdItemData adItemData, final MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    b.put(STManager.KEY_DATA_TYPE, "lm-common");
                    b.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                    d.b(AdItemData.this, materialData, b);
                    d.b(b);
                    b.put("valid", "1");
                    b.put("dlChannel", materialData.t());
                    b.put("data_event", "1");
                    b.put("status", "1");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderStartEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void b(final Context context, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.j(b, "lm-play");
                    d.h(b, str);
                    d.b(b);
                    b.put("valid", z ? "1" : "0");
                    d.b(AdItemData.this, materialData, b);
                    if (map != null && map.size() > 0) {
                        b.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void b(final Context context, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.j(b, "lm-click");
                    d.h(b, str);
                    b.put("evtType", "4");
                    b.put("valid", z ? "1" : "0");
                    d.b(AdItemData.this, materialData, b);
                    d.b(iArr, b);
                    d.b(b);
                    if (map != null && map.size() > 0) {
                        b.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, Map<String, String> map) {
        String c2;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    c2 = c(map);
                    new com.opos.mobad.provider.statistic.a(com.opos.mobad.service.b.a(context), new StatisticModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b())).a(str, c2);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("STEventUtils", "report transform fail", e);
                return;
            }
        }
        c2 = "";
        new com.opos.mobad.provider.statistic.a(com.opos.mobad.service.b.a(context), new StatisticModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b())).a(str, c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Map<String, String> map) {
        b(context, (String) null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdItemData adItemData, MaterialData materialData, Map<String, String> map) {
        map.put("adSource", adItemData.b());
        map.put("adId", adItemData.f());
        map.put("cache", adItemData.I() ? "1" : "0");
        map.put("planId", adItemData.h());
        g(map, adItemData.c());
        map.put("mtId", materialData.c());
        map.put("traceId", materialData.q());
        i(map, adItemData.a());
        map.put("classifyByAge", adItemData.W() != null ? adItemData.W() : "");
        if (TextUtils.isEmpty(adItemData.aa())) {
            return;
        }
        map.put("cKeyWords", adItemData.aa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Map<String, String> map) {
        map.put("uSdkVC", f.h() + "");
        map.put("bizSdkVer", f.h() + "");
        map.put("InstVer", com.opos.mobad.service.f.a.a().d());
        map.put("InstSdkVer", com.opos.mobad.service.f.a.a().b());
    }

    public static void b(Map<String, String> map, String str) {
        if (map != null) {
            map.put("foregroundStatus", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int[] iArr, Map<String, String> map) {
        if (iArr == null || iArr.length != 4) {
            return;
        }
        map.put(STManager.KEY_DOWN_X, iArr[0] + "");
        map.put(STManager.KEY_DOWN_Y, iArr[1] + "");
        map.put(STManager.KEY_UP_X, iArr[2] + "");
        map.put(STManager.KEY_UP_Y, iArr[3] + "");
        map.put("coordinates", iArr[2] + "-" + iArr[3] + "-" + iArr[0] + "-" + iArr[1]);
    }

    private static String c(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject.toString();
    }

    public static void c(final Context context, final AdItemData adItemData, final MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    b.put(STManager.KEY_DATA_TYPE, "lm-common");
                    b.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                    d.b(b);
                    b.put("valid", "1");
                    b.put("dlChannel", materialData.t());
                    d.b(AdItemData.this, materialData, b);
                    b.put("data_event", "1");
                    b.put("status", "3");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderCompleteEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void c(final Context context, final String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.h(b, str);
                    d.j(b, "lm-click");
                    b.put("evtType", "5");
                    b.put("valid", z ? "1" : "0");
                    d.b(AdItemData.this, materialData, b);
                    d.b(iArr, b);
                    d.b(b);
                    if (map != null && map.size() > 0) {
                        b.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordDeepLinkEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    public static void d(final Context context, String str, final AdItemData adItemData, final MaterialData materialData, final boolean z, final int[] iArr, final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b = d.b(context);
                    d.j(b, "lm-click");
                    d.h(b, AdItemData.this.g());
                    d.b(AdItemData.this, materialData, b);
                    b.put("evtType", "9");
                    d.b(b);
                    b.put("valid", z ? "1" : "0");
                    d.b(iArr, b);
                    if (map != null && map.size() > 0) {
                        b.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b);
                    d.b(context, materialData.r(), b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Map<String, String> map, String str) {
        if (map != null) {
            map.put("respId", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Map<String, String> map, String str) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.put(STManager.KEY_AD_POS_ID, str);
        map.put("newPosId", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Map<String, String> map, String str) {
        if (map != null) {
            map.put("sdkReqId", str != null ? str : "");
            if (str == null) {
                str = "";
            }
            map.put("reqId", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Map<String, String> map, String str) {
        if (map != null) {
            map.put(STManager.KEY_DATA_TYPE, str);
            map.put("oriDatatype", str);
        }
    }
}
