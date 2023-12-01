package android.os;

import android.text.TextUtils;
import android.util.Slog;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import dalvik.system.VMRuntime;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/os/Build.class */
public class Build {
    @Deprecated
    public static final String CPU_ABI;
    @Deprecated
    public static final String CPU_ABI2;
    public static final String FINGERPRINT;
    public static final String HOST;
    public static final boolean IS_DEBUGGABLE;
    private static final String TAG = "Build";
    public static final String TAGS;
    public static final long TIME;
    public static final String TYPE;
    public static final String UNKNOWN = "unknown";
    public static final String USER;
    public static final String ID = getString("ro.build.id");
    public static final String DISPLAY = getString("ro.build.display.id");
    public static final String PRODUCT = getString("ro.product.name");
    public static final String DEVICE = getString(TPSystemInfo.KEY_PROPERTY_DEVICE);
    public static final String BOARD = getString(TPSystemInfo.KEY_PROPERTY_BOARD);
    public static final String MANUFACTURER = getString(TPSystemInfo.KEY_PROPERTY_MANUFACTURER);
    public static final String BRAND = getString("ro.product.brand");
    public static final String MODEL = getString(TPSystemInfo.KEY_PROPERTY_MODEL);
    public static final String BOOTLOADER = getString("ro.bootloader");
    @Deprecated
    public static final String RADIO = getString("gsm.version.baseband");
    public static final String HARDWARE = getString("ro.hardware");
    public static final String SERIAL = getString("ro.serialno");
    public static final String[] SUPPORTED_ABIS = getStringList("ro.product.cpu.abilist", ",");
    public static final String[] SUPPORTED_32_BIT_ABIS = getStringList("ro.product.cpu.abilist32", ",");
    public static final String[] SUPPORTED_64_BIT_ABIS = getStringList("ro.product.cpu.abilist64", ",");

    /* loaded from: source-9557208-dex2jar.jar:android/os/Build$VERSION.class */
    public static class VERSION {
        public static final String[] ACTIVE_CODENAMES;
        public static final int RESOURCES_SDK_INT;
        public static final String INCREMENTAL = Build.getString("ro.build.version.incremental");
        public static final String RELEASE = Build.getString(TPSystemInfo.KEY_PROPERTY_VERSION_RELEASE);
        public static final String BASE_OS = SystemProperties.get("ro.build.version.base_os", "");
        public static final String SECURITY_PATCH = SystemProperties.get("ro.build.version.security_patch", "");
        @Deprecated
        public static final String SDK = Build.getString("ro.build.version.sdk");
        public static final int SDK_INT = SystemProperties.getInt("ro.build.version.sdk", 0);
        public static final String CODENAME = Build.getString("ro.build.version.codename");
        private static final String[] ALL_CODENAMES = Build.getStringList("ro.build.version.all_codenames", ",");

        static {
            ACTIVE_CODENAMES = "REL".equals(ALL_CODENAMES[0]) ? new String[0] : ALL_CODENAMES;
            RESOURCES_SDK_INT = SDK_INT + ACTIVE_CODENAMES.length;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/Build$VERSION_CODES.class */
    public static class VERSION_CODES {
        public static final int BASE = 1;
        public static final int BASE_1_1 = 2;
        public static final int CUPCAKE = 3;
        public static final int CUR_DEVELOPMENT = 10000;
        public static final int DONUT = 4;
        public static final int ECLAIR = 5;
        public static final int ECLAIR_0_1 = 6;
        public static final int ECLAIR_MR1 = 7;
        public static final int FROYO = 8;
        public static final int GINGERBREAD = 9;
        public static final int GINGERBREAD_MR1 = 10;
        public static final int HONEYCOMB = 11;
        public static final int HONEYCOMB_MR1 = 12;
        public static final int HONEYCOMB_MR2 = 13;
        public static final int ICE_CREAM_SANDWICH = 14;
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
        public static final int JELLY_BEAN = 16;
        public static final int JELLY_BEAN_MR1 = 17;
        public static final int JELLY_BEAN_MR2 = 18;
        public static final int KITKAT = 19;
        public static final int KITKAT_WATCH = 20;
        public static final int L = 21;
        public static final int LOLLIPOP = 21;
        public static final int LOLLIPOP_MR1 = 22;
    }

    static {
        boolean z = true;
        String[] strArr = VMRuntime.getRuntime().is64Bit() ? SUPPORTED_64_BIT_ABIS : SUPPORTED_32_BIT_ABIS;
        CPU_ABI = strArr[0];
        if (strArr.length > 1) {
            CPU_ABI2 = strArr[1];
        } else {
            CPU_ABI2 = "";
        }
        TYPE = getString("ro.build.type");
        TAGS = getString("ro.build.tags");
        FINGERPRINT = deriveFingerprint();
        TIME = getLong("ro.build.date.utc") * 1000;
        USER = getString("ro.build.user");
        HOST = getString("ro.build.host");
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) {
            z = false;
        }
        IS_DEBUGGABLE = z;
    }

    private static String deriveFingerprint() {
        String str = SystemProperties.get("ro.build.fingerprint");
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = getString("ro.product.brand") + '/' + getString("ro.product.name") + '/' + getString(TPSystemInfo.KEY_PROPERTY_DEVICE) + ':' + getString(TPSystemInfo.KEY_PROPERTY_VERSION_RELEASE) + '/' + getString("ro.build.id") + '/' + getString("ro.build.version.incremental") + ':' + getString("ro.build.type") + '/' + getString("ro.build.tags");
        }
        return str2;
    }

    public static void ensureFingerprintProperty() {
        if (TextUtils.isEmpty(SystemProperties.get("ro.build.fingerprint"))) {
            try {
                SystemProperties.set("ro.build.fingerprint", FINGERPRINT);
            } catch (IllegalArgumentException e) {
                Slog.e(TAG, "Failed to set fingerprint property", e);
            }
        }
    }

    private static long getLong(String str) {
        try {
            return Long.parseLong(SystemProperties.get(str));
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static String getRadioVersion() {
        return SystemProperties.get("gsm.version.baseband", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getString(String str) {
        return SystemProperties.get(str, "unknown");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] getStringList(String str, String str2) {
        String str3 = SystemProperties.get(str);
        return str3.isEmpty() ? new String[0] : str3.split(str2);
    }

    public static boolean isFingerprintConsistent() {
        String str = SystemProperties.get("ro.build.fingerprint");
        String str2 = SystemProperties.get("ro.vendor.build.fingerprint");
        if (TextUtils.isEmpty(str)) {
            Slog.e(TAG, "Required ro.build.fingerprint is empty!");
            return false;
        } else if (TextUtils.isEmpty(str2) || Objects.equals(str, str2)) {
            return true;
        } else {
            Slog.e(TAG, "Mismatched fingerprints; system reported " + str + " but vendor reported " + str2);
            return false;
        }
    }
}
