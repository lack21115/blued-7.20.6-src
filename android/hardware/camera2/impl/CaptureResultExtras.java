package android.hardware.camera2.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CaptureResultExtras.class */
public class CaptureResultExtras implements Parcelable {
    public static final Parcelable.Creator<CaptureResultExtras> CREATOR = new Parcelable.Creator<CaptureResultExtras>() { // from class: android.hardware.camera2.impl.CaptureResultExtras.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CaptureResultExtras createFromParcel(Parcel parcel) {
            return new CaptureResultExtras(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CaptureResultExtras[] newArray(int i) {
            return new CaptureResultExtras[i];
        }
    };
    private int afTriggerId;
    private long frameNumber;
    private int partialResultCount;
    private int precaptureTriggerId;
    private int requestId;
    private int subsequenceId;

    public CaptureResultExtras(int i, int i2, int i3, int i4, long j, int i5) {
        this.requestId = i;
        this.subsequenceId = i2;
        this.afTriggerId = i3;
        this.precaptureTriggerId = i4;
        this.frameNumber = j;
        this.partialResultCount = i5;
    }

    private CaptureResultExtras(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAfTriggerId() {
        return this.afTriggerId;
    }

    public long getFrameNumber() {
        return this.frameNumber;
    }

    public int getPartialResultCount() {
        return this.partialResultCount;
    }

    public int getPrecaptureTriggerId() {
        return this.precaptureTriggerId;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public int getSubsequenceId() {
        return this.subsequenceId;
    }

    public void readFromParcel(Parcel parcel) {
        this.requestId = parcel.readInt();
        this.subsequenceId = parcel.readInt();
        this.afTriggerId = parcel.readInt();
        this.precaptureTriggerId = parcel.readInt();
        this.frameNumber = parcel.readLong();
        this.partialResultCount = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.requestId);
        parcel.writeInt(this.subsequenceId);
        parcel.writeInt(this.afTriggerId);
        parcel.writeInt(this.precaptureTriggerId);
        parcel.writeLong(this.frameNumber);
        parcel.writeInt(this.partialResultCount);
    }
}
