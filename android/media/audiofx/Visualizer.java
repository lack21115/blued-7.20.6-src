package android.media.audiofx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Visualizer.class */
public class Visualizer {
    public static final int ALREADY_EXISTS = -2;
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -4;
    public static final int ERROR_DEAD_OBJECT = -7;
    public static final int ERROR_INVALID_OPERATION = -5;
    public static final int ERROR_NO_INIT = -3;
    public static final int ERROR_NO_MEMORY = -6;
    public static final int MEASUREMENT_MODE_NONE = 0;
    public static final int MEASUREMENT_MODE_PEAK_RMS = 1;
    private static final int NATIVE_EVENT_FFT_CAPTURE = 1;
    private static final int NATIVE_EVENT_PCM_CAPTURE = 0;
    private static final int NATIVE_EVENT_SERVER_DIED = 2;
    public static final int SCALING_MODE_AS_PLAYED = 1;
    public static final int SCALING_MODE_NORMALIZED = 0;
    public static final int STATE_ENABLED = 2;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_UNINITIALIZED = 0;
    public static final int SUCCESS = 0;
    private static final String TAG = "Visualizer-JAVA";
    private int mId;
    private long mJniData;
    private long mNativeVisualizer;
    private int mState;
    private final Object mStateLock = new Object();
    private final Object mListenerLock = new Object();
    private NativeEventHandler mNativeEventHandler = null;
    private OnDataCaptureListener mCaptureListener = null;
    private OnServerDiedListener mServerDiedListener = null;

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Visualizer$MeasurementPeakRms.class */
    public static final class MeasurementPeakRms {
        public int mPeak;
        public int mRms;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Visualizer$NativeEventHandler.class */
    private class NativeEventHandler extends Handler {
        private Visualizer mVisualizer;

        public NativeEventHandler(Visualizer visualizer, Looper looper) {
            super(looper);
            this.mVisualizer = visualizer;
        }

        private void handleCaptureMessage(Message message) {
            OnDataCaptureListener onDataCaptureListener;
            synchronized (Visualizer.this.mListenerLock) {
                onDataCaptureListener = this.mVisualizer.mCaptureListener;
            }
            if (onDataCaptureListener != null) {
                byte[] bArr = (byte[]) message.obj;
                int i = message.arg1;
                switch (message.what) {
                    case 0:
                        onDataCaptureListener.onWaveFormDataCapture(this.mVisualizer, bArr, i);
                        return;
                    case 1:
                        onDataCaptureListener.onFftDataCapture(this.mVisualizer, bArr, i);
                        return;
                    default:
                        Log.e(Visualizer.TAG, "Unknown native event in handleCaptureMessge: " + message.what);
                        return;
                }
            }
        }

        private void handleServerDiedMessage(Message message) {
            OnServerDiedListener onServerDiedListener;
            synchronized (Visualizer.this.mListenerLock) {
                onServerDiedListener = this.mVisualizer.mServerDiedListener;
            }
            if (onServerDiedListener != null) {
                onServerDiedListener.onServerDied();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mVisualizer == null) {
                return;
            }
            switch (message.what) {
                case 0:
                case 1:
                    handleCaptureMessage(message);
                    return;
                case 2:
                    handleServerDiedMessage(message);
                    return;
                default:
                    Log.e(Visualizer.TAG, "Unknown native event: " + message.what);
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Visualizer$OnDataCaptureListener.class */
    public interface OnDataCaptureListener {
        void onFftDataCapture(Visualizer visualizer, byte[] bArr, int i);

        void onWaveFormDataCapture(Visualizer visualizer, byte[] bArr, int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Visualizer$OnServerDiedListener.class */
    public interface OnServerDiedListener {
        void onServerDied();
    }

    static {
        System.loadLibrary("audioeffect_jni");
        native_init();
    }

    public Visualizer(int i) throws UnsupportedOperationException, RuntimeException {
        this.mState = 0;
        int[] iArr = new int[1];
        synchronized (this.mStateLock) {
            this.mState = 0;
            int native_setup = native_setup(new WeakReference(this), i, iArr);
            if (native_setup != 0 && native_setup != -2) {
                Log.e(TAG, "Error code " + native_setup + " when initializing Visualizer.");
                switch (native_setup) {
                    case -5:
                        throw new UnsupportedOperationException("Effect library not loaded");
                    default:
                        throw new RuntimeException("Cannot initialize Visualizer engine, error: " + native_setup);
                }
            }
            this.mId = iArr[0];
            if (native_getEnabled()) {
                this.mState = 2;
            } else {
                this.mState = 1;
            }
        }
    }

    public static native int[] getCaptureSizeRange();

    public static native int getMaxCaptureRate();

    private final native void native_finalize();

    private final native int native_getCaptureSize();

    private final native boolean native_getEnabled();

    private final native int native_getFft(byte[] bArr);

    private final native int native_getMeasurementMode();

    private final native int native_getPeakRms(MeasurementPeakRms measurementPeakRms);

    private final native int native_getSamplingRate();

    private final native int native_getScalingMode();

    private final native int native_getWaveForm(byte[] bArr);

    private static final native void native_init();

    private final native void native_release();

    private final native int native_setCaptureSize(int i);

    private final native int native_setEnabled(boolean z);

    private final native int native_setMeasurementMode(int i);

    private final native int native_setPeriodicCapture(int i, boolean z, boolean z2);

    private final native int native_setScalingMode(int i);

    private final native int native_setup(Object obj, int i, int[] iArr);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        Visualizer visualizer = (Visualizer) ((WeakReference) obj).get();
        if (visualizer == null || visualizer.mNativeEventHandler == null) {
            return;
        }
        visualizer.mNativeEventHandler.sendMessage(visualizer.mNativeEventHandler.obtainMessage(i, i2, i3, obj2));
    }

    protected void finalize() {
        native_finalize();
    }

    public int getCaptureSize() throws IllegalStateException {
        int native_getCaptureSize;
        synchronized (this.mStateLock) {
            if (this.mState == 0) {
                throw new IllegalStateException("getCaptureSize() called in wrong state: " + this.mState);
            }
            native_getCaptureSize = native_getCaptureSize();
        }
        return native_getCaptureSize;
    }

    public boolean getEnabled() {
        boolean native_getEnabled;
        synchronized (this.mStateLock) {
            if (this.mState == 0) {
                throw new IllegalStateException("getEnabled() called in wrong state: " + this.mState);
            }
            native_getEnabled = native_getEnabled();
        }
        return native_getEnabled;
    }

    public int getFft(byte[] bArr) throws IllegalStateException {
        int native_getFft;
        synchronized (this.mStateLock) {
            if (this.mState != 2) {
                throw new IllegalStateException("getFft() called in wrong state: " + this.mState);
            }
            native_getFft = native_getFft(bArr);
        }
        return native_getFft;
    }

    public int getMeasurementMode() throws IllegalStateException {
        int native_getMeasurementMode;
        synchronized (this.mStateLock) {
            if (this.mState == 0) {
                throw new IllegalStateException("getMeasurementMode() called in wrong state: " + this.mState);
            }
            native_getMeasurementMode = native_getMeasurementMode();
        }
        return native_getMeasurementMode;
    }

    public int getMeasurementPeakRms(MeasurementPeakRms measurementPeakRms) {
        int native_getPeakRms;
        if (measurementPeakRms == null) {
            Log.e(TAG, "Cannot store measurements in a null object");
            return -4;
        }
        synchronized (this.mStateLock) {
            if (this.mState != 2) {
                throw new IllegalStateException("getMeasurementPeakRms() called in wrong state: " + this.mState);
            }
            native_getPeakRms = native_getPeakRms(measurementPeakRms);
        }
        return native_getPeakRms;
    }

    public int getSamplingRate() throws IllegalStateException {
        int native_getSamplingRate;
        synchronized (this.mStateLock) {
            if (this.mState == 0) {
                throw new IllegalStateException("getSamplingRate() called in wrong state: " + this.mState);
            }
            native_getSamplingRate = native_getSamplingRate();
        }
        return native_getSamplingRate;
    }

    public int getScalingMode() throws IllegalStateException {
        int native_getScalingMode;
        synchronized (this.mStateLock) {
            if (this.mState == 0) {
                throw new IllegalStateException("getScalingMode() called in wrong state: " + this.mState);
            }
            native_getScalingMode = native_getScalingMode();
        }
        return native_getScalingMode;
    }

    public int getWaveForm(byte[] bArr) throws IllegalStateException {
        int native_getWaveForm;
        synchronized (this.mStateLock) {
            if (this.mState != 2) {
                throw new IllegalStateException("getWaveForm() called in wrong state: " + this.mState);
            }
            native_getWaveForm = native_getWaveForm(bArr);
        }
        return native_getWaveForm;
    }

    public void release() {
        synchronized (this.mStateLock) {
            native_release();
            this.mState = 0;
        }
    }

    public int setCaptureSize(int i) throws IllegalStateException {
        int native_setCaptureSize;
        synchronized (this.mStateLock) {
            if (this.mState != 1) {
                throw new IllegalStateException("setCaptureSize() called in wrong state: " + this.mState);
            }
            native_setCaptureSize = native_setCaptureSize(i);
        }
        return native_setCaptureSize;
    }

    public int setDataCaptureListener(OnDataCaptureListener onDataCaptureListener, int i, boolean z, boolean z2) {
        synchronized (this.mListenerLock) {
            this.mCaptureListener = onDataCaptureListener;
        }
        if (onDataCaptureListener == null) {
            z = false;
            z2 = false;
        }
        int native_setPeriodicCapture = native_setPeriodicCapture(i, z, z2);
        if (native_setPeriodicCapture == 0 && onDataCaptureListener != null && this.mNativeEventHandler == null) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper != null) {
                    this.mNativeEventHandler = new NativeEventHandler(this, mainLooper);
                    return native_setPeriodicCapture;
                }
                this.mNativeEventHandler = null;
                return -3;
            }
            this.mNativeEventHandler = new NativeEventHandler(this, myLooper);
        }
        return native_setPeriodicCapture;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (r5.mState == 2) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setEnabled(boolean r6) throws java.lang.IllegalStateException {
        /*
            r5 = this;
            r0 = 2
            r9 = r0
            r0 = r5
            java.lang.Object r0 = r0.mStateLock
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            r0 = r5
            int r0 = r0.mState     // Catch: java.lang.Throwable -> L32
            if (r0 != 0) goto L3a
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L32
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r3 = r2
            r3.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "setEnabled() called in wrong state: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L32
            r3 = r5
            int r3 = r3.mState     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L32
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L32
            throw r0     // Catch: java.lang.Throwable -> L32
        L32:
            r11 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r0 = r11
            throw r0
        L3a:
            r0 = 0
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L48
            r0 = r5
            int r0 = r0.mState     // Catch: java.lang.Throwable -> L32
            r1 = 1
            if (r0 == r1) goto L58
        L48:
            r0 = r8
            r7 = r0
            r0 = r6
            if (r0 != 0) goto L72
            r0 = r8
            r7 = r0
            r0 = r5
            int r0 = r0.mState     // Catch: java.lang.Throwable -> L32
            r1 = 2
            if (r0 != r1) goto L72
        L58:
            r0 = r5
            r1 = r6
            int r0 = r0.native_setEnabled(r1)     // Catch: java.lang.Throwable -> L32
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            if (r0 != 0) goto L72
            r0 = r6
            if (r0 == 0) goto L77
            r0 = r9
            r7 = r0
        L6b:
            r0 = r5
            r1 = r7
            r0.mState = r1     // Catch: java.lang.Throwable -> L32
            r0 = r8
            r7 = r0
        L72:
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r0 = r7
            return r0
        L77:
            r0 = 1
            r7 = r0
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.audiofx.Visualizer.setEnabled(boolean):int");
    }

    public int setMeasurementMode(int i) throws IllegalStateException {
        int native_setMeasurementMode;
        synchronized (this.mStateLock) {
            if (this.mState == 0) {
                throw new IllegalStateException("setMeasurementMode() called in wrong state: " + this.mState);
            }
            native_setMeasurementMode = native_setMeasurementMode(i);
        }
        return native_setMeasurementMode;
    }

    public int setScalingMode(int i) throws IllegalStateException {
        int native_setScalingMode;
        synchronized (this.mStateLock) {
            if (this.mState == 0) {
                throw new IllegalStateException("setScalingMode() called in wrong state: " + this.mState);
            }
            native_setScalingMode = native_setScalingMode(i);
        }
        return native_setScalingMode;
    }

    public int setServerDiedListener(OnServerDiedListener onServerDiedListener) {
        synchronized (this.mListenerLock) {
            this.mServerDiedListener = onServerDiedListener;
        }
        return 0;
    }
}
