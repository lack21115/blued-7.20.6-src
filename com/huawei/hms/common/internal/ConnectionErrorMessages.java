package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/ConnectionErrorMessages.class */
public class ConnectionErrorMessages {
    private static boolean a(Context context) {
        return context != null && Util.isAvailableLibExist(context) && AvailableUtil.isInstallerLibExist(context);
    }

    public static String getErrorDialogButtonMessage(Activity activity, int i) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1) {
            return a(activity) ? ResourceLoaderUtil.getString("hms_install") : ResourceLoaderUtil.getString("hms_confirm");
        }
        if (i == 2 && a(activity)) {
            return ResourceLoaderUtil.getString("hms_update");
        }
        return ResourceLoaderUtil.getString("hms_confirm");
    }

    public static String getErrorMessage(Activity activity, int i) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1 || i == 2) {
            return a(activity) ? ResourceLoaderUtil.getString("hms_update_title") : activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), Util.getAppName(activity, activity.getPackageName()));
        }
        return null;
    }

    public static String getErrorTitle(Activity activity, int i) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        String str = null;
        if (i == 1) {
            String str2 = null;
            if (a(activity)) {
                str2 = ResourceLoaderUtil.getString("hms_install_message");
            }
            return str2;
        } else if (i == 2) {
            if (a(activity)) {
                str = ResourceLoaderUtil.getString("hms_update_message");
            }
            return str;
        } else if (i != 3) {
            if (i == 9) {
                HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
                return null;
            }
            HMSLog.e("HuaweiApiAvailability", "Unexpected error code " + i);
            return null;
        } else {
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
        }
    }
}
