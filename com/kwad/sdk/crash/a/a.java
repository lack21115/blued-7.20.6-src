package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/a/a.class */
public final class a {
    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        boolean z;
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] zz = e.zy().zz();
        if (zz == null || zz.length == 0) {
            return true;
        }
        int length = zz.length;
        int i = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i >= length) {
                break;
            }
            z2 = a(stackTraceElementArr, zz[i]);
            z = z2;
            if (z2) {
                break;
            }
            i++;
        }
        if (z) {
            String[] zA = e.zy().zA();
            int length2 = zA.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length2) {
                    break;
                } else if (b(stackTraceElementArr, zA[i3])) {
                    return false;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return z;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            String className = stackTraceElementArr[i2].getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            String className = stackTraceElementArr[i2].getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean h(Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                break;
            }
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
            i = i2 + 1;
        }
        return v(arrayList);
    }

    private static boolean v(List<StackTraceElement[]> list) {
        for (StackTraceElement[] stackTraceElementArr : list) {
            if (a(stackTraceElementArr)) {
                return true;
            }
        }
        return false;
    }
}
