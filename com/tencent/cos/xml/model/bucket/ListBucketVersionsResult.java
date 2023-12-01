package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListBucketVersions;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/ListBucketVersionsResult.class */
public class ListBucketVersionsResult extends CosXmlResult {
    public ListBucketVersions listBucketVersions;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.listBucketVersions = new ListBucketVersions();
        try {
            XmlParser.parseListBucketVersions(httpResponse.byteStream(), this.listBucketVersions);
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.POOR_NETWORK.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.SERVERERROR.getCode(), e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        ListBucketVersions listBucketVersions = this.listBucketVersions;
        return listBucketVersions != null ? listBucketVersions.toString() : super.printResult();
    }
}
