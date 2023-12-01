package android.drm;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmInfoStatus.class */
public class DrmInfoStatus {
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_OK = 1;
    public final ProcessedData data;
    public final int infoType;
    public final String mimeType;
    public final int statusCode;

    public DrmInfoStatus(int i, int i2, ProcessedData processedData, String str) {
        if (!DrmInfoRequest.isValidType(i2)) {
            throw new IllegalArgumentException("infoType: " + i2);
        }
        if (!isValidStatusCode(i)) {
            throw new IllegalArgumentException("Unsupported status code: " + i);
        }
        if (str == null || str == "") {
            throw new IllegalArgumentException("mimeType is null or an empty string");
        }
        this.statusCode = i;
        this.infoType = i2;
        this.data = processedData;
        this.mimeType = str;
    }

    private boolean isValidStatusCode(int i) {
        return i == 1 || i == 2;
    }
}
