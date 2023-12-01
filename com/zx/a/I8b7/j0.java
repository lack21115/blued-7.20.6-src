package com.zx.a.I8b7;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/j0.class */
public class j0 implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public d0 f42136a;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f42137c = 8;

    public j0(d0 d0Var) {
        this.f42136a = (d0) o1.a(d0Var);
    }

    public static String a(Throwable th) {
        Throwable th2 = th;
        while (true) {
            Throwable th3 = th2;
            if (th3 == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintWriter printWriter = new PrintWriter((OutputStream) byteArrayOutputStream, false);
                th.printStackTrace(printWriter);
                printWriter.flush();
                return byteArrayOutputStream.toString();
            }
            th2 = th3.getCause();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01c2 -> B:54:0x011f). Please submit an issue!!! */
    @Override // com.zx.a.I8b7.e0
    public void a(int i, String str, String str2, Throwable th) {
        String str3;
        String str4;
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.f42137c];
            String className = stackTraceElement.getClassName();
            str3 = String.format("%s.%s", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName());
        } catch (Throwable th2) {
            str3 = "";
        }
        String str5 = str;
        if (TextUtils.isEmpty(str)) {
            str5 = this.b;
        }
        if (!TextUtils.isEmpty(str5)) {
            str3 = str5 + "-" + str3;
        }
        String str6 = str2;
        if (th != null) {
            str6 = str2;
            if (str2 != null) {
                str6 = str2 + " : " + a(th);
            }
        }
        String str7 = str6;
        if (th != null) {
            str7 = str6;
            if (str6 == null) {
                str7 = a(th);
            }
        }
        String str8 = str7;
        if (TextUtils.isEmpty(str7)) {
            str8 = "Empty/NULL log message";
        }
        String trim = str8.trim();
        String str9 = trim;
        if (trim.startsWith("{")) {
            str9 = trim;
            if (trim.endsWith(com.alipay.sdk.util.i.d)) {
                try {
                    str9 = new JSONObject(trim).toString(2);
                } catch (Throwable th3) {
                    str9 = trim;
                }
            }
        }
        String str10 = str9;
        if (str9.startsWith("[")) {
            str10 = str9;
            if (str9.endsWith("]")) {
                try {
                    str10 = new JSONArray(str9).toString(2);
                } catch (Throwable th4) {
                    str10 = str9;
                }
            }
        }
        try {
            StackTraceElement stackTraceElement2 = Thread.currentThread().getStackTrace()[this.f42137c];
            String className2 = stackTraceElement2.getClassName();
            str4 = String.format("(%s:%d)", className2.substring(className2.lastIndexOf(".") + 1) + ".java", Integer.valueOf(stackTraceElement2.getLineNumber()));
        } catch (Throwable th5) {
            str4 = "";
        }
        String str11 = str10;
        if (th == null) {
            str11 = str10 + " " + str4;
        }
        this.f42136a.a(i, str3, str11);
    }
}
