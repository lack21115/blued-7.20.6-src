package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.tencent.open.GameAppOperation;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PermissionInfo.class */
public class PermissionInfo extends PackageItemInfo implements Parcelable {
    public static final Parcelable.Creator<PermissionInfo> CREATOR = new Parcelable.Creator<PermissionInfo>() { // from class: android.content.pm.PermissionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PermissionInfo createFromParcel(Parcel parcel) {
            return new PermissionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PermissionInfo[] newArray(int i) {
            return new PermissionInfo[i];
        }
    };
    public static final int FLAG_COSTS_MONEY = 1;
    public static final int PROTECTION_DANGEROUS = 1;
    public static final int PROTECTION_FLAG_APPOP = 64;
    public static final int PROTECTION_FLAG_DEVELOPMENT = 32;
    public static final int PROTECTION_FLAG_SYSTEM = 16;
    public static final int PROTECTION_MASK_BASE = 15;
    public static final int PROTECTION_MASK_FLAGS = 240;
    public static final int PROTECTION_NORMAL = 0;
    public static final int PROTECTION_SIGNATURE = 2;
    public static final int PROTECTION_SIGNATURE_OR_SYSTEM = 3;
    public boolean allowViaWhitelist;
    public int descriptionRes;
    public int flags;
    public String group;
    public CharSequence nonLocalizedDescription;
    public int protectionLevel;

    public PermissionInfo() {
    }

    public PermissionInfo(PermissionInfo permissionInfo) {
        super(permissionInfo);
        this.protectionLevel = permissionInfo.protectionLevel;
        this.flags = permissionInfo.flags;
        this.group = permissionInfo.group;
        this.descriptionRes = permissionInfo.descriptionRes;
        this.nonLocalizedDescription = permissionInfo.nonLocalizedDescription;
        this.allowViaWhitelist = permissionInfo.allowViaWhitelist;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private PermissionInfo(Parcel parcel) {
        super(parcel);
        boolean z = true;
        this.protectionLevel = parcel.readInt();
        this.flags = parcel.readInt();
        this.group = parcel.readString();
        this.descriptionRes = parcel.readInt();
        this.allowViaWhitelist = parcel.readInt() != 1 ? false : z;
        this.nonLocalizedDescription = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public static int fixProtectionLevel(int i) {
        int i2 = i;
        if (i == 3) {
            i2 = 18;
        }
        return i2;
    }

    public static String protectionToString(int i) {
        String str = "????";
        switch (i & 15) {
            case 0:
                str = "normal";
                break;
            case 1:
                str = "dangerous";
                break;
            case 2:
                str = GameAppOperation.GAME_SIGNATURE;
                break;
            case 3:
                str = "signatureOrSystem";
                break;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            str2 = str + "|system";
        }
        String str3 = str2;
        if ((i & 32) != 0) {
            str3 = str2 + "|development";
        }
        String str4 = str3;
        if ((i & 64) != 0) {
            str4 = str3 + "|appop";
        }
        return str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CharSequence loadDescription(PackageManager packageManager) {
        CharSequence charSequence;
        if (this.nonLocalizedDescription != null) {
            charSequence = this.nonLocalizedDescription;
        } else if (this.descriptionRes == 0) {
            return null;
        } else {
            CharSequence text = packageManager.getText(this.packageName, this.descriptionRes, null);
            charSequence = text;
            if (text == null) {
                return null;
            }
        }
        return charSequence;
    }

    public String toString() {
        return "PermissionInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + i.d;
    }

    @Override // android.content.pm.PackageItemInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.protectionLevel);
        parcel.writeInt(this.flags);
        parcel.writeString(this.group);
        parcel.writeInt(this.descriptionRes);
        parcel.writeInt(this.allowViaWhitelist ? 1 : 0);
        TextUtils.writeToParcel(this.nonLocalizedDescription, parcel, i);
    }
}
