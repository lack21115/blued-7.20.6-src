package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.BucketLoggingStatus;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/PutBucketLoggingRequest.class */
public class PutBucketLoggingRequest extends BucketRequest {
    private BucketLoggingStatus bucketLoggingStatus;

    public PutBucketLoggingRequest(String str) {
        super(str);
        this.bucketLoggingStatus = new BucketLoggingStatus();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("logging", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildBucketLogging(this.bucketLoggingStatus));
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

    public void setTargetBucket(String str) {
        if (str == null) {
            return;
        }
        if (this.bucketLoggingStatus.loggingEnabled == null) {
            this.bucketLoggingStatus.loggingEnabled = new BucketLoggingStatus.LoggingEnabled();
        }
        this.bucketLoggingStatus.loggingEnabled.targetBucket = str;
    }

    public void setTargetPrefix(String str) {
        if (str == null) {
            return;
        }
        if (this.bucketLoggingStatus.loggingEnabled == null) {
            this.bucketLoggingStatus.loggingEnabled = new BucketLoggingStatus.LoggingEnabled();
        }
        this.bucketLoggingStatus.loggingEnabled.targetPrefix = str;
    }
}
