package com.bytedance.bdtracker;

import android.content.Context;
import android.util.Log;
import com.bytedance.applog.ILogger;
import com.bytedance.applog.scheme.BuildConfig;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/z2.class */
public class z2 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f21341a = false;
    public static ILogger b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f21342c;
    public static final int d;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/z2$a.class */
    public interface a {
        String a();
    }

    static {
        int i = 6090090;
        if (String.valueOf((int) BuildConfig.VERSION_CODE).charAt(0) >= '4') {
            i = 16089689;
        }
        d = i;
    }

    public static void a(Context context, ILogger iLogger, boolean z) {
        try {
            f21341a = (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable th) {
            f21341a = true;
        }
        b = iLogger;
        f21342c = z;
    }

    public static void a(a aVar) {
        if (f21341a && f21342c && aVar != null) {
            ILogger iLogger = b;
            String a2 = aVar.a();
            if (iLogger != null) {
                iLogger.log(a2, null);
            } else {
                Log.d("AppLog", a2, null);
            }
        }
    }

    public static void a(String str) {
        if (f21341a && f21342c) {
            ILogger iLogger = b;
            if (iLogger != null) {
                iLogger.log(str, null);
            } else {
                Log.d("AppLog", str, null);
            }
        }
    }

    public static void a(String str, Throwable th) {
        if (f21342c) {
            ILogger iLogger = b;
            if (iLogger != null) {
                iLogger.log(str, th);
            } else if (f21341a) {
                Log.e("AppLog", str, th);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        if (f21341a && f21342c && str != null) {
            String b2 = b(str, objArr);
            ILogger iLogger = b;
            if (iLogger != null) {
                iLogger.log(b2, null);
            } else {
                Log.d("AppLog", b2, null);
            }
        }
    }

    public static void a(Throwable th) {
        if (f21342c) {
            ILogger iLogger = b;
            if (iLogger != null) {
                iLogger.log("", th);
            } else if (f21341a) {
                Log.e("AppLog", "", th);
            }
        }
    }

    public static String b(String str, Object... objArr) {
        try {
            StringBuilder sb = new StringBuilder();
            if (objArr != null && objArr.length != 0 && str.contains("{}")) {
                int length = str.length();
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    char charAt = str.charAt(i);
                    char charAt2 = i < length - 1 ? str.charAt(i + 1) : ' ';
                    if (charAt == '{' && charAt2 == '}') {
                        int i3 = i2;
                        if (i2 < objArr.length) {
                            sb.append(j1.a(objArr[i2]));
                            i3 = i2 + 1;
                        }
                        i++;
                        i2 = i3;
                    } else {
                        sb.append(charAt);
                    }
                    i++;
                }
                return sb.toString();
            }
            sb.append(str);
            return sb.toString();
        } catch (Throwable th) {
            return str;
        }
    }

    public static void b(String str) {
        if (f21342c) {
            ILogger iLogger = b;
            if (iLogger != null) {
                iLogger.log(str, null);
            } else {
                Log.i("AppLog", str, null);
            }
        }
    }

    public static void b(String str, Throwable th) {
        if (f21342c) {
            ILogger iLogger = b;
            if (iLogger != null) {
                iLogger.log(str, th);
            } else if (f21341a) {
                Log.w("AppLog", str, th);
            }
        }
    }

    public static void c(String str, Throwable th) {
        a(str, th);
    }

    public static void c(String str, Object... objArr) {
        if (f21342c) {
            String b2 = b(str, objArr);
            ILogger iLogger = b;
            if (iLogger != null) {
                iLogger.log(b2, null);
            } else if (f21341a) {
                Log.i("AppLog", b2, null);
            }
        }
    }
}
