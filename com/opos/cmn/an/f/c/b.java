package com.opos.cmn.an.f.c;

import android.app.Application;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.ads.fw;
import com.opos.cmn.an.f.a.b.d;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/c/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10852a = b("ZGVidWcuY29tLm9wb3MuY21uLmxvZw==");
    private static String b = "localId";

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f10853c = "";

    private static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004d -> B:12:0x003f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = r0
            java.lang.String r0 = ""
            r5 = r0
            r0 = r4
            r1 = 29
            if (r0 >= r1) goto L4b
            r0 = r3
            if (r0 == 0) goto L3f
            r0 = r3
            boolean r0 = com.opos.cmn.an.f.a.f.a(r0)     // Catch: java.lang.Exception -> L4d
            if (r0 == 0) goto L34
            com.heytap.baselib.utils.ClientIdUtils r0 = com.heytap.baselib.utils.ClientIdUtils.INSTANCE     // Catch: java.lang.Exception -> L4d
            r1 = r3
            java.util.Map r0 = r0.buildIdMap(r1)     // Catch: java.lang.Exception -> L4d
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L3f
            r0 = r3
            java.lang.String r1 = com.opos.cmn.an.f.c.b.b     // Catch: java.lang.Exception -> L4d
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L4d
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L4d
            r3 = r0
            goto L42
        L34:
            com.heytap.baselib.utils.ClientIdUtils r0 = com.heytap.baselib.utils.ClientIdUtils.INSTANCE     // Catch: java.lang.Exception -> L4d
            r1 = r3
            java.lang.String r0 = r0.getClientId(r1)     // Catch: java.lang.Exception -> L4d
            r3 = r0
            goto L42
        L3f:
            java.lang.String r0 = ""
            r3 = r0
        L42:
            r0 = r3
            if (r0 != 0) goto L49
            java.lang.String r0 = ""
            return r0
        L49:
            r0 = r3
            r5 = r0
        L4b:
            r0 = r5
            return r0
        L4d:
            r3 = move-exception
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.f.c.b.a(android.content.Context):java.lang.String");
    }

    public static String a(d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(dVar.f10831a);
        sb.append("][");
        sb.append(a(dVar.g));
        sb.append("][");
        sb.append(Process.myPid());
        sb.append("][");
        sb.append(dVar.f);
        sb.append(":");
        sb.append(dVar.e);
        sb.append("]:");
        if (dVar.h == 2) {
            Object[] objArr = (Object[]) dVar.b;
            int length = objArr.length;
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    sb.append(objArr[i2]);
                    if (i2 < length - 1) {
                        sb.append(",");
                    }
                    i = i2 + 1;
                }
            }
        } else {
            sb.append(dVar.b);
        }
        if (dVar.f10832c != null) {
            sb.append("\n");
            sb.append(Log.getStackTraceString(dVar.f10832c));
        }
        return sb.toString();
    }

    public static String a(String str) {
        String str2 = "";
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str3 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
                str2 = "";
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        return bArr != null ? new String(Base64.decode(bArr, 2)) : "";
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static boolean a() {
        String a2 = a(f10852a);
        return !TextUtils.isEmpty(a2) && a2.contentEquals(fw.Code);
    }

    public static String b(String str) {
        return !com.opos.cmn.an.c.a.a(str) ? a(str.getBytes()) : "";
    }

    public static boolean b() {
        try {
            return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        } catch (Exception e) {
            return false;
        }
    }

    public static String c() {
        if (TextUtils.isEmpty(f10853c)) {
            f10853c = d();
            if (TextUtils.isEmpty(f10853c)) {
                f10853c = e();
            }
            if (TextUtils.isEmpty(f10853c)) {
                f10853c = f();
            }
        }
        return f10853c;
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String e() {
        String str = null;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                str = (String) invoke;
            }
            return str;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String f() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str;
        String str2 = null;
        String str3 = null;
        if (TextUtils.isEmpty(null)) {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
                str = null;
            } catch (Exception e) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                str2 = readLine;
                bufferedReader2 = bufferedReader;
                if (!TextUtils.isEmpty(readLine)) {
                    str = readLine;
                    str2 = readLine.trim();
                    bufferedReader2 = bufferedReader;
                }
            } catch (Exception e2) {
                str2 = str;
                str3 = str2;
                if (bufferedReader != null) {
                    bufferedReader2 = bufferedReader;
                    bufferedReader2.close();
                    return str2;
                }
                return str3;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
            try {
                bufferedReader2.close();
                return str2;
            } catch (Exception e4) {
                return str2;
            }
        }
        return str3;
    }
}
