package android.os;

import android.app.backup.FullBackup;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.hardware.usb.UsbManager;
import android.provider.Settings;
import android.telephony.SignalStrength;
import android.text.format.DateFormat;
import android.util.Printer;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TimeUtils;
import android.view.SurfaceControl;
import androidx.exifinterface.media.ExifInterface;
import com.android.internal.os.BatterySipper;
import com.android.internal.os.BatteryStatsHelper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.igexin.push.core.b;
import com.umeng.analytics.pro.at;
import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats.class */
public abstract class BatteryStats implements Parcelable {
    private static final String APK_DATA = "apk";
    public static final int AUDIO_TURNED_ON = 15;
    private static final String BATTERY_DATA = "bt";
    private static final String BATTERY_DISCHARGE_DATA = "dc";
    private static final String BATTERY_LEVEL_DATA = "lv";
    private static final int BATTERY_STATS_CHECKIN_VERSION = 9;
    private static final String BLUETOOTH_STATE_COUNT_DATA = "bsc";
    public static final int BLUETOOTH_STATE_HIGH = 3;
    public static final int BLUETOOTH_STATE_INACTIVE = 0;
    public static final int BLUETOOTH_STATE_LOW = 1;
    public static final int BLUETOOTH_STATE_MEDIUM = 2;
    private static final String BLUETOOTH_STATE_TIME_DATA = "bst";
    private static final long BYTES_PER_GB = 1073741824;
    private static final long BYTES_PER_KB = 1024;
    private static final long BYTES_PER_MB = 1048576;
    private static final String CHARGE_STEP_DATA = "csd";
    private static final String CHARGE_TIME_REMAIN_DATA = "ctr";
    public static final int DATA_CONNECTION_1xRTT = 7;
    public static final int DATA_CONNECTION_CDMA = 4;
    private static final String DATA_CONNECTION_COUNT_DATA = "dcc";
    public static final int DATA_CONNECTION_EDGE = 2;
    public static final int DATA_CONNECTION_EHRPD = 14;
    public static final int DATA_CONNECTION_EVDO_0 = 5;
    public static final int DATA_CONNECTION_EVDO_A = 6;
    public static final int DATA_CONNECTION_EVDO_B = 12;
    public static final int DATA_CONNECTION_GPRS = 1;
    public static final int DATA_CONNECTION_HSDPA = 8;
    public static final int DATA_CONNECTION_HSPA = 10;
    public static final int DATA_CONNECTION_HSPAP = 15;
    public static final int DATA_CONNECTION_HSUPA = 9;
    public static final int DATA_CONNECTION_IDEN = 11;
    public static final int DATA_CONNECTION_LTE = 13;
    public static final int DATA_CONNECTION_NONE = 0;
    public static final int DATA_CONNECTION_OTHER = 16;
    private static final String DATA_CONNECTION_TIME_DATA = "dct";
    public static final int DATA_CONNECTION_UMTS = 3;
    private static final String DISCHARGE_STEP_DATA = "dsd";
    private static final String DISCHARGE_TIME_REMAIN_DATA = "dtr";
    public static final int DUMP_CHARGED_ONLY = 2;
    public static final int DUMP_DEVICE_WIFI_ONLY = 32;
    public static final int DUMP_HISTORY_ONLY = 4;
    public static final int DUMP_INCLUDE_HISTORY = 8;
    public static final int DUMP_UNPLUGGED_ONLY = 1;
    public static final int DUMP_VERBOSE = 16;
    public static final int FOREGROUND_ACTIVITY = 10;
    public static final int FULL_WIFI_LOCK = 5;
    private static final String GLOBAL_NETWORK_DATA = "gn";
    private static final String HISTORY_DATA = "h";
    private static final String HISTORY_STRING_POOL = "hsp";
    public static final int JOB = 14;
    private static final String JOB_DATA = "jb";
    private static final String KERNEL_WAKELOCK_DATA = "kwl";
    private static final boolean LOCAL_LOGV = false;
    private static final String MISC_DATA = "m";
    private static final String NETWORK_DATA = "nt";
    public static final int NETWORK_MOBILE_RX_DATA = 0;
    public static final int NETWORK_MOBILE_TX_DATA = 1;
    public static final int NETWORK_WIFI_RX_DATA = 2;
    public static final int NETWORK_WIFI_TX_DATA = 3;
    public static final int NUM_BLUETOOTH_STATES = 4;
    public static final int NUM_DATA_CONNECTION_TYPES = 17;
    public static final int NUM_NETWORK_ACTIVITY_TYPES = 4;
    public static final int NUM_SCREEN_BRIGHTNESS_BINS = 5;
    public static final int NUM_WIFI_SIGNAL_STRENGTH_BINS = 5;
    public static final int NUM_WIFI_STATES = 8;
    public static final int NUM_WIFI_SUPPL_STATES = 13;
    private static final String POWER_USE_ITEM_DATA = "pwi";
    private static final String POWER_USE_SUMMARY_DATA = "pws";
    private static final String PROCESS_DATA = "pr";
    public static final int PROCESS_STATE = 12;
    public static final int SCREEN_BRIGHTNESS_BRIGHT = 4;
    public static final int SCREEN_BRIGHTNESS_DARK = 0;
    private static final String SCREEN_BRIGHTNESS_DATA = "br";
    public static final int SCREEN_BRIGHTNESS_DIM = 1;
    public static final int SCREEN_BRIGHTNESS_LIGHT = 3;
    public static final int SCREEN_BRIGHTNESS_MEDIUM = 2;
    public static final int SENSOR = 3;
    private static final String SENSOR_DATA = "sr";
    public static final String SERVICE_NAME = "batterystats";
    private static final String SIGNAL_SCANNING_TIME_DATA = "sst";
    private static final String SIGNAL_STRENGTH_COUNT_DATA = "sgc";
    private static final String SIGNAL_STRENGTH_TIME_DATA = "sgt";
    private static final String STATE_TIME_DATA = "st";
    public static final int STATS_CURRENT = 1;
    public static final int STATS_SINCE_CHARGED = 0;
    public static final int STATS_SINCE_UNPLUGGED = 2;
    public static final long STEP_LEVEL_INITIAL_MODE_MASK = 71776119061217280L;
    public static final long STEP_LEVEL_INITIAL_MODE_SHIFT = 48;
    public static final long STEP_LEVEL_LEVEL_MASK = 280375465082880L;
    public static final long STEP_LEVEL_LEVEL_SHIFT = 40;
    public static final int STEP_LEVEL_MODE_POWER_SAVE = 4;
    public static final int STEP_LEVEL_MODE_SCREEN_STATE = 3;
    public static final long STEP_LEVEL_MODIFIED_MODE_MASK = -72057594037927936L;
    public static final long STEP_LEVEL_MODIFIED_MODE_SHIFT = 56;
    public static final long STEP_LEVEL_TIME_MASK = 1099511627775L;
    public static final int SYNC = 13;
    private static final String SYNC_DATA = "sy";
    private static final String UID_DATA = "uid";
    private static final String USER_ACTIVITY_DATA = "ua";
    private static final String VERSION_DATA = "vers";
    private static final String VIBRATOR_DATA = "vib";
    public static final int VIBRATOR_ON = 9;
    public static final int VIDEO_TURNED_ON = 8;
    private static final String WAKELOCK_DATA = "wl";
    private static final String WAKEUP_REASON_DATA = "wr";
    public static final int WAKE_TYPE_FULL = 1;
    public static final int WAKE_TYPE_PARTIAL = 0;
    public static final int WAKE_TYPE_WINDOW = 2;
    public static final int WIFI_BATCHED_SCAN = 11;
    private static final String WIFI_DATA = "wfl";
    public static final int WIFI_MULTICAST_ENABLED = 7;
    public static final int WIFI_RUNNING = 4;
    public static final int WIFI_SCAN = 6;
    private static final String WIFI_SIGNAL_STRENGTH_COUNT_DATA = "wsgc";
    private static final String WIFI_SIGNAL_STRENGTH_TIME_DATA = "wsgt";
    private static final String WIFI_STATE_COUNT_DATA = "wsc";
    public static final int WIFI_STATE_OFF = 0;
    public static final int WIFI_STATE_OFF_SCANNING = 1;
    public static final int WIFI_STATE_ON_CONNECTED_P2P = 5;
    public static final int WIFI_STATE_ON_CONNECTED_STA = 4;
    public static final int WIFI_STATE_ON_CONNECTED_STA_P2P = 6;
    public static final int WIFI_STATE_ON_DISCONNECTED = 3;
    public static final int WIFI_STATE_ON_NO_NETWORKS = 2;
    public static final int WIFI_STATE_SOFT_AP = 7;
    private static final String WIFI_STATE_TIME_DATA = "wst";
    public static final int WIFI_SUPPL_STATE_ASSOCIATED = 7;
    public static final int WIFI_SUPPL_STATE_ASSOCIATING = 6;
    public static final int WIFI_SUPPL_STATE_AUTHENTICATING = 5;
    public static final int WIFI_SUPPL_STATE_COMPLETED = 10;
    private static final String WIFI_SUPPL_STATE_COUNT_DATA = "wssc";
    public static final int WIFI_SUPPL_STATE_DISCONNECTED = 1;
    public static final int WIFI_SUPPL_STATE_DORMANT = 11;
    public static final int WIFI_SUPPL_STATE_FOUR_WAY_HANDSHAKE = 8;
    public static final int WIFI_SUPPL_STATE_GROUP_HANDSHAKE = 9;
    public static final int WIFI_SUPPL_STATE_INACTIVE = 3;
    public static final int WIFI_SUPPL_STATE_INTERFACE_DISABLED = 2;
    public static final int WIFI_SUPPL_STATE_INVALID = 0;
    public static final int WIFI_SUPPL_STATE_SCANNING = 4;
    private static final String WIFI_SUPPL_STATE_TIME_DATA = "wsst";
    public static final int WIFI_SUPPL_STATE_UNINITIALIZED = 12;
    private final StringBuilder mFormatBuilder = new StringBuilder(32);
    private final Formatter mFormatter = new Formatter(this.mFormatBuilder);
    private static final String[] STAT_NAMES = {"l", "c", "u"};
    static final String[] SCREEN_BRIGHTNESS_NAMES = {"dark", "dim", "medium", "light", "bright"};
    static final String[] SCREEN_BRIGHTNESS_SHORT_NAMES = {"0", "1", "2", "3", "4"};
    static final String[] DATA_CONNECTION_NAMES = {"none", "gprs", "edge", "umts", "cdma", "evdo_0", "evdo_A", "1xrtt", "hsdpa", "hsupa", "hspa", "iden", "evdo_b", "lte", "ehrpd", "hspap", "other"};
    static final String[] WIFI_SUPPL_STATE_NAMES = {"invalid", "disconn", "disabled", "inactive", "scanning", "authenticating", "associating", "associated", "4-way-handshake", "group-handshake", "completed", "dormant", "uninit"};
    static final String[] WIFI_SUPPL_STATE_SHORT_NAMES = {"inv", "dsc", "dis", "inact", "scan", "auth", "ascing", "asced", "4-way", "group", "compl", "dorm", "uninit"};
    public static final BitDescription[] HISTORY_STATE_DESCRIPTIONS = {new BitDescription(Integer.MIN_VALUE, "running", "r"), new BitDescription(1073741824, "wake_lock", IAdInterListener.AdReqParam.WIDTH), new BitDescription(8388608, "sensor", "s"), new BitDescription(536870912, "gps", OapsKey.KEY_GRADE), new BitDescription(268435456, "wifi_full_lock", "Wl"), new BitDescription(134217728, "wifi_scan", "Ws"), new BitDescription(67108864, "wifi_multicast", "Wm"), new BitDescription(33554432, "mobile_radio", "Pr"), new BitDescription(2097152, "phone_scanning", "Psc"), new BitDescription(4194304, "audio", "a"), new BitDescription(1048576, "screen", ExifInterface.LATITUDE_SOUTH), new BitDescription(524288, BatteryManager.EXTRA_PLUGGED, "BP"), new BitDescription(262144, "phone_in_call", "Pcl"), new BitDescription(65536, "bluetooth", "b"), new BitDescription(HistoryItem.STATE_DATA_CONNECTION_MASK, 9, "data_conn", "Pcn", DATA_CONNECTION_NAMES, DATA_CONNECTION_NAMES), new BitDescription(448, 6, "phone_state", "Pst", new String[]{"in", "out", "emergency", "off"}, new String[]{"in", "out", "em", "off"}), new BitDescription(56, 3, "phone_signal_strength", "Pss", SignalStrength.SIGNAL_STRENGTH_NAMES, new String[]{"0", "1", "2", "3", "4"}), new BitDescription(7, 0, "brightness", "Sb", SCREEN_BRIGHTNESS_NAMES, SCREEN_BRIGHTNESS_SHORT_NAMES)};
    public static final BitDescription[] HISTORY_STATE2_DESCRIPTIONS = {new BitDescription(Integer.MIN_VALUE, Settings.Global.LOW_POWER_MODE, "lp"), new BitDescription(1073741824, "video", "v"), new BitDescription(536870912, "wifi_running", "Wr"), new BitDescription(268435456, "wifi", "W"), new BitDescription(134217728, "flashlight", "fl"), new BitDescription(112, 4, "wifi_signal_strength", "Wss", new String[]{"0", "1", "2", "3", "4"}, new String[]{"0", "1", "2", "3", "4"}), new BitDescription(15, 0, "wifi_suppl", "Wsp", WIFI_SUPPL_STATE_NAMES, WIFI_SUPPL_STATE_SHORT_NAMES)};
    private static final String FOREGROUND_DATA = "fg";
    public static final String[] HISTORY_EVENT_NAMES = {b.l, "proc", FOREGROUND_DATA, Constant.MAP_KEY_TOP, "sync", "wake_lock_in", "job", "user", "userfg", "conn"};
    public static final String[] HISTORY_EVENT_CHECKIN_NAMES = {"Enl", "Epr", "Efg", "Etp", "Esy", "Ewl", "Ejb", "Eur", "Euf", "Ecn"};
    static final String[] WIFI_STATE_NAMES = {"off", "scanning", "no_net", "disconn", at.x, "p2p", "sta_p2p", "soft_ap"};
    static final String[] BLUETOOTH_STATE_NAMES = {"inactive", "low", "med", "high"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.os.BatteryStats$2  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$internal$os$BatterySipper$DrainType = new int[BatterySipper.DrainType.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008b -> B:53:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008f -> B:55:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0093 -> B:47:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0097 -> B:65:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009b -> B:61:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009f -> B:57:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a3 -> B:49:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00a7 -> B:67:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00ab -> B:63:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00af -> B:59:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.CELL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.PHONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.BLUETOOTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.SCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.FLASHLIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.APP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.USER.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.UNACCOUNTED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$android$internal$os$BatterySipper$DrainType[BatterySipper.DrainType.OVERCOUNTED.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$BitDescription.class */
    public static final class BitDescription {
        public final int mask;
        public final String name;
        public final int shift;
        public final String shortName;
        public final String[] shortValues;
        public final String[] values;

        public BitDescription(int i, int i2, String str, String str2, String[] strArr, String[] strArr2) {
            this.mask = i;
            this.shift = i2;
            this.name = str;
            this.shortName = str2;
            this.values = strArr;
            this.shortValues = strArr2;
        }

        public BitDescription(int i, String str, String str2) {
            this.mask = i;
            this.shift = -1;
            this.name = str;
            this.shortName = str2;
            this.values = null;
            this.shortValues = null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Counter.class */
    public static abstract class Counter {
        public abstract int getCountLocked(int i);

        public abstract void logState(Printer printer, String str);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$HistoryEventTracker.class */
    public static final class HistoryEventTracker {
        private final HashMap<String, SparseIntArray>[] mActiveEvents = new HashMap[10];

        public HashMap<String, SparseIntArray> getStateForEvent(int i) {
            return this.mActiveEvents[i];
        }

        public void removeEvents(int i) {
            this.mActiveEvents[i & HistoryItem.EVENT_TYPE_MASK] = null;
        }

        public boolean updateState(int i, String str, int i2, int i3) {
            SparseIntArray sparseIntArray;
            int indexOfKey;
            if ((32768 & i) == 0) {
                if ((i & 16384) != 0) {
                    HashMap<String, SparseIntArray> hashMap = this.mActiveEvents[i & HistoryItem.EVENT_TYPE_MASK];
                    if (hashMap == null || (sparseIntArray = hashMap.get(str)) == null || (indexOfKey = sparseIntArray.indexOfKey(i2)) < 0) {
                        return false;
                    }
                    sparseIntArray.removeAt(indexOfKey);
                    if (sparseIntArray.size() <= 0) {
                        hashMap.remove(str);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            int i4 = i & HistoryItem.EVENT_TYPE_MASK;
            HashMap<String, SparseIntArray> hashMap2 = this.mActiveEvents[i4];
            HashMap<String, SparseIntArray> hashMap3 = hashMap2;
            if (hashMap2 == null) {
                hashMap3 = new HashMap<>();
                this.mActiveEvents[i4] = hashMap3;
            }
            SparseIntArray sparseIntArray2 = hashMap3.get(str);
            SparseIntArray sparseIntArray3 = sparseIntArray2;
            if (sparseIntArray2 == null) {
                sparseIntArray3 = new SparseIntArray();
                hashMap3.put(str, sparseIntArray3);
            }
            if (sparseIntArray3.indexOfKey(i2) >= 0) {
                return false;
            }
            sparseIntArray3.put(i2, i3);
            return true;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$HistoryItem.class */
    public static final class HistoryItem implements Parcelable {
        public static final byte CMD_CURRENT_TIME = 5;
        public static final byte CMD_NULL = -1;
        public static final byte CMD_OVERFLOW = 6;
        public static final byte CMD_RESET = 7;
        public static final byte CMD_SHUTDOWN = 8;
        public static final byte CMD_START = 4;
        public static final byte CMD_UPDATE = 0;
        public static final int EVENT_CONNECTIVITY_CHANGED = 9;
        public static final int EVENT_COUNT = 10;
        public static final int EVENT_FLAG_FINISH = 16384;
        public static final int EVENT_FLAG_START = 32768;
        public static final int EVENT_FOREGROUND = 2;
        public static final int EVENT_FOREGROUND_FINISH = 16386;
        public static final int EVENT_FOREGROUND_START = 32770;
        public static final int EVENT_JOB = 6;
        public static final int EVENT_JOB_FINISH = 16390;
        public static final int EVENT_JOB_START = 32774;
        public static final int EVENT_NONE = 0;
        public static final int EVENT_PROC = 1;
        public static final int EVENT_PROC_FINISH = 16385;
        public static final int EVENT_PROC_START = 32769;
        public static final int EVENT_SYNC = 4;
        public static final int EVENT_SYNC_FINISH = 16388;
        public static final int EVENT_SYNC_START = 32772;
        public static final int EVENT_TOP = 3;
        public static final int EVENT_TOP_FINISH = 16387;
        public static final int EVENT_TOP_START = 32771;
        public static final int EVENT_TYPE_MASK = -49153;
        public static final int EVENT_USER_FOREGROUND = 8;
        public static final int EVENT_USER_FOREGROUND_FINISH = 16392;
        public static final int EVENT_USER_FOREGROUND_START = 32776;
        public static final int EVENT_USER_RUNNING = 7;
        public static final int EVENT_USER_RUNNING_FINISH = 16391;
        public static final int EVENT_USER_RUNNING_START = 32775;
        public static final int EVENT_WAKE_LOCK = 5;
        public static final int EVENT_WAKE_LOCK_FINISH = 16389;
        public static final int EVENT_WAKE_LOCK_START = 32773;
        public static final int MOST_INTERESTING_STATES = 1900544;
        public static final int MOST_INTERESTING_STATES2 = -1879048192;
        public static final int STATE2_FLASHLIGHT_FLAG = 134217728;
        public static final int STATE2_LOW_POWER_FLAG = Integer.MIN_VALUE;
        public static final int STATE2_VIDEO_ON_FLAG = 1073741824;
        public static final int STATE2_WIFI_ON_FLAG = 268435456;
        public static final int STATE2_WIFI_RUNNING_FLAG = 536870912;
        public static final int STATE2_WIFI_SIGNAL_STRENGTH_MASK = 112;
        public static final int STATE2_WIFI_SIGNAL_STRENGTH_SHIFT = 4;
        public static final int STATE2_WIFI_SUPPL_STATE_MASK = 15;
        public static final int STATE2_WIFI_SUPPL_STATE_SHIFT = 0;
        public static final int STATE_AUDIO_ON_FLAG = 4194304;
        public static final int STATE_BATTERY_PLUGGED_FLAG = 524288;
        public static final int STATE_BLUETOOTH_ON_FLAG = 65536;
        public static final int STATE_BRIGHTNESS_MASK = 7;
        public static final int STATE_BRIGHTNESS_SHIFT = 0;
        public static final int STATE_CPU_RUNNING_FLAG = Integer.MIN_VALUE;
        public static final int STATE_DATA_CONNECTION_MASK = 15872;
        public static final int STATE_DATA_CONNECTION_SHIFT = 9;
        public static final int STATE_GPS_ON_FLAG = 536870912;
        public static final int STATE_MOBILE_RADIO_ACTIVE_FLAG = 33554432;
        public static final int STATE_PHONE_IN_CALL_FLAG = 262144;
        public static final int STATE_PHONE_SCANNING_FLAG = 2097152;
        public static final int STATE_PHONE_SIGNAL_STRENGTH_MASK = 56;
        public static final int STATE_PHONE_SIGNAL_STRENGTH_SHIFT = 3;
        public static final int STATE_PHONE_STATE_MASK = 448;
        public static final int STATE_PHONE_STATE_SHIFT = 6;
        public static final int STATE_SCREEN_ON_FLAG = 1048576;
        public static final int STATE_SENSOR_ON_FLAG = 8388608;
        public static final int STATE_WAKE_LOCK_FLAG = 1073741824;
        public static final int STATE_WIFI_FULL_LOCK_FLAG = 268435456;
        public static final int STATE_WIFI_MULTICAST_ON_FLAG = 67108864;
        public static final int STATE_WIFI_SCAN_FLAG = 134217728;
        public byte batteryHealth;
        public byte batteryLevel;
        public byte batteryPlugType;
        public byte batteryStatus;
        public short batteryTemperature;
        public char batteryVoltage;
        public byte cmd;
        public long currentTime;
        public int eventCode;
        public HistoryTag eventTag;
        public final HistoryTag localEventTag;
        public final HistoryTag localWakeReasonTag;
        public final HistoryTag localWakelockTag;
        public HistoryItem next;
        public int numReadInts;
        public int states;
        public int states2;
        public long time;
        public HistoryTag wakeReasonTag;
        public HistoryTag wakelockTag;

        public HistoryItem() {
            this.cmd = (byte) -1;
            this.localWakelockTag = new HistoryTag();
            this.localWakeReasonTag = new HistoryTag();
            this.localEventTag = new HistoryTag();
        }

        public HistoryItem(long j, Parcel parcel) {
            this.cmd = (byte) -1;
            this.localWakelockTag = new HistoryTag();
            this.localWakeReasonTag = new HistoryTag();
            this.localEventTag = new HistoryTag();
            this.time = j;
            this.numReadInts = 2;
            readFromParcel(parcel);
        }

        private void setToCommon(HistoryItem historyItem) {
            this.batteryLevel = historyItem.batteryLevel;
            this.batteryStatus = historyItem.batteryStatus;
            this.batteryHealth = historyItem.batteryHealth;
            this.batteryPlugType = historyItem.batteryPlugType;
            this.batteryTemperature = historyItem.batteryTemperature;
            this.batteryVoltage = historyItem.batteryVoltage;
            this.states = historyItem.states;
            this.states2 = historyItem.states2;
            if (historyItem.wakelockTag != null) {
                this.wakelockTag = this.localWakelockTag;
                this.wakelockTag.setTo(historyItem.wakelockTag);
            } else {
                this.wakelockTag = null;
            }
            if (historyItem.wakeReasonTag != null) {
                this.wakeReasonTag = this.localWakeReasonTag;
                this.wakeReasonTag.setTo(historyItem.wakeReasonTag);
            } else {
                this.wakeReasonTag = null;
            }
            this.eventCode = historyItem.eventCode;
            if (historyItem.eventTag != null) {
                this.eventTag = this.localEventTag;
                this.eventTag.setTo(historyItem.eventTag);
            } else {
                this.eventTag = null;
            }
            this.currentTime = historyItem.currentTime;
        }

        public void clear() {
            this.time = 0L;
            this.cmd = (byte) -1;
            this.batteryLevel = (byte) 0;
            this.batteryStatus = (byte) 0;
            this.batteryHealth = (byte) 0;
            this.batteryPlugType = (byte) 0;
            this.batteryTemperature = (short) 0;
            this.batteryVoltage = (char) 0;
            this.states = 0;
            this.states2 = 0;
            this.wakelockTag = null;
            this.wakeReasonTag = null;
            this.eventCode = 0;
            this.eventTag = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isDeltaData() {
            return this.cmd == 0;
        }

        public void readFromParcel(Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            int readInt = parcel.readInt();
            this.cmd = (byte) (readInt & 255);
            this.batteryLevel = (byte) ((readInt >> 8) & 255);
            this.batteryStatus = (byte) ((readInt >> 16) & 15);
            this.batteryHealth = (byte) ((readInt >> 20) & 15);
            this.batteryPlugType = (byte) ((readInt >> 24) & 15);
            int readInt2 = parcel.readInt();
            this.batteryTemperature = (short) (readInt2 & 65535);
            this.batteryVoltage = (char) ((readInt2 >> 16) & 65535);
            this.states = parcel.readInt();
            this.states2 = parcel.readInt();
            if ((268435456 & readInt) != 0) {
                this.wakelockTag = this.localWakelockTag;
                this.wakelockTag.readFromParcel(parcel);
            } else {
                this.wakelockTag = null;
            }
            if ((536870912 & readInt) != 0) {
                this.wakeReasonTag = this.localWakeReasonTag;
                this.wakeReasonTag.readFromParcel(parcel);
            } else {
                this.wakeReasonTag = null;
            }
            if ((1073741824 & readInt) != 0) {
                this.eventCode = parcel.readInt();
                this.eventTag = this.localEventTag;
                this.eventTag.readFromParcel(parcel);
            } else {
                this.eventCode = 0;
                this.eventTag = null;
            }
            if (this.cmd == 5 || this.cmd == 7) {
                this.currentTime = parcel.readLong();
            } else {
                this.currentTime = 0L;
            }
            this.numReadInts += (parcel.dataPosition() - dataPosition) / 4;
        }

        public boolean same(HistoryItem historyItem) {
            if (sameNonEvent(historyItem) && this.eventCode == historyItem.eventCode) {
                if (this.wakelockTag == historyItem.wakelockTag || !(this.wakelockTag == null || historyItem.wakelockTag == null || !this.wakelockTag.equals(historyItem.wakelockTag))) {
                    if (this.wakeReasonTag == historyItem.wakeReasonTag || !(this.wakeReasonTag == null || historyItem.wakeReasonTag == null || !this.wakeReasonTag.equals(historyItem.wakeReasonTag))) {
                        if (this.eventTag != historyItem.eventTag) {
                            return (this.eventTag == null || historyItem.eventTag == null || !this.eventTag.equals(historyItem.eventTag)) ? false : true;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public boolean sameNonEvent(HistoryItem historyItem) {
            return this.batteryLevel == historyItem.batteryLevel && this.batteryStatus == historyItem.batteryStatus && this.batteryHealth == historyItem.batteryHealth && this.batteryPlugType == historyItem.batteryPlugType && this.batteryTemperature == historyItem.batteryTemperature && this.batteryVoltage == historyItem.batteryVoltage && this.states == historyItem.states && this.states2 == historyItem.states2 && this.currentTime == historyItem.currentTime;
        }

        public void setTo(long j, byte b, HistoryItem historyItem) {
            this.time = j;
            this.cmd = b;
            setToCommon(historyItem);
        }

        public void setTo(HistoryItem historyItem) {
            this.time = historyItem.time;
            this.cmd = historyItem.cmd;
            setToCommon(historyItem);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            parcel.writeLong(this.time);
            byte b = this.cmd;
            byte b2 = this.batteryLevel;
            byte b3 = this.batteryStatus;
            byte b4 = this.batteryHealth;
            byte b5 = this.batteryPlugType;
            int i3 = this.wakelockTag != null ? 268435456 : 0;
            int i4 = this.wakeReasonTag != null ? 536870912 : 0;
            if (this.eventCode != 0) {
                i2 = 1073741824;
            }
            parcel.writeInt(i4 | ((b5 << 24) & 251658240) | (b & 255) | ((b2 << 8) & 65280) | ((b3 << 16) & SurfaceControl.FX_SURFACE_MASK) | ((b4 << 20) & 15728640) | i3 | i2);
            parcel.writeInt((this.batteryTemperature & 65535) | ((this.batteryVoltage << 16) & (-65536)));
            parcel.writeInt(this.states);
            parcel.writeInt(this.states2);
            if (this.wakelockTag != null) {
                this.wakelockTag.writeToParcel(parcel, i);
            }
            if (this.wakeReasonTag != null) {
                this.wakeReasonTag.writeToParcel(parcel, i);
            }
            if (this.eventCode != 0) {
                parcel.writeInt(this.eventCode);
                this.eventTag.writeToParcel(parcel, i);
            }
            if (this.cmd == 5 || this.cmd == 7) {
                parcel.writeLong(this.currentTime);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$HistoryPrinter.class */
    public static class HistoryPrinter {
        int oldState = 0;
        int oldState2 = 0;
        int oldLevel = -1;
        int oldStatus = -1;
        int oldHealth = -1;
        int oldPlug = -1;
        int oldTemp = -1;
        int oldVolt = -1;
        long lastTime = -1;

        public void printNextItem(PrintWriter printWriter, HistoryItem historyItem, long j, boolean z, boolean z2) {
            if (z) {
                printWriter.print(9);
                printWriter.print(',');
                printWriter.print("h");
                printWriter.print(',');
                if (this.lastTime < 0) {
                    printWriter.print(historyItem.time - j);
                } else {
                    printWriter.print(historyItem.time - this.lastTime);
                }
                this.lastTime = historyItem.time;
            } else {
                printWriter.print("  ");
                TimeUtils.formatDuration(historyItem.time - j, printWriter, 19);
                printWriter.print(" (");
                printWriter.print(historyItem.numReadInts);
                printWriter.print(") ");
            }
            if (historyItem.cmd == 4) {
                if (z) {
                    printWriter.print(":");
                }
                printWriter.println("START");
                reset();
            } else if (historyItem.cmd == 5 || historyItem.cmd == 7) {
                if (z) {
                    printWriter.print(":");
                }
                if (historyItem.cmd == 7) {
                    printWriter.print("RESET:");
                    reset();
                }
                printWriter.print("TIME:");
                if (z) {
                    printWriter.println(historyItem.currentTime);
                    return;
                }
                printWriter.print(" ");
                printWriter.println(DateFormat.format("yyyy-MM-dd-HH-mm-ss", historyItem.currentTime).toString());
            } else if (historyItem.cmd == 8) {
                if (z) {
                    printWriter.print(":");
                }
                printWriter.println("SHUTDOWN");
            } else if (historyItem.cmd == 6) {
                if (z) {
                    printWriter.print(":");
                }
                printWriter.println("*OVERFLOW*");
            } else {
                if (!z) {
                    if (historyItem.batteryLevel < 10) {
                        printWriter.print("00");
                    } else if (historyItem.batteryLevel < 100) {
                        printWriter.print("0");
                    }
                    printWriter.print((int) historyItem.batteryLevel);
                    if (z2) {
                        printWriter.print(" ");
                        if (historyItem.states >= 0) {
                            if (historyItem.states < 16) {
                                printWriter.print("0000000");
                            } else if (historyItem.states < 256) {
                                printWriter.print("000000");
                            } else if (historyItem.states < 4096) {
                                printWriter.print("00000");
                            } else if (historyItem.states < 65536) {
                                printWriter.print("0000");
                            } else if (historyItem.states < 1048576) {
                                printWriter.print("000");
                            } else if (historyItem.states < 16777216) {
                                printWriter.print("00");
                            } else if (historyItem.states < 268435456) {
                                printWriter.print("0");
                            }
                        }
                        printWriter.print(Integer.toHexString(historyItem.states));
                    }
                } else if (this.oldLevel != historyItem.batteryLevel) {
                    this.oldLevel = historyItem.batteryLevel;
                    printWriter.print(",Bl=");
                    printWriter.print((int) historyItem.batteryLevel);
                }
                if (this.oldStatus != historyItem.batteryStatus) {
                    this.oldStatus = historyItem.batteryStatus;
                    printWriter.print(z ? ",Bs=" : " status=");
                    switch (this.oldStatus) {
                        case 1:
                            printWriter.print(z ? "?" : "unknown");
                            break;
                        case 2:
                            printWriter.print(z ? "c" : UsbManager.USB_FUNCTION_CHARGING);
                            break;
                        case 3:
                            printWriter.print(z ? "d" : "discharging");
                            break;
                        case 4:
                            printWriter.print(z ? "n" : "not-charging");
                            break;
                        case 5:
                            printWriter.print(z ? FullBackup.DATA_TREE_TOKEN : com.anythink.expressad.d.a.b.ax);
                            break;
                        default:
                            printWriter.print(this.oldStatus);
                            break;
                    }
                }
                if (this.oldHealth != historyItem.batteryHealth) {
                    this.oldHealth = historyItem.batteryHealth;
                    printWriter.print(z ? ",Bh=" : " health=");
                    switch (this.oldHealth) {
                        case 1:
                            printWriter.print(z ? "?" : "unknown");
                            break;
                        case 2:
                            printWriter.print(z ? OapsKey.KEY_GRADE : "good");
                            break;
                        case 3:
                            printWriter.print(z ? "h" : "overheat");
                            break;
                        case 4:
                            printWriter.print(z ? "d" : "dead");
                            break;
                        case 5:
                            printWriter.print(z ? "v" : "over-voltage");
                            break;
                        case 6:
                            printWriter.print(z ? FullBackup.DATA_TREE_TOKEN : "failure");
                            break;
                        case 7:
                            printWriter.print(z ? "c" : "cold");
                            break;
                        default:
                            printWriter.print(this.oldHealth);
                            break;
                    }
                }
                if (this.oldPlug != historyItem.batteryPlugType) {
                    this.oldPlug = historyItem.batteryPlugType;
                    printWriter.print(z ? ",Bp=" : " plug=");
                    switch (this.oldPlug) {
                        case 0:
                            printWriter.print(z ? "n" : "none");
                            break;
                        case 1:
                            printWriter.print(z ? "a" : "ac");
                            break;
                        case 2:
                            printWriter.print(z ? "u" : Context.USB_SERVICE);
                            break;
                        case 3:
                        default:
                            printWriter.print(this.oldPlug);
                            break;
                        case 4:
                            printWriter.print(z ? IAdInterListener.AdReqParam.WIDTH : "wireless");
                            break;
                    }
                }
                if (this.oldTemp != historyItem.batteryTemperature) {
                    this.oldTemp = historyItem.batteryTemperature;
                    printWriter.print(z ? ",Bt=" : " temp=");
                    printWriter.print(this.oldTemp);
                }
                if (this.oldVolt != historyItem.batteryVoltage) {
                    this.oldVolt = historyItem.batteryVoltage;
                    printWriter.print(z ? ",Bv=" : " volt=");
                    printWriter.print(this.oldVolt);
                }
                BatteryStats.printBitDescriptions(printWriter, this.oldState, historyItem.states, historyItem.wakelockTag, BatteryStats.HISTORY_STATE_DESCRIPTIONS, !z);
                BatteryStats.printBitDescriptions(printWriter, this.oldState2, historyItem.states2, null, BatteryStats.HISTORY_STATE2_DESCRIPTIONS, !z);
                if (historyItem.wakeReasonTag != null) {
                    if (z) {
                        printWriter.print(",wr=");
                        printWriter.print(historyItem.wakeReasonTag.poolIdx);
                    } else {
                        printWriter.print(" wake_reason=");
                        printWriter.print(historyItem.wakeReasonTag.uid);
                        printWriter.print(":\"");
                        printWriter.print(historyItem.wakeReasonTag.string);
                        printWriter.print("\"");
                    }
                }
                if (historyItem.eventCode != 0) {
                    printWriter.print(z ? "," : " ");
                    if ((historyItem.eventCode & 32768) != 0) {
                        printWriter.print("+");
                    } else if ((historyItem.eventCode & 16384) != 0) {
                        printWriter.print(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                    String[] strArr = z ? BatteryStats.HISTORY_EVENT_CHECKIN_NAMES : BatteryStats.HISTORY_EVENT_NAMES;
                    int i = historyItem.eventCode & HistoryItem.EVENT_TYPE_MASK;
                    if (i < 0 || i >= strArr.length) {
                        printWriter.print(z ? "Ev" : "event");
                        printWriter.print(i);
                    } else {
                        printWriter.print(strArr[i]);
                    }
                    printWriter.print("=");
                    if (z) {
                        printWriter.print(historyItem.eventTag.poolIdx);
                    } else {
                        UserHandle.formatUid(printWriter, historyItem.eventTag.uid);
                        printWriter.print(":\"");
                        printWriter.print(historyItem.eventTag.string);
                        printWriter.print("\"");
                    }
                }
                printWriter.println();
                this.oldState = historyItem.states;
                this.oldState2 = historyItem.states2;
            }
        }

        void reset() {
            this.oldState2 = 0;
            this.oldState = 0;
            this.oldLevel = -1;
            this.oldStatus = -1;
            this.oldHealth = -1;
            this.oldPlug = -1;
            this.oldTemp = -1;
            this.oldVolt = -1;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$HistoryTag.class */
    public static final class HistoryTag {
        public int poolIdx;
        public String string;
        public int uid;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HistoryTag historyTag = (HistoryTag) obj;
            return this.uid == historyTag.uid && this.string.equals(historyTag.string);
        }

        public int hashCode() {
            return (this.string.hashCode() * 31) + this.uid;
        }

        public void readFromParcel(Parcel parcel) {
            this.string = parcel.readString();
            this.uid = parcel.readInt();
            this.poolIdx = -1;
        }

        public void setTo(HistoryTag historyTag) {
            this.string = historyTag.string;
            this.uid = historyTag.uid;
            this.poolIdx = historyTag.poolIdx;
        }

        public void setTo(String str, int i) {
            this.string = str;
            this.uid = i;
            this.poolIdx = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.string);
            parcel.writeInt(this.uid);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$LongCounter.class */
    public static abstract class LongCounter {
        public abstract long getCountLocked(int i);

        public abstract void logState(Printer printer, String str);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Timer.class */
    public static abstract class Timer {
        public abstract int getCountLocked(int i);

        public abstract long getTotalTimeLocked(long j, int i);

        public abstract void logState(Printer printer, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$TimerEntry.class */
    public static final class TimerEntry {
        final int mId;
        final String mName;
        final long mTime;
        final Timer mTimer;

        TimerEntry(String str, int i, Timer timer, long j) {
            this.mName = str;
            this.mId = i;
            this.mTimer = timer;
            this.mTime = j;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Uid.class */
    public static abstract class Uid {
        public static final int NUM_PROCESS_STATE = 3;
        public static final int NUM_USER_ACTIVITY_TYPES = 3;
        public static final int NUM_WIFI_BATCHED_SCAN_BINS = 5;
        public static final int PROCESS_STATE_ACTIVE = 1;
        public static final int PROCESS_STATE_FOREGROUND = 0;
        public static final int PROCESS_STATE_RUNNING = 2;
        static final String[] PROCESS_STATE_NAMES = {"Foreground", "Active", "Running"};
        static final String[] USER_ACTIVITY_TYPES = {"other", "button", "touch"};

        /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Uid$Pid.class */
        public class Pid {
            public int mWakeNesting;
            public long mWakeStartMs;
            public long mWakeSumMs;

            public Pid() {
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Uid$Pkg.class */
        public static abstract class Pkg {

            /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Uid$Pkg$Serv.class */
            public abstract class Serv {
                public Serv() {
                }

                public abstract int getLaunches(int i);

                public abstract long getStartTime(long j, int i);

                public abstract int getStarts(int i);
            }

            public abstract Map<String, ? extends Serv> getServiceStats();

            public abstract int getWakeups(int i);
        }

        /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Uid$Proc.class */
        public static abstract class Proc {

            /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Uid$Proc$ExcessivePower.class */
            public static class ExcessivePower {
                public static final int TYPE_CPU = 2;
                public static final int TYPE_WAKE = 1;
                public long overTime;
                public int type;
                public long usedTime;
            }

            public abstract int countExcessivePowers();

            public abstract ExcessivePower getExcessivePower(int i);

            public abstract long getForegroundTime(int i);

            public abstract int getNumAnrs(int i);

            public abstract int getNumCrashes(int i);

            public abstract int getStarts(int i);

            public abstract long getSystemTime(int i);

            public abstract long getTimeAtCpuSpeedStep(int i, int i2);

            public abstract long getUserTime(int i);

            public abstract boolean isActive();
        }

        /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Uid$Sensor.class */
        public static abstract class Sensor {
            public static final int GPS = -10000;

            public abstract int getHandle();

            public abstract Timer getSensorTime();
        }

        /* loaded from: source-9557208-dex2jar.jar:android/os/BatteryStats$Uid$Wakelock.class */
        public static abstract class Wakelock {
            public abstract Timer getWakeTime(int i);
        }

        public abstract long getAudioTurnedOnTime(long j, int i);

        public abstract Timer getForegroundActivityTimer();

        public abstract long getFullWifiLockTime(long j, int i);

        public abstract Map<String, ? extends Timer> getJobStats();

        public abstract int getMobileRadioActiveCount(int i);

        public abstract long getMobileRadioActiveTime(int i);

        public abstract long getNetworkActivityBytes(int i, int i2);

        public abstract long getNetworkActivityPackets(int i, int i2);

        public abstract Map<String, ? extends Pkg> getPackageStats();

        public abstract SparseArray<? extends Pid> getPidStats();

        public abstract long getProcessStateTime(int i, long j, int i2);

        public abstract Map<String, ? extends Proc> getProcessStats();

        public abstract SparseArray<? extends Sensor> getSensorStats();

        public abstract Map<String, ? extends Timer> getSyncStats();

        public abstract int getUid();

        public abstract int getUserActivityCount(int i, int i2);

        public abstract Timer getVibratorOnTimer();

        public abstract long getVideoTurnedOnTime(long j, int i);

        public abstract Map<String, ? extends Wakelock> getWakelockStats();

        public abstract long getWifiBatchedScanTime(int i, long j, int i2);

        public abstract long getWifiMulticastTime(long j, int i);

        public abstract long getWifiRunningTime(long j, int i);

        public abstract long getWifiScanTime(long j, int i);

        public abstract boolean hasNetworkActivity();

        public abstract boolean hasUserActivity();

        public abstract void noteActivityPausedLocked(long j);

        public abstract void noteActivityResumedLocked(long j);

        public abstract void noteFullWifiLockAcquiredLocked(long j);

        public abstract void noteFullWifiLockReleasedLocked(long j);

        public abstract void noteUserActivityLocked(int i);

        public abstract void noteWifiBatchedScanStartedLocked(int i, long j);

        public abstract void noteWifiBatchedScanStoppedLocked(long j);

        public abstract void noteWifiMulticastDisabledLocked(long j);

        public abstract void noteWifiMulticastEnabledLocked(long j);

        public abstract void noteWifiRunningLocked(long j);

        public abstract void noteWifiScanStartedLocked(long j);

        public abstract void noteWifiScanStoppedLocked(long j);

        public abstract void noteWifiStoppedLocked(long j);
    }

    private static long computeWakeLock(Timer timer, long j, int i) {
        if (timer != null) {
            return (500 + timer.getTotalTimeLocked(j, i)) / 1000;
        }
        return 0L;
    }

    private static boolean dumpDurationSteps(PrintWriter printWriter, String str, long[] jArr, int i, boolean z) {
        if (i <= 0) {
            return false;
        }
        if (!z) {
            printWriter.println(str);
        }
        String[] strArr = new String[4];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return true;
            }
            long j = jArr[i3] & STEP_LEVEL_TIME_MASK;
            int i4 = (int) ((jArr[i3] & STEP_LEVEL_LEVEL_MASK) >> 40);
            long j2 = (jArr[i3] & STEP_LEVEL_INITIAL_MODE_MASK) >> 48;
            long j3 = (jArr[i3] & STEP_LEVEL_MODIFIED_MODE_MASK) >> 56;
            if (z) {
                strArr[0] = Long.toString(j);
                strArr[1] = Integer.toString(i4);
                if ((3 & j3) == 0) {
                    switch (((int) (3 & j2)) + 1) {
                        case 1:
                            strArr[2] = "s-";
                            break;
                        case 2:
                            strArr[2] = "s+";
                            break;
                        case 3:
                            strArr[2] = "sd";
                            break;
                        case 4:
                            strArr[2] = "sds";
                            break;
                        default:
                            strArr[1] = "?";
                            break;
                    }
                } else {
                    strArr[2] = "";
                }
                if ((4 & j3) == 0) {
                    strArr[3] = (4 & j2) != 0 ? "p+" : "p-";
                } else {
                    strArr[3] = "";
                }
                dumpLine(printWriter, 0, "i", str, strArr);
            } else {
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                TimeUtils.formatDuration(j, printWriter);
                printWriter.print(" to ");
                printWriter.print(i4);
                boolean z2 = false;
                if ((3 & j3) == 0) {
                    printWriter.print(" (");
                    switch (((int) (3 & j2)) + 1) {
                        case 1:
                            printWriter.print("screen-off");
                            break;
                        case 2:
                            printWriter.print("screen-on");
                            break;
                        case 3:
                            printWriter.print("screen-doze");
                            break;
                        case 4:
                            printWriter.print("screen-doze-suspend");
                            break;
                        default:
                            strArr[1] = "screen-?";
                            break;
                    }
                    z2 = true;
                }
                boolean z3 = z2;
                if ((4 & j3) == 0) {
                    printWriter.print(z2 ? ", " : " (");
                    printWriter.print((4 & j2) != 0 ? "power-save-on" : "power-save-off");
                    z3 = true;
                }
                if (z3) {
                    printWriter.print(")");
                }
                printWriter.println();
            }
            i2 = i3 + 1;
        }
    }

    private void dumpHistoryLocked(PrintWriter printWriter, int i, long j, boolean z) {
        HistoryPrinter historyPrinter = new HistoryPrinter();
        HistoryItem historyItem = new HistoryItem();
        long j2 = -1;
        long j3 = -1;
        boolean z2 = false;
        HistoryEventTracker historyEventTracker = null;
        while (getNextHistoryLocked(historyItem)) {
            long j4 = historyItem.time;
            long j5 = j3;
            if (j3 < 0) {
                j5 = j4;
            }
            j3 = j5;
            j2 = j4;
            if (historyItem.time >= j) {
                boolean z3 = z2;
                HistoryEventTracker historyEventTracker2 = historyEventTracker;
                if (j >= 0) {
                    z3 = z2;
                    historyEventTracker2 = historyEventTracker;
                    if (!z2) {
                        if (historyItem.cmd == 5 || historyItem.cmd == 7 || historyItem.cmd == 4 || historyItem.cmd == 8) {
                            z2 = true;
                            historyPrinter.printNextItem(printWriter, historyItem, j5, z, (i & 16) != 0);
                            historyItem.cmd = (byte) 0;
                        } else if (historyItem.currentTime != 0) {
                            z2 = true;
                            byte b = historyItem.cmd;
                            historyItem.cmd = (byte) 5;
                            historyPrinter.printNextItem(printWriter, historyItem, j5, z, (i & 16) != 0);
                            historyItem.cmd = b;
                        }
                        z3 = z2;
                        historyEventTracker2 = historyEventTracker;
                        if (historyEventTracker != null) {
                            if (historyItem.cmd != 0) {
                                historyPrinter.printNextItem(printWriter, historyItem, j5, z, (i & 16) != 0);
                                historyItem.cmd = (byte) 0;
                            }
                            int i2 = historyItem.eventCode;
                            HistoryTag historyTag = historyItem.eventTag;
                            historyItem.eventTag = new HistoryTag();
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= 10) {
                                    break;
                                }
                                HashMap<String, SparseIntArray> stateForEvent = historyEventTracker.getStateForEvent(i4);
                                if (stateForEvent != null) {
                                    for (Map.Entry<String, SparseIntArray> entry : stateForEvent.entrySet()) {
                                        SparseIntArray value = entry.getValue();
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 < value.size()) {
                                                historyItem.eventCode = i4;
                                                historyItem.eventTag.string = entry.getKey();
                                                historyItem.eventTag.uid = value.keyAt(i6);
                                                historyItem.eventTag.poolIdx = value.valueAt(i6);
                                                historyPrinter.printNextItem(printWriter, historyItem, j5, z, (i & 16) != 0);
                                                historyItem.wakeReasonTag = null;
                                                historyItem.wakelockTag = null;
                                                i5 = i6 + 1;
                                            }
                                        }
                                    }
                                }
                                i3 = i4 + 1;
                            }
                            historyItem.eventCode = i2;
                            historyItem.eventTag = historyTag;
                            historyEventTracker2 = null;
                            z3 = z2;
                        }
                    }
                }
                historyPrinter.printNextItem(printWriter, historyItem, j5, z, (i & 16) != 0);
                j3 = j5;
                j2 = j4;
                z2 = z3;
                historyEventTracker = historyEventTracker2;
            }
        }
        if (j >= 0) {
            commitCurrentHistoryBatchLocked();
            printWriter.print(z ? "NEXT: " : "  NEXT: ");
            printWriter.println(1 + j2);
        }
    }

    private static final void dumpLine(PrintWriter printWriter, int i, String str, String str2, Object... objArr) {
        printWriter.print(9);
        printWriter.print(',');
        printWriter.print(i);
        printWriter.print(',');
        printWriter.print(str);
        printWriter.print(',');
        printWriter.print(str2);
        int length = objArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                printWriter.println();
                return;
            }
            Object obj = objArr[i3];
            printWriter.print(',');
            printWriter.print(obj);
            i2 = i3 + 1;
        }
    }

    private static boolean dumpTimeEstimate(PrintWriter printWriter, String str, long[] jArr, int i, long j, long j2) {
        if (i <= 0) {
            return false;
        }
        long j3 = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            long j4 = jArr[i3];
            int i4 = i2;
            long j5 = j3;
            if ((((jArr[i3] & STEP_LEVEL_MODIFIED_MODE_MASK) >> 56) & j) == 0) {
                i4 = i2;
                j5 = j3;
                if ((((j4 & STEP_LEVEL_INITIAL_MODE_MASK) >> 48) & j) == j2) {
                    i4 = i2 + 1;
                    j5 = j3 + (jArr[i3] & STEP_LEVEL_TIME_MASK);
                }
            }
            i3++;
            i2 = i4;
            j3 = j5;
        }
        if (i2 <= 0) {
            return false;
        }
        printWriter.print(str);
        StringBuilder sb = new StringBuilder(64);
        formatTimeMs(sb, (j3 / i2) * 100);
        printWriter.print(sb);
        printWriter.println();
        return true;
    }

    public static final void formatTime(StringBuilder sb, long j) {
        long j2 = j / 100;
        formatTimeRaw(sb, j2);
        sb.append((j - (100 * j2)) * 10);
        sb.append("ms ");
    }

    public static final void formatTimeMs(StringBuilder sb, long j) {
        long j2 = j / 1000;
        formatTimeRaw(sb, j2);
        sb.append(j - (1000 * j2));
        sb.append("ms ");
    }

    public static final void formatTimeMsNoSpace(StringBuilder sb, long j) {
        long j2 = j / 1000;
        formatTimeRaw(sb, j2);
        sb.append(j - (1000 * j2));
        sb.append("ms");
    }

    private static final void formatTimeRaw(StringBuilder sb, long j) {
        long j2 = j / 86400;
        if (j2 != 0) {
            sb.append(j2);
            sb.append("d ");
        }
        long j3 = 60 * j2 * 60 * 24;
        long j4 = (j - j3) / com.anythink.expressad.d.a.b.P;
        if (j4 != 0 || j3 != 0) {
            sb.append(j4);
            sb.append("h ");
        }
        long j5 = j3 + (60 * j4 * 60);
        long j6 = (j - j5) / 60;
        if (j6 != 0 || j5 != 0) {
            sb.append(j6);
            sb.append("m ");
        }
        long j7 = j5 + (60 * j6);
        if (j == 0 && j7 == 0) {
            return;
        }
        sb.append(j - j7);
        sb.append("s ");
    }

    static void printBitDescriptions(PrintWriter printWriter, int i, int i2, HistoryTag historyTag, BitDescription[] bitDescriptionArr, boolean z) {
        int i3 = i ^ i2;
        if (i3 == 0) {
            return;
        }
        boolean z2 = false;
        int i4 = 0;
        while (i4 < bitDescriptionArr.length) {
            BitDescription bitDescription = bitDescriptionArr[i4];
            boolean z3 = z2;
            if ((bitDescription.mask & i3) != 0) {
                printWriter.print(z ? " " : ",");
                if (bitDescription.shift < 0) {
                    printWriter.print((bitDescription.mask & i2) != 0 ? "+" : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    printWriter.print(z ? bitDescription.name : bitDescription.shortName);
                    z3 = z2;
                    if (bitDescription.mask == 1073741824) {
                        z3 = z2;
                        if (historyTag != null) {
                            z3 = true;
                            printWriter.print("=");
                            if (z) {
                                UserHandle.formatUid(printWriter, historyTag.uid);
                                printWriter.print(":\"");
                                printWriter.print(historyTag.string);
                                printWriter.print("\"");
                            } else {
                                printWriter.print(historyTag.poolIdx);
                            }
                        }
                    }
                } else {
                    printWriter.print(z ? bitDescription.name : bitDescription.shortName);
                    printWriter.print("=");
                    int i5 = (bitDescription.mask & i2) >> bitDescription.shift;
                    if (bitDescription.values == null || i5 < 0 || i5 >= bitDescription.values.length) {
                        printWriter.print(i5);
                        z3 = z2;
                    } else {
                        printWriter.print(z ? bitDescription.values[i5] : bitDescription.shortValues[i5]);
                        z3 = z2;
                    }
                }
            }
            i4++;
            z2 = z3;
        }
        if (z2 || historyTag == null) {
            return;
        }
        printWriter.print(z ? " wake_lock=" : ",w=");
        if (!z) {
            printWriter.print(historyTag.poolIdx);
            return;
        }
        UserHandle.formatUid(printWriter, historyTag.uid);
        printWriter.print(":\"");
        printWriter.print(historyTag.string);
        printWriter.print("\"");
    }

    private void printSizeValue(PrintWriter printWriter, long j) {
        float f = (float) j;
        String str = "";
        float f2 = f;
        if (f >= 10240.0f) {
            str = "KB";
            f2 = f / 1024.0f;
        }
        float f3 = f2;
        if (f2 >= 10240.0f) {
            str = "MB";
            f3 = f2 / 1024.0f;
        }
        float f4 = f3;
        if (f3 >= 10240.0f) {
            str = "GB";
            f4 = f3 / 1024.0f;
        }
        float f5 = f4;
        if (f4 >= 10240.0f) {
            str = "TB";
            f5 = f4 / 1024.0f;
        }
        float f6 = f5;
        if (f5 >= 10240.0f) {
            str = "PB";
            f6 = f5 / 1024.0f;
        }
        printWriter.print((int) f6);
        printWriter.print(str);
    }

    private static final String printWakeLock(StringBuilder sb, Timer timer, long j, String str, int i, String str2) {
        String str3 = str2;
        if (timer != null) {
            long computeWakeLock = computeWakeLock(timer, j, i);
            int countLocked = timer.getCountLocked(i);
            str3 = str2;
            if (computeWakeLock != 0) {
                sb.append(str2);
                formatTimeMs(sb, computeWakeLock);
                if (str != null) {
                    sb.append(str);
                    sb.append(' ');
                }
                sb.append('(');
                sb.append(countLocked);
                sb.append(" times)");
                str3 = ", ";
            }
        }
        return str3;
    }

    private static final String printWakeLockCheckin(StringBuilder sb, Timer timer, long j, String str, int i, String str2) {
        long j2 = 0;
        int i2 = 0;
        if (timer != null) {
            j2 = timer.getTotalTimeLocked(j, i);
            i2 = timer.getCountLocked(i);
        }
        sb.append(str2);
        sb.append((500 + j2) / 1000);
        sb.append(',');
        sb.append(str != null ? str + "," : "");
        sb.append(i2);
        return ",";
    }

    private void printmAh(PrintWriter printWriter, double d) {
        printWriter.print(BatteryStatsHelper.makemAh(d));
    }

    public abstract void commitCurrentHistoryBatchLocked();

    public abstract long computeBatteryRealtime(long j, int i);

    public abstract long computeBatteryScreenOffRealtime(long j, int i);

    public abstract long computeBatteryScreenOffUptime(long j, int i);

    public abstract long computeBatteryTimeRemaining(long j);

    public abstract long computeBatteryUptime(long j, int i);

    public abstract long computeChargeTimeRemaining(long j);

    public abstract long computeRealtime(long j, int i);

    public abstract long computeUptime(long j, int i);

    public final void dumpCheckinLocked(Context context, PrintWriter printWriter, int i, int i2) {
        dumpCheckinLocked(context, printWriter, i, i2, BatteryStatsHelper.checkWifiOnly(context));
    }

    public final void dumpCheckinLocked(Context context, PrintWriter printWriter, int i, int i2, boolean z) {
        String str;
        long uptimeMillis = SystemClock.uptimeMillis() * 1000;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long batteryUptime = getBatteryUptime(uptimeMillis);
        long computeBatteryUptime = computeBatteryUptime(uptimeMillis, i);
        long computeBatteryRealtime = computeBatteryRealtime(elapsedRealtime, i);
        long computeBatteryScreenOffUptime = computeBatteryScreenOffUptime(uptimeMillis, i);
        long computeBatteryScreenOffRealtime = computeBatteryScreenOffRealtime(elapsedRealtime, i);
        long computeRealtime = computeRealtime(elapsedRealtime, i);
        long computeUptime = computeUptime(uptimeMillis, i);
        long screenOnTime = getScreenOnTime(elapsedRealtime, i);
        long interactiveTime = getInteractiveTime(elapsedRealtime, i);
        long lowPowerModeEnabledTime = getLowPowerModeEnabledTime(elapsedRealtime, i);
        int numConnectivityChange = getNumConnectivityChange(i);
        long phoneOnTime = getPhoneOnTime(elapsedRealtime, i);
        long wifiOnTime = getWifiOnTime(elapsedRealtime, i);
        long globalWifiRunningTime = getGlobalWifiRunningTime(elapsedRealtime, i);
        long bluetoothOnTime = getBluetoothOnTime(elapsedRealtime, i);
        StringBuilder sb = new StringBuilder(128);
        SparseArray<? extends Uid> uidStats = getUidStats();
        int size = uidStats.size();
        String str2 = STAT_NAMES[i];
        dumpLine(printWriter, 0, str2, BATTERY_DATA, i == 0 ? Integer.valueOf(getStartCount()) : "N/A", Long.valueOf(computeBatteryRealtime / 1000), Long.valueOf(computeBatteryUptime / 1000), Long.valueOf(computeRealtime / 1000), Long.valueOf(computeUptime / 1000), Long.valueOf(getStartClockTime()), Long.valueOf(computeBatteryScreenOffRealtime / 1000), Long.valueOf(computeBatteryScreenOffUptime / 1000));
        long j = 0;
        long j2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Map<String, ? extends Uid.Wakelock> wakelockStats = uidStats.valueAt(i3).getWakelockStats();
            long j3 = j;
            long j4 = j2;
            if (wakelockStats.size() > 0) {
                Iterator<Map.Entry<String, ? extends Uid.Wakelock>> it = wakelockStats.entrySet().iterator();
                while (true) {
                    j3 = j;
                    j4 = j2;
                    if (it.hasNext()) {
                        Uid.Wakelock value = it.next().getValue();
                        Timer wakeTime = value.getWakeTime(1);
                        long j5 = j;
                        if (wakeTime != null) {
                            j5 = j + wakeTime.getTotalTimeLocked(elapsedRealtime, i);
                        }
                        Timer wakeTime2 = value.getWakeTime(0);
                        j = j5;
                        if (wakeTime2 != null) {
                            j2 += wakeTime2.getTotalTimeLocked(elapsedRealtime, i);
                            j = j5;
                        }
                    }
                }
            }
            i3++;
            j = j3;
            j2 = j4;
        }
        long networkActivityBytes = getNetworkActivityBytes(0, i);
        long networkActivityBytes2 = getNetworkActivityBytes(1, i);
        long networkActivityBytes3 = getNetworkActivityBytes(2, i);
        long networkActivityBytes4 = getNetworkActivityBytes(3, i);
        dumpLine(printWriter, 0, str2, GLOBAL_NETWORK_DATA, Long.valueOf(networkActivityBytes), Long.valueOf(networkActivityBytes2), Long.valueOf(networkActivityBytes3), Long.valueOf(networkActivityBytes4), Long.valueOf(getNetworkActivityPackets(0, i)), Long.valueOf(getNetworkActivityPackets(1, i)), Long.valueOf(getNetworkActivityPackets(2, i)), Long.valueOf(getNetworkActivityPackets(3, i)));
        dumpLine(printWriter, 0, str2, "m", Long.valueOf(screenOnTime / 1000), Long.valueOf(phoneOnTime / 1000), Long.valueOf(wifiOnTime / 1000), Long.valueOf(globalWifiRunningTime / 1000), Long.valueOf(bluetoothOnTime / 1000), Long.valueOf(networkActivityBytes), Long.valueOf(networkActivityBytes2), Long.valueOf(networkActivityBytes3), Long.valueOf(networkActivityBytes4), Long.valueOf(j / 1000), Long.valueOf(j2 / 1000), 0, Long.valueOf(getMobileRadioActiveTime(elapsedRealtime, i) / 1000), Long.valueOf(getMobileRadioActiveAdjustedTime(i) / 1000), Long.valueOf(interactiveTime / 1000), Long.valueOf(lowPowerModeEnabledTime / 1000), Integer.valueOf(numConnectivityChange));
        Object[] objArr = new Object[5];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 5) {
                break;
            }
            objArr[i5] = Long.valueOf(getScreenBrightnessTime(i5, elapsedRealtime, i) / 1000);
            i4 = i5 + 1;
        }
        dumpLine(printWriter, 0, str2, "br", objArr);
        Object[] objArr2 = new Object[5];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= 5) {
                break;
            }
            objArr2[i7] = Long.valueOf(getPhoneSignalStrengthTime(i7, elapsedRealtime, i) / 1000);
            i6 = i7 + 1;
        }
        dumpLine(printWriter, 0, str2, SIGNAL_STRENGTH_TIME_DATA, objArr2);
        dumpLine(printWriter, 0, str2, SIGNAL_SCANNING_TIME_DATA, Long.valueOf(getPhoneSignalScanningTime(elapsedRealtime, i) / 1000));
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= 5) {
                break;
            }
            objArr2[i9] = Integer.valueOf(getPhoneSignalStrengthCount(i9, i));
            i8 = i9 + 1;
        }
        dumpLine(printWriter, 0, str2, SIGNAL_STRENGTH_COUNT_DATA, objArr2);
        Object[] objArr3 = new Object[17];
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= 17) {
                break;
            }
            objArr3[i11] = Long.valueOf(getPhoneDataConnectionTime(i11, elapsedRealtime, i) / 1000);
            i10 = i11 + 1;
        }
        dumpLine(printWriter, 0, str2, DATA_CONNECTION_TIME_DATA, objArr3);
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 >= 17) {
                break;
            }
            objArr3[i13] = Integer.valueOf(getPhoneDataConnectionCount(i13, i));
            i12 = i13 + 1;
        }
        dumpLine(printWriter, 0, str2, DATA_CONNECTION_COUNT_DATA, objArr3);
        Object[] objArr4 = new Object[8];
        int i14 = 0;
        while (true) {
            int i15 = i14;
            if (i15 >= 8) {
                break;
            }
            objArr4[i15] = Long.valueOf(getWifiStateTime(i15, elapsedRealtime, i) / 1000);
            i14 = i15 + 1;
        }
        dumpLine(printWriter, 0, str2, WIFI_STATE_TIME_DATA, objArr4);
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i17 >= 8) {
                break;
            }
            objArr4[i17] = Integer.valueOf(getWifiStateCount(i17, i));
            i16 = i17 + 1;
        }
        dumpLine(printWriter, 0, str2, WIFI_STATE_COUNT_DATA, objArr4);
        Object[] objArr5 = new Object[13];
        int i18 = 0;
        while (true) {
            int i19 = i18;
            if (i19 >= 13) {
                break;
            }
            objArr5[i19] = Long.valueOf(getWifiSupplStateTime(i19, elapsedRealtime, i) / 1000);
            i18 = i19 + 1;
        }
        dumpLine(printWriter, 0, str2, WIFI_SUPPL_STATE_TIME_DATA, objArr5);
        int i20 = 0;
        while (true) {
            int i21 = i20;
            if (i21 >= 13) {
                break;
            }
            objArr5[i21] = Integer.valueOf(getWifiSupplStateCount(i21, i));
            i20 = i21 + 1;
        }
        dumpLine(printWriter, 0, str2, WIFI_SUPPL_STATE_COUNT_DATA, objArr5);
        Object[] objArr6 = new Object[5];
        int i22 = 0;
        while (true) {
            int i23 = i22;
            if (i23 >= 5) {
                break;
            }
            objArr6[i23] = Long.valueOf(getWifiSignalStrengthTime(i23, elapsedRealtime, i) / 1000);
            i22 = i23 + 1;
        }
        dumpLine(printWriter, 0, str2, WIFI_SIGNAL_STRENGTH_TIME_DATA, objArr6);
        int i24 = 0;
        while (true) {
            int i25 = i24;
            if (i25 >= 5) {
                break;
            }
            objArr6[i25] = Integer.valueOf(getWifiSignalStrengthCount(i25, i));
            i24 = i25 + 1;
        }
        dumpLine(printWriter, 0, str2, WIFI_SIGNAL_STRENGTH_COUNT_DATA, objArr6);
        Object[] objArr7 = new Object[4];
        int i26 = 0;
        while (true) {
            int i27 = i26;
            if (i27 >= 4) {
                break;
            }
            objArr7[i27] = Long.valueOf(getBluetoothStateTime(i27, elapsedRealtime, i) / 1000);
            i26 = i27 + 1;
        }
        dumpLine(printWriter, 0, str2, BLUETOOTH_STATE_TIME_DATA, objArr7);
        int i28 = 0;
        while (true) {
            int i29 = i28;
            if (i29 >= 4) {
                break;
            }
            objArr7[i29] = Integer.valueOf(getBluetoothStateCount(i29, i));
            i28 = i29 + 1;
        }
        dumpLine(printWriter, 0, str2, BLUETOOTH_STATE_COUNT_DATA, objArr7);
        if (i == 2) {
            dumpLine(printWriter, 0, str2, BATTERY_LEVEL_DATA, Integer.valueOf(getDischargeStartLevel()), Integer.valueOf(getDischargeCurrentLevel()));
        }
        if (i == 2) {
            dumpLine(printWriter, 0, str2, "dc", Integer.valueOf(getDischargeStartLevel() - getDischargeCurrentLevel()), Integer.valueOf(getDischargeStartLevel() - getDischargeCurrentLevel()), Integer.valueOf(getDischargeAmountScreenOn()), Integer.valueOf(getDischargeAmountScreenOff()));
        } else {
            dumpLine(printWriter, 0, str2, "dc", Integer.valueOf(getLowDischargeAmountSinceCharge()), Integer.valueOf(getHighDischargeAmountSinceCharge()), Integer.valueOf(getDischargeAmountScreenOnSinceCharge()), Integer.valueOf(getDischargeAmountScreenOffSinceCharge()));
        }
        if (i2 < 0) {
            Map<String, ? extends Timer> kernelWakelockStats = getKernelWakelockStats();
            if (kernelWakelockStats.size() > 0) {
                for (Map.Entry<String, ? extends Timer> entry : kernelWakelockStats.entrySet()) {
                    sb.setLength(0);
                    printWakeLockCheckin(sb, entry.getValue(), elapsedRealtime, null, i, "");
                    dumpLine(printWriter, 0, str2, KERNEL_WAKELOCK_DATA, entry.getKey(), sb.toString());
                }
            }
            Map<String, ? extends Timer> wakeupReasonStats = getWakeupReasonStats();
            if (wakeupReasonStats.size() > 0) {
                for (Map.Entry<String, ? extends Timer> entry2 : wakeupReasonStats.entrySet()) {
                    dumpLine(printWriter, 0, str2, WAKEUP_REASON_DATA, "\"" + entry2.getKey() + "\"", Long.valueOf((500 + entry2.getValue().getTotalTimeLocked(elapsedRealtime, i)) / 1000), Integer.valueOf(entry2.getValue().getCountLocked(i)));
                }
            }
        }
        BatteryStatsHelper batteryStatsHelper = new BatteryStatsHelper(context, false, z);
        batteryStatsHelper.create(this);
        batteryStatsHelper.refreshStats(i, -1);
        List usageList = batteryStatsHelper.getUsageList();
        if (usageList != null && usageList.size() > 0) {
            dumpLine(printWriter, 0, str2, POWER_USE_SUMMARY_DATA, BatteryStatsHelper.makemAh(batteryStatsHelper.getPowerProfile().getBatteryCapacity()), BatteryStatsHelper.makemAh(batteryStatsHelper.getComputedPower()), BatteryStatsHelper.makemAh(batteryStatsHelper.getMinDrainedPower()), BatteryStatsHelper.makemAh(batteryStatsHelper.getMaxDrainedPower()));
            int i30 = 0;
            while (true) {
                int i31 = i30;
                if (i31 < usageList.size()) {
                    BatterySipper batterySipper = (BatterySipper) usageList.get(i31);
                    int i32 = 0;
                    switch (AnonymousClass2.$SwitchMap$com$android$internal$os$BatterySipper$DrainType[batterySipper.drainType.ordinal()]) {
                        case 1:
                            str = "idle";
                            break;
                        case 2:
                            str = "cell";
                            break;
                        case 3:
                            str = "phone";
                            break;
                        case 4:
                            str = "wifi";
                            break;
                        case 5:
                            str = "blue";
                            break;
                        case 6:
                            str = "scrn";
                            break;
                        case 7:
                            str = "flashlight";
                            break;
                        case 8:
                            i32 = batterySipper.uidObj.getUid();
                            str = "uid";
                            break;
                        case 9:
                            i32 = UserHandle.getUid(batterySipper.userId, 0);
                            str = "user";
                            break;
                        case 10:
                            str = "unacc";
                            break;
                        case 11:
                            str = "over";
                            break;
                        default:
                            str = "???";
                            break;
                    }
                    dumpLine(printWriter, i32, str2, POWER_USE_ITEM_DATA, str, BatteryStatsHelper.makemAh(batterySipper.value));
                    i30 = i31 + 1;
                }
            }
        }
        int i33 = 0;
        while (true) {
            int i34 = i33;
            if (i34 >= size) {
                return;
            }
            int keyAt = uidStats.keyAt(i34);
            if (i2 < 0 || keyAt == i2) {
                Uid valueAt = uidStats.valueAt(i34);
                long networkActivityBytes5 = valueAt.getNetworkActivityBytes(0, i);
                long networkActivityBytes6 = valueAt.getNetworkActivityBytes(1, i);
                long networkActivityBytes7 = valueAt.getNetworkActivityBytes(2, i);
                long networkActivityBytes8 = valueAt.getNetworkActivityBytes(3, i);
                long networkActivityPackets = valueAt.getNetworkActivityPackets(0, i);
                long networkActivityPackets2 = valueAt.getNetworkActivityPackets(1, i);
                long mobileRadioActiveTime = valueAt.getMobileRadioActiveTime(i);
                int mobileRadioActiveCount = valueAt.getMobileRadioActiveCount(i);
                long networkActivityPackets3 = valueAt.getNetworkActivityPackets(2, i);
                long networkActivityPackets4 = valueAt.getNetworkActivityPackets(3, i);
                long fullWifiLockTime = valueAt.getFullWifiLockTime(elapsedRealtime, i);
                long wifiScanTime = valueAt.getWifiScanTime(elapsedRealtime, i);
                long wifiRunningTime = valueAt.getWifiRunningTime(elapsedRealtime, i);
                if (networkActivityBytes5 > 0 || networkActivityBytes6 > 0 || networkActivityBytes7 > 0 || networkActivityBytes8 > 0 || networkActivityPackets > 0 || networkActivityPackets2 > 0 || networkActivityPackets3 > 0 || networkActivityPackets4 > 0 || mobileRadioActiveTime > 0 || mobileRadioActiveCount > 0) {
                    dumpLine(printWriter, keyAt, str2, "nt", Long.valueOf(networkActivityBytes5), Long.valueOf(networkActivityBytes6), Long.valueOf(networkActivityBytes7), Long.valueOf(networkActivityBytes8), Long.valueOf(networkActivityPackets), Long.valueOf(networkActivityPackets2), Long.valueOf(networkActivityPackets3), Long.valueOf(networkActivityPackets4), Long.valueOf(mobileRadioActiveTime), Integer.valueOf(mobileRadioActiveCount));
                }
                if (fullWifiLockTime != 0 || wifiScanTime != 0 || wifiRunningTime != 0) {
                    dumpLine(printWriter, keyAt, str2, WIFI_DATA, Long.valueOf(fullWifiLockTime), Long.valueOf(wifiScanTime), Long.valueOf(wifiRunningTime));
                }
                if (valueAt.hasUserActivity()) {
                    Object[] objArr8 = new Object[3];
                    boolean z2 = false;
                    int i35 = 0;
                    while (true) {
                        int i36 = i35;
                        if (i36 < 3) {
                            int userActivityCount = valueAt.getUserActivityCount(i36, i);
                            objArr8[i36] = Integer.valueOf(userActivityCount);
                            if (userActivityCount != 0) {
                                z2 = true;
                            }
                            i35 = i36 + 1;
                        } else if (z2) {
                            dumpLine(printWriter, keyAt, str2, "ua", objArr8);
                        }
                    }
                }
                Map<String, ? extends Uid.Wakelock> wakelockStats2 = valueAt.getWakelockStats();
                if (wakelockStats2.size() > 0) {
                    for (Map.Entry<String, ? extends Uid.Wakelock> entry3 : wakelockStats2.entrySet()) {
                        Uid.Wakelock value2 = entry3.getValue();
                        sb.setLength(0);
                        printWakeLockCheckin(sb, value2.getWakeTime(2), elapsedRealtime, IAdInterListener.AdReqParam.WIDTH, i, printWakeLockCheckin(sb, value2.getWakeTime(0), elapsedRealtime, "p", i, printWakeLockCheckin(sb, value2.getWakeTime(1), elapsedRealtime, FullBackup.DATA_TREE_TOKEN, i, "")));
                        if (sb.length() > 0) {
                            String key = entry3.getKey();
                            String str3 = key;
                            if (key.indexOf(44) >= 0) {
                                str3 = key.replace(',', '_');
                            }
                            dumpLine(printWriter, keyAt, str2, "wl", str3, sb.toString());
                        }
                    }
                }
                Map<String, ? extends Timer> syncStats = valueAt.getSyncStats();
                if (syncStats.size() > 0) {
                    for (Map.Entry<String, ? extends Timer> entry4 : syncStats.entrySet()) {
                        Timer value3 = entry4.getValue();
                        long totalTimeLocked = (value3.getTotalTimeLocked(elapsedRealtime, i) + 500) / 1000;
                        int countLocked = value3.getCountLocked(i);
                        if (totalTimeLocked != 0) {
                            dumpLine(printWriter, keyAt, str2, SYNC_DATA, entry4.getKey(), Long.valueOf(totalTimeLocked), Integer.valueOf(countLocked));
                        }
                    }
                }
                Map<String, ? extends Timer> jobStats = valueAt.getJobStats();
                if (jobStats.size() > 0) {
                    for (Map.Entry<String, ? extends Timer> entry5 : jobStats.entrySet()) {
                        Timer value4 = entry5.getValue();
                        long totalTimeLocked2 = (value4.getTotalTimeLocked(elapsedRealtime, i) + 500) / 1000;
                        int countLocked2 = value4.getCountLocked(i);
                        if (totalTimeLocked2 != 0) {
                            dumpLine(printWriter, keyAt, str2, JOB_DATA, entry5.getKey(), Long.valueOf(totalTimeLocked2), Integer.valueOf(countLocked2));
                        }
                    }
                }
                SparseArray<? extends Uid.Sensor> sensorStats = valueAt.getSensorStats();
                int size2 = sensorStats.size();
                int i37 = 0;
                while (true) {
                    int i38 = i37;
                    if (i38 < size2) {
                        Uid.Sensor valueAt2 = sensorStats.valueAt(i38);
                        int keyAt2 = sensorStats.keyAt(i38);
                        Timer sensorTime = valueAt2.getSensorTime();
                        if (sensorTime != null) {
                            long totalTimeLocked3 = (sensorTime.getTotalTimeLocked(elapsedRealtime, i) + 500) / 1000;
                            int countLocked3 = sensorTime.getCountLocked(i);
                            if (totalTimeLocked3 != 0) {
                                dumpLine(printWriter, keyAt, str2, SENSOR_DATA, Integer.valueOf(keyAt2), Long.valueOf(totalTimeLocked3), Integer.valueOf(countLocked3));
                            }
                        }
                        i37 = i38 + 1;
                    } else {
                        Timer vibratorOnTimer = valueAt.getVibratorOnTimer();
                        if (vibratorOnTimer != null) {
                            long totalTimeLocked4 = (vibratorOnTimer.getTotalTimeLocked(elapsedRealtime, i) + 500) / 1000;
                            int countLocked4 = vibratorOnTimer.getCountLocked(i);
                            if (totalTimeLocked4 != 0) {
                                dumpLine(printWriter, keyAt, str2, VIBRATOR_DATA, Long.valueOf(totalTimeLocked4), Integer.valueOf(countLocked4));
                            }
                        }
                        Timer foregroundActivityTimer = valueAt.getForegroundActivityTimer();
                        if (foregroundActivityTimer != null) {
                            long totalTimeLocked5 = (foregroundActivityTimer.getTotalTimeLocked(elapsedRealtime, i) + 500) / 1000;
                            int countLocked5 = foregroundActivityTimer.getCountLocked(i);
                            if (totalTimeLocked5 != 0) {
                                dumpLine(printWriter, keyAt, str2, FOREGROUND_DATA, Long.valueOf(totalTimeLocked5), Integer.valueOf(countLocked5));
                            }
                        }
                        Object[] objArr9 = new Object[3];
                        long j6 = 0;
                        int i39 = 0;
                        while (true) {
                            int i40 = i39;
                            if (i40 < 3) {
                                j6 += valueAt.getProcessStateTime(i40, elapsedRealtime, i);
                                objArr9[i40] = Long.valueOf((500 + j6) / 1000);
                                i39 = i40 + 1;
                            } else {
                                if (j6 > 0) {
                                    dumpLine(printWriter, keyAt, str2, "st", objArr9);
                                }
                                Map<String, ? extends Uid.Proc> processStats = valueAt.getProcessStats();
                                if (processStats.size() > 0) {
                                    for (Map.Entry<String, ? extends Uid.Proc> entry6 : processStats.entrySet()) {
                                        Uid.Proc value5 = entry6.getValue();
                                        long userTime = value5.getUserTime(i) * 10;
                                        long systemTime = value5.getSystemTime(i) * 10;
                                        long foregroundTime = value5.getForegroundTime(i) * 10;
                                        int starts = value5.getStarts(i);
                                        int numCrashes = value5.getNumCrashes(i);
                                        int numAnrs = value5.getNumAnrs(i);
                                        if (userTime != 0 || systemTime != 0 || foregroundTime != 0 || starts != 0 || numAnrs != 0 || numCrashes != 0) {
                                            dumpLine(printWriter, keyAt, str2, "pr", entry6.getKey(), Long.valueOf(userTime), Long.valueOf(systemTime), Long.valueOf(foregroundTime), Integer.valueOf(starts), Integer.valueOf(numAnrs), Integer.valueOf(numCrashes));
                                        }
                                    }
                                }
                                Map<String, ? extends Uid.Pkg> packageStats = valueAt.getPackageStats();
                                if (packageStats.size() > 0) {
                                    for (Map.Entry<String, ? extends Uid.Pkg> entry7 : packageStats.entrySet()) {
                                        Uid.Pkg value6 = entry7.getValue();
                                        int wakeups = value6.getWakeups(i);
                                        for (Map.Entry<String, ? extends Uid.Pkg.Serv> entry8 : value6.getServiceStats().entrySet()) {
                                            Uid.Pkg.Serv value7 = entry8.getValue();
                                            long startTime = value7.getStartTime(batteryUptime, i);
                                            int starts2 = value7.getStarts(i);
                                            int launches = value7.getLaunches(i);
                                            if (startTime != 0 || starts2 != 0 || launches != 0) {
                                                dumpLine(printWriter, keyAt, str2, APK_DATA, Integer.valueOf(wakeups), entry7.getKey(), entry8.getKey(), Long.valueOf(startTime / 1000), Integer.valueOf(starts2), Integer.valueOf(launches));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i33 = i34 + 1;
        }
    }

    public void dumpCheckinLocked(Context context, PrintWriter printWriter, List<ApplicationInfo> list, int i, long j) {
        prepareForDumpLocked();
        dumpLine(printWriter, 0, "i", VERSION_DATA, "12", Integer.valueOf(getParcelVersion()), getStartPlatformVersion(), getEndPlatformVersion());
        getHistoryBaseTime();
        SystemClock.elapsedRealtime();
        boolean z = (i & 7) != 0;
        if (((i & 8) != 0 || (i & 4) != 0) && startIteratingHistoryLocked()) {
            int i2 = 0;
            while (true) {
                try {
                    int i3 = i2;
                    if (i3 >= getHistoryStringPoolSize()) {
                        break;
                    }
                    printWriter.print(9);
                    printWriter.print(',');
                    printWriter.print(HISTORY_STRING_POOL);
                    printWriter.print(',');
                    printWriter.print(i3);
                    printWriter.print(",");
                    printWriter.print(getHistoryTagPoolUid(i3));
                    printWriter.print(",\"");
                    printWriter.print(getHistoryTagPoolString(i3).replace("\\", "\\\\").replace("\"", "\\\""));
                    printWriter.print("\"");
                    printWriter.println();
                    i2 = i3 + 1;
                } finally {
                    finishIteratingHistoryLocked();
                }
            }
            dumpHistoryLocked(printWriter, i, j, true);
        }
        if (z && (i & 3) == 0) {
            return;
        }
        if (list != null) {
            SparseArray sparseArray = new SparseArray();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= list.size()) {
                    break;
                }
                ApplicationInfo applicationInfo = list.get(i5);
                ArrayList arrayList = (ArrayList) sparseArray.get(applicationInfo.uid);
                ArrayList arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList();
                    sparseArray.put(applicationInfo.uid, arrayList2);
                }
                arrayList2.add(applicationInfo.packageName);
                i4 = i5 + 1;
            }
            SparseArray<? extends Uid> uidStats = getUidStats();
            int size = uidStats.size();
            String[] strArr = new String[2];
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= size) {
                    break;
                }
                int keyAt = uidStats.keyAt(i7);
                ArrayList arrayList3 = (ArrayList) sparseArray.get(keyAt);
                if (arrayList3 != null) {
                    int i8 = 0;
                    while (true) {
                        int i9 = i8;
                        if (i9 < arrayList3.size()) {
                            strArr[0] = Integer.toString(keyAt);
                            strArr[1] = (String) arrayList3.get(i9);
                            dumpLine(printWriter, 0, "i", "uid", strArr);
                            i8 = i9 + 1;
                        }
                    }
                }
                i6 = i7 + 1;
            }
        }
        if (!z || (i & 2) != 0) {
            dumpDurationSteps(printWriter, DISCHARGE_STEP_DATA, getDischargeStepDurationsArray(), getNumDischargeStepDurations(), true);
            String[] strArr2 = new String[1];
            long computeBatteryTimeRemaining = computeBatteryTimeRemaining(SystemClock.elapsedRealtime());
            if (computeBatteryTimeRemaining >= 0) {
                strArr2[0] = Long.toString(computeBatteryTimeRemaining);
                dumpLine(printWriter, 0, "i", DISCHARGE_TIME_REMAIN_DATA, strArr2);
            }
            dumpDurationSteps(printWriter, CHARGE_STEP_DATA, getChargeStepDurationsArray(), getNumChargeStepDurations(), true);
            long computeChargeTimeRemaining = computeChargeTimeRemaining(SystemClock.elapsedRealtime());
            if (computeChargeTimeRemaining >= 0) {
                strArr2[0] = Long.toString(computeChargeTimeRemaining);
                dumpLine(printWriter, 0, "i", CHARGE_TIME_REMAIN_DATA, strArr2);
            }
            dumpCheckinLocked(context, printWriter, 0, -1, (i & 32) != 0);
        }
        if (z && (i & 1) == 0) {
            return;
        }
        dumpCheckinLocked(context, printWriter, 2, -1, (i & 32) != 0);
    }

    public void dumpLocked(Context context, PrintWriter printWriter, int i, int i2, long j) {
        prepareForDumpLocked();
        boolean z = (i & 7) != 0;
        if ((i & 4) != 0 || !z) {
            long historyTotalSize = getHistoryTotalSize();
            long historyUsedSize = getHistoryUsedSize();
            if (startIteratingHistoryLocked()) {
                try {
                    printWriter.print("Battery History (");
                    printWriter.print((100 * historyUsedSize) / historyTotalSize);
                    printWriter.print("% used, ");
                    printSizeValue(printWriter, historyUsedSize);
                    printWriter.print(" used of ");
                    printSizeValue(printWriter, historyTotalSize);
                    printWriter.print(", ");
                    printWriter.print(getHistoryStringPoolSize());
                    printWriter.print(" strings using ");
                    printSizeValue(printWriter, getHistoryStringPoolBytes());
                    printWriter.println("):");
                    dumpHistoryLocked(printWriter, i, j, false);
                    printWriter.println();
                } finally {
                    finishIteratingHistoryLocked();
                }
            }
            if (startIteratingOldHistoryLocked()) {
                try {
                    HistoryItem historyItem = new HistoryItem();
                    printWriter.println("Old battery History:");
                    HistoryPrinter historyPrinter = new HistoryPrinter();
                    long j2 = -1;
                    while (true) {
                        long j3 = j2;
                        if (!getNextOldHistoryLocked(historyItem)) {
                            break;
                        }
                        long j4 = j3;
                        if (j3 < 0) {
                            j4 = historyItem.time;
                        }
                        historyPrinter.printNextItem(printWriter, historyItem, j4, false, (i & 16) != 0);
                        j2 = j4;
                    }
                    printWriter.println();
                } finally {
                    finishIteratingOldHistoryLocked();
                }
            }
        }
        if (z && (i & 3) == 0) {
            return;
        }
        if (!z) {
            SparseArray<? extends Uid> uidStats = getUidStats();
            int size = uidStats.size();
            boolean z2 = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i3 = 0;
            while (i3 < size) {
                SparseArray<? extends Uid.Pid> pidStats = uidStats.valueAt(i3).getPidStats();
                boolean z3 = z2;
                if (pidStats != null) {
                    int i4 = 0;
                    while (true) {
                        z3 = z2;
                        if (i4 < pidStats.size()) {
                            Uid.Pid valueAt = pidStats.valueAt(i4);
                            boolean z4 = z2;
                            if (!z2) {
                                printWriter.println("Per-PID Stats:");
                                z4 = true;
                            }
                            long j5 = valueAt.mWakeSumMs;
                            long j6 = valueAt.mWakeNesting > 0 ? elapsedRealtime - valueAt.mWakeStartMs : 0L;
                            printWriter.print("  PID ");
                            printWriter.print(pidStats.keyAt(i4));
                            printWriter.print(" wake time: ");
                            TimeUtils.formatDuration(j5 + j6, printWriter);
                            printWriter.println("");
                            i4++;
                            z2 = z4;
                        }
                    }
                }
                i3++;
                z2 = z3;
            }
            if (z2) {
                printWriter.println();
            }
        }
        if (!z || (i & 2) != 0) {
            if (dumpDurationSteps(printWriter, "Discharge step durations:", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), false)) {
                long computeBatteryTimeRemaining = computeBatteryTimeRemaining(SystemClock.elapsedRealtime());
                if (computeBatteryTimeRemaining >= 0) {
                    printWriter.print("  Estimated discharge time remaining: ");
                    TimeUtils.formatDuration(computeBatteryTimeRemaining / 1000, printWriter);
                    printWriter.println();
                }
                dumpTimeEstimate(printWriter, "  Estimated screen off time: ", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), 7L, 0L);
                dumpTimeEstimate(printWriter, "  Estimated screen off power save time: ", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), 7L, 4L);
                dumpTimeEstimate(printWriter, "  Estimated screen on time: ", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), 7L, 1L);
                dumpTimeEstimate(printWriter, "  Estimated screen on power save time: ", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), 7L, 5L);
                dumpTimeEstimate(printWriter, "  Estimated screen doze time: ", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), 7L, 2L);
                dumpTimeEstimate(printWriter, "  Estimated screen doze power save time: ", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), 7L, 6L);
                dumpTimeEstimate(printWriter, "  Estimated screen doze suspend time: ", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), 7L, 3L);
                dumpTimeEstimate(printWriter, "  Estimated screen doze suspend power save time: ", getDischargeStepDurationsArray(), getNumDischargeStepDurations(), 7L, 7L);
                printWriter.println();
            }
            if (dumpDurationSteps(printWriter, "Charge step durations:", getChargeStepDurationsArray(), getNumChargeStepDurations(), false)) {
                long computeChargeTimeRemaining = computeChargeTimeRemaining(SystemClock.elapsedRealtime());
                if (computeChargeTimeRemaining >= 0) {
                    printWriter.print("  Estimated charge time remaining: ");
                    TimeUtils.formatDuration(computeChargeTimeRemaining / 1000, printWriter);
                    printWriter.println();
                }
                printWriter.println();
            }
            printWriter.println("Statistics since last charge:");
            printWriter.println("  System starts: " + getStartCount() + ", currently on battery: " + getIsOnBattery());
            dumpLocked(context, printWriter, "", 0, i2, (i & 32) != 0);
            printWriter.println();
        }
        if (z && (i & 1) == 0) {
            return;
        }
        printWriter.println("Statistics since last unplugged:");
        dumpLocked(context, printWriter, "", 2, i2, (i & 32) != 0);
    }

    public final void dumpLocked(Context context, PrintWriter printWriter, String str, int i, int i2) {
        dumpLocked(context, printWriter, str, i, i2, BatteryStatsHelper.checkWifiOnly(context));
    }

    /* JADX WARN: Code restructure failed: missing block: B:271:0x193d, code lost:
        if (r24 != 0) goto L322;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void dumpLocked(android.content.Context r10, java.io.PrintWriter r11, java.lang.String r12, int r13, int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 8715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.os.BatteryStats.dumpLocked(android.content.Context, java.io.PrintWriter, java.lang.String, int, int, boolean):void");
    }

    public abstract void finishIteratingHistoryLocked();

    public abstract void finishIteratingOldHistoryLocked();

    final String formatBytesLocked(long j) {
        this.mFormatBuilder.setLength(0);
        if (j < 1024) {
            return j + "B";
        }
        if (j < 1048576) {
            this.mFormatter.format("%.2fKB", Double.valueOf(j / 1024.0d));
            return this.mFormatBuilder.toString();
        } else if (j < 1073741824) {
            this.mFormatter.format("%.2fMB", Double.valueOf(j / 1048576.0d));
            return this.mFormatBuilder.toString();
        } else {
            this.mFormatter.format("%.2fGB", Double.valueOf(j / 1.073741824E9d));
            return this.mFormatBuilder.toString();
        }
    }

    public final String formatRatioLocked(long j, long j2) {
        if (j2 == 0) {
            return "--%";
        }
        this.mFormatBuilder.setLength(0);
        this.mFormatter.format("%.1f%%", Float.valueOf((((float) j) / ((float) j2)) * 100.0f));
        return this.mFormatBuilder.toString();
    }

    public abstract long getBatteryRealtime(long j);

    public abstract long getBatteryUptime(long j);

    public abstract long getBluetoothOnTime(long j, int i);

    public abstract int getBluetoothPingCount();

    public abstract int getBluetoothStateCount(int i, int i2);

    public abstract long getBluetoothStateTime(int i, long j, int i2);

    public abstract long[] getChargeStepDurationsArray();

    public abstract int getCpuSpeedSteps();

    public abstract int getDischargeAmount(int i);

    public abstract int getDischargeAmountScreenOff();

    public abstract int getDischargeAmountScreenOffSinceCharge();

    public abstract int getDischargeAmountScreenOn();

    public abstract int getDischargeAmountScreenOnSinceCharge();

    public abstract int getDischargeCurrentLevel();

    public abstract int getDischargeStartLevel();

    public abstract long[] getDischargeStepDurationsArray();

    public abstract String getEndPlatformVersion();

    public abstract long getFlashlightOnCount(int i);

    public abstract long getFlashlightOnTime(long j, int i);

    public abstract long getGlobalWifiRunningTime(long j, int i);

    public abstract int getHighDischargeAmountSinceCharge();

    public abstract long getHistoryBaseTime();

    public abstract int getHistoryStringPoolBytes();

    public abstract int getHistoryStringPoolSize();

    public abstract String getHistoryTagPoolString(int i);

    public abstract int getHistoryTagPoolUid(int i);

    public abstract int getHistoryTotalSize();

    public abstract int getHistoryUsedSize();

    public abstract long getInteractiveTime(long j, int i);

    public abstract boolean getIsOnBattery();

    public abstract Map<String, ? extends Timer> getKernelWakelockStats();

    public abstract int getLowDischargeAmountSinceCharge();

    public abstract int getLowPowerModeEnabledCount(int i);

    public abstract long getLowPowerModeEnabledTime(long j, int i);

    public abstract long getMobileRadioActiveAdjustedTime(int i);

    public abstract int getMobileRadioActiveCount(int i);

    public abstract long getMobileRadioActiveTime(long j, int i);

    public abstract int getMobileRadioActiveUnknownCount(int i);

    public abstract long getMobileRadioActiveUnknownTime(int i);

    public abstract long getNetworkActivityBytes(int i, int i2);

    public abstract long getNetworkActivityPackets(int i, int i2);

    public abstract boolean getNextHistoryLocked(HistoryItem historyItem);

    public abstract boolean getNextOldHistoryLocked(HistoryItem historyItem);

    public abstract int getNumChargeStepDurations();

    public abstract int getNumConnectivityChange(int i);

    public abstract int getNumDischargeStepDurations();

    public abstract int getParcelVersion();

    public abstract int getPhoneDataConnectionCount(int i, int i2);

    public abstract long getPhoneDataConnectionTime(int i, long j, int i2);

    public abstract int getPhoneOnCount(int i);

    public abstract long getPhoneOnTime(long j, int i);

    public abstract long getPhoneSignalScanningTime(long j, int i);

    public abstract int getPhoneSignalStrengthCount(int i, int i2);

    public abstract long getPhoneSignalStrengthTime(int i, long j, int i2);

    public abstract long getScreenBrightnessTime(int i, long j, int i2);

    public abstract int getScreenOnCount(int i);

    public abstract long getScreenOnTime(long j, int i);

    public abstract long getStartClockTime();

    public abstract int getStartCount();

    public abstract String getStartPlatformVersion();

    public abstract SparseArray<? extends Uid> getUidStats();

    public abstract Map<String, ? extends Timer> getWakeupReasonStats();

    public abstract long getWifiOnTime(long j, int i);

    public abstract int getWifiSignalStrengthCount(int i, int i2);

    public abstract long getWifiSignalStrengthTime(int i, long j, int i2);

    public abstract int getWifiStateCount(int i, int i2);

    public abstract long getWifiStateTime(int i, long j, int i2);

    public abstract int getWifiSupplStateCount(int i, int i2);

    public abstract long getWifiSupplStateTime(int i, long j, int i2);

    public void prepareForDumpLocked() {
    }

    public abstract boolean startIteratingHistoryLocked();

    public abstract boolean startIteratingOldHistoryLocked();

    public abstract void writeToParcelWithoutUids(Parcel parcel, int i);
}
