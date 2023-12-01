package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/UploadPartCopyRequest.class */
public class UploadPartCopyRequest extends CopyObjectRequest {
    private int partNumber;
    private String uploadId;

    public UploadPartCopyRequest(String str, String str2, int i, String str3, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlClientException {
        this(str, str2, i, str3, copySourceStruct, -1L, -1L);
    }

    public UploadPartCopyRequest(String str, String str2, int i, String str3, CopyObjectRequest.CopySourceStruct copySourceStruct, long j, long j2) {
        super(str, str2, copySourceStruct);
        this.partNumber = -1;
        this.uploadId = null;
        this.partNumber = i;
        this.uploadId = str3;
        setCopyRange(j, j2);
    }

    @Override // com.tencent.cos.xml.model.object.CopyObjectRequest, com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.requestURL != null) {
            return;
        }
        if (this.partNumber <= 0) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "partNumber must be >= 1");
        }
        if (this.uploadId == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "uploadID must not be null");
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("partNumber", String.valueOf(this.partNumber));
        this.queryParameters.put("uploadId", this.uploadId);
        return super.getQueryString();
    }

    public void setCopyRange(long j, long j2) {
        if (j < 0 || j2 < j) {
            return;
        }
        addHeader("x-cos-copy-source-range", "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2);
    }
}
