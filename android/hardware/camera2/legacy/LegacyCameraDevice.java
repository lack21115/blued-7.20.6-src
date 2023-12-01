package android.hardware.camera2.legacy;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.ICameraDeviceCallbacks;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.impl.CaptureResultExtras;
import android.hardware.camera2.legacy.CameraDeviceState;
import android.hardware.camera2.legacy.LegacyExceptionUtils;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.hardware.camera2.utils.ArrayUtils;
import android.hardware.camera2.utils.CameraRuntimeException;
import android.hardware.camera2.utils.LongParcelable;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import com.android.internal.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/LegacyCameraDevice.class */
public class LegacyCameraDevice implements AutoCloseable {
    private static final int GRALLOC_USAGE_HW_COMPOSER = 2048;
    private static final int GRALLOC_USAGE_HW_TEXTURE = 256;
    private static final int GRALLOC_USAGE_HW_VIDEO_ENCODER = 65536;
    private static final int GRALLOC_USAGE_RENDERSCRIPT = 1048576;
    private static final int GRALLOC_USAGE_SW_READ_OFTEN = 3;
    private static final int ILLEGAL_VALUE = -1;
    public static final int MAX_DIMEN_FOR_ROUNDING = 1080;
    private final String TAG;
    private final Handler mCallbackHandler;
    private final int mCameraId;
    private List<Surface> mConfiguredSurfaces;
    private final ICameraDeviceCallbacks mDeviceCallbacks;
    private final RequestThreadManager mRequestThreadManager;
    private final Handler mResultHandler;
    private final CameraCharacteristics mStaticCharacteristics;
    public static final String DEBUG_PROP = "HAL1ShimLogging";
    private static final boolean DEBUG = Log.isLoggable(DEBUG_PROP, 3);
    private final CameraDeviceState mDeviceState = new CameraDeviceState();
    private boolean mClosed = false;
    private final ConditionVariable mIdle = new ConditionVariable(true);
    private final HandlerThread mResultThread = new HandlerThread("ResultThread");
    private final HandlerThread mCallbackHandlerThread = new HandlerThread("CallbackThread");
    private final CameraDeviceState.CameraDeviceStateListener mStateListener = new CameraDeviceState.CameraDeviceStateListener() { // from class: android.hardware.camera2.legacy.LegacyCameraDevice.1
        @Override // android.hardware.camera2.legacy.CameraDeviceState.CameraDeviceStateListener
        public void onBusy() {
            LegacyCameraDevice.this.mIdle.close();
            if (LegacyCameraDevice.DEBUG) {
                Log.d(LegacyCameraDevice.this.TAG, "onBusy called");
            }
        }

        @Override // android.hardware.camera2.legacy.CameraDeviceState.CameraDeviceStateListener
        public void onCaptureResult(final CameraMetadataNative cameraMetadataNative, final RequestHolder requestHolder) {
            final CaptureResultExtras extrasFromRequest = LegacyCameraDevice.this.getExtrasFromRequest(requestHolder);
            LegacyCameraDevice.this.mResultHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.LegacyCameraDevice.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (LegacyCameraDevice.DEBUG) {
                        Log.d(LegacyCameraDevice.this.TAG, "doing onCaptureResult callback for request " + requestHolder.getRequestId());
                    }
                    try {
                        LegacyCameraDevice.this.mDeviceCallbacks.onResultReceived(cameraMetadataNative, extrasFromRequest);
                    } catch (RemoteException e) {
                        throw new IllegalStateException("Received remote exception during onCameraError callback: ", e);
                    }
                }
            });
        }

        @Override // android.hardware.camera2.legacy.CameraDeviceState.CameraDeviceStateListener
        public void onCaptureStarted(final RequestHolder requestHolder, final long j) {
            final CaptureResultExtras extrasFromRequest = LegacyCameraDevice.this.getExtrasFromRequest(requestHolder);
            LegacyCameraDevice.this.mResultHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.LegacyCameraDevice.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LegacyCameraDevice.DEBUG) {
                        Log.d(LegacyCameraDevice.this.TAG, "doing onCaptureStarted callback for request " + requestHolder.getRequestId());
                    }
                    try {
                        LegacyCameraDevice.this.mDeviceCallbacks.onCaptureStarted(extrasFromRequest, j);
                    } catch (RemoteException e) {
                        throw new IllegalStateException("Received remote exception during onCameraError callback: ", e);
                    }
                }
            });
        }

        @Override // android.hardware.camera2.legacy.CameraDeviceState.CameraDeviceStateListener
        public void onConfiguring() {
            if (LegacyCameraDevice.DEBUG) {
                Log.d(LegacyCameraDevice.this.TAG, "doing onConfiguring callback.");
            }
        }

        @Override // android.hardware.camera2.legacy.CameraDeviceState.CameraDeviceStateListener
        public void onError(final int i, final RequestHolder requestHolder) {
            if (LegacyCameraDevice.DEBUG) {
                Log.d(LegacyCameraDevice.this.TAG, "onError called, errorCode = " + i);
            }
            switch (i) {
                case 0:
                case 1:
                case 2:
                    LegacyCameraDevice.this.mIdle.open();
                    if (LegacyCameraDevice.DEBUG) {
                        Log.d(LegacyCameraDevice.this.TAG, "onError - opening idle");
                        break;
                    }
                    break;
            }
            final CaptureResultExtras extrasFromRequest = LegacyCameraDevice.this.getExtrasFromRequest(requestHolder);
            LegacyCameraDevice.this.mResultHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.LegacyCameraDevice.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LegacyCameraDevice.DEBUG) {
                        Log.d(LegacyCameraDevice.this.TAG, "doing onError callback for request " + requestHolder.getRequestId() + ", with error code " + i);
                    }
                    try {
                        LegacyCameraDevice.this.mDeviceCallbacks.onDeviceError(i, extrasFromRequest);
                    } catch (RemoteException e) {
                        throw new IllegalStateException("Received remote exception during onCameraError callback: ", e);
                    }
                }
            });
        }

        @Override // android.hardware.camera2.legacy.CameraDeviceState.CameraDeviceStateListener
        public void onIdle() {
            if (LegacyCameraDevice.DEBUG) {
                Log.d(LegacyCameraDevice.this.TAG, "onIdle called");
            }
            LegacyCameraDevice.this.mIdle.open();
            LegacyCameraDevice.this.mResultHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.LegacyCameraDevice.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LegacyCameraDevice.DEBUG) {
                        Log.d(LegacyCameraDevice.this.TAG, "doing onIdle callback.");
                    }
                    try {
                        LegacyCameraDevice.this.mDeviceCallbacks.onDeviceIdle();
                    } catch (RemoteException e) {
                        throw new IllegalStateException("Received remote exception during onCameraIdle callback: ", e);
                    }
                }
            });
        }
    };

    public LegacyCameraDevice(int i, Camera camera, CameraCharacteristics cameraCharacteristics, ICameraDeviceCallbacks iCameraDeviceCallbacks) {
        this.mCameraId = i;
        this.mDeviceCallbacks = iCameraDeviceCallbacks;
        this.TAG = String.format("CameraDevice-%d-LE", Integer.valueOf(this.mCameraId));
        this.mResultThread.start();
        this.mResultHandler = new Handler(this.mResultThread.getLooper());
        this.mCallbackHandlerThread.start();
        this.mCallbackHandler = new Handler(this.mCallbackHandlerThread.getLooper());
        this.mDeviceState.setCameraDeviceCallbacks(this.mCallbackHandler, this.mStateListener);
        this.mStaticCharacteristics = cameraCharacteristics;
        this.mRequestThreadManager = new RequestThreadManager(i, camera, cameraCharacteristics, this.mDeviceState);
        this.mRequestThreadManager.start();
    }

    static void configureSurface(Surface surface, int i, int i2, int i3) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surface);
        Preconditions.checkArgumentPositive(i, "width must be positive.");
        Preconditions.checkArgumentPositive(i2, "height must be positive.");
        LegacyExceptionUtils.throwOnError(nativeConfigureSurface(surface, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean containsSurfaceId(Surface surface, Collection<Long> collection) {
        return collection.contains(Long.valueOf(getSurfaceId(surface)));
    }

    public static int detectSurfaceType(Surface surface) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surface);
        return LegacyExceptionUtils.throwOnError(nativeDetectSurfaceType(surface));
    }

    static int detectSurfaceUsageFlags(Surface surface) {
        Preconditions.checkNotNull(surface);
        return nativeDetectSurfaceUsageFlags(surface);
    }

    static Size findClosestSize(Size size, Size[] sizeArr) {
        Size size2;
        if (size != null && sizeArr != null) {
            Size size3 = null;
            int length = sizeArr.length;
            int i = 0;
            while (i < length) {
                Size size4 = sizeArr[i];
                size2 = size;
                if (!size4.equals(size)) {
                    Size size5 = size3;
                    if (size4.getWidth() <= 1080) {
                        if (size3 != null) {
                            size5 = size3;
                            if (findEuclidDistSquare(size, size4) >= findEuclidDistSquare(size3, size4)) {
                            }
                        }
                        size5 = size4;
                    }
                    i++;
                    size3 = size5;
                }
            }
            return size3;
        }
        size2 = null;
        return size2;
    }

    static long findEuclidDistSquare(Size size, Size size2) {
        long width = size.getWidth() - size2.getWidth();
        long height = size.getHeight() - size2.getHeight();
        return (width * width) + (height * height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CaptureResultExtras getExtrasFromRequest(RequestHolder requestHolder) {
        return requestHolder == null ? new CaptureResultExtras(-1, -1, -1, -1, -1L, -1) : new CaptureResultExtras(requestHolder.getRequestId(), requestHolder.getSubsequeceId(), 0, 0, requestHolder.getFrameNumber(), 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getSurfaceId(Surface surface) {
        Preconditions.checkNotNull(surface);
        return nativeGetSurfaceId(surface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> getSurfaceIds(Collection<Surface> collection) {
        if (collection == null) {
            throw new NullPointerException("Null argument surfaces");
        }
        ArrayList arrayList = new ArrayList();
        for (Surface surface : collection) {
            long surfaceId = getSurfaceId(surface);
            if (surfaceId == 0) {
                throw new IllegalStateException("Configured surface had null native GraphicBufferProducer pointer!");
            }
            arrayList.add(Long.valueOf(surfaceId));
        }
        return arrayList;
    }

    public static Size getSurfaceSize(Surface surface) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surface);
        int[] iArr = new int[2];
        LegacyExceptionUtils.throwOnError(nativeDetectSurfaceDimens(surface, iArr));
        return new Size(iArr[0], iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Size getTextureSize(SurfaceTexture surfaceTexture) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surfaceTexture);
        int[] iArr = new int[2];
        LegacyExceptionUtils.throwOnError(nativeDetectTextureDimens(surfaceTexture, iArr));
        return new Size(iArr[0], iArr[1]);
    }

    public static boolean isFlexibleConsumer(Surface surface) {
        int detectSurfaceUsageFlags = detectSurfaceUsageFlags(surface);
        return (detectSurfaceUsageFlags & 1114112) == 0 && (detectSurfaceUsageFlags & 2307) != 0;
    }

    private static native int nativeConfigureSurface(Surface surface, int i, int i2, int i3);

    private static native int nativeDetectSurfaceDimens(Surface surface, int[] iArr);

    private static native int nativeDetectSurfaceType(Surface surface);

    private static native int nativeDetectSurfaceUsageFlags(Surface surface);

    private static native int nativeDetectTextureDimens(SurfaceTexture surfaceTexture, int[] iArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int nativeGetJpegFooterSize();

    private static native long nativeGetSurfaceId(Surface surface);

    private static native int nativeProduceFrame(Surface surface, byte[] bArr, int i, int i2, int i3);

    private static native int nativeSetNextTimestamp(Surface surface, long j);

    private static native int nativeSetSurfaceDimens(Surface surface, int i, int i2);

    private static native int nativeSetSurfaceFormat(Surface surface, int i);

    private static native int nativeSetSurfaceOrientation(Surface surface, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean needsConversion(Surface surface) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        int detectSurfaceType = detectSurfaceType(surface);
        return detectSurfaceType == 35 || detectSurfaceType == 842094169 || detectSurfaceType == 17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void produceFrame(Surface surface, byte[] bArr, int i, int i2, int i3) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surface);
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgumentPositive(i, "width must be positive.");
        Preconditions.checkArgumentPositive(i2, "height must be positive.");
        LegacyExceptionUtils.throwOnError(nativeProduceFrame(surface, bArr, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setNextTimestamp(Surface surface, long j) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surface);
        LegacyExceptionUtils.throwOnError(nativeSetNextTimestamp(surface, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSurfaceDimens(Surface surface, int i, int i2) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surface);
        Preconditions.checkArgumentPositive(i, "width must be positive.");
        Preconditions.checkArgumentPositive(i2, "height must be positive.");
        LegacyExceptionUtils.throwOnError(nativeSetSurfaceDimens(surface, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSurfaceFormat(Surface surface, int i) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surface);
        LegacyExceptionUtils.throwOnError(nativeSetSurfaceFormat(surface, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSurfaceOrientation(Surface surface, int i, int i2) throws LegacyExceptionUtils.BufferQueueAbandonedException {
        Preconditions.checkNotNull(surface);
        LegacyExceptionUtils.throwOnError(nativeSetSurfaceOrientation(surface, i, i2));
    }

    public long cancelRequest(int i) {
        return this.mRequestThreadManager.cancelRepeating(i);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.mRequestThreadManager.quit();
        this.mCallbackHandlerThread.quitSafely();
        this.mResultThread.quitSafely();
        try {
            this.mCallbackHandlerThread.join();
        } catch (InterruptedException e) {
            Log.e(this.TAG, String.format("Thread %s (%d) interrupted while quitting.", this.mCallbackHandlerThread.getName(), Long.valueOf(this.mCallbackHandlerThread.getId())));
        }
        try {
            this.mResultThread.join();
        } catch (InterruptedException e2) {
            Log.e(this.TAG, String.format("Thread %s (%d) interrupted while quitting.", this.mResultThread.getName(), Long.valueOf(this.mResultThread.getId())));
        }
        this.mClosed = true;
    }

    public int configureOutputs(List<Surface> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Surface surface : list) {
                if (surface == null) {
                    Log.e(this.TAG, "configureOutputs - null outputs are not allowed");
                    return -22;
                }
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.mStaticCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                try {
                    Size surfaceSize = getSurfaceSize(surface);
                    int detectSurfaceType = detectSurfaceType(surface);
                    boolean isFlexibleConsumer = isFlexibleConsumer(surface);
                    Size[] outputSizes = streamConfigurationMap.getOutputSizes(detectSurfaceType);
                    Size[] sizeArr = outputSizes;
                    if (outputSizes == null) {
                        if (detectSurfaceType < 1 || detectSurfaceType > 5) {
                            sizeArr = outputSizes;
                            if (detectSurfaceType == 33) {
                                sizeArr = streamConfigurationMap.getOutputSizes(256);
                            }
                        } else {
                            sizeArr = streamConfigurationMap.getOutputSizes(35);
                        }
                    }
                    if (!ArrayUtils.contains(sizeArr, surfaceSize)) {
                        Size size = surfaceSize;
                        if (isFlexibleConsumer) {
                            Size findClosestSize = findClosestSize(surfaceSize, sizeArr);
                            size = findClosestSize;
                            if (findClosestSize != null) {
                                arrayList.add(new Pair(surface, findClosestSize));
                            }
                        }
                        Log.e(this.TAG, String.format("Surface with size (w=%d, h=%d) and format 0x%x is not valid, %s", Integer.valueOf(size.getWidth()), Integer.valueOf(size.getHeight()), Integer.valueOf(detectSurfaceType), sizeArr == null ? "format is invalid." : "size not in valid set: " + Arrays.toString(sizeArr)));
                        return -22;
                    }
                    arrayList.add(new Pair(surface, surfaceSize));
                } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
                    Log.e(this.TAG, "Surface bufferqueue is abandoned, cannot configure as output: ", e);
                    return -22;
                }
            }
        }
        boolean z = false;
        if (this.mDeviceState.setConfiguring()) {
            this.mRequestThreadManager.configure(arrayList);
            z = this.mDeviceState.setIdle();
        }
        if (z) {
            this.mConfiguredSurfaces = list != null ? new ArrayList(list) : null;
            return 0;
        }
        return -38;
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } catch (CameraRuntimeException e) {
            Log.e(this.TAG, "Got error while trying to finalize, ignoring: " + e.getMessage());
        } finally {
            super.finalize();
        }
    }

    public long flush() {
        long flush = this.mRequestThreadManager.flush();
        waitUntilIdle();
        return flush;
    }

    public boolean isClosed() {
        return this.mClosed;
    }

    public int submitRequest(CaptureRequest captureRequest, boolean z, LongParcelable longParcelable) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(captureRequest);
        return submitRequestList(arrayList, z, longParcelable);
    }

    public int submitRequestList(List<CaptureRequest> list, boolean z, LongParcelable longParcelable) {
        if (list == null || list.isEmpty()) {
            Log.e(this.TAG, "submitRequestList - Empty/null requests are not allowed");
            return -22;
        }
        ArrayList arrayList = this.mConfiguredSurfaces == null ? new ArrayList() : getSurfaceIds(this.mConfiguredSurfaces);
        for (CaptureRequest captureRequest : list) {
            if (captureRequest.getTargets().isEmpty()) {
                Log.e(this.TAG, "submitRequestList - Each request must have at least one Surface target");
                return -22;
            }
            for (Surface surface : captureRequest.getTargets()) {
                if (surface == null) {
                    Log.e(this.TAG, "submitRequestList - Null Surface targets are not allowed");
                    return -22;
                } else if (this.mConfiguredSurfaces == null) {
                    Log.e(this.TAG, "submitRequestList - must configure  device with valid surfaces before submitting requests");
                    return -38;
                } else if (!containsSurfaceId(surface, arrayList)) {
                    Log.e(this.TAG, "submitRequestList - cannot use a surface that wasn't configured");
                    return -22;
                }
            }
        }
        this.mIdle.close();
        return this.mRequestThreadManager.submitCaptureRequests(list, z, longParcelable);
    }

    public void waitUntilIdle() {
        this.mIdle.block();
    }
}
