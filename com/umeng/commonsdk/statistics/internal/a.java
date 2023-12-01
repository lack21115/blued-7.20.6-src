package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/internal/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f27238a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f27239c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/internal/a$a.class */
    public static class C0914a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f27240a = new a();

        private C0914a() {
        }
    }

    private a() {
        this.b = null;
        this.f27239c = null;
    }

    public static a a(Context context) {
        if (f27238a == null && context != null) {
            f27238a = context.getApplicationContext();
        }
        return C0914a.f27240a;
    }

    private void f(String str) {
        try {
            String replaceAll = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/");
            this.b = replaceAll + "/Android " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f27238a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f27238a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(bh.aT);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    this.f27239c = sb.toString();
                    return;
                }
                String str3 = split[i2];
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    String str4 = substring;
                    if (substring.endsWith("=")) {
                        str4 = substring.replace("=", "");
                    }
                    sb.append(str4);
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f27238a, th);
        }
    }

    public String a() {
        return this.f27239c;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public String b() {
        return this.b;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bh.aG);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("h");
    }

    public void e(String str) {
        String substring = str.substring(0, str.indexOf(95));
        g(substring);
        f(substring);
    }
}
