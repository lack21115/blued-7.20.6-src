package com.tencent.cos.xml.model.ci;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.object.ObjectRequest;
import com.tencent.cos.xml.model.tag.pic.PicOperationRule;
import com.tencent.cos.xml.model.tag.pic.PicOperations;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Collections;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/FormatConversionRequest.class */
public class FormatConversionRequest extends ObjectRequest {
    public String fileId;
    private final String format;
    public String saveBucket;

    public FormatConversionRequest(String str, String str2, String str3) {
        super(str, str2);
        this.format = str3;
        setQueryEncodedString("image_process");
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        PicOperations picOperations = getPicOperations();
        if (picOperations != null) {
            addHeader("Pic-Operations", picOperations.toJsonStr());
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    public PicOperations getPicOperations() {
        PicOperationRule picOperationRule = new PicOperationRule("imageView2/format/" + this.format);
        picOperationRule.setBucket(this.saveBucket);
        picOperationRule.setFileId(this.fileId);
        return new PicOperations(false, Collections.singletonList(picOperationRule));
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return RequestBodySerializer.string("text/plain", "");
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public boolean headersHasUnsafeNonAscii() {
        return true;
    }
}
