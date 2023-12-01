package android.os;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.system.Os;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/os/Process.class */
public class Process {
    public static final int BLUETOOTH_UID = 1002;
    public static final int DRM_UID = 1019;
    public static final int FIRST_APPLICATION_UID = 10000;
    public static final int FIRST_ISOLATED_UID = 99000;
    public static final int FIRST_SHARED_APPLICATION_GID = 50000;
    public static final int LAST_APPLICATION_UID = 19999;
    public static final int LAST_ISOLATED_UID = 99999;
    public static final int LAST_SHARED_APPLICATION_GID = 59999;
    private static final String LOG_TAG = "Process";
    public static final int LOG_UID = 1007;
    public static final int MEDIA_RW_GID = 1023;
    public static final int MEDIA_UID = 1013;
    public static final int NFC_UID = 1027;
    public static final int PACKAGE_INFO_GID = 1032;
    public static final int PHONE_UID = 1001;
    public static final int PROC_COMBINE = 256;
    public static final int PROC_OUT_FLOAT = 16384;
    public static final int PROC_OUT_LONG = 8192;
    public static final int PROC_OUT_STRING = 4096;
    public static final int PROC_PARENS = 512;
    public static final int PROC_QUOTES = 1024;
    public static final int PROC_SPACE_TERM = 32;
    public static final int PROC_TAB_TERM = 9;
    public static final int PROC_TERM_MASK = 255;
    public static final int PROC_ZERO_TERM = 0;
    public static final int ROOT_UID = 0;
    public static final int SCHED_BATCH = 3;
    public static final int SCHED_FIFO = 1;
    public static final int SCHED_IDLE = 5;
    public static final int SCHED_OTHER = 0;
    public static final int SCHED_RR = 2;
    public static final String SECONDARY_ZYGOTE_SOCKET = "zygote_secondary";
    public static final int SHARED_RELRO_UID = 1037;
    public static final int SHARED_USER_GID = 9997;
    public static final int SHELL_UID = 2000;
    public static final int SIGNAL_KILL = 9;
    public static final int SIGNAL_QUIT = 3;
    public static final int SIGNAL_USR1 = 10;
    public static final int SYSTEM_UID = 1000;
    public static final int THREAD_GROUP_AUDIO_APP = 3;
    public static final int THREAD_GROUP_AUDIO_SYS = 4;
    public static final int THREAD_GROUP_BG_NONINTERACTIVE = 0;
    public static final int THREAD_GROUP_DEFAULT = -1;
    private static final int THREAD_GROUP_FOREGROUND = 1;
    public static final int THREAD_GROUP_SYSTEM = 2;
    public static final int THREAD_PRIORITY_AUDIO = -16;
    public static final int THREAD_PRIORITY_BACKGROUND = 10;
    public static final int THREAD_PRIORITY_DEFAULT = 0;
    public static final int THREAD_PRIORITY_DISPLAY = -4;
    public static final int THREAD_PRIORITY_FOREGROUND = -2;
    public static final int THREAD_PRIORITY_LESS_FAVORABLE = 1;
    public static final int THREAD_PRIORITY_LOWEST = 19;
    public static final int THREAD_PRIORITY_MORE_FAVORABLE = -1;
    public static final int THREAD_PRIORITY_URGENT_AUDIO = -19;
    public static final int THREAD_PRIORITY_URGENT_DISPLAY = -8;
    public static final int VPN_UID = 1016;
    public static final int WIFI_UID = 1010;
    static final int ZYGOTE_RETRY_MILLIS = 500;
    public static final String ZYGOTE_SOCKET = "zygote";
    static ZygoteState primaryZygoteState;
    static ZygoteState secondaryZygoteState;

    /* loaded from: source-9557208-dex2jar.jar:android/os/Process$ProcessStartResult.class */
    public static final class ProcessStartResult {
        public int pid;
        public boolean usingWrapper;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/Process$ZygoteState.class */
    public static class ZygoteState {
        final List<String> abiList;
        final DataInputStream inputStream;
        boolean mClosed;
        final LocalSocket socket;
        final BufferedWriter writer;

        private ZygoteState(LocalSocket localSocket, DataInputStream dataInputStream, BufferedWriter bufferedWriter, List<String> list) {
            this.socket = localSocket;
            this.inputStream = dataInputStream;
            this.writer = bufferedWriter;
            this.abiList = list;
        }

        public static ZygoteState connect(String str) throws IOException {
            DataInputStream dataInputStream;
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(str, LocalSocketAddress.Namespace.RESERVED));
                dataInputStream = new DataInputStream(localSocket.getInputStream());
            } catch (IOException e) {
                e = e;
            }
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(localSocket.getOutputStream()), 256);
                String abiList = Process.getAbiList(bufferedWriter, dataInputStream);
                Log.i("Zygote", "Process: zygote socket opened, supported ABIS: " + abiList);
                return new ZygoteState(localSocket, dataInputStream, bufferedWriter, Arrays.asList(abiList.split(",")));
            } catch (IOException e2) {
                e = e2;
                try {
                    localSocket.close();
                } catch (IOException e3) {
                }
                throw e;
            }
        }

        public void close() {
            try {
                this.socket.close();
            } catch (IOException e) {
                Log.e(Process.LOG_TAG, "I/O exception on routine close", e);
            }
            this.mClosed = true;
        }

        boolean isClosed() {
            return this.mClosed;
        }

        boolean matches(String str) {
            return this.abiList.contains(str);
        }
    }

    public static void establishZygoteConnectionForAbi(String str) {
        try {
            openZygoteSocketIfNeeded(str);
        } catch (ZygoteStartFailedEx e) {
            throw new RuntimeException("Unable to connect to zygote for abi: " + str, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAbiList(BufferedWriter bufferedWriter, DataInputStream dataInputStream) throws IOException {
        bufferedWriter.write("1");
        bufferedWriter.newLine();
        bufferedWriter.write("--query-abi-list");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        return new String(bArr, StandardCharsets.US_ASCII);
    }

    public static final native long getElapsedCpuTime();

    public static final native long getFreeMemory();

    public static final native int getGidForName(String str);

    public static final int getParentPid(int i) {
        long[] jArr = {-1};
        readProcLines("/proc/" + i + "/status", new String[]{"PPid:"}, jArr);
        return (int) jArr[0];
    }

    public static final native int[] getPids(String str, int[] iArr);

    public static final native int[] getPidsForCommands(String[] strArr);

    public static final native int getProcessGroup(int i) throws IllegalArgumentException, SecurityException;

    public static final native long getPss(int i);

    public static final int getThreadGroupLeader(int i) {
        long[] jArr = {-1};
        readProcLines("/proc/" + i + "/status", new String[]{"Tgid:"}, jArr);
        return (int) jArr[0];
    }

    public static final native int getThreadPriority(int i) throws IllegalArgumentException;

    public static final native long getTotalMemory();

    public static final native int getUidForName(String str);

    public static final int getUidForPid(int i) {
        long[] jArr = {-1};
        readProcLines("/proc/" + i + "/status", new String[]{"Uid:"}, jArr);
        return (int) jArr[0];
    }

    public static final boolean isIsolated() {
        int appId = UserHandle.getAppId(myUid());
        return appId >= 99000 && appId <= 99999;
    }

    public static final void killProcess(int i) {
        sendSignal(i, 9);
    }

    public static final native int killProcessGroup(int i, int i2);

    public static final void killProcessQuiet(int i) {
        sendSignalQuiet(i, 9);
    }

    public static final int myPid() {
        return Os.getpid();
    }

    public static final int myPpid() {
        return Os.getppid();
    }

    public static final int myTid() {
        return Os.gettid();
    }

    public static final int myUid() {
        return Os.getuid();
    }

    public static final UserHandle myUserHandle() {
        return new UserHandle(UserHandle.getUserId(myUid()));
    }

    private static ZygoteState openZygoteSocketIfNeeded(String str) throws ZygoteStartFailedEx {
        if (primaryZygoteState == null || primaryZygoteState.isClosed()) {
            try {
                primaryZygoteState = ZygoteState.connect(ZYGOTE_SOCKET);
            } catch (IOException e) {
                throw new ZygoteStartFailedEx("Error connecting to primary zygote", e);
            }
        }
        if (primaryZygoteState.matches(str)) {
            return primaryZygoteState;
        }
        if (secondaryZygoteState == null || secondaryZygoteState.isClosed()) {
            try {
                secondaryZygoteState = ZygoteState.connect(SECONDARY_ZYGOTE_SOCKET);
            } catch (IOException e2) {
                throw new ZygoteStartFailedEx("Error connecting to secondary zygote", e2);
            }
        }
        if (secondaryZygoteState.matches(str)) {
            return secondaryZygoteState;
        }
        throw new ZygoteStartFailedEx("Unsupported zygote ABI: " + str);
    }

    public static final native boolean parseProcLine(byte[] bArr, int i, int i2, int[] iArr, String[] strArr, long[] jArr, float[] fArr);

    public static final native boolean readProcFile(String str, int[] iArr, String[] strArr, long[] jArr, float[] fArr);

    public static final native void readProcLines(String str, String[] strArr, long[] jArr);

    public static final native void removeAllProcessGroups();

    public static final native void sendSignal(int i, int i2);

    public static final native void sendSignalQuiet(int i, int i2);

    public static final native void setArgV0(String str);

    public static final native void setCanSelfBackground(boolean z);

    public static final native int setGid(int i);

    public static final native void setProcessGroup(int i, int i2) throws IllegalArgumentException, SecurityException;

    public static final native boolean setSwappiness(int i, boolean z);

    public static final native void setThreadGroup(int i, int i2) throws IllegalArgumentException, SecurityException;

    public static final native void setThreadPriority(int i) throws IllegalArgumentException, SecurityException;

    public static final native void setThreadPriority(int i, int i2) throws IllegalArgumentException, SecurityException;

    public static final native void setThreadScheduler(int i, int i2, int i3) throws IllegalArgumentException;

    public static final native int setUid(int i);

    public static final ProcessStartResult start(String str, String str2, int i, int i2, int[] iArr, int i3, int i4, int i5, String str3, String str4, String str5, String str6, boolean z, String[] strArr) {
        try {
            return startViaZygote(str, str2, i, i2, iArr, i3, i4, i5, str3, str4, str5, str6, z, strArr);
        } catch (ZygoteStartFailedEx e) {
            Log.e(LOG_TAG, "Starting VM process through Zygote failed");
            throw new RuntimeException("Starting VM process through Zygote failed", e);
        }
    }

    private static ProcessStartResult startViaZygote(String str, String str2, int i, int i2, int[] iArr, int i3, int i4, int i5, String str3, String str4, String str5, String str6, boolean z, String[] strArr) throws ZygoteStartFailedEx {
        ProcessStartResult zygoteSendArgsAndGetResult;
        synchronized (Process.class) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add("--runtime-init");
                arrayList.add("--setuid=" + i);
                arrayList.add("--setgid=" + i2);
                if ((i3 & 16) != 0) {
                    arrayList.add("--enable-jni-logging");
                }
                if ((i3 & 8) != 0) {
                    arrayList.add("--enable-safemode");
                }
                if ((i3 & 1) != 0) {
                    arrayList.add("--enable-debugger");
                }
                if ((i3 & 2) != 0) {
                    arrayList.add("--enable-checkjni");
                }
                if ((i3 & 4) != 0) {
                    arrayList.add("--enable-assert");
                }
                if (i4 == 2) {
                    arrayList.add("--mount-external-multiuser");
                } else if (i4 == 3) {
                    arrayList.add("--mount-external-multiuser-all");
                }
                if (z) {
                    arrayList.add("--refresh_theme");
                }
                arrayList.add("--target-sdk-version=" + i5);
                if (iArr != null && iArr.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("--setgroups=");
                    int length = iArr.length;
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 >= length) {
                            break;
                        }
                        if (i7 != 0) {
                            sb.append(',');
                        }
                        sb.append(iArr[i7]);
                        i6 = i7 + 1;
                    }
                    arrayList.add(sb.toString());
                }
                if (str2 != null) {
                    arrayList.add("--nice-name=" + str2);
                }
                if (str3 != null) {
                    arrayList.add("--seinfo=" + str3);
                }
                if (str5 != null) {
                    arrayList.add("--instruction-set=" + str5);
                }
                if (str6 != null) {
                    arrayList.add("--app-data-dir=" + str6);
                }
                arrayList.add(str);
                if (strArr != null) {
                    int length2 = strArr.length;
                    int i8 = 0;
                    while (true) {
                        int i9 = i8;
                        if (i9 >= length2) {
                            break;
                        }
                        arrayList.add(strArr[i9]);
                        i8 = i9 + 1;
                    }
                }
                zygoteSendArgsAndGetResult = zygoteSendArgsAndGetResult(openZygoteSocketIfNeeded(str4), arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zygoteSendArgsAndGetResult;
    }

    @Deprecated
    public static final boolean supportsProcesses() {
        return true;
    }

    private static ProcessStartResult zygoteSendArgsAndGetResult(ZygoteState zygoteState, ArrayList<String> arrayList) throws ZygoteStartFailedEx {
        try {
            BufferedWriter bufferedWriter = zygoteState.writer;
            DataInputStream dataInputStream = zygoteState.inputStream;
            bufferedWriter.write(Integer.toString(arrayList.size()));
            bufferedWriter.newLine();
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    bufferedWriter.flush();
                    ProcessStartResult processStartResult = new ProcessStartResult();
                    processStartResult.pid = dataInputStream.readInt();
                    if (processStartResult.pid < 0) {
                        throw new ZygoteStartFailedEx("fork() failed");
                    }
                    processStartResult.usingWrapper = dataInputStream.readBoolean();
                    return processStartResult;
                }
                String str = arrayList.get(i2);
                if (str.indexOf(10) >= 0) {
                    throw new ZygoteStartFailedEx("embedded newlines not allowed");
                }
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                i = i2 + 1;
            }
        } catch (IOException e) {
            zygoteState.close();
            throw new ZygoteStartFailedEx(e);
        }
    }
}
