package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/v.class */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static v f28013a;

    /* renamed from: a  reason: collision with other field name */
    private Context f1035a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f1036a = new ArrayList();
    private final List<String> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f28014c = new ArrayList();

    private v(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f1035a = applicationContext;
        if (applicationContext == null) {
            this.f1035a = context;
        }
        SharedPreferences sharedPreferences = this.f1035a.getSharedPreferences("mipush_app_info", 0);
        String[] split = sharedPreferences.getString("unregistered_pkg_names", "").split(",");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String str = split[i2];
            if (TextUtils.isEmpty(str)) {
                this.f1036a.add(str);
            }
            i = i2 + 1;
        }
        String[] split2 = sharedPreferences.getString("disable_push_pkg_names", "").split(",");
        int length2 = split2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                break;
            }
            String str2 = split2[i4];
            if (!TextUtils.isEmpty(str2)) {
                this.b.add(str2);
            }
            i3 = i4 + 1;
        }
        String[] split3 = sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",");
        int length3 = split3.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                return;
            }
            String str3 = split3[i6];
            if (!TextUtils.isEmpty(str3)) {
                this.f28014c.add(str3);
            }
            i5 = i6 + 1;
        }
    }

    public static v a(Context context) {
        if (f28013a == null) {
            f28013a = new v(context);
        }
        return f28013a;
    }

    public void a(String str) {
        synchronized (this.f1036a) {
            if (!this.f1036a.contains(str)) {
                this.f1036a.add(str);
                this.f1035a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bn.a(this.f1036a, ",")).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m9165a(String str) {
        boolean contains;
        synchronized (this.f1036a) {
            contains = this.f1036a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.b) {
            if (!this.b.contains(str)) {
                this.b.add(str);
                this.f1035a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bn.a(this.b, ",")).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m9166b(String str) {
        boolean contains;
        synchronized (this.b) {
            contains = this.b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.f28014c) {
            if (!this.f28014c.contains(str)) {
                this.f28014c.add(str);
                this.f1035a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bn.a(this.f28014c, ",")).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m9167c(String str) {
        boolean contains;
        synchronized (this.f28014c) {
            contains = this.f28014c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f1036a) {
            if (this.f1036a.contains(str)) {
                this.f1036a.remove(str);
                this.f1035a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bn.a(this.f1036a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.b) {
            if (this.b.contains(str)) {
                this.b.remove(str);
                this.f1035a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bn.a(this.b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f28014c) {
            if (this.f28014c.contains(str)) {
                this.f28014c.remove(str);
                this.f1035a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bn.a(this.f28014c, ",")).commit();
            }
        }
    }
}
