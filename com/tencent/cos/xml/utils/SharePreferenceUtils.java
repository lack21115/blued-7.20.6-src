package com.tencent.cos.xml.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/utils/SharePreferenceUtils.class */
public class SharePreferenceUtils {
    private static SharePreferenceUtils instance;
    private SharedPreferences sharedPreferences;

    private SharePreferenceUtils(Context context) {
        this.sharedPreferences = context.getSharedPreferences("upload_download", 0);
    }

    public static SharePreferenceUtils instance(Context context) {
        synchronized (SharePreferenceUtils.class) {
            try {
                if (instance == null) {
                    instance = new SharePreferenceUtils(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return instance;
    }

    public boolean clear(String str) {
        synchronized (this) {
            if (str != null) {
                return this.sharedPreferences.edit().remove(str).commit();
            }
            return false;
        }
    }

    public String getValue(String str) {
        synchronized (this) {
            if (str != null) {
                return this.sharedPreferences.getString(str, null);
            }
            return null;
        }
    }

    public boolean updateValue(String str, String str2) {
        synchronized (this) {
            if (str != null) {
                return this.sharedPreferences.edit().putString(str, str2).commit();
            }
            return false;
        }
    }
}
