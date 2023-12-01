package com.blued.android.core.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/FixedBadParcelHelper.class */
public class FixedBadParcelHelper {
    public static void a(Context context, Bundle bundle) {
        Set<String> keySet;
        if (context == null || bundle == null || !a()) {
            return;
        }
        bundle.setClassLoader(context.getClass().getClassLoader());
        Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (bundle2 != null && (keySet = bundle2.keySet()) != null) {
            for (String str : keySet) {
                Object obj = bundle2.get(str);
                if (obj instanceof Bundle) {
                    ((Bundle) obj).setClassLoader(context.getClass().getClassLoader());
                }
            }
        }
        Log.b("FixedBadParcelHelper", "intercept end");
    }

    public static boolean a() {
        String str = Build.MANUFACTURER;
        Log.b("FixedBadParcelHelper", "isRealmeNew manufacturer=" + str);
        boolean z = !TextUtils.isEmpty(str) && (str.toLowerCase().contains("realme") || str.toLowerCase().contains("oppo") || str.toLowerCase().contains("vivo") || str.toLowerCase().contains("huawei") || str.toLowerCase().contains("samsung") || str.toLowerCase().contains("xiaomi") || str.toLowerCase().contains("acer"));
        Log.b("FixedBadParcelHelper", "isRealmeNew isContain=" + z);
        return z;
    }
}
