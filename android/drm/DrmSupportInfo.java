package android.drm;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmSupportInfo.class */
public class DrmSupportInfo {
    private final ArrayList<String> mFileSuffixList = new ArrayList<>();
    private final ArrayList<String> mMimeTypeList = new ArrayList<>();
    private String mDescription = "";

    public void addFileSuffix(String str) {
        if (str == "") {
            throw new IllegalArgumentException("fileSuffix is an empty string");
        }
        this.mFileSuffixList.add(str);
    }

    public void addMimeType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("mimeType is null");
        }
        if (str == "") {
            throw new IllegalArgumentException("mimeType is an empty string");
        }
        this.mMimeTypeList.add(str);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof DrmSupportInfo) {
            DrmSupportInfo drmSupportInfo = (DrmSupportInfo) obj;
            z = false;
            if (this.mFileSuffixList.equals(drmSupportInfo.mFileSuffixList)) {
                z = false;
                if (this.mMimeTypeList.equals(drmSupportInfo.mMimeTypeList)) {
                    z = false;
                    if (this.mDescription.equals(drmSupportInfo.mDescription)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public String getDescriprition() {
        return this.mDescription;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Iterator<String> getFileSuffixIterator() {
        return this.mFileSuffixList.iterator();
    }

    public Iterator<String> getMimeTypeIterator() {
        return this.mMimeTypeList.iterator();
    }

    public int hashCode() {
        return this.mFileSuffixList.hashCode() + this.mMimeTypeList.hashCode() + this.mDescription.hashCode();
    }

    boolean isSupportedFileSuffix(String str) {
        return this.mFileSuffixList.contains(str);
    }

    boolean isSupportedMimeType(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mMimeTypeList.size()) {
                return false;
            }
            if (this.mMimeTypeList.get(i2).startsWith(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public void setDescription(String str) {
        if (str == null) {
            throw new IllegalArgumentException("description is null");
        }
        if (str == "") {
            throw new IllegalArgumentException("description is an empty string");
        }
        this.mDescription = str;
    }
}
