package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mi.class */
public class mi {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23958a = "txmapengine";
    public static String b = "release";

    /* renamed from: c  reason: collision with root package name */
    public static String f23959c = "undefined";
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static int i = 0;
    public static String j = "";
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String n = "tms";
    public static String o = "undefined";
    public static List<b> p = new ArrayList(10);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mi$a.class */
    public interface a {
        void close();

        void init(Context context, String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mi$b.class */
    public enum b {
        PLUGIN("shell.adapter.LocPluginModular"),
        BUGLY("bugly.TMSBugly"),
        BEACON("beacon.TMSBeaconReport");
        
        public String b;

        b(String str) {
            this.b = str;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mi$c.class */
    public interface c {
        byte[] a(byte[] bArr);
    }

    public static String a() {
        return f23959c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + b;
    }

    public static String a(String str) {
        return a() + "!" + str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(Context context) {
        try {
            String a2 = g7.a(context, context.getPackageName() + "_ShellConfig");
            String str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = g7.a(context, "TMS_ShellConfig");
                if (TextUtils.isEmpty(str)) {
                    try {
                        Properties properties = new Properties();
                        properties.load(context.getAssets().open("tencentmap/mapsdk_vector/sdkconfig.dat"));
                        str = properties.getProperty("classname");
                    } catch (IOException e2) {
                        str = "com.tencent.mapsdk.BuildConfig";
                    }
                }
            }
            Class<?> cls = Class.forName(str);
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                Field field = declaredFields[i3];
                boolean z = true;
                field.setAccessible(true);
                String name = field.getName();
                switch (name.hashCode()) {
                    case -2051118828:
                        if (name.equals("VERSION_CODE")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -2050804302:
                        if (name.equals("VERSION_NAME")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1781919750:
                        if (name.equals("SEARCH_ENABLE")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1256894524:
                        if (name.equals("BEACON_KEY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -783990306:
                        if (name.equals("BEACON_ENABLE")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -758346991:
                        if (name.equals("SHEET_PROJECT_NAME")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -368721951:
                        if (name.equals("BUGLY_KEY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 44249739:
                        if (name.equals("BUILD_TYPE")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 64921139:
                        if (name.equals("DEBUG")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 196363279:
                        if (name.equals("PLUGIN_ENABLE")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1766588577:
                        if (name.equals("BUGLY_ENABLE")) {
                            break;
                        }
                        z = true;
                        break;
                    case 2076249758:
                        if (name.equals("FLAVOR")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 2095911147:
                        if (name.equals("REPO_VERSION")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 2107919841:
                        if (name.equals("BUGLY_KEY_SHARE")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        d = ((Boolean) field.get(cls)).booleanValue();
                        na.a(ma.w, "[DEBUG]:" + d);
                        break;
                    case true:
                        boolean booleanValue = ((Boolean) field.get(cls)).booleanValue();
                        e = booleanValue;
                        if (booleanValue) {
                            p.add(b.BUGLY);
                        }
                        na.a(ma.w, "[BUGLY]:" + e);
                        break;
                    case true:
                        f23959c = (String) field.get(cls);
                        na.a(ma.w, "[FLAVOR]:" + f23959c);
                        break;
                    case true:
                        f = ((Boolean) field.get(cls)).booleanValue();
                        na.a(ma.w, "[SEARCH]:" + f);
                        break;
                    case true:
                        boolean booleanValue2 = ((Boolean) field.get(cls)).booleanValue();
                        g = booleanValue2;
                        if (booleanValue2) {
                            p.add(b.PLUGIN);
                        }
                        na.a(ma.w, "[PLUGIN]:" + g);
                        break;
                    case true:
                        n = (String) field.get(cls);
                        break;
                    case true:
                        o = (String) field.get(cls);
                        na.a(ma.w, "[REPO]:" + o);
                        break;
                    case true:
                        j = (String) field.get(cls);
                        na.a(ma.w, "[VER]:" + j);
                        break;
                    case true:
                        boolean booleanValue3 = ((Boolean) field.get(cls)).booleanValue();
                        h = booleanValue3;
                        if (booleanValue3) {
                            p.add(b.BEACON);
                        }
                        na.a(ma.w, "[BEACON]:" + h);
                        break;
                    case true:
                        k = (String) field.get(cls);
                        break;
                    case true:
                        l = (String) field.get(cls);
                        break;
                    case true:
                        m = (String) field.get(cls);
                        break;
                    case true:
                        i = ((Integer) field.get(cls)).intValue();
                        na.a(ma.w, "[VER_CODE]:" + i);
                        break;
                    case true:
                        b = (String) field.get(cls);
                        na.a(ma.w, "[BUILD_TYPE]:" + b);
                        break;
                }
                i2 = i3 + 1;
            }
        } catch (ClassNotFoundException e3) {
            na.f(e3.getMessage(), e3);
        } catch (IllegalAccessException e4) {
            na.f(e4.getMessage(), e4);
        }
    }

    public static String b() {
        return j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + o;
    }
}
