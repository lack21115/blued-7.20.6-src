package com.android.internal.os;

import android.net.Credentials;
import android.net.LocalSocket;
import android.os.Process;
import android.os.SELinux;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import com.android.internal.os.ZygoteInit;
import dalvik.system.PathClassLoader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import libcore.io.IoUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/ZygoteConnection.class */
public class ZygoteConnection {
    private static final int CONNECTION_TIMEOUT_MILLIS = 1000;
    private static final int MAX_ZYGOTE_ARGC = 1024;
    private static final String TAG = "Zygote";
    private static final int[][] intArray2d = (int[][]) Array.newInstance(Integer.TYPE, 0, 0);
    private final String abiList;
    private final LocalSocket mSocket;
    private final DataOutputStream mSocketOutStream;
    private final BufferedReader mSocketReader;
    private final Credentials peer;
    private final String peerSecurityContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/ZygoteConnection$Arguments.class */
    public static class Arguments {
        boolean abiListQuery;
        String appDataDir;
        boolean capabilitiesSpecified;
        String classpath;
        int debugFlags;
        long effectiveCapabilities;
        boolean gidSpecified;
        int[] gids;
        String instructionSet;
        String invokeWith;
        String niceName;
        long permittedCapabilities;
        boolean refreshTheme;
        String[] remainingArgs;
        ArrayList<int[]> rlimits;
        boolean runtimeInit;
        String seInfo;
        boolean seInfoSpecified;
        int targetSdkVersion;
        boolean targetSdkVersionSpecified;
        boolean uidSpecified;
        int uid = 0;
        int gid = 0;
        int mountExternal = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Arguments(String[] strArr) throws IllegalArgumentException {
            parseArgs(strArr);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
            if (r6.classpath == null) goto L180;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
            throw new java.lang.IllegalArgumentException("--runtime-init and -classpath are incompatible");
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x042a, code lost:
            r6.remainingArgs = new java.lang.String[r7.length - r9];
            java.lang.System.arraycopy(r7, r9, r6.remainingArgs, 0, r6.remainingArgs.length);
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x0444, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
            if (r6.runtimeInit == false) goto L180;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void parseArgs(java.lang.String[] r7) throws java.lang.IllegalArgumentException {
            /*
                Method dump skipped, instructions count: 1093
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.ZygoteConnection.Arguments.parseArgs(java.lang.String[]):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZygoteConnection(LocalSocket localSocket, String str) throws IOException {
        this.mSocket = localSocket;
        this.abiList = str;
        this.mSocketOutStream = new DataOutputStream(localSocket.getOutputStream());
        this.mSocketReader = new BufferedReader(new InputStreamReader(localSocket.getInputStream()), 256);
        this.mSocket.setSoTimeout(1000);
        try {
            this.peer = this.mSocket.getPeerCredentials();
            this.peerSecurityContext = SELinux.getPeerContext(this.mSocket.getFileDescriptor());
        } catch (IOException e) {
            Log.e(TAG, "Cannot read peer credentials", e);
            throw e;
        }
    }

    public static void applyDebuggerSystemProperty(Arguments arguments) {
        if ("1".equals(SystemProperties.get("ro.debuggable"))) {
            arguments.debugFlags |= 1;
        }
    }

    private static void applyInvokeWithSecurityPolicy(Arguments arguments, Credentials credentials, String str) throws ZygoteSecurityException {
        int uid = credentials.getUid();
        if (arguments.invokeWith != null && uid != 0) {
            throw new ZygoteSecurityException("Peer is not permitted to specify an explicit invoke-with wrapper command");
        }
        if (arguments.invokeWith != null && !SELinux.checkSELinuxAccess(str, str, Process.ZYGOTE_SOCKET, "specifyinvokewith")) {
            throw new ZygoteSecurityException("Peer is not permitted to specify an explicit invoke-with wrapper command");
        }
    }

    public static void applyInvokeWithSystemProperty(Arguments arguments) {
        if (arguments.invokeWith != null || arguments.niceName == null || arguments.niceName == null) {
            return;
        }
        String str = "wrap." + arguments.niceName;
        String str2 = str;
        if (str.length() > 31) {
            str2 = str.charAt(30) != '.' ? str.substring(0, 31) : str.substring(0, 30);
        }
        arguments.invokeWith = SystemProperties.get(str2);
        if (arguments.invokeWith == null || arguments.invokeWith.length() != 0) {
            return;
        }
        arguments.invokeWith = null;
    }

    private static void applyRlimitSecurityPolicy(Arguments arguments, Credentials credentials, String str) throws ZygoteSecurityException {
        int uid = credentials.getUid();
        if (uid != 0 && uid != 1000 && arguments.rlimits != null) {
            throw new ZygoteSecurityException("This UID may not specify rlimits.");
        }
        if (arguments.rlimits != null && !SELinux.checkSELinuxAccess(str, str, Process.ZYGOTE_SOCKET, "specifyrlimits")) {
            throw new ZygoteSecurityException("Peer may not specify rlimits");
        }
    }

    private static void applyUidSecurityPolicy(Arguments arguments, Credentials credentials, String str) throws ZygoteSecurityException {
        int uid = credentials.getUid();
        if (uid != 0) {
            if (uid == 1000) {
                String str2 = SystemProperties.get("ro.factorytest");
                if (((str2.equals("1") || str2.equals("2")) ? false : true) && arguments.uidSpecified && arguments.uid < 1000) {
                    throw new ZygoteSecurityException("System UID may not launch process with UID < 1000");
                }
            } else if (arguments.uidSpecified || arguments.gidSpecified || arguments.gids != null) {
                throw new ZygoteSecurityException("App UIDs may not specify uid's or gid's");
            }
        }
        if ((arguments.uidSpecified || arguments.gidSpecified || arguments.gids != null) && !SELinux.checkSELinuxAccess(str, str, Process.ZYGOTE_SOCKET, "specifyids")) {
            throw new ZygoteSecurityException("Peer may not specify uid's or gid's");
        }
        if (!arguments.uidSpecified) {
            arguments.uid = credentials.getUid();
            arguments.uidSpecified = true;
        }
        if (arguments.gidSpecified) {
            return;
        }
        arguments.gid = credentials.getGid();
        arguments.gidSpecified = true;
    }

    private static void applyseInfoSecurityPolicy(Arguments arguments, Credentials credentials, String str) throws ZygoteSecurityException {
        int uid = credentials.getUid();
        if (arguments.seInfo == null) {
            return;
        }
        if (uid != 0 && uid != 1000) {
            throw new ZygoteSecurityException("This UID may not specify SELinux info.");
        }
        if (!SELinux.checkSELinuxAccess(str, str, Process.ZYGOTE_SOCKET, "specifyseinfo")) {
            throw new ZygoteSecurityException("Peer may not specify SELinux info");
        }
    }

    private void checkTime(long j, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - j > 1000) {
            Slog.w(TAG, "Slow operation: " + (elapsedRealtime - j) + "ms so far, now at " + str);
        }
    }

    private boolean handleAbiListQuery() {
        try {
            byte[] bytes = this.abiList.getBytes(StandardCharsets.US_ASCII);
            this.mSocketOutStream.writeInt(bytes.length);
            this.mSocketOutStream.write(bytes);
            return false;
        } catch (IOException e) {
            Log.e(TAG, "Error writing to command socket", e);
            return true;
        }
    }

    private void handleChildProc(Arguments arguments, FileDescriptor[] fileDescriptorArr, FileDescriptor fileDescriptor, PrintStream printStream) throws ZygoteInit.MethodAndArgsCaller {
        closeSocket();
        ZygoteInit.closeServerSocket();
        PrintStream printStream2 = printStream;
        if (fileDescriptorArr != null) {
            try {
                ZygoteInit.reopenStdio(fileDescriptorArr[0], fileDescriptorArr[1], fileDescriptorArr[2]);
                int length = fileDescriptorArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    IoUtils.closeQuietly(fileDescriptorArr[i2]);
                    i = i2 + 1;
                }
                printStream2 = System.err;
            } catch (IOException e) {
                Log.e(TAG, "Error reopening stdio", e);
                printStream2 = printStream;
            }
        }
        if (arguments.niceName != null) {
            Process.setArgV0(arguments.niceName);
        }
        if (arguments.runtimeInit) {
            if (arguments.invokeWith != null) {
                WrapperInit.execApplication(arguments.invokeWith, arguments.niceName, arguments.targetSdkVersion, fileDescriptor, arguments.remainingArgs);
                return;
            } else {
                RuntimeInit.zygoteInit(arguments.targetSdkVersion, arguments.remainingArgs, null);
                return;
            }
        }
        try {
            String str = arguments.remainingArgs[0];
            String[] strArr = new String[arguments.remainingArgs.length - 1];
            System.arraycopy(arguments.remainingArgs, 1, strArr, 0, strArr.length);
            if (arguments.invokeWith != null) {
                WrapperInit.execStandalone(arguments.invokeWith, arguments.classpath, str, strArr);
                return;
            }
            try {
                ZygoteInit.invokeStaticMain(arguments.classpath != null ? new PathClassLoader(arguments.classpath, ClassLoader.getSystemClassLoader()) : ClassLoader.getSystemClassLoader(), str, strArr);
            } catch (RuntimeException e2) {
                logAndPrintError(printStream2, "Error starting.", e2);
            }
        } catch (ArrayIndexOutOfBoundsException e3) {
            logAndPrintError(printStream2, "Missing required class name argument", null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.IOException] */
    private boolean handleParentProc(int i, FileDescriptor[] fileDescriptorArr, FileDescriptor fileDescriptor, Arguments arguments) {
        int i2;
        if (i > 0) {
            setChildPgid(i);
        }
        if (fileDescriptorArr != null) {
            int length = fileDescriptorArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                IoUtils.closeQuietly(fileDescriptorArr[i4]);
                i3 = i4 + 1;
            }
        }
        boolean z = false;
        int i5 = i;
        if (fileDescriptor != null) {
            z = false;
            i5 = i;
            if (i > 0) {
                ?? e = new DataInputStream(new FileInputStream(fileDescriptor));
                int i6 = -1;
                try {
                    try {
                        i6 = e.readInt();
                        try {
                            e.close();
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        Log.w(TAG, "Error reading pid from wrapped process, child may have died", e3);
                        try {
                            e.close();
                        } catch (IOException e4) {
                            e = e4;
                        }
                    }
                    z = false;
                    i5 = i;
                    if (i6 > 0) {
                        int i7 = i6;
                        while (true) {
                            i2 = i7;
                            if (i2 <= 0 || i2 == i) {
                                break;
                            }
                            i7 = Process.getParentPid(i2);
                        }
                        if (i2 > 0) {
                            Log.i(TAG, "Wrapped process has pid " + i6);
                            z = true;
                            i5 = i6;
                        } else {
                            Log.w(TAG, "Wrapped process reported a pid that is not a child of the process that we forked: childPid=" + i + " innerPid=" + i6);
                            z = false;
                            i5 = i;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        e.close();
                    } catch (IOException e5) {
                    }
                    throw th;
                }
            }
        }
        try {
            this.mSocketOutStream.writeInt(i5);
            this.mSocketOutStream.writeBoolean(z);
            return false;
        } catch (IOException e6) {
            Log.e(TAG, "Error writing to command socket", e6);
            return true;
        }
    }

    private static void logAndPrintError(PrintStream printStream, String str, Throwable th) {
        Log.e(TAG, str, th);
        if (printStream != null) {
            StringBuilder append = new StringBuilder().append(str);
            Throwable th2 = th;
            if (th == null) {
                th2 = "";
            }
            printStream.println(append.append(th2).toString());
        }
    }

    private String[] readArgumentList() throws IOException {
        try {
            String readLine = this.mSocketReader.readLine();
            if (readLine == null) {
                return null;
            }
            int parseInt = Integer.parseInt(readLine);
            if (parseInt > 1024) {
                throw new IOException("max arg count exceeded");
            }
            String[] strArr = new String[parseInt];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= parseInt) {
                    return strArr;
                }
                strArr[i2] = this.mSocketReader.readLine();
                if (strArr[i2] == null) {
                    throw new IOException("truncated request");
                }
                i = i2 + 1;
            }
        } catch (NumberFormatException e) {
            Log.e(TAG, "invalid Zygote wire format: non-int at argc");
            throw new IOException("invalid wire format");
        }
    }

    private void setChildPgid(int i) {
        try {
            ZygoteInit.setpgid(i, ZygoteInit.getpgid(this.peer.getPid()));
        } catch (IOException e) {
            Log.i(TAG, "Zygote: setpgid failed. This is normal if peer is not in our session");
        }
    }

    void closeSocket() {
        try {
            this.mSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Exception while closing command socket in parent", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileDescriptor getFileDescriptor() {
        return this.mSocket.getFileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0209  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean runOnce() throws com.android.internal.os.ZygoteInit.MethodAndArgsCaller {
        /*
            Method dump skipped, instructions count: 2173
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.ZygoteConnection.runOnce():boolean");
    }
}
