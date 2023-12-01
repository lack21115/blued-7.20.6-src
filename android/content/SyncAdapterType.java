package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/content/SyncAdapterType.class */
public class SyncAdapterType implements Parcelable {
    public static final Parcelable.Creator<SyncAdapterType> CREATOR = new Parcelable.Creator<SyncAdapterType>() { // from class: android.content.SyncAdapterType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncAdapterType createFromParcel(Parcel parcel) {
            return new SyncAdapterType(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SyncAdapterType[] newArray(int i) {
            return new SyncAdapterType[i];
        }
    };
    public final String accountType;
    private final boolean allowParallelSyncs;
    public final String authority;
    private final boolean isAlwaysSyncable;
    public final boolean isKey;
    private final String settingsActivity;
    private final boolean supportsUploading;
    private final boolean userVisible;

    public SyncAdapterType(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
    }

    private SyncAdapterType(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the authority must not be empty: " + str);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("the accountType must not be empty: " + str2);
        }
        this.authority = str;
        this.accountType = str2;
        this.userVisible = true;
        this.supportsUploading = true;
        this.isAlwaysSyncable = false;
        this.allowParallelSyncs = false;
        this.settingsActivity = null;
        this.isKey = true;
    }

    public SyncAdapterType(String str, String str2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the authority must not be empty: " + str);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("the accountType must not be empty: " + str2);
        }
        this.authority = str;
        this.accountType = str2;
        this.userVisible = z;
        this.supportsUploading = z2;
        this.isAlwaysSyncable = false;
        this.allowParallelSyncs = false;
        this.settingsActivity = null;
        this.isKey = false;
    }

    public SyncAdapterType(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the authority must not be empty: " + str);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("the accountType must not be empty: " + str2);
        }
        this.authority = str;
        this.accountType = str2;
        this.userVisible = z;
        this.supportsUploading = z2;
        this.isAlwaysSyncable = z3;
        this.allowParallelSyncs = z4;
        this.settingsActivity = str3;
        this.isKey = false;
    }

    public static SyncAdapterType newKey(String str, String str2) {
        return new SyncAdapterType(str, str2);
    }

    public boolean allowParallelSyncs() {
        if (this.isKey) {
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        }
        return this.allowParallelSyncs;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SyncAdapterType) {
            SyncAdapterType syncAdapterType = (SyncAdapterType) obj;
            return this.authority.equals(syncAdapterType.authority) && this.accountType.equals(syncAdapterType.accountType);
        }
        return false;
    }

    public String getSettingsActivity() {
        if (this.isKey) {
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        }
        return this.settingsActivity;
    }

    public int hashCode() {
        return ((this.authority.hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.accountType.hashCode();
    }

    public boolean isAlwaysSyncable() {
        if (this.isKey) {
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        }
        return this.isAlwaysSyncable;
    }

    public boolean isUserVisible() {
        if (this.isKey) {
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        }
        return this.userVisible;
    }

    public boolean supportsUploading() {
        if (this.isKey) {
            throw new IllegalStateException("this method is not allowed to be called when this is a key");
        }
        return this.supportsUploading;
    }

    public String toString() {
        return this.isKey ? "SyncAdapterType Key {name=" + this.authority + ", type=" + this.accountType + "}" : "SyncAdapterType {name=" + this.authority + ", type=" + this.accountType + ", userVisible=" + this.userVisible + ", supportsUploading=" + this.supportsUploading + ", isAlwaysSyncable=" + this.isAlwaysSyncable + ", allowParallelSyncs=" + this.allowParallelSyncs + ", settingsActivity=" + this.settingsActivity + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.isKey) {
            throw new IllegalStateException("keys aren't parcelable");
        }
        parcel.writeString(this.authority);
        parcel.writeString(this.accountType);
        parcel.writeInt(this.userVisible ? 1 : 0);
        parcel.writeInt(this.supportsUploading ? 1 : 0);
        parcel.writeInt(this.isAlwaysSyncable ? 1 : 0);
        parcel.writeInt(this.allowParallelSyncs ? 1 : 0);
        parcel.writeString(this.settingsActivity);
    }
}
