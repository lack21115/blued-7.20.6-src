package android.hardware;

import android.app.ActivityThread;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.ITorchService;
import android.media.IAudioService;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSIllegalArgumentException;
import android.renderscript.RenderScript;
import android.renderscript.Type;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera.class */
public class Camera {
    public static final String ACTION_NEW_PICTURE = "android.hardware.action.NEW_PICTURE";
    public static final String ACTION_NEW_VIDEO = "android.hardware.action.NEW_VIDEO";
    public static final int CAMERA_ERROR_SERVER_DIED = 100;
    public static final int CAMERA_ERROR_UNKNOWN = 1;
    private static final int CAMERA_FACE_DETECTION_HW = 0;
    private static final int CAMERA_FACE_DETECTION_SW = 1;
    public static final int CAMERA_HAL_API_VERSION_1_0 = 256;
    private static final int CAMERA_HAL_API_VERSION_NORMAL_CONNECT = -2;
    private static final int CAMERA_HAL_API_VERSION_UNSPECIFIED = -1;
    private static final int CAMERA_MSG_COMPRESSED_IMAGE = 256;
    private static final int CAMERA_MSG_ERROR = 1;
    private static final int CAMERA_MSG_FOCUS = 4;
    private static final int CAMERA_MSG_FOCUS_MOVE = 2048;
    private static final int CAMERA_MSG_META_DATA = 8192;
    private static final int CAMERA_MSG_POSTVIEW_FRAME = 64;
    private static final int CAMERA_MSG_PREVIEW_FRAME = 16;
    private static final int CAMERA_MSG_PREVIEW_METADATA = 1024;
    private static final int CAMERA_MSG_RAW_IMAGE = 128;
    private static final int CAMERA_MSG_RAW_IMAGE_NOTIFY = 512;
    private static final int CAMERA_MSG_SHUTTER = 2;
    private static final int CAMERA_MSG_STATS_DATA = 4096;
    private static final int CAMERA_MSG_VIDEO_FRAME = 32;
    private static final int CAMERA_MSG_ZOOM = 8;
    private static final int EACCESS = -13;
    private static final int EBUSY = -16;
    private static final int EINVAL = -22;
    private static final int ENODEV = -19;
    private static final int ENOSYS = -38;
    private static final int EOPNOTSUPP = -95;
    private static final int EUSERS = -87;
    private static final int NO_ERROR = 0;
    private static final String TAG = "Camera";
    private AutoFocusCallback mAutoFocusCallback;
    private AutoFocusMoveCallback mAutoFocusMoveCallback;
    private CameraDataCallback mCameraDataCallback;
    private int mCameraId;
    private CameraMetaDataCallback mCameraMetaDataCallback;
    private ErrorCallback mErrorCallback;
    private EventHandler mEventHandler;
    private FaceDetectionListener mFaceListener;
    private PictureCallback mJpegCallback;
    private long mNativeContext;
    private boolean mOneShot;
    private PictureCallback mPostviewCallback;
    private PreviewCallback mPreviewCallback;
    private PictureCallback mRawImageCallback;
    private ShutterCallback mShutterCallback;
    private Binder mTorchToken;
    private boolean mUsingPreviewAllocation;
    private boolean mWithBuffer;
    private OnZoomChangeListener mZoomListener;
    private boolean mFaceDetectionRunning = false;
    private final Object mAutoFocusCallbackLock = new Object();

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$Area.class */
    public static class Area {
        public Rect rect;
        public int weight;

        public Area(Rect rect, int i) {
            this.rect = rect;
            this.weight = i;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Area) {
                Area area = (Area) obj;
                if (this.rect == null) {
                    if (area.rect != null) {
                        return false;
                    }
                } else if (!this.rect.equals(area.rect)) {
                    return false;
                }
                return this.weight == area.weight;
            }
            return false;
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$AutoFocusCallback.class */
    public interface AutoFocusCallback {
        void onAutoFocus(boolean z, Camera camera);
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$AutoFocusMoveCallback.class */
    public interface AutoFocusMoveCallback {
        void onAutoFocusMoving(boolean z, Camera camera);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$CameraDataCallback.class */
    public interface CameraDataCallback {
        void onCameraData(int[] iArr, Camera camera);
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$CameraInfo.class */
    public static class CameraInfo {
        public static final int CAMERA_FACING_BACK = 0;
        public static final int CAMERA_FACING_FRONT = 1;
        public static final int CAMERA_SUPPORT_MODE_NONZSL = 3;
        public static final int CAMERA_SUPPORT_MODE_ZSL = 2;
        public boolean canDisableShutterSound;
        public int facing;
        public int orientation;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$CameraMetaDataCallback.class */
    public interface CameraMetaDataCallback {
        void onCameraMetaData(byte[] bArr, Camera camera);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$Coordinate.class */
    public class Coordinate {
        public int xCoordinate;
        public int yCoordinate;

        public Coordinate(int i, int i2) {
            this.xCoordinate = i;
            this.yCoordinate = i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Coordinate) {
                Coordinate coordinate = (Coordinate) obj;
                return this.xCoordinate == coordinate.xCoordinate && this.yCoordinate == coordinate.yCoordinate;
            }
            return false;
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$ErrorCallback.class */
    public interface ErrorCallback {
        void onError(int i, Camera camera);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$EventHandler.class */
    public class EventHandler extends Handler {
        private final Camera mCamera;

        public EventHandler(Camera camera, Looper looper) {
            super(looper);
            this.mCamera = camera;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AutoFocusCallback autoFocusCallback;
            boolean z = true;
            switch (message.what) {
                case 1:
                    Log.e(Camera.TAG, "Error " + message.arg1);
                    if (Camera.this.mErrorCallback != null) {
                        Camera.this.mErrorCallback.onError(message.arg1, this.mCamera);
                        return;
                    }
                    return;
                case 2:
                    if (Camera.this.mShutterCallback != null) {
                        Camera.this.mShutterCallback.onShutter();
                        return;
                    }
                    return;
                case 4:
                    synchronized (Camera.this.mAutoFocusCallbackLock) {
                        autoFocusCallback = Camera.this.mAutoFocusCallback;
                    }
                    if (autoFocusCallback != null) {
                        autoFocusCallback.onAutoFocus(message.arg1 != 0, this.mCamera);
                        return;
                    }
                    return;
                case 8:
                    if (Camera.this.mZoomListener != null) {
                        OnZoomChangeListener onZoomChangeListener = Camera.this.mZoomListener;
                        int i = message.arg1;
                        if (message.arg2 == 0) {
                            z = false;
                        }
                        onZoomChangeListener.onZoomChange(i, z, this.mCamera);
                        return;
                    }
                    return;
                case 16:
                    PreviewCallback previewCallback = Camera.this.mPreviewCallback;
                    if (previewCallback != null) {
                        if (Camera.this.mOneShot) {
                            Camera.this.mPreviewCallback = null;
                        } else if (!Camera.this.mWithBuffer) {
                            Camera.this.setHasPreviewCallback(true, false);
                        }
                        previewCallback.onPreviewFrame((byte[]) message.obj, this.mCamera);
                        return;
                    }
                    return;
                case 64:
                    if (Camera.this.mPostviewCallback != null) {
                        Camera.this.mPostviewCallback.onPictureTaken((byte[]) message.obj, this.mCamera);
                        return;
                    }
                    return;
                case 128:
                    if (Camera.this.mRawImageCallback != null) {
                        Camera.this.mRawImageCallback.onPictureTaken((byte[]) message.obj, this.mCamera);
                        return;
                    }
                    return;
                case 256:
                    if (Camera.this.mJpegCallback != null) {
                        Camera.this.mJpegCallback.onPictureTaken((byte[]) message.obj, this.mCamera);
                        return;
                    }
                    return;
                case 1024:
                    if (Camera.this.mFaceListener != null) {
                        Camera.this.mFaceListener.onFaceDetection((Face[]) message.obj, this.mCamera);
                        return;
                    }
                    return;
                case 2048:
                    if (Camera.this.mAutoFocusMoveCallback != null) {
                        Camera.this.mAutoFocusMoveCallback.onAutoFocusMoving(message.arg1 != 0, this.mCamera);
                        return;
                    }
                    return;
                case 4096:
                    int[] iArr = new int[257];
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= 257) {
                            if (Camera.this.mCameraDataCallback != null) {
                                Camera.this.mCameraDataCallback.onCameraData(iArr, this.mCamera);
                                return;
                            }
                            return;
                        }
                        iArr[i3] = Camera.byteToInt((byte[]) message.obj, i3 * 4);
                        i2 = i3 + 1;
                    }
                case 8192:
                    if (Camera.this.mCameraMetaDataCallback != null) {
                        Camera.this.mCameraMetaDataCallback.onCameraMetaData((byte[]) message.obj, this.mCamera);
                        return;
                    }
                    return;
                default:
                    Log.e(Camera.TAG, "Unknown message type " + message.what);
                    return;
            }
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$Face.class */
    public static class Face {
        public Rect rect;
        public int score;
        public int id = -1;
        public Point leftEye = null;
        public Point rightEye = null;
        public Point mouth = null;
        public int smileDegree = 0;
        public int smileScore = 0;
        public int blinkDetected = 0;
        public int faceRecognised = 0;
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$FaceDetectionListener.class */
    public interface FaceDetectionListener {
        void onFaceDetection(Face[] faceArr, Camera camera);
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$OnZoomChangeListener.class */
    public interface OnZoomChangeListener {
        void onZoomChange(int i, boolean z, Camera camera);
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$Parameters.class */
    public class Parameters {
        public static final String AE_BRACKET = "AE-Bracket";
        public static final String AE_BRACKET_HDR = "HDR";
        public static final String AE_BRACKET_HDR_OFF = "Off";
        public static final String ANTIBANDING_50HZ = "50hz";
        public static final String ANTIBANDING_60HZ = "60hz";
        public static final String ANTIBANDING_AUTO = "auto";
        public static final String ANTIBANDING_OFF = "off";
        public static final String AUTO_EXPOSURE_CENTER_WEIGHTED = "center-weighted";
        public static final String AUTO_EXPOSURE_FRAME_AVG = "frame-average";
        public static final String AUTO_EXPOSURE_SPOT_METERING = "spot-metering";
        public static final String CONTINUOUS_AF_OFF = "caf-off";
        public static final String CONTINUOUS_AF_ON = "caf-on";
        public static final String DENOISE_OFF = "denoise-off";
        public static final String DENOISE_ON = "denoise-on";
        public static final String EFFECT_AQUA = "aqua";
        public static final String EFFECT_BLACKBOARD = "blackboard";
        public static final String EFFECT_MONO = "mono";
        public static final String EFFECT_NEGATIVE = "negative";
        public static final String EFFECT_NONE = "none";
        public static final String EFFECT_POSTERIZE = "posterize";
        public static final String EFFECT_SEPIA = "sepia";
        public static final String EFFECT_SOLARIZE = "solarize";
        public static final String EFFECT_WHITEBOARD = "whiteboard";
        public static final String FACE_DETECTION_OFF = "off";
        public static final String FACE_DETECTION_ON = "on";
        private static final String FALSE = "false";
        public static final String FLASH_MODE_AUTO = "auto";
        public static final String FLASH_MODE_OFF = "off";
        public static final String FLASH_MODE_ON = "on";
        public static final String FLASH_MODE_RED_EYE = "red-eye";
        public static final String FLASH_MODE_TORCH = "torch";
        public static final int FOCUS_DISTANCE_FAR_INDEX = 2;
        public static final int FOCUS_DISTANCE_NEAR_INDEX = 0;
        public static final int FOCUS_DISTANCE_OPTIMAL_INDEX = 1;
        public static final String FOCUS_MODE_AUTO = "auto";
        public static final String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";
        public static final String FOCUS_MODE_CONTINUOUS_VIDEO = "continuous-video";
        public static final String FOCUS_MODE_EDOF = "edof";
        public static final String FOCUS_MODE_FIXED = "fixed";
        public static final String FOCUS_MODE_INFINITY = "infinity";
        public static final String FOCUS_MODE_MACRO = "macro";
        public static final String FOCUS_MODE_MANUAL_POSITION = "manual";
        public static final String FOCUS_MODE_NORMAL = "normal";
        public static final String HISTOGRAM_DISABLE = "disable";
        public static final String HISTOGRAM_ENABLE = "enable";
        public static final String ISO_100 = "ISO100";
        public static final String ISO_1600 = "ISO1600";
        public static final String ISO_200 = "ISO200";
        public static final String ISO_3200 = "ISO3200";
        public static final String ISO_400 = "ISO400";
        public static final String ISO_800 = "ISO800";
        public static final String ISO_AUTO = "auto";
        public static final String ISO_HJR = "ISO_HJR";
        private static final String KEY_ANTIBANDING = "antibanding";
        private static final String KEY_AUTO_EXPOSURE_LOCK = "auto-exposure-lock";
        private static final String KEY_AUTO_EXPOSURE_LOCK_SUPPORTED = "auto-exposure-lock-supported";
        private static final String KEY_AUTO_WHITEBALANCE_LOCK = "auto-whitebalance-lock";
        private static final String KEY_AUTO_WHITEBALANCE_LOCK_SUPPORTED = "auto-whitebalance-lock-supported";
        private static final String KEY_EFFECT = "effect";
        private static final String KEY_EXPOSURE_COMPENSATION = "exposure-compensation";
        private static final String KEY_EXPOSURE_COMPENSATION_STEP = "exposure-compensation-step";
        private static final String KEY_FLASH_MODE = "flash-mode";
        private static final String KEY_FOCAL_LENGTH = "focal-length";
        private static final String KEY_FOCUS_AREAS = "focus-areas";
        private static final String KEY_FOCUS_DISTANCES = "focus-distances";
        private static final String KEY_FOCUS_MODE = "focus-mode";
        private static final String KEY_GPS_ALTITUDE = "gps-altitude";
        private static final String KEY_GPS_LATITUDE = "gps-latitude";
        private static final String KEY_GPS_LONGITUDE = "gps-longitude";
        private static final String KEY_GPS_PROCESSING_METHOD = "gps-processing-method";
        private static final String KEY_GPS_TIMESTAMP = "gps-timestamp";
        private static final String KEY_HORIZONTAL_VIEW_ANGLE = "horizontal-view-angle";
        private static final String KEY_JPEG_QUALITY = "jpeg-quality";
        private static final String KEY_JPEG_THUMBNAIL_HEIGHT = "jpeg-thumbnail-height";
        private static final String KEY_JPEG_THUMBNAIL_QUALITY = "jpeg-thumbnail-quality";
        private static final String KEY_JPEG_THUMBNAIL_SIZE = "jpeg-thumbnail-size";
        private static final String KEY_JPEG_THUMBNAIL_WIDTH = "jpeg-thumbnail-width";
        private static final String KEY_MAX_EXPOSURE_COMPENSATION = "max-exposure-compensation";
        private static final String KEY_MAX_NUM_DETECTED_FACES_HW = "max-num-detected-faces-hw";
        private static final String KEY_MAX_NUM_DETECTED_FACES_SW = "max-num-detected-faces-sw";
        private static final String KEY_MAX_NUM_FOCUS_AREAS = "max-num-focus-areas";
        private static final String KEY_MAX_NUM_METERING_AREAS = "max-num-metering-areas";
        private static final String KEY_MAX_ZOOM = "max-zoom";
        private static final String KEY_METERING_AREAS = "metering-areas";
        private static final String KEY_MIN_EXPOSURE_COMPENSATION = "min-exposure-compensation";
        private static final String KEY_PICTURE_FORMAT = "picture-format";
        private static final String KEY_PICTURE_SIZE = "picture-size";
        private static final String KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO = "preferred-preview-size-for-video";
        private static final String KEY_PREVIEW_FORMAT = "preview-format";
        private static final String KEY_PREVIEW_FPS_RANGE = "preview-fps-range";
        private static final String KEY_PREVIEW_FRAME_RATE = "preview-frame-rate";
        private static final String KEY_PREVIEW_SIZE = "preview-size";
        public static final String KEY_QC_AE_BRACKET_HDR = "ae-bracket-hdr";
        private static final String KEY_QC_AUTO_EXPOSURE = "auto-exposure";
        private static final String KEY_QC_AUTO_HDR_ENABLE = "auto-hdr-enable";
        private static final String KEY_QC_CAMERA_MODE = "camera-mode";
        private static final String KEY_QC_CONTINUOUS_AF = "continuous-af";
        private static final String KEY_QC_CONTRAST = "contrast";
        private static final String KEY_QC_DENOISE = "denoise";
        private static final String KEY_QC_EXIF_DATETIME = "exif-datetime";
        private static final String KEY_QC_EXPOSURE_TIME = "exposure-time";
        private static final String KEY_QC_FACE_DETECTION = "face-detection";
        private static final String KEY_QC_GPS_ALTITUDE_REF = "gps-altitude-ref";
        private static final String KEY_QC_GPS_LATITUDE_REF = "gps-latitude-ref";
        private static final String KEY_QC_GPS_LONGITUDE_REF = "gps-longitude-ref";
        private static final String KEY_QC_GPS_STATUS = "gps-status";
        private static final String KEY_QC_HFR_SIZE = "hfr-size";
        private static final String KEY_QC_HISTOGRAM = "histogram";
        private static final String KEY_QC_ISO_MODE = "iso";
        private static final String KEY_QC_LENSSHADE = "lensshade";
        private static final String KEY_QC_MANUAL_FOCUS_POSITION = "manual-focus-position";
        private static final String KEY_QC_MANUAL_FOCUS_POS_TYPE = "manual-focus-pos-type";
        private static final String KEY_QC_MAX_CONTRAST = "max-contrast";
        private static final String KEY_QC_MAX_EXPOSURE_TIME = "max-exposure-time";
        private static final String KEY_QC_MAX_SATURATION = "max-saturation";
        private static final String KEY_QC_MAX_SHARPNESS = "max-sharpness";
        private static final String KEY_QC_MAX_WB_CCT = "max-wb-cct";
        private static final String KEY_QC_MEMORY_COLOR_ENHANCEMENT = "mce";
        private static final String KEY_QC_MIN_EXPOSURE_TIME = "min-exposure-time";
        private static final String KEY_QC_MIN_WB_CCT = "min-wb-cct";
        private static final String KEY_QC_POWER_MODE = "power-mode";
        private static final String KEY_QC_POWER_MODE_SUPPORTED = "power-mode-supported";
        private static final String KEY_QC_PREVIEW_FRAME_RATE_AUTO_MODE = "frame-rate-auto";
        private static final String KEY_QC_PREVIEW_FRAME_RATE_FIXED_MODE = "frame-rate-fixed";
        private static final String KEY_QC_PREVIEW_FRAME_RATE_MODE = "preview-frame-rate-mode";
        private static final String KEY_QC_REDEYE_REDUCTION = "redeye-reduction";
        private static final String KEY_QC_SATURATION = "saturation";
        private static final String KEY_QC_SCENE_DETECT = "scene-detect";
        private static final String KEY_QC_SELECTABLE_ZONE_AF = "selectable-zone-af";
        private static final String KEY_QC_SHARPNESS = "sharpness";
        private static final String KEY_QC_SKIN_TONE_ENHANCEMENT = "skinToneEnhancement";
        private static final String KEY_QC_TOUCH_AF_AEC = "touch-af-aec";
        private static final String KEY_QC_TOUCH_INDEX_AEC = "touch-index-aec";
        private static final String KEY_QC_TOUCH_INDEX_AF = "touch-index-af";
        private static final String KEY_QC_VIDEO_HDR = "video-hdr";
        private static final String KEY_QC_VIDEO_HIGH_FRAME_RATE = "video-hfr";
        private static final String KEY_QC_VIDEO_ROTATION = "video-rotation";
        private static final String KEY_QC_WB_MANUAL_CCT = "wb-manual-cct";
        private static final String KEY_QC_ZSL = "zsl";
        private static final String KEY_RECORDING_HINT = "recording-hint";
        private static final String KEY_ROTATION = "rotation";
        private static final String KEY_SCENE_MODE = "scene-mode";
        private static final String KEY_SMOOTH_ZOOM_SUPPORTED = "smooth-zoom-supported";
        private static final String KEY_VERTICAL_VIEW_ANGLE = "vertical-view-angle";
        private static final String KEY_VIDEO_SIZE = "video-size";
        private static final String KEY_VIDEO_SNAPSHOT_SUPPORTED = "video-snapshot-supported";
        private static final String KEY_VIDEO_STABILIZATION = "video-stabilization";
        private static final String KEY_VIDEO_STABILIZATION_SUPPORTED = "video-stabilization-supported";
        private static final String KEY_WHITE_BALANCE = "whitebalance";
        private static final String KEY_ZOOM = "zoom";
        private static final String KEY_ZOOM_RATIOS = "zoom-ratios";
        private static final String KEY_ZOOM_SUPPORTED = "zoom-supported";
        public static final String LENSSHADE_DISABLE = "disable";
        public static final String LENSSHADE_ENABLE = "enable";
        public static final String LOW_POWER = "Low_Power";
        private static final int MANUAL_FOCUS_POS_TYPE_DAC = 1;
        private static final int MANUAL_FOCUS_POS_TYPE_INDEX = 0;
        public static final String MCE_DISABLE = "disable";
        public static final String MCE_ENABLE = "enable";
        public static final String NORMAL_POWER = "Normal_Power";
        private static final String PIXEL_FORMAT_BAYER_RGGB = "bayer-rggb";
        private static final String PIXEL_FORMAT_JPEG = "jpeg";
        private static final String PIXEL_FORMAT_NV12 = "nv12";
        private static final String PIXEL_FORMAT_RAW = "raw";
        private static final String PIXEL_FORMAT_RGB565 = "rgb565";
        private static final String PIXEL_FORMAT_YUV420P = "yuv420p";
        private static final String PIXEL_FORMAT_YUV420SP = "yuv420sp";
        private static final String PIXEL_FORMAT_YUV420SP_ADRENO = "yuv420sp-adreno";
        private static final String PIXEL_FORMAT_YUV422I = "yuv422i-yuyv";
        private static final String PIXEL_FORMAT_YUV422SP = "yuv422sp";
        private static final String PIXEL_FORMAT_YV12 = "yv12";
        public static final int PREVIEW_FPS_MAX_INDEX = 1;
        public static final int PREVIEW_FPS_MIN_INDEX = 0;
        public static final String REDEYE_REDUCTION_DISABLE = "disable";
        public static final String REDEYE_REDUCTION_ENABLE = "enable";
        public static final String SCENE_DETECT_OFF = "off";
        public static final String SCENE_DETECT_ON = "on";
        public static final String SCENE_MODE_ACTION = "action";
        public static final String SCENE_MODE_ASD = "asd";
        public static final String SCENE_MODE_AUTO = "auto";
        public static final String SCENE_MODE_BACKLIGHT = "backlight";
        public static final String SCENE_MODE_BARCODE = "barcode";
        public static final String SCENE_MODE_BEACH = "beach";
        public static final String SCENE_MODE_CANDLELIGHT = "candlelight";
        public static final String SCENE_MODE_FIREWORKS = "fireworks";
        public static final String SCENE_MODE_FLOWERS = "flowers";
        public static final String SCENE_MODE_HDR = "hdr";
        public static final String SCENE_MODE_LANDSCAPE = "landscape";
        public static final String SCENE_MODE_NIGHT = "night";
        public static final String SCENE_MODE_NIGHT_PORTRAIT = "night-portrait";
        public static final String SCENE_MODE_PARTY = "party";
        public static final String SCENE_MODE_PORTRAIT = "portrait";
        public static final String SCENE_MODE_SNOW = "snow";
        public static final String SCENE_MODE_SPORTS = "sports";
        public static final String SCENE_MODE_STEADYPHOTO = "steadyphoto";
        public static final String SCENE_MODE_SUNSET = "sunset";
        public static final String SCENE_MODE_THEATRE = "theatre";
        public static final String SELECTABLE_ZONE_AF_AUTO = "auto";
        public static final String SELECTABLE_ZONE_AF_CENTER_WEIGHTED = "center-weighted";
        public static final String SELECTABLE_ZONE_AF_FRAME_AVERAGE = "frame-average";
        public static final String SELECTABLE_ZONE_AF_SPOTMETERING = "spot-metering";
        public static final String SKIN_TONE_ENHANCEMENT_DISABLE = "disable";
        public static final String SKIN_TONE_ENHANCEMENT_ENABLE = "enable";
        private static final String SUPPORTED_VALUES_SUFFIX = "-values";
        public static final String TOUCH_AF_AEC_OFF = "touch-off";
        public static final String TOUCH_AF_AEC_ON = "touch-on";
        private static final String TRUE = "true";
        public static final String VIDEO_HFR_2X = "60";
        public static final String VIDEO_HFR_3X = "90";
        public static final String VIDEO_HFR_4X = "120";
        public static final String VIDEO_HFR_OFF = "off";
        public static final String VIDEO_ROTATION_0 = "0";
        public static final String VIDEO_ROTATION_180 = "180";
        public static final String VIDEO_ROTATION_270 = "270";
        public static final String VIDEO_ROTATION_90 = "90";
        public static final String WHITE_BALANCE_AUTO = "auto";
        public static final String WHITE_BALANCE_CLOUDY_DAYLIGHT = "cloudy-daylight";
        public static final String WHITE_BALANCE_DAYLIGHT = "daylight";
        public static final String WHITE_BALANCE_FLUORESCENT = "fluorescent";
        public static final String WHITE_BALANCE_INCANDESCENT = "incandescent";
        public static final String WHITE_BALANCE_MANUAL_CCT = "manual-cct";
        public static final String WHITE_BALANCE_SHADE = "shade";
        public static final String WHITE_BALANCE_TWILIGHT = "twilight";
        public static final String WHITE_BALANCE_WARM_FLUORESCENT = "warm-fluorescent";
        public static final String ZSL_OFF = "off";
        public static final String ZSL_ON = "on";
        private final LinkedHashMap<String, String> mMap;

        private Parameters() {
            this.mMap = new LinkedHashMap<>(64);
        }

        private String cameraFormatForPixelFormat(int i) {
            switch (i) {
                case 4:
                    return PIXEL_FORMAT_RGB565;
                case 16:
                    return PIXEL_FORMAT_YUV422SP;
                case 17:
                    return PIXEL_FORMAT_YUV420SP;
                case 20:
                    return PIXEL_FORMAT_YUV422I;
                case 256:
                    return PIXEL_FORMAT_JPEG;
                case ImageFormat.YV12 /* 842094169 */:
                    return PIXEL_FORMAT_YUV420P;
                default:
                    return null;
            }
        }

        private float getFloat(String str, float f) {
            try {
                return Float.parseFloat(this.mMap.get(str));
            } catch (NumberFormatException e) {
                return f;
            }
        }

        private int getInt(String str, int i) {
            try {
                return Integer.parseInt(this.mMap.get(str));
            } catch (NumberFormatException e) {
                return i;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Camera getOuter() {
            return Camera.this;
        }

        private int pixelFormatForCameraFormat(String str) {
            if (str == null) {
                return 0;
            }
            if (str.equals(PIXEL_FORMAT_YUV422SP)) {
                return 16;
            }
            if (str.equals(PIXEL_FORMAT_YUV420SP)) {
                return 17;
            }
            if (str.equals(PIXEL_FORMAT_YUV422I)) {
                return 20;
            }
            if (str.equals(PIXEL_FORMAT_YUV420P)) {
                return ImageFormat.YV12;
            }
            if (str.equals(PIXEL_FORMAT_RGB565)) {
                return 4;
            }
            return str.equals(PIXEL_FORMAT_JPEG) ? 256 : 0;
        }

        private void put(String str, String str2) {
            this.mMap.remove(str);
            this.mMap.put(str, str2);
        }

        private boolean same(String str, String str2) {
            if (str == null && str2 == null) {
                return true;
            }
            return str != null && str.equals(str2);
        }

        private void set(String str, List<Area> list) {
            if (list == null) {
                set(str, "(0,0,0,0,0)");
                return;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    set(str, sb.toString());
                    return;
                }
                Area area = list.get(i2);
                Rect rect = area.rect;
                sb.append('(');
                sb.append(rect.left);
                sb.append(',');
                sb.append(rect.top);
                sb.append(',');
                sb.append(rect.right);
                sb.append(',');
                sb.append(rect.bottom);
                sb.append(',');
                sb.append(area.weight);
                sb.append(')');
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
                i = i2 + 1;
            }
        }

        private ArrayList<String> split(String str) {
            ArrayList<String> arrayList;
            if (str != null) {
                TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(',');
                simpleStringSplitter.setString(str);
                ArrayList<String> arrayList2 = new ArrayList<>();
                Iterator<String> it = simpleStringSplitter.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    arrayList2.add(it.next());
                }
            } else {
                arrayList = null;
            }
            return arrayList;
        }

        private ArrayList<Area> splitArea(String str) {
            ArrayList<Area> arrayList;
            int i;
            if (str == null || str.isEmpty() || str.charAt(0) != '(' || str.charAt(str.length() - 1) != ')') {
                Log.e(Camera.TAG, "Invalid area string=" + str);
                arrayList = null;
            } else {
                ArrayList<Area> arrayList2 = new ArrayList<>();
                int i2 = 1;
                int[] iArr = new int[5];
                do {
                    int indexOf = str.indexOf("),(", i2);
                    i = indexOf;
                    if (indexOf == -1) {
                        i = str.length() - 1;
                    }
                    splitInt(str.substring(i2, i), iArr);
                    arrayList2.add(new Area(new Rect(iArr[0], iArr[1], iArr[2], iArr[3]), iArr[4]));
                    i2 = i + 3;
                } while (i != str.length() - 1);
                if (arrayList2.size() == 0) {
                    return null;
                }
                arrayList = arrayList2;
                if (arrayList2.size() == 1) {
                    Area area = arrayList2.get(0);
                    Rect rect = area.rect;
                    arrayList = arrayList2;
                    if (rect.left == 0) {
                        arrayList = arrayList2;
                        if (rect.top == 0) {
                            arrayList = arrayList2;
                            if (rect.right == 0) {
                                arrayList = arrayList2;
                                if (rect.bottom == 0) {
                                    arrayList = arrayList2;
                                    if (area.weight == 0) {
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }

        private ArrayList<Coordinate> splitCoordinate(String str) {
            ArrayList<Coordinate> arrayList;
            if (str == null) {
                arrayList = null;
            } else {
                TextUtils.SimpleStringSplitter<String> simpleStringSplitter = new TextUtils.SimpleStringSplitter(',');
                simpleStringSplitter.setString(str);
                ArrayList<Coordinate> arrayList2 = new ArrayList<>();
                for (String str2 : simpleStringSplitter) {
                    Coordinate strToCoordinate = strToCoordinate(str2);
                    if (strToCoordinate != null) {
                        arrayList2.add(strToCoordinate);
                    }
                }
                arrayList = arrayList2;
                if (arrayList2.size() == 0) {
                    return null;
                }
            }
            return arrayList;
        }

        private void splitFloat(String str, float[] fArr) {
            if (str == null) {
                return;
            }
            TextUtils.SimpleStringSplitter<String> simpleStringSplitter = new TextUtils.SimpleStringSplitter(',');
            simpleStringSplitter.setString(str);
            int i = 0;
            for (String str2 : simpleStringSplitter) {
                fArr[i] = Float.parseFloat(str2);
                i++;
            }
        }

        private ArrayList<Integer> splitInt(String str) {
            ArrayList<Integer> arrayList;
            if (str == null) {
                arrayList = null;
            } else {
                TextUtils.SimpleStringSplitter<String> simpleStringSplitter = new TextUtils.SimpleStringSplitter(',');
                simpleStringSplitter.setString(str);
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (String str2 : simpleStringSplitter) {
                    arrayList2.add(Integer.valueOf(Integer.parseInt(str2)));
                }
                arrayList = arrayList2;
                if (arrayList2.size() == 0) {
                    return null;
                }
            }
            return arrayList;
        }

        private void splitInt(String str, int[] iArr) {
            if (str == null) {
                return;
            }
            TextUtils.SimpleStringSplitter<String> simpleStringSplitter = new TextUtils.SimpleStringSplitter(',');
            simpleStringSplitter.setString(str);
            int i = 0;
            for (String str2 : simpleStringSplitter) {
                iArr[i] = Integer.parseInt(str2.replaceAll("\\s", ""));
                i++;
            }
        }

        private ArrayList<int[]> splitRange(String str) {
            ArrayList<int[]> arrayList;
            int i;
            if (str == null || str.isEmpty() || str.charAt(0) != '(' || str.charAt(str.length() - 1) != ')') {
                Log.e(Camera.TAG, "Invalid range list string=" + str);
                arrayList = null;
            } else {
                ArrayList<int[]> arrayList2 = new ArrayList<>();
                int i2 = 1;
                do {
                    int[] iArr = new int[2];
                    int indexOf = str.indexOf("),(", i2);
                    i = indexOf;
                    if (indexOf == -1) {
                        i = str.length() - 1;
                    }
                    splitInt(str.substring(i2, i), iArr);
                    arrayList2.add(iArr);
                    i2 = i + 3;
                } while (i != str.length() - 1);
                arrayList = arrayList2;
                if (arrayList2.size() == 0) {
                    return null;
                }
            }
            return arrayList;
        }

        private ArrayList<Size> splitSize(String str) {
            ArrayList<Size> arrayList;
            if (str == null) {
                arrayList = null;
            } else {
                TextUtils.SimpleStringSplitter<String> simpleStringSplitter = new TextUtils.SimpleStringSplitter(',');
                simpleStringSplitter.setString(str);
                ArrayList<Size> arrayList2 = new ArrayList<>();
                for (String str2 : simpleStringSplitter) {
                    Size strToSize = strToSize(str2);
                    if (strToSize != null) {
                        arrayList2.add(strToSize);
                    }
                }
                arrayList = arrayList2;
                if (arrayList2.size() == 0) {
                    return null;
                }
            }
            return arrayList;
        }

        private Coordinate strToCoordinate(String str) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(120);
            if (indexOf == -1) {
                Log.e(Camera.TAG, "Invalid Coordinate parameter string=" + str);
                return null;
            }
            return new Coordinate(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        }

        private Size strToSize(String str) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(120);
            if (indexOf == -1) {
                Log.e(Camera.TAG, "Invalid size parameter string=" + str);
                return null;
            }
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        }

        public void copyFrom(Parameters parameters) {
            if (parameters == null) {
                throw new NullPointerException("other must not be null");
            }
            this.mMap.putAll(parameters.mMap);
        }

        @Deprecated
        public void dump() {
            Log.e(Camera.TAG, "dump: size=" + this.mMap.size());
            for (String str : this.mMap.keySet()) {
                Log.e(Camera.TAG, "dump: " + str + "=" + this.mMap.get(str));
            }
        }

        public String flatten() {
            StringBuilder sb = new StringBuilder(128);
            for (String str : this.mMap.keySet()) {
                sb.append(str);
                sb.append("=");
                sb.append(this.mMap.get(str));
                sb.append(";");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        public String get(String str) {
            return this.mMap.get(str);
        }

        public String getAEBracket() {
            return get(KEY_QC_AE_BRACKET_HDR);
        }

        public String getAntibanding() {
            return get(KEY_ANTIBANDING);
        }

        public String getAutoExposure() {
            return get(KEY_QC_AUTO_EXPOSURE);
        }

        public boolean getAutoExposureLock() {
            return "true".equals(get(KEY_AUTO_EXPOSURE_LOCK));
        }

        public boolean getAutoWhiteBalanceLock() {
            return "true".equals(get(KEY_AUTO_WHITEBALANCE_LOCK));
        }

        public String getCameraMode() {
            return get(KEY_QC_CAMERA_MODE);
        }

        public String getColorEffect() {
            return get(KEY_EFFECT);
        }

        public String getContinuousAf() {
            return get(KEY_QC_CONTINUOUS_AF);
        }

        public int getContrast() {
            return getInt(KEY_QC_CONTRAST);
        }

        public String getCurrentFocusPosition() {
            return get(KEY_QC_MANUAL_FOCUS_POSITION);
        }

        public String getDenoise() {
            return get(KEY_QC_DENOISE);
        }

        public int getExposureCompensation() {
            return getInt(KEY_EXPOSURE_COMPENSATION, 0);
        }

        public float getExposureCompensationStep() {
            return getFloat(KEY_EXPOSURE_COMPENSATION_STEP, 0.0f);
        }

        public String getExposureTime() {
            return get(KEY_QC_EXPOSURE_TIME);
        }

        public String getFaceDetectionMode() {
            return get(KEY_QC_FACE_DETECTION);
        }

        public String getFlashMode() {
            return get(KEY_FLASH_MODE);
        }

        public float getFocalLength() {
            return Float.parseFloat(get(KEY_FOCAL_LENGTH));
        }

        public List<Area> getFocusAreas() {
            return splitArea(get(KEY_FOCUS_AREAS));
        }

        public void getFocusDistances(float[] fArr) {
            if (fArr == null || fArr.length != 3) {
                throw new IllegalArgumentException("output must be a float array with three elements.");
            }
            splitFloat(get(KEY_FOCUS_DISTANCES), fArr);
        }

        public String getFocusMode() {
            return get(KEY_FOCUS_MODE);
        }

        public float getHorizontalViewAngle() {
            return Float.parseFloat(get(KEY_HORIZONTAL_VIEW_ANGLE));
        }

        public String getISOValue() {
            return get(KEY_QC_ISO_MODE);
        }

        public int getInt(String str) {
            return Integer.parseInt(this.mMap.get(str));
        }

        public int getJpegQuality() {
            return getInt(KEY_JPEG_QUALITY);
        }

        public int getJpegThumbnailQuality() {
            return getInt(KEY_JPEG_THUMBNAIL_QUALITY);
        }

        public Size getJpegThumbnailSize() {
            return new Size(getInt(KEY_JPEG_THUMBNAIL_WIDTH), getInt(KEY_JPEG_THUMBNAIL_HEIGHT));
        }

        public String getLensShade() {
            return get(KEY_QC_LENSSHADE);
        }

        public int getMaxContrast() {
            return getInt(KEY_QC_MAX_CONTRAST);
        }

        public int getMaxExposureCompensation() {
            return getInt(KEY_MAX_EXPOSURE_COMPENSATION, 0);
        }

        public String getMaxExposureTime() {
            return get(KEY_QC_MAX_EXPOSURE_TIME);
        }

        public int getMaxNumDetectedFaces() {
            return getInt(KEY_MAX_NUM_DETECTED_FACES_HW, 0);
        }

        public int getMaxNumFocusAreas() {
            return getInt(KEY_MAX_NUM_FOCUS_AREAS, 0);
        }

        public int getMaxNumMeteringAreas() {
            return getInt(KEY_MAX_NUM_METERING_AREAS, 0);
        }

        public int getMaxSaturation() {
            return getInt(KEY_QC_MAX_SATURATION);
        }

        public int getMaxSharpness() {
            return getInt(KEY_QC_MAX_SHARPNESS);
        }

        public String getMaxWBCCT() {
            return get(KEY_QC_MAX_WB_CCT);
        }

        public int getMaxZoom() {
            return getInt(KEY_MAX_ZOOM, 0);
        }

        public String getMemColorEnhance() {
            return get(KEY_QC_MEMORY_COLOR_ENHANCEMENT);
        }

        public List<Area> getMeteringAreas() {
            return splitArea(get(KEY_METERING_AREAS));
        }

        public int getMinExposureCompensation() {
            return getInt(KEY_MIN_EXPOSURE_COMPENSATION, 0);
        }

        public String getMinExposureTime() {
            return get(KEY_QC_MIN_EXPOSURE_TIME);
        }

        public int getPictureFormat() {
            return pixelFormatForCameraFormat(get(KEY_PICTURE_FORMAT));
        }

        public Size getPictureSize() {
            return strToSize(get(KEY_PICTURE_SIZE));
        }

        public String getPowerMode() {
            return get(KEY_QC_POWER_MODE);
        }

        public Size getPreferredPreviewSizeForVideo() {
            return strToSize(get(KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO));
        }

        public int getPreviewFormat() {
            return pixelFormatForCameraFormat(get(KEY_PREVIEW_FORMAT));
        }

        public void getPreviewFpsRange(int[] iArr) {
            if (iArr == null || iArr.length != 2) {
                throw new IllegalArgumentException("range must be an array with two elements.");
            }
            splitInt(get(KEY_PREVIEW_FPS_RANGE), iArr);
        }

        @Deprecated
        public int getPreviewFrameRate() {
            return getInt(KEY_PREVIEW_FRAME_RATE);
        }

        public String getPreviewFrameRateMode() {
            return get(KEY_QC_PREVIEW_FRAME_RATE_MODE);
        }

        public Size getPreviewSize() {
            return strToSize(get(KEY_PREVIEW_SIZE));
        }

        public String getRedeyeReductionMode() {
            return get(KEY_QC_REDEYE_REDUCTION);
        }

        public int getSaturation() {
            return getInt(KEY_QC_SATURATION);
        }

        public String getSceneDetectMode() {
            return get(KEY_QC_SCENE_DETECT);
        }

        public String getSceneMode() {
            return get(KEY_SCENE_MODE);
        }

        public String getSelectableZoneAf() {
            return get(KEY_QC_SELECTABLE_ZONE_AF);
        }

        public int getSharpness() {
            return getInt(KEY_QC_SHARPNESS);
        }

        public List<String> getSupportedAntibanding() {
            return split(get("antibanding-values"));
        }

        public List<String> getSupportedAutoexposure() {
            return split(get("auto-exposure-values"));
        }

        public List<String> getSupportedColorEffects() {
            return split(get("effect-values"));
        }

        public List<String> getSupportedContinuousAfModes() {
            return split(get("continuous-af-values"));
        }

        public List<String> getSupportedDenoiseModes() {
            return split(get("denoise-values"));
        }

        public List<String> getSupportedFaceDetectionModes() {
            return split(get("face-detection-values"));
        }

        public List<String> getSupportedFlashModes() {
            return split(get("flash-mode-values"));
        }

        public List<String> getSupportedFocusModes() {
            return split(get("focus-mode-values"));
        }

        public List<Size> getSupportedHfrSizes() {
            return splitSize(get("hfr-size-values"));
        }

        public List<String> getSupportedHistogramModes() {
            return split(get("histogram-values"));
        }

        public List<String> getSupportedIsoValues() {
            return split(get("iso-values"));
        }

        public List<Size> getSupportedJpegThumbnailSizes() {
            return splitSize(get("jpeg-thumbnail-size-values"));
        }

        public List<String> getSupportedLensShadeModes() {
            return split(get("lensshade-values"));
        }

        public List<String> getSupportedMemColorEnhanceModes() {
            return split(get("mce-values"));
        }

        public List<Integer> getSupportedPictureFormats() {
            String str = get("picture-format-values");
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = split(str).iterator();
            while (it.hasNext()) {
                int pixelFormatForCameraFormat = pixelFormatForCameraFormat(it.next());
                if (pixelFormatForCameraFormat != 0) {
                    arrayList.add(Integer.valueOf(pixelFormatForCameraFormat));
                }
            }
            return arrayList;
        }

        public List<Size> getSupportedPictureSizes() {
            return splitSize(get("picture-size-values"));
        }

        public List<Integer> getSupportedPreviewFormats() {
            String str = get("preview-format-values");
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = split(str).iterator();
            while (it.hasNext()) {
                int pixelFormatForCameraFormat = pixelFormatForCameraFormat(it.next());
                if (pixelFormatForCameraFormat != 0) {
                    arrayList.add(Integer.valueOf(pixelFormatForCameraFormat));
                }
            }
            return arrayList;
        }

        public List<int[]> getSupportedPreviewFpsRange() {
            return splitRange(get("preview-fps-range-values"));
        }

        public List<String> getSupportedPreviewFrameRateModes() {
            return split(get("preview-frame-rate-mode-values"));
        }

        @Deprecated
        public List<Integer> getSupportedPreviewFrameRates() {
            return splitInt(get("preview-frame-rate-values"));
        }

        public List<Size> getSupportedPreviewSizes() {
            return splitSize(get("preview-size-values"));
        }

        public List<String> getSupportedRedeyeReductionModes() {
            return split(get("redeye-reduction-values"));
        }

        public List<String> getSupportedSceneDetectModes() {
            return split(get("scene-detect-values"));
        }

        public List<String> getSupportedSceneModes() {
            return split(get("scene-mode-values"));
        }

        public List<String> getSupportedSelectableZoneAf() {
            return split(get("selectable-zone-af-values"));
        }

        public List<String> getSupportedSkinToneEnhancementModes() {
            return split(get("skinToneEnhancement-values"));
        }

        public List<String> getSupportedTouchAfAec() {
            return split(get("touch-af-aec-values"));
        }

        public List<String> getSupportedVideoHDRModes() {
            return split(get("video-hdr-values"));
        }

        public List<String> getSupportedVideoHighFrameRateModes() {
            return split(get("video-hfr-values"));
        }

        public List<String> getSupportedVideoRotationValues() {
            return split(get("video-rotation-values"));
        }

        public List<Size> getSupportedVideoSizes() {
            return splitSize(get("video-size-values"));
        }

        public List<String> getSupportedWhiteBalance() {
            return split(get("whitebalance-values"));
        }

        public List<String> getSupportedZSLModes() {
            return split(get("zsl-values"));
        }

        public String getTouchAfAec() {
            return get(KEY_QC_TOUCH_AF_AEC);
        }

        public Coordinate getTouchIndexAec() {
            return strToCoordinate(get(KEY_QC_TOUCH_INDEX_AEC));
        }

        public Coordinate getTouchIndexAf() {
            return strToCoordinate(get(KEY_QC_TOUCH_INDEX_AF));
        }

        public float getVerticalViewAngle() {
            return Float.parseFloat(get(KEY_VERTICAL_VIEW_ANGLE));
        }

        public String getVideoHDRMode() {
            return get(KEY_QC_VIDEO_HDR);
        }

        public String getVideoHighFrameRate() {
            return get(KEY_QC_VIDEO_HIGH_FRAME_RATE);
        }

        public String getVideoRotation() {
            return get(KEY_QC_VIDEO_ROTATION);
        }

        public boolean getVideoStabilization() {
            return "true".equals(get(KEY_VIDEO_STABILIZATION));
        }

        public String getWBCurrentCCT() {
            return get(KEY_QC_WB_MANUAL_CCT);
        }

        public String getWBMinCCT() {
            return get(KEY_QC_MIN_WB_CCT);
        }

        public String getWhiteBalance() {
            return get(KEY_WHITE_BALANCE);
        }

        public String getZSLMode() {
            return get(KEY_QC_ZSL);
        }

        public int getZoom() {
            return getInt(KEY_ZOOM, 0);
        }

        public List<Integer> getZoomRatios() {
            return splitInt(get(KEY_ZOOM_RATIOS));
        }

        public boolean isAutoExposureLockSupported() {
            return "true".equals(get(KEY_AUTO_EXPOSURE_LOCK_SUPPORTED));
        }

        public boolean isAutoWhiteBalanceLockSupported() {
            return "true".equals(get(KEY_AUTO_WHITEBALANCE_LOCK_SUPPORTED));
        }

        public boolean isPowerModeSupported() {
            return "true".equals(get(KEY_QC_POWER_MODE_SUPPORTED));
        }

        public boolean isSmoothZoomSupported() {
            return "true".equals(get(KEY_SMOOTH_ZOOM_SUPPORTED));
        }

        public boolean isVideoSnapshotSupported() {
            return "true".equals(get(KEY_VIDEO_SNAPSHOT_SUPPORTED));
        }

        public boolean isVideoStabilizationSupported() {
            return "true".equals(get(KEY_VIDEO_STABILIZATION_SUPPORTED));
        }

        public boolean isZoomSupported() {
            return "true".equals(get(KEY_ZOOM_SUPPORTED));
        }

        public void remove(String str) {
            this.mMap.remove(str);
        }

        public void removeGpsData() {
            remove(KEY_QC_GPS_LATITUDE_REF);
            remove(KEY_GPS_LATITUDE);
            remove(KEY_QC_GPS_LONGITUDE_REF);
            remove(KEY_GPS_LONGITUDE);
            remove(KEY_QC_GPS_ALTITUDE_REF);
            remove(KEY_GPS_ALTITUDE);
            remove(KEY_GPS_TIMESTAMP);
            remove(KEY_GPS_PROCESSING_METHOD);
        }

        public boolean same(Parameters parameters) {
            if (this == parameters) {
                return true;
            }
            return parameters != null && this.mMap.equals(parameters.mMap);
        }

        public void set(String str, int i) {
            put(str, Integer.toString(i));
        }

        public void set(String str, String str2) {
            if (str.indexOf(61) != -1 || str.indexOf(59) != -1 || str.indexOf(0) != -1) {
                Log.e(Camera.TAG, "Key \"" + str + "\" contains invalid character (= or ; or \\0)");
            } else if (str2.indexOf(61) == -1 && str2.indexOf(59) == -1 && str2.indexOf(0) == -1) {
                put(str, str2);
            } else {
                Log.e(Camera.TAG, "Value \"" + str2 + "\" contains invalid character (= or ; or \\0)");
            }
        }

        public void setAEBracket(String str) {
            set(KEY_QC_AE_BRACKET_HDR, str);
        }

        public void setAntibanding(String str) {
            set(KEY_ANTIBANDING, str);
        }

        public void setAutoExposure(String str) {
            set(KEY_QC_AUTO_EXPOSURE, str);
        }

        public void setAutoExposureLock(boolean z) {
            set(KEY_AUTO_EXPOSURE_LOCK, z ? "true" : "false");
        }

        public void setAutoHDRMode(String str) {
            set(KEY_QC_AUTO_HDR_ENABLE, str);
        }

        public void setAutoWhiteBalanceLock(boolean z) {
            set(KEY_AUTO_WHITEBALANCE_LOCK, z ? "true" : "false");
        }

        public void setCameraMode(int i) {
            set(KEY_QC_CAMERA_MODE, i);
        }

        public void setColorEffect(String str) {
            set(KEY_EFFECT, str);
        }

        public void setContinuousAf(String str) {
            set(KEY_QC_CONTINUOUS_AF, str);
        }

        public void setContrast(int i) {
            if (i < 0 || i > getMaxContrast()) {
                throw new IllegalArgumentException("Invalid Contrast " + i);
            }
            set(KEY_QC_CONTRAST, String.valueOf(i));
        }

        public void setDenoise(String str) {
            set(KEY_QC_DENOISE, str);
        }

        public void setExifDateTime(String str) {
            set(KEY_QC_EXIF_DATETIME, str);
        }

        public void setExposureCompensation(int i) {
            set(KEY_EXPOSURE_COMPENSATION, i);
        }

        public void setExposureTime(int i) {
            set(KEY_QC_EXPOSURE_TIME, Integer.toString(i));
        }

        public void setFaceDetectionMode(String str) {
            set(KEY_QC_FACE_DETECTION, str);
        }

        public void setFlashMode(String str) {
            set(KEY_FLASH_MODE, str);
        }

        public void setFocusAreas(List<Area> list) {
            set(KEY_FOCUS_AREAS, list);
        }

        public void setFocusMode(String str) {
            set(KEY_FOCUS_MODE, str);
        }

        public void setFocusPosition(int i, int i2) {
            set(KEY_QC_MANUAL_FOCUS_POS_TYPE, Integer.toString(i));
            set(KEY_QC_MANUAL_FOCUS_POSITION, Integer.toString(i2));
        }

        public void setGpsAltitude(double d) {
            set(KEY_GPS_ALTITUDE, Double.toString(d));
        }

        public void setGpsAltitudeRef(double d) {
            set(KEY_QC_GPS_ALTITUDE_REF, Double.toString(d));
        }

        public void setGpsLatitude(double d) {
            set(KEY_GPS_LATITUDE, Double.toString(d));
        }

        public void setGpsLatitudeRef(String str) {
            set(KEY_QC_GPS_LATITUDE_REF, str);
        }

        public void setGpsLongitude(double d) {
            set(KEY_GPS_LONGITUDE, Double.toString(d));
        }

        public void setGpsLongitudeRef(String str) {
            set(KEY_QC_GPS_LONGITUDE_REF, str);
        }

        public void setGpsProcessingMethod(String str) {
            set(KEY_GPS_PROCESSING_METHOD, str);
        }

        public void setGpsStatus(double d) {
            set(KEY_QC_GPS_STATUS, Double.toString(d));
        }

        public void setGpsTimestamp(long j) {
            set(KEY_GPS_TIMESTAMP, Long.toString(j));
        }

        public void setISOValue(String str) {
            set(KEY_QC_ISO_MODE, str);
        }

        public void setJpegQuality(int i) {
            set(KEY_JPEG_QUALITY, i);
        }

        public void setJpegThumbnailQuality(int i) {
            set(KEY_JPEG_THUMBNAIL_QUALITY, i);
        }

        public void setJpegThumbnailSize(int i, int i2) {
            set(KEY_JPEG_THUMBNAIL_WIDTH, i);
            set(KEY_JPEG_THUMBNAIL_HEIGHT, i2);
        }

        public void setLensShade(String str) {
            set(KEY_QC_LENSSHADE, str);
        }

        public void setMemColorEnhance(String str) {
            set(KEY_QC_MEMORY_COLOR_ENHANCEMENT, str);
        }

        public void setMeteringAreas(List<Area> list) {
            set(KEY_METERING_AREAS, list);
        }

        public void setPictureFormat(int i) {
            String cameraFormatForPixelFormat = cameraFormatForPixelFormat(i);
            if (cameraFormatForPixelFormat == null) {
                throw new IllegalArgumentException("Invalid pixel_format=" + i);
            }
            set(KEY_PICTURE_FORMAT, cameraFormatForPixelFormat);
        }

        public void setPictureSize(int i, int i2) {
            set(KEY_PICTURE_SIZE, Integer.toString(i) + "x" + Integer.toString(i2));
        }

        public void setPowerMode(String str) {
            set(KEY_QC_POWER_MODE, str);
        }

        public void setPreviewFormat(int i) {
            String cameraFormatForPixelFormat = cameraFormatForPixelFormat(i);
            if (cameraFormatForPixelFormat == null) {
                throw new IllegalArgumentException("Invalid pixel_format=" + i);
            }
            set(KEY_PREVIEW_FORMAT, cameraFormatForPixelFormat);
        }

        public void setPreviewFpsRange(int i, int i2) {
            set(KEY_PREVIEW_FPS_RANGE, "" + i + "," + i2);
        }

        @Deprecated
        public void setPreviewFrameRate(int i) {
            set(KEY_PREVIEW_FRAME_RATE, i);
        }

        public void setPreviewFrameRateMode(String str) {
            set(KEY_QC_PREVIEW_FRAME_RATE_MODE, str);
        }

        public void setPreviewSize(int i, int i2) {
            set(KEY_PREVIEW_SIZE, Integer.toString(i) + "x" + Integer.toString(i2));
        }

        public void setRecordingHint(boolean z) {
            set(KEY_RECORDING_HINT, z ? "true" : "false");
        }

        public void setRedeyeReductionMode(String str) {
            set(KEY_QC_REDEYE_REDUCTION, str);
        }

        public void setRotation(int i) {
            if (i != 0 && i != 90 && i != 180 && i != 270) {
                throw new IllegalArgumentException("Invalid rotation=" + i);
            }
            set("rotation", Integer.toString(i));
        }

        public void setSaturation(int i) {
            if (i < 0 || i > getMaxSaturation()) {
                throw new IllegalArgumentException("Invalid Saturation " + i);
            }
            set(KEY_QC_SATURATION, String.valueOf(i));
        }

        public void setSceneDetectMode(String str) {
            set(KEY_QC_SCENE_DETECT, str);
        }

        public void setSceneMode(String str) {
            set(KEY_SCENE_MODE, str);
        }

        public void setSelectableZoneAf(String str) {
            set(KEY_QC_SELECTABLE_ZONE_AF, str);
        }

        public void setSharpness(int i) {
            if (i < 0 || i > getMaxSharpness()) {
                throw new IllegalArgumentException("Invalid Sharpness " + i);
            }
            set(KEY_QC_SHARPNESS, String.valueOf(i));
        }

        public void setTouchAfAec(String str) {
            set(KEY_QC_TOUCH_AF_AEC, str);
        }

        public void setTouchIndexAec(int i, int i2) {
            set(KEY_QC_TOUCH_INDEX_AEC, Integer.toString(i) + "x" + Integer.toString(i2));
        }

        public void setTouchIndexAf(int i, int i2) {
            set(KEY_QC_TOUCH_INDEX_AF, Integer.toString(i) + "x" + Integer.toString(i2));
        }

        public void setVideoHDRMode(String str) {
            set(KEY_QC_VIDEO_HDR, str);
        }

        public void setVideoHighFrameRate(String str) {
            set(KEY_QC_VIDEO_HIGH_FRAME_RATE, str);
        }

        public void setVideoRotation(String str) {
            set(KEY_QC_VIDEO_ROTATION, str);
        }

        public void setVideoStabilization(boolean z) {
            set(KEY_VIDEO_STABILIZATION, z ? "true" : "false");
        }

        public void setWBManualCCT(int i) {
            set(KEY_QC_WB_MANUAL_CCT, Integer.toString(i));
        }

        public void setWhiteBalance(String str) {
            if (same(str, get(KEY_WHITE_BALANCE))) {
                return;
            }
            set(KEY_WHITE_BALANCE, str);
            set(KEY_AUTO_WHITEBALANCE_LOCK, "false");
        }

        public void setZSLMode(String str) {
            set(KEY_QC_ZSL, str);
        }

        public void setZoom(int i) {
            set(KEY_ZOOM, i);
        }

        public void unflatten(String str) {
            this.mMap.clear();
            TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(';');
            simpleStringSplitter.setString(str);
            for (String str2 : simpleStringSplitter) {
                int indexOf = str2.indexOf(61);
                if (indexOf != -1) {
                    this.mMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                }
            }
        }
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$PictureCallback.class */
    public interface PictureCallback {
        void onPictureTaken(byte[] bArr, Camera camera);
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$PreviewCallback.class */
    public interface PreviewCallback {
        void onPreviewFrame(byte[] bArr, Camera camera);
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$ShutterCallback.class */
    public interface ShutterCallback {
        void onShutter();
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/Camera$Size.class */
    public class Size {
        public int height;
        public int width;

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Size) {
                Size size = (Size) obj;
                return this.width == size.width && this.height == size.height;
            }
            return false;
        }

        public int hashCode() {
            return (this.width * 32713) + this.height;
        }
    }

    Camera() {
    }

    Camera(int i) {
        int cameraInitNormal = cameraInitNormal(i);
        if (checkInitErrors(cameraInitNormal)) {
            switch (cameraInitNormal) {
                case -19:
                    throw new RuntimeException("Camera initialization failed");
                case -13:
                    throw new RuntimeException("Fail to connect to camera service");
                default:
                    throw new RuntimeException("Unknown camera error");
            }
        }
    }

    private Camera(int i, int i2) {
        int cameraInitVersion = cameraInitVersion(i, i2);
        if (checkInitErrors(cameraInitVersion)) {
            switch (cameraInitVersion) {
                case -95:
                    throw new RuntimeException("Camera initialization failed because the hal version is not supported by this device");
                case -87:
                    throw new RuntimeException("Camera initialization failed because the max number of camera devices were already opened");
                case -38:
                    throw new RuntimeException("Camera initialization failed because some methods are not implemented");
                case -22:
                    throw new RuntimeException("Camera initialization failed because the input arugments are invalid");
                case -19:
                    throw new RuntimeException("Camera initialization failed");
                case -16:
                    throw new RuntimeException("Camera initialization failed because the camera device was already opened");
                case -13:
                    throw new RuntimeException("Fail to connect to camera service");
                default:
                    throw new RuntimeException("Unknown camera error");
            }
        }
    }

    private final native void _addCallbackBuffer(byte[] bArr, int i);

    private final native boolean _enableShutterSound(boolean z);

    private static native void _getCameraInfo(int i, CameraInfo cameraInfo);

    private final native void _sendVendorCommand(int i, int i2, int i3);

    private final native void _startFaceDetection(int i);

    private final native void _stopFaceDetection();

    private final native void _stopPreview();

    private final void addCallbackBuffer(byte[] bArr, int i) {
        if (i != 16 && i != 128) {
            throw new IllegalArgumentException("Unsupported message type: " + i);
        }
        _addCallbackBuffer(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int byteToInt(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 4) {
                return i2;
            }
            i2 += (bArr[(3 - i4) + i] & 255) << ((3 - i4) * 8);
            i3 = i4 + 1;
        }
    }

    private int cameraInitNormal(int i) {
        return cameraInitVersion(i, -2);
    }

    private int cameraInitVersion(int i, int i2) {
        this.mCameraId = i;
        this.mShutterCallback = null;
        this.mRawImageCallback = null;
        this.mJpegCallback = null;
        this.mPreviewCallback = null;
        this.mPostviewCallback = null;
        this.mUsingPreviewAllocation = false;
        this.mZoomListener = null;
        this.mCameraDataCallback = null;
        this.mCameraMetaDataCallback = null;
        this.mTorchToken = new Binder();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        String currentPackageName = ActivityThread.currentPackageName();
        String str = currentPackageName;
        if (currentPackageName == null) {
            str = currentPackageName;
            if (1000 == Binder.getCallingUid()) {
                str = "android";
            }
        }
        notifyTorch(true);
        return native_setup(new WeakReference(this), i, i2, str);
    }

    public static boolean checkInitErrors(int i) {
        return i != 0;
    }

    private native void enableFocusMoveCallback(int i);

    public static void getCameraInfo(int i, CameraInfo cameraInfo) {
        _getCameraInfo(i, cameraInfo);
        try {
            if (IAudioService.Stub.asInterface(ServiceManager.getService("audio")).isCameraSoundForced()) {
                cameraInfo.canDisableShutterSound = false;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Audio service is unavailable for queries");
        }
    }

    public static Parameters getEmptyParameters() {
        Camera camera = new Camera();
        camera.getClass();
        return new Parameters();
    }

    public static native int getNumberOfCameras();

    public static Parameters getParametersCopy(Parameters parameters) {
        if (parameters == null) {
            throw new NullPointerException("parameters must not be null");
        }
        Camera outer = parameters.getOuter();
        outer.getClass();
        Parameters parameters2 = new Parameters();
        parameters2.copyFrom(parameters);
        return parameters2;
    }

    private final native void native_autoFocus();

    private final native void native_cancelAutoFocus();

    private final native String native_getParameters();

    private final native void native_release();

    private final native void native_sendHistogramData();

    private final native void native_sendMetaData();

    private final native void native_setHistogramMode(boolean z);

    private final native void native_setLongshot(boolean z);

    private final native void native_setMetadataCb(boolean z);

    private final native void native_setParameters(String str);

    private final native int native_setup(Object obj, int i, int i2, String str);

    private final native void native_stopLongshot();

    private final native void native_takePicture(int i);

    private void notifyTorch(boolean z) {
        ITorchService asInterface = ITorchService.Stub.asInterface(ServiceManager.getService("torch"));
        if (asInterface != null) {
            try {
                if (z) {
                    asInterface.onCameraOpened(this.mTorchToken, this.mCameraId);
                } else {
                    asInterface.onCameraClosed(this.mTorchToken, this.mCameraId);
                }
            } catch (RemoteException e) {
            }
        }
    }

    public static Camera open() {
        int numberOfCameras = getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numberOfCameras) {
                return null;
            }
            getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 0) {
                return new Camera(i2);
            }
            i = i2 + 1;
        }
    }

    public static Camera open(int i) {
        return new Camera(i);
    }

    public static Camera openLegacy(int i, int i2) {
        if (i2 < 256) {
            throw new IllegalArgumentException("Invalid HAL version " + i2);
        }
        return new Camera(i, i2);
    }

    public static Camera openUninitialized() {
        return new Camera();
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        Camera camera = (Camera) ((WeakReference) obj).get();
        if (camera == null || camera.mEventHandler == null) {
            return;
        }
        camera.mEventHandler.sendMessage(camera.mEventHandler.obtainMessage(i, i2, i3, obj2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void setHasPreviewCallback(boolean z, boolean z2);

    private final native void setPreviewCallbackSurface(Surface surface);

    public final void addCallbackBuffer(byte[] bArr) {
        _addCallbackBuffer(bArr, 16);
    }

    public final void addRawImageCallbackBuffer(byte[] bArr) {
        addCallbackBuffer(bArr, 128);
    }

    public final void autoFocus(AutoFocusCallback autoFocusCallback) {
        synchronized (this.mAutoFocusCallbackLock) {
            this.mAutoFocusCallback = autoFocusCallback;
        }
        native_autoFocus();
    }

    public int cameraInitUnspecified(int i) {
        return cameraInitVersion(i, -1);
    }

    public final void cancelAutoFocus() {
        synchronized (this.mAutoFocusCallbackLock) {
            this.mAutoFocusCallback = null;
        }
        native_cancelAutoFocus();
        this.mEventHandler.removeMessages(4);
    }

    public final Allocation createPreviewAllocation(RenderScript renderScript, int i) throws RSIllegalArgumentException {
        Size previewSize = getParameters().getPreviewSize();
        Type.Builder builder = new Type.Builder(renderScript, Element.createPixel(renderScript, Element.DataType.UNSIGNED_8, Element.DataKind.PIXEL_YUV));
        builder.setYuvFormat(ImageFormat.YV12);
        builder.setX(previewSize.width);
        builder.setY(previewSize.height);
        return Allocation.createTyped(renderScript, builder.create(), i | 32);
    }

    public final boolean disableShutterSound() {
        return _enableShutterSound(false);
    }

    public final boolean enableShutterSound(boolean z) {
        if (!z) {
            try {
                if (IAudioService.Stub.asInterface(ServiceManager.getService("audio")).isCameraSoundForced()) {
                    return false;
                }
            } catch (RemoteException e) {
                Log.e(TAG, "Audio service is unavailable for queries");
            }
        }
        return _enableShutterSound(z);
    }

    protected void finalize() {
        release();
    }

    public int getCurrentFocusPosition() {
        Parameters parameters = new Parameters();
        parameters.unflatten(native_getParameters());
        int i = -1;
        if (parameters.getCurrentFocusPosition() != null) {
            i = Integer.parseInt(parameters.getCurrentFocusPosition());
        }
        return i;
    }

    public Parameters getParameters() {
        Parameters parameters = new Parameters();
        parameters.unflatten(native_getParameters());
        return parameters;
    }

    public int getWBCurrentCCT() {
        Parameters parameters = new Parameters();
        parameters.unflatten(native_getParameters());
        int i = 0;
        if (parameters.getWBCurrentCCT() != null) {
            i = Integer.parseInt(parameters.getWBCurrentCCT());
        }
        return i;
    }

    public final native void lock();

    public final native boolean previewEnabled();

    public final native void reconnect() throws IOException;

    public final void release() {
        notifyTorch(false);
        native_release();
        this.mFaceDetectionRunning = false;
    }

    public final void sendHistogramData() {
        native_sendHistogramData();
    }

    public final void sendMetaData() {
        native_sendMetaData();
    }

    public final void sendVendorCommand(int i, int i2, int i3) {
        if (i < 1000) {
            throw new IllegalArgumentException("Command numbers must be at least 1000");
        }
        _sendVendorCommand(i, i2, i3);
    }

    public void setAutoFocusMoveCallback(AutoFocusMoveCallback autoFocusMoveCallback) {
        this.mAutoFocusMoveCallback = autoFocusMoveCallback;
        enableFocusMoveCallback(this.mAutoFocusMoveCallback != null ? 1 : 0);
    }

    public final native void setDisplayOrientation(int i);

    public final void setErrorCallback(ErrorCallback errorCallback) {
        this.mErrorCallback = errorCallback;
    }

    public final void setFaceDetectionListener(FaceDetectionListener faceDetectionListener) {
        this.mFaceListener = faceDetectionListener;
    }

    public final void setHistogramMode(CameraDataCallback cameraDataCallback) {
        this.mCameraDataCallback = cameraDataCallback;
        native_setHistogramMode(cameraDataCallback != null);
    }

    public final void setLongshot(boolean z) {
        native_setLongshot(z);
    }

    public final void setMetadataCb(CameraMetaDataCallback cameraMetaDataCallback) {
        this.mCameraMetaDataCallback = cameraMetaDataCallback;
        native_setMetadataCb(cameraMetaDataCallback != null);
    }

    public final void setOneShotPreviewCallback(PreviewCallback previewCallback) {
        boolean z = true;
        this.mPreviewCallback = previewCallback;
        this.mOneShot = true;
        this.mWithBuffer = false;
        if (previewCallback != null) {
            this.mUsingPreviewAllocation = false;
        }
        if (previewCallback == null) {
            z = false;
        }
        setHasPreviewCallback(z, false);
    }

    public void setParameters(Parameters parameters) {
        if (this.mUsingPreviewAllocation) {
            Size previewSize = parameters.getPreviewSize();
            Size previewSize2 = getParameters().getPreviewSize();
            if (previewSize.width != previewSize2.width || previewSize.height != previewSize2.height) {
                throw new IllegalStateException("Cannot change preview size while a preview allocation is configured.");
            }
        }
        native_setParameters(parameters.flatten());
    }

    public final void setPreviewCallback(PreviewCallback previewCallback) {
        this.mPreviewCallback = previewCallback;
        this.mOneShot = false;
        this.mWithBuffer = false;
        if (previewCallback != null) {
            this.mUsingPreviewAllocation = false;
        }
        setHasPreviewCallback(previewCallback != null, false);
    }

    public final void setPreviewCallbackAllocation(Allocation allocation) throws IOException {
        Surface surface;
        if (allocation != null) {
            Size previewSize = getParameters().getPreviewSize();
            if (previewSize.width != allocation.getType().getX() || previewSize.height != allocation.getType().getY()) {
                throw new IllegalArgumentException("Allocation dimensions don't match preview dimensions: Allocation is " + allocation.getType().getX() + ", " + allocation.getType().getY() + ". Preview is " + previewSize.width + ", " + previewSize.height);
            }
            if ((allocation.getUsage() & 32) == 0) {
                throw new IllegalArgumentException("Allocation usage does not include USAGE_IO_INPUT");
            }
            if (allocation.getType().getElement().getDataKind() != Element.DataKind.PIXEL_YUV) {
                throw new IllegalArgumentException("Allocation is not of a YUV type");
            }
            surface = allocation.getSurface();
            this.mUsingPreviewAllocation = true;
        } else {
            this.mUsingPreviewAllocation = false;
            surface = null;
        }
        setPreviewCallbackSurface(surface);
    }

    public final void setPreviewCallbackWithBuffer(PreviewCallback previewCallback) {
        boolean z = false;
        this.mPreviewCallback = previewCallback;
        this.mOneShot = false;
        this.mWithBuffer = true;
        if (previewCallback != null) {
            this.mUsingPreviewAllocation = false;
        }
        if (previewCallback != null) {
            z = true;
        }
        setHasPreviewCallback(z, true);
    }

    public final void setPreviewDisplay(SurfaceHolder surfaceHolder) throws IOException {
        if (surfaceHolder != null) {
            setPreviewSurface(surfaceHolder.getSurface());
        } else {
            setPreviewSurface(null);
        }
    }

    public final native void setPreviewSurface(Surface surface) throws IOException;

    public final native void setPreviewTexture(SurfaceTexture surfaceTexture) throws IOException;

    public final void setZoomChangeListener(OnZoomChangeListener onZoomChangeListener) {
        this.mZoomListener = onZoomChangeListener;
    }

    public final void startFaceDetection() {
        if (this.mFaceDetectionRunning) {
            throw new RuntimeException("Face detection is already running");
        }
        _startFaceDetection(0);
        this.mFaceDetectionRunning = true;
    }

    public final native void startPreview();

    public final native void startSmoothZoom(int i);

    public final void stopFaceDetection() {
        _stopFaceDetection();
        this.mFaceDetectionRunning = false;
    }

    public final void stopLongshot() {
        native_stopLongshot();
    }

    public final void stopPreview() {
        _stopPreview();
        this.mFaceDetectionRunning = false;
        this.mShutterCallback = null;
        this.mRawImageCallback = null;
        this.mPostviewCallback = null;
        this.mJpegCallback = null;
        synchronized (this.mAutoFocusCallbackLock) {
            this.mAutoFocusCallback = null;
        }
        this.mAutoFocusMoveCallback = null;
    }

    public final native void stopSmoothZoom();

    public final void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback, PictureCallback pictureCallback2) {
        takePicture(shutterCallback, pictureCallback, null, pictureCallback2);
    }

    public final void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback, PictureCallback pictureCallback2, PictureCallback pictureCallback3) {
        this.mShutterCallback = shutterCallback;
        this.mRawImageCallback = pictureCallback;
        this.mPostviewCallback = pictureCallback2;
        this.mJpegCallback = pictureCallback3;
        int i = 0;
        if (this.mShutterCallback != null) {
            i = 0 | 2;
        }
        int i2 = i;
        if (this.mRawImageCallback != null) {
            i2 = i | 128;
        }
        int i3 = i2;
        if (this.mPostviewCallback != null) {
            i3 = i2 | 64;
        }
        int i4 = i3;
        if (this.mJpegCallback != null) {
            i4 = i3 | 256;
        }
        native_takePicture(i4);
        this.mFaceDetectionRunning = false;
    }

    public final native void unlock();
}
