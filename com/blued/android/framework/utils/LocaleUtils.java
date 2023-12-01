package com.blued.android.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppInfo;
import com.google.gson.Gson;
import com.igexin.push.f.o;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Locale;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/LocaleUtils.class */
public class LocaleUtils {
    private static Locale b;
    private static LocaleList d;

    /* renamed from: a  reason: collision with root package name */
    private static final String f10092a = LocaleUtils.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static Locale f10093c = Locale.SIMPLIFIED_CHINESE;

    private static String a(Locale locale) {
        Gson f = AppInfo.f();
        Gson gson = f;
        if (f == null) {
            gson = new Gson();
        }
        return gson.toJson(locale);
    }

    public static Locale a(Context context) {
        synchronized (LocaleUtils.class) {
            if (context == null) {
                return null;
            }
            try {
                return a(context.getSharedPreferences("local_language_file", 0).getString("local_language_key", ""));
            } finally {
            }
        }
    }

    private static Locale a(String str) {
        Gson f = AppInfo.f();
        Gson gson = f;
        if (f == null) {
            gson = new Gson();
        }
        return (Locale) gson.fromJson(str, (Class<Object>) Locale.class);
    }

    public static void a(Context context, Locale locale) {
        b = locale;
        SharedPreferences.Editor edit = context.getSharedPreferences("local_language_file", 0).edit();
        edit.putString("local_language_key", a(locale));
        edit.apply();
    }

    public static void a(boolean z) {
        SharedPreferences.Editor edit = AppInfo.d().getSharedPreferences("local_language_file", 0).edit();
        edit.putBoolean("local_follow_system", z);
        edit.apply();
    }

    public static boolean a() {
        return AppInfo.d().getSharedPreferences("local_language_file", 0).getBoolean("local_follow_system", true);
    }

    public static String b() {
        String str = a.V;
        try {
            Locale c2 = c();
            Locale locale = c2;
            if (c2 == null) {
                locale = f10093c;
            }
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (a.V.equalsIgnoreCase(language)) {
                country = ("tw".equalsIgnoreCase(country) || "hk".equalsIgnoreCase(country)) ? "tw" : AdvanceSetting.CLEAR_NOTIFICATION;
            } else if ("en".equalsIgnoreCase(language)) {
                country = o.f23663a;
                str = "en";
            } else if ("id".equalsIgnoreCase(country)) {
                str = "id";
            } else {
                if (a.aa.equalsIgnoreCase(language)) {
                    country = "AR";
                }
                str = language;
            }
            return str + "-" + country;
        } catch (Exception e) {
            return "";
        }
    }

    public static Locale b(Context context) {
        Locale locale;
        Locale locale2;
        synchronized (LocaleUtils.class) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    LocaleList locales = context.getResources().getConfiguration().getLocales();
                    locale = null;
                    if (locales != null) {
                        locale = null;
                        if (locales.size() > 0) {
                            locale = locales.get(0);
                            for (int i = 0; i < locales.size(); i++) {
                                if (locales.get(i) != null) {
                                    Log.v("jzb_local", "getCurrentInAppLocale getLocales() " + i + " = " + locale2.toString());
                                }
                            }
                        }
                    }
                } else {
                    Locale locale3 = context.getResources().getConfiguration().locale;
                    locale = locale3;
                    if (locale3 != null) {
                        Log.v("jzb_local", "getCurrentInAppLocale  .locale  = " + locale3.toString());
                        locale = locale3;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return locale;
    }

    public static void b(Context context, Locale locale) {
        if (context == null || locale == null) {
            return;
        }
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        a(context, locale);
    }

    public static Locale c() {
        Locale locale;
        synchronized (LocaleUtils.class) {
            try {
                if (b == null) {
                    try {
                        b = a(AppInfo.d());
                    } catch (Exception e) {
                        Log.i(f10092a, "read locale exception");
                        e.printStackTrace();
                    }
                }
                if (b == null || TextUtils.isEmpty(b.getLanguage())) {
                    b = b(AppInfo.d());
                    Log.i(f10092a, "read locale from app locale follow resouce");
                }
                if (b == null || TextUtils.isEmpty(b.getLanguage())) {
                    b = f10093c;
                    Log.i(f10092a, "read locale from app locale zh ch");
                }
                locale = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return locale;
    }

    public static void c(Context context) {
        if (context != null) {
            b(context, a(context));
        }
    }

    public static void d() {
        if (Build.VERSION.SDK_INT >= 24) {
            d = LocaleList.getDefault();
        }
    }

    public static Locale e() {
        LocaleList localeList;
        Locale locale = (Build.VERSION.SDK_INT < 24 || (localeList = d) == null || localeList.size() <= 0) ? Locale.getDefault() : d.get(0);
        Locale locale2 = locale;
        if (locale == null) {
            locale2 = Locale.getDefault();
        }
        Locale locale3 = locale2;
        if (locale2 == null) {
            locale3 = Locale.SIMPLIFIED_CHINESE;
        }
        return locale3;
    }
}
