package com.blued.android.module.common.user;

import android.text.TextUtils;
import com.blued.android.framework.utils.AesCrypto;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/LoginRegisterUtils.class */
public class LoginRegisterUtils {
    public static String a(String str) {
        try {
            return !TextUtils.isEmpty(str) ? AesCrypto.b(str) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
