package com.tencent.cos.xml.model.ci.audit;

import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.model.bucket.BucketRequest;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/BasePostAuditRequest.class */
public abstract class BasePostAuditRequest extends BucketRequest {
    public BasePostAuditRequest(String str) {
        super(str);
        addNoSignHeader("Content-Type");
        addNoSignHeader("Content-Length");
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getRequestHost(CosXmlServiceConfig cosXmlServiceConfig) {
        return cosXmlServiceConfig.getRequestHost(this.region, this.bucket, CosXmlServiceConfig.CI_HOST_FORMAT);
    }
}
