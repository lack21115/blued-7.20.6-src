package com.tencent.cos.xml.model.ci;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.tag.pic.PicObject;
import com.tencent.cos.xml.model.tag.pic.PicOriginalInfo;
import com.tencent.cos.xml.model.tag.pic.QRCodeInfo;
import com.tencent.qcloud.core.http.HttpResponse;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/QRCodeUploadResult.class */
public class QRCodeUploadResult extends ImageUploadResult {
    public PicUploadResult picUploadResult;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/QRCodeUploadResult$PicUploadResult.class */
    public static class PicUploadResult {
        public PicOriginalInfo originalInfo;
        public List<QrPicObject> processResults;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/QRCodeUploadResult$QrPicObject.class */
    public static class QrPicObject extends PicObject {
        public int codeStatus;
        public List<QRCodeInfo> qrCodeInfo;
    }

    public PicUploadResult getPicUploadResult() {
        return this.picUploadResult;
    }

    @Override // com.tencent.cos.xml.model.ci.ImageUploadResult, com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlClientException, CosXmlServiceException {
        super.parseResponseBody(httpResponse);
        try {
            this.picUploadResult = (PicUploadResult) QCloudXml.fromXml(httpResponse.byteStream(), PicUploadResult.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }
}
