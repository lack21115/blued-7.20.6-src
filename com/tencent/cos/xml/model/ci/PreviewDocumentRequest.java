package com.tencent.cos.xml.model.ci;

import com.sina.weibo.sdk.constant.WBPageConstants;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.object.GetObjectRequest;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/PreviewDocumentRequest.class */
public class PreviewDocumentRequest extends GetObjectRequest {
    private int page;

    public PreviewDocumentRequest(String str, String str2, String str3, int i) {
        this(str, str2, str3, i + ".jpg", i);
    }

    public PreviewDocumentRequest(String str, String str2, String str3, String str4, int i) {
        super(str, str2, str3, str4);
        this.queryParameters.put("ci-process", "doc-preview");
        this.page = i;
        this.queryParameters.put(WBPageConstants.ParamKey.PAGE, String.valueOf(i));
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.page < 1) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "Please set a valid page number");
        }
    }

    @Override // com.tencent.cos.xml.model.object.GetObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    public PreviewDocumentRequest setSrcType(String str) {
        this.queryParameters.put("srcType", str);
        return this;
    }
}
