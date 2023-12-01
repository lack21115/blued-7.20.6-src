package com.tencent.cos.xml.model.ci.audit;

import android.text.TextUtils;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.audit.post.PostDocumentAudit;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/PostDocumentAuditRequest.class */
public class PostDocumentAuditRequest extends BasePostAuditRequest {
    private final PostDocumentAudit postDocumentAudit;

    public PostDocumentAuditRequest(String str) {
        super(str);
        this.postDocumentAudit = new PostDocumentAudit();
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (TextUtils.isEmpty(this.postDocumentAudit.input.object) && TextUtils.isEmpty(this.postDocumentAudit.input.url)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "object or url must be non-empty");
        }
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/document/auditing";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", QCloudXml.toXml(this.postDocumentAudit));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    public void setBizType(String str) {
        this.postDocumentAudit.conf.bizType = str;
    }

    public void setCallback(String str) {
        this.postDocumentAudit.conf.callback = str;
    }

    public void setDataId(String str) {
        this.postDocumentAudit.input.dataId = str;
    }

    public void setDetectType(String str) {
        this.postDocumentAudit.conf.detectType = str;
    }

    public void setObject(String str) {
        this.postDocumentAudit.input.object = str;
    }

    public void setType(String str) {
        this.postDocumentAudit.input.type = str;
    }

    public void setUrl(String str) {
        this.postDocumentAudit.input.url = str;
    }
}
