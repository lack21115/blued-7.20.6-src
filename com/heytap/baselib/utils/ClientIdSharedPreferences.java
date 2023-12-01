package com.heytap.baselib.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/ClientIdSharedPreferences.class */
public class ClientIdSharedPreferences {
    private static String EXTRAS_KEY_CLIENT_ID = "clientId";
    private static String NAME_CLIENT_INFO = "e3c9997fed83a974";
    private static volatile SharedPreferences sp;

    public static String get(Context context) {
        initIfNeed(context);
        return sp.getString(EXTRAS_KEY_CLIENT_ID, null);
    }

    private static void initIfNeed(Context context) {
        if (sp == null) {
            synchronized (ClientIdSharedPreferences.class) {
                try {
                    if (sp == null) {
                        sp = context.getSharedPreferences(NAME_CLIENT_INFO, 0);
                    }
                } finally {
                }
            }
        }
    }

    public static void set(Context context, String str) {
        initIfNeed(context);
        sp.edit().putString(EXTRAS_KEY_CLIENT_ID, str).apply();
    }
}
