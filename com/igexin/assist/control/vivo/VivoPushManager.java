package com.igexin.assist.control.vivo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.sdk.PushManager;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import java.io.File;
import java.lang.reflect.Field;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/vivo/VivoPushManager.class */
public class VivoPushManager implements AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.1.1";
    public static final String TAG = "Assist_VV";
    private static final String VIVO_VERSION = "sdk_version_vivo";
    private String mSdkSwitchPath;
    public static final String VIVO = "Vivo".toLowerCase();
    private static final String phoneBrand = Build.BRAND;

    public VivoPushManager(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Log.d("Assist_VV", "vivo plugin version = 3.1.1, vivo sdk version = " + applicationInfo.metaData.get(VIVO_VERSION));
            this.mSdkSwitchPath = context.getFilesDir().getPath() + "/init.pid";
            PushClient.getInstance(context).initialize();
            PushClient.getInstance(context).checkManifest();
        } catch (Throwable th) {
            Log.e("Assist_VV", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVivoMessageBeanExtra(MessageBean messageBean) {
        try {
            Field declaredField = MessageBean.class.getDeclaredField("extra");
            declaredField.setAccessible(true);
            ((Bundle) declaredField.get(messageBean)).putBoolean("isForce", true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean checkVivoDevice(Context context) {
        try {
            boolean isSupport = PushClient.getInstance(context).isSupport();
            Log.d("Assist_VV", "the vivo system push support = ".concat(String.valueOf(isSupport)));
            return isSupport;
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
            return false;
        }
    }

    private boolean isSdkInit() {
        if (this.mSdkSwitchPath != null) {
            return new File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return null;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        return PushClient.getInstance(context).getRegId();
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        return false;
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            Log.d("Assist_VV", "Register vivo push, pkg = " + context.getPackageName());
            if (PushManager.getInstance().isPushTurnedOn(context) || !isSdkInit()) {
                turnOnPush(context);
            }
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(final Context context) {
        try {
            PushClient.getInstance(context).turnOffPush(new IPushActionListener() { // from class: com.igexin.assist.control.vivo.VivoPushManager.2
                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i) {
                    Log.d("Assist_VV", "turnOffPush finish, state = ".concat(String.valueOf(i)));
                    if (i != 0 || context == null) {
                        return;
                    }
                    Log.d("Assist_VV", "turnOnPush token = \"false\"");
                    MessageManger.getInstance().addMessage(new MessageBean(context, "token", "false"));
                }
            });
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(final Context context) {
        try {
            PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: com.igexin.assist.control.vivo.VivoPushManager.1
                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i) {
                    Log.d("Assist_VV", "turnOnPush finish, state = ".concat(String.valueOf(i)));
                    if (i != 0) {
                        if (i == 101) {
                            Log.d("Assist_VV", "the vivo rom not support system push");
                            return;
                        }
                        return;
                    }
                    String regId = PushClient.getInstance(context).getRegId();
                    Log.d("Assist_VV", "turnOnPush token = ".concat(String.valueOf(regId)));
                    if (context == null || TextUtils.isEmpty(regId)) {
                        return;
                    }
                    MessageBean messageBean = new MessageBean(context, "token", AssistPushConsts.VIVO_PREFIX.concat(String.valueOf(regId)));
                    VivoPushManager.this.addVivoMessageBeanExtra(messageBean);
                    MessageManger.getInstance().addMessage(messageBean);
                }
            });
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        try {
            turnOffPush(context);
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }
}
