package com.tencent.cos.xml.model.ci;

import com.baidu.mobads.sdk.internal.a;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.cos.xml.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/PreviewDocumentInHtmlRequest.class */
public class PreviewDocumentInHtmlRequest extends GetObjectRequest {
    public PreviewDocumentInHtmlRequest(String str, String str2, String str3) {
        this(str, str2, str3, StringUtils.extractNameNoSuffix(str2));
    }

    public PreviewDocumentInHtmlRequest(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.queryParameters.put("ci-process", "doc-preview");
        this.queryParameters.put("dstType", a.f);
    }

    @Override // com.tencent.cos.xml.model.object.GetObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    public PreviewDocumentInHtmlRequest setCopyable(boolean z) {
        this.queryParameters.put("copyable", z ? "1" : "0");
        return this;
    }

    public PreviewDocumentInHtmlRequest setWatermark(String str) {
        try {
            this.queryParameters.put("htmlwaterword", DigestUtils.getSecurityBase64(str));
            return this;
        } catch (CosXmlClientException e) {
            e.printStackTrace();
            return this;
        }
    }

    public PreviewDocumentInHtmlRequest setWatermarkColor(String str) {
        try {
            this.queryParameters.put("htmlfillstyle", DigestUtils.getSecurityBase64(str));
            return this;
        } catch (CosXmlClientException e) {
            e.printStackTrace();
            return this;
        }
    }

    public PreviewDocumentInHtmlRequest setWatermarkFont(String str) {
        try {
            this.queryParameters.put("htmlfront", DigestUtils.getSecurityBase64(str));
            return this;
        } catch (CosXmlClientException e) {
            e.printStackTrace();
            return this;
        }
    }

    public PreviewDocumentInHtmlRequest setWatermarkHorizontal(int i) {
        this.queryParameters.put("htmlhorizontal", String.valueOf(i));
        return this;
    }

    public PreviewDocumentInHtmlRequest setWatermarkRotate(int i) {
        this.queryParameters.put("htmlrotate", String.valueOf(i));
        return this;
    }

    public PreviewDocumentInHtmlRequest setWatermarkVertical(int i) {
        this.queryParameters.put("htmlvertical", String.valueOf(i));
        return this;
    }
}
