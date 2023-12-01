package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.CosError;
import com.tencent.cos.xml.utils.BaseXmlSlimParser;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpResponse;
import com.tencent.qcloud.core.http.ResponseBodyConverter;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/ResponseXmlS3BodySerializer.class */
public class ResponseXmlS3BodySerializer<T> extends ResponseBodyConverter<T> {
    private CosXmlResult cosXmlResult;

    public ResponseXmlS3BodySerializer(CosXmlResult cosXmlResult) {
        this.cosXmlResult = cosXmlResult;
    }

    private void parseCOSXMLError(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        int code = httpResponse.code();
        if (code < 200 || code >= 300) {
            CosXmlServiceException cosXmlServiceException = new CosXmlServiceException(httpResponse.message());
            cosXmlServiceException.setStatusCode(code);
            cosXmlServiceException.setRequestId(httpResponse.header(Headers.REQUEST_ID));
            InputStream byteStream = httpResponse.byteStream();
            if (byteStream != null) {
                CosError cosError = new CosError();
                try {
                    BaseXmlSlimParser.parseError(byteStream, cosError);
                    if (cosError.code != null) {
                        cosXmlServiceException.setErrorCode(cosError.code);
                    }
                    if (cosError.message != null) {
                        cosXmlServiceException.setErrorMessage(cosError.message);
                    }
                    if (cosError.requestId != null) {
                        cosXmlServiceException.setRequestId(cosError.requestId);
                    }
                    if (cosError.resource != null) {
                        cosXmlServiceException.setServiceName(cosError.resource);
                    }
                } catch (IOException e) {
                    throw new CosXmlClientException(ClientErrorCode.POOR_NETWORK.getCode(), e);
                } catch (XmlPullParserException e2) {
                    throw new CosXmlClientException(ClientErrorCode.SERVERERROR.getCode(), e2);
                }
            }
            throw cosXmlServiceException;
        }
    }

    @Override // com.tencent.qcloud.core.http.ResponseBodyConverter
    public T convert(HttpResponse httpResponse) throws QCloudClientException, QCloudServiceException {
        parseCOSXMLError(httpResponse);
        this.cosXmlResult.parseResponseBody(httpResponse);
        return (T) this.cosXmlResult;
    }
}
