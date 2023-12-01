package com.getui.gtc.base.log.c;

import android.os.Process;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.getui.gtc.base.log.ILogDestination;
import com.getui.gtc.base.log.ILogFormatter;
import com.getui.gtc.base.util.CommonUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/log/c/a.class */
public final class a implements ILogFormatter {

    /* renamed from: a  reason: collision with root package name */
    public String f8307a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    private final ILogDestination f8308c;
    private final SimpleDateFormat d;
    private String e;

    public a() {
        this(new com.getui.gtc.base.log.b.a());
    }

    public a(ILogDestination iLogDestination) {
        this.d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        this.f8307a = "";
        this.e = "";
        this.b = 8;
        this.f8308c = (ILogDestination) com.getui.gtc.base.log.e.a.a(iLogDestination);
        this.e = CommonUtil.getProcessName();
    }

    private String a() {
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.b];
            String className = stackTraceElement.getClassName();
            return String.format("%s.%s", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName());
        } catch (Throwable th) {
            return "";
        }
    }

    private String a(String str, Throwable th) {
        String str2 = str;
        if (th != null) {
            str2 = str;
            if (str != null) {
                str2 = str + " : " + a(th);
            }
        }
        String str3 = str2;
        if (th != null) {
            str3 = str2;
            if (str2 == null) {
                str3 = a(th);
            }
        }
        String str4 = str3;
        if (TextUtils.isEmpty(str3)) {
            str4 = "Empty/NULL log message";
        }
        String trim = str4.trim();
        String str5 = trim;
        if (trim.startsWith("{")) {
            str5 = trim;
            if (trim.endsWith("}")) {
                try {
                    str5 = new JSONObject(trim).toString(2);
                } catch (Throwable th2) {
                    str5 = trim;
                }
            }
        }
        String str6 = str5;
        if (str5.startsWith("[")) {
            str6 = str5;
            if (str5.endsWith("]")) {
                try {
                    str6 = new JSONArray(str5).toString(2);
                } catch (Throwable th3) {
                    str6 = str5;
                }
            }
        }
        String b = b();
        String str7 = str6;
        if (th == null) {
            str7 = str6 + " " + b;
        }
        return str7;
    }

    private static String a(Throwable th) {
        if (th == null) {
            return "";
        }
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

    private String b() {
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.b];
            String className = stackTraceElement.getClassName();
            String substring = className.substring(className.lastIndexOf(".") + 1);
            return String.format("(%s:%d)", substring + ".java", Integer.valueOf(stackTraceElement.getLineNumber()));
        } catch (Throwable th) {
            return "";
        }
    }

    @Override // com.getui.gtc.base.log.ILogFormatter
    public final void log(int i, String str, String str2, Throwable th) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.format(new Date()));
        sb.append(" ");
        sb.append(Process.myPid());
        sb.append("/");
        sb.append(this.e);
        sb.append(" ");
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "?" : ExifInterface.LONGITUDE_EAST : "W" : "I" : "D" : ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        sb.append("/");
        String a2 = a();
        String str4 = TextUtils.isEmpty(str) ? this.f8307a : str;
        if (TextUtils.isEmpty(str4)) {
            str3 = a2;
        } else {
            str3 = str4 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + a2;
        }
        sb.append(str3);
        sb.append(": ");
        sb.append(a(str2, th));
        String sb2 = sb.toString();
        String str5 = sb2;
        if (!sb2.endsWith("\n")) {
            str5 = sb2 + "\n";
        }
        this.f8308c.log(i, str, str5);
    }
}
