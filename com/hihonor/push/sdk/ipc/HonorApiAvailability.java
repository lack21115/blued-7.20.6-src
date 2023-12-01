package com.hihonor.push.sdk.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.sdk.HonorPushErrorCode;
import com.hihonor.push.sdk.a;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/ipc/HonorApiAvailability.class */
public class HonorApiAvailability {

    /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/ipc/HonorApiAvailability$PackageStates.class */
    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED
    }

    public static RemoteServiceBean a(Context context) {
        RemoteServiceBean remoteServiceBean = new RemoteServiceBean();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("android", "com.hihonor.android.pushagentproxy.HiPushService"));
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices.size() > 0) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                String str = next.serviceInfo.applicationInfo.packageName;
                String a2 = a.a(context, str);
                remoteServiceBean.setPackageName(str);
                remoteServiceBean.setPackageServiceName(next.serviceInfo.name);
                remoteServiceBean.setPackageSignature(a2);
            }
        }
        return remoteServiceBean;
    }

    public static int isHonorMobileServicesAvailable(Context context) {
        PackageStates packageStates;
        if (context != null) {
            RemoteServiceBean a2 = a(context);
            String packageName = a2.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageStates = PackageStates.NOT_INSTALLED;
            } else {
                try {
                    packageStates = context.getPackageManager().getApplicationInfo(packageName, 0).enabled ? PackageStates.ENABLED : PackageStates.DISABLED;
                } catch (PackageManager.NameNotFoundException e) {
                    packageStates = PackageStates.NOT_INSTALLED;
                }
            }
            if (PackageStates.NOT_INSTALLED.equals(packageStates)) {
                Log.i("HonorApiAvailability", "push service is not installed");
                return HonorPushErrorCode.ERROR_SERVICE_MISSING;
            } else if (!PackageStates.DISABLED.equals(packageStates)) {
                return (!TextUtils.equals(packageName, "android") || TextUtils.isEmpty(a2.getPackageSignature())) ? HonorPushErrorCode.ERROR_SERVICE_INVALID : HonorPushErrorEnum.SUCCESS.statusCode;
            } else {
                Log.i("HonorApiAvailability", "push service is disabled");
                return HonorPushErrorCode.ERROR_SERVICE_DISABLED;
            }
        }
        throw new NullPointerException("context must not be null.");
    }
}
