package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/internal/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f40929a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f40930c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/internal/a$a.class */
    public static class C1084a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f40931a = new a();

        private C1084a() {
        }
    }

    private a() {
        this.b = null;
        this.f40930c = null;
    }

    public static a a(Context context) {
        if (f40929a == null && context != null) {
            f40929a = context.getApplicationContext();
        }
        return C1084a.f40931a;
    }

    private void f(String str) {
        try {
            String replaceAll = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", BridgeUtil.SPLIT_MARK);
            this.b = replaceAll + BridgeUtil.SPLIT_MARK + "Android " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f40929a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f40929a, th);
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
                    this.f40930c = sb.toString();
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
            UMCrashManager.reportCrash(f40929a, th);
        }
    }

    public String a() {
        return this.f40930c;
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
