package com.zego.ve;

import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.opengl.GLES20;
import android.os.BatteryManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/SniffAndroid.class */
public class SniffAndroid {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.zego.ve.SniffAndroid.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            int i = 3;
            while (true) {
                int i2 = i;
                if (i2 >= name.length()) {
                    return true;
                }
                if (!Character.isDigit(name.charAt(i2))) {
                    return false;
                }
                i = i2 + 1;
            }
        }
    };
    private static final List<String> CPU_TEMP_FILE_PATHS = Arrays.asList("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp");
    private static final int DEVICEINFO_UNKNOWN = -1;
    private static String TAG = "SniffAndroid";
    private static ArrayList<CoreFreq> mCoresFreq;
    ProcStat lastProcStat;
    private Context mAppContext = null;
    private String mGpuVendor = "unkown";
    private String mGpuRenderer = "unkown";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/SniffAndroid$CoreFreq.class */
    public static class CoreFreq {
        int cur;
        int max;
        int min;
        int num;

        CoreFreq(int i) {
            this.min = 0;
            this.max = 0;
            this.num = i;
            this.min = SniffAndroid.getMinCpuFreq(i);
            this.max = SniffAndroid.getMaxCpuFreq(i);
        }

        int getCurUsage() {
            int i;
            updateCurFreq();
            int i2 = this.max;
            int i3 = this.min;
            if (i2 - i3 <= 0 || i2 <= 0 || (i = this.cur) <= 0) {
                return 0;
            }
            return ((i - i3) * 100) / (i2 - i3);
        }

        void updateCurFreq() {
            this.cur = SniffAndroid.getCurCpuFreq(this.num);
            if (this.min == 0) {
                this.min = SniffAndroid.getMinCpuFreq(this.num);
            }
            if (this.max == 0) {
                this.max = SniffAndroid.getMaxCpuFreq(this.num);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/SniffAndroid$ProcStat.class */
    public class ProcStat {
        final long idleTime;
        final long runTime;

        ProcStat(long j, long j2) {
            this.runTime = j;
            this.idleTime = j2;
        }
    }

    private static String ExecuteTop() {
        Process process;
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
        } catch (Throwable th) {
            th = th;
            process = null;
        }
        try {
            try {
                process = Runtime.getRuntime().exec("top -n 1");
            } catch (IOException e) {
                try {
                    e.printStackTrace();
                    process = null;
                } catch (IOException e2) {
                    e = e2;
                    process = null;
                    str = null;
                    bufferedReader = null;
                    android.util.Log.e("executeTop", "error in getting first line of top");
                    BufferedReader bufferedReader3 = bufferedReader;
                    e.printStackTrace();
                    try {
                        bufferedReader.close();
                        process.destroy();
                    } catch (IOException e3) {
                        android.util.Log.e("executeTop", "error in closing and destroying top process");
                        e3.printStackTrace();
                    }
                    return str;
                }
            }
            bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String str2 = null;
                while (true) {
                    String str3 = str2;
                    if (str3 != null) {
                        try {
                            if (!str3.contentEquals("")) {
                                try {
                                    bufferedReader.close();
                                    process.destroy();
                                    return str3;
                                } catch (IOException e4) {
                                    android.util.Log.e("executeTop", "error in closing and destroying top process");
                                    e4.printStackTrace();
                                    return str3;
                                }
                            }
                        } catch (IOException e5) {
                            e = e5;
                            str = str3;
                            android.util.Log.e("executeTop", "error in getting first line of top");
                            BufferedReader bufferedReader32 = bufferedReader;
                            e.printStackTrace();
                            bufferedReader.close();
                            process.destroy();
                            return str;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            try {
                                bufferedReader2.close();
                                process.destroy();
                            } catch (IOException e6) {
                                android.util.Log.e("executeTop", "error in closing and destroying top process");
                                e6.printStackTrace();
                            }
                            throw th;
                        }
                    }
                    str2 = bufferedReader.readLine();
                }
            } catch (IOException e7) {
                e = e7;
                str = null;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            process = null;
            th = th3;
            bufferedReader2.close();
            process.destroy();
            throw th;
        }
    }

    private static int ExtractValue(byte[] bArr, int i) {
        int i2;
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i3 = i;
                while (true) {
                    i2 = i3 + 1;
                    if (i2 >= bArr.length || !Character.isDigit(bArr[i2])) {
                        break;
                    }
                    i3 = i2;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    private void GatherGlInfo() {
        this.mGpuVendor = GLES20.glGetString(7936);
        this.mGpuRenderer = GLES20.glGetString(7937);
    }

    private int GetBatteryLevel() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((BatteryManager) this.mAppContext.getSystemService(Context.BATTERY_SERVICE)).getIntProperty(4);
        }
        Intent registerReceiver = new ContextWrapper(this.mAppContext).registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        return (registerReceiver.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) * 100) / registerReceiver.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
    }

    private static int GetCPUMaxFreqKHz() {
        int i;
        int i2;
        int i3;
        try {
            int GetNumberOfCPUCores = GetNumberOfCPUCores();
            int i4 = 0;
            int i5 = -1;
            while (true) {
                i2 = i5;
                if (i4 >= GetNumberOfCPUCores) {
                    break;
                }
                File file = new File("/sys/devices/system/cpu/cpu" + i4 + "/cpufreq/cpuinfo_max_freq");
                int i6 = i2;
                if (file.exists()) {
                    i6 = i2;
                    if (file.canRead()) {
                        byte[] bArr = new byte[128];
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            fileInputStream.read(bArr);
                            int i7 = 0;
                            while (true) {
                                i3 = i7;
                                if (!Character.isDigit(bArr[i3]) || i3 >= 128) {
                                    break;
                                }
                                i7 = i3 + 1;
                            }
                            Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                            i6 = i2;
                            if (valueOf.intValue() > i2) {
                                i6 = valueOf.intValue();
                            }
                        } catch (NumberFormatException e) {
                            i6 = i2;
                        } catch (Throwable th) {
                            fileInputStream.close();
                            throw th;
                        }
                        fileInputStream.close();
                    }
                }
                i4++;
                i5 = i6;
            }
            i = i2;
            if (i2 == -1) {
                FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                int ParseFileForValue = ParseFileForValue("cpu MHz", fileInputStream2) * 1000;
                i = i2;
                if (ParseFileForValue > i2) {
                    i = ParseFileForValue;
                }
                fileInputStream2.close();
            }
        } catch (IOException e2) {
            i = -1;
        }
        android.util.Log.i(TAG, "max freq:" + i);
        return i;
    }

    private static int GetCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    private static int GetCoresFromFileInfo(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException e) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            int GetCoresFromFileString = GetCoresFromFileString(readLine);
            try {
                fileInputStream.close();
                return GetCoresFromFileString;
            } catch (IOException e2) {
                return GetCoresFromFileString;
            }
        } catch (IOException e3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    return -1;
                } catch (IOException e4) {
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th2) {
            fileInputStream2 = fileInputStream;
            th = th2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    private static int GetCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    public static int GetCpuUsage(int[] iArr) {
        int i = 0;
        if (iArr.length < 2) {
            return 0;
        }
        int i2 = 1;
        while (i2 < iArr.length) {
            int i3 = i;
            if (iArr[i2] > 0) {
                i3 = i + iArr[i2];
            }
            i2++;
            i = i3;
        }
        return i / (iArr.length - 1);
    }

    public static int GetCpuUsageBaseTop() {
        try {
            int[] iArr = new int[3];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 3) {
                    break;
                }
                int i3 = 0;
                for (int i4 : GetCpuUsageStatistic()) {
                    i3 += i4;
                }
                iArr[i2] = i3;
                i = i2 + 1;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < 3; i6++) {
                i5 += iArr[i6];
            }
            return i5 / 3;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int[] GetCpuUsageStatistic() {
        String replaceAll = ExecuteTop().replaceAll(",", "").replaceAll("User", "").replaceAll("System", "").replaceAll("IOW", "").replaceAll("IRQ", "").replaceAll("%", "");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                break;
            }
            replaceAll = replaceAll.replaceAll("  ", " ");
            i = i2 + 1;
        }
        String[] split = replaceAll.trim().split(" ");
        int[] iArr = new int[split.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= split.length) {
                return iArr;
            }
            split[i4] = split[i4].trim();
            iArr[i4] = Integer.parseInt(split[i4]);
            i3 = i4 + 1;
        }
    }

    public static int GetNbCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.zego.ve.SniffAndroid.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception e) {
            return 1;
        }
    }

    private static int GetNumberOfCPUCores() {
        int i;
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int GetCoresFromFileInfo = GetCoresFromFileInfo("/sys/devices/system/cpu/possible");
            i = GetCoresFromFileInfo;
            if (GetCoresFromFileInfo == -1) {
                i = GetCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (i == -1) {
                i = GetCoresFromCPUFileList();
            }
        } catch (NullPointerException | SecurityException e) {
            i = -1;
        }
        android.util.Log.i(TAG, "cores:" + i);
        return i;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00b9 -> B:19:0x0090). Please submit an issue!!! */
    private static long GetTotalMemory(Context context) {
        FileInputStream fileInputStream;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            android.util.Log.i(TAG, "total mem:" + memoryInfo.totalMem);
            return memoryInfo.totalMem;
        }
        long j = -1;
        try {
            long ParseFileForValue = ParseFileForValue("MemTotal", fileInputStream) * 1024;
            new FileInputStream("/proc/meminfo").close();
            j = ParseFileForValue;
        } catch (IOException e) {
        }
        android.util.Log.i(TAG, "total mem:" + j);
        return j;
    }

    public static void InitCoresFreq() {
        if (mCoresFreq != null) {
            return;
        }
        int GetNbCores = GetNbCores();
        mCoresFreq = new ArrayList<>();
        byte b = 0;
        while (true) {
            byte b2 = b;
            if (b2 >= GetNbCores) {
                return;
            }
            mCoresFreq.add(new CoreFreq(b2));
            b = (byte) (b2 + 1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0050, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int ParseFileForValue(java.lang.String r4, java.io.FileInputStream r5) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r10 = r0
            r0 = r5
            r1 = r10
            int r0 = r0.read(r1)     // Catch: java.lang.Throwable -> L5a
            r9 = r0
            r0 = 0
            r7 = r0
            goto L5e
        L14:
            r0 = r6
            r8 = r0
            r0 = r7
            r1 = r9
            if (r0 >= r1) goto L50
            r0 = r7
            r1 = r6
            int r0 = r0 - r1
            r8 = r0
            r0 = r10
            r1 = r7
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L5a
            r1 = r4
            r2 = r8
            char r1 = r1.charAt(r2)     // Catch: java.lang.Throwable -> L5a
            if (r0 == r1) goto L35
            r0 = r6
            r8 = r0
            goto L50
        L35:
            r0 = r8
            r1 = r4
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L5a
            r2 = 1
            int r1 = r1 - r2
            if (r0 != r1) goto L49
            r0 = r10
            r1 = r7
            int r0 = ExtractValue(r0, r1)     // Catch: java.lang.Throwable -> L5a
            r6 = r0
            r0 = r6
            return r0
        L49:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L14
        L50:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L5e
        L58:
            r0 = -1
            return r0
        L5a:
            r4 = move-exception
            goto L58
        L5e:
            r0 = r7
            r1 = r9
            if (r0 >= r1) goto L58
            r0 = r10
            r1 = r7
            r0 = r0[r1]
            r1 = 10
            if (r0 == r1) goto L74
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L50
        L74:
            r0 = r7
            r6 = r0
            r0 = r10
            r1 = r7
            r0 = r0[r1]
            r1 = 10
            if (r0 != r1) goto L83
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
        L83:
            r0 = r6
            r7 = r0
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.SniffAndroid.ParseFileForValue(java.lang.String, java.io.FileInputStream):int");
    }

    private ProcStat ReadIdleAndRunTime() {
        try {
            try {
                FileReader fileReader = new FileReader("/proc/stat");
                try {
                    try {
                        Scanner scanner = new Scanner(new BufferedReader(fileReader));
                        scanner.next();
                        long nextLong = scanner.nextLong();
                        long nextLong2 = scanner.nextLong();
                        long nextLong3 = scanner.nextLong();
                        long nextLong4 = scanner.nextLong();
                        scanner.close();
                        fileReader.close();
                        return new ProcStat(nextLong + nextLong2 + nextLong3, nextLong4);
                    } catch (Throwable th) {
                        fileReader.close();
                        throw th;
                    }
                } catch (Exception e) {
                    android.util.Log.e(TAG, "Problems parsing /proc/stat");
                    fileReader.close();
                    return null;
                }
            } catch (IOException e2) {
                android.util.Log.e(TAG, "Problems reading /proc/stat");
                return null;
            }
        } catch (FileNotFoundException e3) {
            android.util.Log.e(TAG, "Cannot open /proc/stat for reading");
            return null;
        }
    }

    private static int ReadIntegerFile(String str) {
        int i = 0;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            int parseInt = Integer.parseInt(randomAccessFile.readLine());
            i = parseInt;
            randomAccessFile.close();
            return parseInt;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    private double ReadOneLine(File file) {
        String str;
        double d = -100000.0d;
        if (file.exists()) {
            if (!file.canRead()) {
                return -100000.0d;
            }
            String str2 = "";
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                str = bufferedReader.readLine();
                fileInputStream.close();
                inputStreamReader.close();
                str2 = str;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                str = str2;
            }
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException e2) {
                return -100000.0d;
            }
        }
        return d;
    }

    public static int[] getCoresUsageGuessFromFreq() {
        int[] iArr;
        synchronized (SniffAndroid.class) {
            try {
                InitCoresFreq();
                iArr = new int[mCoresFreq.size() + 1];
                iArr[0] = 0;
                byte b = 0;
                while (true) {
                    byte b2 = b;
                    if (b2 >= mCoresFreq.size()) {
                        break;
                    }
                    int i = b2 + 1;
                    iArr[i] = mCoresFreq.get(b2).getCurUsage();
                    iArr[0] = iArr[0] + iArr[i];
                    b = (byte) i;
                }
                if (mCoresFreq.size() > 0) {
                    iArr[0] = iArr[0] / mCoresFreq.size();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getCurCpuFreq(int i) {
        return ReadIntegerFile("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getMaxCpuFreq(int i) {
        return ReadIntegerFile("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getMinCpuFreq(int i) {
        return ReadIntegerFile("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq");
    }

    private boolean isEGL14SupportedHere() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private boolean isTemperatureValid(double d) {
        return d >= -30.0d && d <= 250.0d;
    }

    public boolean CheckBackground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return (runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200) ? false : true;
    }

    public int GetBattery() {
        return GetBatteryLevel();
    }

    public int GetCPUClock() {
        return GetCPUMaxFreqKHz();
    }

    public int GetCPUKernel() {
        return GetNumberOfCPUCores();
    }

    public int GetCPUTemperature() {
        double d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= CPU_TEMP_FILE_PATHS.size()) {
                d = 0.0d;
                break;
            }
            String str = CPU_TEMP_FILE_PATHS.get(i2);
            Double valueOf = Double.valueOf(ReadOneLine(new File(str)));
            if (isTemperatureValid(valueOf.doubleValue())) {
                d = valueOf.doubleValue();
                android.util.Log.i(TAG, "getCpuTemperature valid path:" + str);
                break;
            } else if (isTemperatureValid(valueOf.doubleValue() / 1000.0d)) {
                d = valueOf.doubleValue() / 1000.0d;
                android.util.Log.i(TAG, "getCpuTemperature valid path:" + str);
                break;
            } else {
                i = i2 + 1;
            }
        }
        return (int) (d * 1000.0d);
    }

    public String GetCPUVendor() {
        return Build.HARDWARE;
    }

    public int GetCPUsage() {
        return Build.VERSION.SDK_INT < 26 ? SampleCpuUtilization() : GetCpuUsage(getCoresUsageGuessFromFreq());
    }

    public String GetDeviceName() {
        return Build.MODEL;
    }

    public String GetGPURenderer() {
        return this.mGpuRenderer;
    }

    public String GetGPUVendor() {
        return this.mGpuVendor;
    }

    public int GetOsVersion() {
        return Build.VERSION.SDK_INT;
    }

    public int GetRAM() {
        return (int) (GetTotalMemory(this.mAppContext) / 1024);
    }

    public int SampleCpuUtilization() {
        ProcStat ReadIdleAndRunTime = ReadIdleAndRunTime();
        if (ReadIdleAndRunTime == null) {
            return 0;
        }
        long j = ReadIdleAndRunTime.runTime - this.lastProcStat.runTime;
        long j2 = ReadIdleAndRunTime.idleTime;
        long j3 = this.lastProcStat.idleTime;
        this.lastProcStat = ReadIdleAndRunTime;
        long j4 = (j2 - j3) + j;
        return Math.max(0, Math.min(j4 == 0 ? 0 : Math.round((float) ((j * 100) / j4)), 100));
    }

    public int getCPUScore() {
        return 0;
    }

    public boolean initSniff(Context context) {
        this.mAppContext = context;
        this.lastProcStat = new ProcStat(0L, 0L);
        return true;
    }
}
