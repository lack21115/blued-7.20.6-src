package com.igexin.assist.control.xiaomi;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.xiaomi.mipush.sdk.MiPushClient;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/xiaomi/ManufacturePushManager.class */
public class ManufacturePushManager implements AbstractPushManager {
    private static final String PACKAGE_XIAOMI = "com.xiaomi.xmsf";
    public static final String PLUGIN_VERSION = "3.3.0";
    public static final String TAG = "Assist_XM";
    public static final String XIAOMI_VERSION = "5_1_0-C";
    private String appId;
    private String appKey;
    private Context context;

    public ManufacturePushManager(Context context) {
        this.appId = "";
        this.appKey = "";
        try {
            this.context = context;
            Log.d("Assist_XM", "xiaomi plugin version = 3.3.0, xiaomi sdk version = 5_1_0-C");
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String appIdByBuildConfig = Utils.getAppIdByBuildConfig(applicationInfo);
            this.appId = appIdByBuildConfig;
            if (TextUtils.isEmpty(appIdByBuildConfig)) {
                String str = (String) applicationInfo.metaData.get(AssistPushConsts.MIPUSH_APPID);
                this.appId = str;
                this.appId = str.replace(AssistPushConsts.XM_PREFIX, "");
            }
            String appKeyByBuildConfig = Utils.getAppKeyByBuildConfig(applicationInfo);
            this.appKey = appKeyByBuildConfig;
            if (TextUtils.isEmpty(appKeyByBuildConfig)) {
                String str2 = (String) applicationInfo.metaData.get(AssistPushConsts.MIPUSH_APPKEY);
                this.appKey = str2;
                this.appKey = str2.replace(AssistPushConsts.XM_PREFIX, "");
            }
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return "3";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        if (context == null) {
            return null;
        }
        return MiPushClient.getRegId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        boolean z = false;
        try {
            if (XmSystemUtils.isBrandXiaoMi()) {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(PACKAGE_XIAOMI, 0);
                z = false;
                if (packageInfo != null) {
                    z = false;
                    if (packageInfo.versionCode >= 105) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            Log.d("Assist_XM", "support error is : " + th.toString());
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            if (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appKey) || context == null) {
                Log.d("Assist_XM", "Register mipush appId or appKey is empty, or context null.");
                return;
            }
            Log.d("Assist_XM", "Register mipush, pkg = " + context.getPackageName());
            if (isSupport()) {
                MiPushClient.registerPush(context, this.appId, this.appKey);
            } else {
                Log.d("Assist_XM", "mipush not support.");
            }
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
        if (i2 == 0) {
            turnOnPush(context);
            return;
        }
        int i3 = (i + i2) % 24;
        Log.d("Assist_XM", "getui setSilentTime" + i + ":" + i2);
        Log.d("Assist_XM", "mipush setAcceptTime" + i3 + ":" + i);
        MiPushClient.setAcceptTime(context, i3, 0, i, 0, null);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        if (context == null) {
            return;
        }
        MiPushClient.pausePush(context, this.appId);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        if (context == null) {
            return;
        }
        MiPushClient.resumePush(context, this.appId);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        try {
            Log.d("Assist_XM", "Unregister mipush");
            if (context == null) {
                return;
            }
            MiPushClient.unregisterPush(context);
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }
}
