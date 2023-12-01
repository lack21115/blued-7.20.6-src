package android.content;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/content/UriPermission.class */
public final class UriPermission implements Parcelable {
    public static final Parcelable.Creator<UriPermission> CREATOR = new Parcelable.Creator<UriPermission>() { // from class: android.content.UriPermission.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UriPermission createFromParcel(Parcel parcel) {
            return new UriPermission(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UriPermission[] newArray(int i) {
            return new UriPermission[i];
        }
    };
    public static final long INVALID_TIME = Long.MIN_VALUE;
    private final int mModeFlags;
    private final long mPersistedTime;
    private final Uri mUri;

    public UriPermission(Uri uri, int i, long j) {
        this.mUri = uri;
        this.mModeFlags = i;
        this.mPersistedTime = j;
    }

    public UriPermission(Parcel parcel) {
        this.mUri = (Uri) parcel.readParcelable(null);
        this.mModeFlags = parcel.readInt();
        this.mPersistedTime = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getPersistedTime() {
        return this.mPersistedTime;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isReadPermission() {
        return (this.mModeFlags & 1) != 0;
    }

    public boolean isWritePermission() {
        return (this.mModeFlags & 2) != 0;
    }

    public String toString() {
        return "UriPermission {uri=" + this.mUri + ", modeFlags=" + this.mModeFlags + ", persistedTime=" + this.mPersistedTime + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mUri, i);
        parcel.writeInt(this.mModeFlags);
        parcel.writeLong(this.mPersistedTime);
    }
}
