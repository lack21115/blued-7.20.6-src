package com.tencent.cos.xml.model.ci;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.BucketDocumentPreviewState;
import com.tencent.cos.xml.model.tag.GetBucketDPState;
import com.tencent.qcloud.core.http.HttpResponse;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/GetBucketDPStateResult.class */
public class GetBucketDPStateResult extends CosXmlResult {
    private BucketDocumentPreviewState bucketDocumentPreviewState;

    public BucketDocumentPreviewState getDocumentPreviewState() {
        return this.bucketDocumentPreviewState;
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlClientException, CosXmlServiceException {
        super.parseResponseBody(httpResponse);
        try {
            this.bucketDocumentPreviewState = ((GetBucketDPState) QCloudXml.fromXml(httpResponse.byteStream(), GetBucketDPState.class)).DocBucketList;
        } catch (IOException | XmlPullParserException e) {
            throw new CosXmlServiceException("Parse xml error", e);
        }
    }
}
