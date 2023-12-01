package com.tencent.cos.xml.model.ci;

import com.baidu.mobads.sdk.internal.a;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.object.ObjectRequest;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.qcloud.core.http.RequestBodySerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/PreviewDocumentInHtmlBytesRequest.class */
public class PreviewDocumentInHtmlBytesRequest extends ObjectRequest {
    public PreviewDocumentInHtmlBytesRequest(String str, String str2) {
        super(str, str2);
        this.queryParameters.put("ci-process", "doc-preview");
        this.queryParameters.put("dstType", a.f);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return null;
    }

    public PreviewDocumentInHtmlBytesRequest setCopyable(boolean z) {
        this.queryParameters.put("copyable", z ? "1" : "0");
        return this;
    }

    public PreviewDocumentInHtmlBytesRequest setWatermark(String str) {
        try {
            this.queryParameters.put("htmlwaterword", DigestUtils.getSecurityBase64(str));
            return this;
        } catch (CosXmlClientException e) {
            e.printStackTrace();
            return this;
        }
    }

    public PreviewDocumentInHtmlBytesRequest setWatermarkColor(String str) {
        try {
            this.queryParameters.put("htmlfillstyle", DigestUtils.getSecurityBase64(str));
            return this;
        } catch (CosXmlClientException e) {
            e.printStackTrace();
            return this;
        }
    }

    public PreviewDocumentInHtmlBytesRequest setWatermarkFont(String str) {
        try {
            this.queryParameters.put("htmlfront", DigestUtils.getSecurityBase64(str));
            return this;
        } catch (CosXmlClientException e) {
            e.printStackTrace();
            return this;
        }
    }

    public PreviewDocumentInHtmlBytesRequest setWatermarkHorizontal(int i) {
        this.queryParameters.put("htmlhorizontal", String.valueOf(i));
        return this;
    }

    public PreviewDocumentInHtmlBytesRequest setWatermarkRotate(int i) {
        this.queryParameters.put("htmlrotate", String.valueOf(i));
        return this;
    }

    public PreviewDocumentInHtmlBytesRequest setWatermarkVertical(int i) {
        this.queryParameters.put("htmlvertical", String.valueOf(i));
        return this;
    }
}
