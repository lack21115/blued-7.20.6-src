package com.blued.android.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.core.AppInfo;
import com.google.gson.Gson;
import java.util.Locale;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/LocaleUtils.class */
public class LocaleUtils {
    private static Locale b;
    private static LocaleList d;
    private static final String a = LocaleUtils.class.getSimpleName();
    private static Locale c = Locale.SIMPLIFIED_CHINESE;

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
        return (Locale) gson.fromJson(str, Locale.class);
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
        String str = "zh";
        try {
            Locale c2 = c();
            Locale locale = c2;
            if (c2 == null) {
                locale = c;
            }
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if ("zh".equalsIgnoreCase(language)) {
                country = ("tw".equalsIgnoreCase(country) || "hk".equalsIgnoreCase(country)) ? "tw" : "cn";
            } else if ("en".equalsIgnoreCase(language)) {
                country = "us";
                str = "en";
            } else if ("id".equalsIgnoreCase(country)) {
                str = "id";
            } else {
                if ("ar".equalsIgnoreCase(language)) {
                    country = "AR";
                }
                str = language;
            }
            return str + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + country;
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
                        Log.i(a, "read locale exception");
                        e.printStackTrace();
                    }
                }
                if (b == null || TextUtils.isEmpty(b.getLanguage())) {
                    b = b(AppInfo.d());
                    Log.i(a, "read locale from app locale follow resouce");
                }
                if (b == null || TextUtils.isEmpty(b.getLanguage())) {
                    b = c;
                    Log.i(a, "read locale from app locale zh ch");
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
