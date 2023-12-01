package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.Constants;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/utils/SharedPreferenceManager.class */
public class SharedPreferenceManager {
    private static final String DECRYPT_TAG = "decryptTag";
    private static final String HAS_DEFAULT_CHANNEL_CREATED = "hasDefaultChannelCreated";
    private static final String SHARED_PREFS_NAME = "shared_msg_sdk";
    private static final String STATIC_INFOMATION_SDK_VERSION = "lastUpLoadInfoSDKVersionName";
    private static final String STATIC_INFOMATION_UNIQUE_ID = "lastUploadInfoUniqueID";
    private Context mContext;
    private SharedPreferences mSharedPrefs;
    private Object prefsLock;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/utils/SharedPreferenceManager$SharedPreferenceManagerInstanceHolder.class */
    static class SharedPreferenceManagerInstanceHolder {
        static SharedPreferenceManager INSTANCE = new SharedPreferenceManager();

        private SharedPreferenceManagerInstanceHolder() {
        }
    }

    private SharedPreferenceManager() {
        this.prefsLock = new Object();
        Context context = PushService.getInstance().getContext();
        if (context != null) {
            this.mContext = getStorageContext(context);
        }
        Context context2 = this.mContext;
        if (context2 != null) {
            this.mSharedPrefs = context2.getSharedPreferences(SHARED_PREFS_NAME, 0);
        }
    }

    public static SharedPreferenceManager getInstance() {
        return SharedPreferenceManagerInstanceHolder.INSTANCE;
    }

    private SharedPreferences getSharedPrefs() {
        SharedPreferences sharedPreferences = this.mSharedPrefs;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.prefsLock) {
            if (this.mSharedPrefs != null || this.mContext == null) {
                return this.mSharedPrefs;
            }
            SharedPreferences sharedPreferences2 = this.mContext.getSharedPreferences(SHARED_PREFS_NAME, 0);
            this.mSharedPrefs = sharedPreferences2;
            return sharedPreferences2;
        }
    }

    private Context getStorageContext(Context context) {
        boolean isFBEVersion = ApkInfoUtil.isFBEVersion();
        LogUtil.d("fbeVersion is ".concat(String.valueOf(isFBEVersion)));
        return (!isFBEVersion || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    public String getDecryptTag() {
        SharedPreferences sharedPrefs = getSharedPrefs();
        return sharedPrefs != null ? sharedPrefs.getString(DECRYPT_TAG, "DES") : "DES";
    }

    public int getIntData(String str) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs != null) {
            return sharedPrefs.getInt(str, 0);
        }
        return 0;
    }

    public int getIntData(String str, int i) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        return sharedPrefs != null ? sharedPrefs.getInt(str, i) : i;
    }

    public String getLastUpdataUniqueID() {
        SharedPreferences sharedPrefs = getSharedPrefs();
        return sharedPrefs != null ? sharedPrefs.getString(STATIC_INFOMATION_UNIQUE_ID, "") : "";
    }

    public String getLastUploadInfoSDKVersion() {
        SharedPreferences sharedPrefs = getSharedPrefs();
        return sharedPrefs != null ? sharedPrefs.getString(STATIC_INFOMATION_SDK_VERSION, "") : "";
    }

    public long getLongData(String str) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        return sharedPrefs != null ? sharedPrefs.getLong(str, Constants.UNKNOWN_LONG.longValue()) : Constants.UNKNOWN_LONG.longValue();
    }

    public long getLongData(String str, long j) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        return sharedPrefs != null ? sharedPrefs.getLong(str, j) : j;
    }

    public boolean hasDefaultChannelCreated() {
        SharedPreferences sharedPrefs = getSharedPrefs();
        boolean z = false;
        if (sharedPrefs != null) {
            z = sharedPrefs.getBoolean(HAS_DEFAULT_CHANNEL_CREATED, false);
        }
        return z;
    }

    public void saveDecryptTag(String str) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs != null) {
            sharedPrefs.edit().putString(DECRYPT_TAG, str).commit();
        }
    }

    public void saveLastUploadUniqueID(String str) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs != null) {
            sharedPrefs.edit().putString(STATIC_INFOMATION_UNIQUE_ID, str).commit();
        }
    }

    public void saveSDKVersionName() {
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs != null) {
            sharedPrefs.edit().putString(STATIC_INFOMATION_SDK_VERSION, "3.1.0").commit();
        }
    }

    public void setHasDefaultChannelCreated(boolean z) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs != null) {
            sharedPrefs.edit().putBoolean(HAS_DEFAULT_CHANNEL_CREATED, z).commit();
        }
    }

    public void setIntData(String str, int i) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs != null) {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    public void setLongData(String str, long j) {
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs != null) {
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putLong(str, j);
            edit.apply();
        }
    }
}
