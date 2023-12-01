package com.blued.android.chat;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.heart.PingCheckerManager;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/PingCheckerJobServer.class */
public class PingCheckerJobServer extends JobService implements PingCheckerManager.PingCheckerListener {
    private static final int IM_CHECK_JOB_ID = 108;
    private static final String TAG = "Chat_PingChecker";
    private Runnable finishJobTask;
    private JobParameters jobParams;
    private Handler uiHandler;

    public static void startServer(Context context) {
        if (ChatManager.debug) {
            Log.v(TAG, "start PingCheckerJobServer...");
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            JobInfo.Builder builder = new JobInfo.Builder(108, new ComponentName(context, PingCheckerJobServer.class));
            builder.setRequiredNetworkType(1);
            builder.setPeriodic(300000L);
            int schedule = jobScheduler.schedule(builder.build());
            if (ChatManager.debug) {
                Log.v(TAG, "start PingCheckerJobServer result:" + schedule);
            }
        } catch (Exception e) {
            if (ChatManager.debug) {
                Log.v(TAG, "start PingCheckerJobServer exception:" + e);
            }
        }
    }

    public static void stopServer(Context context) {
        if (ChatManager.debug) {
            Log.v(TAG, "stop PingCheckerJobServer...");
        }
        try {
            ((JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE)).cancel(108);
        } catch (Exception e) {
            if (ChatManager.debug) {
                Log.v(TAG, "stop PingCheckerJobServer exception:" + e);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.uiHandler = new Handler();
        this.finishJobTask = new Runnable() { // from class: com.blued.android.chat.PingCheckerJobServer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PingCheckerJobServer.this.jobParams != null) {
                    if (ChatManager.debug) {
                        Log.v(PingCheckerJobServer.TAG, "jobFinished");
                    }
                    PingCheckerJobServer pingCheckerJobServer = PingCheckerJobServer.this;
                    pingCheckerJobServer.jobFinished(pingCheckerJobServer.jobParams, false);
                }
            }
        };
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (ChatManager.debug) {
            Log.v(TAG, "pingCheckerJobServer.onDestroy()");
        }
    }

    @Override // com.blued.android.chat.core.worker.heart.PingCheckerManager.PingCheckerListener
    public void onPingCheckFinish() {
        if (ChatManager.debug) {
            Log.v(TAG, "pingCheckerJobServer.onPingCheckFinish(), will finish job after 30s.");
        }
        this.uiHandler.postDelayed(this.finishJobTask, 30000L);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (ChatManager.debug) {
            Log.v(TAG, "pingCheckerJobServer.onStartJob()");
        }
        this.uiHandler.removeCallbacks(this.finishJobTask);
        this.jobParams = jobParameters;
        return (ChatManagerInner.isStopped() || PingCheckerManager.getInstance().checkImLink(this)) ? false : true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (ChatManager.debug) {
            Log.v(TAG, "pingCheckerJobServer.onStopJob()");
        }
        PingCheckerManager.getInstance().stopCheckImLink(this);
        this.uiHandler.removeCallbacks(this.finishJobTask);
        return false;
    }
}
