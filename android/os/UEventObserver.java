package android.os;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/os/UEventObserver.class */
public abstract class UEventObserver {
    private static final boolean DEBUG = false;
    private static final String TAG = "UEventObserver";
    private static UEventThread sThread;

    /* loaded from: source-9557208-dex2jar.jar:android/os/UEventObserver$UEvent.class */
    public static final class UEvent {
        private final HashMap<String, String> mMap = new HashMap<>();

        public UEvent(String str) {
            int i = 0;
            int length = str.length();
            while (i < length) {
                int indexOf = str.indexOf(61, i);
                int indexOf2 = str.indexOf(0, i);
                if (indexOf2 < 0) {
                    return;
                }
                if (indexOf > i && indexOf < indexOf2) {
                    this.mMap.put(str.substring(i, indexOf), str.substring(indexOf + 1, indexOf2));
                }
                i = indexOf2 + 1;
            }
        }

        public String get(String str) {
            return this.mMap.get(str);
        }

        public String get(String str, String str2) {
            String str3 = this.mMap.get(str);
            return str3 == null ? str2 : str3;
        }

        public String toString() {
            return this.mMap.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/UEventObserver$UEventThread.class */
    public static final class UEventThread extends Thread {
        private final ArrayList<Object> mKeysAndObservers;
        private final ArrayList<UEventObserver> mTempObserversToSignal;

        public UEventThread() {
            super(UEventObserver.TAG);
            this.mKeysAndObservers = new ArrayList<>();
            this.mTempObserversToSignal = new ArrayList<>();
        }

        private void sendEvent(String str) {
            synchronized (this.mKeysAndObservers) {
                int size = this.mKeysAndObservers.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    if (str.contains((String) this.mKeysAndObservers.get(i2))) {
                        this.mTempObserversToSignal.add((UEventObserver) this.mKeysAndObservers.get(i2 + 1));
                    }
                    i = i2 + 2;
                }
            }
            if (this.mTempObserversToSignal.isEmpty()) {
                return;
            }
            UEvent uEvent = new UEvent(str);
            int size2 = this.mTempObserversToSignal.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    this.mTempObserversToSignal.clear();
                    return;
                } else {
                    this.mTempObserversToSignal.get(i4).onUEvent(uEvent);
                    i3 = i4 + 1;
                }
            }
        }

        public void addObserver(String str, UEventObserver uEventObserver) {
            synchronized (this.mKeysAndObservers) {
                this.mKeysAndObservers.add(str);
                this.mKeysAndObservers.add(uEventObserver);
                UEventObserver.nativeAddMatch(str);
            }
        }

        public void removeObserver(UEventObserver uEventObserver) {
            synchronized (this.mKeysAndObservers) {
                int i = 0;
                while (i < this.mKeysAndObservers.size()) {
                    if (this.mKeysAndObservers.get(i + 1) == uEventObserver) {
                        this.mKeysAndObservers.remove(i + 1);
                        UEventObserver.nativeRemoveMatch((String) this.mKeysAndObservers.remove(i));
                    } else {
                        i += 2;
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            UEventObserver.nativeSetup();
            while (true) {
                String access$100 = UEventObserver.access$100();
                if (access$100 != null) {
                    sendEvent(access$100);
                }
            }
        }
    }

    static /* synthetic */ String access$100() {
        return nativeWaitForNextEvent();
    }

    private static UEventThread getThread() {
        UEventThread uEventThread;
        synchronized (UEventObserver.class) {
            try {
                if (sThread == null) {
                    sThread = new UEventThread();
                    sThread.start();
                }
                uEventThread = sThread;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uEventThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAddMatch(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRemoveMatch(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetup();

    private static native String nativeWaitForNextEvent();

    private static UEventThread peekThread() {
        UEventThread uEventThread;
        synchronized (UEventObserver.class) {
            try {
                uEventThread = sThread;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uEventThread;
    }

    protected void finalize() throws Throwable {
        try {
            stopObserving();
        } finally {
            super.finalize();
        }
    }

    public abstract void onUEvent(UEvent uEvent);

    public final void startObserving(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("match substring must be non-empty");
        }
        getThread().addObserver(str, this);
    }

    public final void stopObserving() {
        UEventThread thread = getThread();
        if (thread != null) {
            thread.removeObserver(this);
        }
    }
}
