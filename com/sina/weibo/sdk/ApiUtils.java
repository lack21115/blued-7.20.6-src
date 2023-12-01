package com.sina.weibo.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/ApiUtils.class */
public class ApiUtils {
    public static final int BUILD_INT = 10350;
    public static final int BUILD_INT_440 = 10355;
    public static final int BUILD_INT_VER_2_2 = 10351;
    public static final int BUILD_INT_VER_2_3 = 10352;
    public static final int BUILD_INT_VER_2_5 = 10353;
    private static final String TAG = ApiUtils.class.getName();

    private static boolean containSign(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        int length = signatureArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (str.equals(MD5.hexdigest(signatureArr[i2].toByteArray()))) {
                LogUtil.d(TAG, "check pass");
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean validateWeiboSign(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return containSign(context.getPackageManager().getPackageInfo(str, 64).signatures, WBConstants.WEIBO_SIGN);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
