package android.hardware.camera2.impl;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.ICameraDeviceCallbacks;
import android.hardware.camera2.ICameraDeviceUser;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.utils.CameraBinderDecorator;
import android.hardware.camera2.utils.CameraRuntimeException;
import android.hardware.camera2.utils.LongParcelable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraDeviceImpl.class */
public class CameraDeviceImpl extends CameraDevice {
    private static final int REQUEST_ID_NONE = -1;
    private final boolean DEBUG;
    private final String TAG;
    private final String mCameraId;
    private final CameraCharacteristics mCharacteristics;
    private CameraCaptureSessionImpl mCurrentSession;
    private final CameraDevice.StateCallback mDeviceCallback;
    private final Handler mDeviceHandler;
    private ICameraDeviceUser mRemoteDevice;
    private volatile StateCallbackKK mSessionStateCallback;
    private final int mTotalPartialCount;
    final Object mInterfaceLock = new Object();
    private final CameraDeviceCallbacks mCallbacks = new CameraDeviceCallbacks();
    private volatile boolean mClosing = false;
    private boolean mInError = false;
    private boolean mIdle = true;
    private final SparseArray<CaptureCallbackHolder> mCaptureCallbackMap = new SparseArray<>();
    private int mRepeatingRequestId = -1;
    private final ArrayList<Integer> mRepeatingRequestIdDeletedList = new ArrayList<>();
    private final SparseArray<Surface> mConfiguredOutputs = new SparseArray<>();
    private final List<AbstractMap.SimpleEntry<Long, Integer>> mFrameNumberRequestPairs = new ArrayList();
    private final FrameNumberTracker mFrameNumberTracker = new FrameNumberTracker();
    private int mNextSessionId = 0;
    private final Runnable mCallOnOpened = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                StateCallbackKK stateCallbackKK = CameraDeviceImpl.this.mSessionStateCallback;
                if (stateCallbackKK != null) {
                    stateCallbackKK.onOpened(CameraDeviceImpl.this);
                }
                CameraDeviceImpl.this.mDeviceCallback.onOpened(CameraDeviceImpl.this);
            }
        }
    };
    private final Runnable mCallOnUnconfigured = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                StateCallbackKK stateCallbackKK = CameraDeviceImpl.this.mSessionStateCallback;
                if (stateCallbackKK != null) {
                    stateCallbackKK.onUnconfigured(CameraDeviceImpl.this);
                }
            }
        }
    };
    private final Runnable mCallOnActive = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.3
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                StateCallbackKK stateCallbackKK = CameraDeviceImpl.this.mSessionStateCallback;
                if (stateCallbackKK != null) {
                    stateCallbackKK.onActive(CameraDeviceImpl.this);
                }
            }
        }
    };
    private final Runnable mCallOnBusy = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.4
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                StateCallbackKK stateCallbackKK = CameraDeviceImpl.this.mSessionStateCallback;
                if (stateCallbackKK != null) {
                    stateCallbackKK.onBusy(CameraDeviceImpl.this);
                }
            }
        }
    };
    private final Runnable mCallOnClosed = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.5
        private boolean mClosedOnce = false;

        @Override // java.lang.Runnable
        public void run() {
            StateCallbackKK stateCallbackKK;
            if (this.mClosedOnce) {
                throw new AssertionError("Don't post #onClosed more than once");
            }
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                stateCallbackKK = CameraDeviceImpl.this.mSessionStateCallback;
            }
            if (stateCallbackKK != null) {
                stateCallbackKK.onClosed(CameraDeviceImpl.this);
            }
            CameraDeviceImpl.this.mDeviceCallback.onClosed(CameraDeviceImpl.this);
            this.mClosedOnce = true;
        }
    };
    private final Runnable mCallOnIdle = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.6
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                StateCallbackKK stateCallbackKK = CameraDeviceImpl.this.mSessionStateCallback;
                if (stateCallbackKK != null) {
                    stateCallbackKK.onIdle(CameraDeviceImpl.this);
                }
            }
        }
    };
    private final Runnable mCallOnDisconnected = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.7
        @Override // java.lang.Runnable
        public void run() {
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                StateCallbackKK stateCallbackKK = CameraDeviceImpl.this.mSessionStateCallback;
                if (stateCallbackKK != null) {
                    stateCallbackKK.onDisconnected(CameraDeviceImpl.this);
                }
                CameraDeviceImpl.this.mDeviceCallback.onDisconnected(CameraDeviceImpl.this);
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraDeviceImpl$CameraDeviceCallbacks.class */
    public class CameraDeviceCallbacks extends ICameraDeviceCallbacks.Stub {
        public static final int ERROR_CAMERA_BUFFER = 5;
        public static final int ERROR_CAMERA_DEVICE = 1;
        public static final int ERROR_CAMERA_DISCONNECTED = 0;
        public static final int ERROR_CAMERA_REQUEST = 3;
        public static final int ERROR_CAMERA_RESULT = 4;
        public static final int ERROR_CAMERA_SERVICE = 2;

        public CameraDeviceCallbacks() {
        }

        private void onCaptureErrorLocked(int i, CaptureResultExtras captureResultExtras) {
            int requestId = captureResultExtras.getRequestId();
            int subsequenceId = captureResultExtras.getSubsequenceId();
            long frameNumber = captureResultExtras.getFrameNumber();
            final CaptureCallbackHolder captureCallbackHolder = (CaptureCallbackHolder) CameraDeviceImpl.this.mCaptureCallbackMap.get(requestId);
            final CaptureRequest request = captureCallbackHolder.getRequest(subsequenceId);
            if (i == 5) {
                Log.e(CameraDeviceImpl.this.TAG, String.format("Lost output buffer reported for frame %d", Long.valueOf(frameNumber)));
                return;
            }
            final CaptureFailure captureFailure = new CaptureFailure(request, (CameraDeviceImpl.this.mCurrentSession == null || !CameraDeviceImpl.this.mCurrentSession.isAborting()) ? 0 : 1, i == 4, requestId, frameNumber);
            captureCallbackHolder.getHandler().post(new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.CameraDeviceCallbacks.5
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraDeviceImpl.this.isClosed()) {
                        return;
                    }
                    captureCallbackHolder.getCallback().onCaptureFailed(CameraDeviceImpl.this, request, captureFailure);
                }
            });
            if (CameraDeviceImpl.this.DEBUG) {
                Log.v(CameraDeviceImpl.this.TAG, String.format("got error frame %d", Long.valueOf(frameNumber)));
            }
            CameraDeviceImpl.this.mFrameNumberTracker.updateTracker(frameNumber, true);
            CameraDeviceImpl.this.checkAndFireSequenceComplete();
        }

        @Override // android.hardware.camera2.ICameraDeviceCallbacks.Stub, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.hardware.camera2.ICameraDeviceCallbacks
        public void onCaptureStarted(final CaptureResultExtras captureResultExtras, final long j) {
            int requestId = captureResultExtras.getRequestId();
            final long frameNumber = captureResultExtras.getFrameNumber();
            if (CameraDeviceImpl.this.DEBUG) {
                Log.d(CameraDeviceImpl.this.TAG, "Capture started for id " + requestId + " frame number " + frameNumber);
            }
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                final CaptureCallbackHolder captureCallbackHolder = (CaptureCallbackHolder) CameraDeviceImpl.this.mCaptureCallbackMap.get(requestId);
                if (captureCallbackHolder == null) {
                    return;
                }
                if (CameraDeviceImpl.this.isClosed()) {
                    return;
                }
                captureCallbackHolder.getHandler().post(new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.CameraDeviceCallbacks.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraDeviceImpl.this.isClosed()) {
                            return;
                        }
                        captureCallbackHolder.getCallback().onCaptureStarted(CameraDeviceImpl.this, captureCallbackHolder.getRequest(captureResultExtras.getSubsequenceId()), j, frameNumber);
                    }
                });
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.hardware.camera2.ICameraDeviceCallbacks
        public void onDeviceError(final int i, CaptureResultExtras captureResultExtras) {
            if (CameraDeviceImpl.this.DEBUG) {
                Log.d(CameraDeviceImpl.this.TAG, String.format("Device error received, code %d, frame number %d, request ID %d, subseq ID %d", Integer.valueOf(i), Long.valueOf(captureResultExtras.getFrameNumber()), Integer.valueOf(captureResultExtras.getRequestId()), Integer.valueOf(captureResultExtras.getSubsequenceId())));
            }
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                switch (i) {
                    case 0:
                        CameraDeviceImpl.this.mDeviceHandler.post(CameraDeviceImpl.this.mCallOnDisconnected);
                        break;
                    case 1:
                    case 2:
                        CameraDeviceImpl.this.mInError = true;
                        CameraDeviceImpl.this.mDeviceHandler.post(new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.CameraDeviceCallbacks.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraDeviceImpl.this.isClosed()) {
                                    return;
                                }
                                CameraDeviceImpl.this.mDeviceCallback.onError(CameraDeviceImpl.this, i);
                            }
                        });
                        break;
                    case 3:
                    case 4:
                    case 5:
                        onCaptureErrorLocked(i, captureResultExtras);
                        break;
                    default:
                        Log.e(CameraDeviceImpl.this.TAG, "Unknown error from camera device: " + i);
                        CameraDeviceImpl.this.mInError = true;
                        CameraDeviceImpl.this.mDeviceHandler.post(new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.CameraDeviceCallbacks.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraDeviceImpl.this.isClosed()) {
                                    return;
                                }
                                CameraDeviceImpl.this.mDeviceCallback.onError(CameraDeviceImpl.this, i);
                            }
                        });
                        break;
                }
            }
        }

        @Override // android.hardware.camera2.ICameraDeviceCallbacks
        public void onDeviceIdle() {
            if (CameraDeviceImpl.this.DEBUG) {
                Log.d(CameraDeviceImpl.this.TAG, "Camera now idle");
            }
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                if (!CameraDeviceImpl.this.mIdle) {
                    CameraDeviceImpl.this.mDeviceHandler.post(CameraDeviceImpl.this.mCallOnIdle);
                }
                CameraDeviceImpl.this.mIdle = true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v44, types: [android.hardware.camera2.CaptureResult] */
        @Override // android.hardware.camera2.ICameraDeviceCallbacks
        public void onResultReceived(CameraMetadataNative cameraMetadataNative, CaptureResultExtras captureResultExtras) throws RemoteException {
            final TotalCaptureResult totalCaptureResult;
            Runnable runnable;
            int requestId = captureResultExtras.getRequestId();
            long frameNumber = captureResultExtras.getFrameNumber();
            if (CameraDeviceImpl.this.DEBUG) {
                Log.v(CameraDeviceImpl.this.TAG, "Received result frame " + frameNumber + " for id " + requestId);
            }
            synchronized (CameraDeviceImpl.this.mInterfaceLock) {
                if (CameraDeviceImpl.this.mRemoteDevice == null) {
                    return;
                }
                cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Size>>) CameraCharacteristics.LENS_INFO_SHADING_MAP_SIZE, (CameraCharacteristics.Key<Size>) CameraDeviceImpl.this.getCharacteristics().get(CameraCharacteristics.LENS_INFO_SHADING_MAP_SIZE));
                final CaptureCallbackHolder captureCallbackHolder = (CaptureCallbackHolder) CameraDeviceImpl.this.mCaptureCallbackMap.get(requestId);
                boolean z = captureResultExtras.getPartialResultCount() < CameraDeviceImpl.this.mTotalPartialCount;
                if (captureCallbackHolder == null) {
                    if (CameraDeviceImpl.this.DEBUG) {
                        Log.d(CameraDeviceImpl.this.TAG, "holder is null, early return at frame " + frameNumber);
                    }
                    CameraDeviceImpl.this.mFrameNumberTracker.updateTracker(frameNumber, null, z);
                } else if (CameraDeviceImpl.this.isClosed()) {
                    if (CameraDeviceImpl.this.DEBUG) {
                        Log.d(CameraDeviceImpl.this.TAG, "camera is closed, early return at frame " + frameNumber);
                    }
                    CameraDeviceImpl.this.mFrameNumberTracker.updateTracker(frameNumber, null, z);
                } else {
                    final CaptureRequest request = captureCallbackHolder.getRequest(captureResultExtras.getSubsequenceId());
                    if (z) {
                        totalCaptureResult = new CaptureResult(cameraMetadataNative, request, captureResultExtras);
                        runnable = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.CameraDeviceCallbacks.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraDeviceImpl.this.isClosed()) {
                                    return;
                                }
                                captureCallbackHolder.getCallback().onCaptureProgressed(CameraDeviceImpl.this, request, totalCaptureResult);
                            }
                        };
                    } else {
                        totalCaptureResult = new TotalCaptureResult(cameraMetadataNative, request, captureResultExtras, CameraDeviceImpl.this.mFrameNumberTracker.popPartialResults(frameNumber));
                        runnable = new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.CameraDeviceCallbacks.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CameraDeviceImpl.this.isClosed()) {
                                    return;
                                }
                                captureCallbackHolder.getCallback().onCaptureCompleted(CameraDeviceImpl.this, request, totalCaptureResult);
                            }
                        };
                    }
                    captureCallbackHolder.getHandler().post(runnable);
                    CameraDeviceImpl.this.mFrameNumberTracker.updateTracker(frameNumber, totalCaptureResult, z);
                    if (!z) {
                        CameraDeviceImpl.this.checkAndFireSequenceComplete();
                    }
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraDeviceImpl$CaptureCallback.class */
    public static abstract class CaptureCallback {
        public static final int NO_FRAMES_CAPTURED = -1;

        public void onCaptureCompleted(CameraDevice cameraDevice, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        }

        public void onCaptureFailed(CameraDevice cameraDevice, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        }

        public void onCapturePartial(CameraDevice cameraDevice, CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        public void onCaptureProgressed(CameraDevice cameraDevice, CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        public void onCaptureSequenceAborted(CameraDevice cameraDevice, int i) {
        }

        public void onCaptureSequenceCompleted(CameraDevice cameraDevice, int i, long j) {
        }

        public void onCaptureStarted(CameraDevice cameraDevice, CaptureRequest captureRequest, long j, long j2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraDeviceImpl$CaptureCallbackHolder.class */
    public static class CaptureCallbackHolder {
        private final CaptureCallback mCallback;
        private final Handler mHandler;
        private final boolean mRepeating;
        private final List<CaptureRequest> mRequestList;

        CaptureCallbackHolder(CaptureCallback captureCallback, List<CaptureRequest> list, Handler handler, boolean z) {
            if (captureCallback == null || handler == null) {
                throw new UnsupportedOperationException("Must have a valid handler and a valid callback");
            }
            this.mRepeating = z;
            this.mHandler = handler;
            this.mRequestList = new ArrayList(list);
            this.mCallback = captureCallback;
        }

        public CaptureCallback getCallback() {
            return this.mCallback;
        }

        public Handler getHandler() {
            return this.mHandler;
        }

        public CaptureRequest getRequest() {
            return getRequest(0);
        }

        public CaptureRequest getRequest(int i) {
            if (i >= this.mRequestList.size()) {
                throw new IllegalArgumentException(String.format("Requested subsequenceId %d is larger than request list size %d.", Integer.valueOf(i), Integer.valueOf(this.mRequestList.size())));
            }
            if (i < 0) {
                throw new IllegalArgumentException(String.format("Requested subsequenceId %d is negative", Integer.valueOf(i)));
            }
            return this.mRequestList.get(i);
        }

        public boolean isRepeating() {
            return this.mRepeating;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraDeviceImpl$FrameNumberTracker.class */
    public class FrameNumberTracker {
        private long mCompletedFrameNumber = -1;
        private final TreeSet<Long> mFutureErrorSet = new TreeSet<>();
        private final HashMap<Long, List<CaptureResult>> mPartialResults = new HashMap<>();

        public FrameNumberTracker() {
        }

        private void update() {
            Iterator<Long> it = this.mFutureErrorSet.iterator();
            while (it.hasNext() && it.next().longValue() == this.mCompletedFrameNumber + 1) {
                this.mCompletedFrameNumber++;
                it.remove();
            }
        }

        public long getCompletedFrameNumber() {
            return this.mCompletedFrameNumber;
        }

        public List<CaptureResult> popPartialResults(long j) {
            return this.mPartialResults.remove(Long.valueOf(j));
        }

        public void updateTracker(long j, CaptureResult captureResult, boolean z) {
            if (!z) {
                updateTracker(j, false);
            } else if (captureResult != null) {
                List<CaptureResult> list = this.mPartialResults.get(Long.valueOf(j));
                ArrayList arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList();
                    this.mPartialResults.put(Long.valueOf(j), arrayList);
                }
                arrayList.add(captureResult);
            }
        }

        public void updateTracker(long j, boolean z) {
            if (z) {
                this.mFutureErrorSet.add(Long.valueOf(j));
            } else {
                if (j != this.mCompletedFrameNumber + 1) {
                    Log.e(CameraDeviceImpl.this.TAG, String.format("result frame number %d comes out of order, should be %d + 1", Long.valueOf(j), Long.valueOf(this.mCompletedFrameNumber)));
                }
                this.mCompletedFrameNumber = j;
            }
            update();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/impl/CameraDeviceImpl$StateCallbackKK.class */
    public static abstract class StateCallbackKK extends CameraDevice.StateCallback {
        public void onActive(CameraDevice cameraDevice) {
        }

        public void onBusy(CameraDevice cameraDevice) {
        }

        public void onIdle(CameraDevice cameraDevice) {
        }

        public void onUnconfigured(CameraDevice cameraDevice) {
        }
    }

    public CameraDeviceImpl(String str, CameraDevice.StateCallback stateCallback, Handler handler, CameraCharacteristics cameraCharacteristics) {
        if (str == null || stateCallback == null || handler == null || cameraCharacteristics == null) {
            throw new IllegalArgumentException("Null argument given");
        }
        this.mCameraId = str;
        this.mDeviceCallback = stateCallback;
        this.mDeviceHandler = handler;
        this.mCharacteristics = cameraCharacteristics;
        String format = String.format("CameraDevice-JV-%s", this.mCameraId);
        this.TAG = format.length() > 23 ? format.substring(0, 23) : format;
        this.DEBUG = Log.isLoggable(this.TAG, 3);
        Integer num = (Integer) this.mCharacteristics.get(CameraCharacteristics.REQUEST_PARTIAL_RESULT_COUNT);
        if (num == null) {
            this.mTotalPartialCount = 1;
        } else {
            this.mTotalPartialCount = num.intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndFireSequenceComplete() {
        CaptureCallbackHolder valueAt;
        long completedFrameNumber = this.mFrameNumberTracker.getCompletedFrameNumber();
        Iterator<AbstractMap.SimpleEntry<Long, Integer>> it = this.mFrameNumberRequestPairs.iterator();
        while (it.hasNext()) {
            final AbstractMap.SimpleEntry<Long, Integer> next = it.next();
            if (next.getKey().longValue() <= completedFrameNumber) {
                final int intValue = next.getValue().intValue();
                synchronized (this.mInterfaceLock) {
                    if (this.mRemoteDevice == null) {
                        Log.w(this.TAG, "Camera closed while checking sequences");
                        return;
                    }
                    int indexOfKey = this.mCaptureCallbackMap.indexOfKey(intValue);
                    valueAt = indexOfKey >= 0 ? this.mCaptureCallbackMap.valueAt(indexOfKey) : null;
                    if (valueAt != null) {
                        this.mCaptureCallbackMap.removeAt(indexOfKey);
                        if (this.DEBUG) {
                            Log.v(this.TAG, String.format("remove holder for requestId %d, because lastFrame %d is <= %d", Integer.valueOf(intValue), next.getKey(), Long.valueOf(completedFrameNumber)));
                        }
                    }
                }
                it.remove();
                if (valueAt != null) {
                    final CaptureCallbackHolder captureCallbackHolder = valueAt;
                    valueAt.getHandler().post(new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CameraDeviceImpl.this.isClosed()) {
                                return;
                            }
                            if (CameraDeviceImpl.this.DEBUG) {
                                Log.d(CameraDeviceImpl.this.TAG, String.format("fire sequence complete for request %d", Integer.valueOf(intValue)));
                            }
                            long longValue = ((Long) next.getKey()).longValue();
                            if (longValue < -2147483648L || longValue > 2147483647L) {
                                throw new AssertionError(longValue + " cannot be cast to int");
                            }
                            captureCallbackHolder.getCallback().onCaptureSequenceCompleted(CameraDeviceImpl.this, intValue, longValue);
                        }
                    });
                }
            }
        }
    }

    private void checkEarlyTriggerSequenceComplete(final int i, final long j) {
        if (j != -1) {
            this.mFrameNumberRequestPairs.add(new AbstractMap.SimpleEntry<>(Long.valueOf(j), Integer.valueOf(i)));
            checkAndFireSequenceComplete();
            return;
        }
        int indexOfKey = this.mCaptureCallbackMap.indexOfKey(i);
        CaptureCallbackHolder valueAt = indexOfKey >= 0 ? this.mCaptureCallbackMap.valueAt(indexOfKey) : null;
        if (valueAt != null) {
            this.mCaptureCallbackMap.removeAt(indexOfKey);
            if (this.DEBUG) {
                Log.v(this.TAG, String.format("remove holder for requestId %d, because lastFrame is %d.", Integer.valueOf(i), Long.valueOf(j)));
            }
        }
        if (valueAt == null) {
            Log.w(this.TAG, String.format("did not register callback to request %d", Integer.valueOf(i)));
            return;
        }
        if (this.DEBUG) {
            Log.v(this.TAG, "immediately trigger onCaptureSequenceAborted because request did not reach HAL");
        }
        final CaptureCallbackHolder captureCallbackHolder = valueAt;
        valueAt.getHandler().post(new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.9
            @Override // java.lang.Runnable
            public void run() {
                if (CameraDeviceImpl.this.isClosed()) {
                    return;
                }
                if (CameraDeviceImpl.this.DEBUG) {
                    Log.d(CameraDeviceImpl.this.TAG, String.format("early trigger sequence complete for request %d", Integer.valueOf(i)));
                }
                if (j < -2147483648L || j > 2147483647L) {
                    throw new AssertionError(j + " cannot be cast to int");
                }
                captureCallbackHolder.getCallback().onCaptureSequenceAborted(CameraDeviceImpl.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler checkHandler(Handler handler) {
        Handler handler2 = handler;
        if (handler == null) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                throw new IllegalArgumentException("No handler given, and current thread has no looper!");
            }
            handler2 = new Handler(myLooper);
        }
        return handler2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Handler checkHandler(Handler handler, T t) {
        Handler handler2 = handler;
        if (t != null) {
            handler2 = checkHandler(handler);
        }
        return handler2;
    }

    private void checkIfCameraClosedOrInError() throws CameraAccessException {
        if (this.mInError) {
            throw new CameraAccessException(3, "The camera device has encountered a serious error");
        }
        if (this.mRemoteDevice == null) {
            throw new IllegalStateException("CameraDevice was already closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CameraCharacteristics getCharacteristics() {
        return this.mCharacteristics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isClosed() {
        return this.mClosing;
    }

    private int submitCaptureRequest(List<CaptureRequest> list, CaptureCallback captureCallback, Handler handler, boolean z) throws CameraAccessException {
        int submitRequestList;
        Handler checkHandler = checkHandler(handler, captureCallback);
        for (CaptureRequest captureRequest : list) {
            if (captureRequest.getTargets().isEmpty()) {
                throw new IllegalArgumentException("Each request must have at least one Surface target");
            }
            for (Surface surface : captureRequest.getTargets()) {
                if (surface == null) {
                    throw new IllegalArgumentException("Null Surface targets are not allowed");
                }
            }
        }
        synchronized (this.mInterfaceLock) {
            checkIfCameraClosedOrInError();
            if (z) {
                stopRepeating();
            }
            LongParcelable longParcelable = new LongParcelable();
            try {
                try {
                    submitRequestList = this.mRemoteDevice.submitRequestList(list, z, longParcelable);
                    if (this.DEBUG) {
                        Log.v(this.TAG, "last frame number " + longParcelable.getNumber());
                    }
                    if (captureCallback != null) {
                        this.mCaptureCallbackMap.put(submitRequestList, new CaptureCallbackHolder(captureCallback, list, checkHandler, z));
                    } else if (this.DEBUG) {
                        Log.d(this.TAG, "Listen for request " + submitRequestList + " is null");
                    }
                    long number = longParcelable.getNumber();
                    if (z) {
                        if (this.mRepeatingRequestId != -1) {
                            checkEarlyTriggerSequenceComplete(this.mRepeatingRequestId, number);
                        }
                        this.mRepeatingRequestId = submitRequestList;
                    } else {
                        this.mFrameNumberRequestPairs.add(new AbstractMap.SimpleEntry<>(Long.valueOf(number), Integer.valueOf(submitRequestList)));
                    }
                    if (this.mIdle) {
                        this.mDeviceHandler.post(this.mCallOnActive);
                    }
                    this.mIdle = false;
                } catch (RemoteException e) {
                    return -1;
                }
            } catch (CameraRuntimeException e2) {
                throw e2.asChecked();
            }
        }
        return submitRequestList;
    }

    private void waitUntilIdle() throws CameraAccessException {
        synchronized (this.mInterfaceLock) {
            checkIfCameraClosedOrInError();
            if (this.mRepeatingRequestId != -1) {
                throw new IllegalStateException("Active repeating request ongoing");
            }
            try {
                this.mRemoteDevice.waitUntilIdle();
            } catch (CameraRuntimeException e) {
                throw e.asChecked();
            } catch (RemoteException e2) {
            }
        }
    }

    public int capture(CaptureRequest captureRequest, CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        if (this.DEBUG) {
            Log.d(this.TAG, "calling capture");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(captureRequest);
        return submitCaptureRequest(arrayList, captureCallback, handler, false);
    }

    public int captureBurst(List<CaptureRequest> list, CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("At least one request must be given");
        }
        return submitCaptureRequest(list, captureCallback, handler, false);
    }

    @Override // android.hardware.camera2.CameraDevice, java.lang.AutoCloseable
    public void close() {
        synchronized (this.mInterfaceLock) {
            try {
                if (this.mRemoteDevice != null) {
                    this.mRemoteDevice.disconnect();
                }
            } catch (CameraRuntimeException e) {
                Log.e(this.TAG, "Exception while closing: ", e.asChecked());
            } catch (RemoteException e2) {
            }
            if (this.mRemoteDevice != null || this.mInError) {
                this.mDeviceHandler.post(this.mCallOnClosed);
            }
            this.mRemoteDevice = null;
            this.mInError = false;
        }
    }

    public void configureOutputs(List<Surface> list) throws CameraAccessException {
        configureOutputsChecked(list);
    }

    public boolean configureOutputsChecked(List<Surface> list) throws CameraAccessException {
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        synchronized (this.mInterfaceLock) {
            checkIfCameraClosedOrInError();
            HashSet hashSet = new HashSet(arrayList);
            ArrayList<Integer> arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mConfiguredOutputs.size()) {
                    break;
                }
                int keyAt = this.mConfiguredOutputs.keyAt(i2);
                Surface valueAt = this.mConfiguredOutputs.valueAt(i2);
                if (arrayList.contains(valueAt)) {
                    hashSet.remove(valueAt);
                } else {
                    arrayList2.add(Integer.valueOf(keyAt));
                }
                i = i2 + 1;
            }
            this.mDeviceHandler.post(this.mCallOnBusy);
            stopRepeating();
            try {
                waitUntilIdle();
                this.mRemoteDevice.beginConfigure();
                for (Integer num : arrayList2) {
                    this.mRemoteDevice.deleteStream(num.intValue());
                    this.mConfiguredOutputs.delete(num.intValue());
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Surface surface = (Surface) it.next();
                    this.mConfiguredOutputs.put(this.mRemoteDevice.createStream(0, 0, 0, surface), surface);
                }
                try {
                    this.mRemoteDevice.endConfigure();
                    if (1 == 0 || arrayList.size() <= 0) {
                        this.mDeviceHandler.post(this.mCallOnUnconfigured);
                    } else {
                        this.mDeviceHandler.post(this.mCallOnIdle);
                    }
                } catch (IllegalArgumentException e) {
                    Log.w(this.TAG, "Stream configuration failed");
                    if (0 == 0 || arrayList.size() <= 0) {
                        this.mDeviceHandler.post(this.mCallOnUnconfigured);
                    } else {
                        this.mDeviceHandler.post(this.mCallOnIdle);
                    }
                    return false;
                }
            } catch (CameraRuntimeException e2) {
                if (e2.getReason() == 4) {
                    throw new IllegalStateException("The camera is currently busy. You must wait until the previous operation completes.");
                }
                throw e2.asChecked();
            } catch (RemoteException e3) {
                if (0 == 0 || arrayList.size() <= 0) {
                    this.mDeviceHandler.post(this.mCallOnUnconfigured);
                } else {
                    this.mDeviceHandler.post(this.mCallOnIdle);
                }
                return false;
            }
        }
        return true;
    }

    @Override // android.hardware.camera2.CameraDevice
    public CaptureRequest.Builder createCaptureRequest(int i) throws CameraAccessException {
        CaptureRequest.Builder builder;
        synchronized (this.mInterfaceLock) {
            checkIfCameraClosedOrInError();
            CameraMetadataNative cameraMetadataNative = new CameraMetadataNative();
            try {
                try {
                    this.mRemoteDevice.createDefaultRequest(i, cameraMetadataNative);
                    builder = new CaptureRequest.Builder(cameraMetadataNative);
                } catch (RemoteException e) {
                    return null;
                }
            } catch (CameraRuntimeException e2) {
                throw e2.asChecked();
            }
        }
        return builder;
    }

    @Override // android.hardware.camera2.CameraDevice
    public void createCaptureSession(List<Surface> list, CameraCaptureSession.StateCallback stateCallback, Handler handler) throws CameraAccessException {
        boolean z;
        synchronized (this.mInterfaceLock) {
            if (this.DEBUG) {
                Log.d(this.TAG, "createCaptureSession");
            }
            checkIfCameraClosedOrInError();
            if (this.mCurrentSession != null) {
                this.mCurrentSession.replaceSessionClose();
            }
            CameraAccessException cameraAccessException = null;
            try {
                z = configureOutputsChecked(list);
            } catch (CameraAccessException e) {
                z = false;
                cameraAccessException = e;
                if (this.DEBUG) {
                    Log.v(this.TAG, "createCaptureSession - failed with exception ", e);
                    z = false;
                    cameraAccessException = e;
                }
            }
            int i = this.mNextSessionId;
            this.mNextSessionId = i + 1;
            this.mCurrentSession = new CameraCaptureSessionImpl(i, list, stateCallback, handler, this, this.mDeviceHandler, z);
            if (cameraAccessException != null) {
                throw cameraAccessException;
            }
            this.mSessionStateCallback = this.mCurrentSession.getDeviceStateCallback();
        }
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void flush() throws CameraAccessException {
        synchronized (this.mInterfaceLock) {
            checkIfCameraClosedOrInError();
            this.mDeviceHandler.post(this.mCallOnBusy);
            if (this.mIdle) {
                this.mDeviceHandler.post(this.mCallOnIdle);
                return;
            }
            try {
                LongParcelable longParcelable = new LongParcelable();
                this.mRemoteDevice.flush(longParcelable);
                if (this.mRepeatingRequestId != -1) {
                    checkEarlyTriggerSequenceComplete(this.mRepeatingRequestId, longParcelable.getNumber());
                    this.mRepeatingRequestId = -1;
                }
            } catch (CameraRuntimeException e) {
                throw e.asChecked();
            } catch (RemoteException e2) {
            }
        }
    }

    public CameraDeviceCallbacks getCallbacks() {
        return this.mCallbacks;
    }

    @Override // android.hardware.camera2.CameraDevice
    public String getId() {
        return this.mCameraId;
    }

    public void setRemoteDevice(ICameraDeviceUser iCameraDeviceUser) {
        synchronized (this.mInterfaceLock) {
            if (this.mInError) {
                return;
            }
            this.mRemoteDevice = (ICameraDeviceUser) CameraBinderDecorator.newInstance(iCameraDeviceUser);
            this.mDeviceHandler.post(this.mCallOnOpened);
            this.mDeviceHandler.post(this.mCallOnUnconfigured);
        }
    }

    public void setRemoteFailure(CameraRuntimeException cameraRuntimeException) {
        int i = 4;
        boolean z = true;
        switch (cameraRuntimeException.getReason()) {
            case 1:
                i = 3;
                break;
            case 2:
                z = false;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 1;
                break;
            case 5:
                i = 2;
                break;
            default:
                Log.wtf(this.TAG, "Unknown failure in opening camera device: " + cameraRuntimeException.getReason());
                break;
        }
        synchronized (this.mInterfaceLock) {
            this.mInError = true;
            final boolean z2 = z;
            final int i2 = i;
            this.mDeviceHandler.post(new Runnable() { // from class: android.hardware.camera2.impl.CameraDeviceImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    if (z2) {
                        CameraDeviceImpl.this.mDeviceCallback.onError(CameraDeviceImpl.this, i2);
                    } else {
                        CameraDeviceImpl.this.mDeviceCallback.onDisconnected(CameraDeviceImpl.this);
                    }
                }
            });
        }
    }

    public int setRepeatingBurst(List<CaptureRequest> list, CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("At least one request must be given");
        }
        return submitCaptureRequest(list, captureCallback, handler, true);
    }

    public int setRepeatingRequest(CaptureRequest captureRequest, CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(captureRequest);
        return submitCaptureRequest(arrayList, captureCallback, handler, true);
    }

    public void setSessionListener(StateCallbackKK stateCallbackKK) {
        synchronized (this.mInterfaceLock) {
            this.mSessionStateCallback = stateCallbackKK;
        }
    }

    public void stopRepeating() throws CameraAccessException {
        synchronized (this.mInterfaceLock) {
            checkIfCameraClosedOrInError();
            if (this.mRepeatingRequestId != -1) {
                int i = this.mRepeatingRequestId;
                this.mRepeatingRequestId = -1;
                if (this.mCaptureCallbackMap.get(i) != null) {
                    this.mRepeatingRequestIdDeletedList.add(Integer.valueOf(i));
                }
                try {
                    LongParcelable longParcelable = new LongParcelable();
                    this.mRemoteDevice.cancelRequest(i, longParcelable);
                    checkEarlyTriggerSequenceComplete(i, longParcelable.getNumber());
                } catch (CameraRuntimeException e) {
                    throw e.asChecked();
                } catch (RemoteException e2) {
                }
            }
        }
    }
}
