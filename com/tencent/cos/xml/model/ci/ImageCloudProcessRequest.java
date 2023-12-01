package com.tencent.cos.xml.model.ci;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.object.ObjectRequest;
import com.tencent.qcloud.core.http.RequestBodySerializer;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/ImageCloudProcessRequest.class */
public abstract class ImageCloudProcessRequest extends ObjectRequest {
    public ImageCloudProcessRequest(String str, String str2) {
        super(str, str2);
    }

    protected abstract void addCiParams();

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        addCiParams();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return null;
    }
}
