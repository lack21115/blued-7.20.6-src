package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.DomainConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/PutBucketDomainRequest.class */
public class PutBucketDomainRequest extends BucketRequest {
    private DomainConfiguration domainConfiguration;

    public PutBucketDomainRequest(String str) {
        super(str);
        DomainConfiguration domainConfiguration = new DomainConfiguration();
        this.domainConfiguration = domainConfiguration;
        domainConfiguration.domainRules = new ArrayList();
    }

    public void addDomainRule(DomainConfiguration.DomainRule domainRule) {
        if (domainRule != null) {
            this.domainConfiguration.domainRules.add(domainRule);
        }
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.domainConfiguration.domainRules.size() > 0) {
            for (DomainConfiguration.DomainRule domainRule : this.domainConfiguration.domainRules) {
                if (domainRule.status == null) {
                    throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "DomainRule.status is null");
                }
                if (domainRule.name == null) {
                    throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "DomainRule.name is null");
                }
                if (domainRule.type == null) {
                    throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "DomainRule.type is null");
                }
            }
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("domain", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildDomainConfiguration(this.domainConfiguration));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public boolean isNeedMD5() {
        return true;
    }
}
