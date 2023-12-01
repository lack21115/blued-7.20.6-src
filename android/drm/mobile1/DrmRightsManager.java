package android.drm.mobile1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/drm/mobile1/DrmRightsManager.class */
public class DrmRightsManager {
    private static final int DRM_MIMETYPE_MESSAGE = 1;
    private static final int DRM_MIMETYPE_RIGHTS_WBXML = 4;
    public static final String DRM_MIMETYPE_RIGHTS_WBXML_STRING = "application/vnd.oma.drm.rights+wbxml";
    private static final int DRM_MIMETYPE_RIGHTS_XML = 3;
    public static final String DRM_MIMETYPE_RIGHTS_XML_STRING = "application/vnd.oma.drm.rights+xml";
    private static final int JNI_DRM_FAILURE = -1;
    private static final int JNI_DRM_SUCCESS = 0;
    private static DrmRightsManager singleton = null;

    static {
        try {
            System.loadLibrary("drm1_jni");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }

    protected DrmRightsManager() {
    }

    public static DrmRightsManager getInstance() {
        DrmRightsManager drmRightsManager;
        synchronized (DrmRightsManager.class) {
            try {
                if (singleton == null) {
                    singleton = new DrmRightsManager();
                }
                drmRightsManager = singleton;
            } catch (Throwable th) {
                throw th;
            }
        }
        return drmRightsManager;
    }

    private native int nativeDeleteRights(DrmRights drmRights);

    private native int nativeGetNumOfRights();

    private native int nativeGetRightsList(DrmRights[] drmRightsArr, int i);

    private native int nativeInstallDrmRights(InputStream inputStream, int i, int i2, DrmRights drmRights);

    private native int nativeQueryRights(DrmRawContent drmRawContent, DrmRights drmRights);

    public void deleteRights(DrmRights drmRights) {
        synchronized (this) {
            if (-1 == nativeDeleteRights(drmRights)) {
            }
        }
    }

    public List getRightsList() {
        ArrayList arrayList;
        synchronized (this) {
            ArrayList arrayList2 = new ArrayList();
            int nativeGetNumOfRights = nativeGetNumOfRights();
            if (-1 == nativeGetNumOfRights) {
                arrayList = null;
            } else {
                arrayList = arrayList2;
                if (nativeGetNumOfRights > 0) {
                    DrmRights[] drmRightsArr = new DrmRights[nativeGetNumOfRights];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= nativeGetNumOfRights) {
                            break;
                        }
                        drmRightsArr[i2] = new DrmRights();
                        i = i2 + 1;
                    }
                    int nativeGetRightsList = nativeGetRightsList(drmRightsArr, nativeGetNumOfRights);
                    if (-1 != nativeGetRightsList) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            arrayList = arrayList2;
                            if (i4 >= nativeGetRightsList) {
                                break;
                            }
                            arrayList2.add(drmRightsArr[i4]);
                            i3 = i4 + 1;
                        }
                    } else {
                        arrayList = null;
                    }
                }
            }
        }
        return arrayList;
    }

    public DrmRights installRights(InputStream inputStream, int i, String str) throws DrmException, IOException {
        int i2;
        DrmRights drmRights;
        synchronized (this) {
            if (DRM_MIMETYPE_RIGHTS_XML_STRING.equals(str)) {
                i2 = 3;
            } else if (DRM_MIMETYPE_RIGHTS_WBXML_STRING.equals(str)) {
                i2 = 4;
            } else if (!"application/vnd.oma.drm.message".equals(str)) {
                throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE");
            } else {
                i2 = 1;
            }
            if (i <= 0) {
                drmRights = null;
            } else {
                DrmRights drmRights2 = new DrmRights();
                drmRights = drmRights2;
                if (-1 == nativeInstallDrmRights(inputStream, i, i2, drmRights2)) {
                    throw new DrmException("nativeInstallDrmRights() returned JNI_DRM_FAILURE");
                }
            }
        }
        return drmRights;
    }

    public DrmRights queryRights(DrmRawContent drmRawContent) {
        DrmRights drmRights;
        synchronized (this) {
            DrmRights drmRights2 = new DrmRights();
            int nativeQueryRights = nativeQueryRights(drmRawContent, drmRights2);
            drmRights = drmRights2;
            if (-1 == nativeQueryRights) {
                drmRights = null;
            }
        }
        return drmRights;
    }
}
