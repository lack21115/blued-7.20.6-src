package com.tencent.cos.xml.model.ci.audit;

import android.text.TextUtils;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.audit.post.PostAudioAudit;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/PostAudioAuditRequest.class */
public class PostAudioAuditRequest extends BasePostAuditRequest {
    private final PostAudioAudit postAudioAudit;

    public PostAudioAuditRequest(String str) {
        super(str);
        this.postAudioAudit = new PostAudioAudit();
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (TextUtils.isEmpty(this.postAudioAudit.input.object) && TextUtils.isEmpty(this.postAudioAudit.input.url)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "object or url must be non-empty");
        }
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/audio/auditing";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", QCloudXml.toXml(this.postAudioAudit));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    public void setBizType(String str) {
        this.postAudioAudit.conf.bizType = str;
    }

    public void setCallback(String str) {
        this.postAudioAudit.conf.callback = str;
    }

    public void setCallbackVersion(String str) {
        this.postAudioAudit.conf.callbackVersion = str;
    }

    public void setDataId(String str) {
        this.postAudioAudit.input.dataId = str;
    }

    public void setDetectType(String str) {
        this.postAudioAudit.conf.detectType = str;
    }

    public void setObject(String str) {
        this.postAudioAudit.input.object = str;
    }

    public void setUrl(String str) {
        this.postAudioAudit.input.url = str;
    }
}
