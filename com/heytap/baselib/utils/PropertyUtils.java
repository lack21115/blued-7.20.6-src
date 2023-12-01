package com.heytap.baselib.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/PropertyUtils.class */
public class PropertyUtils {
    private static final String TAG = PropertyUtils.class.getSimpleName();
    private static final String BRAND_O = idIOUtil.base64Decode("T1BQTw==");
    private static final String BRAND_OP = idIOUtil.base64Decode("T25lcGx1cw==");

    PropertyUtils() {
    }

    private static boolean isDeviceTypeTv(Context context) {
        return ((UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE)).getCurrentModeType() == 4;
    }

    private static boolean isOBrand() {
        return BRAND_O.equalsIgnoreCase(Build.BRAND);
    }

    private static boolean isOPBrand() {
        return BRAND_OP.equalsIgnoreCase(Build.BRAND);
    }

    public static boolean isOPTV(Context context) {
        return isOPBrand() && isDeviceTypeTv(context);
    }

    public static boolean isOTV(Context context) {
        return isOBrand() && isDeviceTypeTv(context);
    }
}
