package com.tencent.bugly.idasc.crashreport;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.igexin.push.core.b;
import com.tencent.bugly.idasc.proguard.ao;
import com.tencent.bugly.idasc.proguard.p;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/crashreport/BuglyLog.class */
public class BuglyLog {
    public static void d(String str, String str2) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = b.l;
        }
        if (p.f35328c) {
            Log.d(str3, str4);
        }
        ao.a("D", str3, str4);
    }

    public static void e(String str, String str2) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = b.l;
        }
        if (p.f35328c) {
            Log.e(str3, str4);
        }
        ao.a(ExifInterface.LONGITUDE_EAST, str3, str4);
    }

    public static void e(String str, String str2, Throwable th) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = b.l;
        }
        if (p.f35328c) {
            Log.e(str3, str4, th);
        }
        ao.a(ExifInterface.LONGITUDE_EAST, str3, th);
    }

    public static void i(String str, String str2) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = b.l;
        }
        if (p.f35328c) {
            Log.i(str3, str4);
        }
        ao.a("I", str3, str4);
    }

    public static void setCache(int i) {
        ao.a(i);
    }

    public static void v(String str, String str2) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = b.l;
        }
        if (p.f35328c) {
            Log.v(str3, str4);
        }
        ao.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str3, str4);
    }

    public static void w(String str, String str2) {
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = b.l;
        }
        if (p.f35328c) {
            Log.w(str3, str4);
        }
        ao.a("W", str3, str4);
    }
}
