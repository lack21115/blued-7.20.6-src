package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/s.class */
public class s {

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/s$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f27875a;

        /* renamed from: a  reason: collision with other field name */
        private final StringBuilder f859a;
        private final String b;

        public a() {
            this(":", ",");
        }

        public a(String str, String str2) {
            this.f859a = new StringBuilder();
            this.f27875a = str;
            this.b = str2;
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f859a.length() > 0) {
                    this.f859a.append(this.b);
                }
                StringBuilder sb = this.f859a;
                sb.append(str);
                sb.append(this.f27875a);
                sb.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f859a.toString();
        }
    }

    public static int a(String str, int i) {
        int i2 = i;
        if (!TextUtils.isEmpty(str)) {
            try {
                i2 = Integer.parseInt(str);
            } catch (Exception e) {
                return i;
            }
        }
        return i2;
    }

    public static boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        return Build.VERSION.SDK_INT >= 20 ? powerManager != null && powerManager.isInteractive() : powerManager != null && powerManager.isScreenOn();
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int b(String str, int i) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i : i;
    }
}
