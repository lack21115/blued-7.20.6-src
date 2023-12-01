package com.zx.a.I8b7;

import android.os.Process;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/y.class */
public class y implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public d0 f42229a;
    public SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /* renamed from: c  reason: collision with root package name */
    public String f42230c = "";
    public int d = 8;

    public y(d0 d0Var) {
        this.f42229a = (d0) o1.a(d0Var);
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x02d3 -> B:74:0x01f4). Please submit an issue!!! */
    @Override // com.zx.a.I8b7.e0
    public void a(int i, String str, String str2, Throwable th) {
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.format(new Date()));
        sb.append(" ");
        sb.append(Process.myPid());
        sb.append(BridgeUtil.SPLIT_MARK);
        sb.append(Process.myPid());
        sb.append(" ");
        if (i == 1) {
            sb.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        } else if (i == 2) {
            sb.append("D");
        } else if (i == 3) {
            sb.append("I");
        } else if (i == 4) {
            sb.append("W");
        } else if (i != 5) {
            sb.append("?");
        } else {
            sb.append(ExifInterface.LONGITUDE_EAST);
        }
        sb.append(BridgeUtil.SPLIT_MARK);
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.d];
            String className = stackTraceElement.getClassName();
            str3 = String.format("%s.%s", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName());
        } catch (Throwable th2) {
            str3 = "";
        }
        String str5 = TextUtils.isEmpty(str) ? this.f42230c : str;
        if (!TextUtils.isEmpty(str5)) {
            str3 = str5 + "-" + str3;
        }
        sb.append(str3);
        sb.append(": ");
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
            StackTraceElement stackTraceElement2 = Thread.currentThread().getStackTrace()[this.d];
            String className2 = stackTraceElement2.getClassName();
            str4 = String.format("(%s:%d)", className2.substring(className2.lastIndexOf(".") + 1) + ".java", Integer.valueOf(stackTraceElement2.getLineNumber()));
        } catch (Throwable th5) {
            str4 = "";
        }
        String str11 = str10;
        if (th == null) {
            str11 = str10 + " " + str4;
        }
        sb.append(str11);
        String sb2 = sb.toString();
        String str12 = sb2;
        if (!sb2.endsWith("\n")) {
            str12 = sb2 + "\n";
        }
        this.f42229a.a(i, str, str12);
    }
}
