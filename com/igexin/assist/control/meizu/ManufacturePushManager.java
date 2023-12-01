package com.igexin.assist.control.meizu;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.meizu.cloud.pushsdk.PushManager;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/meizu/ManufacturePushManager.class */
public class ManufacturePushManager implements AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.2.2";
    public static final String TAG = "Assist_MZ";
    private String appId;
    private String appKey;
    private Context context;

    public ManufacturePushManager(Context context) {
        this.appId = "";
        this.appKey = "";
        String str = PushManager.TAG;
        String str2 = str;
        try {
            try {
                Field[] declaredFields = Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    str2 = str;
                    if (i >= length) {
                        break;
                    }
                    Field field = declaredFields[i];
                    String str3 = str;
                    str2 = str;
                    if (Modifier.isFinal(field.getModifiers())) {
                        str3 = str;
                        if ("TAG".equals(field.getName())) {
                            String str4 = str;
                            str3 = (String) field.get(null);
                        }
                    }
                    i++;
                    str = str3;
                }
            } catch (Throwable th) {
                Log.d("Assist_MZ", th.getMessage());
                return;
            }
        } catch (Exception e) {
        }
        Log.d("Assist_MZ", "meizu plugin version = 3.2.2, meizu sdk version = ".concat(String.valueOf(str2)));
        this.context = context;
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        String appIdByBuildConfig = Utils.getAppIdByBuildConfig(applicationInfo);
        this.appId = appIdByBuildConfig;
        if (TextUtils.isEmpty(appIdByBuildConfig)) {
            String str5 = (String) applicationInfo.metaData.get(AssistPushConsts.MEIZUPUSH_APPID);
            this.appId = str5;
            this.appId = str5.replace(AssistPushConsts.MZ_PREFIX, "");
        }
        String appKeyByBuildConfig = Utils.getAppKeyByBuildConfig(applicationInfo);
        this.appKey = appKeyByBuildConfig;
        if (TextUtils.isEmpty(appKeyByBuildConfig)) {
            String str6 = (String) applicationInfo.metaData.get(AssistPushConsts.MEIZUPUSH_APPKEY);
            this.appKey = str6;
            this.appKey = str6.replace(AssistPushConsts.MZ_PREFIX, "");
        }
    }

    private static boolean isBrandMeizu() {
        boolean z;
        try {
            String a2 = i.a("ro.meizu.product.model");
            Log.d("Assist_MZ", "brand = ".concat(String.valueOf(a2)));
            if (TextUtils.isEmpty(a2) && !AssistUtils.BRAND_MZ.equalsIgnoreCase(Build.BRAND) && !"22c4185e".equalsIgnoreCase(Build.BRAND)) {
                z = false;
                Log.d("Assist_MZ", "is mz:".concat(String.valueOf(z)));
                return z;
            }
            z = true;
            Log.d("Assist_MZ", "is mz:".concat(String.valueOf(z)));
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return "4";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        if (context == null) {
            return null;
        }
        return PushManager.getPushId(context);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        try {
            return isBrandMeizu();
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            if (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appKey) || context == null) {
                Log.d("Assist_MZ", "Register mzpush appId not find, or context null.");
                return;
            }
            Log.d("Assist_MZ", "Register meizupush, pkg = " + context.getPackageName());
            if (isSupport()) {
                PushManager.register(context, this.appId, this.appKey);
            } else {
                Log.d("Assist_MZ", "mzpush not support.");
            }
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        if (context == null) {
            return;
        }
        String pushId = PushManager.getPushId(context);
        if (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(pushId)) {
            return;
        }
        PushManager.switchPush(context, this.appId, this.appKey, pushId, false);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        if (context == null) {
            return;
        }
        String pushId = PushManager.getPushId(context);
        if (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(pushId)) {
            return;
        }
        PushManager.switchPush(context, this.appId, this.appKey, pushId, true);
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        try {
            if (!TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey)) {
                Log.d("Assist_MZ", "|Unregister meizupush");
                PushManager.unRegister(context, this.appId, this.appKey);
                return;
            }
            Log.d("Assist_MZ", "|Unregister meizupush appId not find");
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }
}
