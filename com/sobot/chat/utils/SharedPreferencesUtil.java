package com.sobot.chat.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.sobot.chat.core.channel.Const;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SharedPreferencesUtil.class */
public class SharedPreferencesUtil {
    private static String CONFIG = "sobot_config";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences sharedPreferences1;

    private static String Object2String(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
            objectOutputStream.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object String2Object(String str) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0)));
            Object readObject = objectInputStream.readObject();
            objectInputStream.close();
            return readObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppKey(Context context, String str) {
        return context == null ? str : context.getSharedPreferences(CONFIG, 0).getString(Const.SOBOT_APPKEY, str);
    }

    public static boolean getBooleanData(Context context, String str, boolean z) {
        if (sharedPreferences == null) {
            if (context == null) {
                return z;
            }
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        return sharedPreferences.getBoolean(str, z);
    }

    public static int getIntData(Context context, String str, int i) {
        if (sharedPreferences == null) {
            if (context == null) {
                return i;
            }
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        return sharedPreferences.getInt(str, i);
    }

    public static long getLongData(Context context, String str, long j) {
        if (sharedPreferences == null) {
            if (context == null) {
                return j;
            }
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        return sharedPreferences.getLong(str, j);
    }

    public static Object getObject(Context context, String str) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        String string = sharedPreferences.getString(str, null);
        if (string != null) {
            return String2Object(string);
        }
        return null;
    }

    public static String getOnlyStringData(Context context, String str, String str2) {
        if (sharedPreferences1 == null) {
            if (context == null) {
                return str2;
            }
            sharedPreferences1 = context.getSharedPreferences(CONFIG, 0);
        }
        return sharedPreferences1.getString(str, str2);
    }

    public static String getStringData(Context context, String str, String str2) {
        if (sharedPreferences == null) {
            if (context == null) {
                return str2;
            }
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        return sharedPreferences.getString(str, str2);
    }

    public static void removeKey(Context context, String str) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public static void saveAppKey(Context context, String str) {
        sharedPreferences = null;
        context.getSharedPreferences(CONFIG, 0).edit().putString(Const.SOBOT_APPKEY, str).apply();
    }

    public static void saveBooleanData(Context context, String str, boolean z) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public static void saveIntData(Context context, String str, int i) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        sharedPreferences.edit().putInt(str, i).apply();
    }

    public static void saveLongData(Context context, String str, long j) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public static void saveObject(Context context, String str, Object obj) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, Object2String(obj));
        edit.commit();
    }

    public static void saveOnlyStringData(Context context, String str, String str2) {
        if (sharedPreferences1 == null) {
            sharedPreferences1 = context.getSharedPreferences(CONFIG, 0);
        }
        sharedPreferences1.edit().putString(str, str2).apply();
    }

    public static void saveStringData(Context context, String str, String str2) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(CONFIG + getAppKey(context, ""), 0);
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }
}
