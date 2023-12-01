package android.content.pm;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;
import com.android.internal.util.ArrayUtils;
import com.huawei.hms.ads.fw;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ApplicationInfo.class */
public class ApplicationInfo extends PackageItemInfo implements Parcelable {
    public static final Parcelable.Creator<ApplicationInfo> CREATOR = new Parcelable.Creator<ApplicationInfo>() { // from class: android.content.pm.ApplicationInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApplicationInfo createFromParcel(Parcel parcel) {
            return new ApplicationInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApplicationInfo[] newArray(int i) {
            return new ApplicationInfo[i];
        }
    };
    public static final int FLAG_ALLOW_BACKUP = 32768;
    public static final int FLAG_ALLOW_CLEAR_USER_DATA = 64;
    public static final int FLAG_ALLOW_TASK_REPARENTING = 32;
    public static final int FLAG_CANT_SAVE_STATE = 268435456;
    public static final int FLAG_DEBUGGABLE = 2;
    public static final int FLAG_EXTERNAL_STORAGE = 262144;
    public static final int FLAG_FACTORY_TEST = 16;
    public static final int FLAG_FORWARD_LOCK = 536870912;
    public static final int FLAG_FULL_BACKUP_ONLY = 67108864;
    public static final int FLAG_HAS_CODE = 4;
    public static final int FLAG_HIDDEN = 134217728;
    public static final int FLAG_INSTALLED = 8388608;
    public static final int FLAG_IS_DATA_ONLY = 16777216;
    public static final int FLAG_IS_GAME = 33554432;
    public static final int FLAG_KILL_AFTER_RESTORE = 65536;
    public static final int FLAG_LARGE_HEAP = 1048576;
    public static final int FLAG_MULTIARCH = Integer.MIN_VALUE;
    public static final int FLAG_PERSISTENT = 8;
    public static final int FLAG_PRIVILEGED = 1073741824;
    public static final int FLAG_RESIZEABLE_FOR_SCREENS = 4096;
    public static final int FLAG_RESTORE_ANY_VERSION = 131072;
    public static final int FLAG_STOPPED = 2097152;
    public static final int FLAG_SUPPORTS_LARGE_SCREENS = 2048;
    public static final int FLAG_SUPPORTS_NORMAL_SCREENS = 1024;
    public static final int FLAG_SUPPORTS_RTL = 4194304;
    public static final int FLAG_SUPPORTS_SCREEN_DENSITIES = 8192;
    public static final int FLAG_SUPPORTS_SMALL_SCREENS = 512;
    public static final int FLAG_SUPPORTS_XLARGE_SCREENS = 524288;
    public static final int FLAG_SYSTEM = 1;
    public static final int FLAG_TEST_ONLY = 256;
    public static final int FLAG_UPDATED_SYSTEM_APP = 128;
    public static final int FLAG_VM_SAFE_MODE = 16384;
    public String backupAgentName;
    public String className;
    public int compatibleWidthLimitDp;
    public String dataDir;
    public int descriptionRes;
    public boolean enabled;
    public int enabledSetting;
    public int flags;
    public int installLocation;
    public boolean isThemeable;
    public int largestWidthLimitDp;
    public String manageSpaceActivityName;
    public String nativeLibraryDir;
    public String nativeLibraryRootDir;
    public boolean nativeLibraryRootRequiresIsa;
    public String permission;
    public String primaryCpuAbi;
    public String processName;
    public boolean protect;
    public String publicSourceDir;
    public int requiresSmallestWidthDp;
    public String[] resourceDirs;
    public String scanPublicSourceDir;
    public String scanSourceDir;
    public String secondaryCpuAbi;
    public String secondaryNativeLibraryDir;
    public String seinfo;
    public String[] sharedLibraryFiles;
    public String sourceDir;
    public String[] splitPublicSourceDirs;
    public String[] splitSourceDirs;
    public int targetSdkVersion;
    public String taskAffinity;
    public int theme;
    public int uiOptions;
    public int uid;
    public int versionCode;

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/ApplicationInfo$DisplayNameComparator.class */
    public static class DisplayNameComparator implements Comparator<ApplicationInfo> {
        private PackageManager mPM;
        private final Collator sCollator = Collator.getInstance();

        public DisplayNameComparator(PackageManager packageManager) {
            this.mPM = packageManager;
        }

        @Override // java.util.Comparator
        public final int compare(ApplicationInfo applicationInfo, ApplicationInfo applicationInfo2) {
            CharSequence applicationLabel = this.mPM.getApplicationLabel(applicationInfo);
            String str = applicationLabel;
            if (applicationLabel == null) {
                str = applicationInfo.packageName;
            }
            CharSequence applicationLabel2 = this.mPM.getApplicationLabel(applicationInfo2);
            String str2 = applicationLabel2;
            if (applicationLabel2 == null) {
                str2 = applicationInfo2.packageName;
            }
            return this.sCollator.compare(str.toString(), str2.toString());
        }
    }

    public ApplicationInfo() {
        this.uiOptions = 0;
        this.flags = 0;
        this.requiresSmallestWidthDp = 0;
        this.compatibleWidthLimitDp = 0;
        this.largestWidthLimitDp = 0;
        this.enabled = true;
        this.enabledSetting = 0;
        this.installLocation = -1;
        this.isThemeable = false;
        this.protect = false;
    }

    public ApplicationInfo(ApplicationInfo applicationInfo) {
        super(applicationInfo);
        this.uiOptions = 0;
        this.flags = 0;
        this.requiresSmallestWidthDp = 0;
        this.compatibleWidthLimitDp = 0;
        this.largestWidthLimitDp = 0;
        this.enabled = true;
        this.enabledSetting = 0;
        this.installLocation = -1;
        this.isThemeable = false;
        this.protect = false;
        this.taskAffinity = applicationInfo.taskAffinity;
        this.permission = applicationInfo.permission;
        this.processName = applicationInfo.processName;
        this.className = applicationInfo.className;
        this.theme = applicationInfo.theme;
        this.flags = applicationInfo.flags;
        this.requiresSmallestWidthDp = applicationInfo.requiresSmallestWidthDp;
        this.compatibleWidthLimitDp = applicationInfo.compatibleWidthLimitDp;
        this.largestWidthLimitDp = applicationInfo.largestWidthLimitDp;
        this.scanSourceDir = applicationInfo.scanSourceDir;
        this.scanPublicSourceDir = applicationInfo.scanPublicSourceDir;
        this.sourceDir = applicationInfo.sourceDir;
        this.publicSourceDir = applicationInfo.publicSourceDir;
        this.splitSourceDirs = applicationInfo.splitSourceDirs;
        this.splitPublicSourceDirs = applicationInfo.splitPublicSourceDirs;
        this.nativeLibraryDir = applicationInfo.nativeLibraryDir;
        this.secondaryNativeLibraryDir = applicationInfo.secondaryNativeLibraryDir;
        this.nativeLibraryRootDir = applicationInfo.nativeLibraryRootDir;
        this.nativeLibraryRootRequiresIsa = applicationInfo.nativeLibraryRootRequiresIsa;
        this.primaryCpuAbi = applicationInfo.primaryCpuAbi;
        this.secondaryCpuAbi = applicationInfo.secondaryCpuAbi;
        this.resourceDirs = applicationInfo.resourceDirs;
        this.seinfo = applicationInfo.seinfo;
        this.sharedLibraryFiles = applicationInfo.sharedLibraryFiles;
        this.dataDir = applicationInfo.dataDir;
        this.uid = applicationInfo.uid;
        this.targetSdkVersion = applicationInfo.targetSdkVersion;
        this.versionCode = applicationInfo.versionCode;
        this.enabled = applicationInfo.enabled;
        this.enabledSetting = applicationInfo.enabledSetting;
        this.installLocation = applicationInfo.installLocation;
        this.manageSpaceActivityName = applicationInfo.manageSpaceActivityName;
        this.descriptionRes = applicationInfo.descriptionRes;
        this.uiOptions = applicationInfo.uiOptions;
        this.backupAgentName = applicationInfo.backupAgentName;
        this.protect = applicationInfo.protect;
        this.isThemeable = applicationInfo.isThemeable;
    }

    private ApplicationInfo(Parcel parcel) {
        super(parcel);
        this.uiOptions = 0;
        this.flags = 0;
        this.requiresSmallestWidthDp = 0;
        this.compatibleWidthLimitDp = 0;
        this.largestWidthLimitDp = 0;
        this.enabled = true;
        this.enabledSetting = 0;
        this.installLocation = -1;
        this.isThemeable = false;
        this.protect = false;
        this.taskAffinity = parcel.readString();
        this.permission = parcel.readString();
        this.processName = parcel.readString();
        this.className = parcel.readString();
        this.theme = parcel.readInt();
        this.flags = parcel.readInt();
        this.requiresSmallestWidthDp = parcel.readInt();
        this.compatibleWidthLimitDp = parcel.readInt();
        this.largestWidthLimitDp = parcel.readInt();
        this.scanSourceDir = parcel.readString();
        this.scanPublicSourceDir = parcel.readString();
        this.sourceDir = parcel.readString();
        this.publicSourceDir = parcel.readString();
        this.splitSourceDirs = parcel.readStringArray();
        this.splitPublicSourceDirs = parcel.readStringArray();
        this.nativeLibraryDir = parcel.readString();
        this.secondaryNativeLibraryDir = parcel.readString();
        this.nativeLibraryRootDir = parcel.readString();
        this.nativeLibraryRootRequiresIsa = parcel.readInt() != 0;
        this.primaryCpuAbi = parcel.readString();
        this.secondaryCpuAbi = parcel.readString();
        this.resourceDirs = parcel.readStringArray();
        this.seinfo = parcel.readString();
        this.sharedLibraryFiles = parcel.readStringArray();
        this.dataDir = parcel.readString();
        this.uid = parcel.readInt();
        this.targetSdkVersion = parcel.readInt();
        this.versionCode = parcel.readInt();
        this.enabled = parcel.readInt() != 0;
        this.enabledSetting = parcel.readInt();
        this.installLocation = parcel.readInt();
        this.manageSpaceActivityName = parcel.readString();
        this.backupAgentName = parcel.readString();
        this.descriptionRes = parcel.readInt();
        this.uiOptions = parcel.readInt();
        this.protect = parcel.readInt() != 0;
        this.isThemeable = parcel.readInt() != 0;
    }

    private boolean isPackageUnavailable(PackageManager packageManager) {
        try {
            return packageManager.getPackageInfo(this.packageName, 0) == null;
        } catch (PackageManager.NameNotFoundException e) {
            return true;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void disableCompatibilityMode() {
        this.flags |= 540160;
    }

    public void dump(Printer printer, String str) {
        super.dumpFront(printer, str);
        if (this.className != null) {
            printer.println(str + "className=" + this.className);
        }
        if (this.permission != null) {
            printer.println(str + "permission=" + this.permission);
        }
        printer.println(str + "processName=" + this.processName);
        printer.println(str + "taskAffinity=" + this.taskAffinity);
        printer.println(str + "uid=" + this.uid + " flags=0x" + Integer.toHexString(this.flags) + " theme=0x" + Integer.toHexString(this.theme));
        printer.println(str + "requiresSmallestWidthDp=" + this.requiresSmallestWidthDp + " compatibleWidthLimitDp=" + this.compatibleWidthLimitDp + " largestWidthLimitDp=" + this.largestWidthLimitDp);
        printer.println(str + "sourceDir=" + this.sourceDir);
        if (!Objects.equals(this.sourceDir, this.publicSourceDir)) {
            printer.println(str + "publicSourceDir=" + this.publicSourceDir);
        }
        if (!ArrayUtils.isEmpty(this.splitSourceDirs)) {
            printer.println(str + "splitSourceDirs=" + Arrays.toString(this.splitSourceDirs));
        }
        if (!ArrayUtils.isEmpty(this.splitPublicSourceDirs) && !Arrays.equals(this.splitSourceDirs, this.splitPublicSourceDirs)) {
            printer.println(str + "splitPublicSourceDirs=" + Arrays.toString(this.splitPublicSourceDirs));
        }
        if (this.resourceDirs != null) {
            printer.println(str + "resourceDirs=" + this.resourceDirs);
        }
        if (this.seinfo != null) {
            printer.println(str + "seinfo=" + this.seinfo);
        }
        printer.println(str + "dataDir=" + this.dataDir);
        if (this.sharedLibraryFiles != null) {
            printer.println(str + "sharedLibraryFiles=" + this.sharedLibraryFiles);
        }
        printer.println(str + "enabled=" + this.enabled + " targetSdkVersion=" + this.targetSdkVersion + " versionCode=" + this.versionCode);
        if (this.manageSpaceActivityName != null) {
            printer.println(str + "manageSpaceActivityName=" + this.manageSpaceActivityName);
        }
        if (this.descriptionRes != 0) {
            printer.println(str + "description=0x" + Integer.toHexString(this.descriptionRes));
        }
        if (this.uiOptions != 0) {
            printer.println(str + "uiOptions=0x" + Integer.toHexString(this.uiOptions));
        }
        printer.println(str + "supportsRtl=" + (hasRtlSupport() ? fw.Code : "false"));
        super.dumpBack(printer, str);
    }

    @Override // android.content.pm.PackageItemInfo
    protected ApplicationInfo getApplicationInfo() {
        return this;
    }

    public String getBaseCodePath() {
        return this.sourceDir;
    }

    public String getBaseResourcePath() {
        return this.publicSourceDir;
    }

    public String getCodePath() {
        return this.scanSourceDir;
    }

    public String getResourcePath() {
        return this.scanPublicSourceDir;
    }

    public String[] getSplitCodePaths() {
        return this.splitSourceDirs;
    }

    public String[] getSplitResourcePaths() {
        return this.splitSourceDirs;
    }

    public boolean hasRtlSupport() {
        return (this.flags & 4194304) == 4194304;
    }

    @Override // android.content.pm.PackageItemInfo
    public Drawable loadDefaultIcon(PackageManager packageManager) {
        return ((this.flags & 262144) == 0 || !isPackageUnavailable(packageManager)) ? packageManager.getDefaultActivityIcon() : Resources.getSystem().getDrawable(17303241);
    }

    public CharSequence loadDescription(PackageManager packageManager) {
        CharSequence text;
        if (this.descriptionRes == 0 || (text = packageManager.getText(this.packageName, this.descriptionRes, this)) == null) {
            return null;
        }
        return text;
    }

    public void setBaseCodePath(String str) {
        this.sourceDir = str;
    }

    public void setBaseResourcePath(String str) {
        this.publicSourceDir = str;
    }

    public void setCodePath(String str) {
        this.scanSourceDir = str;
    }

    public void setResourcePath(String str) {
        this.scanPublicSourceDir = str;
    }

    public void setSplitCodePaths(String[] strArr) {
        this.splitSourceDirs = strArr;
    }

    public void setSplitResourcePaths(String[] strArr) {
        this.splitPublicSourceDirs = strArr;
    }

    public String toString() {
        return "ApplicationInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
    }

    @Override // android.content.pm.PackageItemInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.taskAffinity);
        parcel.writeString(this.permission);
        parcel.writeString(this.processName);
        parcel.writeString(this.className);
        parcel.writeInt(this.theme);
        parcel.writeInt(this.flags);
        parcel.writeInt(this.requiresSmallestWidthDp);
        parcel.writeInt(this.compatibleWidthLimitDp);
        parcel.writeInt(this.largestWidthLimitDp);
        parcel.writeString(this.scanSourceDir);
        parcel.writeString(this.scanPublicSourceDir);
        parcel.writeString(this.sourceDir);
        parcel.writeString(this.publicSourceDir);
        parcel.writeStringArray(this.splitSourceDirs);
        parcel.writeStringArray(this.splitPublicSourceDirs);
        parcel.writeString(this.nativeLibraryDir);
        parcel.writeString(this.secondaryNativeLibraryDir);
        parcel.writeString(this.nativeLibraryRootDir);
        parcel.writeInt(this.nativeLibraryRootRequiresIsa ? 1 : 0);
        parcel.writeString(this.primaryCpuAbi);
        parcel.writeString(this.secondaryCpuAbi);
        parcel.writeStringArray(this.resourceDirs);
        parcel.writeString(this.seinfo);
        parcel.writeStringArray(this.sharedLibraryFiles);
        parcel.writeString(this.dataDir);
        parcel.writeInt(this.uid);
        parcel.writeInt(this.targetSdkVersion);
        parcel.writeInt(this.versionCode);
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeInt(this.enabledSetting);
        parcel.writeInt(this.installLocation);
        parcel.writeString(this.manageSpaceActivityName);
        parcel.writeString(this.backupAgentName);
        parcel.writeInt(this.descriptionRes);
        parcel.writeInt(this.uiOptions);
        parcel.writeInt(this.protect ? 1 : 0);
        parcel.writeInt(this.isThemeable ? 1 : 0);
    }
}
