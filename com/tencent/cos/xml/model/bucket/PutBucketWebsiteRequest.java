package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.WebsiteConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/PutBucketWebsiteRequest.class */
public class PutBucketWebsiteRequest extends BucketRequest {
    private WebsiteConfiguration websiteConfiguration;

    public PutBucketWebsiteRequest(String str) {
        super(str);
        this.websiteConfiguration = new WebsiteConfiguration();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("website", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildWebsiteConfiguration(this.websiteConfiguration));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    public void setErrorDocument(String str) {
        if (str != null) {
            if (this.websiteConfiguration.errorDocument == null) {
                this.websiteConfiguration.errorDocument = new WebsiteConfiguration.ErrorDocument();
            }
            this.websiteConfiguration.errorDocument.key = str;
        }
    }

    public void setIndexDocument(String str) {
        if (str != null) {
            if (this.websiteConfiguration.indexDocument == null) {
                this.websiteConfiguration.indexDocument = new WebsiteConfiguration.IndexDocument();
            }
            this.websiteConfiguration.indexDocument.suffix = str;
        }
    }

    public void setRedirectAllRequestTo(String str) {
        if (str != null) {
            if (this.websiteConfiguration.redirectAllRequestTo == null) {
                this.websiteConfiguration.redirectAllRequestTo = new WebsiteConfiguration.RedirectAllRequestTo();
            }
            this.websiteConfiguration.redirectAllRequestTo.protocol = str;
        }
    }

    public void setRoutingRules(List<WebsiteConfiguration.RoutingRule> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (this.websiteConfiguration.routingRules == null) {
            this.websiteConfiguration.routingRules = new ArrayList();
        }
        for (WebsiteConfiguration.RoutingRule routingRule : list) {
            this.websiteConfiguration.routingRules.add(routingRule);
        }
    }
}
