package com.blued.android.framework.utils.upload.qiniu;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadModel.class */
public class UploadModel {
    public String compressPath;
    public int type = 0;
    public String url;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadModel$TYPE.class */
    public interface TYPE {
    }

    public String toString() {
        return "UploadModel{compressPath='" + this.compressPath + "', url='" + this.url + "', type=" + this.type + '}';
    }
}
