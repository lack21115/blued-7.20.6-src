package com.tencent.cos.xml.model.ci.audit;

import android.text.TextUtils;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.audit.post.PostTextAudit;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/PostTextAuditRequest.class */
public class PostTextAuditRequest extends BasePostAuditRequest {
    protected final PostTextAudit postTextAudit;

    public PostTextAuditRequest(String str) {
        super(str);
        this.postTextAudit = new PostTextAudit();
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (TextUtils.isEmpty(this.postTextAudit.input.object) && TextUtils.isEmpty(this.postTextAudit.input.url) && TextUtils.isEmpty(this.postTextAudit.input.content)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "object or url or content must be non-empty");
        }
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/text/auditing";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", QCloudXml.toXml(this.postTextAudit));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    public void setBizType(String str) {
        this.postTextAudit.conf.bizType = str;
    }

    public void setCallback(String str) {
        this.postTextAudit.conf.callback = str;
    }

    public void setCallbackVersion(String str) {
        this.postTextAudit.conf.callbackVersion = str;
    }

    public void setContent(String str) {
        this.postTextAudit.input.content = str;
    }

    public void setDataId(String str) {
        this.postTextAudit.input.dataId = str;
    }

    public void setDetectType(String str) {
        this.postTextAudit.conf.detectType = str;
    }

    public void setObject(String str) {
        this.postTextAudit.input.object = str;
    }

    public void setUrl(String str) {
        this.postTextAudit.input.url = str;
    }
}
