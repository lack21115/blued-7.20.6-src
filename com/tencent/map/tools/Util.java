package com.tencent.map.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.android.internal.telephony.PhoneConstants;
import com.tencent.mapsdk.internal.ii;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/Util.class */
public class Util {
    private static final boolean DEBUG = false;
    private static final int DEFAUlT_GlEsVersion = 65537;
    private static final String DUID_FILE_NAME = "txlbs_duid";
    private static final String DUID_KEY = "txlbs_key_duid";
    public static final String META_NAME_API_KEY = "TencentMapSDK";
    public static final int SMALL_SCREEN_THRESHOLD = 400;
    private static final String SUID_FILE_NAME = "txlbs_suid";
    private static final String SUID_KEY = "txlbs_key_suid";
    private static final String TAG = "Util";

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String filterBuilder(String... strArr) {
        String str;
        String str2;
        if (strArr != null) {
            int i = 0;
            String str3 = "category=";
            while (true) {
                str = str3;
                if (i >= strArr.length) {
                    break;
                }
                if (i == 0) {
                    str2 = str3 + strArr[i];
                } else {
                    str2 = str3 + "," + strArr[i];
                }
                str3 = str2;
                i++;
            }
        } else {
            str = "";
        }
        return str;
    }

    public static <T> Class<? extends T> findClass(String str, Class<T> cls, ClassLoader classLoader) {
        try {
            Class<? extends T> cls2 = (Class<? extends T>) Class.forName(str, false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                return cls2;
            }
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Class findClass(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Field findField(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            if (cls.getSuperclass() != Object.class) {
                return findField(cls.getSuperclass(), str);
            }
            return null;
        }
    }

    public static Method findMethod(Class cls, String str, Class[] clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            if (cls.getSuperclass() != Object.class) {
                return findMethod(cls.getSuperclass(), str, clsArr);
            }
            return null;
        }
    }

    public static <T> void foreach(Iterable<T> iterable, Callback<T> callback) {
        if (iterable == null || callback == null) {
            return;
        }
        for (T t : iterable) {
            callback.callback(t);
        }
    }

    public static <T> void foreach(T[] tArr, Callback<T> callback) {
        if (tArr == null || callback == null) {
            return;
        }
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            callback.callback(tArr[i2]);
            i = i2 + 1;
        }
    }

    public static String getAppName(Context context) {
        String rawAppName = getRawAppName(context);
        try {
            return URLEncoder.encode(rawAppName, "utf-8");
        } catch (Exception e) {
            return rawAppName;
        }
    }

    public static String getAppVersion(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            return str + i;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static float getDensity(Context context) {
        if (context == null) {
            return 1.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static String getDuid(Context context) {
        return context == null ? "" : getDuidFromSharePrerences(context);
    }

    private static String getDuidFromSharePrerences(Context context) {
        String sharePreference = getSharePreference(context, DUID_FILE_NAME, DUID_KEY);
        String str = sharePreference;
        if (TextUtils.isEmpty(sharePreference)) {
            str = ii.a(context);
            saveSharePreference(context, DUID_FILE_NAME, DUID_KEY, str);
        }
        return str;
    }

    public static Object getField(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            Class<?> cls = obj.getClass();
            if (obj instanceof Class) {
                cls = (Class) obj;
            }
            Field findField = findField(cls, str);
            if (findField != null) {
                findField.setAccessible(true);
                return findField.get(obj);
            }
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public static String getMD5String(String str) {
        return TextUtils.isEmpty(str) ? "" : getMD5String(str.getBytes());
    }

    public static String getMD5String(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i3 + 1;
                cArr2[i3] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getMetaKey(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (context == null) {
            return "";
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString(str);
    }

    public static int getOpenglesVersion(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        return deviceConfigurationInfo != null ? deviceConfigurationInfo.reqGlEsVersion : DEFAUlT_GlEsVersion;
    }

    public static String getProcessName(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader2.readLine();
            String str = readLine;
            if (!TextUtils.isEmpty(readLine)) {
                str = readLine.trim();
            }
            try {
                bufferedReader2.close();
                return bufferedReader;
            } catch (IOException e) {
                e.printStackTrace();
                return bufferedReader;
            }
        } catch (Throwable th2) {
            bufferedReader = bufferedReader2;
            th = th2;
            try {
                th.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public static String getRawAppName(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        return (applicationInfo != null ? applicationInfo.loadLabel(packageManager) : "can't find app name").toString();
    }

    public static String getResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels + PhoneConstants.APN_TYPE_ALL + displayMetrics.heightPixels;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getSharePreference(Context context, String str, String str2) {
        return context == null ? "" : context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static String getSuid(Context context) {
        return context == null ? "" : getSuidFromSharePrerences(context);
    }

    private static String getSuidFromSharePrerences(Context context) {
        String sharePreference = getSharePreference(context, SUID_FILE_NAME, SUID_KEY);
        String str = sharePreference;
        if (TextUtils.isEmpty(sharePreference)) {
            str = getUUID();
            saveSharePreference(context, SUID_FILE_NAME, SUID_KEY, str);
        }
        return str;
    }

    public static String getUUID() {
        try {
            return UUID.randomUUID().toString();
        } catch (Exception e) {
            return System.currentTimeMillis() + "";
        }
    }

    public static int getWindowHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getWindowWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Object invokeMethod(Object obj, String str, Class[] clsArr, Object[] objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method findMethod = findMethod(obj.getClass(), str, clsArr);
            if (findMethod != null) {
                findMethod.setAccessible(true);
                return findMethod.invoke(obj, objArr);
            }
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getTargetException());
        }
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                try {
                    break;
                } catch (IllegalAccessException e) {
                    return null;
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getTargetException());
                }
            }
            clsArr[i2] = objArr[i2].getClass();
            i = i2 + 1;
        }
        Method findMethod = findMethod(obj.getClass(), str, clsArr);
        if (findMethod != null) {
            findMethod.setAccessible(true);
            return findMethod.invoke(obj, objArr);
        }
        return null;
    }

    public static Object invokeStaticMethod(Class cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Method findMethod = findMethod(cls, str, clsArr);
            if (findMethod != null) {
                findMethod.setAccessible(true);
                return findMethod.invoke(cls, objArr);
            }
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getTargetException());
        }
    }

    private static boolean isMatchClassTypes(Class<?>[] clsArr, Object[] objArr) {
        int i;
        int i2;
        boolean z = false;
        if (clsArr.length != objArr.length) {
            return false;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= clsArr.length) {
                break;
            }
            if (clsArr[i3] != objArr[i3].getClass()) {
                i2 = i;
                if (!clsArr[i3].isAssignableFrom(objArr[i3].getClass())) {
                    i3++;
                    i4 = i2;
                }
            }
            i2 = i + 1;
            i3++;
            i4 = i2;
        }
        if (i == clsArr.length) {
            z = true;
        }
        return z;
    }

    public static <T> List<T> listWhere(Iterable<T> iterable, Condition<T> condition) {
        List<T> emptyList = Collections.emptyList();
        if (iterable != null) {
            if (condition == null) {
                return emptyList;
            }
            for (T t : iterable) {
                if (condition.callback((Condition<T>) t).booleanValue()) {
                    emptyList.add(t);
                }
            }
        }
        return emptyList;
    }

    public static <T> T newInstance(Class<T> cls, Object... objArr) {
        if (cls == null || cls.isEnum() || cls.isInterface() || cls.isAnnotation() || cls.isArray()) {
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= declaredConstructors.length) {
                try {
                    return cls.newInstance();
                } catch (IllegalAccessException e) {
                    return null;
                } catch (InstantiationException e2) {
                    throw new RuntimeException(e2);
                }
            }
            if (isMatchClassTypes(declaredConstructors[i2].getParameterTypes(), objArr)) {
                try {
                    declaredConstructors[i2].setAccessible(true);
                    return (T) declaredConstructors[i2].newInstance(objArr);
                } catch (IllegalAccessException | InstantiationException e3) {
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException(e4.getTargetException());
                }
            }
            i = i2 + 1;
        }
    }

    public static void saveSharePreference(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static void setField(Object obj, String str, Object obj2) {
        if (obj == null) {
            return;
        }
        try {
            Field findField = findField(obj.getClass(), str);
            if (findField != null) {
                findField.setAccessible(true);
                findField.set(obj, obj2);
            }
        } catch (IllegalAccessException e) {
        }
    }

    public static <T> T singleWhere(Iterable<T> iterable, Condition<T> condition) {
        if (iterable == null || condition == null) {
            return null;
        }
        for (T t : iterable) {
            if (condition.callback((Condition<T>) t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    public static <T> boolean where(Iterable<T> iterable, ReturnCallback<Boolean, T> returnCallback) {
        if (iterable == null || returnCallback == null) {
            return false;
        }
        for (T t : iterable) {
            if (returnCallback.callback(t).booleanValue()) {
                return true;
            }
        }
        returnCallback.callback(null);
        return false;
    }

    public static <T> boolean where(T[] tArr, ReturnCallback<Boolean, T> returnCallback) {
        if (tArr == null || returnCallback == null) {
            return false;
        }
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                returnCallback.callback(null);
                return false;
            } else if (returnCallback.callback(tArr[i2]).booleanValue()) {
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }
}
