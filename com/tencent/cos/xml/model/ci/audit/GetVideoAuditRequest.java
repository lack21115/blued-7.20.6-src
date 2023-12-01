package com.tencent.cos.xml.model.ci.audit;

import com.tencent.cos.xml.CosXmlServiceConfig;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/GetVideoAuditRequest.class */
public class GetVideoAuditRequest extends GetAuditRequest {
    public GetVideoAuditRequest(String str, String str2) {
        super(str, str2);
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/video/auditing/" + this.jobId;
    }
}
