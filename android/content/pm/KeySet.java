package android.content.pm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/KeySet.class */
public class KeySet implements Parcelable {
    public static final Parcelable.Creator<KeySet> CREATOR = new Parcelable.Creator<KeySet>() { // from class: android.content.pm.KeySet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeySet createFromParcel(Parcel parcel) {
            return KeySet.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeySet[] newArray(int i) {
            return new KeySet[i];
        }
    };
    private IBinder token;

    public KeySet(IBinder iBinder) {
        if (iBinder == null) {
            throw new NullPointerException("null value for KeySet IBinder token");
        }
        this.token = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeySet readFromParcel(Parcel parcel) {
        return new KeySet(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof KeySet) {
            z = false;
            if (this.token == ((KeySet) obj).token) {
                z = true;
            }
        }
        return z;
    }

    public IBinder getToken() {
        return this.token;
    }

    public int hashCode() {
        return this.token.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.token);
    }
}
