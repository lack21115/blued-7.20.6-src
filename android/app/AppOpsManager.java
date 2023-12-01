package android.app;

import android.Manifest;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import com.android.internal.app.IAppOpsCallback;
import com.android.internal.app.IAppOpsService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/AppOpsManager.class */
public class AppOpsManager {
    public static final String ACTION_SU_SESSION_CHANGED = "android.intent.action.SU_SESSION_CHANGED";
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_ASK = 4;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;
    public static final int OP_ACCESS_NOTIFICATIONS = 25;
    public static final int OP_ACTIVATE_VPN = 47;
    public static final int OP_ALARM_WAKEUP = 60;
    public static final int OP_AUDIO_ALARM_VOLUME = 37;
    public static final int OP_AUDIO_BLUETOOTH_VOLUME = 39;
    public static final int OP_AUDIO_MASTER_VOLUME = 33;
    public static final int OP_AUDIO_MEDIA_VOLUME = 36;
    public static final int OP_AUDIO_NOTIFICATION_VOLUME = 38;
    public static final int OP_AUDIO_RING_VOLUME = 35;
    public static final int OP_AUDIO_VOICE_VOLUME = 34;
    public static final int OP_BLUETOOTH_CHANGE = 49;
    public static final int OP_BOOT_COMPLETED = 53;
    public static final int OP_CALL_PHONE = 13;
    public static final int OP_CAMERA = 26;
    public static final int OP_COARSE_LOCATION = 0;
    public static final int OP_DATA_CONNECT_CHANGE = 59;
    public static final int OP_DELETE_CALL_LOG = 58;
    public static final int OP_DELETE_CONTACTS = 57;
    public static final int OP_DELETE_MMS = 56;
    public static final int OP_DELETE_SMS = 55;
    public static final int OP_FINE_LOCATION = 1;
    public static final int OP_GET_USAGE_STATS = 43;
    public static final int OP_GPS = 2;
    public static final int OP_MONITOR_HIGH_POWER_LOCATION = 42;
    public static final int OP_MONITOR_LOCATION = 41;
    public static final int OP_MUTE_MICROPHONE = 44;
    public static final int OP_NEIGHBORING_CELLS = 12;
    public static final int OP_NFC_CHANGE = 54;
    public static final int OP_NONE = -1;
    public static final int OP_PLAY_AUDIO = 28;
    public static final int OP_POST_NOTIFICATION = 11;
    public static final int OP_PROJECT_MEDIA = 46;
    public static final int OP_READ_CALENDAR = 8;
    public static final int OP_READ_CALL_LOG = 6;
    public static final int OP_READ_CLIPBOARD = 29;
    public static final int OP_READ_CONTACTS = 4;
    public static final int OP_READ_ICC_SMS = 21;
    public static final int OP_READ_MMS = 51;
    public static final int OP_READ_SMS = 14;
    public static final int OP_RECEIVE_EMERGECY_SMS = 17;
    public static final int OP_RECEIVE_MMS = 18;
    public static final int OP_RECEIVE_SMS = 16;
    public static final int OP_RECEIVE_WAP_PUSH = 19;
    public static final int OP_RECORD_AUDIO = 27;
    public static final int OP_SEND_MMS = 50;
    public static final int OP_SEND_SMS = 20;
    public static final int OP_SU = 61;
    public static final int OP_SYSTEM_ALERT_WINDOW = 24;
    public static final int OP_TAKE_AUDIO_FOCUS = 32;
    public static final int OP_TAKE_MEDIA_BUTTONS = 31;
    public static final int OP_TOAST_WINDOW = 45;
    public static final int OP_VIBRATE = 3;
    public static final int OP_WAKE_LOCK = 40;
    public static final int OP_WIFI_CHANGE = 48;
    public static final int OP_WIFI_SCAN = 10;
    public static final int OP_WRITE_CALENDAR = 9;
    public static final int OP_WRITE_CALL_LOG = 7;
    public static final int OP_WRITE_CLIPBOARD = 30;
    public static final int OP_WRITE_CONTACTS = 5;
    public static final int OP_WRITE_ICC_SMS = 22;
    public static final int OP_WRITE_MMS = 52;
    public static final int OP_WRITE_SETTINGS = 23;
    public static final int OP_WRITE_SMS = 15;
    public static final int _NUM_OP = 62;
    static IBinder sToken;
    final Context mContext;
    final ArrayMap<OnOpChangedListener, IAppOpsCallback> mModeWatchers = new ArrayMap<>();
    final IAppOpsService mService;
    private static int[] sOpToSwitch = {0, 0, 0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 13, 14, 15, 16, 16, 16, 16, 20, 14, 15, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0, 0, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61};
    public static final String OPSTR_COARSE_LOCATION = "android:coarse_location";
    public static final String OPSTR_FINE_LOCATION = "android:fine_location";
    public static final String OPSTR_MONITOR_LOCATION = "android:monitor_location";
    public static final String OPSTR_MONITOR_HIGH_POWER_LOCATION = "android:monitor_location_high_power";
    public static final String OPSTR_GET_USAGE_STATS = "android:get_usage_stats";
    public static final String OPSTR_ACTIVATE_VPN = "android:activate_vpn";
    private static final String OPSTR_SU = "android:su";
    private static String[] sOpToString = {OPSTR_COARSE_LOCATION, OPSTR_FINE_LOCATION, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, OPSTR_MONITOR_LOCATION, OPSTR_MONITOR_HIGH_POWER_LOCATION, OPSTR_GET_USAGE_STATS, null, null, null, OPSTR_ACTIVATE_VPN, null, null, null, null, null, null, null, null, null, null, null, null, null, OPSTR_SU};
    private static final String OPSTR_GPS = "android:gps";
    private static final String OPSTR_VIBRATE = "android:vibrate";
    private static final String OPSTR_READ_CONTACTS = "android:read_contacts";
    private static final String OPSTR_WRITE_CONTACTS = "android:write_contacts";
    private static final String OPSTR_READ_CALL_LOG = "android:read_call_log";
    private static final String OPSTR_WRITE_CALL_LOG = "android:write_call_log";
    private static final String OPSTR_READ_CALENDAR = "android:read_calendar";
    private static final String OPSTR_WRITE_CALENDAR = "android:write_calendar";
    private static final String OPSTR_WIFI_SCAN = "android:wifi_scan";
    private static final String OPSTR_POST_NOTIFICATION = "android:post_notification";
    private static final String OPSTR_NEIGHBORING_CELLS = "android:neighboring_cells";
    private static final String OPSTR_CALL_PHONE = "android:call_phone";
    private static final String OPSTR_READ_SMS = "android:read_sms";
    private static final String OPSTR_WRITE_SMS = "android:write_sms";
    private static final String OPSTR_RECEIVE_SMS = "android:receive_sms";
    private static final String OPSTR_RECEIVE_EMERGECY_SMS = "android:receive_emergecy_sms";
    private static final String OPSTR_RECEIVE_MMS = "android:receive_mms";
    private static final String OPSTR_RECEIVE_WAP_PUSH = "android:receive_wap_push";
    private static final String OPSTR_SEND_SMS = "android:send_sms";
    private static final String OPSTR_READ_ICC_SMS = "android:read_icc_sms";
    private static final String OPSTR_WRITE_ICC_SMS = "android:write_icc_sms";
    private static final String OPSTR_WRITE_SETTINGS = "android:write_settings";
    private static final String OPSTR_SYSTEM_ALERT_WINDOW = "android:system_alert_window";
    private static final String OPSTR_ACCESS_NOTIFICATIONS = "android:access_notifications";
    private static final String OPSTR_CAMERA = "android:camera";
    private static final String OPSTR_RECORD_AUDIO = "android:record_audio";
    private static final String OPSTR_PLAY_AUDIO = "android:play_audio";
    private static final String OPSTR_READ_CLIPBOARD = "android:read_clipboard";
    private static final String OPSTR_WRITE_CLIPBOARD = "android:write_clipboard";
    private static final String OPSTR_TAKE_MEDIA_BUTTONS = "android:take_media_buttons";
    private static final String OPSTR_TAKE_AUDIO_FOCUS = "android:take_audio_focus";
    private static final String OPSTR_AUDIO_MASTER_VOLUME = "android:audio_master_volume";
    private static final String OPSTR_AUDIO_VOICE_VOLUME = "android:audio_voice_volume";
    private static final String OPSTR_AUDIO_RING_VOLUME = "android:audio_ring_volume";
    private static final String OPSTR_AUDIO_MEDIA_VOLUME = "android:audio_media_volume";
    private static final String OPSTR_AUDIO_ALARM_VOLUME = "android:audio_alarm_volume";
    private static final String OPSTR_AUDIO_NOTIFICATION_VOLUME = "android:audio_notification_volume";
    private static final String OPSTR_AUDIO_BLUETOOTH_VOLUME = "android:audio_bluetooth_volume";
    private static final String OPSTR_WAKE_LOCK = "android:wake_lock";
    private static final String OPSTR_MUTE_MICROPHONE = "android:mute_microphone";
    private static final String OPSTR_TOAST_WINDOW = "android:toast_window";
    private static final String OPSTR_PROJECT_MEDIA = "android:project_media";
    private static final String OPSTR_WIFI_CHANGE = "android:wifi_change";
    private static final String OPSTR_BLUETOOTH_CHANGE = "android:bluetooth_change";
    private static final String OPSTR_SEND_MMS = "android:send_mms";
    private static final String OPSTR_READ_MMS = "android:read_mms";
    private static final String OPSTR_WRITE_MMS = "android:write_mms";
    private static final String OPSTR_BOOT_COMPLETED = "android:boot_completed";
    private static final String OPSTR_NFC_CHANGE = "android:nfc_change";
    private static final String OPSTR_DELETE_SMS = "android:delete_sms";
    private static final String OPSTR_DELETE_MMS = "android:delete_mms";
    private static final String OPSTR_DELETE_CONTACTS = "android:delete_contacts";
    private static final String OPSTR_DELETE_CALL_LOG = "android:delete_call_log";
    private static final String OPSTR_DATA_CONNECT_CHANGE = "android:data_connect_change";
    private static final String OPSTR_ALARM_WAKEUP = "android:alarm_wakeup";
    private static String[] sOpToOpString = {OPSTR_COARSE_LOCATION, OPSTR_FINE_LOCATION, OPSTR_GPS, OPSTR_VIBRATE, OPSTR_READ_CONTACTS, OPSTR_WRITE_CONTACTS, OPSTR_READ_CALL_LOG, OPSTR_WRITE_CALL_LOG, OPSTR_READ_CALENDAR, OPSTR_WRITE_CALENDAR, OPSTR_WIFI_SCAN, OPSTR_POST_NOTIFICATION, OPSTR_NEIGHBORING_CELLS, OPSTR_CALL_PHONE, OPSTR_READ_SMS, OPSTR_WRITE_SMS, OPSTR_RECEIVE_SMS, OPSTR_RECEIVE_EMERGECY_SMS, OPSTR_RECEIVE_MMS, OPSTR_RECEIVE_WAP_PUSH, OPSTR_SEND_SMS, OPSTR_READ_ICC_SMS, OPSTR_WRITE_ICC_SMS, OPSTR_WRITE_SETTINGS, OPSTR_SYSTEM_ALERT_WINDOW, OPSTR_ACCESS_NOTIFICATIONS, OPSTR_CAMERA, OPSTR_RECORD_AUDIO, OPSTR_PLAY_AUDIO, OPSTR_READ_CLIPBOARD, OPSTR_WRITE_CLIPBOARD, OPSTR_TAKE_MEDIA_BUTTONS, OPSTR_TAKE_AUDIO_FOCUS, OPSTR_AUDIO_MASTER_VOLUME, OPSTR_AUDIO_VOICE_VOLUME, OPSTR_AUDIO_RING_VOLUME, OPSTR_AUDIO_MEDIA_VOLUME, OPSTR_AUDIO_ALARM_VOLUME, OPSTR_AUDIO_NOTIFICATION_VOLUME, OPSTR_AUDIO_BLUETOOTH_VOLUME, OPSTR_WAKE_LOCK, OPSTR_MONITOR_LOCATION, OPSTR_MONITOR_HIGH_POWER_LOCATION, OPSTR_GET_USAGE_STATS, OPSTR_MUTE_MICROPHONE, OPSTR_TOAST_WINDOW, OPSTR_PROJECT_MEDIA, OPSTR_ACTIVATE_VPN, OPSTR_WIFI_CHANGE, OPSTR_BLUETOOTH_CHANGE, OPSTR_SEND_MMS, OPSTR_READ_MMS, OPSTR_WRITE_MMS, OPSTR_BOOT_COMPLETED, OPSTR_NFC_CHANGE, OPSTR_DELETE_SMS, OPSTR_DELETE_MMS, OPSTR_DELETE_CONTACTS, OPSTR_DELETE_CALL_LOG, OPSTR_DATA_CONNECT_CHANGE, OPSTR_ALARM_WAKEUP, OPSTR_SU};
    private static String[] sOpNames = {"COARSE_LOCATION", "FINE_LOCATION", "GPS", "VIBRATE", "READ_CONTACTS", "WRITE_CONTACTS", "READ_CALL_LOG", "WRITE_CALL_LOG", "READ_CALENDAR", "WRITE_CALENDAR", "WIFI_SCAN", "POST_NOTIFICATION", "NEIGHBORING_CELLS", "CALL_PHONE", "READ_SMS", "WRITE_SMS", "RECEIVE_SMS", "RECEIVE_EMERGECY_SMS", "RECEIVE_MMS", "RECEIVE_WAP_PUSH", "SEND_SMS", "READ_ICC_SMS", "WRITE_ICC_SMS", "WRITE_SETTINGS", "SYSTEM_ALERT_WINDOW", "ACCESS_NOTIFICATIONS", "CAMERA", "RECORD_AUDIO", "PLAY_AUDIO", "READ_CLIPBOARD", "WRITE_CLIPBOARD", "TAKE_MEDIA_BUTTONS", "TAKE_AUDIO_FOCUS", "AUDIO_MASTER_VOLUME", "AUDIO_VOICE_VOLUME", "AUDIO_RING_VOLUME", "AUDIO_MEDIA_VOLUME", "AUDIO_ALARM_VOLUME", "AUDIO_NOTIFICATION_VOLUME", "AUDIO_BLUETOOTH_VOLUME", "WAKE_LOCK", "MONITOR_LOCATION", "MONITOR_HIGH_POWER_LOCATION", "GET_USAGE_STATS", "MUTE_MICROPHONE", "TOAST_WINDOW", "PROJECT_MEDIA", "ACTIVATE_VPN", "WIFI_CHANGE", "BLUETOOTH_CHANGE", "SEND_MMS", "READ_MMS", "WRITE_MMS", "BOOT_COMPLETED", "NFC_CHANGE", "DELETE_SMS", "DELETE_MMS", "DELETE_CONTACTS", "DELETE_CALL_LOG", "DATA_CONNECT_CHANGE", "ALARM_WAKEUP", "SU"};
    private static String[] sOpPerms = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", null, Manifest.permission.VIBRATE, Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CALL_LOG, Manifest.permission.WRITE_CALL_LOG, Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR, null, null, null, Manifest.permission.CALL_PHONE, Manifest.permission.READ_SMS, Manifest.permission.WRITE_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.RECEIVE_EMERGENCY_BROADCAST, Manifest.permission.RECEIVE_MMS, Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.WRITE_SMS, Manifest.permission.WRITE_SETTINGS, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.ACCESS_NOTIFICATIONS, Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, null, null, null, null, null, null, null, null, null, null, null, null, Manifest.permission.WAKE_LOCK, null, null, Manifest.permission.PACKAGE_USAGE_STATS, null, null, null, null, Manifest.permission.CHANGE_WIFI_STATE, Manifest.permission.BLUETOOTH, Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.WRITE_SMS, Manifest.permission.RECEIVE_BOOT_COMPLETED, Manifest.permission.NFC, Manifest.permission.WRITE_SMS, Manifest.permission.WRITE_SMS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.WRITE_CALL_LOG, Manifest.permission.MODIFY_PHONE_STATE, null, null};
    private static String[] sOpRestrictions = {UserManager.DISALLOW_SHARE_LOCATION, UserManager.DISALLOW_SHARE_LOCATION, UserManager.DISALLOW_SHARE_LOCATION, null, null, null, UserManager.DISALLOW_OUTGOING_CALLS, UserManager.DISALLOW_OUTGOING_CALLS, null, null, UserManager.DISALLOW_SHARE_LOCATION, null, null, null, UserManager.DISALLOW_SMS, UserManager.DISALLOW_SMS, UserManager.DISALLOW_SMS, null, UserManager.DISALLOW_SMS, null, UserManager.DISALLOW_SMS, UserManager.DISALLOW_SMS, UserManager.DISALLOW_SMS, null, UserManager.DISALLOW_CREATE_WINDOWS, null, null, null, null, null, null, null, null, UserManager.DISALLOW_ADJUST_VOLUME, UserManager.DISALLOW_ADJUST_VOLUME, UserManager.DISALLOW_ADJUST_VOLUME, UserManager.DISALLOW_ADJUST_VOLUME, UserManager.DISALLOW_ADJUST_VOLUME, UserManager.DISALLOW_ADJUST_VOLUME, UserManager.DISALLOW_ADJUST_VOLUME, null, UserManager.DISALLOW_SHARE_LOCATION, UserManager.DISALLOW_SHARE_LOCATION, null, UserManager.DISALLOW_UNMUTE_MICROPHONE, UserManager.DISALLOW_CREATE_WINDOWS, null, UserManager.DISALLOW_CONFIG_VPN, null, null, null, null, null, null, null, null, null, null, null, null, null, UserManager.DISALLOW_SU};
    private static boolean[] sOpAllowSystemRestrictionBypass = {false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false};
    private static int[] sOpDefaultMode = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4};
    private static int[] sOpDefaultStrictMode = {4, 4, 4, 0, 4, 4, 4, 4, 0, 0, 4, 0, 0, 4, 4, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 0, 0, 1, 1, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0, 4};
    private static final boolean[] sOpStrictMode = {true, true, true, false, true, true, true, true, false, false, true, false, false, true, true, true, false, false, false, false, true, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, true, true, true, true, false, true, true, true, true, true, true, false, true};
    private static boolean[] sOpDisableReset = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    private static HashMap<String, Integer> sOpStrToOp = new HashMap<>();
    private static HashMap<String, Integer> sOpStringToOp = new HashMap<>();
    private static HashMap<String, Integer> sNameToOp = new HashMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/app/AppOpsManager$OnOpChangedInternalListener.class */
    public static class OnOpChangedInternalListener implements OnOpChangedListener {
        public void onOpChanged(int i, String str) {
        }

        @Override // android.app.AppOpsManager.OnOpChangedListener
        public void onOpChanged(String str, String str2) {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/AppOpsManager$OnOpChangedListener.class */
    public interface OnOpChangedListener {
        void onOpChanged(String str, String str2);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/AppOpsManager$OpEntry.class */
    public static class OpEntry implements Parcelable {
        public static final Parcelable.Creator<OpEntry> CREATOR = new Parcelable.Creator<OpEntry>() { // from class: android.app.AppOpsManager.OpEntry.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public OpEntry createFromParcel(Parcel parcel) {
                return new OpEntry(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public OpEntry[] newArray(int i) {
                return new OpEntry[i];
            }
        };
        private final int mAllowedCount;
        private final int mDuration;
        private final int mIgnoredCount;
        private final int mMode;
        private final int mOp;
        private final long mRejectTime;
        private final long mTime;

        public OpEntry(int i, int i2, long j, long j2, int i3, int i4, int i5) {
            this.mOp = i;
            this.mMode = i2;
            this.mTime = j;
            this.mRejectTime = j2;
            this.mDuration = i3;
            this.mAllowedCount = i4;
            this.mIgnoredCount = i5;
        }

        OpEntry(Parcel parcel) {
            this.mOp = parcel.readInt();
            this.mMode = parcel.readInt();
            this.mTime = parcel.readLong();
            this.mRejectTime = parcel.readLong();
            this.mDuration = parcel.readInt();
            this.mAllowedCount = parcel.readInt();
            this.mIgnoredCount = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getAllowedCount() {
            return this.mAllowedCount;
        }

        public int getDuration() {
            return this.mDuration == -1 ? (int) (System.currentTimeMillis() - this.mTime) : this.mDuration;
        }

        public int getIgnoredCount() {
            return this.mIgnoredCount;
        }

        public int getMode() {
            return this.mMode;
        }

        public int getOp() {
            return this.mOp;
        }

        public long getRejectTime() {
            return this.mRejectTime;
        }

        public long getTime() {
            return this.mTime;
        }

        public boolean isRunning() {
            return this.mDuration == -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mOp);
            parcel.writeInt(this.mMode);
            parcel.writeLong(this.mTime);
            parcel.writeLong(this.mRejectTime);
            parcel.writeInt(this.mDuration);
            parcel.writeInt(this.mAllowedCount);
            parcel.writeInt(this.mIgnoredCount);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/AppOpsManager$PackageOps.class */
    public static class PackageOps implements Parcelable {
        public static final Parcelable.Creator<PackageOps> CREATOR = new Parcelable.Creator<PackageOps>() { // from class: android.app.AppOpsManager.PackageOps.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PackageOps createFromParcel(Parcel parcel) {
                return new PackageOps(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PackageOps[] newArray(int i) {
                return new PackageOps[i];
            }
        };
        private final List<OpEntry> mEntries;
        private final String mPackageName;
        private final int mUid;

        PackageOps(Parcel parcel) {
            this.mPackageName = parcel.readString();
            this.mUid = parcel.readInt();
            this.mEntries = new ArrayList();
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return;
                }
                this.mEntries.add(OpEntry.CREATOR.createFromParcel(parcel));
                i = i2 + 1;
            }
        }

        public PackageOps(String str, int i, List<OpEntry> list) {
            this.mPackageName = str;
            this.mUid = i;
            this.mEntries = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public List<OpEntry> getOps() {
            return this.mEntries;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public int getUid() {
            return this.mUid;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mPackageName);
            parcel.writeInt(this.mUid);
            parcel.writeInt(this.mEntries.size());
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mEntries.size()) {
                    return;
                }
                this.mEntries.get(i3).writeToParcel(parcel, i);
                i2 = i3 + 1;
            }
        }
    }

    static {
        if (sOpToSwitch.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpToString.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpToOpString.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpNames.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpPerms.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpDefaultMode.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpDefaultStrictMode.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpDisableReset.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpRestrictions.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpAllowSystemRestrictionBypass.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else if (sOpStrictMode.length != 62) {
            new StringBuilder();
            throw new VerifyError("bad dex opcode");
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 62) {
                    if (62 < 0) {
                        HashMap<String, Integer> hashMap = sNameToOp;
                        String str = sOpNames[0];
                        throw new VerifyError("bad dex opcode");
                    }
                    return;
                } else if (sOpToString[i2] != null) {
                    HashMap<String, Integer> hashMap2 = sOpStrToOp;
                    String str2 = sOpToString[i2];
                    throw new VerifyError("bad dex opcode");
                } else if (sOpToOpString[i2] != null) {
                    HashMap<String, Integer> hashMap3 = sOpStringToOp;
                    String str3 = sOpToOpString[i2];
                    throw new VerifyError("bad dex opcode");
                } else {
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppOpsManager(Context context, IAppOpsService iAppOpsService) {
        this.mContext = context;
        this.mService = iAppOpsService;
    }

    private String buildSecurityExceptionMsg(int i, int i2, String str) {
        return str + " from uid " + i2 + " not allowed to perform " + sOpNames[i];
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0031 -> B:11:0x0022). Please submit an issue!!! */
    public static IBinder getToken(IAppOpsService iAppOpsService) {
        synchronized (AppOpsManager.class) {
            try {
                if (sToken != null) {
                    return sToken;
                }
                try {
                    sToken = iAppOpsService.getToken(new Binder());
                } catch (RemoteException e) {
                }
                return sToken;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isStrictEnable() {
        return SystemProperties.getBoolean("persist.sys.strict_op_enable", false);
    }

    public static boolean isStrictOp(int i) {
        return sOpStrictMode[i];
    }

    public static int nameToOp(String str) {
        Integer num = sNameToOp.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static boolean opAllowSystemBypassRestriction(int i) {
        return sOpAllowSystemRestrictionBypass[i];
    }

    public static boolean opAllowsReset(int i) {
        return !sOpDisableReset[i];
    }

    public static int opToDefaultMode(int i, boolean z) {
        return z ? sOpDefaultStrictMode[i] : sOpDefaultMode[i];
    }

    public static String opToName(int i) {
        return i == -1 ? "NONE" : i < sOpNames.length ? sOpNames[i] : "Unknown(" + i + ")";
    }

    public static String opToPermission(int i) {
        return sOpPerms[i];
    }

    public static String opToRestriction(int i) {
        return sOpRestrictions[i];
    }

    public static int opToSwitch(int i) {
        return sOpToSwitch[i];
    }

    public static int strDebugOpToOp(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sOpNames.length) {
                throw new IllegalArgumentException("Unknown operation string: " + str);
            }
            if (sOpNames[i2].equals(str)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static int strOpToOp(String str) {
        Integer num = sOpStrToOp.get(str);
        if (num == null) {
            throw new IllegalArgumentException("Unknown operation string: " + str);
        }
        return num.intValue();
    }

    public static int stringOpToOp(String str) {
        Integer num = sOpStringToOp.get(str);
        Integer num2 = num;
        if (num == null) {
            num2 = -1;
        }
        return num2.intValue();
    }

    public static int stringToMode(String str) {
        if ("allowed".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("ignored".equalsIgnoreCase(str)) {
            return 1;
        }
        return "ask".equalsIgnoreCase(str) ? 4 : 2;
    }

    public int checkAudioOp(int i, int i2, int i3, String str) {
        int i4;
        try {
            int checkAudioOperation = this.mService.checkAudioOperation(i, i2, i3, str);
            i4 = checkAudioOperation;
            if (checkAudioOperation == 2) {
                throw new SecurityException(buildSecurityExceptionMsg(i, i3, str));
            }
        } catch (RemoteException e) {
            i4 = 1;
        }
        return i4;
    }

    public int checkAudioOpNoThrow(int i, int i2, int i3, String str) {
        try {
            return this.mService.checkAudioOperation(i, i2, i3, str);
        } catch (RemoteException e) {
            return 1;
        }
    }

    public int checkOp(int i, int i2, String str) {
        int i3;
        try {
            int checkOperation = this.mService.checkOperation(i, i2, str);
            i3 = checkOperation;
            if (checkOperation == 2) {
                throw new SecurityException(buildSecurityExceptionMsg(i, i2, str));
            }
        } catch (RemoteException e) {
            i3 = 1;
        }
        return i3;
    }

    public int checkOp(String str, int i, String str2) {
        return checkOp(strOpToOp(str), i, str2);
    }

    public int checkOpNoThrow(int i, int i2, String str) {
        try {
            return this.mService.checkOperation(i, i2, str);
        } catch (RemoteException e) {
            return 1;
        }
    }

    public int checkOpNoThrow(String str, int i, String str2) {
        return checkOpNoThrow(strOpToOp(str), i, str2);
    }

    public void checkPackage(int i, String str) {
        try {
            if (this.mService.checkPackage(i, str) != 0) {
                throw new SecurityException("Package " + str + " does not belong to " + i);
            }
        } catch (RemoteException e) {
            throw new SecurityException("Unable to verify package ownership", e);
        }
    }

    public void finishOp(int i) {
        finishOp(i, Process.myUid(), this.mContext.getOpPackageName());
    }

    public void finishOp(int i, int i2, String str) {
        try {
            this.mService.finishOperation(getToken(this.mService), i, i2, str);
        } catch (RemoteException e) {
        }
    }

    public void finishOp(String str, int i, String str2) {
        finishOp(strOpToOp(str), i, str2);
    }

    public List<PackageOps> getOpsForPackage(int i, String str, int[] iArr) {
        try {
            return this.mService.getOpsForPackage(i, str, iArr);
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<PackageOps> getPackagesForOps(int[] iArr) {
        try {
            return this.mService.getPackagesForOps(iArr);
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean getPrivacyGuardSettingForPackage(int i, String str) {
        try {
            return this.mService.getPrivacyGuardSettingForPackage(i, str);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isControlAllowed(int i, String str) {
        try {
            return this.mService.isControlAllowed(i, str);
        } catch (RemoteException e) {
            return true;
        }
    }

    public int noteOp(int i) {
        return noteOp(i, Process.myUid(), this.mContext.getOpPackageName());
    }

    public int noteOp(int i, int i2, String str) {
        int i3;
        try {
            int noteOperation = this.mService.noteOperation(i, i2, str);
            i3 = noteOperation;
            if (noteOperation == 2) {
                throw new SecurityException(buildSecurityExceptionMsg(i, i2, str));
            }
        } catch (RemoteException e) {
            i3 = 1;
        }
        return i3;
    }

    public int noteOp(String str, int i, String str2) {
        return noteOp(strOpToOp(str), i, str2);
    }

    public int noteOpNoThrow(int i, int i2, String str) {
        try {
            return this.mService.noteOperation(i, i2, str);
        } catch (RemoteException e) {
            return 1;
        }
    }

    public int noteOpNoThrow(String str, int i, String str2) {
        return noteOpNoThrow(strOpToOp(str), i, str2);
    }

    public void resetAllModes() {
        try {
            this.mService.resetAllModes(UserHandle.myUserId(), null);
        } catch (RemoteException e) {
        }
    }

    public void resetCounters() {
        try {
            this.mService.resetCounters();
        } catch (RemoteException e) {
        }
    }

    public void setMode(int i, int i2, String str, int i3) {
        try {
            this.mService.setMode(i, i2, str, i3);
        } catch (RemoteException e) {
        }
    }

    public void setPrivacyGuardSettingForPackage(int i, String str, boolean z) {
        try {
            this.mService.setPrivacyGuardSettingForPackage(i, str, z);
        } catch (RemoteException e) {
        }
    }

    public void setRestriction(int i, int i2, int i3, String[] strArr) {
        try {
            this.mService.setAudioRestriction(i, i2, Binder.getCallingUid(), i3, strArr);
        } catch (RemoteException e) {
        }
    }

    public int startOp(int i) {
        return startOp(i, Process.myUid(), this.mContext.getOpPackageName());
    }

    public int startOp(int i, int i2, String str) {
        int i3;
        try {
            int startOperation = this.mService.startOperation(getToken(this.mService), i, i2, str);
            i3 = startOperation;
            if (startOperation == 2) {
                throw new SecurityException(buildSecurityExceptionMsg(i, i2, str));
            }
        } catch (RemoteException e) {
            i3 = 1;
        }
        return i3;
    }

    public int startOp(String str, int i, String str2) {
        return startOp(strOpToOp(str), i, str2);
    }

    public int startOpNoThrow(int i, int i2, String str) {
        try {
            return this.mService.startOperation(getToken(this.mService), i, i2, str);
        } catch (RemoteException e) {
            return 1;
        }
    }

    public int startOpNoThrow(String str, int i, String str2) {
        return startOpNoThrow(strOpToOp(str), i, str2);
    }

    public void startWatchingMode(int i, String str, final OnOpChangedListener onOpChangedListener) {
        synchronized (this.mModeWatchers) {
            IAppOpsCallback iAppOpsCallback = this.mModeWatchers.get(onOpChangedListener);
            IAppOpsCallback.Stub stub = iAppOpsCallback;
            if (iAppOpsCallback == null) {
                stub = new IAppOpsCallback.Stub() { // from class: android.app.AppOpsManager.1
                    @Override // com.android.internal.app.IAppOpsCallback
                    public void opChanged(int i2, String str2) {
                        if (onOpChangedListener instanceof OnOpChangedInternalListener) {
                            ((OnOpChangedInternalListener) onOpChangedListener).onOpChanged(i2, str2);
                        }
                        if (AppOpsManager.sOpToString[i2] != null) {
                            onOpChangedListener.onOpChanged(AppOpsManager.sOpToString[i2], str2);
                        }
                    }
                };
                this.mModeWatchers.put(onOpChangedListener, stub);
            }
            try {
                this.mService.startWatchingMode(i, str, stub);
            } catch (RemoteException e) {
            }
        }
    }

    public void startWatchingMode(String str, String str2, OnOpChangedListener onOpChangedListener) {
        startWatchingMode(strOpToOp(str), str2, onOpChangedListener);
    }

    public void stopWatchingMode(OnOpChangedListener onOpChangedListener) {
        synchronized (this.mModeWatchers) {
            IAppOpsCallback iAppOpsCallback = this.mModeWatchers.get(onOpChangedListener);
            if (iAppOpsCallback != null) {
                try {
                    this.mService.stopWatchingMode(iAppOpsCallback);
                } catch (RemoteException e) {
                }
            }
        }
    }
}
