package android.app.job;

import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/job/JobScheduler.class */
public abstract class JobScheduler {
    public static final int RESULT_FAILURE = 0;
    public static final int RESULT_SUCCESS = 1;

    public abstract void cancel(int i);

    public abstract void cancelAll();

    public abstract List<JobInfo> getAllPendingJobs();

    public abstract int schedule(JobInfo jobInfo);
}
