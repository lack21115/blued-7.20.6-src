package com.bytedance.bdtracker;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w2.class */
public class w2 {

    /* renamed from: a  reason: collision with root package name */
    public static final CharSequence f7726a = "amigo";
    public static final CharSequence b = "funtouch";

    /* renamed from: c  reason: collision with root package name */
    public static final j2<Boolean> f7727c = new a();

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w2$a.class */
    public static final class a extends j2<Boolean> {
        @Override // com.bytedance.bdtracker.j2
        public Boolean a(Object[] objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable th) {
                return false;
            }
        }
    }

    public static String a() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        String str2;
        Process exec;
        String a2 = y2.a(str);
        if (TextUtils.isEmpty(a2)) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                exec = Runtime.getRuntime().exec("getprop " + str);
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                str2 = "";
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                str2 = "";
            }
            try {
                String readLine = bufferedReader.readLine();
                str2 = readLine;
                exec.destroy();
                str2 = readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    z2.a(th);
                    j1.a((Closeable) bufferedReader);
                    return str2;
                } catch (Throwable th3) {
                    j1.a((Closeable) bufferedReader);
                    throw th3;
                }
            }
            j1.a((Closeable) bufferedReader);
            return str2;
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (r0.toLowerCase().contains("realme") != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b() {
        /*
            java.lang.String r0 = android.os.Build.MANUFACTURER
            r6 = r0
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r5 = r0
            r0 = 0
            r4 = r0
            r0 = r4
            r3 = r0
            r0 = r5
            if (r0 != 0) goto L2d
            r0 = r6
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "oppo"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L2b
            r0 = r4
            r3 = r0
            r0 = r6
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "realme"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L2d
        L2b:
            r0 = 1
            r3 = r0
        L2d:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.w2.b():boolean");
    }

    public static boolean c() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean d() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith(AssistUtils.BRAND_HON)) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith(AssistUtils.BRAND_HON);
        }
        return true;
    }

    public static boolean e() {
        boolean z = false;
        try {
            if (Class.forName("miui.os.Build").getName().length() > 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
