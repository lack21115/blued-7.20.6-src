package android.hardware.camera2.legacy;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.legacy.ParameterUtils;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.utils.ListUtils;
import android.hardware.camera2.utils.ParamsUtils;
import android.location.Location;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/LegacyRequestMapper.class */
public class LegacyRequestMapper {
    private static final byte DEFAULT_JPEG_QUALITY = 85;
    private static final String TAG = "LegacyRequestMapper";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);

    private static boolean checkForCompleteGpsData(Location location) {
        return (location == null || location.getProvider() == null || location.getTime() == 0) ? false : true;
    }

    private static String convertAeAntiBandingModeToLegacy(int i) {
        switch (i) {
            case 0:
                return "off";
            case 1:
                return Camera.Parameters.ANTIBANDING_50HZ;
            case 2:
                return Camera.Parameters.ANTIBANDING_60HZ;
            case 3:
                return "auto";
            default:
                return null;
        }
    }

    private static int[] convertAeFpsRangeToLegacy(Range<Integer> range) {
        return new int[]{range.getLower().intValue(), range.getUpper().intValue()};
    }

    private static String convertAwbModeToLegacy(int i) {
        switch (i) {
            case 1:
                return "auto";
            case 2:
                return Camera.Parameters.WHITE_BALANCE_INCANDESCENT;
            case 3:
                return Camera.Parameters.WHITE_BALANCE_FLUORESCENT;
            case 4:
                return Camera.Parameters.WHITE_BALANCE_WARM_FLUORESCENT;
            case 5:
                return Camera.Parameters.WHITE_BALANCE_DAYLIGHT;
            case 6:
                return Camera.Parameters.WHITE_BALANCE_CLOUDY_DAYLIGHT;
            case 7:
                return Camera.Parameters.WHITE_BALANCE_TWILIGHT;
            case 8:
                return Camera.Parameters.WHITE_BALANCE_SHADE;
            default:
                Log.w(TAG, "convertAwbModeToLegacy - unrecognized control.awbMode" + i);
                return "auto";
        }
    }

    private static List<Camera.Area> convertMeteringRegionsToLegacy(Rect rect, ParameterUtils.ZoomData zoomData, MeteringRectangle[] meteringRectangleArr, int i, String str) {
        ArrayList asList;
        if (meteringRectangleArr != null && i > 0) {
            ArrayList arrayList = new ArrayList();
            int length = meteringRectangleArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                MeteringRectangle meteringRectangle = meteringRectangleArr[i3];
                if (meteringRectangle.getMeteringWeight() != 0) {
                    arrayList.add(meteringRectangle);
                }
                i2 = i3 + 1;
            }
            if (arrayList.size() == 0) {
                Log.w(TAG, "Only received metering rectangles with weight 0.");
                return Arrays.asList(ParameterUtils.CAMERA_AREA_DEFAULT);
            }
            int min = Math.min(i, arrayList.size());
            ArrayList arrayList2 = new ArrayList(min);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= min) {
                    break;
                }
                arrayList2.add(ParameterUtils.convertMeteringRectangleToLegacy(rect, (MeteringRectangle) arrayList.get(i5), zoomData).meteringArea);
                i4 = i5 + 1;
            }
            if (i < arrayList.size()) {
                Log.w(TAG, "convertMeteringRegionsToLegacy - Too many requested " + str + " regions, ignoring all beyond the first " + i);
            }
            asList = arrayList2;
            if (VERBOSE) {
                Log.v(TAG, "convertMeteringRegionsToLegacy - " + str + " areas = " + ParameterUtils.stringFromAreaList(arrayList2));
                return arrayList2;
            }
        } else if (i <= 0) {
            return null;
        } else {
            asList = Arrays.asList(ParameterUtils.CAMERA_AREA_DEFAULT);
        }
        return asList;
    }

    public static void convertRequestMetadata(LegacyRequest legacyRequest) {
        String str;
        boolean z;
        CameraCharacteristics cameraCharacteristics = legacyRequest.characteristics;
        CaptureRequest captureRequest = legacyRequest.captureRequest;
        Size size = legacyRequest.previewSize;
        Camera.Parameters parameters = legacyRequest.parameters;
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        ParameterUtils.ZoomData convertScalerCropRegion = ParameterUtils.convertScalerCropRegion(rect, (Rect) captureRequest.get(CaptureRequest.SCALER_CROP_REGION), size, parameters);
        if (parameters.isZoomSupported()) {
            parameters.setZoom(convertScalerCropRegion.zoomIndex);
        } else if (VERBOSE) {
            Log.v(TAG, "convertRequestToMetadata - zoom is not supported");
        }
        int intValue = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.COLOR_CORRECTION_ABERRATION_MODE, 1)).intValue();
        if (intValue != 1) {
            Log.w(TAG, "convertRequestToMetadata - Ignoring unsupported colorCorrection.aberrationMode = " + intValue);
        }
        Integer num = (Integer) captureRequest.get(CaptureRequest.CONTROL_AE_ANTIBANDING_MODE);
        String convertAeAntiBandingModeToLegacy = num != null ? convertAeAntiBandingModeToLegacy(num.intValue()) : (String) ListUtils.listSelectFirstFrom(parameters.getSupportedAntibanding(), new String[]{"auto", "off", Camera.Parameters.ANTIBANDING_50HZ, Camera.Parameters.ANTIBANDING_60HZ});
        if (convertAeAntiBandingModeToLegacy != null) {
            parameters.setAntibanding(convertAeAntiBandingModeToLegacy);
        }
        MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) captureRequest.get(CaptureRequest.CONTROL_AE_REGIONS);
        if (captureRequest.get(CaptureRequest.CONTROL_AWB_REGIONS) != null) {
            Log.w(TAG, "convertRequestMetadata - control.awbRegions setting is not supported, ignoring value");
        }
        int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
        List<Camera.Area> convertMeteringRegionsToLegacy = convertMeteringRegionsToLegacy(rect, convertScalerCropRegion, meteringRectangleArr, maxNumMeteringAreas, "AE");
        if (maxNumMeteringAreas > 0) {
            parameters.setMeteringAreas(convertMeteringRegionsToLegacy);
        }
        MeteringRectangle[] meteringRectangleArr2 = (MeteringRectangle[]) captureRequest.get(CaptureRequest.CONTROL_AF_REGIONS);
        int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
        List<Camera.Area> convertMeteringRegionsToLegacy2 = convertMeteringRegionsToLegacy(rect, convertScalerCropRegion, meteringRectangleArr2, maxNumFocusAreas, "AF");
        if (maxNumFocusAreas > 0) {
            parameters.setFocusAreas(convertMeteringRegionsToLegacy2);
        }
        Range range = (Range) captureRequest.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
        if (range != null) {
            int[] convertAeFpsRangeToLegacy = convertAeFpsRangeToLegacy(range);
            Iterator<int[]> it = parameters.getSupportedPreviewFpsRange().iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                int[] next = it.next();
                if (convertAeFpsRangeToLegacy[0] == next[0] && convertAeFpsRangeToLegacy[1] == next[1]) {
                    z = true;
                    break;
                }
            }
            if (z) {
                parameters.setPreviewFpsRange(convertAeFpsRangeToLegacy[0], convertAeFpsRangeToLegacy[1]);
            } else {
                Log.w(TAG, "Unsupported FPS range set [" + convertAeFpsRangeToLegacy[0] + "," + convertAeFpsRangeToLegacy[1] + "]");
            }
        }
        Range range2 = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        int intValue2 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, 0)).intValue();
        int i = intValue2;
        if (!range2.contains((Range) Integer.valueOf(intValue2))) {
            Log.w(TAG, "convertRequestMetadata - control.aeExposureCompensation is out of range, ignoring value");
            i = 0;
        }
        parameters.setExposureCompensation(i);
        Boolean bool = (Boolean) getIfSupported(captureRequest, CaptureRequest.CONTROL_AE_LOCK, false, parameters.isAutoExposureLockSupported(), false);
        if (bool != null) {
            parameters.setAutoExposureLock(bool.booleanValue());
        }
        if (VERBOSE) {
            Log.v(TAG, "convertRequestToMetadata - control.aeLock set to " + bool);
        }
        mapAeAndFlashMode(captureRequest, parameters);
        int intValue3 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_AF_MODE, 0)).intValue();
        String convertAfModeToLegacy = LegacyMetadataMapper.convertAfModeToLegacy(intValue3, parameters.getSupportedFocusModes());
        if (convertAfModeToLegacy != null) {
            parameters.setFocusMode(convertAfModeToLegacy);
        }
        if (VERBOSE) {
            Log.v(TAG, "convertRequestToMetadata - control.afMode " + intValue3 + " mapped to " + convertAfModeToLegacy);
        }
        Integer num2 = (Integer) getIfSupported(captureRequest, CaptureRequest.CONTROL_AWB_MODE, 1, parameters.getSupportedWhiteBalance() != null, 1);
        String str2 = null;
        if (num2 != null) {
            str2 = convertAwbModeToLegacy(num2.intValue());
            parameters.setWhiteBalance(str2);
        }
        if (VERBOSE) {
            Log.v(TAG, "convertRequestToMetadata - control.awbMode " + num2 + " mapped to " + str2);
        }
        Boolean bool2 = (Boolean) getIfSupported(captureRequest, CaptureRequest.CONTROL_AWB_LOCK, false, parameters.isAutoWhiteBalanceLockSupported(), false);
        if (bool2 != null) {
            parameters.setAutoWhiteBalanceLock(bool2.booleanValue());
        }
        int filterSupportedCaptureIntent = filterSupportedCaptureIntent(((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_CAPTURE_INTENT, 1)).intValue());
        parameters.setRecordingHint(filterSupportedCaptureIntent == 3 || filterSupportedCaptureIntent == 4);
        Integer num3 = (Integer) getIfSupported(captureRequest, CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0, parameters.isVideoStabilizationSupported(), 0);
        if (num3 != null) {
            parameters.setVideoStabilization(num3.intValue() == 1);
        }
        boolean listContains = ListUtils.listContains(parameters.getSupportedFocusModes(), Camera.Parameters.FOCUS_MODE_INFINITY);
        Float f = (Float) getIfSupported(captureRequest, CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f), listContains, Float.valueOf(0.0f));
        if (f == null || f.floatValue() != 0.0f) {
            Log.w(TAG, "convertRequestToMetadata - Ignoring android.lens.focusDistance " + listContains + ", only 0.0f is supported");
        }
        if (parameters.getSupportedSceneModes() != null) {
            int intValue4 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_MODE, 1)).intValue();
            switch (intValue4) {
                case 1:
                    str = "auto";
                    break;
                case 2:
                    int intValue5 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_SCENE_MODE, 0)).intValue();
                    str = LegacyMetadataMapper.convertSceneModeToLegacy(intValue5);
                    if (str == null) {
                        str = "auto";
                        Log.w(TAG, "Skipping unknown requested scene mode: " + intValue5);
                        break;
                    }
                    break;
                default:
                    Log.w(TAG, "Control mode " + intValue4 + " is unsupported, defaulting to AUTO");
                    str = "auto";
                    break;
            }
            parameters.setSceneMode(str);
        }
        if (parameters.getSupportedColorEffects() != null) {
            int intValue6 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_EFFECT_MODE, 0)).intValue();
            String convertEffectModeToLegacy = LegacyMetadataMapper.convertEffectModeToLegacy(intValue6);
            if (convertEffectModeToLegacy != null) {
                parameters.setColorEffect(convertEffectModeToLegacy);
            } else {
                parameters.setColorEffect("none");
                Log.w(TAG, "Skipping unknown requested effect mode: " + intValue6);
            }
        }
        int intValue7 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.SENSOR_TEST_PATTERN_MODE, 0)).intValue();
        if (intValue7 != 0) {
            Log.w(TAG, "convertRequestToMetadata - ignoring sensor.testPatternMode " + intValue7 + "; only OFF is supported");
        }
        Location location = (Location) captureRequest.get(CaptureRequest.JPEG_GPS_LOCATION);
        if (location == null) {
            parameters.removeGpsData();
        } else if (checkForCompleteGpsData(location)) {
            parameters.setGpsAltitude(location.getAltitude());
            parameters.setGpsLatitude(location.getLatitude());
            parameters.setGpsLongitude(location.getLongitude());
            parameters.setGpsProcessingMethod(location.getProvider().toUpperCase());
            parameters.setGpsTimestamp(location.getTime());
        } else {
            Log.w(TAG, "Incomplete GPS parameters provided in location " + location);
        }
        Integer num4 = (Integer) captureRequest.get(CaptureRequest.JPEG_ORIENTATION);
        parameters.setRotation(((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(num4 == null ? 0 : num4.intValue()))).intValue());
        parameters.setJpegQuality(((Byte) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.JPEG_QUALITY, (byte) 85)).byteValue() & 255);
        parameters.setJpegThumbnailQuality(((Byte) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.JPEG_THUMBNAIL_QUALITY, (byte) 85)).byteValue() & 255);
        List<Camera.Size> supportedJpegThumbnailSizes = parameters.getSupportedJpegThumbnailSizes();
        if (supportedJpegThumbnailSizes != null && supportedJpegThumbnailSizes.size() > 0) {
            Size size2 = (Size) captureRequest.get(CaptureRequest.JPEG_THUMBNAIL_SIZE);
            boolean z2 = size2 == null ? false : !ParameterUtils.containsSize(supportedJpegThumbnailSizes, size2.getWidth(), size2.getHeight());
            if (z2) {
                Log.w(TAG, "Invalid JPEG thumbnail size set " + size2 + ", skipping thumbnail...");
            }
            if (size2 == null || z2) {
                parameters.setJpegThumbnailSize(0, 0);
            } else {
                parameters.setJpegThumbnailSize(size2.getWidth(), size2.getHeight());
            }
        }
        int intValue8 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.NOISE_REDUCTION_MODE, 1)).intValue();
        if (intValue8 != 1) {
            Log.w(TAG, "convertRequestToMetadata - Ignoring unsupported noiseReduction.mode = " + intValue8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int filterSupportedCaptureIntent(int i) {
        int i2 = i;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
            case 6:
                Log.w(TAG, "Unsupported control.captureIntent value 1; default to PREVIEW");
            default:
                i2 = 1;
                Log.w(TAG, "Unknown control.captureIntent value 1; default to PREVIEW");
                break;
        }
        return i2;
    }

    private static <T> T getIfSupported(CaptureRequest captureRequest, CaptureRequest.Key<T> key, T t, boolean z, T t2) {
        Object orDefault = ParamsUtils.getOrDefault(captureRequest, key, t);
        Object obj = orDefault;
        if (!z) {
            if (!Objects.equals(orDefault, t2)) {
                Log.w(TAG, key.getName() + " is not supported; ignoring requested value " + orDefault);
            }
            obj = null;
        }
        return (T) obj;
    }

    private static void mapAeAndFlashMode(CaptureRequest captureRequest, Camera.Parameters parameters) {
        String str;
        int intValue = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.FLASH_MODE, 0)).intValue();
        int intValue2 = ((Integer) ParamsUtils.getOrDefault(captureRequest, CaptureRequest.CONTROL_AE_MODE, 1)).intValue();
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String str2 = null;
        if (ListUtils.listContains(supportedFlashModes, "off")) {
            str2 = "off";
        }
        if (intValue2 == 1) {
            if (intValue != 2) {
                str = str2;
                if (intValue == 1) {
                    if (ListUtils.listContains(supportedFlashModes, "on")) {
                        str = "on";
                    } else {
                        Log.w(TAG, "mapAeAndFlashMode - Ignore flash.mode == SINGLE;camera does not support it");
                        str = str2;
                    }
                }
            } else if (ListUtils.listContains(supportedFlashModes, "torch")) {
                str = "torch";
            } else {
                Log.w(TAG, "mapAeAndFlashMode - Ignore flash.mode == TORCH;camera does not support it");
                str = str2;
            }
        } else if (intValue2 == 3) {
            if (ListUtils.listContains(supportedFlashModes, "on")) {
                str = "on";
            } else {
                Log.w(TAG, "mapAeAndFlashMode - Ignore control.aeMode == ON_ALWAYS_FLASH;camera does not support it");
                str = str2;
            }
        } else if (intValue2 != 2) {
            str = str2;
            if (intValue2 == 4) {
                if (ListUtils.listContains(supportedFlashModes, Camera.Parameters.FLASH_MODE_RED_EYE)) {
                    str = Camera.Parameters.FLASH_MODE_RED_EYE;
                } else {
                    Log.w(TAG, "mapAeAndFlashMode - Ignore control.aeMode == ON_AUTO_FLASH_REDEYE;camera does not support it");
                    str = str2;
                }
            }
        } else if (ListUtils.listContains(supportedFlashModes, "auto")) {
            str = "auto";
        } else {
            Log.w(TAG, "mapAeAndFlashMode - Ignore control.aeMode == ON_AUTO_FLASH;camera does not support it");
            str = str2;
        }
        if (str != null) {
            parameters.setFlashMode(str);
        }
        if (VERBOSE) {
            Log.v(TAG, "mapAeAndFlashMode - set flash.mode (api1) to " + str + ", requested (api2) " + intValue + ", supported (api1) " + ListUtils.listToString(supportedFlashModes));
        }
    }
}
