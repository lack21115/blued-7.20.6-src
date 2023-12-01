package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.IntelligentTieringConfiguration;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/PutBucketIntelligentTieringRequest.class */
public class PutBucketIntelligentTieringRequest extends BucketRequest {
    public static final String STATUS_ENABLED = "Enabled";
    public static final String STATUS_SUSPEND = "Suspended";
    private IntelligentTieringConfiguration configuration;

    public PutBucketIntelligentTieringRequest(String str) {
        super(str);
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.configuration == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "configuration must not be null");
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("intelligenttiering", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            String xml = QCloudXml.toXml(this.configuration);
            return RequestBodySerializer.bytes("text/plain", xml.getBytes(), 0L, xml.length());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), "", e.getCause());
        }
    }

    public void setConfiguration(IntelligentTieringConfiguration intelligentTieringConfiguration) {
        this.configuration = intelligentTieringConfiguration;
    }
}
