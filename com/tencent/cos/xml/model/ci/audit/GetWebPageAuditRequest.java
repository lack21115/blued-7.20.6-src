package com.tencent.cos.xml.model.ci.audit;

import com.tencent.cos.xml.CosXmlServiceConfig;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/GetWebPageAuditRequest.class */
public class GetWebPageAuditRequest extends GetAuditRequest {
    public GetWebPageAuditRequest(String str, String str2) {
        super(str, str2);
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/webpage/auditing/" + this.jobId;
    }
}
