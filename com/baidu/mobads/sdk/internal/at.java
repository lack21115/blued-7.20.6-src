package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import com.baidu.mobads.sdk.internal.av;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/at.class */
public class at extends av.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9319a = "local";
    private static final int b = 4000;

    /* renamed from: c  reason: collision with root package name */
    private static final int f9320c = 23;
    private static final int d = 5;
    private static final Pattern e = Pattern.compile("(\\$\\d+)+$");
    private static final char f = 9556;
    private static final char g = 9562;
    private static final char h = 9567;
    private static final char i = 9553;
    private static final String j = "════════════════════════════════════════════";
    private static final String k = "------------------------------------------";
    private static final String l = "╔════════════════════════════════════════════════════════════════════════════════════════";
    private static final String m = "╚════════════════════════════════════════════════════════════════════════════════════════";
    private static final String n = "╟------------------------------------------------------------------------------------";

    private static void a(int i2, String str, String str2) {
        if (i2 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i2, str, str2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    String a() {
        return "local";
    }

    protected String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String substring = className.substring(className.lastIndexOf(46) + 1);
        String str = substring;
        if (substring.length() > 23) {
            if (Build.VERSION.SDK_INT >= 24) {
                return substring;
            }
            str = substring.substring(0, 23);
        }
        return str;
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    protected void a(int i2, String str, String str2, Throwable th) {
        int min;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("当前线程：");
            sb.append(Thread.currentThread().getName());
            sb.append(";  ");
            sb.append("调用位置：");
            sb.append(c());
            sb.append(";  ");
            sb.append("打印消息：");
            if (str2.length() <= 4000) {
                sb.append(str2);
                a(i2, str, sb.toString());
                return;
            }
            ArrayList arrayList = new ArrayList();
            int length = str2.length();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                int indexOf = str2.indexOf(10, i4);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i4 + 4000);
                    arrayList.add(str2.substring(i4, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i4 = min;
                }
                i3 = min + 1;
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            int length2 = strArr.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length2) {
                    return;
                }
                a(i2, str, sb.toString() + strArr[i6]);
                i5 = i6 + 1;
            }
        } catch (Throwable th2) {
            a(6, str, th2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mobads.sdk.internal.av.a
    public final String b() {
        String b2 = super.b();
        if (b2 != null) {
            return b2;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace.length <= 5 ? "" : a(stackTrace[5]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        boolean z;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (i2 < length) {
            String className = stackTrace[i2].getClassName();
            Matcher matcher = e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (className.equals(av.class.getName()) || className.equals(bq.class.getName())) {
                z = true;
            } else {
                z = z2;
                if (z2) {
                    break;
                }
            }
            i3++;
            i2++;
            z2 = z;
        }
        String fileName = stackTrace[i3].getFileName();
        String methodName = stackTrace[i3].getMethodName();
        return "   (" + fileName + ":" + stackTrace[i3].getLineNumber() + ")# " + methodName;
    }
}
