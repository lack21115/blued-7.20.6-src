package android.media;

import android.hardware.Camera;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/media/CameraProfile.class */
public class CameraProfile {
    public static final int QUALITY_HIGH = 2;
    public static final int QUALITY_LOW = 0;
    public static final int QUALITY_MEDIUM = 1;
    private static final HashMap<Integer, int[]> sCache = new HashMap<>();

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    private static int[] getImageEncodingQualityLevels(int i) {
        int native_get_num_image_encoding_quality_levels = native_get_num_image_encoding_quality_levels(i);
        if (native_get_num_image_encoding_quality_levels != 3) {
            throw new RuntimeException("Unexpected Jpeg encoding quality levels " + native_get_num_image_encoding_quality_levels);
        }
        int[] iArr = new int[native_get_num_image_encoding_quality_levels];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= native_get_num_image_encoding_quality_levels) {
                Arrays.sort(iArr);
                return iArr;
            }
            iArr[i3] = native_get_image_encoding_quality_level(i, i3);
            i2 = i3 + 1;
        }
    }

    public static int getJpegEncodingQualityParameter(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= numberOfCameras) {
                return 0;
            }
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 0) {
                return getJpegEncodingQualityParameter(i3, i);
            }
            i2 = i3 + 1;
        }
    }

    public static int getJpegEncodingQualityParameter(int i, int i2) {
        int i3;
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("Unsupported quality level: " + i2);
        }
        synchronized (sCache) {
            int[] iArr = sCache.get(Integer.valueOf(i));
            int[] iArr2 = iArr;
            if (iArr == null) {
                iArr2 = getImageEncodingQualityLevels(i);
                sCache.put(Integer.valueOf(i), iArr2);
            }
            i3 = iArr2[i2];
        }
        return i3;
    }

    private static final native int native_get_image_encoding_quality_level(int i, int i2);

    private static final native int native_get_num_image_encoding_quality_levels(int i);

    private static final native void native_init();
}
