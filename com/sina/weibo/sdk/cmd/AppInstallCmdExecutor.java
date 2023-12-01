package com.sina.weibo.sdk.cmd;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.SDKNotification;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/AppInstallCmdExecutor.class */
public class AppInstallCmdExecutor implements CmdExecutor<AppInstallCmd> {
    private static final int MESSAGE_DO_CMD = 1;
    private static final int MESSAGE_QUIT_LOOP = 2;
    private boolean isStarted = false;
    private Context mContext;
    private InstallHandler mHandler;
    private Looper mLooper;
    private HandlerThread thread;
    private static final String WB_APK_FILE_DIR = Environment.getExternalStorageDirectory() + "/Android/org_share_data/";
    private static final String TAG = AppInstallCmdExecutor.class.getName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/AppInstallCmdExecutor$InstallHandler.class */
    public class InstallHandler extends Handler {
        public InstallHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                AppInstallCmdExecutor.this.handleCmd((AppInstallCmd) message.obj);
            } else if (i != 2) {
            } else {
                AppInstallCmdExecutor.this.mLooper.quit();
                AppInstallCmdExecutor.this.isStarted = false;
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/AppInstallCmdExecutor$NOTIFICATION_CONSTANTS.class */
    static final class NOTIFICATION_CONSTANTS {
        private static final int NOTIFICATIONID = 1;
        private static final String WEIBO = "Weibo";
        private static final String WEIBO_ZH_CN = "微博";
        private static final String WEIBO_ZH_TW = "微博";

        private NOTIFICATION_CONSTANTS() {
        }
    }

    public AppInstallCmdExecutor(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private static PendingIntent buildInstallApkIntent(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return PendingIntent.getActivity(context, 0, new Intent(), 16);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), AdBaseConstants.MIME_APK);
        return PendingIntent.getActivity(context, 0, intent, 16);
    }

    private static boolean checkApkInstalled(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static boolean checkApkSign(PackageInfo packageInfo, String str) {
        if (packageInfo == null) {
            return false;
        }
        if (packageInfo.signatures == null) {
            return Build.VERSION.SDK_INT < 11;
        }
        String str2 = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= packageInfo.signatures.length) {
                break;
            }
            byte[] byteArray = packageInfo.signatures[i2].toByteArray();
            if (byteArray != null) {
                str2 = MD5.hexdigest(byteArray);
            }
            i = i2 + 1;
        }
        if (str2 == null) {
            return false;
        }
        return str2.equals(str);
    }

    private static boolean checkPackageName(PackageInfo packageInfo, String str) {
        if (packageInfo == null) {
            return false;
        }
        return str.equals(packageInfo.packageName);
    }

    private static String generateSaveFileName(String str) {
        int lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1, str.length()) : "";
    }

    private static String getNotificationTitle(Context context, String str) {
        return TextUtils.isEmpty(str) ? ResourceManager.getString(context, "Weibo", "微博", "微博") : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCmd(AppInstallCmd appInstallCmd) {
        String internalGetRedirectUri;
        String generateSaveFileName;
        String str = "";
        if (needActivate(this.mContext, appInstallCmd)) {
            String str2 = WB_APK_FILE_DIR;
            String downloadUrl = appInstallCmd.getDownloadUrl();
            long appVersion = appInstallCmd.getAppVersion();
            Pair<Integer, File> walkDir = walkDir(this.mContext, str2, appInstallCmd);
            if (walkDir != null && walkDir.second != null && walkDir.first.intValue() >= appVersion) {
                showNotification(this.mContext, appInstallCmd, walkDir.second.getAbsolutePath());
            } else if (NetworkHelper.isWifiValid(this.mContext)) {
                try {
                    if (TextUtils.isEmpty(downloadUrl)) {
                        return;
                    }
                    try {
                        internalGetRedirectUri = NetUtils.internalGetRedirectUri(this.mContext, downloadUrl, "GET", new WeiboParameters(""));
                        generateSaveFileName = generateSaveFileName(internalGetRedirectUri);
                    } catch (WeiboException e) {
                        e.printStackTrace();
                        if (TextUtils.isEmpty("")) {
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(generateSaveFileName) && generateSaveFileName.endsWith(".apk")) {
                        String internalDownloadFile = NetUtils.internalDownloadFile(this.mContext, internalGetRedirectUri, str2, generateSaveFileName);
                        if (TextUtils.isEmpty(internalDownloadFile)) {
                            return;
                        }
                        str = internalDownloadFile;
                        showNotification(this.mContext, appInstallCmd, str);
                        return;
                    }
                    LogUtil.e(TAG, "redirectDownloadUrl is illeagle");
                    if (TextUtils.isEmpty("")) {
                        return;
                    }
                    showNotification(this.mContext, appInstallCmd, "");
                } catch (Throwable th) {
                    if (!TextUtils.isEmpty("")) {
                        showNotification(this.mContext, appInstallCmd, "");
                    }
                    throw th;
                }
            }
        }
    }

    private static boolean isSpecifiedApk(PackageInfo packageInfo, List<String> list, String str) {
        boolean z;
        Iterator<String> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (checkPackageName(packageInfo, it.next())) {
                z = true;
                break;
            }
        }
        return z && checkApkSign(packageInfo, str);
    }

    private static boolean needActivate(Context context, AppInstallCmd appInstallCmd) {
        List<String> appPackage = appInstallCmd.getAppPackage();
        if (appPackage == null || appPackage.size() == 0 || TextUtils.isEmpty(appInstallCmd.getAppSign()) || TextUtils.isEmpty(appInstallCmd.getDownloadUrl()) || TextUtils.isEmpty(appInstallCmd.getNotificationText())) {
            return false;
        }
        if (appPackage.contains("com.sina.weibo")) {
            WeiboAppManager.WeiboInfo weiboInfo = WeiboAppManager.getInstance(context).getWeiboInfo();
            return weiboInfo == null || !weiboInfo.isLegal();
        }
        for (String str : appPackage) {
            if (checkApkInstalled(context, str)) {
                return false;
            }
        }
        return true;
    }

    private static void showNotification(Context context, AppInstallCmd appInstallCmd, String str) {
        SDKNotification.SDKNotificationBuilder.buildUpon().setNotificationContent(appInstallCmd.getNotificationText()).setNotificationPendingIntent(buildInstallApkIntent(context, str)).setNotificationTitle(getNotificationTitle(context, appInstallCmd.getNotificationTitle())).setTickerText(appInstallCmd.getNotificationText()).build(context).show(1);
    }

    private static Pair<Integer, File> walkDir(Context context, String str, AppInstallCmd appInstallCmd) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            int length = listFiles.length;
            int i = 0;
            int i2 = 0;
            File file2 = null;
            while (i < length) {
                File file3 = listFiles[i];
                String name = file3.getName();
                File file4 = file2;
                int i3 = i2;
                if (file3.isFile()) {
                    file4 = file2;
                    i3 = i2;
                    if (name.endsWith(".apk")) {
                        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file3.getAbsolutePath(), 64);
                        if (isSpecifiedApk(packageArchiveInfo, appInstallCmd.getAppPackage(), appInstallCmd.getAppSign())) {
                            file4 = file2;
                            i3 = i2;
                            if (packageArchiveInfo.versionCode > i2) {
                                i3 = packageArchiveInfo.versionCode;
                                file4 = file3;
                            }
                        } else {
                            file4 = file2;
                            i3 = i2;
                        }
                    }
                }
                i++;
                file2 = file4;
                i2 = i3;
            }
            return new Pair<>(Integer.valueOf(i2), file2);
        }
        return null;
    }

    @Override // com.sina.weibo.sdk.cmd.CmdExecutor
    public boolean doExecutor(AppInstallCmd appInstallCmd) {
        InstallHandler installHandler;
        if (this.thread == null || (installHandler = this.mHandler) == null) {
            throw new RuntimeException("no thread running. please call start method first!");
        }
        if (appInstallCmd != null) {
            Message obtainMessage = installHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = appInstallCmd;
            this.mHandler.sendMessage(obtainMessage);
            return false;
        }
        return false;
    }

    public void start() {
        if (this.isStarted) {
            return;
        }
        this.isStarted = true;
        HandlerThread handlerThread = new HandlerThread("");
        this.thread = handlerThread;
        handlerThread.start();
        this.mLooper = this.thread.getLooper();
        this.mHandler = new InstallHandler(this.mLooper);
    }

    public void stop() {
        InstallHandler installHandler;
        if (this.thread == null || (installHandler = this.mHandler) == null) {
            LogUtil.w(TAG, "no thread running. please call start method first!");
            return;
        }
        Message obtainMessage = installHandler.obtainMessage();
        obtainMessage.what = 2;
        this.mHandler.sendMessage(obtainMessage);
    }
}
