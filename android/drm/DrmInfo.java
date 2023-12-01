package android.drm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmInfo.class */
public class DrmInfo {
    private final HashMap<String, Object> mAttributes = new HashMap<>();
    private byte[] mData;
    private final int mInfoType;
    private final String mMimeType;

    public DrmInfo(int i, String str, String str2) {
        this.mInfoType = i;
        this.mMimeType = str2;
        try {
            this.mData = DrmUtils.readBytes(str);
        } catch (IOException e) {
            this.mData = null;
        }
        if (isValid()) {
            return;
        }
        String str3 = "infoType: " + i + ",mimeType: " + str2 + ",data: " + this.mData;
        throw new IllegalArgumentException();
    }

    public DrmInfo(int i, byte[] bArr, String str) {
        this.mInfoType = i;
        this.mMimeType = str;
        this.mData = bArr;
        if (!isValid()) {
            throw new IllegalArgumentException("infoType: " + i + ",mimeType: " + str + ",data: " + bArr);
        }
    }

    public Object get(String str) {
        return this.mAttributes.get(str);
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getInfoType() {
        return this.mInfoType;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValid() {
        return (this.mMimeType == null || this.mMimeType.equals("") || this.mData == null || this.mData.length <= 0 || !DrmInfoRequest.isValidType(this.mInfoType)) ? false : true;
    }

    public Iterator<Object> iterator() {
        return this.mAttributes.values().iterator();
    }

    public Iterator<String> keyIterator() {
        return this.mAttributes.keySet().iterator();
    }

    public void put(String str, Object obj) {
        this.mAttributes.put(str, obj);
    }
}
