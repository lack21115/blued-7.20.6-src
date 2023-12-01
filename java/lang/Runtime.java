package java.lang;

import android.system.OsConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.VMDebug;
import dalvik.system.VMStack;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.FinalizerReference;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Runtime.class */
public class Runtime {
    private static boolean finalizeOnExit;
    private static final Runtime mRuntime = new Runtime();
    private final String[] mLibPaths = initLibPaths();
    private List<Thread> shutdownHooks = new ArrayList();
    private boolean shuttingDown;
    private boolean tracingMethods;

    private Runtime() {
    }

    private String doLoad(String str, ClassLoader classLoader) {
        String nativeLoad;
        String str2 = null;
        if (classLoader != null) {
            str2 = null;
            if (classLoader instanceof BaseDexClassLoader) {
                str2 = ((BaseDexClassLoader) classLoader).getLdLibraryPath();
            }
        }
        synchronized (this) {
            nativeLoad = nativeLoad(str, classLoader, str2);
        }
        return nativeLoad;
    }

    public static Runtime getRuntime() {
        return mRuntime;
    }

    private static String[] initLibPaths() {
        String[] strArr;
        String property = System.getProperty("java.library.path");
        if (property != null) {
            String[] split = property.split(":");
            int i = 0;
            while (true) {
                int i2 = i;
                strArr = split;
                if (i2 >= split.length) {
                    break;
                }
                if (!split[i2].endsWith(BridgeUtil.SPLIT_MARK)) {
                    split[i2] = split[i2] + BridgeUtil.SPLIT_MARK;
                }
                i = i2 + 1;
            }
        } else {
            strArr = EmptyArray.STRING;
        }
        return strArr;
    }

    private static native void nativeExit(int i);

    private static native String nativeLoad(String str, ClassLoader classLoader, String str2);

    @Deprecated
    public static void runFinalizersOnExit(boolean z) {
        finalizeOnExit = z;
    }

    public void addShutdownHook(Thread thread) {
        if (thread == null) {
            throw new NullPointerException("hook == null");
        }
        if (this.shuttingDown) {
            throw new IllegalStateException("VM already shutting down");
        }
        if (thread.hasBeenStarted) {
            throw new IllegalArgumentException("Hook has already been started");
        }
        synchronized (this.shutdownHooks) {
            if (this.shutdownHooks.contains(thread)) {
                throw new IllegalArgumentException("Hook already registered.");
            }
            this.shutdownHooks.add(thread);
        }
    }

    public int availableProcessors() {
        return (int) Libcore.os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
    }

    public Process exec(String str) throws IOException {
        return exec(str, (String[]) null, (File) null);
    }

    public Process exec(String str, String[] strArr) throws IOException {
        return exec(str, strArr, (File) null);
    }

    public Process exec(String str, String[] strArr, File file) throws IOException {
        if (str == null) {
            throw new NullPointerException("prog == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("prog is empty");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        int countTokens = stringTokenizer.countTokens();
        String[] strArr2 = new String[countTokens];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= countTokens) {
                return exec(strArr2, strArr, file);
            }
            strArr2[i2] = stringTokenizer.nextToken();
            i = i2 + 1;
        }
    }

    public Process exec(String[] strArr) throws IOException {
        return exec(strArr, (String[]) null, (File) null);
    }

    public Process exec(String[] strArr, String[] strArr2) throws IOException {
        return exec(strArr, strArr2, (File) null);
    }

    public Process exec(String[] strArr, String[] strArr2, File file) throws IOException {
        return ProcessManager.getInstance().exec(strArr, strArr2, file, false);
    }

    public void exit(int i) {
        Thread[] threadArr;
        synchronized (this) {
            if (!this.shuttingDown) {
                this.shuttingDown = true;
                synchronized (this.shutdownHooks) {
                    threadArr = new Thread[this.shutdownHooks.size()];
                    this.shutdownHooks.toArray(threadArr);
                }
                int length = threadArr.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    threadArr[i3].start();
                    i2 = i3 + 1;
                }
                int length2 = threadArr.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= length2) {
                        break;
                    }
                    try {
                        threadArr[i5].join();
                    } catch (InterruptedException e) {
                    }
                    i4 = i5 + 1;
                }
                if (finalizeOnExit) {
                    runFinalization();
                }
                nativeExit(i);
            }
        }
    }

    public native long freeMemory();

    public native void gc();

    @Deprecated
    public InputStream getLocalizedInputStream(InputStream inputStream) {
        String property = System.getProperty("file.encoding", "UTF-8");
        if (property.equals("UTF-8")) {
            return inputStream;
        }
        throw new UnsupportedOperationException("Cannot localize " + property);
    }

    @Deprecated
    public OutputStream getLocalizedOutputStream(OutputStream outputStream) {
        String property = System.getProperty("file.encoding", "UTF-8");
        if (property.equals("UTF-8")) {
            return outputStream;
        }
        throw new UnsupportedOperationException("Cannot localize " + property);
    }

    public void halt(int i) {
        nativeExit(i);
    }

    public void load(String str) {
        load(str, VMStack.getCallingClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void load(String str, ClassLoader classLoader) {
        if (str == null) {
            throw new NullPointerException("absolutePath == null");
        }
        String doLoad = doLoad(str, classLoader);
        if (doLoad != null) {
            throw new UnsatisfiedLinkError(doLoad);
        }
    }

    public void loadLibrary(String str) {
        loadLibrary(str, VMStack.getCallingClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadLibrary(String str, ClassLoader classLoader) {
        String[] strArr;
        if (classLoader != null) {
            String findLibrary = classLoader.findLibrary(str);
            if (findLibrary == null) {
                throw new UnsatisfiedLinkError(classLoader + " couldn't find \"" + System.mapLibraryName(str) + "\"");
            }
            String doLoad = doLoad(findLibrary, classLoader);
            if (doLoad != null) {
                throw new UnsatisfiedLinkError(doLoad);
            }
            return;
        }
        String mapLibraryName = System.mapLibraryName(str);
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        int length = this.mLibPaths.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                if (str2 == null) {
                    throw new UnsatisfiedLinkError("Library " + str + " not found; tried " + arrayList);
                }
                throw new UnsatisfiedLinkError(str2);
            }
            String str3 = strArr[i2] + mapLibraryName;
            arrayList.add(str3);
            if (IoUtils.canOpenReadOnly(str3)) {
                str2 = doLoad(str3, classLoader);
                if (str2 == null) {
                    return;
                }
            }
            i = i2 + 1;
        }
    }

    public native long maxMemory();

    public boolean removeShutdownHook(Thread thread) {
        boolean remove;
        if (thread == null) {
            throw new NullPointerException("hook == null");
        }
        if (this.shuttingDown) {
            throw new IllegalStateException("VM already shutting down");
        }
        synchronized (this.shutdownHooks) {
            remove = this.shutdownHooks.remove(thread);
        }
        return remove;
    }

    public void runFinalization() {
        try {
            FinalizerReference.finalizeAllEnqueued();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public native long totalMemory();

    public void traceInstructions(boolean z) {
    }

    public void traceMethodCalls(boolean z) {
        if (z != this.tracingMethods) {
            if (z) {
                VMDebug.startMethodTracing();
            } else {
                VMDebug.stopMethodTracing();
            }
            this.tracingMethods = z;
        }
    }
}
