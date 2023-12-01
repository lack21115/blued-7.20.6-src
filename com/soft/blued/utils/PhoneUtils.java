package com.soft.blued.utils;

import android.telephony.TelephonyManager;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.PermissionUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/PhoneUtils.class */
public class PhoneUtils {
    public static String a() {
        return PermissionUtils.a(new String[]{"android.permission.READ_PHONE_STATE"}) ? ((TelephonyManager) AppInfo.d().getSystemService("phone")).getNetworkOperatorName() : "";
    }
}
