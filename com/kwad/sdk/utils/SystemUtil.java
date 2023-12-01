package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/SystemUtil.class */
public final class SystemUtil {
    private static long aAK;
    private static long aAL;
    private static int aAM;
    private static LEVEL aAN;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/SystemUtil$LEVEL.class */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        int value;

        LEVEL(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/SystemUtil$a.class */
    public static final class a {
        public long aAO;
        public long aAP;
        public long aAQ;
        public long aAR;
        public long aAS;
        public int mThreadsCount;
    }

    public static long EA() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        String readLine;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        return 0L;
                    }
                } catch (Exception e) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue();
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
            return longValue << 10;
        } catch (Exception e2) {
            bufferedReader2 = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static a EB() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String ai;
        a aVar = new a();
        try {
            randomAccessFile = new RandomAccessFile("/proc/self/status", "r");
            while (true) {
                try {
                    String readLine = randomAccessFile.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                        return aVar;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.startsWith("VmSize") && readLine.contains("kB")) {
                            String ai2 = ai(readLine, "VmSize");
                            if (ai2 != null) {
                                aVar.aAP = Long.valueOf(ai2).longValue();
                            }
                        } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                            String ai3 = ai(readLine, "VmRSS:");
                            if (ai3 != null) {
                                aVar.aAQ = Long.valueOf(ai3).longValue();
                            }
                        } else if (readLine.startsWith("Threads:") && (ai = ai(readLine, "Threads:")) != null) {
                            aVar.mThreadsCount = Integer.valueOf(ai).intValue();
                        }
                    }
                } catch (IOException e) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    return aVar;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
        } catch (IOException e2) {
            randomAccessFile = null;
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
        }
    }

    private static String ai(String str, String str2) {
        int i;
        int i2;
        int length = str2.length();
        int i3 = -1;
        while (true) {
            i = i3;
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                i2 = i;
                if (i != -1) {
                    break;
                }
            } else {
                i2 = i;
                if (i == -1) {
                    i2 = length;
                }
            }
            length++;
            i3 = i2;
        }
        if (i == -1) {
            return null;
        }
        return length == -1 ? str.substring(i) : str.substring(i, length);
    }

    public static boolean b(Context context, String... strArr) {
        if (context == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 0) {
                return true;
            }
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
                i = i2 + 1;
            } catch (Exception e) {
                return true;
            }
        }
    }

    public static boolean cO(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return b(context, "android.permission.READ_PHONE_STATE");
    }

    public static long cP(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static boolean ch(int i) {
        return getApiLevel() >= i;
    }

    public static void checkUiThread() {
    }

    private static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getProcessName(Context context) {
        return ap.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return ap.isInMainProcess(context);
    }
}
