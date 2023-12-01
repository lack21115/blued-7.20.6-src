package android.media.projection;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.AudioRecord;
import android.media.projection.IMediaProjectionCallback;
import android.os.Handler;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import android.view.Surface;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/media/projection/MediaProjection.class */
public final class MediaProjection {
    private static final String TAG = "MediaProjection";
    private final Map<Callback, CallbackRecord> mCallbacks = new ArrayMap();
    private final Context mContext;
    private final IMediaProjection mImpl;

    /* loaded from: source-9557208-dex2jar.jar:android/media/projection/MediaProjection$Callback.class */
    public static abstract class Callback {
        public void onStop() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/projection/MediaProjection$CallbackRecord.class */
    private static final class CallbackRecord {
        private final Callback mCallback;
        private final Handler mHandler;

        public CallbackRecord(Callback callback, Handler handler) {
            this.mCallback = callback;
            this.mHandler = handler;
        }

        public void onStop() {
            this.mHandler.post(new Runnable() { // from class: android.media.projection.MediaProjection.CallbackRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    CallbackRecord.this.mCallback.onStop();
                }
            });
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/projection/MediaProjection$MediaProjectionCallback.class */
    private final class MediaProjectionCallback extends IMediaProjectionCallback.Stub {
        private MediaProjectionCallback() {
        }

        @Override // android.media.projection.IMediaProjectionCallback
        public void onStop() {
            for (CallbackRecord callbackRecord : MediaProjection.this.mCallbacks.values()) {
                callbackRecord.onStop();
            }
        }
    }

    public MediaProjection(Context context, IMediaProjection iMediaProjection) {
        this.mContext = context;
        this.mImpl = iMediaProjection;
        try {
            this.mImpl.start(new MediaProjectionCallback());
        } catch (RemoteException e) {
            throw new RuntimeException("Failed to start media projection", e);
        }
    }

    public AudioRecord createAudioRecord(int i, int i2, int i3, int i4) {
        return null;
    }

    public VirtualDisplay createVirtualDisplay(String str, int i, int i2, int i3, int i4, Surface surface, VirtualDisplay.Callback callback, Handler handler) {
        return ((DisplayManager) this.mContext.getSystemService("display")).createVirtualDisplay(this, str, i, i2, i3, surface, i4, callback, handler);
    }

    public VirtualDisplay createVirtualDisplay(String str, int i, int i2, int i3, boolean z, Surface surface, VirtualDisplay.Callback callback, Handler handler) {
        return ((DisplayManager) this.mContext.getSystemService("display")).createVirtualDisplay(this, str, i, i2, i3, surface, (z ? 4 : 0) | 16 | 2, callback, handler);
    }

    public IMediaProjection getProjection() {
        return this.mImpl;
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback should not be null");
        }
        Handler handler2 = handler;
        if (handler == null) {
            handler2 = new Handler();
        }
        this.mCallbacks.put(callback, new CallbackRecord(callback, handler2));
    }

    public void stop() {
        try {
            this.mImpl.stop();
        } catch (RemoteException e) {
            Log.e(TAG, "Unable to stop projection", e);
        }
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback should not be null");
        }
        this.mCallbacks.remove(callback);
    }
}
