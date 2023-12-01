package android.view.inputmethod;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputBinding.class */
public final class InputBinding implements Parcelable {
    public static final Parcelable.Creator<InputBinding> CREATOR = new Parcelable.Creator<InputBinding>() { // from class: android.view.inputmethod.InputBinding.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputBinding createFromParcel(Parcel parcel) {
            return new InputBinding(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputBinding[] newArray(int i) {
            return new InputBinding[i];
        }
    };
    static final String TAG = "InputBinding";
    final InputConnection mConnection;
    final IBinder mConnectionToken;
    final int mPid;
    final int mUid;

    InputBinding(Parcel parcel) {
        this.mConnection = null;
        this.mConnectionToken = parcel.readStrongBinder();
        this.mUid = parcel.readInt();
        this.mPid = parcel.readInt();
    }

    public InputBinding(InputConnection inputConnection, IBinder iBinder, int i, int i2) {
        this.mConnection = inputConnection;
        this.mConnectionToken = iBinder;
        this.mUid = i;
        this.mPid = i2;
    }

    public InputBinding(InputConnection inputConnection, InputBinding inputBinding) {
        this.mConnection = inputConnection;
        this.mConnectionToken = inputBinding.getConnectionToken();
        this.mUid = inputBinding.getUid();
        this.mPid = inputBinding.getPid();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public InputConnection getConnection() {
        return this.mConnection;
    }

    public IBinder getConnectionToken() {
        return this.mConnectionToken;
    }

    public int getPid() {
        return this.mPid;
    }

    public int getUid() {
        return this.mUid;
    }

    public String toString() {
        return "InputBinding{" + this.mConnectionToken + " / uid " + this.mUid + " / pid " + this.mPid + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mConnectionToken);
        parcel.writeInt(this.mUid);
        parcel.writeInt(this.mPid);
    }
}
