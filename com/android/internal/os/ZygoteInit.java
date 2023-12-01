package com.android.internal.os;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.LocalServerSocket;
import android.opengl.EGL14;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.EventLog;
import android.util.Log;
import android.webkit.WebViewFactory;
import com.android.internal.R;
import com.android.internal.os.ZygoteConnection;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import dalvik.system.VMRuntime;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import libcore.io.IoUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/ZygoteInit.class */
public class ZygoteInit {
    private static final String ABI_LIST_ARG = "--abi-list=";
    private static final String ANDROID_SOCKET_PREFIX = "ANDROID_SOCKET_";
    static final int GC_LOOP_COUNT = 10;
    private static final int LOG_BOOT_PROGRESS_PRELOAD_END = 3030;
    private static final int LOG_BOOT_PROGRESS_PRELOAD_START = 3020;
    private static final String PRELOADED_CLASSES = "/system/etc/preloaded-classes";
    private static final int PRELOAD_GC_THRESHOLD = 50000;
    private static final boolean PRELOAD_RESOURCES = true;
    private static final String PROPERTY_DISABLE_OPENGL_PRELOADING = "ro.zygote.disable_gl_preload";
    private static final int ROOT_GID = 0;
    private static final int ROOT_UID = 0;
    private static final String SOCKET_NAME_ARG = "--socket-name=";
    private static final String TAG = "Zygote";
    private static final int UNPRIVILEGED_GID = 9999;
    private static final int UNPRIVILEGED_UID = 9999;
    private static Resources mResources;
    private static LocalServerSocket sServerSocket;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/ZygoteInit$MethodAndArgsCaller.class */
    public static class MethodAndArgsCaller extends Exception implements Runnable {
        private final String[] mArgs;
        private final Method mMethod;

        public MethodAndArgsCaller(Method method, String[] strArr) {
            this.mMethod = method;
            this.mArgs = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mMethod.invoke(null, this.mArgs);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (!(cause instanceof Error)) {
                    throw new RuntimeException(e2);
                }
                throw ((Error) cause);
            }
        }
    }

    private ZygoteInit() {
    }

    private static ZygoteConnection acceptCommandPeer(String str) {
        try {
            return new ZygoteConnection(sServerSocket.accept(), str);
        } catch (IOException e) {
            throw new RuntimeException("IOException during accept()", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeServerSocket() {
        try {
            if (sServerSocket != null) {
                FileDescriptor fileDescriptor = sServerSocket.getFileDescriptor();
                sServerSocket.close();
                if (fileDescriptor != null) {
                    Os.close(fileDescriptor);
                }
            }
        } catch (ErrnoException e) {
            Log.e(TAG, "Zygote:  error closing descriptor", e);
        } catch (IOException e2) {
            Log.e(TAG, "Zygote:  error closing sockets", e2);
        }
        sServerSocket = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native FileDescriptor createFileDescriptor(int i) throws IOException;

    static void gc() {
        VMRuntime runtime = VMRuntime.getRuntime();
        System.gc();
        runtime.runFinalizationSync();
        System.gc();
        runtime.runFinalizationSync();
        System.gc();
        runtime.runFinalizationSync();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileDescriptor getServerSocketFileDescriptor() {
        return sServerSocket.getFileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getpgid(int i) throws IOException;

    private static void handleSystemServerProcess(ZygoteConnection.Arguments arguments) throws MethodAndArgsCaller {
        closeServerSocket();
        Os.umask(OsConstants.S_IRWXG | OsConstants.S_IRWXO);
        if (arguments.niceName != null) {
            Process.setArgV0(arguments.niceName);
        }
        String str = Os.getenv("SYSTEMSERVERCLASSPATH");
        if (str != null) {
            performSystemServerDexOpt(str);
        }
        if (arguments.invokeWith == null) {
            PathClassLoader pathClassLoader = null;
            if (str != null) {
                pathClassLoader = new PathClassLoader(str, ClassLoader.getSystemClassLoader());
                Thread.currentThread().setContextClassLoader(pathClassLoader);
            }
            RuntimeInit.zygoteInit(arguments.targetSdkVersion, arguments.remainingArgs, pathClassLoader);
            return;
        }
        String[] strArr = arguments.remainingArgs;
        if (str != null) {
            String[] strArr2 = new String[strArr.length + 2];
            strArr2[0] = "-cp";
            strArr2[1] = str;
            System.arraycopy(arguments.remainingArgs, 0, strArr2, 2, arguments.remainingArgs.length);
        }
        WrapperInit.execApplication(arguments.invokeWith, arguments.niceName, arguments.targetSdkVersion, null, strArr);
    }

    private static boolean hasSecondZygote(String str) {
        return !SystemProperties.get("ro.product.cpu.abilist").equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeStaticMain(ClassLoader classLoader, String str, String[] strArr) throws MethodAndArgsCaller {
        try {
            try {
                Method method = classLoader.loadClass(str).getMethod("main", String[].class);
                int modifiers = method.getModifiers();
                if (!Modifier.isStatic(modifiers) || !Modifier.isPublic(modifiers)) {
                    throw new RuntimeException("Main method is not public and static on " + str);
                }
                throw new MethodAndArgsCaller(method, strArr);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Missing static main on " + str, e);
            } catch (SecurityException e2) {
                throw new RuntimeException("Problem getting static main on " + str, e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Missing class when invoking static main " + str, e3);
        }
    }

    public static void main(String[] strArr) {
        try {
            SamplingProfilerIntegration.start();
            boolean z = false;
            String str = "zygote";
            String str2 = null;
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    if (str2 == null) {
                        throw new RuntimeException("No ABI list supplied.");
                    }
                    registerZygoteSocket(str);
                    EventLog.writeEvent((int) LOG_BOOT_PROGRESS_PRELOAD_START, SystemClock.uptimeMillis());
                    preload();
                    EventLog.writeEvent((int) LOG_BOOT_PROGRESS_PRELOAD_END, SystemClock.uptimeMillis());
                    SamplingProfilerIntegration.writeZygoteSnapshot();
                    gc();
                    Trace.setTracingEnabled(false);
                    if (z) {
                        startSystemServer(str2, str);
                    }
                    Log.i(TAG, "Accepting command socket connections");
                    runSelectLoop(str2);
                    closeServerSocket();
                    return;
                }
                if ("start-system-server".equals(strArr[i2])) {
                    z = true;
                } else if (strArr[i2].startsWith(ABI_LIST_ARG)) {
                    str2 = strArr[i2].substring(ABI_LIST_ARG.length());
                } else if (!strArr[i2].startsWith(SOCKET_NAME_ARG)) {
                    throw new RuntimeException("Unknown command line argument: " + strArr[i2]);
                } else {
                    str = strArr[i2].substring(SOCKET_NAME_ARG.length());
                }
                i = i2 + 1;
            }
        } catch (MethodAndArgsCaller e) {
            e.run();
        } catch (RuntimeException e2) {
            Log.e(TAG, "Zygote died with exception", e2);
            closeServerSocket();
            throw e2;
        }
    }

    private static void performSystemServerDexOpt(String str) {
        String[] split = str.split(":");
        InstallerConnection installerConnection = new InstallerConnection();
        String vmInstructionSet = VMRuntime.getRuntime().vmInstructionSet();
        try {
            try {
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return;
                    }
                    String str2 = split[i2];
                    byte isDexOptNeededInternal = DexFile.isDexOptNeededInternal(str2, PhoneConstants.APN_TYPE_ALL, vmInstructionSet, false);
                    if (isDexOptNeededInternal == 2) {
                        installerConnection.dexopt(str2, 1000, false, vmInstructionSet);
                    } else if (isDexOptNeededInternal == 1) {
                        installerConnection.patchoat(str2, 1000, false, vmInstructionSet);
                    }
                    i = i2 + 1;
                }
            } catch (IOException e) {
                throw new RuntimeException("Error starting system_server", e);
            }
        } finally {
            installerConnection.disconnect();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long posixCapabilitiesAsBits(int... r6) {
        /*
            r0 = 0
            r10 = r0
            r0 = r6
            int r0 = r0.length
            r8 = r0
            r0 = 0
            r7 = r0
        L8:
            r0 = r7
            r1 = r8
            if (r0 >= r1) goto L37
            r0 = r6
            r1 = r7
            r0 = r0[r1]
            r9 = r0
            r0 = r9
            if (r0 < 0) goto L1c
            r0 = r9
            int r1 = android.system.OsConstants.CAP_LAST_CAP
            if (r0 <= r1) goto L28
        L1c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r9
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            throw r0
        L28:
            r0 = r10
            r1 = 1
            r2 = r9
            long r1 = r1 << r2
            long r0 = r0 | r1
            r10 = r0
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L8
        L37:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.ZygoteInit.posixCapabilitiesAsBits(int[]):long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void preload() {
        Log.d(TAG, "begin preload");
        preloadClasses();
        preloadResources();
        preloadOpenGL();
        preloadSharedLibraries();
        WebViewFactory.prepareWebViewInZygote();
        Log.d(TAG, "end preload");
    }

    private static void preloadClasses() {
        VMRuntime runtime = VMRuntime.getRuntime();
        try {
            FileInputStream fileInputStream = new FileInputStream(PRELOADED_CLASSES);
            Log.i(TAG, "Preloading classes...");
            long uptimeMillis = SystemClock.uptimeMillis();
            setEffectiveGroup(9999);
            setEffectiveUser(9999);
            float targetHeapUtilization = runtime.getTargetHeapUtilization();
            runtime.setTargetHeapUtilization(0.8f);
            System.gc();
            runtime.runFinalizationSync();
            Debug.startAllocCounting();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 256);
                int i = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        Log.i(TAG, "...preloaded " + i + " classes in " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms.");
                        return;
                    }
                    String trim = readLine.trim();
                    if (!trim.startsWith("#") && !trim.equals("")) {
                        try {
                            Class.forName(trim);
                            if (Debug.getGlobalAllocSize() > PRELOAD_GC_THRESHOLD) {
                                System.gc();
                                runtime.runFinalizationSync();
                                Debug.resetGlobalAllocSize();
                            }
                            i++;
                        } catch (ClassNotFoundException e) {
                            Log.w(TAG, "Class not found for preloading: " + trim);
                        } catch (UnsatisfiedLinkError e2) {
                            Log.w(TAG, "Problem preloading " + trim + ": " + e2);
                        } catch (Throwable th) {
                            Log.e(TAG, "Error preloading " + trim + ".", th);
                            if (th instanceof Error) {
                                throw ((Error) th);
                            }
                            if (!(th instanceof RuntimeException)) {
                                throw new RuntimeException(th);
                            }
                            throw ((RuntimeException) th);
                        }
                        System.gc();
                    }
                }
            } catch (IOException e3) {
                Log.e(TAG, "Error reading /system/etc/preloaded-classes.", e3);
            } finally {
                IoUtils.closeQuietly(fileInputStream);
                runtime.setTargetHeapUtilization(targetHeapUtilization);
                runtime.preloadDexCaches();
                Debug.stopAllocCounting();
                setEffectiveUser(0);
                setEffectiveGroup(0);
            }
        } catch (FileNotFoundException e4) {
            Log.e(TAG, "Couldn't find /system/etc/preloaded-classes.");
        }
    }

    private static int preloadColorStateLists(VMRuntime vMRuntime, TypedArray typedArray) {
        int length = typedArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                System.gc();
                return length;
            }
            if (Debug.getGlobalAllocSize() > PRELOAD_GC_THRESHOLD) {
                vMRuntime.runFinalizationSync();
                Debug.resetGlobalAllocSize();
            }
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0 && mResources.getColorStateList(resourceId) == null) {
                throw new IllegalArgumentException("Unable to find preloaded color resource #0x" + Integer.toHexString(resourceId) + " (" + typedArray.getString(i2) + ")");
            }
            i = i2 + 1;
        }
    }

    private static int preloadDrawables(VMRuntime vMRuntime, TypedArray typedArray) {
        int length = typedArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                System.gc();
                return length;
            }
            if (Debug.getGlobalAllocSize() > PRELOAD_GC_THRESHOLD) {
                vMRuntime.runFinalizationSync();
                Debug.resetGlobalAllocSize();
            }
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0 && mResources.getDrawable(resourceId, null) == null) {
                throw new IllegalArgumentException("Unable to find preloaded drawable resource #0x" + Integer.toHexString(resourceId) + " (" + typedArray.getString(i2) + ")");
            }
            i = i2 + 1;
        }
    }

    private static void preloadOpenGL() {
        if (SystemProperties.getBoolean(PROPERTY_DISABLE_OPENGL_PRELOADING, false)) {
            return;
        }
        EGL14.eglGetDisplay(0);
    }

    private static void preloadResources() {
        VMRuntime runtime = VMRuntime.getRuntime();
        Debug.startAllocCounting();
        try {
            System.gc();
            runtime.runFinalizationSync();
            mResources = Resources.getSystem();
            mResources.startPreloading();
            Log.i(TAG, "Preloading resources...");
            long uptimeMillis = SystemClock.uptimeMillis();
            TypedArray obtainTypedArray = mResources.obtainTypedArray(R.array.preloaded_drawables);
            int preloadDrawables = preloadDrawables(runtime, obtainTypedArray);
            obtainTypedArray.recycle();
            Log.i(TAG, "...preloaded " + preloadDrawables + " resources in " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms.");
            long uptimeMillis2 = SystemClock.uptimeMillis();
            TypedArray obtainTypedArray2 = mResources.obtainTypedArray(R.array.preloaded_color_state_lists);
            int preloadColorStateLists = preloadColorStateLists(runtime, obtainTypedArray2);
            obtainTypedArray2.recycle();
            Log.i(TAG, "...preloaded " + preloadColorStateLists + " resources in " + (SystemClock.uptimeMillis() - uptimeMillis2) + "ms.");
            mResources.finishPreloading();
        } catch (RuntimeException e) {
            Log.w(TAG, "Failure preloading resources", e);
        } finally {
            Debug.stopAllocCounting();
        }
    }

    private static void preloadSharedLibraries() {
        Log.i(TAG, "Preloading shared libraries...");
        System.loadLibrary(MsgBackupManager.PLATFORM_ANDROID);
        System.loadLibrary("compiler_rt");
        System.loadLibrary("jnigraphics");
    }

    private static void registerZygoteSocket(String str) {
        if (sServerSocket == null) {
            String str2 = ANDROID_SOCKET_PREFIX + str;
            try {
                int parseInt = Integer.parseInt(System.getenv(str2));
                try {
                    sServerSocket = new LocalServerSocket(createFileDescriptor(parseInt));
                } catch (IOException e) {
                    throw new RuntimeException("Error binding to local socket '" + parseInt + "'", e);
                }
            } catch (RuntimeException e2) {
                throw new RuntimeException(str2 + " unset or invalid", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void reopenStdio(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, FileDescriptor fileDescriptor3) throws IOException;

    private static void runSelectLoop(String str) throws MethodAndArgsCaller {
        int i;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        FileDescriptor[] fileDescriptorArr = new FileDescriptor[4];
        arrayList.add(sServerSocket.getFileDescriptor());
        arrayList2.add(null);
        int i2 = 10;
        while (true) {
            if (i2 <= 0) {
                gc();
                i = 10;
            } else {
                i = i2 - 1;
            }
            try {
                FileDescriptor[] fileDescriptorArr2 = (FileDescriptor[]) arrayList.toArray(fileDescriptorArr);
                int selectReadable = selectReadable(fileDescriptorArr2);
                if (selectReadable < 0) {
                    break;
                } else if (selectReadable == 0) {
                    ZygoteConnection acceptCommandPeer = acceptCommandPeer(str);
                    arrayList2.add(acceptCommandPeer);
                    arrayList.add(acceptCommandPeer.getFileDescriptor());
                    fileDescriptorArr = fileDescriptorArr2;
                    i2 = i;
                } else {
                    fileDescriptorArr = fileDescriptorArr2;
                    i2 = i;
                    if (((ZygoteConnection) arrayList2.get(selectReadable)).runOnce()) {
                        arrayList2.remove(selectReadable);
                        arrayList.remove(selectReadable);
                        fileDescriptorArr = fileDescriptorArr2;
                        i2 = i;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Error in select()", e);
            }
        }
        throw new RuntimeException("Error in select()");
    }

    static native int selectReadable(FileDescriptor[] fileDescriptorArr) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setCloseOnExec(FileDescriptor fileDescriptor, boolean z) throws IOException;

    private static void setEffectiveGroup(int i) {
        int i2 = setregid(0, i);
        if (i2 != 0) {
            Log.e(TAG, "setregid() failed. errno: " + i2);
        }
    }

    private static void setEffectiveUser(int i) {
        int i2 = setreuid(0, i);
        if (i2 != 0) {
            Log.e(TAG, "setreuid() failed. errno: " + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setpgid(int i, int i2);

    static native int setregid(int i, int i2);

    static native int setreuid(int i, int i2);

    private static boolean startSystemServer(String str, String str2) throws MethodAndArgsCaller, RuntimeException {
        long posixCapabilitiesAsBits = posixCapabilitiesAsBits(OsConstants.CAP_BLOCK_SUSPEND, OsConstants.CAP_KILL, OsConstants.CAP_NET_ADMIN, OsConstants.CAP_NET_BIND_SERVICE, OsConstants.CAP_NET_BROADCAST, OsConstants.CAP_NET_RAW, OsConstants.CAP_SYS_MODULE, OsConstants.CAP_SYS_NICE, OsConstants.CAP_SYS_RESOURCE, OsConstants.CAP_SYS_TIME, OsConstants.CAP_SYS_TTY_CONFIG);
        try {
            ZygoteConnection.Arguments arguments = new ZygoteConnection.Arguments(new String[]{"--setuid=1000", "--setgid=1000", "--setgroups=1001,1002,1003,1004,1005,1006,1007,1008,1009,1010,1018,1021,1032,3001,3002,3003,3006,3007", "--capabilities=" + posixCapabilitiesAsBits + "," + posixCapabilitiesAsBits, "--runtime-init", "--nice-name=system_server", "com.android.server.SystemServer"});
            try {
                ZygoteConnection.applyDebuggerSystemProperty(arguments);
                ZygoteConnection.applyInvokeWithSystemProperty(arguments);
                if (Zygote.forkSystemServer(arguments.uid, arguments.gid, arguments.gids, arguments.debugFlags, null, arguments.permittedCapabilities, arguments.effectiveCapabilities) == 0) {
                    if (hasSecondZygote(str)) {
                        waitForSecondaryZygote(str2);
                    }
                    handleSystemServerProcess(arguments);
                    return true;
                }
                return true;
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException(e);
            }
        } catch (IllegalArgumentException e2) {
            e = e2;
        }
    }

    private static void waitForSecondaryZygote(String str) {
        String str2 = "zygote".equals(str) ? "zygote_secondary" : "zygote";
        while (true) {
            try {
                Process.ZygoteState.connect(str2).close();
                return;
            } catch (IOException e) {
                Log.w(TAG, "Got error connecting to zygote, retrying. msg= " + e.getMessage());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e2) {
                }
            }
        }
    }
}
