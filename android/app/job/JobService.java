package android.app.job;

import android.app.Service;
import android.app.job.IJobService;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.annotations.GuardedBy;

/* loaded from: source-9557208-dex2jar.jar:android/app/job/JobService.class */
public abstract class JobService extends Service {
    public static final String PERMISSION_BIND = "android.permission.BIND_JOB_SERVICE";
    private static final String TAG = "JobService";
    @GuardedBy("mHandlerLock")
    JobHandler mHandler;
    private final int MSG_EXECUTE_JOB = 0;
    private final int MSG_STOP_JOB = 1;
    private final int MSG_JOB_FINISHED = 2;
    private final Object mHandlerLock = new Object();
    IJobService mBinder = new IJobService.Stub() { // from class: android.app.job.JobService.1
        @Override // android.app.job.IJobService
        public void startJob(JobParameters jobParameters) {
            JobService.this.ensureHandler();
            Message.obtain(JobService.this.mHandler, 0, jobParameters).sendToTarget();
        }

        @Override // android.app.job.IJobService
        public void stopJob(JobParameters jobParameters) {
            JobService.this.ensureHandler();
            Message.obtain(JobService.this.mHandler, 1, jobParameters).sendToTarget();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/job/JobService$JobHandler.class */
    public class JobHandler extends Handler {
        JobHandler(Looper looper) {
            super(looper);
        }

        private void ackStartMessage(JobParameters jobParameters, boolean z) {
            IJobCallback callback = jobParameters.getCallback();
            int jobId = jobParameters.getJobId();
            if (callback != null) {
                try {
                    callback.acknowledgeStartMessage(jobId, z);
                } catch (RemoteException e) {
                    Log.e(JobService.TAG, "System unreachable for starting job.");
                }
            } else if (Log.isLoggable(JobService.TAG, 3)) {
                Log.d(JobService.TAG, "Attempting to ack a job that has already been processed.");
            }
        }

        private void ackStopMessage(JobParameters jobParameters, boolean z) {
            IJobCallback callback = jobParameters.getCallback();
            int jobId = jobParameters.getJobId();
            if (callback != null) {
                try {
                    callback.acknowledgeStopMessage(jobId, z);
                } catch (RemoteException e) {
                    Log.e(JobService.TAG, "System unreachable for stopping job.");
                }
            } else if (Log.isLoggable(JobService.TAG, 3)) {
                Log.d(JobService.TAG, "Attempting to ack a job that has already been processed.");
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = true;
            JobParameters jobParameters = (JobParameters) message.obj;
            switch (message.what) {
                case 0:
                    try {
                        ackStartMessage(jobParameters, JobService.this.onStartJob(jobParameters));
                        return;
                    } catch (Exception e) {
                        Log.e(JobService.TAG, "Error while executing job: " + jobParameters.getJobId());
                        throw new RuntimeException(e);
                    }
                case 1:
                    try {
                        ackStopMessage(jobParameters, JobService.this.onStopJob(jobParameters));
                        return;
                    } catch (Exception e2) {
                        Log.e(JobService.TAG, "Application unable to handle onStopJob.", e2);
                        throw new RuntimeException(e2);
                    }
                case 2:
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    IJobCallback callback = jobParameters.getCallback();
                    if (callback == null) {
                        Log.e(JobService.TAG, "finishJob() called for a nonexistent job id.");
                        return;
                    }
                    try {
                        callback.jobFinished(jobParameters.getJobId(), z);
                        return;
                    } catch (RemoteException e3) {
                        Log.e(JobService.TAG, "Error reporting job finish to system: binder has goneaway.");
                        return;
                    }
                default:
                    Log.e(JobService.TAG, "Unrecognised message received.");
                    return;
            }
        }
    }

    void ensureHandler() {
        synchronized (this.mHandlerLock) {
            if (this.mHandler == null) {
                this.mHandler = new JobHandler(getMainLooper());
            }
        }
    }

    public final void jobFinished(JobParameters jobParameters, boolean z) {
        ensureHandler();
        Message obtain = Message.obtain(this.mHandler, 2, jobParameters);
        obtain.arg2 = z ? 1 : 0;
        obtain.sendToTarget();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mBinder.asBinder();
    }

    public abstract boolean onStartJob(JobParameters jobParameters);

    public abstract boolean onStopJob(JobParameters jobParameters);
}
