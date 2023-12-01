package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.AccessControlPolicy;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/GetBucketACLResult.class */
public final class GetBucketACLResult extends CosXmlResult {
    public AccessControlPolicy accessControlPolicy;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.accessControlPolicy = new AccessControlPolicy();
        try {
            XmlParser.parseAccessControlPolicy(httpResponse.byteStream(), this.accessControlPolicy);
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.POOR_NETWORK.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.SERVERERROR.getCode(), e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        AccessControlPolicy accessControlPolicy = this.accessControlPolicy;
        return accessControlPolicy != null ? accessControlPolicy.toString() : super.printResult();
    }
}
