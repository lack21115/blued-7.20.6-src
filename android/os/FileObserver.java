package android.os;

import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/os/FileObserver.class */
public abstract class FileObserver {
    public static final int ACCESS = 1;
    public static final int ALL_EVENTS = 4095;
    public static final int ATTRIB = 4;
    public static final int CLOSE_NOWRITE = 16;
    public static final int CLOSE_WRITE = 8;
    public static final int CREATE = 256;
    public static final int DELETE = 512;
    public static final int DELETE_SELF = 1024;
    private static final String LOG_TAG = "FileObserver";
    public static final int MODIFY = 2;
    public static final int MOVED_FROM = 64;
    public static final int MOVED_TO = 128;
    public static final int MOVE_SELF = 2048;
    public static final int OPEN = 32;
    private static ObserverThread s_observerThread = new ObserverThread();
    private Integer m_descriptor;
    private int m_mask;
    private String m_path;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/FileObserver$ObserverThread.class */
    public static class ObserverThread extends Thread {
        private int m_fd;
        private HashMap<Integer, WeakReference> m_observers;

        public ObserverThread() {
            super(FileObserver.LOG_TAG);
            this.m_observers = new HashMap<>();
            this.m_fd = init();
        }

        private native int init();

        private native void observe(int i);

        private native int startWatching(int i, String str, int i2);

        private native void stopWatching(int i, int i2);

        public void onEvent(int i, int i2, String str) {
            FileObserver fileObserver = null;
            synchronized (this.m_observers) {
                WeakReference weakReference = this.m_observers.get(Integer.valueOf(i));
                if (weakReference != null) {
                    FileObserver fileObserver2 = (FileObserver) weakReference.get();
                    fileObserver = fileObserver2;
                    if (fileObserver2 == null) {
                        this.m_observers.remove(Integer.valueOf(i));
                        fileObserver = fileObserver2;
                    }
                }
            }
            if (fileObserver != null) {
                try {
                    fileObserver.onEvent(i2, str);
                } catch (Throwable th) {
                    Log.wtf(FileObserver.LOG_TAG, "Unhandled exception in FileObserver " + fileObserver, th);
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            observe(this.m_fd);
        }

        public int startWatching(String str, int i, FileObserver fileObserver) {
            int startWatching = startWatching(this.m_fd, str, i);
            Integer num = new Integer(startWatching);
            if (startWatching >= 0) {
                synchronized (this.m_observers) {
                    this.m_observers.put(num, new WeakReference(fileObserver));
                }
            }
            return num.intValue();
        }

        public void stopWatching(int i) {
            stopWatching(this.m_fd, i);
        }
    }

    static {
        s_observerThread.start();
    }

    public FileObserver(String str) {
        this(str, 4095);
    }

    public FileObserver(String str, int i) {
        this.m_path = str;
        this.m_mask = i;
        this.m_descriptor = -1;
    }

    protected void finalize() {
        stopWatching();
    }

    public abstract void onEvent(int i, String str);

    public void startWatching() {
        if (this.m_descriptor.intValue() < 0) {
            this.m_descriptor = Integer.valueOf(s_observerThread.startWatching(this.m_path, this.m_mask, this));
        }
    }

    public void stopWatching() {
        if (this.m_descriptor.intValue() >= 0) {
            s_observerThread.stopWatching(this.m_descriptor.intValue());
            this.m_descriptor = -1;
        }
    }
}
