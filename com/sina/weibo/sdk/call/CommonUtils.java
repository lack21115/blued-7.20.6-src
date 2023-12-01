package com.sina.weibo.sdk.call;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/call/CommonUtils.class */
class CommonUtils {
    CommonUtils() {
    }

    public static String buildUriQuery(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        for (String str : hashMap.keySet()) {
            String str2 = hashMap.get(str);
            if (str2 != null) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
                sb.append(str);
                sb.append("=");
                sb.append(str2);
            }
        }
        return sb.toString().replaceFirst(ContainerUtils.FIELD_DELIMITER, "?");
    }

    public static void openWeiboActivity(Context context, String str, String str2) throws WeiboNotInstalledException {
        try {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.setData(Uri.parse(str2));
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new WeiboNotInstalledException(WBPageConstants.ExceptionMsg.WEIBO_NOT_INSTALLED);
        }
    }

    public static void openWeiboActivity(Context context, String str, String str2, String str3) throws WeiboNotInstalledException {
        try {
            if (str3 == null) {
                Intent intent = new Intent();
                intent.setAction(str);
                intent.setData(Uri.parse(str2));
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setAction(str);
            intent2.setData(Uri.parse(str2));
            intent2.setPackage(str3);
            context.startActivity(intent2);
        } catch (ActivityNotFoundException e) {
            if (str3 == null) {
                throw new WeiboNotInstalledException(WBPageConstants.ExceptionMsg.WEIBO_NOT_INSTALLED);
            }
            try {
                Intent intent3 = new Intent();
                intent3.setAction(str);
                intent3.setData(Uri.parse(str2));
                context.startActivity(intent3);
            } catch (ActivityNotFoundException e2) {
                throw new WeiboNotInstalledException(WBPageConstants.ExceptionMsg.WEIBO_NOT_INSTALLED);
            }
        }
    }
}
