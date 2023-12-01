package android.app;

import android.app.job.IJobScheduler;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.RemoteException;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/JobSchedulerImpl.class */
public class JobSchedulerImpl extends JobScheduler {
    IJobScheduler mBinder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JobSchedulerImpl(IJobScheduler iJobScheduler) {
        this.mBinder = iJobScheduler;
    }

    @Override // android.app.job.JobScheduler
    public void cancel(int i) {
        try {
            this.mBinder.cancel(i);
        } catch (RemoteException e) {
        }
    }

    @Override // android.app.job.JobScheduler
    public void cancelAll() {
        try {
            this.mBinder.cancelAll();
        } catch (RemoteException e) {
        }
    }

    @Override // android.app.job.JobScheduler
    public List<JobInfo> getAllPendingJobs() {
        try {
            return this.mBinder.getAllPendingJobs();
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // android.app.job.JobScheduler
    public int schedule(JobInfo jobInfo) {
        try {
            return this.mBinder.schedule(jobInfo);
        } catch (RemoteException e) {
            return 0;
        }
    }
}
