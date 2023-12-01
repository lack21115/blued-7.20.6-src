package com.igexin.push.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.igexin.push.core.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23570a = -1;
    public static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23571c = 1;
    private static final String d = "LoginInteractor";
    private static k e;

    public static k a() {
        if (e == null) {
            e = new k();
        }
        return e;
    }

    private static void a(List<com.igexin.push.c.c.j> list) {
        if (ServiceManager.getInstance().initType == null) {
            return;
        }
        int intValue = ServiceManager.getInstance().initType.first.intValue();
        String valueOf = String.valueOf(intValue);
        String str = valueOf;
        if (intValue == 1) {
            str = valueOf + "#" + ServiceManager.getInstance().initType.second;
        }
        com.igexin.push.c.c.j jVar = new com.igexin.push.c.c.j();
        jVar.f23347a = (byte) 5;
        jVar.b = str;
        list.add(jVar);
    }

    public static int b() {
        if (!e.s || com.igexin.push.f.c.a(System.currentTimeMillis()) || !com.igexin.push.f.c.a()) {
            com.igexin.c.a.c.a.a(d, "keyNegotiate stop ++++++++++");
            com.igexin.c.a.c.a.a("LoginInteractor|keyNegotiate stop ++++++++++", new Object[0]);
            return -1;
        }
        com.igexin.push.c.c.g gVar = new com.igexin.push.c.c.g();
        gVar.b = e.f23495a;
        int a2 = d.a.f23474a.h.a("K-", gVar, true);
        com.igexin.c.a.c.a.a("LoginInteractor|keyNegotiate result=".concat(String.valueOf(a2)), new Object[0]);
        return a2 < 0 ? 0 : 1;
    }

    public static void c() {
        com.igexin.c.a.c.a.d.a().a("[LoginInteractor] Start login appid = " + e.f23495a);
        if (e.t) {
            e.t = false;
            e.T = System.currentTimeMillis() + (Math.abs(new Random().nextInt() % 24) * 3600000);
        }
        com.igexin.push.b.c.a().d().d();
        boolean z = true;
        boolean z2 = true;
        if (e.z == 0) {
            com.igexin.c.a.c.a.a("registerReq #####", new Object[0]);
            com.igexin.push.c.c.d dVar = new com.igexin.push.c.c.d(e.D, e.E, e.L, e.f23495a);
            String str = e.D;
            String str2 = e.E;
            String str3 = e.L;
            if (d.a.f23474a.h.a("R-" + e.L, dVar, true) < 0) {
                z2 = false;
            }
            com.igexin.c.a.c.a.a("registerReq|" + z2 + "|" + e.L, new Object[0]);
            return;
        }
        long j = e.z;
        com.igexin.push.c.c.i d2 = d();
        com.igexin.c.a.c.a.a("loginReqBefore|" + d2.b, new Object[0]);
        if (d.a.f23474a.h.a("S-" + e.z, d2, true) < 0) {
            z = false;
        }
        if (z) {
            String str4 = e.A;
            com.igexin.c.a.c.a.a("LoginInteractor|loginReq|" + e.A, new Object[0]);
        }
    }

    public static com.igexin.push.c.c.i d() {
        Pair<String, String> b2;
        com.igexin.push.c.c.i iVar = new com.igexin.push.c.c.i();
        iVar.b = e.z;
        iVar.f23346c = (byte) 0;
        iVar.d = 65280;
        iVar.e = e.f23495a;
        try {
            ArrayList<com.igexin.push.c.c.j> arrayList = new ArrayList();
            ConnectivityManager connectivityManager = (ConnectivityManager) e.l.getSystemService(Context.CONNECTIVITY_SERVICE);
            int i = -1;
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                i = -1;
                if (activeNetworkInfo != null) {
                    int type = activeNetworkInfo.getType();
                    com.igexin.push.c.c.j jVar = new com.igexin.push.c.c.j();
                    jVar.f23347a = (byte) 2;
                    jVar.b = String.valueOf(type);
                    arrayList.add(jVar);
                    i = type;
                }
            }
            if (i == 1 && (b2 = com.igexin.push.f.n.b()) != null) {
                String str = b2.first;
                String str2 = b2.second;
                if (str != null) {
                    com.igexin.push.c.c.j jVar2 = new com.igexin.push.c.c.j();
                    jVar2.f23347a = (byte) 1;
                    jVar2.b = str;
                    arrayList.add(jVar2);
                }
                if (str2 != null) {
                    com.igexin.push.c.c.j jVar3 = new com.igexin.push.c.c.j();
                    jVar3.f23347a = (byte) 4;
                    jVar3.b = str2;
                    arrayList.add(jVar3);
                }
            }
            String q = com.igexin.push.f.n.q();
            if (!TextUtils.isEmpty(q)) {
                String[] split = q.split("#");
                if (split.length >= 3 && !TextUtils.isEmpty(split[2])) {
                    com.igexin.push.c.c.j jVar4 = new com.igexin.push.c.c.j();
                    jVar4.f23347a = (byte) 6;
                    jVar4.b = split[2];
                    arrayList.add(jVar4);
                }
            }
            if (ServiceManager.getInstance().initType != null) {
                int intValue = ServiceManager.getInstance().initType.first.intValue();
                String valueOf = String.valueOf(intValue);
                String str3 = valueOf;
                if (intValue == 1) {
                    str3 = valueOf + "#" + ServiceManager.getInstance().initType.second;
                }
                com.igexin.push.c.c.j jVar5 = new com.igexin.push.c.c.j();
                jVar5.f23347a = (byte) 5;
                jVar5.b = str3;
                arrayList.add(jVar5);
            }
            StringBuilder sb = new StringBuilder();
            for (com.igexin.push.c.c.j jVar6 : arrayList) {
                sb.append((String) jVar6.b);
                sb.append("|");
            }
            com.igexin.c.a.c.a.a("LoginInteractor| ".concat(String.valueOf(sb)), new Object[0]);
            if (!arrayList.isEmpty()) {
                iVar.f = arrayList;
                return iVar;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return iVar;
    }
}
