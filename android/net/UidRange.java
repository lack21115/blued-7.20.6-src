package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-9557208-dex2jar.jar:android/net/UidRange.class */
public final class UidRange implements Parcelable {
    public static final Parcelable.Creator<UidRange> CREATOR = new Parcelable.Creator<UidRange>() { // from class: android.net.UidRange.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UidRange createFromParcel(Parcel parcel) {
            return new UidRange(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UidRange[] newArray(int i) {
            return new UidRange[i];
        }
    };
    public final int start;
    public final int stop;

    public UidRange(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid start UID.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Invalid stop UID.");
        }
        if (i > i2) {
            throw new IllegalArgumentException("Invalid UID range.");
        }
        this.start = i;
        this.stop = i2;
    }

    public static UidRange createForUser(int i) {
        return new UidRange(i * 100000, ((i + 1) * 100000) - 1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UidRange) {
            UidRange uidRange = (UidRange) obj;
            return this.start == uidRange.start && this.stop == uidRange.stop;
        }
        return false;
    }

    public int getStartUser() {
        return this.start / 100000;
    }

    public int hashCode() {
        return ((this.start + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.stop;
    }

    public String toString() {
        return this.start + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.stop;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.start);
        parcel.writeInt(this.stop);
    }
}
