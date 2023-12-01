package com.tencent.cos.xml.model.ci;

import com.tencent.cos.xml.model.ci.QRCodeUploadResult;
import com.tencent.cos.xml.model.tag.pic.PicOriginalInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/QRCodeUploadResult$PicUploadResult$$XmlAdapter.class */
public class QRCodeUploadResult$PicUploadResult$$XmlAdapter implements IXmlAdapter<QRCodeUploadResult.PicUploadResult> {
    private HashMap<String, ChildElementBinder<QRCodeUploadResult.PicUploadResult>> childElementBinders;

    public QRCodeUploadResult$PicUploadResult$$XmlAdapter() {
        HashMap<String, ChildElementBinder<QRCodeUploadResult.PicUploadResult>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("OriginalInfo", new ChildElementBinder<QRCodeUploadResult.PicUploadResult>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$PicUploadResult$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.PicUploadResult picUploadResult, String str) throws IOException, XmlPullParserException {
                picUploadResult.originalInfo = (PicOriginalInfo) QCloudXml.fromXml(xmlPullParser, PicOriginalInfo.class, "OriginalInfo");
            }
        });
        this.childElementBinders.put("ProcessResults", new ChildElementBinder<QRCodeUploadResult.PicUploadResult>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$PicUploadResult$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.PicUploadResult picUploadResult, String str) throws IOException, XmlPullParserException {
                if (picUploadResult.processResults == null) {
                    picUploadResult.processResults = new ArrayList();
                }
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    int i = eventType;
                    if (i == 1) {
                        return;
                    }
                    if (i == 2) {
                        picUploadResult.processResults.add(QCloudXml.fromXml(xmlPullParser, QRCodeUploadResult.QrPicObject.class, "Object"));
                    } else if (i == 3 && "ProcessResults".equalsIgnoreCase(xmlPullParser.getName())) {
                        return;
                    }
                    eventType = xmlPullParser.next();
                }
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public QRCodeUploadResult.PicUploadResult fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        QRCodeUploadResult.PicUploadResult picUploadResult = new QRCodeUploadResult.PicUploadResult();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return picUploadResult;
            }
            if (i == 2) {
                ChildElementBinder<QRCodeUploadResult.PicUploadResult> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, picUploadResult, null);
                }
            } else if (i == 3) {
                if ((str == null ? "UploadResult" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return picUploadResult;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, QRCodeUploadResult.PicUploadResult picUploadResult, String str) throws IOException, XmlPullParserException {
        if (picUploadResult == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "UploadResult";
        }
        xmlSerializer.startTag("", str2);
        if (picUploadResult.originalInfo != null) {
            QCloudXml.toXml(xmlSerializer, picUploadResult.originalInfo, "OriginalInfo");
        }
        xmlSerializer.startTag("", "ProcessResults");
        if (picUploadResult.processResults != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= picUploadResult.processResults.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, picUploadResult.processResults.get(i2), "ProcessResults");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "ProcessResults");
        xmlSerializer.endTag("", str2);
    }
}
