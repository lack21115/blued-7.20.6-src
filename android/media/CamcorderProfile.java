package android.media;

import android.hardware.Camera;

/* loaded from: source-9557208-dex2jar.jar:android/media/CamcorderProfile.class */
public class CamcorderProfile {
    public static final int QUALITY_1080P = 6;
    public static final int QUALITY_2160P = 8;
    public static final int QUALITY_480P = 4;
    public static final int QUALITY_4kDCI = 14;
    public static final int QUALITY_720P = 5;
    public static final int QUALITY_CIF = 3;
    public static final int QUALITY_FWVGA = 13;
    public static final int QUALITY_HIGH = 1;
    public static final int QUALITY_HIGH_SPEED_1080P = 2004;
    public static final int QUALITY_HIGH_SPEED_2160P = 2005;
    public static final int QUALITY_HIGH_SPEED_480P = 2002;
    public static final int QUALITY_HIGH_SPEED_720P = 2003;
    public static final int QUALITY_HIGH_SPEED_HIGH = 2001;
    private static final int QUALITY_HIGH_SPEED_LIST_END = 2005;
    private static final int QUALITY_HIGH_SPEED_LIST_START = 2000;
    public static final int QUALITY_HIGH_SPEED_LOW = 2000;
    public static final int QUALITY_HVGA = 19;
    private static final int QUALITY_LIST_END = 19;
    private static final int QUALITY_LIST_START = 0;
    public static final int QUALITY_LOW = 0;
    public static final int QUALITY_QCIF = 2;
    public static final int QUALITY_QVGA = 7;
    public static final int QUALITY_TIME_LAPSE_1080P = 1006;
    public static final int QUALITY_TIME_LAPSE_2160P = 1008;
    public static final int QUALITY_TIME_LAPSE_480P = 1004;
    public static final int QUALITY_TIME_LAPSE_4kDCI = 1014;
    public static final int QUALITY_TIME_LAPSE_720P = 1005;
    public static final int QUALITY_TIME_LAPSE_CIF = 1003;
    public static final int QUALITY_TIME_LAPSE_FWVGA = 1013;
    public static final int QUALITY_TIME_LAPSE_HIGH = 1001;
    private static final int QUALITY_TIME_LAPSE_LIST_END = 1014;
    private static final int QUALITY_TIME_LAPSE_LIST_START = 1000;
    public static final int QUALITY_TIME_LAPSE_LOW = 1000;
    public static final int QUALITY_TIME_LAPSE_QCIF = 1002;
    public static final int QUALITY_TIME_LAPSE_QVGA = 1007;
    public static final int QUALITY_TIME_LAPSE_VGA = 1011;
    public static final int QUALITY_TIME_LAPSE_WQVGA = 1012;
    public static final int QUALITY_TIME_LAPSE_WVGA = 1010;
    public static final int QUALITY_VGA = 11;
    public static final int QUALITY_WQVGA = 12;
    public static final int QUALITY_WVGA = 10;
    public int audioBitRate;
    public int audioChannels;
    public int audioCodec;
    public int audioSampleRate;
    public int duration;
    public int fileFormat;
    public int quality;
    public int videoBitRate;
    public int videoCodec;
    public int videoFrameHeight;
    public int videoFrameRate;
    public int videoFrameWidth;

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    private CamcorderProfile(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.duration = i;
        this.quality = i2;
        this.fileFormat = i3;
        this.videoCodec = i4;
        this.videoBitRate = i5;
        this.videoFrameRate = i6;
        this.videoFrameWidth = i7;
        this.videoFrameHeight = i8;
        this.audioCodec = i9;
        this.audioBitRate = i10;
        this.audioSampleRate = i11;
        this.audioChannels = i12;
    }

    public static CamcorderProfile get(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= numberOfCameras) {
                return null;
            }
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 0) {
                return get(i3, i);
            }
            i2 = i3 + 1;
        }
    }

    public static CamcorderProfile get(int i, int i2) {
        if ((i2 < 0 || i2 > 19) && ((i2 < 1000 || i2 > 1014) && (i2 < 2000 || i2 > 2005))) {
            throw new IllegalArgumentException("Unsupported quality level: " + i2);
        }
        return native_get_camcorder_profile(i, i2);
    }

    public static boolean hasProfile(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= numberOfCameras) {
                return false;
            }
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 0) {
                return hasProfile(i3, i);
            }
            i2 = i3 + 1;
        }
    }

    public static boolean hasProfile(int i, int i2) {
        return native_has_camcorder_profile(i, i2);
    }

    private static final native CamcorderProfile native_get_camcorder_profile(int i, int i2);

    private static final native boolean native_has_camcorder_profile(int i, int i2);

    private static final native void native_init();
}
