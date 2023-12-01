package com.qiniu.android.collect;

import com.qiniu.android.collect.UploadInfoElement;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/UploadInfo.class */
public class UploadInfo {
    public static UploadInfoElement.BlockInfo getBlockInfo() {
        return new UploadInfoElement.BlockInfo();
    }

    public static UploadInfoElement.ReqInfo getReqInfo() {
        return new UploadInfoElement.ReqInfo();
    }

    public static UploadInfoElement.UploadQuality getUploadQuality() {
        return new UploadInfoElement.UploadQuality();
    }
}
