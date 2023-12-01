package android.hardware.camera2.legacy;

import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.ICameraDeviceCallbacks;
import android.hardware.camera2.ICameraDeviceUser;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.impl.CaptureResultExtras;
import android.hardware.camera2.utils.CameraBinderDecorator;
import android.hardware.camera2.utils.CameraRuntimeException;
import android.hardware.camera2.utils.LongParcelable;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/CameraDeviceUserShim.class */
public class CameraDeviceUserShim implements ICameraDeviceUser {
    private static final boolean DEBUG = Log.isLoggable(LegacyCameraDevice.DEBUG_PROP, 3);
    private static final int OPEN_CAMERA_TIMEOUT_MS = 5000;
    private static final String TAG = "CameraDeviceUserShim";
    private final CameraCallbackThread mCameraCallbacks;
    private final CameraCharacteristics mCameraCharacteristics;
    private final CameraLooper mCameraInit;
    private final LegacyCameraDevice mLegacyDevice;
    private final Object mConfigureLock = new Object();
    private boolean mConfiguring = false;
    private final SparseArray<Surface> mSurfaces = new SparseArray<>();
    private int mSurfaceIdCounter = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/CameraDeviceUserShim$CameraCallbackThread.class */
    public static class CameraCallbackThread implements ICameraDeviceCallbacks {
        private static final int CAMERA_ERROR = 0;
        private static final int CAMERA_IDLE = 1;
        private static final int CAPTURE_STARTED = 2;
        private static final int RESULT_RECEIVED = 3;
        private final ICameraDeviceCallbacks mCallbacks;
        private Handler mHandler;
        private final HandlerThread mHandlerThread = new HandlerThread("LegacyCameraCallback");

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/CameraDeviceUserShim$CameraCallbackThread$CallbackHandler.class */
        public class CallbackHandler extends Handler {
            public CallbackHandler(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 0:
                            CameraCallbackThread.this.mCallbacks.onDeviceError(message.arg1, (CaptureResultExtras) message.obj);
                            return;
                        case 1:
                            CameraCallbackThread.this.mCallbacks.onDeviceIdle();
                            return;
                        case 2:
                            CameraCallbackThread.this.mCallbacks.onCaptureStarted((CaptureResultExtras) message.obj, ((message.arg2 & ExpandableListView.PACKED_POSITION_VALUE_NULL) << 32) | (message.arg1 & ExpandableListView.PACKED_POSITION_VALUE_NULL));
                            return;
                        case 3:
                            Object[] objArr = (Object[]) message.obj;
                            CameraCallbackThread.this.mCallbacks.onResultReceived((CameraMetadataNative) objArr[0], (CaptureResultExtras) objArr[1]);
                            return;
                        default:
                            throw new IllegalArgumentException("Unknown callback message " + message.what);
                    }
                } catch (RemoteException e) {
                    throw new IllegalStateException("Received remote exception during camera callback " + message.what, e);
                }
            }
        }

        public CameraCallbackThread(ICameraDeviceCallbacks iCameraDeviceCallbacks) {
            this.mCallbacks = iCameraDeviceCallbacks;
            this.mHandlerThread.start();
        }

        private Handler getHandler() {
            if (this.mHandler == null) {
                this.mHandler = new CallbackHandler(this.mHandlerThread.getLooper());
            }
            return this.mHandler;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        public void close() {
            this.mHandlerThread.quitSafely();
        }

        @Override // android.hardware.camera2.ICameraDeviceCallbacks
        public void onCaptureStarted(CaptureResultExtras captureResultExtras, long j) {
            getHandler().sendMessage(getHandler().obtainMessage(2, (int) (j & ExpandableListView.PACKED_POSITION_VALUE_NULL), (int) ((j >> 32) & ExpandableListView.PACKED_POSITION_VALUE_NULL), captureResultExtras));
        }

        @Override // android.hardware.camera2.ICameraDeviceCallbacks
        public void onDeviceError(int i, CaptureResultExtras captureResultExtras) {
            getHandler().sendMessage(getHandler().obtainMessage(0, i, 0, captureResultExtras));
        }

        @Override // android.hardware.camera2.ICameraDeviceCallbacks
        public void onDeviceIdle() {
            getHandler().sendMessage(getHandler().obtainMessage(1));
        }

        @Override // android.hardware.camera2.ICameraDeviceCallbacks
        public void onResultReceived(CameraMetadataNative cameraMetadataNative, CaptureResultExtras captureResultExtras) {
            getHandler().sendMessage(getHandler().obtainMessage(3, new Object[]{cameraMetadataNative, captureResultExtras}));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/CameraDeviceUserShim$CameraLooper.class */
    public static class CameraLooper implements Runnable, AutoCloseable {
        private final int mCameraId;
        private volatile int mInitErrors;
        private Looper mLooper;
        private final Camera mCamera = Camera.openUninitialized();
        private final ConditionVariable mStartDone = new ConditionVariable();
        private final Thread mThread = new Thread(this);

        public CameraLooper(int i) {
            this.mCameraId = i;
            this.mThread.start();
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.mLooper == null) {
                return;
            }
            this.mLooper.quitSafely();
            try {
                this.mThread.join();
                this.mLooper = null;
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }

        public Camera getCamera() {
            return this.mCamera;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.mLooper = Looper.myLooper();
            this.mInitErrors = CameraDeviceUserShim.translateErrorsFromCamera1(this.mCamera.cameraInitUnspecified(this.mCameraId));
            this.mStartDone.open();
            Looper.loop();
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:6:0x001b). Please submit an issue!!! */
        public int waitForOpen(int i) {
            if (this.mStartDone.block(i)) {
                return this.mInitErrors;
            }
            Log.e(CameraDeviceUserShim.TAG, "waitForOpen - Camera failed to open after timeout of 5000 ms");
            try {
                this.mCamera.release();
            } catch (RuntimeException e) {
                Log.e(CameraDeviceUserShim.TAG, "connectBinderShim - Failed to release camera after timeout ", e);
            }
            throw new CameraRuntimeException(3);
        }
    }

    protected CameraDeviceUserShim(int i, LegacyCameraDevice legacyCameraDevice, CameraCharacteristics cameraCharacteristics, CameraLooper cameraLooper, CameraCallbackThread cameraCallbackThread) {
        this.mLegacyDevice = legacyCameraDevice;
        this.mCameraCharacteristics = cameraCharacteristics;
        this.mCameraInit = cameraLooper;
        this.mCameraCallbacks = cameraCallbackThread;
    }

    public static CameraDeviceUserShim connectBinderShim(ICameraDeviceCallbacks iCameraDeviceCallbacks, int i) {
        if (DEBUG) {
            Log.d(TAG, "Opening shim Camera device");
        }
        CameraLooper cameraLooper = new CameraLooper(i);
        CameraCallbackThread cameraCallbackThread = new CameraCallbackThread(iCameraDeviceCallbacks);
        int waitForOpen = cameraLooper.waitForOpen(5000);
        Camera camera = cameraLooper.getCamera();
        CameraBinderDecorator.throwOnError(waitForOpen);
        camera.disableShutterSound();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        try {
            CameraCharacteristics createCharacteristics = LegacyMetadataMapper.createCharacteristics(camera.getParameters(), cameraInfo);
            return new CameraDeviceUserShim(i, new LegacyCameraDevice(i, camera, createCharacteristics, cameraCallbackThread), createCharacteristics, cameraLooper, cameraCallbackThread);
        } catch (RuntimeException e) {
            throw new CameraRuntimeException(3, "Unable to get initial parameters", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int translateErrorsFromCamera1(int i) {
        switch (i) {
            case -13:
                return -1;
            default:
                return i;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int beginConfigure() {
        if (DEBUG) {
            Log.d(TAG, "beginConfigure called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot begin configure, device has been closed.");
            return -19;
        }
        synchronized (this.mConfigureLock) {
            if (this.mConfiguring) {
                Log.e(TAG, "Cannot begin configure, configuration change already in progress.");
                return -38;
            }
            this.mConfiguring = true;
            return 0;
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int cancelRequest(int i, LongParcelable longParcelable) {
        if (DEBUG) {
            Log.d(TAG, "cancelRequest called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot cancel request, device has been closed.");
            return -19;
        }
        synchronized (this.mConfigureLock) {
            if (this.mConfiguring) {
                Log.e(TAG, "Cannot cancel request, configuration change in progress.");
                return -38;
            }
            longParcelable.setNumber(this.mLegacyDevice.cancelRequest(i));
            return 0;
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int createDefaultRequest(int i, CameraMetadataNative cameraMetadataNative) {
        if (DEBUG) {
            Log.d(TAG, "createDefaultRequest called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot create default request, device has been closed.");
            return -19;
        }
        try {
            cameraMetadataNative.swap(LegacyMetadataMapper.createRequestTemplate(this.mCameraCharacteristics, i));
            return 0;
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "createDefaultRequest - invalid templateId specified");
            return -22;
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int createStream(int i, int i2, int i3, Surface surface) {
        if (DEBUG) {
            Log.d(TAG, "createStream called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot create stream, device has been closed.");
            return -19;
        }
        synchronized (this.mConfigureLock) {
            if (!this.mConfiguring) {
                Log.e(TAG, "Cannot create stream, beginConfigure hasn't been called yet.");
                return -38;
            }
            int i4 = this.mSurfaceIdCounter + 1;
            this.mSurfaceIdCounter = i4;
            this.mSurfaces.put(i4, surface);
            return i4;
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int deleteStream(int i) {
        if (DEBUG) {
            Log.d(TAG, "deleteStream called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot delete stream, device has been closed.");
            return -19;
        }
        synchronized (this.mConfigureLock) {
            if (!this.mConfiguring) {
                Log.e(TAG, "Cannot delete stream, beginConfigure hasn't been called yet.");
                return -38;
            }
            int indexOfKey = this.mSurfaces.indexOfKey(i);
            if (indexOfKey < 0) {
                Log.e(TAG, "Cannot delete stream, stream id " + i + " doesn't exist.");
                return -22;
            }
            this.mSurfaces.removeAt(indexOfKey);
            return 0;
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public void disconnect() {
        if (DEBUG) {
            Log.d(TAG, "disconnect called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.w(TAG, "Cannot disconnect, device has already been closed.");
        }
        try {
            this.mLegacyDevice.close();
        } finally {
            this.mCameraInit.close();
            this.mCameraCallbacks.close();
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int endConfigure() {
        if (DEBUG) {
            Log.d(TAG, "endConfigure called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot end configure, device has been closed.");
            return -19;
        }
        ArrayList arrayList = null;
        synchronized (this.mConfigureLock) {
            try {
                if (!this.mConfiguring) {
                    Log.e(TAG, "Cannot end configure, no configuration change in progress.");
                    return -38;
                }
                int size = this.mSurfaces.size();
                if (size > 0) {
                    arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        try {
                            arrayList.add(this.mSurfaces.valueAt(i2));
                            i = i2 + 1;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                }
                this.mConfiguring = false;
                return this.mLegacyDevice.configureOutputs(arrayList);
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int flush(LongParcelable longParcelable) {
        if (DEBUG) {
            Log.d(TAG, "flush called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot flush, device has been closed.");
            return -19;
        }
        synchronized (this.mConfigureLock) {
            if (this.mConfiguring) {
                Log.e(TAG, "Cannot flush, configuration change in progress.");
                return -38;
            }
            long flush = this.mLegacyDevice.flush();
            if (longParcelable != null) {
                longParcelable.setNumber(flush);
                return 0;
            }
            return 0;
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int getCameraInfo(CameraMetadataNative cameraMetadataNative) {
        if (DEBUG) {
            Log.d(TAG, "getCameraInfo called.");
        }
        Log.e(TAG, "getCameraInfo unimplemented.");
        return 0;
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int submitRequest(CaptureRequest captureRequest, boolean z, LongParcelable longParcelable) {
        if (DEBUG) {
            Log.d(TAG, "submitRequest called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot submit request, device has been closed.");
            return -19;
        }
        synchronized (this.mConfigureLock) {
            if (this.mConfiguring) {
                Log.e(TAG, "Cannot submit request, configuration change in progress.");
                return -38;
            }
            return this.mLegacyDevice.submitRequest(captureRequest, z, longParcelable);
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int submitRequestList(List<CaptureRequest> list, boolean z, LongParcelable longParcelable) {
        if (DEBUG) {
            Log.d(TAG, "submitRequestList called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot submit request list, device has been closed.");
            return -19;
        }
        synchronized (this.mConfigureLock) {
            if (this.mConfiguring) {
                Log.e(TAG, "Cannot submit request, configuration change in progress.");
                return -38;
            }
            return this.mLegacyDevice.submitRequestList(list, z, longParcelable);
        }
    }

    @Override // android.hardware.camera2.ICameraDeviceUser
    public int waitUntilIdle() throws RemoteException {
        if (DEBUG) {
            Log.d(TAG, "waitUntilIdle called.");
        }
        if (this.mLegacyDevice.isClosed()) {
            Log.e(TAG, "Cannot wait until idle, device has been closed.");
            return -19;
        }
        synchronized (this.mConfigureLock) {
            if (this.mConfiguring) {
                Log.e(TAG, "Cannot wait until idle, configuration change in progress.");
                return -38;
            }
            this.mLegacyDevice.waitUntilIdle();
            return 0;
        }
    }
}
