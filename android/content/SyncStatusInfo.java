package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/content/SyncStatusInfo.class */
public class SyncStatusInfo implements Parcelable {
    public static final Parcelable.Creator<SyncStatusInfo> CREATOR = new Parcelable.Creator<SyncStatusInfo>() { // from class: android.content.SyncStatusInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncStatusInfo createFromParcel(Parcel parcel) {
            return new SyncStatusInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncStatusInfo[] newArray(int i) {
            return new SyncStatusInfo[i];
        }
    };
    private static final String TAG = "Sync";
    static final int VERSION = 2;
    public final int authorityId;
    public long initialFailureTime;
    public boolean initialize;
    public String lastFailureMesg;
    public int lastFailureSource;
    public long lastFailureTime;
    public int lastSuccessSource;
    public long lastSuccessTime;
    public int numSourceLocal;
    public int numSourcePeriodic;
    public int numSourcePoll;
    public int numSourceServer;
    public int numSourceUser;
    public int numSyncs;
    public boolean pending;
    private ArrayList<Long> periodicSyncTimes;
    public long totalElapsedTime;

    public SyncStatusInfo(int i) {
        this.authorityId = i;
    }

    public SyncStatusInfo(SyncStatusInfo syncStatusInfo) {
        this.authorityId = syncStatusInfo.authorityId;
        this.totalElapsedTime = syncStatusInfo.totalElapsedTime;
        this.numSyncs = syncStatusInfo.numSyncs;
        this.numSourcePoll = syncStatusInfo.numSourcePoll;
        this.numSourceServer = syncStatusInfo.numSourceServer;
        this.numSourceLocal = syncStatusInfo.numSourceLocal;
        this.numSourceUser = syncStatusInfo.numSourceUser;
        this.numSourcePeriodic = syncStatusInfo.numSourcePeriodic;
        this.lastSuccessTime = syncStatusInfo.lastSuccessTime;
        this.lastSuccessSource = syncStatusInfo.lastSuccessSource;
        this.lastFailureTime = syncStatusInfo.lastFailureTime;
        this.lastFailureSource = syncStatusInfo.lastFailureSource;
        this.lastFailureMesg = syncStatusInfo.lastFailureMesg;
        this.initialFailureTime = syncStatusInfo.initialFailureTime;
        this.pending = syncStatusInfo.pending;
        this.initialize = syncStatusInfo.initialize;
        if (syncStatusInfo.periodicSyncTimes != null) {
            this.periodicSyncTimes = new ArrayList<>(syncStatusInfo.periodicSyncTimes);
        }
    }

    public SyncStatusInfo(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt != 2 && readInt != 1) {
            Log.w("SyncStatusInfo", "Unknown version: " + readInt);
        }
        this.authorityId = parcel.readInt();
        this.totalElapsedTime = parcel.readLong();
        this.numSyncs = parcel.readInt();
        this.numSourcePoll = parcel.readInt();
        this.numSourceServer = parcel.readInt();
        this.numSourceLocal = parcel.readInt();
        this.numSourceUser = parcel.readInt();
        this.lastSuccessTime = parcel.readLong();
        this.lastSuccessSource = parcel.readInt();
        this.lastFailureTime = parcel.readLong();
        this.lastFailureSource = parcel.readInt();
        this.lastFailureMesg = parcel.readString();
        this.initialFailureTime = parcel.readLong();
        this.pending = parcel.readInt() != 0;
        this.initialize = parcel.readInt() != 0;
        if (readInt == 1) {
            this.periodicSyncTimes = null;
            return;
        }
        int readInt2 = parcel.readInt();
        if (readInt2 < 0) {
            this.periodicSyncTimes = null;
            return;
        }
        this.periodicSyncTimes = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt2) {
                return;
            }
            this.periodicSyncTimes.add(Long.valueOf(parcel.readLong()));
            i = i2 + 1;
        }
    }

    private void ensurePeriodicSyncTimeSize(int i) {
        if (this.periodicSyncTimes == null) {
            this.periodicSyncTimes = new ArrayList<>(0);
        }
        int i2 = i + 1;
        if (this.periodicSyncTimes.size() >= i2) {
            return;
        }
        int size = this.periodicSyncTimes.size();
        while (true) {
            int i3 = size;
            if (i3 >= i2) {
                return;
            }
            this.periodicSyncTimes.add(0L);
            size = i3 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLastFailureMesgAsInt(int i) {
        int syncErrorStringToInt = ContentResolver.syncErrorStringToInt(this.lastFailureMesg);
        if (syncErrorStringToInt > 0) {
            return syncErrorStringToInt;
        }
        Log.d(TAG, "Unknown lastFailureMesg:" + this.lastFailureMesg);
        return i;
    }

    public long getPeriodicSyncTime(int i) {
        if (this.periodicSyncTimes == null || i >= this.periodicSyncTimes.size()) {
            return 0L;
        }
        return this.periodicSyncTimes.get(i).longValue();
    }

    public void removePeriodicSyncTime(int i) {
        if (this.periodicSyncTimes == null || i >= this.periodicSyncTimes.size()) {
            return;
        }
        this.periodicSyncTimes.remove(i);
    }

    public void setPeriodicSyncTime(int i, long j) {
        ensurePeriodicSyncTimeSize(i);
        this.periodicSyncTimes.set(i, Long.valueOf(j));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(2);
        parcel.writeInt(this.authorityId);
        parcel.writeLong(this.totalElapsedTime);
        parcel.writeInt(this.numSyncs);
        parcel.writeInt(this.numSourcePoll);
        parcel.writeInt(this.numSourceServer);
        parcel.writeInt(this.numSourceLocal);
        parcel.writeInt(this.numSourceUser);
        parcel.writeLong(this.lastSuccessTime);
        parcel.writeInt(this.lastSuccessSource);
        parcel.writeLong(this.lastFailureTime);
        parcel.writeInt(this.lastFailureSource);
        parcel.writeString(this.lastFailureMesg);
        parcel.writeLong(this.initialFailureTime);
        parcel.writeInt(this.pending ? 1 : 0);
        parcel.writeInt(this.initialize ? 1 : 0);
        if (this.periodicSyncTimes == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(this.periodicSyncTimes.size());
        Iterator<Long> it = this.periodicSyncTimes.iterator();
        while (it.hasNext()) {
            parcel.writeLong(it.next().longValue());
        }
    }
}
