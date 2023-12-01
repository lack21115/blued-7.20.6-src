package android.drm;

import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmEvent.class */
public class DrmEvent {
    public static final String DRM_INFO_OBJECT = "drm_info_object";
    public static final String DRM_INFO_STATUS_OBJECT = "drm_info_status_object";
    public static final int TYPE_ALL_RIGHTS_REMOVED = 1001;
    public static final int TYPE_DRM_INFO_PROCESSED = 1002;
    private HashMap<String, Object> mAttributes;
    private String mMessage;
    private final int mType;
    private final int mUniqueId;

    /* JADX INFO: Access modifiers changed from: protected */
    public DrmEvent(int i, int i2, String str) {
        this.mMessage = "";
        this.mAttributes = new HashMap<>();
        this.mUniqueId = i;
        this.mType = i2;
        if (str != null) {
            this.mMessage = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DrmEvent(int i, int i2, String str, HashMap<String, Object> hashMap) {
        this.mMessage = "";
        this.mAttributes = new HashMap<>();
        this.mUniqueId = i;
        this.mType = i2;
        if (str != null) {
            this.mMessage = str;
        }
        if (hashMap != null) {
            this.mAttributes = hashMap;
        }
    }

    public Object getAttribute(String str) {
        return this.mAttributes.get(str);
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getType() {
        return this.mType;
    }

    public int getUniqueId() {
        return this.mUniqueId;
    }
}
