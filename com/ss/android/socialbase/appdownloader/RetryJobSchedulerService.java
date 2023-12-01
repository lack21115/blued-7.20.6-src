package com.ss.android.socialbase.appdownloader;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/RetryJobSchedulerService.class */
public class RetryJobSchedulerService extends JobService {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mb(int i) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) appContext.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mb(DownloadInfo downloadInfo, long j, boolean z, int i) {
        Context appContext;
        long j2;
        IReserveWifiStatusListener reserveWifiStatusListener;
        IReserveWifiStatusListener reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (appContext = DownloadComponentManager.getAppContext()) == null) {
            return;
        }
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.onStatusChanged(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) appContext.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(downloadInfo.getId());
            if (i == 0 || (z && i != 2)) {
                j = 1000;
                j2 = 0;
            } else {
                j2 = 60000 + j;
            }
            JobInfo.Builder requiresDeviceIdle = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(appContext.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j).setRequiredNetworkType(z ? 2 : 1).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j2);
            }
            int schedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (schedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener.onStatusChanged(downloadInfo, 3, 3);
            }
            if (schedule <= 0) {
                Logger.w("RetrySchedulerService", "schedule err errCode = " + schedule);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (DownloadComponentManager.notAutoRebootService()) {
            onStartCommand = 2;
        }
        return onStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters != null) {
            int jobId = jobParameters.getJobId();
            Logger.i("RetrySchedulerService", "onStartJob, id = " + jobId);
            RetryScheduler.getInstance().doSchedulerRetry(jobId);
            return false;
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
