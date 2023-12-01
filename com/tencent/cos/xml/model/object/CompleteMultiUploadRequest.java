package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.CompleteMultipartUpload;
import com.tencent.cos.xml.transfer.XmlSlimBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/CompleteMultiUploadRequest.class */
public final class CompleteMultiUploadRequest extends BaseMultipartUploadRequest {
    private CompleteMultipartUpload completeMultipartUpload;
    private String uploadId;

    public CompleteMultiUploadRequest(String str, String str2, String str3, Map<Integer, String> map) {
        super(str, str2);
        this.uploadId = str3;
        CompleteMultipartUpload completeMultipartUpload = new CompleteMultipartUpload();
        this.completeMultipartUpload = completeMultipartUpload;
        completeMultipartUpload.parts = new ArrayList();
        setPartNumberAndETag(map);
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.requestURL == null && this.uploadId == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "uploadID must not be null");
        }
    }

    public CompleteMultipartUpload getCompleteMultipartUpload() {
        return this.completeMultipartUpload;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public int getPriority() {
        return 3;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("uploadId", this.uploadId);
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.bytes("application/xml", XmlSlimBuilder.buildCompleteMultipartUpload(this.completeMultipartUpload).getBytes("utf-8"));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setPartNumberAndETag(int i, String str) {
        CompleteMultipartUpload.Part part = new CompleteMultipartUpload.Part();
        part.partNumber = i;
        part.eTag = str;
        this.completeMultipartUpload.parts.add(part);
    }

    public void setPartNumberAndETag(Map<Integer, String> map) {
        if (map != null) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                CompleteMultipartUpload.Part part = new CompleteMultipartUpload.Part();
                part.partNumber = entry.getKey().intValue();
                part.eTag = entry.getValue();
                this.completeMultipartUpload.parts.add(part);
            }
        }
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
