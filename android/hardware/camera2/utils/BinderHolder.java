package android.hardware.camera2.utils;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/BinderHolder.class */
public class BinderHolder implements Parcelable {
    public static final Parcelable.Creator<BinderHolder> CREATOR = new Parcelable.Creator<BinderHolder>() { // from class: android.hardware.camera2.utils.BinderHolder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BinderHolder createFromParcel(Parcel parcel) {
            return new BinderHolder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BinderHolder[] newArray(int i) {
            return new BinderHolder[i];
        }
    };
    private IBinder mBinder;

    public BinderHolder() {
        this.mBinder = null;
    }

    public BinderHolder(IBinder iBinder) {
        this.mBinder = null;
        this.mBinder = iBinder;
    }

    private BinderHolder(Parcel parcel) {
        this.mBinder = null;
        this.mBinder = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getBinder() {
        return this.mBinder;
    }

    public void readFromParcel(Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
    }

    public void setBinder(IBinder iBinder) {
        this.mBinder = iBinder;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mBinder);
    }
}
