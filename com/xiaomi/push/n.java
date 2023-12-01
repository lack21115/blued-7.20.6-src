package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile n f41560a;

    /* renamed from: a  reason: collision with other field name */
    private Context f897a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f898a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Map<String, String>> f899a = new HashMap();

    private n(Context context) {
        this.f897a = context;
    }

    public static n a(Context context) {
        if (f41560a == null) {
            synchronized (n.class) {
                try {
                    if (f41560a == null) {
                        f41560a = new n(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41560a;
    }

    private String a(String str, String str2) {
        synchronized (this) {
            if (this.f899a != null && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        Map<String, String> map = this.f899a.get(str);
                        if (map != null) {
                            return map.get(str2);
                        }
                        return "";
                    } catch (Throwable th) {
                        return "";
                    }
                }
            }
            return "";
        }
    }

    private void b(String str, String str2, String str3) {
        synchronized (this) {
            if (this.f899a == null) {
                this.f899a = new HashMap();
            }
            Map<String, String> map = this.f899a.get(str);
            HashMap hashMap = map;
            if (map == null) {
                hashMap = new HashMap();
            }
            hashMap.put(str2, str3);
            this.f899a.put(str, hashMap);
        }
    }

    public String a(String str, String str2, String str3) {
        synchronized (this) {
            String a2 = a(str, str2);
            if (TextUtils.isEmpty(a2)) {
                return this.f897a.getSharedPreferences(str, 4).getString(str2, str3);
            }
            return a2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12062a(String str, String str2, String str3) {
        synchronized (this) {
            b(str, str2, str3);
            this.f898a.post(new o(this, str, str2, str3));
        }
    }
}
