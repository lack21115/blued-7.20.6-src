package com.sina.weibo.sdk.cmd;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/WbAppActivator.class */
public class WbAppActivator {
    private static final String TAG = WbAppActivator.class.getName();
    private static WbAppActivator mInstance;
    private String mAppkey;
    private Context mContext;
    private AppInstallCmdExecutor mInstallExecutor;
    private AppInvokeCmdExecutor mInvokeExecutor;
    private volatile ReentrantLock mLock = new ReentrantLock(true);

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/WbAppActivator$FrequencyHelper.class */
    static class FrequencyHelper {
        private static final int DEFAULT_FREQUENCY = 3600000;
        private static final String KEY_FREQUENCY = "frequency_get_cmd";
        private static final String KEY_LAST_TIME_GET_CMD = "last_time_get_cmd";
        private static final String WEIBO_SDK_PREFERENCES_NAME = "com_sina_weibo_sdk";

        private FrequencyHelper() {
        }

        public static long getFrequency(Context context, SharedPreferences sharedPreferences) {
            if (sharedPreferences != null) {
                return sharedPreferences.getLong(KEY_FREQUENCY, 3600000L);
            }
            return 3600000L;
        }

        public static long getLastTime(Context context, SharedPreferences sharedPreferences) {
            if (sharedPreferences != null) {
                return sharedPreferences.getLong(KEY_LAST_TIME_GET_CMD, 0L);
            }
            return 0L;
        }

        public static SharedPreferences getWeiboSdkSp(Context context) {
            return context.getSharedPreferences(WEIBO_SDK_PREFERENCES_NAME, 0);
        }

        public static void saveFrequency(Context context, SharedPreferences sharedPreferences, long j) {
            if (sharedPreferences == null || j <= 0) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(KEY_FREQUENCY, j);
            edit.commit();
        }

        public static void saveLastTime(Context context, SharedPreferences sharedPreferences, long j) {
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(KEY_LAST_TIME_GET_CMD, j);
                edit.commit();
            }
        }
    }

    private WbAppActivator(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mInvokeExecutor = new AppInvokeCmdExecutor(applicationContext);
        this.mInstallExecutor = new AppInstallCmdExecutor(this.mContext);
        this.mAppkey = str;
    }

    public static WbAppActivator getInstance(Context context, String str) {
        WbAppActivator wbAppActivator;
        synchronized (WbAppActivator.class) {
            try {
                if (mInstance == null) {
                    mInstance = new WbAppActivator(context, str);
                }
                wbAppActivator = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wbAppActivator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInstallCmd(List<AppInstallCmd> list) {
        if (list != null) {
            this.mInstallExecutor.start();
            for (AppInstallCmd appInstallCmd : list) {
                this.mInstallExecutor.doExecutor(appInstallCmd);
            }
            this.mInstallExecutor.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInvokeCmd(List<AppInvokeCmd> list) {
        if (list != null) {
            for (AppInvokeCmd appInvokeCmd : list) {
                this.mInvokeExecutor.doExecutor(appInvokeCmd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String requestCmdInfo(Context context, String str) {
        String packageName = context.getPackageName();
        String sign = Utility.getSign(context, packageName);
        WeiboParameters weiboParameters = new WeiboParameters(str);
        weiboParameters.put("appkey", str);
        weiboParameters.put("packagename", packageName);
        weiboParameters.put("key_hash", sign);
        weiboParameters.put("version", WBConstants.WEIBO_SDK_VERSION_CODE);
        return NetUtils.internalHttpRequest(context, "http://api.weibo.cn/2/client/common_config", "GET", weiboParameters);
    }

    public void activateApp() {
        final SharedPreferences weiboSdkSp = FrequencyHelper.getWeiboSdkSp(this.mContext);
        long frequency = FrequencyHelper.getFrequency(this.mContext, weiboSdkSp);
        long currentTimeMillis = System.currentTimeMillis() - FrequencyHelper.getLastTime(this.mContext, weiboSdkSp);
        if (currentTimeMillis < frequency) {
            LogUtil.v(TAG, String.format("it's only %d ms from last time get cmd", Long.valueOf(currentTimeMillis)));
        } else {
            new Thread(new Runnable() { // from class: com.sina.weibo.sdk.cmd.WbAppActivator.1
                /* JADX WARN: Removed duplicated region for block: B:36:0x013d  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 392
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.cmd.WbAppActivator.AnonymousClass1.run():void");
                }
            }).start();
        }
    }
}
