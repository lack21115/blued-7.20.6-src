package com.tencent.beacon.module;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.util.b;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.c.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/module/AuditModule.class */
public class AuditModule implements d, BeaconModule {

    /* renamed from: c  reason: collision with root package name */
    private String f35076c;
    private Set<String> d;
    private Context f;

    /* renamed from: a  reason: collision with root package name */
    private boolean f35075a = true;
    private boolean b = true;
    private int e = 2;

    public static String a() {
        ArrayList<String> a2 = b.a(new String[]{"/system/bin/sh", "-c", "getprop ro.build.fingerprint"});
        return (a2 == null || a2.size() <= 0) ? "" : a2.get(0);
    }

    private String a(String str) {
        String str2;
        if (str != null) {
            String replace = str.replace("=", "%3D").replace(BridgeUtil.SPLIT_MARK, "%2F").replace("+", "%2B");
            str2 = replace;
            if (replace.length() > 1024) {
                return replace + ";";
            }
        } else {
            str2 = "";
        }
        return str2;
    }

    public static String b(Context context) {
        try {
            if (Integer.parseInt(Build.VERSION.SDK) < 9) {
                c.b("[audit] Api level < 9,return null!", new Object[0]);
                return "";
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append("[audit] get app_first_installed_time:");
            sb.append(String.valueOf(packageInfo.firstInstallTime));
            c.a(sb.toString(), new Object[0]);
            return String.valueOf(packageInfo.firstInstallTime);
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }

    private String c() {
        String str;
        return (com.tencent.beacon.e.b.a() == null || (str = this.f35076c) == null) ? "" : str;
    }

    private Activity d() {
        SparseArray<WeakReference<Activity>> a2;
        if (Integer.valueOf(Build.VERSION.SDK).intValue() < 16) {
            return null;
        }
        try {
            String e = e();
            if (e == null || (a2 = com.tencent.beacon.d.a.c.a()) == null) {
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a2.size()) {
                    return null;
                }
                WeakReference<Activity> weakReference = a2.get(a2.keyAt(i2));
                if (weakReference != null && weakReference.get() != null) {
                    Activity activity = weakReference.get();
                    if (activity.getClass().getName().equals(e)) {
                        return activity;
                    }
                }
                i = i2 + 1;
            }
        } catch (Exception e2) {
            c.a(e2);
            return null;
        }
    }

    private String e() {
        return null;
    }

    @Override // com.tencent.beacon.module.BeaconModule
    public void a(Context context) {
        this.f = context;
        com.tencent.beacon.a.a.b.a().a(2, this);
        com.tencent.beacon.a.a.b.a().a(10, this);
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        boolean z;
        int i = cVar.f34920a;
        if (i != 2) {
            if (i != 10) {
                return;
            }
            c.d("[module] native audit module > %s", Boolean.valueOf(this.b));
            if (this.b && com.tencent.beacon.e.b.a().f()) {
                b();
                return;
            }
            return;
        }
        Map map = (Map) cVar.b.get("d_m");
        if (map == null) {
            return;
        }
        this.f35075a = b.a((String) map.get("upAc"), this.f35075a);
        this.e = b.a((String) map.get("deleteSoCrashTime"), this.e, 1, 10);
        this.f35076c = (String) map.get("appendXMeths");
        String str = (String) map.get("auditIgnore");
        if (!TextUtils.isEmpty(str)) {
            this.d = new HashSet(Arrays.asList(str.split(",")));
        }
        if (this.d != null) {
            z = !this.d.contains((f.e().h() + BridgeUtil.UNDERLINE_STR + Build.VERSION.SDK).replaceAll(" ", ""));
        } else {
            z = true;
        }
        boolean z2 = false;
        if (this.f35075a) {
            z2 = false;
            if (z) {
                z2 = true;
            }
        }
        this.b = z2;
    }

    public void b() {
        Context context = this.f;
        if (context != null && com.tencent.beacon.a.c.b.g(context)) {
            c.a("[audit] start upload ac event", new Object[0]);
            e l = e.l();
            HashMap hashMap = new HashMap();
            hashMap.put("A19", l.q());
            hashMap.put("A58", l.m() ? "Y" : "N");
            hashMap.put("A82", a());
            hashMap.put("A85", com.tencent.beacon.a.c.b.d ? "Y" : "N");
            hashMap.put("A88", b(this.f));
            hashMap.put("A89", l.a(this.f));
            hashMap.put("A90", "");
            hashMap.put("A91", "");
            hashMap.put("A92", "");
            hashMap.put("B13", a(a.a(this.f, Integer.valueOf(Build.VERSION.SDK).intValue(), d(), c(), this.e)));
            hashMap.put("A31", "" + l.p());
            ((StatModule) com.tencent.beacon.a.c.c.d().a(ModuleName.STAT)).a(hashMap);
        }
    }
}
