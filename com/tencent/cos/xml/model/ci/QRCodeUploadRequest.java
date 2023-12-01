package com.tencent.cos.xml.model.ci;

import android.net.Uri;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.pic.PicOperationRule;
import com.tencent.cos.xml.model.tag.pic.PicOperations;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/QRCodeUploadRequest.class */
public class QRCodeUploadRequest extends ImageUploadRequest {
    private int cover;
    public String fileId;
    public String saveBucket;

    protected QRCodeUploadRequest(String str, String str2) {
        super(str, str2);
        this.cover = 0;
    }

    public QRCodeUploadRequest(String str, String str2, Uri uri) {
        super(str, str2, uri);
        this.cover = 0;
    }

    public QRCodeUploadRequest(String str, String str2, InputStream inputStream) {
        super(str, str2, inputStream);
        this.cover = 0;
    }

    public QRCodeUploadRequest(String str, String str2, String str3) {
        super(str, str2, str3);
        this.cover = 0;
    }

    public QRCodeUploadRequest(String str, String str2, StringBuilder sb) {
        super(str, str2, sb);
        this.cover = 0;
    }

    public QRCodeUploadRequest(String str, String str2, URL url) {
        super(str, str2, url);
        this.cover = 0;
    }

    public QRCodeUploadRequest(String str, String str2, byte[] bArr) {
        super(str, str2, bArr);
        this.cover = 0;
    }

    @Override // com.tencent.cos.xml.model.ci.ImageUploadRequest, com.tencent.cos.xml.model.object.PutObjectRequest, com.tencent.cos.xml.model.object.BasePutObjectRequest, com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        int i = this.cover;
        if (i == 0 || i == 1) {
            return;
        }
        int code = ClientErrorCode.INVALID_ARGUMENT.getCode();
        throw new CosXmlClientException(code, "cover can not be " + this.cover);
    }

    @Override // com.tencent.cos.xml.model.ci.PicOperationProvider
    public PicOperations getPicOperations() {
        PicOperationRule picOperationRule = new PicOperationRule("QRcode/cover/" + this.cover);
        picOperationRule.setBucket(this.saveBucket);
        picOperationRule.setFileId(this.fileId);
        return new PicOperations(this.isPicInfo, Collections.singletonList(picOperationRule));
    }

    public void setCover(int i) {
        this.cover = i;
    }
}
