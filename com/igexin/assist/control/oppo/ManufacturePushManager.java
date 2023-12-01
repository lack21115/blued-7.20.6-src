package com.igexin.assist.control.oppo;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/oppo/ManufacturePushManager.class */
public class ManufacturePushManager implements ICallBackResultService, AbstractPushManager {
    public static final String PLUGIN_VERSION = "3.3.0";
    public static final String TAG = "Assist_OP";
    private String appKey;
    private String appSecret;
    private Context context;

    public ManufacturePushManager(Context context) {
        this.appKey = "";
        this.appSecret = "";
        try {
            this.context = context;
            Log.d("Assist_OP", "oppo plugin version = 3.3.0, oppo sdk version = " + HeytapPushManager.getSDKVersionName());
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String appKeyByBuildConfig = Utils.getAppKeyByBuildConfig(applicationInfo);
            this.appKey = appKeyByBuildConfig;
            if (TextUtils.isEmpty(appKeyByBuildConfig)) {
                String str = (String) applicationInfo.metaData.get(AssistPushConsts.OPPOPUSH_APPKEY);
                this.appKey = str;
                this.appKey = str.replace(AssistPushConsts.OPPO_PREFIX, "");
            }
            String appSecretByBuildConfig = Utils.getAppSecretByBuildConfig(applicationInfo);
            this.appSecret = appSecretByBuildConfig;
            if (TextUtils.isEmpty(appSecretByBuildConfig)) {
                String str2 = (String) applicationInfo.metaData.get(AssistPushConsts.OPPOPUSH_APPSECRET);
                this.appSecret = str2;
                this.appSecret = str2.replace(AssistPushConsts.OPPO_PREFIX, "");
            }
            createNotificationChannel(context);
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    public static boolean checkOppoDevice(Context context) {
        try {
            HeytapPushManager.init(context, false);
            return HeytapPushManager.isSupportPush(context);
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
            return false;
        }
    }

    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Class<?> cls = Class.forName("android.app.NotificationChannel");
        Constructor<?> constructor = cls.getConstructor(String.class, CharSequence.class, Integer.TYPE);
        if (constructor == null || ((Parcelable) NotificationManager.class.getMethod("getNotificationChannel", String.class).invoke(notificationManager, "Default")) != null) {
            return;
        }
        NotificationManager.class.getMethod("createNotificationChannel", cls).invoke(notificationManager, (Parcelable) constructor.newInstance("Default", "Default", 3));
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getBrandCode() {
        return "4";
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public String getToken(Context context) {
        return HeytapPushManager.getRegisterID();
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public boolean isSupport() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            HeytapPushManager.init(context, false);
            boolean isSupportPush = HeytapPushManager.isSupportPush(this.context);
            Log.d("Assist_OP", "is oppo:".concat(String.valueOf(isSupportPush)));
            return isSupportPush;
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
            return false;
        }
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onError(int i, String str) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetNotificationStatus(int i, int i2) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetPushStatus(int i, int i2) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onRegister(int i, String str) {
        String valueOf;
        String valueOf2;
        try {
            Log.d("Assist_OP", "onToken :" + str + ", code = " + i);
            if (this.context == null || i != 0 || TextUtils.isEmpty(str) || str.equalsIgnoreCase("InvalidAppKey")) {
                return;
            }
            String str2 = "";
            String[] split = str.split("_");
            if (split.length != 1) {
                if (split.length == 2) {
                    if (split[0].equalsIgnoreCase("CN")) {
                        valueOf2 = String.valueOf(str);
                    } else {
                        valueOf = String.valueOf(str);
                        str2 = "OPG_".concat(valueOf);
                    }
                } else if (split.length == 3) {
                    if (split[1].equalsIgnoreCase("CN")) {
                        valueOf2 = String.valueOf(str);
                    } else {
                        valueOf = String.valueOf(str);
                        str2 = "OPG_".concat(valueOf);
                    }
                }
                MessageManger.getInstance().addMessage(new MessageBean(this.context, "token", str2));
            }
            valueOf2 = String.valueOf(str);
            str2 = AssistPushConsts.OPPO_PREFIX.concat(valueOf2);
            MessageManger.getInstance().addMessage(new MessageBean(this.context, "token", str2));
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onSetPushTime(int i, String str) {
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onUnRegister(int i) {
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void register(Context context) {
        try {
            this.context = context;
            if (!TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.appSecret)) {
                Log.d("Assist_OP", "Register oppo push, pkg = " + context.getPackageName() + ", appKey = " + this.appKey + ", appSecret = " + this.appSecret);
                if (isSupport()) {
                    HeytapPushManager.register(context, this.appKey, this.appSecret, this);
                    return;
                } else {
                    Log.d("Assist_OP", "not support oppo push.");
                    return;
                }
            }
            Log.d("Assist_OP", "Register oppo push appKey or appSecret is null or empty");
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void setSilentTime(Context context, int i, int i2) {
        if (i2 == 0) {
            turnOnPush(context);
            return;
        }
        int i3 = (i + i2) % 24;
        Log.d("Assist_OP", "getui setSilentTime" + i + ":" + i2);
        Log.d("Assist_OP", "oppo push setAcceptTime" + i3 + ":" + i);
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 7) {
                HeytapPushManager.setPushTime(arrayList, i3, 0, i, 0);
                return;
            } else {
                arrayList.add(Integer.valueOf(i5));
                i4 = i5 + 1;
            }
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOffPush(Context context) {
        try {
            HeytapPushManager.pausePush();
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void turnOnPush(Context context) {
        try {
            HeytapPushManager.resumePush();
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }

    @Override // com.igexin.assist.control.AbstractPushManager
    public void unregister(Context context) {
        try {
            HeytapPushManager.unRegister();
        } catch (Throwable th) {
            Log.d("Assist_OP", th.getMessage());
        }
    }
}
