package com.tencent.cos.xml.model.ci.audit;

import com.tencent.cos.xml.CosXmlServiceConfig;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/GetAudioAuditRequest.class */
public class GetAudioAuditRequest extends GetAuditRequest {
    public GetAudioAuditRequest(String str, String str2) {
        super(str, str2);
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/audio/auditing/" + this.jobId;
    }
}
