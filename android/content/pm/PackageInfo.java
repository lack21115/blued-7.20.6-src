package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageInfo.class */
public class PackageInfo implements Parcelable {
    public static final Parcelable.Creator<PackageInfo> CREATOR = new Parcelable.Creator<PackageInfo>() { // from class: android.content.pm.PackageInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageInfo createFromParcel(Parcel parcel) {
            return new PackageInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageInfo[] newArray(int i) {
            return new PackageInfo[i];
        }
    };
    public static final int INSTALL_LOCATION_AUTO = 0;
    public static final int INSTALL_LOCATION_INTERNAL_ONLY = 1;
    public static final int INSTALL_LOCATION_PREFER_EXTERNAL = 2;
    public static final int INSTALL_LOCATION_UNSPECIFIED = -1;
    public static final int REQUESTED_PERMISSION_GRANTED = 2;
    public static final int REQUESTED_PERMISSION_REQUIRED = 1;
    public ActivityInfo[] activities;
    public ApplicationInfo applicationInfo;
    public int baseRevisionCode;
    public ConfigurationInfo[] configPreferences;
    public boolean coreApp;
    public FeatureGroupInfo[] featureGroups;
    public long firstInstallTime;
    public int[] gids;
    public boolean hasIconPack;
    public int installLocation;
    public InstrumentationInfo[] instrumentation;
    public boolean isLegacyIconPackApk;
    public boolean isThemeApk;
    public long lastUpdateTime;
    public ArrayList<String> mOverlayTargets;
    public String overlayTarget;
    public String packageName;
    public PermissionInfo[] permissions;
    public ProviderInfo[] providers;
    public ActivityInfo[] receivers;
    public FeatureInfo[] reqFeatures;
    public String[] requestedPermissions;
    public int[] requestedPermissionsFlags;
    public String requiredAccountType;
    public boolean requiredForAllUsers;
    public String restrictedAccountType;
    public ServiceInfo[] services;
    public String sharedUserId;
    public int sharedUserLabel;
    public Signature[] signatures;
    public String[] splitNames;
    public int[] splitRevisionCodes;
    public ThemeInfo themeInfo;
    public int versionCode;
    public String versionName;

    public PackageInfo() {
        this.installLocation = 1;
        this.isThemeApk = false;
        this.hasIconPack = false;
        this.isLegacyIconPackApk = false;
    }

    private PackageInfo(Parcel parcel) {
        this.installLocation = 1;
        this.isThemeApk = false;
        this.hasIconPack = false;
        this.isLegacyIconPackApk = false;
        this.packageName = parcel.readString();
        this.splitNames = parcel.createStringArray();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.baseRevisionCode = parcel.readInt();
        this.splitRevisionCodes = parcel.createIntArray();
        this.sharedUserId = parcel.readString();
        this.sharedUserLabel = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.applicationInfo = ApplicationInfo.CREATOR.createFromParcel(parcel);
        }
        this.firstInstallTime = parcel.readLong();
        this.lastUpdateTime = parcel.readLong();
        this.gids = parcel.createIntArray();
        this.activities = (ActivityInfo[]) parcel.createTypedArray(ActivityInfo.CREATOR);
        this.receivers = (ActivityInfo[]) parcel.createTypedArray(ActivityInfo.CREATOR);
        this.services = (ServiceInfo[]) parcel.createTypedArray(ServiceInfo.CREATOR);
        this.providers = (ProviderInfo[]) parcel.createTypedArray(ProviderInfo.CREATOR);
        this.instrumentation = (InstrumentationInfo[]) parcel.createTypedArray(InstrumentationInfo.CREATOR);
        this.permissions = (PermissionInfo[]) parcel.createTypedArray(PermissionInfo.CREATOR);
        this.requestedPermissions = parcel.createStringArray();
        this.requestedPermissionsFlags = parcel.createIntArray();
        this.signatures = (Signature[]) parcel.createTypedArray(Signature.CREATOR);
        this.configPreferences = (ConfigurationInfo[]) parcel.createTypedArray(ConfigurationInfo.CREATOR);
        this.reqFeatures = (FeatureInfo[]) parcel.createTypedArray(FeatureInfo.CREATOR);
        this.featureGroups = (FeatureGroupInfo[]) parcel.createTypedArray(FeatureGroupInfo.CREATOR);
        this.installLocation = parcel.readInt();
        this.coreApp = parcel.readInt() != 0;
        this.requiredForAllUsers = parcel.readInt() != 0;
        this.restrictedAccountType = parcel.readString();
        this.requiredAccountType = parcel.readString();
        this.overlayTarget = parcel.readString();
        this.isThemeApk = parcel.readInt() != 0;
        this.mOverlayTargets = parcel.createStringArrayList();
        this.themeInfo = (ThemeInfo) parcel.readParcelable(null);
        this.hasIconPack = parcel.readInt() == 1;
        this.isLegacyIconPackApk = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PackageInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeStringArray(this.splitNames);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeInt(this.baseRevisionCode);
        parcel.writeIntArray(this.splitRevisionCodes);
        parcel.writeString(this.sharedUserId);
        parcel.writeInt(this.sharedUserLabel);
        if (this.applicationInfo != null) {
            parcel.writeInt(1);
            this.applicationInfo.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeLong(this.firstInstallTime);
        parcel.writeLong(this.lastUpdateTime);
        parcel.writeIntArray(this.gids);
        parcel.writeTypedArray(this.activities, i);
        parcel.writeTypedArray(this.receivers, i);
        parcel.writeTypedArray(this.services, i);
        parcel.writeTypedArray(this.providers, i);
        parcel.writeTypedArray(this.instrumentation, i);
        parcel.writeTypedArray(this.permissions, i);
        parcel.writeStringArray(this.requestedPermissions);
        parcel.writeIntArray(this.requestedPermissionsFlags);
        parcel.writeTypedArray(this.signatures, i);
        parcel.writeTypedArray(this.configPreferences, i);
        parcel.writeTypedArray(this.reqFeatures, i);
        parcel.writeTypedArray(this.featureGroups, i);
        parcel.writeInt(this.installLocation);
        parcel.writeInt(this.coreApp ? 1 : 0);
        parcel.writeInt(this.requiredForAllUsers ? 1 : 0);
        parcel.writeString(this.restrictedAccountType);
        parcel.writeString(this.requiredAccountType);
        parcel.writeString(this.overlayTarget);
        parcel.writeInt(this.isThemeApk ? 1 : 0);
        parcel.writeStringList(this.mOverlayTargets);
        parcel.writeParcelable(this.themeInfo, i);
        parcel.writeInt(this.hasIconPack ? 1 : 0);
        parcel.writeInt(this.isLegacyIconPackApk ? 1 : 0);
    }
}
