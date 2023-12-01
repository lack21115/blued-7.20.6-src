package com.tencent.liteav.base.storage;

import android.content.SharedPreferences;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.Map;
import java.util.Set;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/storage/PersistStorage.class */
public class PersistStorage {
    public static final String GLOBAL_DOMAIN = "com.liteav.storage.global";
    private final SharedPreferences.Editor mEditor;
    private final SharedPreferences mSharedPreferences;

    public PersistStorage(String str) {
        SharedPreferences sharedPreferences = ContextUtils.getApplicationContext().getSharedPreferences(str, 0);
        this.mSharedPreferences = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    public static int integerToBase(Integer num) {
        return num.intValue();
    }

    public static long longToBase(Long l) {
        return l.longValue();
    }

    public void clear(String str) {
        this.mEditor.remove(str);
    }

    public void commit() {
        this.mEditor.commit();
    }

    public String[] getAllKeys() {
        Map<String, ?> all = this.mSharedPreferences.getAll();
        if (all == null || all.isEmpty()) {
            return new String[0];
        }
        Set<String> keySet = all.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }

    public Integer getInt(String str) {
        if (this.mSharedPreferences.contains(str)) {
            try {
                return Integer.valueOf(this.mSharedPreferences.getInt(str, -1));
            } catch (ClassCastException e) {
                return null;
            }
        }
        return null;
    }

    public Long getLong(String str) {
        if (this.mSharedPreferences.contains(str)) {
            try {
                return Long.valueOf(this.mSharedPreferences.getLong(str, -1L));
            } catch (ClassCastException e) {
                return null;
            }
        }
        return null;
    }

    public String getString(String str) {
        if (this.mSharedPreferences.contains(str)) {
            try {
                return this.mSharedPreferences.getString(str, null);
            } catch (ClassCastException e) {
                return null;
            }
        }
        return null;
    }

    public void put(String str, int i) {
        this.mEditor.putInt(str, i);
    }

    public void put(String str, long j) {
        this.mEditor.putLong(str, j);
    }

    public void put(String str, String str2) {
        this.mEditor.putString(str, str2);
    }
}
