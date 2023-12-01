package android.hardware.camera2.legacy;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.legacy.ParameterUtils;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.utils.ListUtils;
import android.hardware.camera2.utils.ParamsUtils;
import android.util.Log;
import android.util.Size;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Preconditions;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/LegacyFaceDetectMapper.class */
public class LegacyFaceDetectMapper {
    private static String TAG = "LegacyFaceDetectMapper";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    private final Camera mCamera;
    private final boolean mFaceDetectSupported;
    private Camera.Face[] mFaces;
    private Camera.Face[] mFacesPrev;
    private boolean mFaceDetectEnabled = false;
    private boolean mFaceDetectScenePriority = false;
    private boolean mFaceDetectReporting = false;
    private final Object mLock = new Object();

    public LegacyFaceDetectMapper(Camera camera, CameraCharacteristics cameraCharacteristics) {
        this.mCamera = (Camera) Preconditions.checkNotNull(camera, "camera must not be null");
        Preconditions.checkNotNull(cameraCharacteristics, "characteristics must not be null");
        this.mFaceDetectSupported = ArrayUtils.contains((int[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES), 1);
        if (this.mFaceDetectSupported) {
            this.mCamera.setFaceDetectionListener(new Camera.FaceDetectionListener() { // from class: android.hardware.camera2.legacy.LegacyFaceDetectMapper.1
                @Override // android.hardware.Camera.FaceDetectionListener
                public void onFaceDetection(Camera.Face[] faceArr, Camera camera2) {
                    int length = faceArr == null ? 0 : faceArr.length;
                    synchronized (LegacyFaceDetectMapper.this.mLock) {
                        if (LegacyFaceDetectMapper.this.mFaceDetectEnabled) {
                            LegacyFaceDetectMapper.this.mFaces = faceArr;
                        } else if (length > 0) {
                            Log.d(LegacyFaceDetectMapper.TAG, "onFaceDetection - Ignored some incoming faces sinceface detection was disabled");
                        }
                    }
                    if (LegacyFaceDetectMapper.VERBOSE) {
                        Log.v(LegacyFaceDetectMapper.TAG, "onFaceDetection - read " + length + " faces");
                    }
                }
            });
        }
    }

    public void mapResultFaces(CameraMetadataNative cameraMetadataNative, LegacyRequest legacyRequest) {
        int i;
        Camera.Face[] faceArr;
        boolean z;
        Camera.Face[] faceArr2;
        Preconditions.checkNotNull(cameraMetadataNative, "result must not be null");
        Preconditions.checkNotNull(legacyRequest, "legacyRequest must not be null");
        synchronized (this.mLock) {
            i = this.mFaceDetectReporting ? 1 : 0;
            faceArr = this.mFaceDetectReporting ? this.mFaces : null;
            z = this.mFaceDetectScenePriority;
            faceArr2 = this.mFacesPrev;
            this.mFacesPrev = faceArr;
        }
        CameraCharacteristics cameraCharacteristics = legacyRequest.characteristics;
        CaptureRequest captureRequest = legacyRequest.captureRequest;
        Size size = legacyRequest.previewSize;
        Camera.Parameters parameters = legacyRequest.parameters;
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        ParameterUtils.ZoomData convertScalerCropRegion = ParameterUtils.convertScalerCropRegion(rect, (Rect) captureRequest.get(CaptureRequest.SCALER_CROP_REGION), size, parameters);
        ArrayList arrayList = new ArrayList();
        if (faceArr != null) {
            int length = faceArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                Camera.Face face = faceArr[i3];
                if (face != null) {
                    arrayList.add(ParameterUtils.convertFaceFromLegacy(face, rect, convertScalerCropRegion));
                } else {
                    Log.w(TAG, "mapResultFaces - read NULL face from camera1 device");
                }
                i2 = i3 + 1;
            }
        }
        if (VERBOSE && faceArr2 != faceArr) {
            Log.v(TAG, "mapResultFaces - changed to " + ListUtils.listToString(arrayList));
        }
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Face[]>>) CaptureResult.STATISTICS_FACES, (CaptureResult.Key<Face[]>) arrayList.toArray(new Face[0]));
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.STATISTICS_FACE_DETECT_MODE, (CaptureResult.Key<Integer>) Integer.valueOf(i));
        if (z) {
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_SCENE_MODE, (CaptureResult.Key<Integer>) 1);
        }
    }

    public void processFaceDetectMode(CaptureRequest captureRequest, Camera.Parameters parameters) {
        Preconditions.checkNotNull(captureRequest, "captureRequest must not be null");
        int intValue = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0)).intValue();
        if (intValue != 0 && !this.mFaceDetectSupported) {
            Log.w(TAG, "processFaceDetectMode - Ignoring statistics.faceDetectMode; face detection is not available");
            return;
        }
        int intValue2 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_SCENE_MODE, 0)).intValue();
        if (intValue2 == 1 && !this.mFaceDetectSupported) {
            Log.w(TAG, "processFaceDetectMode - ignoring control.sceneMode == FACE_PRIORITY; face detection is not available");
            return;
        }
        switch (intValue) {
            case 0:
            case 1:
                break;
            default:
                Log.w(TAG, "processFaceDetectMode - ignoring unknown statistics.faceDetectMode = " + intValue);
                return;
            case 2:
                Log.w(TAG, "processFaceDetectMode - statistics.faceDetectMode == FULL unsupported, downgrading to SIMPLE");
                break;
        }
        boolean z = intValue != 0 || intValue2 == 1;
        synchronized (this.mLock) {
            if (z != this.mFaceDetectEnabled) {
                if (z) {
                    this.mCamera.startFaceDetection();
                    if (VERBOSE) {
                        Log.v(TAG, "processFaceDetectMode - start face detection");
                    }
                } else {
                    this.mCamera.stopFaceDetection();
                    if (VERBOSE) {
                        Log.v(TAG, "processFaceDetectMode - stop face detection");
                    }
                    this.mFaces = null;
                }
                this.mFaceDetectEnabled = z;
                this.mFaceDetectScenePriority = intValue2 == 1;
                this.mFaceDetectReporting = intValue != 0;
            }
        }
    }
}
