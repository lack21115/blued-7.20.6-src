package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.qcloud.core.auth.STSCredentialScope;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/BaseMultipartUploadRequest.class */
public abstract class BaseMultipartUploadRequest extends UploadRequest {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMultipartUploadRequest(String str, String str2) {
        super(str, str2);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public STSCredentialScope[] getSTSCredentialScope(CosXmlServiceConfig cosXmlServiceConfig) {
        STSCredentialScope[] sTSCredentialScopeArr = new STSCredentialScope[5];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= 5) {
                return sTSCredentialScopeArr;
            }
            sTSCredentialScopeArr[i3] = new STSCredentialScope(new String[]{"name/cos:InitiateMultipartUpload", "name/cos:ListParts", "name/cos:UploadPart", "name/cos:CompleteMultipartUpload", "name/cos:AbortMultipartUpload"}[i], cosXmlServiceConfig.getBucket(this.bucket), cosXmlServiceConfig.getRegion(), getPath(cosXmlServiceConfig));
            i++;
            i2 = i3 + 1;
        }
    }
}
