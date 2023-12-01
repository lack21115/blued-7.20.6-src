package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.at;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/internal/PreferenceWrapper.class */
public class PreferenceWrapper {
    private static final String DEFAULT_PREFERENCE = at.b().b(at.j);

    private PreferenceWrapper() {
    }

    public static SharedPreferences getDefault(Context context) {
        if (context != null) {
            return context.getSharedPreferences(DEFAULT_PREFERENCE, 0);
        }
        return null;
    }

    public static SharedPreferences getInstance(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
