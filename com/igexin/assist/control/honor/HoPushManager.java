package com.igexin.assist.control.honor;

import android.content.Context;
import android.util.Log;
import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;
import com.hihonor.push.sdk.ipc.HonorApiAvailability;
import com.igexin.assist.control.AbstractPushManager;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/honor/HoPushManager.class */
public class HoPushManager implements AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.3.0";
    public static final String TAG = "Assist_Honor";
    private Context context;
    private final Object object = new Object();
    private String token = "";

    public HoPushManager(Context context) {
        try {
            this.context = context;
            Log.d("Assist_Honor", "honor plugin version = 3.3.0, honor sdk version = ".concat(String.valueOf((String) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.hihonor.push.sdk_version"))));
        } catch (Throwable th) {
            Log.d("Assist_Honor", th.getMessage());
            Log.d("Assist_Honor", "honor plugin version = 3.3.0, not meta-data");
        }
    }

    public static boolean checkHWDevice(Context context) {
        int i;
        try {
            i = HonorApiAvailability.isHonorMobileServicesAvailable(context);
        } catch (Throwable th) {
            Log.e("Assist_Honor", "honor check support failed.".concat(String.valueOf(th)));
            i = -1;
        }
        return i == 0;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return "7";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        return this.token;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        int i;
        try {
            i = HonorApiAvailability.isHonorMobileServicesAvailable(this.context);
        } catch (Throwable th) {
            Log.e("Assist_Honor", "honor check support failed.".concat(String.valueOf(th)));
            i = -1;
        }
        return i == 0;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        Log.d("Assist_Honor", "Register honorpush, pkg = " + this.context.getPackageName());
        if (!checkHWDevice(context)) {
            Log.d("Assist_Honor", "honorpush not support.");
            return;
        }
        Log.d("Assist_Honor", "Register honorpush, pkg = " + this.context.getPackageName());
        if (isSupport()) {
            HonorPushClient.getInstance().init(context, true);
        } else {
            Log.d("Assist_Honor", "honorpush not support.");
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        HonorPushClient.getInstance().turnOffNotificationCenter(new HonorPushCallback<Void>() { // from class: com.igexin.assist.control.honor.HoPushManager.3
            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onFailure(int i, String str) {
                Log.e("Assist_Honor", "turnOffPush failed: ret=" + i + " , " + str);
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onSuccess(Void r4) {
                Log.i("Assist_Honor", "turnOffPush Complete");
            }
        });
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        HonorPushClient.getInstance().turnOffNotificationCenter(new HonorPushCallback<Void>() { // from class: com.igexin.assist.control.honor.HoPushManager.2
            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onFailure(int i, String str) {
                Log.e("Assist_Honor", "turnOnPush failed: ret=" + i + " , " + str);
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onSuccess(Void r4) {
                Log.i("Assist_Honor", "turnOnPush Complete");
            }
        });
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        HonorPushClient.getInstance().deletePushToken(new HonorPushCallback<Void>() { // from class: com.igexin.assist.control.honor.HoPushManager.1
            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onFailure(int i, String str) {
                Log.e("Assist_Honor", "deleteToken failed." + i + " , s = " + str);
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onSuccess(Void r4) {
                Log.i("Assist_Honor", "deleteToken success.");
            }
        });
    }
}
