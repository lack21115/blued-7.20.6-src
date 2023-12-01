package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/L32b7.class */
public final class L32b7 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26199a = kC0XR.a(kC0XR.b);
    public static final String b = kC0XR.a(kC0XR.f26272c);

    /* renamed from: c  reason: collision with root package name */
    public static final String f26200c = kC0XR.a(kC0XR.d);
    public static final String d = kC0XR.a(kC0XR.e);
    public static final String e = kC0XR.a(kC0XR.f);
    public static long f = 0;
    public static final String[] g = {"^/data/user/\\d+$", "^/data/data$"};

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/L32b7$spXPg.class */
    public static final class spXPg {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f26201a;
        public final String b;

        public spXPg(boolean z, String str) {
            this.f26201a = z;
            this.b = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0703 A[LOOP:0: B:195:0x06fa->B:197:0x0703, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 1895
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.L32b7.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        try {
            str2 = context.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (PackageManager.NameNotFoundException e2) {
            str2 = "";
        }
        try {
            sb.append((String) ((ArrayList) com.tencent.turingcam.oqKCa.a(new File(str2))).get(0));
        } catch (Throwable th) {
            sb.append("");
        }
        sb.append("_");
        long j = -1;
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            j = -1;
            if (file.exists()) {
                j = file.length();
            }
        }
        sb.append(j);
        sb.append("_");
        sb.append(Process.myUid());
        return sb.toString();
    }

    public static boolean a() {
        try {
            return 999 == Process.myUid() / 100000;
        } catch (Throwable th) {
            return false;
        }
    }
}
