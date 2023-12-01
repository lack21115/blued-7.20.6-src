package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/android/b/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f41862a = false;

    public static String a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "KWE_N";
        }
        return str2;
    }

    public static String a(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "UnknownHostException";
            }
            try {
            } catch (Throwable th3) {
                th3.printStackTrace();
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }

    public static void a(boolean z) {
        f41862a = z;
    }

    public static boolean a(Context context, String[] strArr) {
        try {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (context.checkPermission(strArr[i2], Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    public static String b(String str) {
        try {
            e a2 = com.yxcorp.kuaishou.addfp.c.a.a.a(str, false);
            return !TextUtils.isEmpty(a2.b) ? a2.b : (TextUtils.isEmpty(a2.f41859c) || !a2.f41859c.contains(NetworkUtil.NETWORK_CLASS_DENIED)) ? TextUtils.isEmpty(a2.b) ? "KWE_N" : "KWE_OTHER" : "KWE_PN";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_PE";
        }
    }
}
