package com.tencent.cos.xml.model.ci.audit;

import android.text.TextUtils;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.audit.post.PostVideoAudit;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/audit/PostVideoAuditRequest.class */
public class PostVideoAuditRequest extends BasePostAuditRequest {
    private final PostVideoAudit postVideoAudit;

    public PostVideoAuditRequest(String str) {
        super(str);
        this.postVideoAudit = new PostVideoAudit();
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (TextUtils.isEmpty(this.postVideoAudit.input.object) && TextUtils.isEmpty(this.postVideoAudit.input.url)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "object or url must be non-empty");
        }
        if (this.postVideoAudit.conf.snapshot.count == 0) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "count cannot be 0");
        }
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/video/auditing";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", QCloudXml.toXml(this.postVideoAudit));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    public void setBizType(String str) {
        this.postVideoAudit.conf.bizType = str;
    }

    public void setCallback(String str) {
        this.postVideoAudit.conf.callback = str;
    }

    public void setCallbackVersion(String str) {
        this.postVideoAudit.conf.callbackVersion = str;
    }

    public void setCount(int i) {
        this.postVideoAudit.conf.snapshot.count = i;
    }

    public void setDataId(String str) {
        this.postVideoAudit.input.dataId = str;
    }

    public void setDetectContent(int i) {
        this.postVideoAudit.conf.detectContent = i;
    }

    public void setDetectType(String str) {
        this.postVideoAudit.conf.detectType = str;
    }

    public void setMode(String str) {
        this.postVideoAudit.conf.snapshot.mode = str;
    }

    public void setObject(String str) {
        this.postVideoAudit.input.object = str;
    }

    public void setTimeInterval(float f) {
        this.postVideoAudit.conf.snapshot.timeInterval = f;
    }

    public void setUrl(String str) {
        this.postVideoAudit.input.url = str;
    }
}
