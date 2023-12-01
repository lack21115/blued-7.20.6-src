package android.hardware.camera2;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.hardware.camera2.impl.PublicKey;
import android.hardware.camera2.impl.SyntheticKey;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraMetadata.class */
public abstract class CameraMetadata<TKey> {
    public static final int COLOR_CORRECTION_ABERRATION_MODE_FAST = 1;
    public static final int COLOR_CORRECTION_ABERRATION_MODE_HIGH_QUALITY = 2;
    public static final int COLOR_CORRECTION_ABERRATION_MODE_OFF = 0;
    public static final int COLOR_CORRECTION_MODE_FAST = 1;
    public static final int COLOR_CORRECTION_MODE_HIGH_QUALITY = 2;
    public static final int COLOR_CORRECTION_MODE_TRANSFORM_MATRIX = 0;
    public static final int CONTROL_AE_ANTIBANDING_MODE_50HZ = 1;
    public static final int CONTROL_AE_ANTIBANDING_MODE_60HZ = 2;
    public static final int CONTROL_AE_ANTIBANDING_MODE_AUTO = 3;
    public static final int CONTROL_AE_ANTIBANDING_MODE_OFF = 0;
    public static final int CONTROL_AE_MODE_OFF = 0;
    public static final int CONTROL_AE_MODE_ON = 1;
    public static final int CONTROL_AE_MODE_ON_ALWAYS_FLASH = 3;
    public static final int CONTROL_AE_MODE_ON_AUTO_FLASH = 2;
    public static final int CONTROL_AE_MODE_ON_AUTO_FLASH_REDEYE = 4;
    public static final int CONTROL_AE_PRECAPTURE_TRIGGER_IDLE = 0;
    public static final int CONTROL_AE_PRECAPTURE_TRIGGER_START = 1;
    public static final int CONTROL_AE_STATE_CONVERGED = 2;
    public static final int CONTROL_AE_STATE_FLASH_REQUIRED = 4;
    public static final int CONTROL_AE_STATE_INACTIVE = 0;
    public static final int CONTROL_AE_STATE_LOCKED = 3;
    public static final int CONTROL_AE_STATE_PRECAPTURE = 5;
    public static final int CONTROL_AE_STATE_SEARCHING = 1;
    public static final int CONTROL_AF_MODE_AUTO = 1;
    public static final int CONTROL_AF_MODE_CONTINUOUS_PICTURE = 4;
    public static final int CONTROL_AF_MODE_CONTINUOUS_VIDEO = 3;
    public static final int CONTROL_AF_MODE_EDOF = 5;
    public static final int CONTROL_AF_MODE_MACRO = 2;
    public static final int CONTROL_AF_MODE_OFF = 0;
    public static final int CONTROL_AF_STATE_ACTIVE_SCAN = 3;
    public static final int CONTROL_AF_STATE_FOCUSED_LOCKED = 4;
    public static final int CONTROL_AF_STATE_INACTIVE = 0;
    public static final int CONTROL_AF_STATE_NOT_FOCUSED_LOCKED = 5;
    public static final int CONTROL_AF_STATE_PASSIVE_FOCUSED = 2;
    public static final int CONTROL_AF_STATE_PASSIVE_SCAN = 1;
    public static final int CONTROL_AF_STATE_PASSIVE_UNFOCUSED = 6;
    public static final int CONTROL_AF_TRIGGER_CANCEL = 2;
    public static final int CONTROL_AF_TRIGGER_IDLE = 0;
    public static final int CONTROL_AF_TRIGGER_START = 1;
    public static final int CONTROL_AWB_MODE_AUTO = 1;
    public static final int CONTROL_AWB_MODE_CLOUDY_DAYLIGHT = 6;
    public static final int CONTROL_AWB_MODE_DAYLIGHT = 5;
    public static final int CONTROL_AWB_MODE_FLUORESCENT = 3;
    public static final int CONTROL_AWB_MODE_INCANDESCENT = 2;
    public static final int CONTROL_AWB_MODE_OFF = 0;
    public static final int CONTROL_AWB_MODE_SHADE = 8;
    public static final int CONTROL_AWB_MODE_TWILIGHT = 7;
    public static final int CONTROL_AWB_MODE_WARM_FLUORESCENT = 4;
    public static final int CONTROL_AWB_STATE_CONVERGED = 2;
    public static final int CONTROL_AWB_STATE_INACTIVE = 0;
    public static final int CONTROL_AWB_STATE_LOCKED = 3;
    public static final int CONTROL_AWB_STATE_SEARCHING = 1;
    public static final int CONTROL_CAPTURE_INTENT_CUSTOM = 0;
    public static final int CONTROL_CAPTURE_INTENT_MANUAL = 6;
    public static final int CONTROL_CAPTURE_INTENT_PREVIEW = 1;
    public static final int CONTROL_CAPTURE_INTENT_STILL_CAPTURE = 2;
    public static final int CONTROL_CAPTURE_INTENT_VIDEO_RECORD = 3;
    public static final int CONTROL_CAPTURE_INTENT_VIDEO_SNAPSHOT = 4;
    public static final int CONTROL_CAPTURE_INTENT_ZERO_SHUTTER_LAG = 5;
    public static final int CONTROL_EFFECT_MODE_AQUA = 8;
    public static final int CONTROL_EFFECT_MODE_BLACKBOARD = 7;
    public static final int CONTROL_EFFECT_MODE_MONO = 1;
    public static final int CONTROL_EFFECT_MODE_NEGATIVE = 2;
    public static final int CONTROL_EFFECT_MODE_OFF = 0;
    public static final int CONTROL_EFFECT_MODE_POSTERIZE = 5;
    public static final int CONTROL_EFFECT_MODE_SEPIA = 4;
    public static final int CONTROL_EFFECT_MODE_SOLARIZE = 3;
    public static final int CONTROL_EFFECT_MODE_WHITEBOARD = 6;
    public static final int CONTROL_MODE_AUTO = 1;
    public static final int CONTROL_MODE_OFF = 0;
    public static final int CONTROL_MODE_OFF_KEEP_STATE = 3;
    public static final int CONTROL_MODE_USE_SCENE_MODE = 2;
    public static final int CONTROL_SCENE_MODE_ACTION = 2;
    public static final int CONTROL_SCENE_MODE_BARCODE = 16;
    public static final int CONTROL_SCENE_MODE_BEACH = 8;
    public static final int CONTROL_SCENE_MODE_CANDLELIGHT = 15;
    public static final int CONTROL_SCENE_MODE_DISABLED = 0;
    public static final int CONTROL_SCENE_MODE_FACE_PRIORITY = 1;
    public static final int CONTROL_SCENE_MODE_FIREWORKS = 12;
    public static final int CONTROL_SCENE_MODE_HDR = 18;
    public static final int CONTROL_SCENE_MODE_HIGH_SPEED_VIDEO = 17;
    public static final int CONTROL_SCENE_MODE_LANDSCAPE = 4;
    public static final int CONTROL_SCENE_MODE_NIGHT = 5;
    public static final int CONTROL_SCENE_MODE_NIGHT_PORTRAIT = 6;
    public static final int CONTROL_SCENE_MODE_PARTY = 14;
    public static final int CONTROL_SCENE_MODE_PORTRAIT = 3;
    public static final int CONTROL_SCENE_MODE_SNOW = 9;
    public static final int CONTROL_SCENE_MODE_SPORTS = 13;
    public static final int CONTROL_SCENE_MODE_STEADYPHOTO = 11;
    public static final int CONTROL_SCENE_MODE_SUNSET = 10;
    public static final int CONTROL_SCENE_MODE_THEATRE = 7;
    public static final int CONTROL_VIDEO_STABILIZATION_MODE_OFF = 0;
    public static final int CONTROL_VIDEO_STABILIZATION_MODE_ON = 1;
    public static final int EDGE_MODE_FAST = 1;
    public static final int EDGE_MODE_HIGH_QUALITY = 2;
    public static final int EDGE_MODE_OFF = 0;
    public static final int FLASH_MODE_OFF = 0;
    public static final int FLASH_MODE_SINGLE = 1;
    public static final int FLASH_MODE_TORCH = 2;
    public static final int FLASH_STATE_CHARGING = 1;
    public static final int FLASH_STATE_FIRED = 3;
    public static final int FLASH_STATE_PARTIAL = 4;
    public static final int FLASH_STATE_READY = 2;
    public static final int FLASH_STATE_UNAVAILABLE = 0;
    public static final int HOT_PIXEL_MODE_FAST = 1;
    public static final int HOT_PIXEL_MODE_HIGH_QUALITY = 2;
    public static final int HOT_PIXEL_MODE_OFF = 0;
    public static final int INFO_SUPPORTED_HARDWARE_LEVEL_FULL = 1;
    public static final int INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY = 2;
    public static final int INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED = 0;
    public static final int LED_AVAILABLE_LEDS_TRANSMIT = 0;
    public static final int LENS_FACING_BACK = 1;
    public static final int LENS_FACING_FRONT = 0;
    public static final int LENS_INFO_FOCUS_DISTANCE_CALIBRATION_APPROXIMATE = 1;
    public static final int LENS_INFO_FOCUS_DISTANCE_CALIBRATION_CALIBRATED = 2;
    public static final int LENS_INFO_FOCUS_DISTANCE_CALIBRATION_UNCALIBRATED = 0;
    public static final int LENS_OPTICAL_STABILIZATION_MODE_OFF = 0;
    public static final int LENS_OPTICAL_STABILIZATION_MODE_ON = 1;
    public static final int LENS_STATE_MOVING = 1;
    public static final int LENS_STATE_STATIONARY = 0;
    public static final int NOISE_REDUCTION_MODE_FAST = 1;
    public static final int NOISE_REDUCTION_MODE_HIGH_QUALITY = 2;
    public static final int NOISE_REDUCTION_MODE_OFF = 0;
    public static final int REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE = 0;
    public static final int REQUEST_AVAILABLE_CAPABILITIES_BURST_CAPTURE = 6;
    public static final int REQUEST_AVAILABLE_CAPABILITIES_MANUAL_POST_PROCESSING = 2;
    public static final int REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR = 1;
    public static final int REQUEST_AVAILABLE_CAPABILITIES_RAW = 3;
    public static final int REQUEST_AVAILABLE_CAPABILITIES_READ_SENSOR_SETTINGS = 5;
    public static final int REQUEST_AVAILABLE_CAPABILITIES_ZSL = 4;
    public static final int SCALER_CROPPING_TYPE_CENTER_ONLY = 0;
    public static final int SCALER_CROPPING_TYPE_FREEFORM = 1;
    public static final int SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_BGGR = 3;
    public static final int SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GBRG = 2;
    public static final int SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GRBG = 1;
    public static final int SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGB = 4;
    public static final int SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGGB = 0;
    public static final int SENSOR_INFO_TIMESTAMP_SOURCE_REALTIME = 1;
    public static final int SENSOR_INFO_TIMESTAMP_SOURCE_UNKNOWN = 0;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_CLOUDY_WEATHER = 10;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_COOL_WHITE_FLUORESCENT = 14;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_D50 = 23;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_D55 = 20;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_D65 = 21;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_D75 = 22;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_DAYLIGHT = 1;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_DAYLIGHT_FLUORESCENT = 12;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_DAY_WHITE_FLUORESCENT = 13;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_FINE_WEATHER = 9;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_FLASH = 4;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_FLUORESCENT = 2;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_ISO_STUDIO_TUNGSTEN = 24;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_SHADE = 11;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_STANDARD_A = 17;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_STANDARD_B = 18;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_STANDARD_C = 19;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_TUNGSTEN = 3;
    public static final int SENSOR_REFERENCE_ILLUMINANT1_WHITE_FLUORESCENT = 15;
    public static final int SENSOR_TEST_PATTERN_MODE_COLOR_BARS = 2;
    public static final int SENSOR_TEST_PATTERN_MODE_COLOR_BARS_FADE_TO_GRAY = 3;
    public static final int SENSOR_TEST_PATTERN_MODE_CUSTOM1 = 256;
    public static final int SENSOR_TEST_PATTERN_MODE_OFF = 0;
    public static final int SENSOR_TEST_PATTERN_MODE_PN9 = 4;
    public static final int SENSOR_TEST_PATTERN_MODE_SOLID_COLOR = 1;
    public static final int SHADING_MODE_FAST = 1;
    public static final int SHADING_MODE_HIGH_QUALITY = 2;
    public static final int SHADING_MODE_OFF = 0;
    public static final int STATISTICS_FACE_DETECT_MODE_FULL = 2;
    public static final int STATISTICS_FACE_DETECT_MODE_OFF = 0;
    public static final int STATISTICS_FACE_DETECT_MODE_SIMPLE = 1;
    public static final int STATISTICS_LENS_SHADING_MAP_MODE_OFF = 0;
    public static final int STATISTICS_LENS_SHADING_MAP_MODE_ON = 1;
    public static final int STATISTICS_SCENE_FLICKER_50HZ = 1;
    public static final int STATISTICS_SCENE_FLICKER_60HZ = 2;
    public static final int STATISTICS_SCENE_FLICKER_NONE = 0;
    public static final int SYNC_FRAME_NUMBER_CONVERGING = -1;
    public static final int SYNC_FRAME_NUMBER_UNKNOWN = -2;
    public static final int SYNC_MAX_LATENCY_PER_FRAME_CONTROL = 0;
    public static final int SYNC_MAX_LATENCY_UNKNOWN = -1;
    public static final int TONEMAP_MODE_CONTRAST_CURVE = 0;
    public static final int TONEMAP_MODE_FAST = 1;
    public static final int TONEMAP_MODE_HIGH_QUALITY = 2;
    private static final String TAG = "CameraMetadataAb";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <TKey> ArrayList<TKey> getKeysStatic(Class<?> cls, Class<TKey> cls2, CameraMetadata<TKey> cameraMetadata, int[] iArr) {
        if (VERBOSE) {
            Log.v(TAG, "getKeysStatic for " + cls);
        }
        Class<?> cls3 = cls;
        if (cls.equals(TotalCaptureResult.class)) {
            cls3 = CaptureResult.class;
        }
        if (iArr != null) {
            Arrays.sort(iArr);
        }
        ArrayList<TKey> arrayList = (ArrayList<TKey>) new ArrayList();
        Field[] declaredFields = cls3.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            Field field = declaredFields[i2];
            if (field.getType().isAssignableFrom(cls2) && (field.getModifiers() & 1) != 0) {
                try {
                    Object obj = field.get(cameraMetadata);
                    if (cameraMetadata == 0 || cameraMetadata.getProtected(obj) != null) {
                        if (shouldKeyBeAdded(obj, field, iArr)) {
                            arrayList.add(obj);
                            if (VERBOSE) {
                                Log.v(TAG, "getKeysStatic - key was added - " + obj);
                            }
                        } else if (VERBOSE) {
                            Log.v(TAG, "getKeysStatic - key was filtered - " + obj);
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new AssertionError("Can't get IllegalAccessException", e);
                } catch (IllegalArgumentException e2) {
                    throw new AssertionError("Can't get IllegalArgumentException", e2);
                }
            }
            i = i2 + 1;
        }
    }

    private static <TKey> boolean shouldKeyBeAdded(TKey tkey, Field field, int[] iArr) {
        CameraMetadataNative.Key nativeKey;
        boolean z;
        if (tkey == null) {
            throw new NullPointerException("key must not be null");
        }
        if (tkey instanceof CameraCharacteristics.Key) {
            nativeKey = ((CameraCharacteristics.Key) tkey).getNativeKey();
        } else if (tkey instanceof CaptureResult.Key) {
            nativeKey = ((CaptureResult.Key) tkey).getNativeKey();
        } else if (!(tkey instanceof CaptureRequest.Key)) {
            throw new IllegalArgumentException("key type must be that of a metadata key");
        } else {
            nativeKey = ((CaptureRequest.Key) tkey).getNativeKey();
        }
        if (field.getAnnotation(PublicKey.class) == null) {
            z = false;
        } else {
            z = true;
            if (iArr != null) {
                z = true;
                if (field.getAnnotation(SyntheticKey.class) == null) {
                    z = true;
                    if (Arrays.binarySearch(iArr, nativeKey.getTag()) < 0) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    protected abstract Class<TKey> getKeyClass();

    public List<TKey> getKeys() {
        return Collections.unmodifiableList(getKeysStatic(getClass(), getKeyClass(), this, null));
    }

    protected abstract <T> T getProtected(TKey tkey);
}
