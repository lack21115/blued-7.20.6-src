package android.hardware.camera2.legacy;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.legacy.LegacyExceptionUtils;
import android.hardware.camera2.utils.LongParcelable;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.MutableLong;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import com.android.internal.util.Preconditions;
import com.igexin.push.core.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/RequestThreadManager.class */
public class RequestThreadManager {
    private static final float ASPECT_RATIO_TOLERANCE = 0.01f;
    private static final int JPEG_FRAME_TIMEOUT = 4000;
    private static final int MAX_IN_FLIGHT_REQUESTS = 2;
    private static final int MSG_CLEANUP = 3;
    private static final int MSG_CONFIGURE_OUTPUTS = 1;
    private static final int MSG_SUBMIT_CAPTURE_REQUEST = 2;
    private static final int PREVIEW_FRAME_TIMEOUT = 1000;
    private static final int REQUEST_COMPLETE_TIMEOUT = 4000;
    private static final boolean USE_BLOB_FORMAT_OVERRIDE = true;
    private final String TAG;
    private Camera mCamera;
    private final int mCameraId;
    private final CaptureCollector mCaptureCollector;
    private final CameraCharacteristics mCharacteristics;
    private final CameraDeviceState mDeviceState;
    private Surface mDummySurface;
    private SurfaceTexture mDummyTexture;
    private final LegacyFaceDetectMapper mFaceDetectMapper;
    private final LegacyFocusStateMapper mFocusStateMapper;
    private GLThreadManager mGLThreadManager;
    private Size mIntermediateBufferSize;
    private Camera.Parameters mParams;
    private SurfaceTexture mPreviewTexture;
    private final RequestHandlerThread mRequestThread;
    private static final boolean DEBUG = Log.isLoggable(LegacyCameraDevice.DEBUG_PROP, 3);
    private static final boolean VERBOSE = Log.isLoggable(LegacyCameraDevice.DEBUG_PROP, 2);
    private boolean mPreviewRunning = false;
    private final List<Surface> mPreviewOutputs = new ArrayList();
    private final List<Surface> mCallbackOutputs = new ArrayList();
    private final List<Long> mJpegSurfaceIds = new ArrayList();
    private final RequestQueue mRequestQueue = new RequestQueue(this.mJpegSurfaceIds);
    private LegacyRequest mLastRequest = null;
    private final Object mIdleLock = new Object();
    private final FpsCounter mPrevCounter = new FpsCounter("Incoming Preview");
    private final FpsCounter mRequestCounter = new FpsCounter("Incoming Requests");
    private final AtomicBoolean mQuit = new AtomicBoolean(false);
    private final Camera.ErrorCallback mErrorCallback = new Camera.ErrorCallback() { // from class: android.hardware.camera2.legacy.RequestThreadManager.1
        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int i, Camera camera) {
            Log.e(RequestThreadManager.this.TAG, "Received error " + i + " from the Camera1 ErrorCallback");
            RequestThreadManager.this.mDeviceState.setError(1);
        }
    };
    private final ConditionVariable mReceivedJpeg = new ConditionVariable(false);
    private final Camera.PictureCallback mJpegCallback = new Camera.PictureCallback() { // from class: android.hardware.camera2.legacy.RequestThreadManager.2
        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            Log.i(RequestThreadManager.this.TAG, "Received jpeg.");
            Pair<RequestHolder, Long> jpegProduced = RequestThreadManager.this.mCaptureCollector.jpegProduced();
            if (jpegProduced == null || jpegProduced.first == null) {
                Log.e(RequestThreadManager.this.TAG, "Dropping jpeg frame.");
                return;
            }
            RequestHolder requestHolder = jpegProduced.first;
            long longValue = jpegProduced.second.longValue();
            for (Surface surface : requestHolder.getHolderTargets()) {
                try {
                    if (LegacyCameraDevice.containsSurfaceId(surface, RequestThreadManager.this.mJpegSurfaceIds)) {
                        Log.i(RequestThreadManager.this.TAG, "Producing jpeg buffer...");
                        int length = bArr.length;
                        int nativeGetJpegFooterSize = LegacyCameraDevice.nativeGetJpegFooterSize();
                        LegacyCameraDevice.setNextTimestamp(surface, longValue);
                        LegacyCameraDevice.setSurfaceFormat(surface, 1);
                        int ceil = (((int) Math.ceil(Math.sqrt((length + nativeGetJpegFooterSize + 3) & (-4)))) + 15) & (-16);
                        LegacyCameraDevice.setSurfaceDimens(surface, ceil, ceil);
                        LegacyCameraDevice.produceFrame(surface, bArr, ceil, ceil, 33);
                    }
                } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
                    Log.w(RequestThreadManager.this.TAG, "Surface abandoned, dropping frame. ", e);
                }
            }
            RequestThreadManager.this.mReceivedJpeg.open();
        }
    };
    private final Camera.ShutterCallback mJpegShutterCallback = new Camera.ShutterCallback() { // from class: android.hardware.camera2.legacy.RequestThreadManager.3
        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            RequestThreadManager.this.mCaptureCollector.jpegCaptured(SystemClock.elapsedRealtimeNanos());
        }
    };
    private final SurfaceTexture.OnFrameAvailableListener mPreviewCallback = new SurfaceTexture.OnFrameAvailableListener() { // from class: android.hardware.camera2.legacy.RequestThreadManager.4
        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            if (RequestThreadManager.DEBUG) {
                RequestThreadManager.this.mPrevCounter.countAndLog();
            }
            RequestThreadManager.this.mGLThreadManager.queueNewFrame();
        }
    };
    private final Handler.Callback mRequestHandlerCb = new Handler.Callback() { // from class: android.hardware.camera2.legacy.RequestThreadManager.5
        private boolean mCleanup = false;
        private final LegacyResultMapper mMapper = new LegacyResultMapper();

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (this.mCleanup) {
                return true;
            }
            if (RequestThreadManager.DEBUG) {
                Log.d(RequestThreadManager.this.TAG, "Request thread handling message:" + message.what);
            }
            long elapsedRealtimeNanos = RequestThreadManager.DEBUG ? SystemClock.elapsedRealtimeNanos() : 0L;
            switch (message.what) {
                case -1:
                    return true;
                case 0:
                default:
                    throw new AssertionError("Unhandled message " + message.what + " on RequestThread.");
                case 1:
                    ConfigureHolder configureHolder = (ConfigureHolder) message.obj;
                    Log.i(RequestThreadManager.this.TAG, "Configure outputs: " + (configureHolder.surfaces != null ? configureHolder.surfaces.size() : 0) + " surfaces configured.");
                    try {
                        if (!RequestThreadManager.this.mCaptureCollector.waitForEmpty(4000L, TimeUnit.MILLISECONDS)) {
                            Log.e(RequestThreadManager.this.TAG, "Timed out while queueing configure request.");
                            RequestThreadManager.this.mCaptureCollector.failAll();
                        }
                        RequestThreadManager.this.configureOutputs(configureHolder.surfaces);
                        configureHolder.condition.open();
                        if (RequestThreadManager.DEBUG) {
                            Log.d(RequestThreadManager.this.TAG, "Configure took " + (SystemClock.elapsedRealtimeNanos() - elapsedRealtimeNanos) + " ns");
                            return true;
                        }
                        return true;
                    } catch (InterruptedException e) {
                        Log.e(RequestThreadManager.this.TAG, "Interrupted while waiting for requests to complete.");
                        RequestThreadManager.this.mDeviceState.setError(1);
                        return true;
                    }
                case 2:
                    Handler handler = RequestThreadManager.this.mRequestThread.getHandler();
                    Pair<BurstHolder, Long> next = RequestThreadManager.this.mRequestQueue.getNext();
                    Pair<BurstHolder, Long> pair = next;
                    if (next == null) {
                        try {
                            if (!RequestThreadManager.this.mCaptureCollector.waitForEmpty(4000L, TimeUnit.MILLISECONDS)) {
                                Log.e(RequestThreadManager.this.TAG, "Timed out while waiting for prior requests to complete.");
                                RequestThreadManager.this.mCaptureCollector.failAll();
                            }
                            synchronized (RequestThreadManager.this.mIdleLock) {
                                pair = RequestThreadManager.this.mRequestQueue.getNext();
                                if (pair == null) {
                                    RequestThreadManager.this.mDeviceState.setIdle();
                                    return true;
                                }
                            }
                        } catch (InterruptedException e2) {
                            Log.e(RequestThreadManager.this.TAG, "Interrupted while waiting for requests to complete: ", e2);
                            RequestThreadManager.this.mDeviceState.setError(1);
                            return true;
                        }
                    }
                    if (pair != null) {
                        handler.sendEmptyMessage(2);
                    }
                    for (RequestHolder requestHolder : pair.first.produceRequestHolders(pair.second.longValue())) {
                        CaptureRequest request = requestHolder.getRequest();
                        boolean z = false;
                        if (RequestThreadManager.this.mLastRequest == null || RequestThreadManager.this.mLastRequest.captureRequest != request) {
                            LegacyRequest legacyRequest = new LegacyRequest(RequestThreadManager.this.mCharacteristics, request, ParameterUtils.convertSize(RequestThreadManager.this.mParams.getPreviewSize()), RequestThreadManager.this.mParams);
                            LegacyMetadataMapper.convertRequestMetadata(legacyRequest);
                            z = false;
                            if (!RequestThreadManager.this.mParams.same(legacyRequest.parameters)) {
                                try {
                                    RequestThreadManager.this.mCamera.setParameters(legacyRequest.parameters);
                                    z = true;
                                    RequestThreadManager.this.mParams = legacyRequest.parameters;
                                } catch (RuntimeException e3) {
                                    Log.e(RequestThreadManager.this.TAG, "Exception while setting camera parameters: ", e3);
                                    requestHolder.failRequest();
                                    RequestThreadManager.this.mDeviceState.setCaptureStart(requestHolder, 0L, 3);
                                }
                            }
                            RequestThreadManager.this.mLastRequest = legacyRequest;
                        }
                        try {
                            if (RequestThreadManager.this.mCaptureCollector.queueRequest(requestHolder, RequestThreadManager.this.mLastRequest, 4000L, TimeUnit.MILLISECONDS)) {
                                if (requestHolder.hasPreviewTargets()) {
                                    RequestThreadManager.this.doPreviewCapture(requestHolder);
                                }
                                if (requestHolder.hasJpegTargets()) {
                                    while (!RequestThreadManager.this.mCaptureCollector.waitForPreviewsEmpty(1000L, TimeUnit.MILLISECONDS)) {
                                        Log.e(RequestThreadManager.this.TAG, "Timed out while waiting for preview requests to complete.");
                                        RequestThreadManager.this.mCaptureCollector.failNextPreview();
                                    }
                                    RequestThreadManager.this.mReceivedJpeg.close();
                                    RequestThreadManager.this.doJpegCapturePrepare(requestHolder);
                                }
                                RequestThreadManager.this.mFaceDetectMapper.processFaceDetectMode(request, RequestThreadManager.this.mParams);
                                RequestThreadManager.this.mFocusStateMapper.processRequestTriggers(request, RequestThreadManager.this.mParams);
                                if (requestHolder.hasJpegTargets()) {
                                    RequestThreadManager.this.doJpegCapture(requestHolder);
                                    if (!RequestThreadManager.this.mReceivedJpeg.block(4000L)) {
                                        Log.e(RequestThreadManager.this.TAG, "Hit timeout for jpeg callback!");
                                        RequestThreadManager.this.mCaptureCollector.failNextJpeg();
                                    }
                                }
                                if (z) {
                                    if (RequestThreadManager.DEBUG) {
                                        Log.d(RequestThreadManager.this.TAG, "Params changed -- getting new Parameters from HAL.");
                                    }
                                    try {
                                        RequestThreadManager.this.mParams = RequestThreadManager.this.mCamera.getParameters();
                                        RequestThreadManager.this.mLastRequest.setParameters(RequestThreadManager.this.mParams);
                                    } catch (RuntimeException e4) {
                                        Log.e(RequestThreadManager.this.TAG, "Received device exception: ", e4);
                                        RequestThreadManager.this.mDeviceState.setError(1);
                                    }
                                }
                                MutableLong mutableLong = new MutableLong(0L);
                                try {
                                    if (!RequestThreadManager.this.mCaptureCollector.waitForRequestCompleted(requestHolder, 4000L, TimeUnit.MILLISECONDS, mutableLong)) {
                                        Log.e(RequestThreadManager.this.TAG, "Timed out while waiting for request to complete.");
                                        RequestThreadManager.this.mCaptureCollector.failAll();
                                    }
                                    CameraMetadataNative cachedConvertResultMetadata = this.mMapper.cachedConvertResultMetadata(RequestThreadManager.this.mLastRequest, mutableLong.value);
                                    RequestThreadManager.this.mFocusStateMapper.mapResultTriggers(cachedConvertResultMetadata);
                                    RequestThreadManager.this.mFaceDetectMapper.mapResultFaces(cachedConvertResultMetadata, RequestThreadManager.this.mLastRequest);
                                    if (!requestHolder.requestFailed()) {
                                        RequestThreadManager.this.mDeviceState.setCaptureResult(requestHolder, cachedConvertResultMetadata, -1);
                                    }
                                } catch (InterruptedException e5) {
                                    Log.e(RequestThreadManager.this.TAG, "Interrupted waiting for request completion: ", e5);
                                    RequestThreadManager.this.mDeviceState.setError(1);
                                }
                            } else {
                                Log.e(RequestThreadManager.this.TAG, "Timed out while queueing capture request.");
                                requestHolder.failRequest();
                                RequestThreadManager.this.mDeviceState.setCaptureStart(requestHolder, 0L, 3);
                            }
                        } catch (IOException e6) {
                            Log.e(RequestThreadManager.this.TAG, "Received device exception during capture call: ", e6);
                            RequestThreadManager.this.mDeviceState.setError(1);
                        } catch (InterruptedException e7) {
                            Log.e(RequestThreadManager.this.TAG, "Interrupted during capture: ", e7);
                            RequestThreadManager.this.mDeviceState.setError(1);
                        } catch (RuntimeException e8) {
                            Log.e(RequestThreadManager.this.TAG, "Received device exception during capture call: ", e8);
                            RequestThreadManager.this.mDeviceState.setError(1);
                        }
                    }
                    if (RequestThreadManager.DEBUG) {
                        Log.d(RequestThreadManager.this.TAG, "Capture request took " + (SystemClock.elapsedRealtimeNanos() - elapsedRealtimeNanos) + " ns");
                        RequestThreadManager.this.mRequestCounter.countAndLog();
                        return true;
                    }
                    return true;
                case 3:
                    this.mCleanup = true;
                    try {
                        if (!RequestThreadManager.this.mCaptureCollector.waitForEmpty(4000L, TimeUnit.MILLISECONDS)) {
                            Log.e(RequestThreadManager.this.TAG, "Timed out while queueing cleanup request.");
                            RequestThreadManager.this.mCaptureCollector.failAll();
                        }
                    } catch (InterruptedException e9) {
                        Log.e(RequestThreadManager.this.TAG, "Interrupted while waiting for requests to complete: ", e9);
                        RequestThreadManager.this.mDeviceState.setError(1);
                    }
                    if (RequestThreadManager.this.mPreviewTexture != null) {
                        RequestThreadManager.this.mPreviewTexture.setOnFrameAvailableListener(null);
                    }
                    if (RequestThreadManager.this.mGLThreadManager != null) {
                        RequestThreadManager.this.mGLThreadManager.quit();
                        RequestThreadManager.this.mGLThreadManager = null;
                    }
                    if (RequestThreadManager.this.mCamera != null) {
                        RequestThreadManager.this.mCamera.release();
                        RequestThreadManager.this.mCamera = null;
                    }
                    RequestThreadManager.this.resetJpegSurfaceFormats(RequestThreadManager.this.mCallbackOutputs);
                    return true;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/RequestThreadManager$ConfigureHolder.class */
    public static class ConfigureHolder {
        public final ConditionVariable condition;
        public final Collection<Pair<Surface, Size>> surfaces;

        public ConfigureHolder(ConditionVariable conditionVariable, Collection<Pair<Surface, Size>> collection) {
            this.condition = conditionVariable;
            this.surfaces = collection;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/RequestThreadManager$FpsCounter.class */
    public static class FpsCounter {
        private static final long NANO_PER_SECOND = 1000000000;
        private static final String TAG = "FpsCounter";
        private final String mStreamType;
        private int mFrameCount = 0;
        private long mLastTime = 0;
        private long mLastPrintTime = 0;
        private double mLastFps = 0.0d;

        public FpsCounter(String str) {
            this.mStreamType = str;
        }

        public double checkFps() {
            double d;
            synchronized (this) {
                d = this.mLastFps;
            }
            return d;
        }

        public void countAndLog() {
            synchronized (this) {
                countFrame();
                staggeredLog();
            }
        }

        public void countFrame() {
            synchronized (this) {
                this.mFrameCount++;
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                if (this.mLastTime == 0) {
                    this.mLastTime = elapsedRealtimeNanos;
                }
                if (elapsedRealtimeNanos > this.mLastTime + 1000000000) {
                    this.mLastFps = this.mFrameCount * (1.0E9d / (elapsedRealtimeNanos - this.mLastTime));
                    this.mFrameCount = 0;
                    this.mLastTime = elapsedRealtimeNanos;
                }
            }
        }

        public void staggeredLog() {
            synchronized (this) {
                if (this.mLastTime > this.mLastPrintTime + 5000000000L) {
                    this.mLastPrintTime = this.mLastTime;
                    Log.d(TAG, "FPS for " + this.mStreamType + " stream: " + this.mLastFps);
                }
            }
        }
    }

    public RequestThreadManager(int i, Camera camera, CameraCharacteristics cameraCharacteristics, CameraDeviceState cameraDeviceState) {
        this.mCamera = (Camera) Preconditions.checkNotNull(camera, "camera must not be null");
        this.mCameraId = i;
        this.mCharacteristics = (CameraCharacteristics) Preconditions.checkNotNull(cameraCharacteristics, "characteristics must not be null");
        String format = String.format("RequestThread-%d", Integer.valueOf(i));
        this.TAG = format;
        this.mDeviceState = (CameraDeviceState) Preconditions.checkNotNull(cameraDeviceState, "deviceState must not be null");
        this.mFocusStateMapper = new LegacyFocusStateMapper(this.mCamera);
        this.mFaceDetectMapper = new LegacyFaceDetectMapper(this.mCamera, this.mCharacteristics);
        this.mCaptureCollector = new CaptureCollector(2, this.mDeviceState);
        this.mRequestThread = new RequestHandlerThread(format, this.mRequestHandlerCb);
        this.mCamera.setErrorCallback(this.mErrorCallback);
    }

    private Size calculatePictureSize(List<Surface> list, List<Size> list2, Camera.Parameters parameters) {
        if (list.size() != list2.size()) {
            throw new IllegalStateException("Input collections must be same length");
        }
        ArrayList<Size> arrayList = new ArrayList();
        Iterator<Size> it = list2.iterator();
        for (Surface surface : list) {
            Size next = it.next();
            if (LegacyCameraDevice.containsSurfaceId(surface, this.mJpegSurfaceIds)) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        int i = -1;
        int i2 = -1;
        for (Size size : arrayList) {
            int i3 = i;
            if (size.getWidth() > i) {
                i3 = size.getWidth();
            }
            int i4 = i2;
            if (size.getHeight() > i2) {
                i4 = size.getHeight();
            }
            i2 = i4;
            i = i3;
        }
        Size size2 = new Size(i, i2);
        List<Size> convertSizeList = ParameterUtils.convertSizeList(parameters.getSupportedPictureSizes());
        ArrayList arrayList2 = new ArrayList();
        for (Size size3 : convertSizeList) {
            if (size3.getWidth() >= i && size3.getHeight() >= i2) {
                arrayList2.add(size3);
            }
        }
        if (arrayList2.isEmpty()) {
            throw new AssertionError("Could not find any supported JPEG sizes large enough to fit " + size2);
        }
        Size size4 = (Size) Collections.min(arrayList2, new android.hardware.camera2.utils.SizeAreaComparator());
        if (!size4.equals(size2)) {
            Log.w(this.TAG, String.format("configureOutputs - Will need to crop picture %s into smallest bound size %s", size4, size2));
        }
        return size4;
    }

    private static boolean checkAspectRatiosMatch(Size size, Size size2) {
        return Math.abs((((float) size.getWidth()) / ((float) size.getHeight())) - (((float) size2.getWidth()) / ((float) size2.getHeight()))) < 0.01f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureOutputs(Collection<Pair<Surface, Size>> collection) {
        if (DEBUG) {
            Log.d(this.TAG, "configureOutputs with " + (collection == null ? b.l : collection.size() + " surfaces"));
        }
        try {
            stopPreview();
            try {
                this.mCamera.setPreviewTexture(null);
            } catch (IOException e) {
                Log.w(this.TAG, "Failed to clear prior SurfaceTexture, may cause GL deadlock: ", e);
            } catch (RuntimeException e2) {
                Log.e(this.TAG, "Received device exception in configure call: ", e2);
                this.mDeviceState.setError(1);
                return;
            }
            if (this.mGLThreadManager != null) {
                this.mGLThreadManager.waitUntilStarted();
                this.mGLThreadManager.ignoreNewFrames();
                this.mGLThreadManager.waitUntilIdle();
            }
            resetJpegSurfaceFormats(this.mCallbackOutputs);
            this.mPreviewOutputs.clear();
            this.mCallbackOutputs.clear();
            this.mJpegSurfaceIds.clear();
            this.mPreviewTexture = null;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int intValue = ((Integer) this.mCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
            int intValue2 = ((Integer) this.mCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            if (collection != null) {
                for (Pair<Surface, Size> pair : collection) {
                    Surface surface = pair.first;
                    Size size = pair.second;
                    try {
                        int detectSurfaceType = LegacyCameraDevice.detectSurfaceType(surface);
                        LegacyCameraDevice.setSurfaceOrientation(surface, intValue, intValue2);
                        switch (detectSurfaceType) {
                            case 33:
                                LegacyCameraDevice.setSurfaceFormat(surface, 1);
                                this.mJpegSurfaceIds.add(Long.valueOf(LegacyCameraDevice.getSurfaceId(surface)));
                                this.mCallbackOutputs.add(surface);
                                arrayList2.add(size);
                                continue;
                            default:
                                this.mPreviewOutputs.add(surface);
                                arrayList.add(size);
                                continue;
                        }
                    } catch (LegacyExceptionUtils.BufferQueueAbandonedException e3) {
                        Log.w(this.TAG, "Surface abandoned, skipping...", e3);
                    }
                }
            }
            try {
                this.mParams = this.mCamera.getParameters();
                int[] photoPreviewFpsRange = getPhotoPreviewFpsRange(this.mParams.getSupportedPreviewFpsRange());
                if (DEBUG) {
                    Log.d(this.TAG, "doPreviewCapture - Selected range [" + photoPreviewFpsRange[0] + "," + photoPreviewFpsRange[1] + "]");
                }
                this.mParams.setPreviewFpsRange(photoPreviewFpsRange[0], photoPreviewFpsRange[1]);
                if (arrayList.size() > 0) {
                    Size findLargestByArea = android.hardware.camera2.utils.SizeAreaComparator.findLargestByArea(arrayList);
                    Size largestSupportedJpegSizeByArea = ParameterUtils.getLargestSupportedJpegSizeByArea(this.mParams);
                    List<Size> convertSizeList = ParameterUtils.convertSizeList(this.mParams.getSupportedPreviewSizes());
                    long height = findLargestByArea.getHeight();
                    long width = findLargestByArea.getWidth();
                    Size findLargestByArea2 = android.hardware.camera2.utils.SizeAreaComparator.findLargestByArea(convertSizeList);
                    for (Size size2 : convertSizeList) {
                        long width2 = size2.getWidth() * size2.getHeight();
                        long width3 = findLargestByArea2.getWidth() * findLargestByArea2.getHeight();
                        if (checkAspectRatiosMatch(largestSupportedJpegSizeByArea, size2) && width2 < width3 && width2 >= height * width) {
                            findLargestByArea2 = size2;
                        }
                    }
                    this.mIntermediateBufferSize = findLargestByArea2;
                    this.mParams.setPreviewSize(this.mIntermediateBufferSize.getWidth(), this.mIntermediateBufferSize.getHeight());
                    if (DEBUG) {
                        Log.d(this.TAG, "Intermediate buffer selected with dimens: " + findLargestByArea2.toString());
                    }
                } else {
                    this.mIntermediateBufferSize = null;
                    if (DEBUG) {
                        Log.d(this.TAG, "No Intermediate buffer selected, no preview outputs were configured");
                    }
                }
                Size calculatePictureSize = calculatePictureSize(this.mCallbackOutputs, arrayList2, this.mParams);
                if (calculatePictureSize != null) {
                    Log.i(this.TAG, "configureOutputs - set take picture size to " + calculatePictureSize);
                    this.mParams.setPictureSize(calculatePictureSize.getWidth(), calculatePictureSize.getHeight());
                }
                if (this.mGLThreadManager == null) {
                    this.mGLThreadManager = new GLThreadManager(this.mCameraId, intValue, this.mDeviceState);
                    this.mGLThreadManager.start();
                }
                this.mGLThreadManager.waitUntilStarted();
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList.iterator();
                for (Surface surface2 : this.mPreviewOutputs) {
                    arrayList3.add(new Pair(surface2, it.next()));
                }
                this.mGLThreadManager.setConfigurationAndWait(arrayList3, this.mCaptureCollector);
                this.mGLThreadManager.allowNewFrames();
                this.mPreviewTexture = this.mGLThreadManager.getCurrentSurfaceTexture();
                if (this.mPreviewTexture != null) {
                    this.mPreviewTexture.setOnFrameAvailableListener(this.mPreviewCallback);
                }
                try {
                    this.mCamera.setParameters(this.mParams);
                } catch (RuntimeException e4) {
                    Log.e(this.TAG, "Received device exception while configuring: ", e4);
                    this.mDeviceState.setError(1);
                }
            } catch (RuntimeException e5) {
                Log.e(this.TAG, "Received device exception: ", e5);
                this.mDeviceState.setError(1);
            }
        } catch (RuntimeException e6) {
            Log.e(this.TAG, "Received device exception in configure call: ", e6);
            this.mDeviceState.setError(1);
        }
    }

    private void createDummySurface() {
        if (this.mDummyTexture == null || this.mDummySurface == null) {
            this.mDummyTexture = new SurfaceTexture(0);
            this.mDummyTexture.setDefaultBufferSize(640, 480);
            this.mDummySurface = new Surface(this.mDummyTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJpegCapture(RequestHolder requestHolder) {
        if (DEBUG) {
            Log.d(this.TAG, "doJpegCapturePrepare");
        }
        this.mCamera.takePicture(this.mJpegShutterCallback, null, this.mJpegCallback);
        this.mPreviewRunning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJpegCapturePrepare(RequestHolder requestHolder) throws IOException {
        if (DEBUG) {
            Log.d(this.TAG, "doJpegCapturePrepare - preview running? " + this.mPreviewRunning);
        }
        if (this.mPreviewRunning) {
            return;
        }
        if (DEBUG) {
            Log.d(this.TAG, "doJpegCapture - create fake surface");
        }
        createDummySurface();
        this.mCamera.setPreviewTexture(this.mDummyTexture);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPreviewCapture(RequestHolder requestHolder) throws IOException {
        if (VERBOSE) {
            Log.v(this.TAG, "doPreviewCapture - preview running? " + this.mPreviewRunning);
        }
        if (this.mPreviewRunning) {
            return;
        }
        if (this.mPreviewTexture == null) {
            throw new IllegalStateException("Preview capture called with no preview surfaces configured.");
        }
        this.mPreviewTexture.setDefaultBufferSize(this.mIntermediateBufferSize.getWidth(), this.mIntermediateBufferSize.getHeight());
        this.mCamera.setPreviewTexture(this.mPreviewTexture);
        startPreview();
    }

    private int[] getPhotoPreviewFpsRange(List<int[]> list) {
        int i;
        int i2;
        int i3;
        if (list.size() == 0) {
            Log.e(this.TAG, "No supported frame rates returned!");
            return null;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int[] iArr : list) {
            int i8 = iArr[0];
            int i9 = iArr[1];
            if (i9 <= i5) {
                i3 = i6;
                i2 = i5;
                i = i4;
                if (i9 == i5) {
                    i3 = i6;
                    i2 = i5;
                    i = i4;
                    if (i8 <= i4) {
                    }
                }
                i7++;
                i6 = i3;
                i5 = i2;
                i4 = i;
            }
            i = i8;
            i2 = i9;
            i3 = i7;
            i7++;
            i6 = i3;
            i5 = i2;
            i4 = i;
        }
        return list.get(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetJpegSurfaceFormats(Collection<Surface> collection) {
        if (collection == null) {
            return;
        }
        for (Surface surface : collection) {
            try {
                LegacyCameraDevice.setSurfaceFormat(surface, 33);
            } catch (LegacyExceptionUtils.BufferQueueAbandonedException e) {
                Log.w(this.TAG, "Surface abandoned, skipping...", e);
            }
        }
    }

    private void startPreview() {
        if (VERBOSE) {
            Log.v(this.TAG, "startPreview - preview running? " + this.mPreviewRunning);
        }
        if (this.mPreviewRunning) {
            return;
        }
        this.mCamera.startPreview();
        this.mPreviewRunning = true;
    }

    private void stopPreview() {
        if (VERBOSE) {
            Log.v(this.TAG, "stopPreview - preview running? " + this.mPreviewRunning);
        }
        if (this.mPreviewRunning) {
            this.mCamera.stopPreview();
            this.mPreviewRunning = false;
        }
    }

    public long cancelRepeating(int i) {
        return this.mRequestQueue.stopRepeating(i);
    }

    public void configure(Collection<Pair<Surface, Size>> collection) {
        Handler waitAndGetHandler = this.mRequestThread.waitAndGetHandler();
        ConditionVariable conditionVariable = new ConditionVariable(false);
        waitAndGetHandler.sendMessage(waitAndGetHandler.obtainMessage(1, 0, 0, new ConfigureHolder(conditionVariable, collection)));
        conditionVariable.block();
    }

    public long flush() {
        Log.i(this.TAG, "Flushing all pending requests.");
        long stopRepeating = this.mRequestQueue.stopRepeating();
        this.mCaptureCollector.failAll();
        return stopRepeating;
    }

    public void quit() {
        if (this.mQuit.getAndSet(true)) {
            return;
        }
        Handler waitAndGetHandler = this.mRequestThread.waitAndGetHandler();
        waitAndGetHandler.sendMessageAtFrontOfQueue(waitAndGetHandler.obtainMessage(3));
        this.mRequestThread.quitSafely();
        try {
            this.mRequestThread.join();
        } catch (InterruptedException e) {
            Log.e(this.TAG, String.format("Thread %s (%d) interrupted while quitting.", this.mRequestThread.getName(), Long.valueOf(this.mRequestThread.getId())));
        }
    }

    public void start() {
        this.mRequestThread.start();
    }

    public int submitCaptureRequests(List<CaptureRequest> list, boolean z, LongParcelable longParcelable) {
        int submit;
        Handler waitAndGetHandler = this.mRequestThread.waitAndGetHandler();
        synchronized (this.mIdleLock) {
            submit = this.mRequestQueue.submit(list, z, longParcelable);
            waitAndGetHandler.sendEmptyMessage(2);
        }
        return submit;
    }
}
