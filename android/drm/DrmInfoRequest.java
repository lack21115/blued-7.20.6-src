package android.drm;

import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmInfoRequest.class */
public class DrmInfoRequest {
    public static final String ACCOUNT_ID = "account_id";
    public static final String SUBSCRIPTION_ID = "subscription_id";
    public static final int TYPE_REGISTRATION_INFO = 1;
    public static final int TYPE_RIGHTS_ACQUISITION_INFO = 3;
    public static final int TYPE_RIGHTS_ACQUISITION_PROGRESS_INFO = 4;
    public static final int TYPE_UNREGISTRATION_INFO = 2;
    private final int mInfoType;
    private final String mMimeType;
    private final HashMap<String, Object> mRequestInformation = new HashMap<>();

    public DrmInfoRequest(int i, String str) {
        this.mInfoType = i;
        this.mMimeType = str;
        if (!isValid()) {
            throw new IllegalArgumentException("infoType: " + i + ",mimeType: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    public Object get(String str) {
        return this.mRequestInformation.get(str);
    }

    public int getInfoType() {
        return this.mInfoType;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValid() {
        return (this.mMimeType == null || this.mMimeType.equals("") || this.mRequestInformation == null || !isValidType(this.mInfoType)) ? false : true;
    }

    public Iterator<Object> iterator() {
        return this.mRequestInformation.values().iterator();
    }

    public Iterator<String> keyIterator() {
        return this.mRequestInformation.keySet().iterator();
    }

    public void put(String str, Object obj) {
        this.mRequestInformation.put(str, obj);
    }
}
