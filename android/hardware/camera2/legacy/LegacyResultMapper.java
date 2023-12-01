package android.hardware.camera2.legacy;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.legacy.ParameterUtils;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.utils.ListUtils;
import android.hardware.camera2.utils.ParamsUtils;
import android.location.Location;
import android.util.Log;
import android.util.Size;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/LegacyResultMapper.class */
public class LegacyResultMapper {
    private static final String TAG = "LegacyResultMapper";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    private LegacyRequest mCachedRequest = null;
    private CameraMetadataNative mCachedResult = null;

    private static int convertLegacyAfMode(String str) {
        if (str == null) {
            Log.w(TAG, "convertLegacyAfMode - no AF mode, default to OFF");
            return 0;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -194628547:
                if (str.equals("continuous-video")) {
                    z = true;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    z = false;
                    break;
                }
                break;
            case 3108534:
                if (str.equals(Camera.Parameters.FOCUS_MODE_EDOF)) {
                    z = true;
                    break;
                }
                break;
            case 97445748:
                if (str.equals(Camera.Parameters.FOCUS_MODE_FIXED)) {
                    z = true;
                    break;
                }
                break;
            case 103652300:
                if (str.equals(Camera.Parameters.FOCUS_MODE_MACRO)) {
                    z = true;
                    break;
                }
                break;
            case 173173288:
                if (str.equals(Camera.Parameters.FOCUS_MODE_INFINITY)) {
                    z = true;
                    break;
                }
                break;
            case 910005312:
                if (str.equals("continuous-picture")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                return 1;
            case true:
                return 4;
            case true:
                return 3;
            case true:
                return 5;
            case true:
                return 2;
            case true:
            case true:
                return 0;
            default:
                Log.w(TAG, "convertLegacyAfMode - unknown mode " + str + " , ignoring");
                return 0;
        }
    }

    private static int convertLegacyAwbMode(String str) {
        if (str == null) {
            return 1;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -939299377:
                if (str.equals(Camera.Parameters.WHITE_BALANCE_INCANDESCENT)) {
                    z = true;
                    break;
                }
                break;
            case -719316704:
                if (str.equals(Camera.Parameters.WHITE_BALANCE_WARM_FLUORESCENT)) {
                    z = true;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    z = false;
                    break;
                }
                break;
            case 109399597:
                if (str.equals(Camera.Parameters.WHITE_BALANCE_SHADE)) {
                    z = true;
                    break;
                }
                break;
            case 474934723:
                if (str.equals(Camera.Parameters.WHITE_BALANCE_CLOUDY_DAYLIGHT)) {
                    z = true;
                    break;
                }
                break;
            case 1650323088:
                if (str.equals(Camera.Parameters.WHITE_BALANCE_TWILIGHT)) {
                    z = true;
                    break;
                }
                break;
            case 1902580840:
                if (str.equals(Camera.Parameters.WHITE_BALANCE_FLUORESCENT)) {
                    z = true;
                    break;
                }
                break;
            case 1942983418:
                if (str.equals(Camera.Parameters.WHITE_BALANCE_DAYLIGHT)) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                return 1;
            case true:
                return 2;
            case true:
                return 3;
            case true:
                return 4;
            case true:
                return 5;
            case true:
                return 6;
            case true:
                return 7;
            case true:
                return 8;
            default:
                Log.w(TAG, "convertAwbMode - unrecognized WB mode " + str);
                return 1;
        }
    }

    private static CameraMetadataNative convertResultMetadata(LegacyRequest legacyRequest) {
        CameraCharacteristics cameraCharacteristics = legacyRequest.characteristics;
        CaptureRequest captureRequest = legacyRequest.captureRequest;
        Size size = legacyRequest.previewSize;
        Camera.Parameters parameters = legacyRequest.parameters;
        CameraMetadataNative cameraMetadataNative = new CameraMetadataNative();
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        ParameterUtils.ZoomData convertScalerCropRegion = ParameterUtils.convertScalerCropRegion(rect, (Rect) captureRequest.get(CaptureRequest.SCALER_CROP_REGION), size, parameters);
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.COLOR_CORRECTION_ABERRATION_MODE, (CaptureResult.Key<Integer>) 1);
        mapAe(cameraMetadataNative, cameraCharacteristics, captureRequest, rect, convertScalerCropRegion, parameters);
        mapAf(cameraMetadataNative, rect, convertScalerCropRegion, parameters);
        mapAwb(cameraMetadataNative, parameters);
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_CAPTURE_INTENT, (CaptureResult.Key<Integer>) Integer.valueOf(LegacyRequestMapper.filterSupportedCaptureIntent(((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_CAPTURE_INTENT, 1)).intValue())));
        if (((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_MODE, 1)).intValue() == 2) {
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_MODE, (CaptureResult.Key<Integer>) 2);
        } else {
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_MODE, (CaptureResult.Key<Integer>) 1);
        }
        String sceneMode = parameters.getSceneMode();
        int convertSceneModeFromLegacy = LegacyMetadataMapper.convertSceneModeFromLegacy(sceneMode);
        if (convertSceneModeFromLegacy != -1) {
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_SCENE_MODE, (CaptureResult.Key<Integer>) Integer.valueOf(convertSceneModeFromLegacy));
        } else {
            Log.w(TAG, "Unknown scene mode " + sceneMode + " returned by camera HAL, setting to disabled.");
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_SCENE_MODE, (CaptureResult.Key<Integer>) 0);
        }
        String colorEffect = parameters.getColorEffect();
        int convertEffectModeFromLegacy = LegacyMetadataMapper.convertEffectModeFromLegacy(colorEffect);
        if (convertEffectModeFromLegacy != -1) {
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_EFFECT_MODE, (CaptureResult.Key<Integer>) Integer.valueOf(convertEffectModeFromLegacy));
        } else {
            Log.w(TAG, "Unknown effect mode " + colorEffect + " returned by camera HAL, setting to off.");
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_EFFECT_MODE, (CaptureResult.Key<Integer>) 0);
        }
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_VIDEO_STABILIZATION_MODE, (CaptureResult.Key<Integer>) Integer.valueOf((parameters.isVideoStabilizationSupported() && parameters.getVideoStabilization()) ? 1 : 0));
        if (Camera.Parameters.FOCUS_MODE_INFINITY.equals(parameters.getFocusMode())) {
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Float>>) CaptureResult.LENS_FOCUS_DISTANCE, (CaptureResult.Key<Float>) Float.valueOf(0.0f));
        }
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Float>>) CaptureResult.LENS_FOCAL_LENGTH, (CaptureResult.Key<Float>) Float.valueOf(parameters.getFocalLength()));
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Byte>>) CaptureResult.REQUEST_PIPELINE_DEPTH, (CaptureResult.Key<Byte>) cameraCharacteristics.get(CameraCharacteristics.REQUEST_PIPELINE_MAX_DEPTH));
        mapScaler(cameraMetadataNative, convertScalerCropRegion, parameters);
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.SENSOR_TEST_PATTERN_MODE, (CaptureResult.Key<Integer>) 0);
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Location>>) CaptureResult.JPEG_GPS_LOCATION, (CaptureResult.Key<Location>) captureRequest.get(CaptureRequest.JPEG_GPS_LOCATION));
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.JPEG_ORIENTATION, (CaptureResult.Key<Integer>) captureRequest.get(CaptureRequest.JPEG_ORIENTATION));
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Byte>>) CaptureResult.JPEG_QUALITY, (CaptureResult.Key<Byte>) Byte.valueOf((byte) parameters.getJpegQuality()));
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Byte>>) CaptureResult.JPEG_THUMBNAIL_QUALITY, (CaptureResult.Key<Byte>) Byte.valueOf((byte) parameters.getJpegThumbnailQuality()));
        Camera.Size jpegThumbnailSize = parameters.getJpegThumbnailSize();
        if (jpegThumbnailSize != null) {
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Size>>) CaptureResult.JPEG_THUMBNAIL_SIZE, (CaptureResult.Key<Size>) ParameterUtils.convertSize(jpegThumbnailSize));
        } else {
            Log.w(TAG, "Null thumbnail size received from parameters.");
        }
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.NOISE_REDUCTION_MODE, (CaptureResult.Key<Integer>) 1);
        return cameraMetadataNative;
    }

    private static MeteringRectangle[] getMeteringRectangles(Rect rect, ParameterUtils.ZoomData zoomData, List<Camera.Area> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Camera.Area area : list) {
                arrayList.add(ParameterUtils.convertCameraAreaToActiveArrayRectangle(rect, zoomData, area).toMetering());
            }
        }
        if (VERBOSE) {
            Log.v(TAG, "Metering rectangles for " + str + ": " + ListUtils.listToString(arrayList));
        }
        return (MeteringRectangle[]) arrayList.toArray(new MeteringRectangle[0]);
    }

    private static void mapAe(CameraMetadataNative cameraMetadataNative, CameraCharacteristics cameraCharacteristics, CaptureRequest captureRequest, Rect rect, ParameterUtils.ZoomData zoomData, Camera.Parameters parameters) {
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_AE_ANTIBANDING_MODE, (CaptureResult.Key<Integer>) Integer.valueOf(LegacyMetadataMapper.convertAntiBandingModeOrDefault(parameters.getAntibanding())));
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureResult.Key<Integer>) Integer.valueOf(parameters.getExposureCompensation()));
        boolean autoExposureLock = parameters.isAutoExposureLockSupported() ? parameters.getAutoExposureLock() : false;
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Boolean>>) CaptureResult.CONTROL_AE_LOCK, (CaptureResult.Key<Boolean>) Boolean.valueOf(autoExposureLock));
        if (VERBOSE) {
            Log.v(TAG, "mapAe - android.control.aeLock = " + autoExposureLock + ", supported = " + parameters.isAutoExposureLockSupported());
        }
        Boolean bool = (Boolean) captureRequest.get(CaptureRequest.CONTROL_AE_LOCK);
        if (bool != null && bool.booleanValue() != autoExposureLock) {
            Log.w(TAG, "mapAe - android.control.aeLock was requested to " + bool + " but resulted in " + autoExposureLock);
        }
        mapAeAndFlashMode(cameraMetadataNative, cameraCharacteristics, parameters);
        if (parameters.getMaxNumMeteringAreas() > 0) {
            if (VERBOSE) {
                Log.v(TAG, "mapAe - parameter dump; metering-areas: " + parameters.get("metering-areas"));
            }
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<MeteringRectangle[]>>) CaptureResult.CONTROL_AE_REGIONS, (CaptureResult.Key<MeteringRectangle[]>) getMeteringRectangles(rect, zoomData, parameters.getMeteringAreas(), "AE"));
        }
    }

    private static void mapAeAndFlashMode(CameraMetadataNative cameraMetadataNative, CameraCharacteristics cameraCharacteristics, Camera.Parameters parameters) {
        Integer num = ((Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue() ? null : 0;
        String flashMode = parameters.getFlashMode();
        int i = 1;
        int i2 = 0;
        Integer num2 = num;
        if (flashMode != null) {
            boolean z = true;
            switch (flashMode.hashCode()) {
                case 3551:
                    if (flashMode.equals("on")) {
                        z = true;
                        break;
                    }
                    break;
                case 109935:
                    if (flashMode.equals("off")) {
                        z = false;
                        break;
                    }
                    break;
                case 3005871:
                    if (flashMode.equals("auto")) {
                        z = true;
                        break;
                    }
                    break;
                case 110547964:
                    if (flashMode.equals("torch")) {
                        z = true;
                        break;
                    }
                    break;
                case 1081542389:
                    if (flashMode.equals(Camera.Parameters.FLASH_MODE_RED_EYE)) {
                        z = true;
                        break;
                    }
                    break;
            }
            i = 1;
            i2 = 0;
            num2 = num;
            switch (z) {
                case false:
                    break;
                case true:
                    i = 2;
                    i2 = 0;
                    num2 = num;
                    break;
                case true:
                    i2 = 1;
                    i = 3;
                    num2 = 3;
                    break;
                case true:
                    i = 4;
                    i2 = 0;
                    num2 = num;
                    break;
                case true:
                    i2 = 2;
                    num2 = 3;
                    i = 1;
                    break;
                default:
                    Log.w(TAG, "mapAeAndFlashMode - Ignoring unknown flash mode " + parameters.getFlashMode());
                    num2 = num;
                    i2 = 0;
                    i = 1;
                    break;
            }
        }
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.FLASH_STATE, (CaptureResult.Key<Integer>) num2);
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.FLASH_MODE, (CaptureResult.Key<Integer>) Integer.valueOf(i2));
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_AE_MODE, (CaptureResult.Key<Integer>) Integer.valueOf(i));
    }

    private static void mapAf(CameraMetadataNative cameraMetadataNative, Rect rect, ParameterUtils.ZoomData zoomData, Camera.Parameters parameters) {
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_AF_MODE, (CaptureResult.Key<Integer>) Integer.valueOf(convertLegacyAfMode(parameters.getFocusMode())));
        if (parameters.getMaxNumFocusAreas() > 0) {
            if (VERBOSE) {
                Log.v(TAG, "mapAe - parameter dump; focus-areas: " + parameters.get("focus-areas"));
            }
            cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<MeteringRectangle[]>>) CaptureResult.CONTROL_AF_REGIONS, (CaptureResult.Key<MeteringRectangle[]>) getMeteringRectangles(rect, zoomData, parameters.getFocusAreas(), "AF"));
        }
    }

    private static void mapAwb(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Boolean>>) CaptureResult.CONTROL_AWB_LOCK, (CaptureResult.Key<Boolean>) Boolean.valueOf(parameters.isAutoWhiteBalanceLockSupported() ? parameters.getAutoWhiteBalanceLock() : false));
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Integer>>) CaptureResult.CONTROL_AWB_MODE, (CaptureResult.Key<Integer>) Integer.valueOf(convertLegacyAwbMode(parameters.getWhiteBalance())));
    }

    private static void mapScaler(CameraMetadataNative cameraMetadataNative, ParameterUtils.ZoomData zoomData, Camera.Parameters parameters) {
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Rect>>) CaptureResult.SCALER_CROP_REGION, (CaptureResult.Key<Rect>) zoomData.reportedCrop);
    }

    public CameraMetadataNative cachedConvertResultMetadata(LegacyRequest legacyRequest, long j) {
        boolean z;
        CameraMetadataNative cameraMetadataNative;
        if (this.mCachedRequest == null || !legacyRequest.parameters.same(this.mCachedRequest.parameters)) {
            CameraMetadataNative convertResultMetadata = convertResultMetadata(legacyRequest);
            z = false;
            this.mCachedRequest = legacyRequest;
            this.mCachedResult = new CameraMetadataNative(convertResultMetadata);
            cameraMetadataNative = convertResultMetadata;
        } else {
            cameraMetadataNative = new CameraMetadataNative(this.mCachedResult);
            z = true;
        }
        cameraMetadataNative.set((CaptureResult.Key<CaptureResult.Key<Long>>) CaptureResult.SENSOR_TIMESTAMP, (CaptureResult.Key<Long>) Long.valueOf(j));
        if (VERBOSE) {
            Log.v(TAG, "cachedConvertResultMetadata - cached? " + z + " timestamp = " + j);
            Log.v(TAG, "----- beginning of result dump ------");
            cameraMetadataNative.dumpToLog();
            Log.v(TAG, "----- end of result dump ------");
        }
        return cameraMetadataNative;
    }
}
