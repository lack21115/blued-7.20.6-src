package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.constant.WBConstants;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/SecurityHelper.class */
public class SecurityHelper {
    public static boolean checkResponseAppLegal(Context context, WeiboAppManager.WeiboInfo weiboInfo, Intent intent) {
        if ((weiboInfo == null || weiboInfo.getSupportApi() > 10352) && weiboInfo != null) {
            String stringExtra = intent != null ? intent.getStringExtra(WBConstants.Base.APP_PKG) : null;
            return (stringExtra == null || intent.getStringExtra(WBConstants.TRAN) == null || !ApiUtils.validateWeiboSign(context, stringExtra)) ? false : true;
        }
        return true;
    }

    public static boolean containSign(Signature[] signatureArr, String str) {
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
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean validateAppSignatureForIntent(Context context, Intent intent) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            return containSign(packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures, WBConstants.WEIBO_SIGN);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
