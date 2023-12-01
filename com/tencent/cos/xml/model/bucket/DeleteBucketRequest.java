package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/DeleteBucketRequest.class */
public final class DeleteBucketRequest extends BucketRequest {
    public DeleteBucketRequest(String str) {
        super(str);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "DELETE";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }
}
