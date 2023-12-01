package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003sl.iu;

/* loaded from: source-9557208-dex2jar.jar:android/content/SyncResult.class */
public final class SyncResult implements Parcelable {
    public static final SyncResult ALREADY_IN_PROGRESS = new SyncResult(true);
    public static final Parcelable.Creator<SyncResult> CREATOR = new Parcelable.Creator<SyncResult>() { // from class: android.content.SyncResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncResult createFromParcel(Parcel parcel) {
            return new SyncResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncResult[] newArray(int i) {
            return new SyncResult[i];
        }
    };
    public boolean databaseError;
    public long delayUntil;
    public boolean fullSyncRequested;
    public boolean moreRecordsToGet;
    public boolean partialSyncUnavailable;
    public final SyncStats stats;
    public final boolean syncAlreadyInProgress;
    public boolean tooManyDeletions;
    public boolean tooManyRetries;

    public SyncResult() {
        this(false);
    }

    private SyncResult(Parcel parcel) {
        this.syncAlreadyInProgress = parcel.readInt() != 0;
        this.tooManyDeletions = parcel.readInt() != 0;
        this.tooManyRetries = parcel.readInt() != 0;
        this.databaseError = parcel.readInt() != 0;
        this.fullSyncRequested = parcel.readInt() != 0;
        this.partialSyncUnavailable = parcel.readInt() != 0;
        this.moreRecordsToGet = parcel.readInt() != 0;
        this.delayUntil = parcel.readLong();
        this.stats = new SyncStats(parcel);
    }

    private SyncResult(boolean z) {
        this.syncAlreadyInProgress = z;
        this.tooManyDeletions = false;
        this.tooManyRetries = false;
        this.fullSyncRequested = false;
        this.partialSyncUnavailable = false;
        this.moreRecordsToGet = false;
        this.delayUntil = 0L;
        this.stats = new SyncStats();
    }

    public void clear() {
        if (this.syncAlreadyInProgress) {
            throw new UnsupportedOperationException("you are not allowed to clear the ALREADY_IN_PROGRESS SyncStats");
        }
        this.tooManyDeletions = false;
        this.tooManyRetries = false;
        this.databaseError = false;
        this.fullSyncRequested = false;
        this.partialSyncUnavailable = false;
        this.moreRecordsToGet = false;
        this.delayUntil = 0L;
        this.stats.clear();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean hasError() {
        return hasSoftError() || hasHardError();
    }

    public boolean hasHardError() {
        return this.stats.numParseExceptions > 0 || this.stats.numConflictDetectedExceptions > 0 || this.stats.numAuthExceptions > 0 || this.tooManyDeletions || this.tooManyRetries || this.databaseError;
    }

    public boolean hasSoftError() {
        return this.syncAlreadyInProgress || this.stats.numIoExceptions > 0;
    }

    public boolean madeSomeProgress() {
        return (this.stats.numDeletes > 0 && !this.tooManyDeletions) || this.stats.numInserts > 0 || this.stats.numUpdates > 0;
    }

    public String toDebugString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.fullSyncRequested) {
            stringBuffer.append("f1");
        }
        if (this.partialSyncUnavailable) {
            stringBuffer.append("r1");
        }
        if (hasHardError()) {
            stringBuffer.append("X1");
        }
        if (this.stats.numParseExceptions > 0) {
            stringBuffer.append(iu.h).append(this.stats.numParseExceptions);
        }
        if (this.stats.numConflictDetectedExceptions > 0) {
            stringBuffer.append("c").append(this.stats.numConflictDetectedExceptions);
        }
        if (this.stats.numAuthExceptions > 0) {
            stringBuffer.append("a").append(this.stats.numAuthExceptions);
        }
        if (this.tooManyDeletions) {
            stringBuffer.append("D1");
        }
        if (this.tooManyRetries) {
            stringBuffer.append("R1");
        }
        if (this.databaseError) {
            stringBuffer.append("b1");
        }
        if (hasSoftError()) {
            stringBuffer.append("x1");
        }
        if (this.syncAlreadyInProgress) {
            stringBuffer.append("l1");
        }
        if (this.stats.numIoExceptions > 0) {
            stringBuffer.append("I").append(this.stats.numIoExceptions);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SyncResult:");
        if (this.syncAlreadyInProgress) {
            sb.append(" syncAlreadyInProgress: ").append(this.syncAlreadyInProgress);
        }
        if (this.tooManyDeletions) {
            sb.append(" tooManyDeletions: ").append(this.tooManyDeletions);
        }
        if (this.tooManyRetries) {
            sb.append(" tooManyRetries: ").append(this.tooManyRetries);
        }
        if (this.databaseError) {
            sb.append(" databaseError: ").append(this.databaseError);
        }
        if (this.fullSyncRequested) {
            sb.append(" fullSyncRequested: ").append(this.fullSyncRequested);
        }
        if (this.partialSyncUnavailable) {
            sb.append(" partialSyncUnavailable: ").append(this.partialSyncUnavailable);
        }
        if (this.moreRecordsToGet) {
            sb.append(" moreRecordsToGet: ").append(this.moreRecordsToGet);
        }
        if (this.delayUntil > 0) {
            sb.append(" delayUntil: ").append(this.delayUntil);
        }
        sb.append(this.stats);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.syncAlreadyInProgress ? 1 : 0);
        parcel.writeInt(this.tooManyDeletions ? 1 : 0);
        parcel.writeInt(this.tooManyRetries ? 1 : 0);
        parcel.writeInt(this.databaseError ? 1 : 0);
        parcel.writeInt(this.fullSyncRequested ? 1 : 0);
        parcel.writeInt(this.partialSyncUnavailable ? 1 : 0);
        parcel.writeInt(this.moreRecordsToGet ? 1 : 0);
        parcel.writeLong(this.delayUntil);
        this.stats.writeToParcel(parcel, i);
    }
}
