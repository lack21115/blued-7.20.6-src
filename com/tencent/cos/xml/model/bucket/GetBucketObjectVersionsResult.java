package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.BeaconService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListVersionResult;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/GetBucketObjectVersionsResult.class */
public class GetBucketObjectVersionsResult extends CosXmlResult {
    private static final String TAG = "GetBucketObjectVersionsResult";
    public ListVersionResult listVersionResult;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlClientException, CosXmlServiceException {
        super.parseResponseBody(httpResponse);
        this.listVersionResult = new ListVersionResult();
        try {
            XmlParser.parseGetBucketObjectVersionsResult(httpResponse.byteStream(), this.listVersionResult);
        } catch (IOException e) {
            BeaconService.getInstance().reportError(TAG, e);
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            BeaconService.getInstance().reportError(TAG, e2);
            e2.printStackTrace();
        }
    }
}
