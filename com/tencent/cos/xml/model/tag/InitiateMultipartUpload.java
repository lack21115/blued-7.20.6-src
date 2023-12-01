package com.tencent.cos.xml.model.tag;

import com.alipay.sdk.util.i;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/InitiateMultipartUpload.class */
public class InitiateMultipartUpload {
    public String bucket;
    public String key;
    public String uploadId;

    public String toString() {
        return "{InitiateMultipartUpload:\nBucket:" + this.bucket + "\nKey:" + this.key + "\nUploadId:" + this.uploadId + "\n" + i.d;
    }
}
