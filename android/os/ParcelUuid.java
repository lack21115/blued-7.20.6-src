package android.os;

import android.os.Parcelable;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/os/ParcelUuid.class */
public final class ParcelUuid implements Parcelable {
    public static final Parcelable.Creator<ParcelUuid> CREATOR = new Parcelable.Creator<ParcelUuid>() { // from class: android.os.ParcelUuid.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelUuid createFromParcel(Parcel parcel) {
            return new ParcelUuid(new UUID(parcel.readLong(), parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelUuid[] newArray(int i) {
            return new ParcelUuid[i];
        }
    };
    private final UUID mUuid;

    public ParcelUuid(UUID uuid) {
        this.mUuid = uuid;
    }

    public static ParcelUuid fromString(String str) {
        return new ParcelUuid(UUID.fromString(str));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParcelUuid) {
            return this.mUuid.equals(((ParcelUuid) obj).mUuid);
        }
        return false;
    }

    public UUID getUuid() {
        return this.mUuid;
    }

    public int hashCode() {
        return this.mUuid.hashCode();
    }

    public String toString() {
        return this.mUuid.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mUuid.getMostSignificantBits());
        parcel.writeLong(this.mUuid.getLeastSignificantBits());
    }
}
