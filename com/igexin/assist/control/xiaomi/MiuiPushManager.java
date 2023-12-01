package com.igexin.assist.control.xiaomi;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/xiaomi/MiuiPushManager.class */
public class MiuiPushManager implements AbstractPushManager {
    private static final String KEY_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String PACKAGE_XIAOMI = "com.xiaomi.xmsf";
    public static final String PLUGIN_VERSION = "3.3.0";
    public static final String TAG = "Assist_XM";
    public static final String XIAOMI_VERSION = "5_1_0-C";
    private static final String phoneBrand = Build.BRAND;
    private String appId;
    private String appKey;

    public MiuiPushManager(Context context) {
        this.appId = "";
        this.appKey = "";
        try {
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

    public static boolean checkXMDevice(Context context) {
        PackageInfo packageInfo;
        try {
            if (!isMIUI() || (packageInfo = context.getPackageManager().getPackageInfo(PACKAGE_XIAOMI, 0)) == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable th) {
            return false;
        }
    }

    private static String getProp(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (Exception e) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            try {
                bufferedReader.close();
                return readLine;
            } catch (IOException e2) {
                e2.printStackTrace();
                return readLine;
            }
        } catch (Exception e3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            bufferedReader2 = bufferedReader;
            th = th2;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static boolean isMIUI() {
        return (TextUtils.isEmpty(getProp("ro.miui.ui.version.name")) && TextUtils.isEmpty(getProp("ro.miui.ui.version.code"))) ? false : true;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return null;
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
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            if (!TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appKey)) {
                Log.d("Assist_XM", "Register mipush, pkg = " + context.getPackageName());
                MiPushClient.registerPush(context, this.appId, this.appKey);
                return;
            }
            Log.d("Assist_XM", "Register mipush appId or appKey is null or empty");
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
