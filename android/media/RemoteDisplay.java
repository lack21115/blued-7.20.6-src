package android.media;

import android.os.Handler;
import android.view.Surface;
import dalvik.system.CloseGuard;

/* loaded from: source-9557208-dex2jar.jar:android/media/RemoteDisplay.class */
public final class RemoteDisplay {
    public static final int DISPLAY_ERROR_CONNECTION_DROPPED = 2;
    public static final int DISPLAY_ERROR_UNKOWN = 1;
    public static final int DISPLAY_FLAG_SECURE = 1;
    private final CloseGuard mGuard = CloseGuard.get();
    private final Handler mHandler;
    private final Listener mListener;
    private long mPtr;

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteDisplay$Listener.class */
    public interface Listener {
        void onDisplayConnected(Surface surface, int i, int i2, int i3, int i4);

        void onDisplayDisconnected();

        void onDisplayError(int i);
    }

    private RemoteDisplay(Listener listener, Handler handler) {
        this.mListener = listener;
        this.mHandler = handler;
    }

    private void dispose(boolean z) {
        if (this.mPtr != 0) {
            if (this.mGuard != null) {
                if (z) {
                    this.mGuard.warnIfOpen();
                } else {
                    this.mGuard.close();
                }
            }
            nativeDispose(this.mPtr);
            this.mPtr = 0L;
        }
    }

    public static RemoteDisplay listen(String str, Listener listener, Handler handler) {
        if (str == null) {
            throw new IllegalArgumentException("iface must not be null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler must not be null");
        }
        RemoteDisplay remoteDisplay = new RemoteDisplay(listener, handler);
        remoteDisplay.startListening(str);
        return remoteDisplay;
    }

    private native void nativeDispose(long j);

    private native long nativeListen(String str);

    private native void nativePause(long j);

    private native void nativeResume(long j);

    private void notifyDisplayConnected(final Surface surface, final int i, final int i2, final int i3, final int i4) {
        this.mHandler.post(new Runnable() { // from class: android.media.RemoteDisplay.1
            @Override // java.lang.Runnable
            public void run() {
                RemoteDisplay.this.mListener.onDisplayConnected(surface, i, i2, i3, i4);
            }
        });
    }

    private void notifyDisplayDisconnected() {
        this.mHandler.post(new Runnable() { // from class: android.media.RemoteDisplay.2
            @Override // java.lang.Runnable
            public void run() {
                RemoteDisplay.this.mListener.onDisplayDisconnected();
            }
        });
    }

    private void notifyDisplayError(final int i) {
        this.mHandler.post(new Runnable() { // from class: android.media.RemoteDisplay.3
            @Override // java.lang.Runnable
            public void run() {
                RemoteDisplay.this.mListener.onDisplayError(i);
            }
        });
    }

    private void startListening(String str) {
        this.mPtr = nativeListen(str);
        if (this.mPtr == 0) {
            throw new IllegalStateException("Could not start listening for remote display connection on \"" + str + "\"");
        }
        this.mGuard.open("dispose");
    }

    public void dispose() {
        dispose(false);
    }

    protected void finalize() throws Throwable {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    public void pause() {
        nativePause(this.mPtr);
    }

    public void resume() {
        nativeResume(this.mPtr);
    }
}
