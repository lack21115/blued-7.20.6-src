package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/RetryScheduler.class */
public class RetryScheduler implements Handler.Callback, AppStatusManager.AppStatusChangeListener {
    private static final int MIN_INTERVAL_MS = 3000;
    private static final int MIN_INTERVAL_MS_ACCELERATION = 5000;
    public static final int NET_TYPE_COMMON = 1;
    public static final int NET_TYPE_NONE = 0;
    public static final int NET_TYPE_WIFI = 2;
    public static final int RETRY_SCHEDULE_NORMAL = 1;
    public static final int RETRY_SCHEDULE_WHEN_APP_BACKGROUND = 3;
    public static final int RETRY_SCHEDULE_WHEN_APP_FOREGROUND = 4;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_CONNECTED = 5;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_SUCCEED = 2;
    private static final int SCHEDULE_ALL_TASK_RETRY_DELAY = 2000;
    private static final int SCHEDULE_ALL_TASK_RETRY_MIN_INTERVAL = 10000;
    private static final String TAG = "RetryScheduler";
    private static volatile RetryScheduler sInstance;
    private static RetryScheduleHandler sRetryScheduleHandler;
    private ConnectivityManager mConnectivityManager;
    private final boolean mIsDownloaderProcess;
    private long mLastHandleAllTaskTime;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<RetryInfo> mRetryInfoList = new SparseArray<>();
    private int mWaitingRetryTasksCount = 0;
    private final Context mContext = DownloadComponentManager.getAppContext();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/RetryScheduler$RetryInfo.class */
    public static class RetryInfo {
        final int[] allowErrorCode;
        final int id;
        final int intervalMs;
        final int intervalMsAcceleration;
        final int level;
        private int mCurrentIntervalMs;
        private boolean mIsWaitingRetry;
        private long mLastRetryTime;
        private boolean mNeedWifi;
        private int mRetryCount;
        final int maxCount;
        final boolean useJobScheduler;

        RetryInfo(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            int i6 = i4 < 3000 ? 3000 : i4;
            int i7 = i5 < 5000 ? 5000 : i5;
            this.id = i;
            this.level = i2;
            this.maxCount = i3;
            this.intervalMs = i6;
            this.intervalMsAcceleration = i7;
            this.useJobScheduler = z;
            this.allowErrorCode = iArr;
            this.mCurrentIntervalMs = i6;
        }

        boolean canRetry(long j, int i, int i2, boolean z) {
            if (!this.mIsWaitingRetry) {
                Logger.i(RetryScheduler.TAG, "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.level >= i && this.mRetryCount < this.maxCount) {
                if (!this.mNeedWifi || i2 == 2) {
                    return z || j - this.mLastRetryTime >= ((long) this.intervalMs);
                }
                return false;
            } else {
                return false;
            }
        }

        int getCurrentRetryIntervalMs() {
            return this.mCurrentIntervalMs;
        }

        void increaseRetryCount() {
            synchronized (this) {
                this.mRetryCount++;
            }
        }

        void increaseRetryInterval() {
            synchronized (this) {
                this.mCurrentIntervalMs += this.intervalMsAcceleration;
            }
        }

        void resetRetryInterval() {
            this.mCurrentIntervalMs = this.intervalMs;
        }

        void updateRetryTimeStamp(long j) {
            synchronized (this) {
                this.mLastRetryTime = j;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/RetryScheduler$RetryScheduleHandler.class */
    public interface RetryScheduleHandler {
        void cancelRetry(int i);

        void scheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    private RetryScheduler() {
        registerNetworkCallback();
        this.mIsDownloaderProcess = DownloadUtils.isDownloaderProcess();
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    private boolean canRetryForAllowErrorCode(RetryInfo retryInfo, int i) {
        int[] iArr = retryInfo.allowErrorCode;
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (iArr[i3] == i) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private boolean canRetryWhenInsufficientSpace(DownloadInfo downloadInfo, BaseException baseException) {
        long j;
        try {
            j = DownloadUtils.getAvailableSpaceBytes(downloadInfo.getTempPath());
        } catch (BaseException e) {
            e.printStackTrace();
            j = 0;
        }
        if (j < (baseException instanceof DownloadOutOfSpaceException ? ((DownloadOutOfSpaceException) baseException).getRequiredSpaceBytes() : downloadInfo.getTotalBytes() - downloadInfo.getCurBytes())) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            if (obtain.optInt(DownloadSettingKeys.SPACE_FILL_PART_DOWNLOAD, 0) == 1) {
                if (j <= 0) {
                    return obtain.optInt(DownloadSettingKeys.DOWNLOAD_WHEN_SPACE_NEGATIVE, 0) == 1;
                }
                int optInt = obtain.optInt(DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100);
                if (optInt > 0) {
                    long j2 = j - (optInt * 1048576);
                    Logger.i(TAG, "retry schedule: available = " + DownloadUtils.byteToMb(j) + "MB, minKeep = " + optInt + "MB, canDownload = " + DownloadUtils.byteToMb(j2) + "MB");
                    if (j2 <= 0) {
                        Logger.w(TAG, "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    private RetryInfo createRetryInfo(int i) {
        int[] iArr;
        int i2;
        int i3;
        boolean z;
        DownloadSetting obtain = DownloadSetting.obtain(i);
        int optInt = obtain.optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0);
        JSONObject optJSONObject = obtain.optJSONObject(DownloadSettingKeys.RETRY_SCHEDULE_CONFIG);
        int i4 = 60;
        if (optJSONObject != null) {
            i3 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, 60);
            i4 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC, 60);
            i2 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC_ACCELERATION, 60);
            z = false;
            if (Build.VERSION.SDK_INT >= 21) {
                z = false;
                if (sRetryScheduleHandler != null) {
                    z = false;
                    if (optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.USE_JOB_SCHEDULER, 0) == 1) {
                        z = true;
                    }
                }
            }
            iArr = parserAllowErrorCode(optJSONObject.optString(DownloadSettingKeys.RetryScheduleConfig.ALLOW_ERROR_CODE));
        } else {
            iArr = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new RetryInfo(i, optInt, i3, i4 * 1000, i2 * 1000, z, iArr);
    }

    private void doScheduleAllTaskRetry(final int i, final boolean z) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.2
            @Override // java.lang.Runnable
            public void run() {
                int netWorkType;
                try {
                    if (RetryScheduler.this.mWaitingRetryTasksCount > 0 && (netWorkType = RetryScheduler.this.getNetWorkType()) != 0) {
                        Logger.i(RetryScheduler.TAG, "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + RetryScheduler.this.mWaitingRetryTasksCount);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<RetryInfo> arrayList = new ArrayList();
                        synchronized (RetryScheduler.this.mRetryInfoList) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= RetryScheduler.this.mRetryInfoList.size()) {
                                    break;
                                }
                                RetryInfo retryInfo = (RetryInfo) RetryScheduler.this.mRetryInfoList.valueAt(i3);
                                if (retryInfo != null && retryInfo.canRetry(currentTimeMillis, i, netWorkType, z)) {
                                    if (z) {
                                        retryInfo.resetRetryInterval();
                                    }
                                    arrayList.add(retryInfo);
                                }
                                i2 = i3 + 1;
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (RetryInfo retryInfo2 : arrayList) {
                                RetryScheduler.this.doSchedulerRetryInSubThread(retryInfo2.id, netWorkType, false);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSchedulerRetryInSubThread(int i, int i2, boolean z) {
        IReserveWifiStatusListener reserveWifiStatusListener;
        boolean z2;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        synchronized (this.mRetryInfoList) {
            RetryInfo retryInfo = this.mRetryInfoList.get(i);
            if (retryInfo == null) {
                return;
            }
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i3 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i3;
                if (i3 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            Logger.i(TAG, "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + retryInfo.mRetryCount + ", mWaitingRetryTasksCount = " + this.mWaitingRetryTasksCount);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            if (downloadInfo == null) {
                removeRetryInfo(i);
                return;
            }
            Logger.e(TAG, "doSchedulerRetryInSubThread，id:" + i);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                removeRetryInfo(i);
            } else if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.onStatusChanged(downloadInfo, 4, 3);
                }
                IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
                if (downloadLaunchHandler != null) {
                    downloadLaunchHandler.onLaunchResume(Collections.singletonList(downloadInfo), 3);
                }
                removeRetryInfo(i);
            } else if (realStatus != -1) {
            } else {
                if (i2 != 0) {
                    z2 = true;
                } else if (!retryInfo.useJobScheduler) {
                    return;
                } else {
                    z2 = false;
                }
                BaseException failedException = downloadInfo.getFailedException();
                boolean z3 = z2;
                if (z2) {
                    z3 = z2;
                    if (DownloadUtils.isInsufficientSpaceError(failedException)) {
                        z3 = canRetryWhenInsufficientSpace(downloadInfo, failedException);
                    }
                }
                retryInfo.increaseRetryCount();
                if (!z3) {
                    if (z) {
                        retryInfo.increaseRetryInterval();
                    }
                    boolean z4 = true;
                    if (!downloadInfo.isOnlyWifi()) {
                        z4 = downloadInfo.isPauseReserveOnWifi();
                    }
                    tryStartScheduleRetry(downloadInfo, z4, i2);
                    return;
                }
                Logger.i(TAG, "doSchedulerRetry: restart task, ****** id = " + retryInfo.id);
                retryInfo.updateRetryTimeStamp(System.currentTimeMillis());
                if (z) {
                    retryInfo.increaseRetryInterval();
                }
                downloadInfo.setRetryScheduleCount(retryInfo.mRetryCount);
                if (downloadInfo.getStatus() == -1) {
                    Downloader.getInstance(context).restart(downloadInfo.getId());
                }
            }
        }
    }

    public static RetryScheduler getInstance() {
        if (sInstance == null) {
            synchronized (RetryScheduler.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new RetryScheduler();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNetWorkType() {
        try {
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            }
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            return activeNetworkInfo.getType() == 1 ? 2 : 1;
        } catch (Exception e) {
            return 0;
        }
    }

    private RetryInfo obtainRetryInfo(int i) {
        RetryInfo retryInfo;
        RetryInfo retryInfo2 = this.mRetryInfoList.get(i);
        if (retryInfo2 == null) {
            synchronized (this.mRetryInfoList) {
                RetryInfo retryInfo3 = this.mRetryInfoList.get(i);
                retryInfo = retryInfo3;
                if (retryInfo3 == null) {
                    retryInfo = createRetryInfo(i);
                }
                this.mRetryInfoList.put(i, retryInfo);
            }
            return retryInfo;
        }
        return retryInfo2;
    }

    private int[] parserAllowErrorCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    return iArr;
                }
                iArr[i2] = Integer.parseInt(split[i2]);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    private void registerNetworkCallback() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.USE_NETWORK_CALLBACK, 0) != 1) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (RetryScheduler.this.mContext == null || Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    RetryScheduler.this.mConnectivityManager = (ConnectivityManager) RetryScheduler.this.mContext.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                    RetryScheduler.this.mConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.1.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            Logger.d(RetryScheduler.TAG, "network onAvailable: ");
                            RetryScheduler.this.scheduleAllTaskRetry(1, true);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void removeRetryInfo(int i) {
        synchronized (this.mRetryInfoList) {
            this.mRetryInfoList.remove(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void scheduleAllTaskRetry(int i, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void setRetryScheduleHandler(RetryScheduleHandler retryScheduleHandler) {
        sRetryScheduleHandler = retryScheduleHandler;
    }

    private void tryStartScheduleRetry(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        RetryInfo obtainRetryInfo = obtainRetryInfo(downloadInfo.getId());
        if (obtainRetryInfo.mRetryCount > obtainRetryInfo.maxCount) {
            Logger.w(TAG, "tryStartScheduleRetry, id = " + obtainRetryInfo.id + ", mRetryCount = " + obtainRetryInfo.mRetryCount + ", maxCount = " + obtainRetryInfo.maxCount);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!DownloadUtils.isInsufficientSpaceError(failedException) && !DownloadUtils.isNetworkError(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!canRetryForAllowErrorCode(obtainRetryInfo, errorCode)) {
                return;
            }
            Logger.i(TAG, "allow error code, id = " + obtainRetryInfo.id + ", error code = " + errorCode);
        }
        obtainRetryInfo.mNeedWifi = z;
        synchronized (this.mRetryInfoList) {
            if (!obtainRetryInfo.mIsWaitingRetry) {
                obtainRetryInfo.mIsWaitingRetry = true;
                this.mWaitingRetryTasksCount++;
            }
        }
        int currentRetryIntervalMs = obtainRetryInfo.getCurrentRetryIntervalMs();
        Logger.i(TAG, "tryStartScheduleRetry: id = " + obtainRetryInfo.id + ", delayTimeMills = " + currentRetryIntervalMs + ", mWaitingRetryTasks = " + this.mWaitingRetryTasksCount);
        if (!obtainRetryInfo.useJobScheduler) {
            if (z) {
                return;
            }
            this.mHandler.removeMessages(downloadInfo.getId());
            this.mHandler.sendEmptyMessageDelayed(downloadInfo.getId(), currentRetryIntervalMs);
            return;
        }
        if (i == 0) {
            obtainRetryInfo.resetRetryInterval();
        }
        RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
        if (retryScheduleHandler != null) {
            retryScheduleHandler.scheduleRetry(downloadInfo, currentRetryIntervalMs, z, i);
        }
        if (this.mIsDownloaderProcess) {
            obtainRetryInfo.updateRetryTimeStamp(System.currentTimeMillis());
            obtainRetryInfo.increaseRetryCount();
            obtainRetryInfo.increaseRetryInterval();
        }
    }

    public void doSchedulerRetry(final int i) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RetryScheduler.this.doSchedulerRetryInSubThread(i, RetryScheduler.this.getNetWorkType(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            doScheduleAllTaskRetry(message.arg1, message.arg2 == 1);
            return true;
        }
        Logger.i(TAG, "handleMessage, doSchedulerRetry, id = " + message.what);
        doSchedulerRetry(message.what);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        scheduleAllTaskRetry(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        scheduleAllTaskRetry(4, false);
    }

    public void scheduleRetryWhenHasTaskConnected() {
        scheduleAllTaskRetry(5, false);
    }

    public void scheduleRetryWhenHasTaskSucceed() {
        scheduleAllTaskRetry(2, true);
    }

    public void tryCancelScheduleRetry(int i) {
        synchronized (this.mRetryInfoList) {
            RetryInfo retryInfo = this.mRetryInfoList.get(i);
            if (retryInfo == null) {
                return;
            }
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i2 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i2;
                if (i2 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            if (!retryInfo.useJobScheduler) {
                this.mHandler.removeMessages(i);
                return;
            }
            RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
            if (retryScheduleHandler != null) {
                retryScheduleHandler.cancelRetry(i);
            }
        }
    }

    public void tryStartScheduleRetry(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(DownloadConstants.MIME_APK) || !DownloadConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
            return;
        }
        tryStartScheduleRetry(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), getNetWorkType());
    }
}
