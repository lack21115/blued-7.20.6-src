package android.hardware.camera2.impl;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.dispatch.ArgumentReplacingDispatcher;
import android.hardware.camera2.dispatch.BroadcastDispatcher;
import android.hardware.camera2.dispatch.DuckTypingDispatcher;
import android.hardware.camera2.dispatch.HandlerDispatcher;
import android.hardware.camera2.dispatch.InvokeDispatcher;
import android.hardware.camera2.impl.CallbackProxies;
import android.hardware.camera2.impl.CameraDeviceImpl;
import android.hardware.camera2.utils.TaskDrainer;
import android.hardware.camera2.utils.TaskSingleDrainer;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.android.internal.util.Preconditions;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraCaptureSessionImpl.class */
public class CameraCaptureSessionImpl extends CameraCaptureSession {
    private static final String TAG = "CameraCaptureSession";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    private final TaskSingleDrainer mAbortDrainer;
    private volatile boolean mAborting;
    private boolean mClosed;
    private final boolean mConfigureSuccess;
    private final Handler mDeviceHandler;
    private final CameraDeviceImpl mDeviceImpl;
    private final int mId;
    private final String mIdString;
    private final TaskSingleDrainer mIdleDrainer;
    private final List<Surface> mOutputs;
    private final TaskDrainer<Integer> mSequenceDrainer;
    private boolean mSkipUnconfigure = false;
    private final CameraCaptureSession.StateCallback mStateCallback;
    private final Handler mStateHandler;
    private final TaskSingleDrainer mUnconfigureDrainer;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraCaptureSessionImpl$AbortDrainListener.class */
    private class AbortDrainListener implements TaskDrainer.DrainListener {
        private AbortDrainListener() {
        }

        @Override // android.hardware.camera2.utils.TaskDrainer.DrainListener
        public void onDrained() {
            if (CameraCaptureSessionImpl.VERBOSE) {
                Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onAbortDrained");
            }
            synchronized (CameraCaptureSessionImpl.this) {
                CameraCaptureSessionImpl.this.mIdleDrainer.beginDrain();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraCaptureSessionImpl$IdleDrainListener.class */
    private class IdleDrainListener implements TaskDrainer.DrainListener {
        private IdleDrainListener() {
        }

        @Override // android.hardware.camera2.utils.TaskDrainer.DrainListener
        public void onDrained() {
            if (CameraCaptureSessionImpl.VERBOSE) {
                Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onIdleDrained");
            }
            synchronized (CameraCaptureSessionImpl.this.mDeviceImpl.mInterfaceLock) {
                synchronized (CameraCaptureSessionImpl.this) {
                    if (CameraCaptureSessionImpl.VERBOSE) {
                        Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "Session drain complete, skip unconfigure: " + CameraCaptureSessionImpl.this.mSkipUnconfigure);
                    }
                    if (CameraCaptureSessionImpl.this.mSkipUnconfigure) {
                        CameraCaptureSessionImpl.this.mStateCallback.onClosed(CameraCaptureSessionImpl.this);
                        return;
                    }
                    CameraCaptureSessionImpl.this.mUnconfigureDrainer.taskStarted();
                    try {
                        try {
                            CameraCaptureSessionImpl.this.mDeviceImpl.configureOutputsChecked(null);
                        } catch (IllegalStateException e) {
                            if (CameraCaptureSessionImpl.VERBOSE) {
                                Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "Camera was already closed or busy, skipping unconfigure");
                            }
                            CameraCaptureSessionImpl.this.mUnconfigureDrainer.taskFinished();
                        }
                    } catch (CameraAccessException e2) {
                        Log.e(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "Exception while configuring outputs: ", e2);
                    }
                    CameraCaptureSessionImpl.this.mUnconfigureDrainer.beginDrain();
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraCaptureSessionImpl$SequenceDrainListener.class */
    private class SequenceDrainListener implements TaskDrainer.DrainListener {
        private SequenceDrainListener() {
        }

        @Override // android.hardware.camera2.utils.TaskDrainer.DrainListener
        public void onDrained() {
            if (CameraCaptureSessionImpl.VERBOSE) {
                Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onSequenceDrained");
            }
            CameraCaptureSessionImpl.this.mAbortDrainer.beginDrain();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraCaptureSessionImpl$UnconfigureDrainListener.class */
    private class UnconfigureDrainListener implements TaskDrainer.DrainListener {
        private UnconfigureDrainListener() {
        }

        @Override // android.hardware.camera2.utils.TaskDrainer.DrainListener
        public void onDrained() {
            if (CameraCaptureSessionImpl.VERBOSE) {
                Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onUnconfigureDrained");
            }
            synchronized (CameraCaptureSessionImpl.this) {
                CameraCaptureSessionImpl.this.mStateCallback.onClosed(CameraCaptureSessionImpl.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraCaptureSessionImpl(int i, List<Surface> list, CameraCaptureSession.StateCallback stateCallback, Handler handler, CameraDeviceImpl cameraDeviceImpl, Handler handler2, boolean z) {
        this.mClosed = false;
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("outputs must be a non-null, non-empty list");
        }
        if (stateCallback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        this.mId = i;
        this.mIdString = String.format("Session %d: ", Integer.valueOf(this.mId));
        this.mOutputs = list;
        this.mStateHandler = CameraDeviceImpl.checkHandler(handler);
        this.mStateCallback = createUserStateCallbackProxy(this.mStateHandler, stateCallback);
        this.mDeviceHandler = (Handler) Preconditions.checkNotNull(handler2, "deviceStateHandler must not be null");
        this.mDeviceImpl = (CameraDeviceImpl) Preconditions.checkNotNull(cameraDeviceImpl, "deviceImpl must not be null");
        this.mSequenceDrainer = new TaskDrainer<>(this.mDeviceHandler, new SequenceDrainListener(), "seq");
        this.mIdleDrainer = new TaskSingleDrainer(this.mDeviceHandler, new IdleDrainListener(), "idle");
        this.mAbortDrainer = new TaskSingleDrainer(this.mDeviceHandler, new AbortDrainListener(), "abort");
        this.mUnconfigureDrainer = new TaskSingleDrainer(this.mDeviceHandler, new UnconfigureDrainListener(), "unconf");
        if (z) {
            this.mStateCallback.onConfigured(this);
            if (VERBOSE) {
                Log.v(TAG, this.mIdString + "Created session successfully");
            }
            this.mConfigureSuccess = true;
            return;
        }
        this.mStateCallback.onConfigureFailed(this);
        this.mClosed = true;
        Log.e(TAG, this.mIdString + "Failed to create capture session; configuration failed");
        this.mConfigureSuccess = false;
    }

    private int addPendingSequence(int i) {
        this.mSequenceDrainer.taskStarted(Integer.valueOf(i));
        return i;
    }

    private void checkNotClosed() {
        if (this.mClosed) {
            throw new IllegalStateException("Session has been closed; further changes are illegal.");
        }
    }

    private CameraDeviceImpl.CaptureCallback createCaptureCallbackProxy(Handler handler, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraDeviceImpl.CaptureCallback captureCallback2 = new CameraDeviceImpl.CaptureCallback() { // from class: android.hardware.camera2.impl.CameraCaptureSessionImpl.1
            @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
            public void onCaptureSequenceAborted(CameraDevice cameraDevice, int i) {
                CameraCaptureSessionImpl.this.finishPendingSequence(i);
            }

            @Override // android.hardware.camera2.impl.CameraDeviceImpl.CaptureCallback
            public void onCaptureSequenceCompleted(CameraDevice cameraDevice, int i, long j) {
                CameraCaptureSessionImpl.this.finishPendingSequence(i);
            }
        };
        return captureCallback == null ? captureCallback2 : new CallbackProxies.DeviceCaptureCallbackProxy(new BroadcastDispatcher(new ArgumentReplacingDispatcher(new DuckTypingDispatcher(new HandlerDispatcher(new InvokeDispatcher(captureCallback), handler), CameraCaptureSession.CaptureCallback.class), 0, this), new InvokeDispatcher(captureCallback2)));
    }

    private CameraCaptureSession.StateCallback createUserStateCallbackProxy(Handler handler, CameraCaptureSession.StateCallback stateCallback) {
        return new CallbackProxies.SessionStateCallbackProxy(new HandlerDispatcher(new InvokeDispatcher(stateCallback), handler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPendingSequence(int i) {
        this.mSequenceDrainer.taskFinished(Integer.valueOf(i));
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public void abortCaptures() throws CameraAccessException {
        synchronized (this) {
            checkNotClosed();
            if (VERBOSE) {
                Log.v(TAG, this.mIdString + "abortCaptures");
            }
            if (this.mAborting) {
                Log.w(TAG, this.mIdString + "abortCaptures - Session is already aborting; doing nothing");
            } else {
                this.mAborting = true;
                this.mAbortDrainer.taskStarted();
                this.mDeviceImpl.flush();
            }
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public int capture(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        int addPendingSequence;
        synchronized (this) {
            if (captureRequest == null) {
                throw new IllegalArgumentException("request must not be null");
            }
            checkNotClosed();
            Handler checkHandler = CameraDeviceImpl.checkHandler(handler, captureCallback);
            if (VERBOSE) {
                Log.v(TAG, this.mIdString + "capture - request " + captureRequest + ", callback " + captureCallback + " handler " + checkHandler);
            }
            addPendingSequence = addPendingSequence(this.mDeviceImpl.capture(captureRequest, createCaptureCallbackProxy(checkHandler, captureCallback), this.mDeviceHandler));
        }
        return addPendingSequence;
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public int captureBurst(List<CaptureRequest> list, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        int addPendingSequence;
        synchronized (this) {
            if (list == null) {
                throw new IllegalArgumentException("requests must not be null");
            }
            if (list.isEmpty()) {
                throw new IllegalArgumentException("requests must have at least one element");
            }
            checkNotClosed();
            Handler checkHandler = CameraDeviceImpl.checkHandler(handler, captureCallback);
            if (VERBOSE) {
                Log.v(TAG, this.mIdString + "captureBurst - requests " + Arrays.toString((CaptureRequest[]) list.toArray(new CaptureRequest[0])) + ", callback " + captureCallback + " handler " + checkHandler);
            }
            addPendingSequence = addPendingSequence(this.mDeviceImpl.captureBurst(list, createCaptureCallbackProxy(checkHandler, captureCallback), this.mDeviceHandler));
        }
        return addPendingSequence;
    }

    @Override // android.hardware.camera2.CameraCaptureSession, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                if (VERBOSE) {
                    Log.v(TAG, this.mIdString + "close - first time");
                }
                this.mClosed = true;
                try {
                    try {
                        this.mDeviceImpl.stopRepeating();
                    } catch (IllegalStateException e) {
                        Log.w(TAG, this.mIdString + "The camera device was already closed: ", e);
                        this.mStateCallback.onClosed(this);
                    }
                } catch (CameraAccessException e2) {
                    Log.e(TAG, this.mIdString + "Exception while stopping repeating: ", e2);
                }
                this.mSequenceDrainer.beginDrain();
            } else if (VERBOSE) {
                Log.v(TAG, this.mIdString + "close - reentering");
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public CameraDevice getDevice() {
        return this.mDeviceImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraDeviceImpl.StateCallbackKK getDeviceStateCallback() {
        return new CameraDeviceImpl.StateCallbackKK() { // from class: android.hardware.camera2.impl.CameraCaptureSessionImpl.2
            private boolean mBusy = false;
            private boolean mActive = false;

            @Override // android.hardware.camera2.impl.CameraDeviceImpl.StateCallbackKK
            public void onActive(CameraDevice cameraDevice) {
                CameraCaptureSessionImpl.this.mIdleDrainer.taskStarted();
                this.mActive = true;
                if (CameraCaptureSessionImpl.VERBOSE) {
                    Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onActive");
                }
                CameraCaptureSessionImpl.this.mStateCallback.onActive(this);
            }

            @Override // android.hardware.camera2.impl.CameraDeviceImpl.StateCallbackKK
            public void onBusy(CameraDevice cameraDevice) {
                this.mBusy = true;
                if (CameraCaptureSessionImpl.VERBOSE) {
                    Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onBusy");
                }
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice cameraDevice) {
                if (CameraCaptureSessionImpl.VERBOSE) {
                    Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onDisconnected");
                }
                CameraCaptureSessionImpl.this.close();
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice cameraDevice, int i) {
                Log.wtf(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "Got device error " + i);
            }

            @Override // android.hardware.camera2.impl.CameraDeviceImpl.StateCallbackKK
            public void onIdle(CameraDevice cameraDevice) {
                boolean z;
                if (CameraCaptureSessionImpl.VERBOSE) {
                    Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onIdle");
                }
                synchronized (this) {
                    z = CameraCaptureSessionImpl.this.mAborting;
                }
                if (this.mBusy && z) {
                    CameraCaptureSessionImpl.this.mAbortDrainer.taskFinished();
                    synchronized (this) {
                        CameraCaptureSessionImpl.this.mAborting = false;
                    }
                }
                if (this.mActive) {
                    CameraCaptureSessionImpl.this.mIdleDrainer.taskFinished();
                }
                this.mBusy = false;
                this.mActive = false;
                CameraCaptureSessionImpl.this.mStateCallback.onReady(this);
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice cameraDevice) {
                throw new AssertionError("Camera must already be open before creating a session");
            }

            @Override // android.hardware.camera2.impl.CameraDeviceImpl.StateCallbackKK
            public void onUnconfigured(CameraDevice cameraDevice) {
                if (CameraCaptureSessionImpl.VERBOSE) {
                    Log.v(CameraCaptureSessionImpl.TAG, CameraCaptureSessionImpl.this.mIdString + "onUnconfigured");
                }
                synchronized (this) {
                    if (CameraCaptureSessionImpl.this.mClosed && CameraCaptureSessionImpl.this.mConfigureSuccess && !CameraCaptureSessionImpl.this.mSkipUnconfigure) {
                        CameraCaptureSessionImpl.this.mUnconfigureDrainer.taskFinished();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAborting() {
        return this.mAborting;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceSessionClose() {
        synchronized (this) {
            if (VERBOSE) {
                Log.v(TAG, this.mIdString + "replaceSessionClose");
            }
            this.mSkipUnconfigure = true;
            close();
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public int setRepeatingBurst(List<CaptureRequest> list, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        int addPendingSequence;
        synchronized (this) {
            if (list == null) {
                throw new IllegalArgumentException("requests must not be null");
            }
            if (list.isEmpty()) {
                throw new IllegalArgumentException("requests must have at least one element");
            }
            checkNotClosed();
            Handler checkHandler = CameraDeviceImpl.checkHandler(handler, captureCallback);
            if (VERBOSE) {
                Log.v(TAG, this.mIdString + "setRepeatingBurst - requests " + Arrays.toString((CaptureRequest[]) list.toArray(new CaptureRequest[0])) + ", callback " + captureCallback + " handler" + checkHandler);
            }
            addPendingSequence = addPendingSequence(this.mDeviceImpl.setRepeatingBurst(list, createCaptureCallbackProxy(checkHandler, captureCallback), this.mDeviceHandler));
        }
        return addPendingSequence;
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public int setRepeatingRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        int addPendingSequence;
        synchronized (this) {
            if (captureRequest == null) {
                throw new IllegalArgumentException("request must not be null");
            }
            checkNotClosed();
            Handler checkHandler = CameraDeviceImpl.checkHandler(handler, captureCallback);
            if (VERBOSE) {
                Log.v(TAG, this.mIdString + "setRepeatingRequest - request " + captureRequest + ", callback " + captureCallback + " handler " + checkHandler);
            }
            addPendingSequence = addPendingSequence(this.mDeviceImpl.setRepeatingRequest(captureRequest, createCaptureCallbackProxy(checkHandler, captureCallback), this.mDeviceHandler));
        }
        return addPendingSequence;
    }

    @Override // android.hardware.camera2.CameraCaptureSession
    public void stopRepeating() throws CameraAccessException {
        synchronized (this) {
            checkNotClosed();
            if (VERBOSE) {
                Log.v(TAG, this.mIdString + "stopRepeating");
            }
            this.mDeviceImpl.stopRepeating();
        }
    }
}
