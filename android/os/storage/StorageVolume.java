package android.os.storage;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import com.android.internal.util.IndentingPrintWriter;
import java.io.CharArrayWriter;
import java.io.File;

/* loaded from: source-9557208-dex2jar.jar:android/os/storage/StorageVolume.class */
public class StorageVolume implements Parcelable {
    public static final Parcelable.Creator<StorageVolume> CREATOR = new Parcelable.Creator<StorageVolume>() { // from class: android.os.storage.StorageVolume.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StorageVolume createFromParcel(Parcel parcel) {
            return new StorageVolume(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StorageVolume[] newArray(int i) {
            return new StorageVolume[i];
        }
    };
    public static final String EXTRA_STORAGE_VOLUME = "storage_volume";
    private final boolean mAllowMassStorage;
    private final boolean mAllowMtp;
    private final int mDescriptionId;
    private final boolean mEmulated;
    private boolean mIsFormatting;
    private final long mMaxFileSize;
    private final int mMtpReserveSpace;
    private final UserHandle mOwner;
    private final File mPath;
    private final boolean mPrimary;
    private final boolean mRemovable;
    private String mState;
    private int mStorageId;
    private String mUserLabel;
    private String mUuid;

    private StorageVolume(Parcel parcel) {
        this.mStorageId = parcel.readInt();
        this.mPath = new File(parcel.readString());
        this.mDescriptionId = parcel.readInt();
        this.mPrimary = parcel.readInt() != 0;
        this.mRemovable = parcel.readInt() != 0;
        this.mEmulated = parcel.readInt() != 0;
        this.mMtpReserveSpace = parcel.readInt();
        this.mAllowMassStorage = parcel.readInt() != 0;
        this.mMaxFileSize = parcel.readLong();
        this.mOwner = (UserHandle) parcel.readParcelable(null);
        this.mUuid = parcel.readString();
        this.mUserLabel = parcel.readString();
        this.mState = parcel.readString();
        this.mAllowMtp = parcel.readInt() != 0;
    }

    public StorageVolume(File file, int i, boolean z, boolean z2, boolean z3, int i2, boolean z4, long j, UserHandle userHandle, boolean z5) {
        this.mPath = file;
        this.mDescriptionId = i;
        this.mPrimary = z;
        this.mRemovable = z2;
        this.mEmulated = z3;
        this.mMtpReserveSpace = i2;
        this.mAllowMassStorage = z4;
        this.mMaxFileSize = j;
        this.mOwner = userHandle;
        this.mAllowMtp = z5;
    }

    public static StorageVolume fromTemplate(StorageVolume storageVolume, File file, UserHandle userHandle) {
        return new StorageVolume(file, storageVolume.mDescriptionId, storageVolume.mPrimary, storageVolume.mRemovable, storageVolume.mEmulated, storageVolume.mMtpReserveSpace, storageVolume.mAllowMassStorage, storageVolume.mMaxFileSize, userHandle, storageVolume.mAllowMtp);
    }

    public boolean allowMassStorage() {
        return this.mAllowMassStorage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(IndentingPrintWriter indentingPrintWriter) {
        indentingPrintWriter.println("StorageVolume:");
        indentingPrintWriter.increaseIndent();
        indentingPrintWriter.printPair("mStorageId", Integer.valueOf(this.mStorageId));
        indentingPrintWriter.printPair("mPath", this.mPath);
        indentingPrintWriter.printPair("mDescriptionId", Integer.valueOf(this.mDescriptionId));
        indentingPrintWriter.printPair("mPrimary", Boolean.valueOf(this.mPrimary));
        indentingPrintWriter.printPair("mRemovable", Boolean.valueOf(this.mRemovable));
        indentingPrintWriter.printPair("mEmulated", Boolean.valueOf(this.mEmulated));
        indentingPrintWriter.printPair("mMtpReserveSpace", Integer.valueOf(this.mMtpReserveSpace));
        indentingPrintWriter.printPair("mAllowMassStorage", Boolean.valueOf(this.mAllowMassStorage));
        indentingPrintWriter.printPair("mMaxFileSize", Long.valueOf(this.mMaxFileSize));
        indentingPrintWriter.printPair("mOwner", this.mOwner);
        indentingPrintWriter.printPair("mUuid", this.mUuid);
        indentingPrintWriter.printPair("mUserLabel", this.mUserLabel);
        indentingPrintWriter.printPair("mState", this.mState);
        indentingPrintWriter.printPair("mAllowMtp", Boolean.valueOf(this.mAllowMtp));
        indentingPrintWriter.decreaseIndent();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StorageVolume) || this.mPath == null) {
            return false;
        }
        return this.mPath.equals(((StorageVolume) obj).mPath);
    }

    public String getDescription(Context context) {
        return context.getResources().getString(this.mDescriptionId);
    }

    public int getDescriptionId() {
        return this.mDescriptionId;
    }

    public boolean getIsFormatting() {
        return this.mIsFormatting;
    }

    public long getMaxFileSize() {
        return this.mMaxFileSize;
    }

    public int getMtpReserveSpace() {
        return this.mMtpReserveSpace;
    }

    public UserHandle getOwner() {
        return this.mOwner;
    }

    public String getPath() {
        return this.mPath.toString();
    }

    public File getPathFile() {
        return this.mPath;
    }

    public String getState() {
        return this.mState;
    }

    public int getStorageId() {
        return this.mStorageId;
    }

    public String getUserLabel() {
        return this.mUserLabel;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public int getVolumeId() {
        String str = this.mUuid;
        if (str == null) {
            return -1;
        }
        String replace = str.replace("-", "");
        String str2 = replace;
        if (replace.length() > 8) {
            str2 = replace.substring(0, 8);
        }
        try {
            return (int) Long.parseLong(str2, 16);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int hashCode() {
        return this.mPath.hashCode();
    }

    public boolean isEmulated() {
        return this.mEmulated;
    }

    public boolean isMtpEnabled() {
        return this.mAllowMtp;
    }

    public boolean isPrimary() {
        return this.mPrimary;
    }

    public boolean isRemovable() {
        return this.mRemovable;
    }

    public void setIsFormatting(boolean z) {
        this.mIsFormatting = z;
    }

    public void setState(String str) {
        this.mState = str;
    }

    public void setStorageId(int i) {
        this.mStorageId = ((i + 1) << 16) + 1;
    }

    public void setUserLabel(String str) {
        this.mUserLabel = str;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }

    public String toString() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        dump(new IndentingPrintWriter(charArrayWriter, "    ", 80));
        return charArrayWriter.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mStorageId);
        parcel.writeString(this.mPath.toString());
        parcel.writeInt(this.mDescriptionId);
        parcel.writeInt(this.mPrimary ? 1 : 0);
        parcel.writeInt(this.mRemovable ? 1 : 0);
        parcel.writeInt(this.mEmulated ? 1 : 0);
        parcel.writeInt(this.mMtpReserveSpace);
        parcel.writeInt(this.mAllowMassStorage ? 1 : 0);
        parcel.writeLong(this.mMaxFileSize);
        parcel.writeParcelable(this.mOwner, i);
        parcel.writeString(this.mUuid);
        parcel.writeString(this.mUserLabel);
        parcel.writeString(this.mState);
        parcel.writeInt(this.mAllowMtp ? 1 : 0);
    }
}
