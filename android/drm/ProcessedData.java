package android.drm;

/* loaded from: source-9557208-dex2jar.jar:android/drm/ProcessedData.class */
public class ProcessedData {
    private String mAccountId;
    private final byte[] mData;
    private String mSubscriptionId;

    ProcessedData(byte[] bArr, String str) {
        this.mAccountId = "_NO_USER";
        this.mSubscriptionId = "";
        this.mData = bArr;
        this.mAccountId = str;
    }

    ProcessedData(byte[] bArr, String str, String str2) {
        this.mAccountId = "_NO_USER";
        this.mSubscriptionId = "";
        this.mData = bArr;
        this.mAccountId = str;
        this.mSubscriptionId = str2;
    }

    public String getAccountId() {
        return this.mAccountId;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getSubscriptionId() {
        return this.mSubscriptionId;
    }
}
