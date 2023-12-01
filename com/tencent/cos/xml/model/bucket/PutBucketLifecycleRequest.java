package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/PutBucketLifecycleRequest.class */
public final class PutBucketLifecycleRequest extends BucketRequest {
    private LifecycleConfiguration lifecycleConfiguration;

    public PutBucketLifecycleRequest(String str) {
        super(str);
        LifecycleConfiguration lifecycleConfiguration = new LifecycleConfiguration();
        this.lifecycleConfiguration = lifecycleConfiguration;
        lifecycleConfiguration.rules = new ArrayList();
    }

    public LifecycleConfiguration getLifecycleConfiguration() {
        return this.lifecycleConfiguration;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("lifecycle", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildLifecycleConfigurationXML(this.lifecycleConfiguration));
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

    public void setRuleList(LifecycleConfiguration.Rule rule) {
        if (rule != null) {
            this.lifecycleConfiguration.rules.add(rule);
        }
    }

    public void setRuleList(List<LifecycleConfiguration.Rule> list) {
        if (list != null) {
            this.lifecycleConfiguration.rules.addAll(list);
        }
    }
}
