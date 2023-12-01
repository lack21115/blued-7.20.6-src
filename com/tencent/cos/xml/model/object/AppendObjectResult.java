package com.tencent.cos.xml.model.object;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/AppendObjectResult.class */
public final class AppendObjectResult extends CosXmlResult {
    public String eTag;
    public String nextAppendPosition;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.eTag = httpResponse.header(DBDefinition.ETAG);
        this.nextAppendPosition = httpResponse.header(Headers.APPEND_OBJECT_NEXT_POSISTION);
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        return super.printResult() + "\n" + this.eTag + "\n" + this.nextAppendPosition + "\n";
    }
}
