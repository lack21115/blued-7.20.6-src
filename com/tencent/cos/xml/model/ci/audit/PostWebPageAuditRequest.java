package com.tencent.cos.xml.model.ci.audit;

import android.text.TextUtils;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.audit.post.PostWebPageAudit;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/PostWebPageAuditRequest.class */
public class PostWebPageAuditRequest extends BasePostAuditRequest {
    private final PostWebPageAudit postWebPageAudit;

    public PostWebPageAuditRequest(String str) {
        super(str);
        this.postWebPageAudit = new PostWebPageAudit();
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (TextUtils.isEmpty(this.postWebPageAudit.input.url)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "url must be non-empty");
        }
        if (TextUtils.isEmpty(this.postWebPageAudit.conf.detectType)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "detectType must be non-empty");
        }
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/webpage/auditing";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", QCloudXml.toXml(this.postWebPageAudit));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    public void setCallback(String str) {
        this.postWebPageAudit.conf.callback = str;
    }

    public void setDetectType(String str) {
        this.postWebPageAudit.conf.detectType = str;
    }

    public void setReturnHighlightHtml(boolean z) {
        this.postWebPageAudit.conf.returnHighlightHtml = z;
    }

    public void setUrl(String str) {
        this.postWebPageAudit.input.url = str;
    }
}
