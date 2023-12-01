package android.hardware.camera2.legacy;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.CameraInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.params.StreamConfiguration;
import android.hardware.camera2.params.StreamConfigurationDuration;
import android.hardware.camera2.utils.ArrayUtils;
import android.hardware.camera2.utils.ListUtils;
import android.hardware.camera2.utils.ParamsUtils;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import com.android.internal.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/LegacyMetadataMapper.class */
public class LegacyMetadataMapper {
    private static final long APPROXIMATE_CAPTURE_DELAY_MS = 200;
    private static final long APPROXIMATE_JPEG_ENCODE_TIME_MS = 600;
    private static final long APPROXIMATE_SENSOR_AREA_PX = 8388608;
    public static final int HAL_PIXEL_FORMAT_BGRA_8888 = 5;
    public static final int HAL_PIXEL_FORMAT_BLOB = 33;
    public static final int HAL_PIXEL_FORMAT_IMPLEMENTATION_DEFINED = 34;
    public static final int HAL_PIXEL_FORMAT_RGBA_8888 = 1;
    private static final float LENS_INFO_MINIMUM_FOCUS_DISTANCE_FIXED_FOCUS = 0.0f;
    static final boolean LIE_ABOUT_AE_MAX_REGIONS = false;
    static final boolean LIE_ABOUT_AE_STATE = false;
    static final boolean LIE_ABOUT_AF = false;
    static final boolean LIE_ABOUT_AF_MAX_REGIONS = false;
    static final boolean LIE_ABOUT_AWB = false;
    static final boolean LIE_ABOUT_AWB_STATE = false;
    private static final long NS_PER_MS = 1000000;
    private static final float PREVIEW_ASPECT_RATIO_TOLERANCE = 0.01f;
    private static final int REQUEST_MAX_NUM_INPUT_STREAMS_COUNT = 0;
    private static final int REQUEST_MAX_NUM_OUTPUT_STREAMS_COUNT_PROC = 3;
    private static final int REQUEST_MAX_NUM_OUTPUT_STREAMS_COUNT_PROC_STALL = 1;
    private static final int REQUEST_MAX_NUM_OUTPUT_STREAMS_COUNT_RAW = 0;
    private static final int REQUEST_PIPELINE_MAX_DEPTH_HAL1 = 3;
    private static final int REQUEST_PIPELINE_MAX_DEPTH_OURS = 3;
    static final int UNKNOWN_MODE = -1;
    private static final String TAG = "LegacyMetadataMapper";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);
    private static final String[] sLegacySceneModes = {"auto", "action", Camera.Parameters.SCENE_MODE_PORTRAIT, Camera.Parameters.SCENE_MODE_LANDSCAPE, Camera.Parameters.SCENE_MODE_NIGHT, Camera.Parameters.SCENE_MODE_NIGHT_PORTRAIT, Camera.Parameters.SCENE_MODE_THEATRE, Camera.Parameters.SCENE_MODE_BEACH, Camera.Parameters.SCENE_MODE_SNOW, Camera.Parameters.SCENE_MODE_SUNSET, Camera.Parameters.SCENE_MODE_STEADYPHOTO, Camera.Parameters.SCENE_MODE_FIREWORKS, Camera.Parameters.SCENE_MODE_SPORTS, Camera.Parameters.SCENE_MODE_PARTY, Camera.Parameters.SCENE_MODE_CANDLELIGHT, Camera.Parameters.SCENE_MODE_BARCODE, Camera.Parameters.SCENE_MODE_HDR};
    private static final int[] sSceneModes = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18};
    private static final String[] sLegacyEffectMode = {"none", Camera.Parameters.EFFECT_MONO, Camera.Parameters.EFFECT_NEGATIVE, Camera.Parameters.EFFECT_SOLARIZE, Camera.Parameters.EFFECT_SEPIA, Camera.Parameters.EFFECT_POSTERIZE, Camera.Parameters.EFFECT_WHITEBOARD, Camera.Parameters.EFFECT_BLACKBOARD, Camera.Parameters.EFFECT_AQUA};
    private static final int[] sEffectModes = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static final int[] sAllowedTemplates = {1, 2, 3};

    private static void appendStreamConfig(ArrayList<StreamConfiguration> arrayList, int i, List<Camera.Size> list) {
        for (Camera.Size size : list) {
            arrayList.add(new StreamConfiguration(i, size.width, size.height, false));
        }
    }

    private static long calculateJpegStallDuration(Camera.Size size) {
        return (size.width * size.height * 71) + 200000000;
    }

    private static int[] convertAeFpsRangeToLegacy(Range<Integer> range) {
        return new int[]{range.getLower().intValue(), range.getUpper().intValue()};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String convertAfModeToLegacy(int i, List<String> list) {
        String str;
        if (list == null || list.isEmpty()) {
            Log.w(TAG, "No focus modes supported; API1 bug");
            str = null;
        } else {
            String str2 = null;
            switch (i) {
                case 0:
                    if (!list.contains(Camera.Parameters.FOCUS_MODE_FIXED)) {
                        str2 = Camera.Parameters.FOCUS_MODE_INFINITY;
                        break;
                    } else {
                        str2 = Camera.Parameters.FOCUS_MODE_FIXED;
                        break;
                    }
                case 1:
                    str2 = "auto";
                    break;
                case 2:
                    str2 = Camera.Parameters.FOCUS_MODE_MACRO;
                    break;
                case 3:
                    str2 = "continuous-video";
                    break;
                case 4:
                    str2 = "continuous-picture";
                    break;
                case 5:
                    str2 = Camera.Parameters.FOCUS_MODE_EDOF;
                    break;
            }
            str = str2;
            if (!list.contains(str2)) {
                String str3 = list.get(0);
                Log.w(TAG, String.format("convertAfModeToLegacy - ignoring unsupported mode %d, defaulting to %s", Integer.valueOf(i), str3));
                return str3;
            }
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int convertAntiBandingMode(String str) {
        boolean z;
        if (str == null) {
            return -1;
        }
        switch (str.hashCode()) {
            case 109935:
                if (str.equals("off")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1628397:
                if (str.equals(Camera.Parameters.ANTIBANDING_50HZ)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1658188:
                if (str.equals(Camera.Parameters.ANTIBANDING_60HZ)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3005871:
                if (str.equals("auto")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                return 0;
            case true:
                return 1;
            case true:
                return 2;
            case true:
                return 3;
            default:
                Log.w(TAG, "convertAntiBandingMode - Unknown antibanding mode " + str);
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int convertAntiBandingModeOrDefault(String str) {
        int convertAntiBandingMode = convertAntiBandingMode(str);
        int i = convertAntiBandingMode;
        if (convertAntiBandingMode == -1) {
            i = 0;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int convertEffectModeFromLegacy(String str) {
        if (str == null) {
            return 0;
        }
        int arrayIndex = ArrayUtils.getArrayIndex(sLegacyEffectMode, str);
        if (arrayIndex < 0) {
            return -1;
        }
        return sEffectModes[arrayIndex];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String convertEffectModeToLegacy(int i) {
        int arrayIndex = ArrayUtils.getArrayIndex(sEffectModes, i);
        if (arrayIndex < 0) {
            return null;
        }
        return sLegacyEffectMode[arrayIndex];
    }

    public static void convertRequestMetadata(LegacyRequest legacyRequest) {
        LegacyRequestMapper.convertRequestMetadata(legacyRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int convertSceneModeFromLegacy(String str) {
        if (str == null) {
            return 0;
        }
        int arrayIndex = ArrayUtils.getArrayIndex(sLegacySceneModes, str);
        if (arrayIndex < 0) {
            return -1;
        }
        return sSceneModes[arrayIndex];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String convertSceneModeToLegacy(int i) {
        if (i == 1) {
            return "auto";
        }
        int arrayIndex = ArrayUtils.getArrayIndex(sSceneModes, i);
        if (arrayIndex < 0) {
            return null;
        }
        return sLegacySceneModes[arrayIndex];
    }

    public static CameraCharacteristics createCharacteristics(Camera.Parameters parameters, Camera.CameraInfo cameraInfo) {
        Preconditions.checkNotNull(parameters, "parameters must not be null");
        Preconditions.checkNotNull(cameraInfo, "info must not be null");
        String flatten = parameters.flatten();
        CameraInfo cameraInfo2 = new CameraInfo();
        cameraInfo2.info = cameraInfo;
        return createCharacteristics(flatten, cameraInfo2);
    }

    public static CameraCharacteristics createCharacteristics(String str, CameraInfo cameraInfo) {
        Preconditions.checkNotNull(str, "parameters must not be null");
        Preconditions.checkNotNull(cameraInfo, "info must not be null");
        Preconditions.checkNotNull(cameraInfo.info, "info.info must not be null");
        CameraMetadataNative cameraMetadataNative = new CameraMetadataNative();
        mapCharacteristicsFromInfo(cameraMetadataNative, cameraInfo.info);
        Camera.Parameters emptyParameters = Camera.getEmptyParameters();
        emptyParameters.unflatten(str);
        mapCharacteristicsFromParameters(cameraMetadataNative, emptyParameters);
        if (VERBOSE) {
            Log.v(TAG, "createCharacteristics metadata:");
            Log.v(TAG, "--------------------------------------------------- (start)");
            cameraMetadataNative.dumpToLog();
            Log.v(TAG, "--------------------------------------------------- (end)");
        }
        return new CameraCharacteristics(cameraMetadataNative);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x01fb, code lost:
        if (r11 == 2) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.hardware.camera2.impl.CameraMetadataNative createRequestTemplate(android.hardware.camera2.CameraCharacteristics r10, int r11) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.camera2.legacy.LegacyMetadataMapper.createRequestTemplate(android.hardware.camera2.CameraCharacteristics, int):android.hardware.camera2.impl.CameraMetadataNative");
    }

    private static int[] getTagsForKeys(CameraCharacteristics.Key<?>[] keyArr) {
        int[] iArr = new int[keyArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= keyArr.length) {
                return iArr;
            }
            iArr[i2] = keyArr[i2].getNativeKey().getTag();
            i = i2 + 1;
        }
    }

    private static int[] getTagsForKeys(CaptureRequest.Key<?>[] keyArr) {
        int[] iArr = new int[keyArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= keyArr.length) {
                return iArr;
            }
            iArr[i2] = keyArr[i2].getNativeKey().getTag();
            i = i2 + 1;
        }
    }

    private static int[] getTagsForKeys(CaptureResult.Key<?>[] keyArr) {
        int[] iArr = new int[keyArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= keyArr.length) {
                return iArr;
            }
            iArr[i2] = keyArr[i2].getNativeKey().getTag();
            i = i2 + 1;
        }
    }

    private static void mapCharacteristicsFromInfo(CameraMetadataNative cameraMetadataNative, Camera.CameraInfo cameraInfo) {
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.LENS_FACING, (CameraCharacteristics.Key<Integer>) Integer.valueOf(cameraInfo.facing == 0 ? 1 : 0));
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.SENSOR_ORIENTATION, (CameraCharacteristics.Key<Integer>) Integer.valueOf(cameraInfo.orientation));
    }

    private static void mapCharacteristicsFromParameters(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES, (CameraCharacteristics.Key<int[]>) new int[]{1});
        mapControlAe(cameraMetadataNative, parameters);
        mapControlAf(cameraMetadataNative, parameters);
        mapControlAwb(cameraMetadataNative, parameters);
        mapControlOther(cameraMetadataNative, parameters);
        mapLens(cameraMetadataNative, parameters);
        mapFlash(cameraMetadataNative, parameters);
        mapJpeg(cameraMetadataNative, parameters);
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES, (CameraCharacteristics.Key<int[]>) new int[]{1});
        mapScaler(cameraMetadataNative, parameters);
        mapSensor(cameraMetadataNative, parameters);
        mapStatistics(cameraMetadataNative, parameters);
        mapSync(cameraMetadataNative, parameters);
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, (CameraCharacteristics.Key<Integer>) 2);
        mapScalerStreamConfigs(cameraMetadataNative, parameters);
        mapRequest(cameraMetadataNative, parameters);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0173, code lost:
        if (r0.length == 0) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mapControlAe(android.hardware.camera2.impl.CameraMetadataNative r7, android.hardware.Camera.Parameters r8) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.camera2.legacy.LegacyMetadataMapper.mapControlAe(android.hardware.camera2.impl.CameraMetadataNative, android.hardware.Camera$Parameters):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x005e, code lost:
        if (r0.size() == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mapControlAf(android.hardware.camera2.impl.CameraMetadataNative r7, android.hardware.Camera.Parameters r8) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.camera2.legacy.LegacyMetadataMapper.mapControlAf(android.hardware.camera2.impl.CameraMetadataNative, android.hardware.Camera$Parameters):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0073, code lost:
        if (r0.size() == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mapControlAwb(android.hardware.camera2.impl.CameraMetadataNative r7, android.hardware.Camera.Parameters r8) {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.camera2.legacy.LegacyMetadataMapper.mapControlAwb(android.hardware.camera2.impl.CameraMetadataNative, android.hardware.Camera$Parameters):void");
    }

    private static void mapControlOther(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES, (CameraCharacteristics.Key<int[]>) (parameters.isVideoStabilizationSupported() ? new int[]{0, 1} : new int[]{0}));
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.CONTROL_MAX_REGIONS, (CameraCharacteristics.Key<int[]>) new int[]{parameters.getMaxNumMeteringAreas(), 0, parameters.getMaxNumFocusAreas()});
        List<String> supportedColorEffects = parameters.getSupportedColorEffects();
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.CONTROL_AVAILABLE_EFFECTS, (CameraCharacteristics.Key<int[]>) (supportedColorEffects == null ? new int[0] : ArrayUtils.convertStringListToIntArray(supportedColorEffects, sLegacyEffectMode, sEffectModes)));
        List<Integer> convertStringListToIntList = ArrayUtils.convertStringListToIntList(parameters.getSupportedSceneModes(), sLegacySceneModes, sSceneModes);
        ArrayList arrayList = convertStringListToIntList;
        if (convertStringListToIntList == null) {
            arrayList = new ArrayList();
            arrayList.add(0);
        }
        if (parameters.getMaxNumDetectedFaces() > 0) {
            arrayList.add(1);
        }
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES, (CameraCharacteristics.Key<int[]>) ArrayUtils.toIntArray(arrayList));
    }

    private static void mapFlash(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        boolean z = false;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            z = !ListUtils.listElementsEqualTo(supportedFlashModes, "off");
        }
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Boolean>>) CameraCharacteristics.FLASH_INFO_AVAILABLE, (CameraCharacteristics.Key<Boolean>) Boolean.valueOf(z));
    }

    private static void mapJpeg(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        List<Camera.Size> supportedJpegThumbnailSizes = parameters.getSupportedJpegThumbnailSizes();
        if (supportedJpegThumbnailSizes != null) {
            Size[] convertSizeListToArray = ParameterUtils.convertSizeListToArray(supportedJpegThumbnailSizes);
            Arrays.sort(convertSizeListToArray, new android.hardware.camera2.utils.SizeAreaComparator());
            cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Size[]>>) CameraCharacteristics.JPEG_AVAILABLE_THUMBNAIL_SIZES, (CameraCharacteristics.Key<Size[]>) convertSizeListToArray);
        }
    }

    private static void mapLens(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        if (VERBOSE) {
            Log.v(TAG, "mapLens - focus-mode='" + parameters.getFocusMode() + "'");
        }
        if (Camera.Parameters.FOCUS_MODE_FIXED.equals(parameters.getFocusMode())) {
            cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Float>>) CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE, (CameraCharacteristics.Key<Float>) Float.valueOf(0.0f));
            if (VERBOSE) {
                Log.v(TAG, "mapLens - lens.info.minimumFocusDistance = 0");
            }
        } else if (VERBOSE) {
            Log.v(TAG, "mapLens - lens.info.minimumFocusDistance is unknown");
        }
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<float[]>>) CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS, (CameraCharacteristics.Key<float[]>) new float[]{parameters.getFocalLength()});
    }

    private static void mapRequest(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES, (CameraCharacteristics.Key<int[]>) new int[]{0});
        ArrayList arrayList = new ArrayList(Arrays.asList(CameraCharacteristics.COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES, CameraCharacteristics.CONTROL_AE_AVAILABLE_ANTIBANDING_MODES, CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE, CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, CameraCharacteristics.CONTROL_AVAILABLE_EFFECTS, CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES, CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES, CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES, CameraCharacteristics.CONTROL_MAX_REGIONS, CameraCharacteristics.FLASH_INFO_AVAILABLE, CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, CameraCharacteristics.JPEG_AVAILABLE_THUMBNAIL_SIZES, CameraCharacteristics.LENS_FACING, CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS, CameraCharacteristics.NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES, CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES, CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_STREAMS, CameraCharacteristics.REQUEST_PARTIAL_RESULT_COUNT, CameraCharacteristics.REQUEST_PIPELINE_MAX_DEPTH, CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, CameraCharacteristics.SCALER_CROPPING_TYPE, CameraCharacteristics.SENSOR_AVAILABLE_TEST_PATTERN_MODES, CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE, CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE, CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE, CameraCharacteristics.SENSOR_ORIENTATION, CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES, CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT, CameraCharacteristics.SYNC_MAX_LATENCY));
        if (cameraMetadataNative.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE) != null) {
            arrayList.add(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        }
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.REQUEST_AVAILABLE_CHARACTERISTICS_KEYS, (CameraCharacteristics.Key<int[]>) getTagsForKeys((CameraCharacteristics.Key[]) arrayList.toArray(new CameraCharacteristics.Key[0])));
        ArrayList arrayList2 = new ArrayList(Arrays.asList(CaptureRequest.COLOR_CORRECTION_ABERRATION_MODE, CaptureRequest.CONTROL_AE_ANTIBANDING_MODE, CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, CaptureRequest.CONTROL_AE_LOCK, CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_TRIGGER, CaptureRequest.CONTROL_AWB_LOCK, CaptureRequest.CONTROL_AWB_MODE, CaptureRequest.CONTROL_CAPTURE_INTENT, CaptureRequest.CONTROL_EFFECT_MODE, CaptureRequest.CONTROL_MODE, CaptureRequest.CONTROL_SCENE_MODE, CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, CaptureRequest.FLASH_MODE, CaptureRequest.JPEG_GPS_COORDINATES, CaptureRequest.JPEG_GPS_PROCESSING_METHOD, CaptureRequest.JPEG_GPS_TIMESTAMP, CaptureRequest.JPEG_ORIENTATION, CaptureRequest.JPEG_QUALITY, CaptureRequest.JPEG_THUMBNAIL_QUALITY, CaptureRequest.JPEG_THUMBNAIL_SIZE, CaptureRequest.LENS_FOCAL_LENGTH, CaptureRequest.NOISE_REDUCTION_MODE, CaptureRequest.SCALER_CROP_REGION, CaptureRequest.STATISTICS_FACE_DETECT_MODE));
        if (parameters.getMaxNumMeteringAreas() > 0) {
            arrayList2.add(CaptureRequest.CONTROL_AE_REGIONS);
        }
        if (parameters.getMaxNumFocusAreas() > 0) {
            arrayList2.add(CaptureRequest.CONTROL_AF_REGIONS);
        }
        CaptureRequest.Key[] keyArr = new CaptureRequest.Key[arrayList2.size()];
        arrayList2.toArray(keyArr);
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.REQUEST_AVAILABLE_REQUEST_KEYS, (CameraCharacteristics.Key<int[]>) getTagsForKeys(keyArr));
        ArrayList arrayList3 = new ArrayList(Arrays.asList(CaptureResult.COLOR_CORRECTION_ABERRATION_MODE, CaptureResult.CONTROL_AE_ANTIBANDING_MODE, CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION, CaptureResult.CONTROL_AE_LOCK, CaptureResult.CONTROL_AE_MODE, CaptureResult.CONTROL_AF_MODE, CaptureResult.CONTROL_AF_STATE, CaptureResult.CONTROL_AWB_MODE, CaptureResult.CONTROL_AWB_LOCK, CaptureResult.CONTROL_MODE, CaptureResult.FLASH_MODE, CaptureResult.JPEG_GPS_COORDINATES, CaptureResult.JPEG_GPS_PROCESSING_METHOD, CaptureResult.JPEG_GPS_TIMESTAMP, CaptureResult.JPEG_ORIENTATION, CaptureResult.JPEG_QUALITY, CaptureResult.JPEG_THUMBNAIL_QUALITY, CaptureResult.LENS_FOCAL_LENGTH, CaptureResult.NOISE_REDUCTION_MODE, CaptureResult.REQUEST_PIPELINE_DEPTH, CaptureResult.SCALER_CROP_REGION, CaptureResult.SENSOR_TIMESTAMP, CaptureResult.STATISTICS_FACE_DETECT_MODE));
        if (parameters.getMaxNumMeteringAreas() > 0) {
            arrayList3.add(CaptureResult.CONTROL_AE_REGIONS);
        }
        if (parameters.getMaxNumFocusAreas() > 0) {
            arrayList3.add(CaptureResult.CONTROL_AF_REGIONS);
        }
        CaptureResult.Key[] keyArr2 = new CaptureResult.Key[arrayList3.size()];
        arrayList3.toArray(keyArr2);
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.REQUEST_AVAILABLE_RESULT_KEYS, (CameraCharacteristics.Key<int[]>) getTagsForKeys(keyArr2));
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.REQUEST_MAX_NUM_OUTPUT_STREAMS, (CameraCharacteristics.Key<int[]>) new int[]{0, 3, 1});
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.REQUEST_MAX_NUM_INPUT_STREAMS, (CameraCharacteristics.Key<Integer>) 0);
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.REQUEST_PARTIAL_RESULT_COUNT, (CameraCharacteristics.Key<Integer>) 1);
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Byte>>) CameraCharacteristics.REQUEST_PIPELINE_MAX_DEPTH, (CameraCharacteristics.Key<Byte>) (byte) 6);
    }

    private static void mapScaler(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Float>>) CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, (CameraCharacteristics.Key<Float>) Float.valueOf(ParameterUtils.getMaxZoomRatio(parameters)));
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.SCALER_CROPPING_TYPE, (CameraCharacteristics.Key<Integer>) 0);
    }

    private static void mapScalerStreamConfigs(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        ArrayList arrayList = new ArrayList();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        SizeAreaComparator sizeAreaComparator = new SizeAreaComparator();
        Collections.sort(supportedPreviewSizes, sizeAreaComparator);
        Camera.Size findLargestByArea = SizeAreaComparator.findLargestByArea(supportedPictureSizes);
        float f = (findLargestByArea.width * 1.0f) / findLargestByArea.height;
        if (VERBOSE) {
            Log.v(TAG, String.format("mapScalerStreamConfigs - largest JPEG area %dx%d, AR=%f", Integer.valueOf(findLargestByArea.width), Integer.valueOf(findLargestByArea.height), Float.valueOf(f)));
        }
        while (!supportedPreviewSizes.isEmpty()) {
            int size = supportedPreviewSizes.size() - 1;
            Camera.Size size2 = supportedPreviewSizes.get(size);
            float f2 = (size2.width * 1.0f) / size2.height;
            if (Math.abs(f - f2) < 0.01f) {
                break;
            }
            supportedPreviewSizes.remove(size);
            if (VERBOSE) {
                Log.v(TAG, String.format("mapScalerStreamConfigs - removed preview size %dx%d, AR=%f was not the same", Integer.valueOf(size2.width), Integer.valueOf(size2.height), Float.valueOf(f2)));
            }
        }
        List<Camera.Size> list = supportedPreviewSizes;
        if (supportedPreviewSizes.isEmpty()) {
            Log.w(TAG, "mapScalerStreamConfigs - failed to find any preview size matching JPEG aspect ratio " + f);
            list = parameters.getSupportedPreviewSizes();
        }
        Collections.sort(list, Collections.reverseOrder(sizeAreaComparator));
        appendStreamConfig(arrayList, 34, list);
        appendStreamConfig(arrayList, 35, list);
        for (Integer num : parameters.getSupportedPreviewFormats()) {
            int intValue = num.intValue();
            if (ImageFormat.isPublicFormat(intValue) && intValue != 17) {
                appendStreamConfig(arrayList, intValue, list);
            } else if (VERBOSE) {
                Log.v(TAG, String.format("mapStreamConfigs - Skipping format %x", Integer.valueOf(intValue)));
            }
        }
        appendStreamConfig(arrayList, 33, parameters.getSupportedPictureSizes());
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<StreamConfiguration[]>>) CameraCharacteristics.SCALER_AVAILABLE_STREAM_CONFIGURATIONS, (CameraCharacteristics.Key<StreamConfiguration[]>) arrayList.toArray(new StreamConfiguration[0]));
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<StreamConfigurationDuration[]>>) CameraCharacteristics.SCALER_AVAILABLE_MIN_FRAME_DURATIONS, (CameraCharacteristics.Key<StreamConfigurationDuration[]>) new StreamConfigurationDuration[0]);
        StreamConfigurationDuration[] streamConfigurationDurationArr = new StreamConfigurationDuration[supportedPictureSizes.size()];
        int i = 0;
        long j = -1;
        for (Camera.Size size3 : supportedPictureSizes) {
            long calculateJpegStallDuration = calculateJpegStallDuration(size3);
            streamConfigurationDurationArr[i] = new StreamConfigurationDuration(33, size3.width, size3.height, calculateJpegStallDuration);
            long j2 = j;
            if (j < calculateJpegStallDuration) {
                j2 = calculateJpegStallDuration;
            }
            i++;
            j = j2;
        }
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<StreamConfigurationDuration[]>>) CameraCharacteristics.SCALER_AVAILABLE_STALL_DURATIONS, (CameraCharacteristics.Key<StreamConfigurationDuration[]>) streamConfigurationDurationArr);
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Long>>) CameraCharacteristics.SENSOR_INFO_MAX_FRAME_DURATION, (CameraCharacteristics.Key<Long>) Long.valueOf(j));
    }

    private static void mapSensor(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        Size largestSupportedJpegSizeByArea = ParameterUtils.getLargestSupportedJpegSizeByArea(parameters);
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Rect>>) CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, (CameraCharacteristics.Key<Rect>) ParamsUtils.createRect(largestSupportedJpegSizeByArea));
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.SENSOR_AVAILABLE_TEST_PATTERN_MODES, (CameraCharacteristics.Key<int[]>) new int[]{0});
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Size>>) CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE, (CameraCharacteristics.Key<Size>) largestSupportedJpegSizeByArea);
        float focalLength = parameters.getFocalLength();
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<SizeF>>) CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE, (CameraCharacteristics.Key<SizeF>) new SizeF((float) Math.abs(2.0f * focalLength * Math.tan(((parameters.getHorizontalViewAngle() * 3.141592653589793d) / 180.0d) / 2.0d)), (float) Math.abs(2.0f * focalLength * Math.tan(((parameters.getVerticalViewAngle() * 3.141592653589793d) / 180.0d) / 2.0d))));
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE, (CameraCharacteristics.Key<Integer>) 0);
    }

    private static void mapStatistics(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<int[]>>) CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES, (CameraCharacteristics.Key<int[]>) (parameters.getMaxNumDetectedFaces() > 0 ? new int[]{0, 1} : new int[]{0}));
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT, (CameraCharacteristics.Key<Integer>) Integer.valueOf(parameters.getMaxNumDetectedFaces()));
    }

    private static void mapSync(CameraMetadataNative cameraMetadataNative, Camera.Parameters parameters) {
        cameraMetadataNative.set((CameraCharacteristics.Key<CameraCharacteristics.Key<Integer>>) CameraCharacteristics.SYNC_MAX_LATENCY, (CameraCharacteristics.Key<Integer>) (-1));
    }
}
