package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.CompleteMultipartUploadResult;
import com.tencent.qcloud.core.http.HttpResponse;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/CompleteMultiUploadResult.class */
public final class CompleteMultiUploadResult extends CosXmlResult {
    public CompleteMultipartUploadResult completeMultipartUpload;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        try {
            this.completeMultipartUpload = (CompleteMultipartUploadResult) QCloudXml.fromXml(httpResponse.byteStream(), CompleteMultipartUploadResult.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        CompleteMultipartUploadResult completeMultipartUploadResult = this.completeMultipartUpload;
        return completeMultipartUploadResult != null ? completeMultipartUploadResult.toString() : super.printResult();
    }
}
