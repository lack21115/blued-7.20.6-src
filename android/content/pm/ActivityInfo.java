package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ActivityInfo.class */
public class ActivityInfo extends ComponentInfo implements Parcelable {
    public static final int CONFIG_DENSITY = 4096;
    public static final int CONFIG_FONT_SCALE = 1073741824;
    public static final int CONFIG_KEYBOARD = 16;
    public static final int CONFIG_KEYBOARD_HIDDEN = 32;
    public static final int CONFIG_LAYOUT_DIRECTION = 8192;
    public static final int CONFIG_LOCALE = 4;
    public static final int CONFIG_MCC = 1;
    public static final int CONFIG_MNC = 2;
    public static final int CONFIG_NAVIGATION = 64;
    public static final int CONFIG_ORIENTATION = 128;
    public static final int CONFIG_SCREEN_LAYOUT = 256;
    public static final int CONFIG_SCREEN_SIZE = 1024;
    public static final int CONFIG_SMALLEST_SCREEN_SIZE = 2048;
    public static final int CONFIG_THEME_FONT = 2097152;
    public static final int CONFIG_THEME_RESOURCE = 1048576;
    public static final int CONFIG_TOUCHSCREEN = 8;
    public static final int CONFIG_UI_MODE = 512;
    public static final int DOCUMENT_LAUNCH_ALWAYS = 2;
    public static final int DOCUMENT_LAUNCH_INTO_EXISTING = 1;
    public static final int DOCUMENT_LAUNCH_NEVER = 3;
    public static final int DOCUMENT_LAUNCH_NONE = 0;
    public static final int FLAG_ALLOW_EMBEDDED = Integer.MIN_VALUE;
    public static final int FLAG_ALLOW_TASK_REPARENTING = 64;
    public static final int FLAG_ALWAYS_RETAIN_TASK_STATE = 8;
    public static final int FLAG_AUTO_REMOVE_FROM_RECENTS = 8192;
    public static final int FLAG_CLEAR_TASK_ON_LAUNCH = 4;
    public static final int FLAG_EXCLUDE_FROM_RECENTS = 32;
    public static final int FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS = 256;
    public static final int FLAG_FINISH_ON_TASK_LAUNCH = 2;
    public static final int FLAG_HARDWARE_ACCELERATED = 512;
    public static final int FLAG_IMMERSIVE = 2048;
    public static final int FLAG_MULTIPROCESS = 1;
    public static final int FLAG_NO_HISTORY = 128;
    public static final int FLAG_PRIMARY_USER_ONLY = 536870912;
    public static final int FLAG_RELINQUISH_TASK_IDENTITY = 4096;
    public static final int FLAG_RESUME_WHILE_PAUSING = 16384;
    public static final int FLAG_SHOW_ON_LOCK_SCREEN = 1024;
    public static final int FLAG_SINGLE_USER = 1073741824;
    public static final int FLAG_STATE_NOT_NEEDED = 16;
    public static final int LAUNCH_MULTIPLE = 0;
    public static final int LAUNCH_SINGLE_INSTANCE = 3;
    public static final int LAUNCH_SINGLE_TASK = 2;
    public static final int LAUNCH_SINGLE_TOP = 1;
    public static final int PERSIST_ACROSS_REBOOTS = 2;
    public static final int PERSIST_NEVER = 1;
    public static final int PERSIST_ROOT_ONLY = 0;
    public static final int SCREEN_ORIENTATION_BEHIND = 3;
    public static final int SCREEN_ORIENTATION_FULL_SENSOR = 10;
    public static final int SCREEN_ORIENTATION_FULL_USER = 13;
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
    public static final int SCREEN_ORIENTATION_LOCKED = 14;
    public static final int SCREEN_ORIENTATION_NOSENSOR = 5;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
    public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;
    public static final int SCREEN_ORIENTATION_SENSOR = 4;
    public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
    public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
    public static final int SCREEN_ORIENTATION_UNSPECIFIED = -1;
    public static final int SCREEN_ORIENTATION_USER = 2;
    public static final int SCREEN_ORIENTATION_USER_LANDSCAPE = 11;
    public static final int SCREEN_ORIENTATION_USER_PORTRAIT = 12;
    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;
    public int configChanges;
    public int documentLaunchMode;
    public int flags;
    public int launchMode;
    public int maxRecents;
    public String parentActivityName;
    public String permission;
    public int persistableMode;
    public int screenOrientation;
    public int softInputMode;
    public String targetActivity;
    public String taskAffinity;
    public int theme;
    public int uiOptions;
    public static int[] CONFIG_NATIVE_BITS = {2, 1, 4, 8, 16, 32, 64, 128, 2048, 4096, 512, 8192, 256, 16384};
    public static final Parcelable.Creator<ActivityInfo> CREATOR = new Parcelable.Creator<ActivityInfo>() { // from class: android.content.pm.ActivityInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityInfo createFromParcel(Parcel parcel) {
            return new ActivityInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityInfo[] newArray(int i) {
            return new ActivityInfo[i];
        }
    };

    public ActivityInfo() {
        this.screenOrientation = -1;
        this.uiOptions = 0;
    }

    public ActivityInfo(ActivityInfo activityInfo) {
        super(activityInfo);
        this.screenOrientation = -1;
        this.uiOptions = 0;
        this.theme = activityInfo.theme;
        this.launchMode = activityInfo.launchMode;
        this.permission = activityInfo.permission;
        this.taskAffinity = activityInfo.taskAffinity;
        this.targetActivity = activityInfo.targetActivity;
        this.flags = activityInfo.flags;
        this.screenOrientation = activityInfo.screenOrientation;
        this.configChanges = activityInfo.configChanges;
        this.softInputMode = activityInfo.softInputMode;
        this.uiOptions = activityInfo.uiOptions;
        this.parentActivityName = activityInfo.parentActivityName;
        this.maxRecents = activityInfo.maxRecents;
    }

    private ActivityInfo(Parcel parcel) {
        super(parcel);
        this.screenOrientation = -1;
        this.uiOptions = 0;
        this.theme = parcel.readInt();
        this.launchMode = parcel.readInt();
        this.permission = parcel.readString();
        this.taskAffinity = parcel.readString();
        this.targetActivity = parcel.readString();
        this.flags = parcel.readInt();
        this.screenOrientation = parcel.readInt();
        this.configChanges = parcel.readInt();
        this.softInputMode = parcel.readInt();
        this.uiOptions = parcel.readInt();
        this.parentActivityName = parcel.readString();
        this.persistableMode = parcel.readInt();
        this.maxRecents = parcel.readInt();
    }

    public static int activityInfoConfigToNative(int i) {
        int i2 = 0;
        int i3 = 0;
        while (i3 < CONFIG_NATIVE_BITS.length) {
            int i4 = i2;
            if (((1 << i3) & i) != 0) {
                i4 = i2 | CONFIG_NATIVE_BITS[i3];
            }
            i3++;
            i2 = i4;
        }
        return i2;
    }

    private String persistableModeToString() {
        switch (this.persistableMode) {
            case 0:
                return "PERSIST_ROOT_ONLY";
            case 1:
                return "PERSIST_NEVER";
            case 2:
                return "PERSIST_ACROSS_REBOOTS";
            default:
                return "UNKNOWN=" + this.persistableMode;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        super.dumpFront(printer, str);
        if (this.permission != null) {
            printer.println(str + "permission=" + this.permission);
        }
        printer.println(str + "taskAffinity=" + this.taskAffinity + " targetActivity=" + this.targetActivity + " persistableMode=" + persistableModeToString());
        if (this.launchMode != 0 || this.flags != 0 || this.theme != 0) {
            printer.println(str + "launchMode=" + this.launchMode + " flags=0x" + Integer.toHexString(this.flags) + " theme=0x" + Integer.toHexString(this.theme));
        }
        if (this.screenOrientation != -1 || this.configChanges != 0 || this.softInputMode != 0) {
            printer.println(str + "screenOrientation=" + this.screenOrientation + " configChanges=0x" + Integer.toHexString(this.configChanges) + " softInputMode=0x" + Integer.toHexString(this.softInputMode));
        }
        if (this.uiOptions != 0) {
            printer.println(str + " uiOptions=0x" + Integer.toHexString(this.uiOptions));
        }
        super.dumpBack(printer, str);
    }

    public int getRealConfigChanged() {
        return this.applicationInfo.targetSdkVersion < 13 ? this.configChanges | 1024 | 2048 : this.configChanges;
    }

    public final int getThemeResource() {
        return this.theme != 0 ? this.theme : this.applicationInfo.theme;
    }

    public String toString() {
        return "ActivityInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + i.d;
    }

    @Override // android.content.pm.ComponentInfo, android.content.pm.PackageItemInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.theme);
        parcel.writeInt(this.launchMode);
        parcel.writeString(this.permission);
        parcel.writeString(this.taskAffinity);
        parcel.writeString(this.targetActivity);
        parcel.writeInt(this.flags);
        parcel.writeInt(this.screenOrientation);
        parcel.writeInt(this.configChanges);
        parcel.writeInt(this.softInputMode);
        parcel.writeInt(this.uiOptions);
        parcel.writeString(this.parentActivityName);
        parcel.writeInt(this.persistableMode);
        parcel.writeInt(this.maxRecents);
    }
}
