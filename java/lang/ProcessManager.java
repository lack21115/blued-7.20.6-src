package java.lang;

import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.MutableInt;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/ProcessManager.class */
public final class ProcessManager {
    private static final ProcessManager instance = new ProcessManager();
    private final Map<Integer, ProcessReference> processReferences = new HashMap();
    private final ProcessReferenceQueue referenceQueue = new ProcessReferenceQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/ProcessManager$ProcessImpl.class */
    public static class ProcessImpl extends Process {
        private final InputStream errorStream;
        private Integer exitValue = null;
        private final Object exitValueMutex = new Object();
        private final InputStream inputStream;
        private final OutputStream outputStream;
        private final int pid;

        ProcessImpl(int i, FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, FileDescriptor fileDescriptor3) {
            this.pid = i;
            this.errorStream = new ProcessInputStream(fileDescriptor3);
            this.inputStream = new ProcessInputStream(fileDescriptor);
            this.outputStream = new ProcessOutputStream(fileDescriptor2);
        }

        @Override // java.lang.Process
        public void destroy() {
            synchronized (this.exitValueMutex) {
                if (this.exitValue == null) {
                    try {
                        Libcore.os.kill(this.pid, OsConstants.SIGKILL);
                    } catch (ErrnoException e) {
                        System.logI("Failed to destroy process " + this.pid, e);
                    }
                }
            }
            IoUtils.closeQuietly(this.inputStream);
            IoUtils.closeQuietly(this.errorStream);
            IoUtils.closeQuietly(this.outputStream);
        }

        @Override // java.lang.Process
        public int exitValue() {
            int intValue;
            synchronized (this.exitValueMutex) {
                if (this.exitValue == null) {
                    throw new IllegalThreadStateException("Process has not yet terminated: " + this.pid);
                }
                intValue = this.exitValue.intValue();
            }
            return intValue;
        }

        @Override // java.lang.Process
        public InputStream getErrorStream() {
            return this.errorStream;
        }

        @Override // java.lang.Process
        public InputStream getInputStream() {
            return this.inputStream;
        }

        @Override // java.lang.Process
        public OutputStream getOutputStream() {
            return this.outputStream;
        }

        void setExitValue(int i) {
            synchronized (this.exitValueMutex) {
                this.exitValue = Integer.valueOf(i);
                this.exitValueMutex.notifyAll();
            }
        }

        public String toString() {
            return "Process[pid=" + this.pid + "]";
        }

        @Override // java.lang.Process
        public int waitFor() throws InterruptedException {
            int intValue;
            synchronized (this.exitValueMutex) {
                while (this.exitValue == null) {
                    this.exitValueMutex.wait();
                }
                intValue = this.exitValue.intValue();
            }
            return intValue;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/ProcessManager$ProcessInputStream.class */
    private static class ProcessInputStream extends FileInputStream {
        private FileDescriptor fd;

        private ProcessInputStream(FileDescriptor fileDescriptor) {
            super(fileDescriptor);
            this.fd = fileDescriptor;
        }

        @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                super.close();
                synchronized (this) {
                    IoUtils.close(this.fd);
                    this.fd = null;
                }
            } catch (Throwable th) {
                synchronized (this) {
                    IoUtils.close(this.fd);
                    this.fd = null;
                    throw th;
                }
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/lang/ProcessManager$ProcessOutputStream.class */
    private static class ProcessOutputStream extends FileOutputStream {
        private FileDescriptor fd;

        private ProcessOutputStream(FileDescriptor fileDescriptor) {
            super(fileDescriptor);
            this.fd = fileDescriptor;
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                super.close();
                synchronized (this) {
                    IoUtils.close(this.fd);
                    this.fd = null;
                }
            } catch (Throwable th) {
                synchronized (this) {
                    IoUtils.close(this.fd);
                    this.fd = null;
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/ProcessManager$ProcessReference.class */
    public static class ProcessReference extends WeakReference<ProcessImpl> {
        final int processId;

        public ProcessReference(ProcessImpl processImpl, ProcessReferenceQueue processReferenceQueue) {
            super(processImpl, processReferenceQueue);
            this.processId = processImpl.pid;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/ProcessManager$ProcessReferenceQueue.class */
    public static class ProcessReferenceQueue extends ReferenceQueue<ProcessImpl> {
        ProcessReferenceQueue() {
        }

        @Override // java.lang.ref.ReferenceQueue
        /* renamed from: poll */
        public Reference<? extends ProcessImpl> poll2() {
            return (ProcessReference) super.poll();
        }
    }

    private ProcessManager() {
        Thread thread = new Thread(ProcessManager.class.getName()) { // from class: java.lang.ProcessManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                ProcessManager.this.watchChildren();
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.ProcessManager$ProcessReference] */
    private void cleanUp() {
        while (true) {
            ?? poll2 = this.referenceQueue.poll2();
            if (poll2 == 0) {
                return;
            }
            synchronized (this.processReferences) {
                this.processReferences.remove(Integer.valueOf(poll2.processId));
            }
        }
    }

    private static native int exec(String[] strArr, String[] strArr2, String str, FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, FileDescriptor fileDescriptor3, boolean z) throws IOException;

    public static ProcessManager getInstance() {
        return instance;
    }

    private void onExit(int i, int i2) {
        ProcessReference remove;
        ProcessImpl processImpl;
        synchronized (this.processReferences) {
            cleanUp();
            remove = this.processReferences.remove(Integer.valueOf(i));
        }
        if (remove == null || (processImpl = remove.get()) == null) {
            return;
        }
        processImpl.setExitValue(i2);
    }

    private void waitForMoreChildren() {
        synchronized (this.processReferences) {
            if (this.processReferences.isEmpty()) {
                try {
                    this.processReferences.wait();
                } catch (InterruptedException e) {
                    throw new AssertionError("unexpected interrupt");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void watchChildren() {
        int WEXITSTATUS;
        MutableInt mutableInt = new MutableInt(-1);
        while (true) {
            try {
                int waitpid = Libcore.os.waitpid(0, mutableInt, 0);
                if (!OsConstants.WIFEXITED(mutableInt.value)) {
                    if (!OsConstants.WIFSIGNALED(mutableInt.value)) {
                        if (!OsConstants.WIFSTOPPED(mutableInt.value)) {
                            throw new AssertionError("unexpected status from waitpid: " + mutableInt.value);
                            break;
                        }
                        WEXITSTATUS = OsConstants.WSTOPSIG(mutableInt.value);
                    } else {
                        WEXITSTATUS = OsConstants.WTERMSIG(mutableInt.value);
                    }
                } else {
                    WEXITSTATUS = OsConstants.WEXITSTATUS(mutableInt.value);
                }
                onExit(waitpid, WEXITSTATUS);
            } catch (ErrnoException e) {
                if (e.errno != OsConstants.ECHILD) {
                    throw new AssertionError(e);
                }
                waitForMoreChildren();
            }
        }
    }

    public Process exec(String[] strArr, String[] strArr2, File file, boolean z) throws IOException {
        ProcessImpl processImpl;
        if (strArr == null) {
            throw new NullPointerException("taintedCommand == null");
        }
        if (strArr.length == 0) {
            throw new IndexOutOfBoundsException("taintedCommand.length == 0");
        }
        String[] strArr3 = (String[]) strArr.clone();
        String[] strArr4 = strArr2 != null ? (String[]) strArr2.clone() : null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr3.length) {
                if (strArr4 != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= strArr4.length) {
                            break;
                        } else if (strArr4[i4] == null) {
                            throw new NullPointerException("taintedEnvironment[" + i4 + "] == null");
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                }
                FileDescriptor fileDescriptor = new FileDescriptor();
                FileDescriptor fileDescriptor2 = new FileDescriptor();
                FileDescriptor fileDescriptor3 = new FileDescriptor();
                String path = file == null ? null : file.getPath();
                synchronized (this.processReferences) {
                    try {
                        int exec = exec(strArr3, strArr4, path, fileDescriptor, fileDescriptor2, fileDescriptor3, z);
                        processImpl = new ProcessImpl(exec, fileDescriptor, fileDescriptor2, fileDescriptor3);
                        this.processReferences.put(Integer.valueOf(exec), new ProcessReference(processImpl, this.referenceQueue));
                        this.processReferences.notifyAll();
                    } catch (IOException e) {
                        IOException iOException = new IOException("Error running exec(). Command: " + Arrays.toString(strArr3) + " Working Directory: " + file + " Environment: " + Arrays.toString(strArr4));
                        iOException.initCause(e);
                        throw iOException;
                    }
                }
                return processImpl;
            } else if (strArr3[i2] == null) {
                throw new NullPointerException("taintedCommand[" + i2 + "] == null");
            } else {
                i = i2 + 1;
            }
        }
    }
}
