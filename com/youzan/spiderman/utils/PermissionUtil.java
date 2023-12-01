package com.youzan.spiderman.utils;

import android.content.Context;
import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/PermissionUtil.class */
public class PermissionUtil {
    public static boolean hasExtStroragePermision(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return true;
    }

    public static boolean hasReadPhoneStatePermission(Context context) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }
}
