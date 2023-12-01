package com.tencent.thumbplayer.core.common;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.audiofx.AudioEffect;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bun.miitmdid.core.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPSystemInfo.class */
public class TPSystemInfo {
    public static final int CHIP_ARM_AARCH64 = 7;
    public static final int CHIP_ARM_LATER = 50;
    public static final int CHIP_ARM_V5 = 3;
    public static final int CHIP_ARM_V6 = 4;
    public static final int CHIP_ARM_V7_NENO = 6;
    public static final int CHIP_ARM_V7_NO_NENO = 5;
    public static final int CHIP_MIPS = 2;
    public static final int CHIP_UNKNOW = 0;
    public static final int CHIP_X86 = 1;
    public static final int CPU_HW_HISI = 2;
    public static final int CPU_HW_MTK = 1;
    public static final int CPU_HW_OTHER = -1;
    public static final int CPU_HW_QUALCOMM = 0;
    public static final int CPU_HW_SAMSUNG = 3;
    public static final String KEY_PROPERTY_BOARD = "ro.product.board";
    public static final String KEY_PROPERTY_DEVICE = "ro.product.device";
    public static final String KEY_PROPERTY_MANUFACTURER = "ro.product.manufacturer";
    public static final String KEY_PROPERTY_MODEL = "ro.product.model";
    public static final String KEY_PROPERTY_VERSION_RELEASE = "ro.build.version.release";
    public static final int SDK_INT;
    private static long sAppInstallTime = 0;
    private static int sAudioBestFramesPerBust = 0;
    private static int sAudioBestSampleRate = 0;
    private static int sCpuArchitecture = 0;
    private static int sCpuHWProductIdx = -1;
    private static int sCpuHWProducter = -1;
    private static String sCpuHardware = "";
    private static String sDeviceManufacturer = "";
    private static String sDeviceName = "";
    private static String sFeature = "";
    private static String sOSVersion = "";
    private static String sProcessorName = "N/A";
    private static String sProductBoard = "";
    private static String sProductDevice = "";
    public static int sScreenHeight;
    public static int sScreenWidth;
    private static final String[][] sCpuPerfList = {new String[]{"MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro", "MSM8998", "SDM845", "SM8150", "SM8250", "SM8250-AB", "SM8250-AC", "SM8350", "SM8350-AC", "SM8450"}, new String[]{"MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T", "MT6797X", "MT6771V", "MT6799", "MT6769Z", "MT6785T", "MT6853V", "MT6853V", "MT6873", "MT6874", "MT6875", "MT6877", "MT6885", "MT6889V", "MT6889Z", "MT6891Z", "MT6893", "MT6983"}, new String[]{"K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960", "Kirin970", "Kirin810", "Kirin980", "Kirin820", "Kirin985", "Kirin990", "Kirin9000E", "Kirin9000"}, new String[]{"S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890", "Exynos890", "Exynos8895", "Exynos9810", "Exynos9820", "Exynos9825", "Exynos990", "Exynos1080", "Exynos2100", "Exynos2200"}};
    private static long sMaxCpuFreq = -1;
    private static long sCurrentCpuFreq = -1;
    private static int sNumOfCores = -1;
    private static int sCpuArch = -1;
    private static int sOpenGLVersion = 0;

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String[], java.lang.String[][]] */
    static {
        SDK_INT = (Build.VERSION.SDK_INT == 25 && !TextUtils.isEmpty(Build.VERSION.CODENAME) && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT;
    }

    private static boolean checkPermission(Context context, String str) {
        if (hasMarshmallow()) {
            boolean z = false;
            if (context != null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (Manifest.permission.WRITE_SETTINGS.equals(str)) {
                    return Settings.System.canWrite(context);
                }
                try {
                    z = ContextCompat.checkSelfPermission(context, str) == 0;
                } catch (Exception e) {
                    return false;
                }
            }
            return z;
        }
        return true;
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static int getBestAudioFramesPerBust() {
        return sAudioBestFramesPerBust;
    }

    public static int getBestAudioSampleRate() {
        return sAudioBestSampleRate;
    }

    public static int getCpuArchFromId(int i) {
        if (i != 64) {
            switch (i) {
                case 5:
                    return 3;
                case 6:
                    return 4;
                case 7:
                    return 6;
                case 8:
                case 9:
                case 10:
                    return 7;
                default:
                    return 0;
            }
        }
        return 7;
    }

    public static int getCpuArchitecture() {
        int cpuArchFromId;
        int i = sCpuArch;
        if (-1 != i) {
            return i;
        }
        TPNativeLog.printLog(2, "getCpuArchitecture Build.CPU_ABI: " + Build.CPU_ABI);
        if (Build.CPU_ABI.contains("arm64-v8a")) {
            sCpuArch = 7;
            return 7;
        }
        if (Build.CPU_ABI != null && (Build.CPU_ABI.contains(Utils.CPU_ABI_X86) || Build.CPU_ABI.contains("X86"))) {
            cpuArchFromId = 1;
        } else if (Build.CPU_ABI != null && (Build.CPU_ABI.contains("mips") || Build.CPU_ABI.contains("Mips"))) {
            sCpuArch = 2;
            return sCpuArch;
        } else {
            if (sCpuArchitecture == 0) {
                getCpuInfo();
            }
            TPNativeLog.printLog(2, "getCpuArchitecture mCpuArchitecture:" + sCpuArchitecture);
            if (!TextUtils.isEmpty(sCpuHardware) && sCpuHardware.contains("MSM8994")) {
                sCpuArch = 7;
                return 7;
            } else if (isARMV5Whitelist()) {
                sCpuArch = 3;
                return 3;
            } else if (!TextUtils.isEmpty(sProcessorName) && sProcessorName.contains("ARMv6")) {
                sCpuArch = 4;
                return 4;
            } else if (!TextUtils.isEmpty(sProcessorName) && sProcessorName.contains("AArch64")) {
                sCpuArch = 7;
                return 7;
            } else if (sCpuArchitecture == 7 && !TextUtils.isEmpty(sFeature) && !sFeature.contains("neon") && !sFeature.contains("asimd")) {
                sCpuArch = 4;
                return 4;
            } else {
                cpuArchFromId = getCpuArchFromId(sCpuArchitecture);
            }
        }
        sCpuArch = cpuArchFromId;
        return sCpuArch;
    }

    private static int getCpuHWProducer(String str) {
        if (str.isEmpty()) {
            return -1;
        }
        if (str.contains("Exynos") || str.contains("SMDK") || str.contains("S5L8900") || str.contains("S5PC100")) {
            return 3;
        }
        if (str.contains("Kirin") || str.contains("K3V")) {
            return 2;
        }
        if (str.contains("MSM") || str.contains("APQ") || str.contains("QSD") || str.contains("SDM") || str.contains("SM")) {
            return 0;
        }
        return str.contains("MT6") ? 1 : -1;
    }

    public static int getCpuHWProductIndex(int i, String str) {
        if (i < 0 || i >= sCpuPerfList.length || TextUtils.isEmpty(str)) {
            return -1;
        }
        String[] strArr = sCpuPerfList[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= strArr.length) {
                return -1;
            }
            if (TextUtils.equals(str, strArr[i3])) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public static int getCpuHWProductIndex(String str) {
        int i;
        if (sCpuHWProducter < 0) {
            sCpuHWProducter = getCpuHWProducer(str);
        }
        int i2 = sCpuHWProducter;
        if (i2 >= 0 && sCpuHWProductIdx < 0) {
            String[] strArr = sCpuPerfList[i2];
            int i3 = 0;
            int i4 = -1;
            while (true) {
                i = i4;
                if (i3 >= strArr.length) {
                    break;
                }
                int i5 = i;
                if (str.contains(strArr[i3])) {
                    if (-1 != i) {
                        i5 = i;
                        if (strArr[i3].length() <= strArr[i].length()) {
                        }
                    }
                    i5 = i3;
                }
                i3++;
                i4 = i5;
            }
            sCpuHWProductIdx = i;
        }
        return sCpuHWProductIdx;
    }

    public static int getCpuHWProducter(String str) {
        if (sCpuHWProducter < 0) {
            sCpuHWProducter = getCpuHWProducer(str);
        }
        return sCpuHWProducter;
    }

    public static String getCpuHarewareName() {
        if (TextUtils.isEmpty(sCpuHardware)) {
            getCpuInfo();
        }
        return sCpuHardware;
    }

    public static void getCpuInfo() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                inputStreamReader.close();
                                bufferedReader.close();
                                return;
                            }
                            parseCpuInfoLine(readLine);
                        } catch (Throwable th) {
                            try {
                                sCpuHardware = "Unknown";
                                sCpuArchitecture = 0;
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException e) {
                                        TPNativeLog.printLog(4, e.getMessage());
                                        throw th2;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                inputStreamReader = null;
            }
        } catch (IOException e2) {
            TPNativeLog.printLog(4, e2.getMessage());
        }
    }

    public static long getCurrentCpuFreq() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        long j;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        long j2;
        InputStreamReader inputStreamReader3;
        BufferedReader bufferedReader3;
        long j3;
        InputStreamReader inputStreamReader4;
        BufferedReader bufferedReader4;
        long j4;
        long j5;
        BufferedReader bufferedReader5;
        long j6 = sCurrentCpuFreq;
        if (j6 > 0) {
            return j6;
        }
        try {
            try {
                InputStreamReader inputStreamReader5 = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"), "UTF-8");
                try {
                    bufferedReader5 = new BufferedReader(inputStreamReader5);
                    j = 1024000;
                    j2 = 1024000;
                    j3 = 1024000;
                    j4 = 1024000;
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedReader4 = null;
                    j4 = 1024000;
                    inputStreamReader4 = inputStreamReader5;
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader3 = null;
                    j3 = 1024000;
                    inputStreamReader3 = inputStreamReader5;
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader2 = null;
                    j2 = 1024000;
                    inputStreamReader2 = inputStreamReader5;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                    j = 1024000;
                    inputStreamReader = inputStreamReader5;
                }
                try {
                    String readLine = bufferedReader5.readLine();
                    if (readLine == null) {
                        inputStreamReader5.close();
                        bufferedReader5.close();
                        inputStreamReader5.close();
                        bufferedReader5.close();
                        return 0L;
                    }
                    String trim = readLine.trim();
                    long j7 = 1024000;
                    if (trim.length() > 0) {
                        j7 = Long.parseLong(trim);
                    }
                    long j8 = j7;
                    sCurrentCpuFreq = j7;
                    inputStreamReader5.close();
                    bufferedReader5.close();
                    return j7;
                } catch (FileNotFoundException e4) {
                    e = e4;
                    bufferedReader4 = bufferedReader5;
                    inputStreamReader4 = inputStreamReader5;
                    TPNativeLog.printLog(4, e.getMessage());
                    if (inputStreamReader4 != null) {
                        inputStreamReader4.close();
                    }
                    j5 = j4;
                    if (bufferedReader4 != null) {
                        bufferedReader4.close();
                        return j4;
                    }
                    return j5;
                } catch (IOException e5) {
                    e = e5;
                    bufferedReader3 = bufferedReader5;
                    inputStreamReader3 = inputStreamReader5;
                    TPNativeLog.printLog(4, e.getMessage());
                    if (inputStreamReader3 != null) {
                        inputStreamReader3.close();
                    }
                    j5 = j3;
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                        return j3;
                    }
                    return j5;
                } catch (Exception e6) {
                    e = e6;
                    bufferedReader2 = bufferedReader5;
                    inputStreamReader2 = inputStreamReader5;
                    TPNativeLog.printLog(4, e.getMessage());
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    j5 = j2;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                        return j2;
                    }
                    return j5;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader5;
                    inputStreamReader = inputStreamReader5;
                    TPNativeLog.printLog(4, th.getMessage());
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    j5 = j;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        return j;
                    }
                    return j5;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                inputStreamReader4 = null;
                bufferedReader4 = null;
                j4 = 1024000;
            } catch (IOException e8) {
                e = e8;
                inputStreamReader3 = null;
                bufferedReader3 = null;
                j3 = 1024000;
            } catch (Exception e9) {
                e = e9;
                inputStreamReader2 = null;
                bufferedReader2 = null;
                j2 = 1024000;
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                bufferedReader = null;
                j = 1024000;
            }
        } catch (Throwable th4) {
            TPNativeLog.printLog(4, th4.getMessage());
            return 0L;
        }
    }

    public static String getDeviceManufacturer() {
        if (TextUtils.isEmpty(sDeviceManufacturer)) {
            sDeviceManufacturer = Build.MANUFACTURER;
        }
        return sDeviceManufacturer;
    }

    public static String getDeviceName() {
        String str;
        synchronized (TPSystemInfo.class) {
            try {
                if (TextUtils.isEmpty(sDeviceName)) {
                    sDeviceName = Build.MODEL;
                }
                str = sDeviceName;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x009b: MOVE  (r0 I:??[long, double]) = (r10 I:??[long, double]), block:B:31:0x0092 */
    public static long getMaxCpuFreq() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        long j;
        long j2;
        String readLine;
        long j3 = sMaxCpuFreq;
        if (-1 != j3) {
            return j3;
        }
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"), "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (IOException e) {
                    bufferedReader = null;
                } catch (Throwable th) {
                    bufferedReader = null;
                }
            } catch (IOException e2) {
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                inputStreamReader = null;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException e3) {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                j2 = 0;
                if (bufferedReader != null) {
                    bufferedReader.close();
                    j2 = 0;
                }
                sMaxCpuFreq = j2;
                TPNativeLog.printLog(2, "MaxCpuFreq " + sMaxCpuFreq);
                return j2;
            } catch (Throwable th3) {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                j2 = 0;
                if (bufferedReader != null) {
                    bufferedReader.close();
                    j2 = 0;
                }
                sMaxCpuFreq = j2;
                TPNativeLog.printLog(2, "MaxCpuFreq " + sMaxCpuFreq);
                return j2;
            }
        } catch (IOException e4) {
            TPNativeLog.printLog(4, e4.getMessage());
            j2 = j;
        }
        if (readLine == null) {
            inputStreamReader.close();
            bufferedReader.close();
            try {
                inputStreamReader.close();
                bufferedReader.close();
                return 0L;
            } catch (IOException e5) {
                TPNativeLog.printLog(4, e5.getMessage());
                return 0L;
            }
        }
        String trim = readLine.trim();
        j2 = 0;
        if (trim.length() > 0) {
            j2 = Long.parseLong(trim);
        }
        long j4 = j2;
        inputStreamReader.close();
        long j5 = j2;
        bufferedReader.close();
        sMaxCpuFreq = j2;
        TPNativeLog.printLog(2, "MaxCpuFreq " + sMaxCpuFreq);
        return j2;
    }

    public static int getNumCores() {
        int i = sNumOfCores;
        if (-1 != i) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.thumbplayer.core.common.TPSystemInfo.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            if (listFiles == null) {
                sNumOfCores = 1;
                return 1;
            }
            sNumOfCores = listFiles.length;
            TPNativeLog.printLog(2, "core num " + sNumOfCores);
            return sNumOfCores;
        } catch (Exception e) {
            TPNativeLog.printLog(4, e.getMessage());
            sNumOfCores = 1;
            return 1;
        }
    }

    public static int getOpenGLSupportVersion(Context context) {
        if (sOpenGLVersion == 0) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
                if (activityManager == null) {
                    return sOpenGLVersion;
                }
                sOpenGLVersion = activityManager.getDeviceConfigurationInfo().reqGlEsVersion;
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
            }
        }
        return sOpenGLVersion;
    }

    public static String getOsVersion() {
        if (TextUtils.isEmpty(sOSVersion)) {
            sOSVersion = Build.VERSION.RELEASE;
        }
        return sOSVersion;
    }

    public static String getProductBoard() {
        if (TextUtils.isEmpty(sProductBoard)) {
            sProductBoard = Build.BOARD;
        }
        return sProductBoard;
    }

    public static String getProductDevice() {
        if (TextUtils.isEmpty(sProductDevice)) {
            sProductDevice = Build.DEVICE;
        }
        return sProductDevice;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int i = sScreenHeight;
        if (i != 0) {
            return i;
        }
        try {
            sScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable th) {
            sScreenHeight = 0;
        }
        return sScreenHeight;
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        int i = sScreenWidth;
        if (i != 0) {
            return i;
        }
        try {
            sScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable th) {
            sScreenWidth = 0;
        }
        return sScreenWidth;
    }

    public static int getSystemCpuUsage(String str, String str2) {
        float f;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        try {
            String[] split = str.trim().split("\\s+");
            long systemIdleTime = getSystemIdleTime(split);
            long systemUptime = getSystemUptime(split);
            String[] split2 = str2.trim().split("\\s+");
            long systemIdleTime2 = getSystemIdleTime(split2);
            long systemUptime2 = getSystemUptime(split2);
            f = -1.0f;
            if (systemIdleTime >= 0) {
                f = -1.0f;
                if (systemUptime >= 0) {
                    f = -1.0f;
                    if (systemIdleTime2 >= 0) {
                        f = -1.0f;
                        if (systemUptime2 >= 0) {
                            long j = systemIdleTime2 + systemUptime2;
                            long j2 = systemIdleTime + systemUptime;
                            f = -1.0f;
                            if (j > j2) {
                                f = -1.0f;
                                if (systemUptime2 >= systemUptime) {
                                    f = (((float) (systemUptime2 - systemUptime)) / ((float) (j - j2))) * 100.0f;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            f = -1.0f;
        }
        return (int) f;
    }

    public static long getSystemIdleTime(String[] strArr) {
        try {
            return Long.parseLong(strArr[4]);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static long getSystemUptime(String[] strArr) {
        int i = 1;
        long j = 0;
        while (true) {
            long j2 = j;
            if (i >= strArr.length) {
                return j2;
            }
            long j3 = j2;
            if (4 != i) {
                try {
                    j3 = j2 + Long.parseLong(strArr[i]);
                } catch (Throwable th) {
                    return -1L;
                }
            }
            i++;
            j = j3;
        }
    }

    private static boolean hasMarshmallow() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void initAudioBestSettings(Context context) {
        synchronized (TPSystemInfo.class) {
            if (context != null) {
                try {
                    if (sAudioBestSampleRate <= 0) {
                        if (Build.VERSION.SDK_INT >= 17) {
                            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                            String property = audioManager.getProperty(AudioManager.PROPERTY_OUTPUT_SAMPLE_RATE);
                            String property2 = audioManager.getProperty(AudioManager.PROPERTY_OUTPUT_FRAMES_PER_BUFFER);
                            try {
                                sAudioBestSampleRate = Integer.parseInt(property);
                                sAudioBestFramesPerBust = Integer.parseInt(property2);
                            } catch (NumberFormatException e) {
                                TPNativeLog.printLog(4, e.getMessage());
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean isARMV5Whitelist() {
        return getDeviceName().equals("XT882") || getDeviceName().equals("ME860") || getDeviceName().equals("MB860") || getDeviceName().equals("Lenovo P70") || getDeviceName().equals("Lenovo A60") || getDeviceName().equals("Lenovo A366t");
    }

    private static void parseCpuInfoLine(String str) {
        int indexOf;
        int indexOf2;
        if (str.contains("aarch64") || str.contains("AArch64")) {
            sCpuArchitecture = 64;
        }
        if (str.startsWith("Processor")) {
            int indexOf3 = str.indexOf(58);
            if (indexOf3 > 1) {
                String substring = str.substring(indexOf3 + 1, str.length());
                sProcessorName = substring;
                sProcessorName = substring.trim();
            }
        } else if (str.startsWith("CPU architecture")) {
            if (sCpuArchitecture != 0 || (indexOf2 = str.indexOf(58)) <= 1) {
                return;
            }
            String trim = str.substring(indexOf2 + 1, str.length()).trim();
            if (trim.length() > 0 && trim.length() < 2) {
                sCpuArchitecture = (int) Long.parseLong(trim);
            } else if (trim.length() > 1) {
                sCpuArchitecture = (int) Long.parseLong(trim.substring(0, 1));
            }
        } else if (str.startsWith("Features")) {
            int indexOf4 = str.indexOf(58);
            if (indexOf4 > 1) {
                sFeature = str.substring(indexOf4 + 1, str.length()).trim();
            }
        } else if (!str.startsWith("Hardware") || (indexOf = str.indexOf(58)) <= 1) {
        } else {
            sCpuHardware = str.substring(indexOf + 1, str.length()).trim().replace(" ", "");
            TPNativeLog.printLog(2, "hardware " + sCpuHardware);
            getCpuHWProductIndex(sCpuHardware);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String readStringFromFile(java.io.File r6) {
        /*
            r0 = 0
            r9 = r0
            r0 = 0
            r11 = r0
            r0 = 0
            r10 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L66 java.io.FileNotFoundException -> L7f
            r1 = r0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L66 java.io.FileNotFoundException -> L7f
            r3 = r2
            r4 = r6
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L66 java.io.FileNotFoundException -> L7f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L66 java.io.FileNotFoundException -> L7f
            r8 = r0
            r0 = r10
            r7 = r0
            r0 = r6
            long r0 = r0.length()     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L4b
            r0 = r6
            long r0 = r0.length()     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            int r0 = (int) r0     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            char[] r0 = new char[r0]     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            r11 = r0
            r0 = r10
            r7 = r0
            r0 = r8
            r1 = r11
            r2 = 0
            r3 = r6
            long r3 = r3.length()     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            int r0 = r0.read(r1, r2, r3)     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            if (r0 <= 0) goto L4b
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            r1 = r0
            r2 = r11
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5a java.io.FileNotFoundException -> L60
            r7 = r0
        L4b:
            r0 = r7
            r9 = r0
            r0 = r8
            r0.close()     // Catch: java.lang.Throwable -> L53
            r0 = r7
            return r0
        L53:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
            r0 = r9
            return r0
        L5a:
            r7 = move-exception
            r0 = r8
            r6 = r0
            goto L69
        L60:
            r7 = move-exception
            r0 = r8
            r6 = r0
            goto L83
        L66:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L69:
            r0 = r7
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L77
            r0 = r6
            if (r0 == 0) goto L75
            r0 = r6
            r0.close()     // Catch: java.lang.Throwable -> L53
        L75:
            r0 = 0
            return r0
        L77:
            r8 = move-exception
            r0 = r6
            r7 = r0
            r0 = r8
            r6 = r0
            goto L8a
        L7f:
            r7 = move-exception
            r0 = r11
            r6 = r0
        L83:
            r0 = r7
            throw r0     // Catch: java.lang.Throwable -> L85
        L85:
            r8 = move-exception
            r0 = r6
            r7 = r0
            r0 = r8
            r6 = r0
        L8a:
            r0 = r7
            if (r0 == 0) goto L9a
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L95
            goto L9a
        L95:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L9a:
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPSystemInfo.readStringFromFile(java.io.File):java.lang.String");
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0026: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:10:0x001e */
    public static String readSystemStat() {
        String str;
        RandomAccessFile randomAccessFile;
        try {
            try {
                randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
            }
            try {
                String readLine = randomAccessFile.readLine();
                randomAccessFile.close();
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th3) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th4) {
                            TPNativeLog.printLog(4, th4.getMessage());
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            TPNativeLog.printLog(4, th5.getMessage());
            return str;
        }
    }

    public static void setDeviceName(String str) {
        synchronized (TPSystemInfo.class) {
            try {
                sDeviceName = str;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setProperty(String str, String str2) {
        if (TextUtils.equals(str, KEY_PROPERTY_MODEL)) {
            sDeviceName = str2;
        } else if (TextUtils.equals(str, KEY_PROPERTY_MANUFACTURER)) {
            sDeviceManufacturer = str2;
        } else if (TextUtils.equals(str, KEY_PROPERTY_VERSION_RELEASE)) {
            sOSVersion = str2;
        } else if (TextUtils.equals(str, KEY_PROPERTY_DEVICE)) {
            sProductDevice = str2;
        } else if (TextUtils.equals(str, KEY_PROPERTY_BOARD)) {
            sProductBoard = str2;
        }
    }

    public static boolean supportInDeviceDolbyAudioEffect() {
        boolean z;
        boolean z2;
        int i = 0;
        try {
            AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
            int length = queryEffects.length;
            z = false;
            while (true) {
                z2 = z;
                if (i >= length) {
                    break;
                }
                try {
                    if (queryEffects[i].implementor.contains("Dolby Laboratories")) {
                        z = true;
                    }
                    i++;
                } catch (Exception e) {
                    e = e;
                    TPNativeLog.printLog(4, e.getMessage());
                    z2 = z;
                    return z2;
                }
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        return z2;
    }

    private static void writeStringToFile(String str, String str2) {
        FileWriter fileWriter;
        try {
            File file = new File(str);
            if (file.exists() || !file.createNewFile()) {
                fileWriter = new FileWriter(file, false);
                try {
                    fileWriter.write(str2);
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Throwable th) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            fileWriter = null;
        }
    }
}
