package android.app.job;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;

/* loaded from: source-9557208-dex2jar.jar:android/app/job/JobInfo.class */
public class JobInfo implements Parcelable {
    public static final int BACKOFF_POLICY_EXPONENTIAL = 1;
    public static final int BACKOFF_POLICY_LINEAR = 0;
    public static final Parcelable.Creator<JobInfo> CREATOR = new Parcelable.Creator<JobInfo>() { // from class: android.app.job.JobInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JobInfo createFromParcel(Parcel parcel) {
            return new JobInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JobInfo[] newArray(int i) {
            return new JobInfo[i];
        }
    };
    public static final int DEFAULT_BACKOFF_POLICY = 1;
    public static final long DEFAULT_INITIAL_BACKOFF_MILLIS = 30000;
    public static final long MAX_BACKOFF_DELAY_MILLIS = 18000000;
    public static final int NETWORK_TYPE_ANY = 1;
    public static final int NETWORK_TYPE_NONE = 0;
    public static final int NETWORK_TYPE_UNMETERED = 2;
    private final int backoffPolicy;
    private final PersistableBundle extras;
    private final boolean hasEarlyConstraint;
    private final boolean hasLateConstraint;
    private final long initialBackoffMillis;
    private final long intervalMillis;
    private final boolean isPeriodic;
    private final boolean isPersisted;
    private final int jobId;
    private final long maxExecutionDelayMillis;
    private final long minLatencyMillis;
    private final int networkType;
    private final boolean requireCharging;
    private final boolean requireDeviceIdle;
    private final ComponentName service;

    /* loaded from: source-9557208-dex2jar.jar:android/app/job/JobInfo$Builder.class */
    public static final class Builder {
        private boolean mHasEarlyConstraint;
        private boolean mHasLateConstraint;
        private long mIntervalMillis;
        private boolean mIsPeriodic;
        private boolean mIsPersisted;
        private int mJobId;
        private ComponentName mJobService;
        private long mMaxExecutionDelayMillis;
        private long mMinLatencyMillis;
        private int mNetworkType;
        private boolean mRequiresCharging;
        private boolean mRequiresDeviceIdle;
        private PersistableBundle mExtras = PersistableBundle.EMPTY;
        private long mInitialBackoffMillis = 30000;
        private int mBackoffPolicy = 1;
        private boolean mBackoffPolicySet = false;

        public Builder(int i, ComponentName componentName) {
            this.mJobService = componentName;
            this.mJobId = i;
        }

        public JobInfo build() {
            if (this.mHasEarlyConstraint || this.mHasLateConstraint || this.mRequiresCharging || this.mRequiresDeviceIdle || this.mNetworkType != 0) {
                this.mExtras = new PersistableBundle(this.mExtras);
                if (!this.mIsPeriodic || this.mMaxExecutionDelayMillis == 0) {
                    if (!this.mIsPeriodic || this.mMinLatencyMillis == 0) {
                        if (this.mBackoffPolicySet && this.mRequiresDeviceIdle) {
                            throw new IllegalArgumentException("An idle mode job will not respect any back-off policy, so calling setBackoffCriteria with setRequiresDeviceIdle is an error.");
                        }
                        return new JobInfo(this);
                    }
                    throw new IllegalArgumentException("Can't call setMinimumLatency() on a periodic job");
                }
                throw new IllegalArgumentException("Can't call setOverrideDeadline() on a periodic job.");
            }
            throw new IllegalArgumentException("You're trying to build a job with no constraints, this is not allowed.");
        }

        public Builder setBackoffCriteria(long j, int i) {
            this.mBackoffPolicySet = true;
            this.mInitialBackoffMillis = j;
            this.mBackoffPolicy = i;
            return this;
        }

        public Builder setExtras(PersistableBundle persistableBundle) {
            this.mExtras = persistableBundle;
            return this;
        }

        public Builder setMinimumLatency(long j) {
            this.mMinLatencyMillis = j;
            this.mHasEarlyConstraint = true;
            return this;
        }

        public Builder setOverrideDeadline(long j) {
            this.mMaxExecutionDelayMillis = j;
            this.mHasLateConstraint = true;
            return this;
        }

        public Builder setPeriodic(long j) {
            this.mIsPeriodic = true;
            this.mIntervalMillis = j;
            this.mHasLateConstraint = true;
            this.mHasEarlyConstraint = true;
            return this;
        }

        public Builder setPersisted(boolean z) {
            this.mIsPersisted = z;
            return this;
        }

        public Builder setRequiredNetworkType(int i) {
            this.mNetworkType = i;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.mRequiresCharging = z;
            return this;
        }

        public Builder setRequiresDeviceIdle(boolean z) {
            this.mRequiresDeviceIdle = z;
            return this;
        }
    }

    private JobInfo(Builder builder) {
        this.jobId = builder.mJobId;
        this.extras = builder.mExtras;
        this.service = builder.mJobService;
        this.requireCharging = builder.mRequiresCharging;
        this.requireDeviceIdle = builder.mRequiresDeviceIdle;
        this.networkType = builder.mNetworkType;
        this.minLatencyMillis = builder.mMinLatencyMillis;
        this.maxExecutionDelayMillis = builder.mMaxExecutionDelayMillis;
        this.isPeriodic = builder.mIsPeriodic;
        this.isPersisted = builder.mIsPersisted;
        this.intervalMillis = builder.mIntervalMillis;
        this.initialBackoffMillis = builder.mInitialBackoffMillis;
        this.backoffPolicy = builder.mBackoffPolicy;
        this.hasEarlyConstraint = builder.mHasEarlyConstraint;
        this.hasLateConstraint = builder.mHasLateConstraint;
    }

    private JobInfo(Parcel parcel) {
        this.jobId = parcel.readInt();
        this.extras = parcel.readPersistableBundle();
        this.service = (ComponentName) parcel.readParcelable(null);
        this.requireCharging = parcel.readInt() == 1;
        this.requireDeviceIdle = parcel.readInt() == 1;
        this.networkType = parcel.readInt();
        this.minLatencyMillis = parcel.readLong();
        this.maxExecutionDelayMillis = parcel.readLong();
        this.isPeriodic = parcel.readInt() == 1;
        this.isPersisted = parcel.readInt() == 1;
        this.intervalMillis = parcel.readLong();
        this.initialBackoffMillis = parcel.readLong();
        this.backoffPolicy = parcel.readInt();
        this.hasEarlyConstraint = parcel.readInt() == 1;
        this.hasLateConstraint = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBackoffPolicy() {
        return this.backoffPolicy;
    }

    public PersistableBundle getExtras() {
        return this.extras;
    }

    public int getId() {
        return this.jobId;
    }

    public long getInitialBackoffMillis() {
        return this.initialBackoffMillis;
    }

    public long getIntervalMillis() {
        return this.intervalMillis;
    }

    public long getMaxExecutionDelayMillis() {
        return this.maxExecutionDelayMillis;
    }

    public long getMinLatencyMillis() {
        return this.minLatencyMillis;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public ComponentName getService() {
        return this.service;
    }

    public boolean hasEarlyConstraint() {
        return this.hasEarlyConstraint;
    }

    public boolean hasLateConstraint() {
        return this.hasLateConstraint;
    }

    public boolean isPeriodic() {
        return this.isPeriodic;
    }

    public boolean isPersisted() {
        return this.isPersisted;
    }

    public boolean isRequireCharging() {
        return this.requireCharging;
    }

    public boolean isRequireDeviceIdle() {
        return this.requireDeviceIdle;
    }

    public String toString() {
        return "(job:" + this.jobId + "/" + this.service.flattenToShortString() + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jobId);
        parcel.writePersistableBundle(this.extras);
        parcel.writeParcelable(this.service, i);
        parcel.writeInt(this.requireCharging ? 1 : 0);
        parcel.writeInt(this.requireDeviceIdle ? 1 : 0);
        parcel.writeInt(this.networkType);
        parcel.writeLong(this.minLatencyMillis);
        parcel.writeLong(this.maxExecutionDelayMillis);
        parcel.writeInt(this.isPeriodic ? 1 : 0);
        parcel.writeInt(this.isPersisted ? 1 : 0);
        parcel.writeLong(this.intervalMillis);
        parcel.writeLong(this.initialBackoffMillis);
        parcel.writeInt(this.backoffPolicy);
        parcel.writeInt(this.hasEarlyConstraint ? 1 : 0);
        parcel.writeInt(this.hasLateConstraint ? 1 : 0);
    }
}
