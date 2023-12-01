package com.igexin.assist.control.huawei;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/huawei/HmsPushManager.class */
public class HmsPushManager implements AbstractPushManager {
    private static final String PACKAGE_HUAWEI = "com.huawei.hwid";
    public static final String PLUGIN_VERSION = "3.1.1";
    public static final String TAG = "Assist_HW";
    private String appId;
    private String token = "";
    private final Object object = new Object();

    public HmsPushManager(Context context) {
        try {
            String str = (String) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.huawei.hms.client.service.name:push");
            Log.d("Assist_HW", "huawei plugin version = 3.1.1, huawei sdk version = " + str.split(":")[1]);
        } catch (Throwable th) {
            Log.d("Assist_HW", th.getMessage());
            Log.d("Assist_HW", "huawei plugin version = 3.1.1, not meta-data");
        }
    }

    public static boolean checkHWDevice(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Class<?> cls = Class.forName("android.os.SystemProperties");
            int parseInt = Integer.parseInt((String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.hw_emui_api_level"));
            Log.d("Assist_HW", "pkgInfo.versionCode " + packageInfo.versionCode + " apiVersionCode = " + parseInt);
            boolean z = false;
            if (packageInfo != null) {
                z = false;
                if (packageInfo.versionCode >= 30000000) {
                    z = false;
                    if (parseInt > 9) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            Log.d("Assist_HW", "check hw device error = " + th);
            return false;
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return null;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        return this.token;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(final Context context) {
        Log.d("Assist_HW", "Register hmspush, pkg = " + context.getPackageName());
        new Thread() { // from class: com.igexin.assist.control.huawei.HmsPushManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    synchronized (HmsPushManager.this.object) {
                        if (TextUtils.isEmpty(HmsPushManager.this.appId)) {
                            HmsPushManager.this.appId = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
                        }
                    }
                    HmsPushManager.this.token = HmsInstanceId.getInstance(context).getToken(HmsPushManager.this.appId, HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    Log.i("Assist_HW", "get hms token:" + HmsPushManager.this.token);
                    if (TextUtils.isEmpty(HmsPushManager.this.token)) {
                        return;
                    }
                    Context context2 = context;
                    MessageManger.getInstance().addMessage(new MessageBean(context2, "token", AssistPushConsts.HW_PREFIX + HmsPushManager.this.token));
                } catch (Throwable th) {
                    Log.e("Assist_HW", "get hms token failed:" + th.getMessage());
                }
            }
        }.start();
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        Log.d("Assist_HW", "turnOffPush");
        HmsMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.igexin.assist.control.huawei.HmsPushManager.4
            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.i("Assist_HW", "turnOffPush Complete");
                    return;
                }
                Log.e("Assist_HW", "turnOffPush failed: ret=" + task.getException().getMessage());
            }
        });
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        Log.d("Assist_HW", "turnOnPush");
        HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.igexin.assist.control.huawei.HmsPushManager.3
            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.i("Assist_HW", "turnOnPush Complete");
                    return;
                }
                Log.e("Assist_HW", "turnOnPush failed: ret=" + task.getException().getMessage());
            }
        });
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(final Context context) {
        new Thread() { // from class: com.igexin.assist.control.huawei.HmsPushManager.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    HmsInstanceId.getInstance(context).deleteToken(AGConnectServicesConfig.fromContext(context).getString("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    Log.i("Assist_HW", "deleteToken success.");
                } catch (ApiException e) {
                    Log.e("Assist_HW", "deleteToken failed." + e);
                }
            }
        }.start();
    }
}
