package android.drm.mobile1;

/* loaded from: source-9557208-dex2jar.jar:android/drm/mobile1/DrmRights.class */
public class DrmRights {
    public static final int DRM_PERMISSION_DISPLAY = 2;
    public static final int DRM_PERMISSION_EXECUTE = 3;
    public static final int DRM_PERMISSION_PLAY = 1;
    public static final int DRM_PERMISSION_PRINT = 4;
    private static final int JNI_DRM_FAILURE = -1;
    private static final int JNI_DRM_SUCCESS = 0;
    private String roId = "";

    static {
        try {
            System.loadLibrary("drm1_jni");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }

    private native int nativeConsumeRights(int i);

    private native int nativeGetConstraintInfo(int i, DrmConstraintInfo drmConstraintInfo);

    public boolean consumeRights(int i) {
        return -1 != nativeConsumeRights(i);
    }

    public DrmConstraintInfo getConstraint(int i) {
        DrmConstraintInfo drmConstraintInfo = new DrmConstraintInfo();
        DrmConstraintInfo drmConstraintInfo2 = drmConstraintInfo;
        if (-1 == nativeGetConstraintInfo(i, drmConstraintInfo)) {
            drmConstraintInfo2 = null;
        }
        return drmConstraintInfo2;
    }
}
