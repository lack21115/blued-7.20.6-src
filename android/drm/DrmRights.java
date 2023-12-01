package android.drm;

import java.io.File;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmRights.class */
public class DrmRights {
    private String mAccountId;
    private byte[] mData;
    private String mMimeType;
    private String mSubscriptionId;

    public DrmRights(ProcessedData processedData, String str) {
        if (processedData == null) {
            throw new IllegalArgumentException("data is null");
        }
        this.mData = processedData.getData();
        this.mAccountId = processedData.getAccountId();
        this.mSubscriptionId = processedData.getSubscriptionId();
        this.mMimeType = str;
        if (!isValid()) {
            throw new IllegalArgumentException("mimeType: " + this.mMimeType + ",data: " + this.mData);
        }
    }

    public DrmRights(File file, String str) {
        instantiate(file, str);
    }

    public DrmRights(String str, String str2) {
        instantiate(new File(str), str2);
    }

    public DrmRights(String str, String str2, String str3) {
        this(str, str2);
        this.mAccountId = str3;
    }

    public DrmRights(String str, String str2, String str3, String str4) {
        this(str, str2);
        this.mAccountId = str3;
        this.mSubscriptionId = str4;
    }

    private void instantiate(File file, String str) {
        try {
            this.mData = DrmUtils.readBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mMimeType = str;
        if (!isValid()) {
            throw new IllegalArgumentException("mimeType: " + this.mMimeType + ",data: " + this.mData);
        }
    }

    public String getAccountId() {
        return this.mAccountId;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String getSubscriptionId() {
        return this.mSubscriptionId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValid() {
        return (this.mMimeType == null || this.mMimeType.equals("") || this.mData == null || this.mData.length <= 0) ? false : true;
    }
}
