package android.app.job;

import android.app.job.IJobCallback;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;

/* loaded from: source-9557208-dex2jar.jar:android/app/job/JobParameters.class */
public class JobParameters implements Parcelable {
    public static final Parcelable.Creator<JobParameters> CREATOR = new Parcelable.Creator<JobParameters>() { // from class: android.app.job.JobParameters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JobParameters createFromParcel(Parcel parcel) {
            return new JobParameters(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JobParameters[] newArray(int i) {
            return new JobParameters[i];
        }
    };
    private final IBinder callback;
    private final PersistableBundle extras;
    private final int jobId;
    private final boolean overrideDeadlineExpired;

    public JobParameters(IBinder iBinder, int i, PersistableBundle persistableBundle, boolean z) {
        this.jobId = i;
        this.extras = persistableBundle;
        this.callback = iBinder;
        this.overrideDeadlineExpired = z;
    }

    private JobParameters(Parcel parcel) {
        boolean z = true;
        this.jobId = parcel.readInt();
        this.extras = parcel.readPersistableBundle();
        this.callback = parcel.readStrongBinder();
        this.overrideDeadlineExpired = parcel.readInt() != 1 ? false : z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IJobCallback getCallback() {
        return IJobCallback.Stub.asInterface(this.callback);
    }

    public PersistableBundle getExtras() {
        return this.extras;
    }

    public int getJobId() {
        return this.jobId;
    }

    public boolean isOverrideDeadlineExpired() {
        return this.overrideDeadlineExpired;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jobId);
        parcel.writePersistableBundle(this.extras);
        parcel.writeStrongBinder(this.callback);
        parcel.writeInt(this.overrideDeadlineExpired ? 1 : 0);
    }
}
