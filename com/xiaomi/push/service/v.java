package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/v.class */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static v f41704a;

    /* renamed from: a  reason: collision with other field name */
    private Context f1082a;

    /* renamed from: a  reason: collision with other field name */
    private List<String> f1083a = new ArrayList();
    private final List<String> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f41705c = new ArrayList();

    private v(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f1082a = applicationContext;
        if (applicationContext == null) {
            this.f1082a = context;
        }
        SharedPreferences sharedPreferences = this.f1082a.getSharedPreferences("mipush_app_info", 0);
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
                this.f1083a.add(str);
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
                this.f41705c.add(str3);
            }
            i5 = i6 + 1;
        }
    }

    public static v a(Context context) {
        if (f41704a == null) {
            f41704a = new v(context);
        }
        return f41704a;
    }

    public void a(String str) {
        synchronized (this.f1083a) {
            if (!this.f1083a.contains(str)) {
                this.f1083a.add(str);
                this.f1082a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bn.a(this.f1083a, ",")).commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m12215a(String str) {
        boolean contains;
        synchronized (this.f1083a) {
            contains = this.f1083a.contains(str);
        }
        return contains;
    }

    public void b(String str) {
        synchronized (this.b) {
            if (!this.b.contains(str)) {
                this.b.add(str);
                this.f1082a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bn.a(this.b, ",")).commit();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m12216b(String str) {
        boolean contains;
        synchronized (this.b) {
            contains = this.b.contains(str);
        }
        return contains;
    }

    public void c(String str) {
        synchronized (this.f41705c) {
            if (!this.f41705c.contains(str)) {
                this.f41705c.add(str);
                this.f1082a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bn.a(this.f41705c, ",")).commit();
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m12217c(String str) {
        boolean contains;
        synchronized (this.f41705c) {
            contains = this.f41705c.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f1083a) {
            if (this.f1083a.contains(str)) {
                this.f1083a.remove(str);
                this.f1082a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bn.a(this.f1083a, ",")).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.b) {
            if (this.b.contains(str)) {
                this.b.remove(str);
                this.f1082a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bn.a(this.b, ",")).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f41705c) {
            if (this.f41705c.contains(str)) {
                this.f41705c.remove(str);
                this.f1082a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bn.a(this.f41705c, ",")).commit();
            }
        }
    }
}
