package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.CopyObject;
import com.tencent.cos.xml.model.tag.CosError;
import com.tencent.cos.xml.transfer.XmlSlimParser;
import com.tencent.cos.xml.utils.CloseUtil;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/CopyObjectResult.class */
public class CopyObjectResult extends CosXmlResult {
    public CopyObject copyObject;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                this.copyObject = new CopyObject();
                byte[] bytes = httpResponse.bytes();
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bytes);
                try {
                    XmlSlimParser.parseCopyObjectResult(byteArrayInputStream2, this.copyObject);
                    if (this.copyObject.eTag == null && bytes != null && bytes.length > 0) {
                        byteArrayInputStream2.reset();
                        CosXmlServiceException cosXmlServiceException = new CosXmlServiceException("failed");
                        CosError cosError = new CosError();
                        XmlSlimParser.parseError(byteArrayInputStream2, cosError);
                        cosXmlServiceException.setErrorCode(cosError.code);
                        cosXmlServiceException.setErrorMessage(cosError.message);
                        cosXmlServiceException.setRequestId(cosError.requestId);
                        cosXmlServiceException.setServiceName(cosError.resource);
                        cosXmlServiceException.setStatusCode(httpResponse.code());
                        throw cosXmlServiceException;
                    }
                    CloseUtil.closeQuietly(byteArrayInputStream2);
                } catch (IOException e) {
                    e = e;
                    throw new CosXmlClientException(ClientErrorCode.POOR_NETWORK.getCode(), e);
                } catch (XmlPullParserException e2) {
                    e = e2;
                    throw new CosXmlClientException(ClientErrorCode.SERVERERROR.getCode(), e);
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    CloseUtil.closeQuietly(byteArrayInputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (XmlPullParserException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        CopyObject copyObject = this.copyObject;
        return copyObject != null ? copyObject.toString() : super.printResult();
    }
}
