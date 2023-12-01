package com.tencent.cos.xml.model.ci;

import com.google.common.net.HttpHeaders;
import com.tencent.cos.xml.model.ci.QRCodeUploadResult;
import com.tencent.cos.xml.model.tag.pic.QRCodeInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/QRCodeUploadResult$QrPicObject$$XmlAdapter.class */
public class QRCodeUploadResult$QrPicObject$$XmlAdapter implements IXmlAdapter<QRCodeUploadResult.QrPicObject> {
    private HashMap<String, ChildElementBinder<QRCodeUploadResult.QrPicObject>> childElementBinders;

    public QRCodeUploadResult$QrPicObject$$XmlAdapter() {
        HashMap<String, ChildElementBinder<QRCodeUploadResult.QrPicObject>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("CodeStatus", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.codeStatus = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("QRcodeInfo", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                if (qrPicObject.qrCodeInfo == null) {
                    qrPicObject.qrCodeInfo = new ArrayList();
                }
                qrPicObject.qrCodeInfo.add(QCloudXml.fromXml(xmlPullParser, QRCodeInfo.class, "QRcodeInfo"));
            }
        });
        this.childElementBinders.put("Key", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.key = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put(HttpHeaders.LOCATION, new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.location = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Format", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.format = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Width", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.width = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Height", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.height = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Size", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.size = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Quality", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.quality = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("ETag", new ChildElementBinder<QRCodeUploadResult.QrPicObject>() { // from class: com.tencent.cos.xml.model.ci.QRCodeUploadResult$QrPicObject$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qrPicObject.etag = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public QRCodeUploadResult.QrPicObject fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        QRCodeUploadResult.QrPicObject qrPicObject = new QRCodeUploadResult.QrPicObject();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return qrPicObject;
            }
            if (i == 2) {
                ChildElementBinder<QRCodeUploadResult.QrPicObject> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, qrPicObject, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Object" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return qrPicObject;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, QRCodeUploadResult.QrPicObject qrPicObject, String str) throws IOException, XmlPullParserException {
        if (qrPicObject == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Object";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "CodeStatus");
        xmlSerializer.text(String.valueOf(qrPicObject.codeStatus));
        xmlSerializer.endTag("", "CodeStatus");
        xmlSerializer.startTag("", "QRcodeInfo");
        if (qrPicObject.qrCodeInfo != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= qrPicObject.qrCodeInfo.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, qrPicObject.qrCodeInfo.get(i2), "QRcodeInfo");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "QRcodeInfo");
        if (qrPicObject.key != null) {
            xmlSerializer.startTag("", "Key");
            xmlSerializer.text(String.valueOf(qrPicObject.key));
            xmlSerializer.endTag("", "Key");
        }
        if (qrPicObject.location != null) {
            xmlSerializer.startTag("", HttpHeaders.LOCATION);
            xmlSerializer.text(String.valueOf(qrPicObject.location));
            xmlSerializer.endTag("", HttpHeaders.LOCATION);
        }
        if (qrPicObject.format != null) {
            xmlSerializer.startTag("", "Format");
            xmlSerializer.text(String.valueOf(qrPicObject.format));
            xmlSerializer.endTag("", "Format");
        }
        xmlSerializer.startTag("", "Width");
        xmlSerializer.text(String.valueOf(qrPicObject.width));
        xmlSerializer.endTag("", "Width");
        xmlSerializer.startTag("", "Height");
        xmlSerializer.text(String.valueOf(qrPicObject.height));
        xmlSerializer.endTag("", "Height");
        xmlSerializer.startTag("", "Size");
        xmlSerializer.text(String.valueOf(qrPicObject.size));
        xmlSerializer.endTag("", "Size");
        xmlSerializer.startTag("", "Quality");
        xmlSerializer.text(String.valueOf(qrPicObject.quality));
        xmlSerializer.endTag("", "Quality");
        if (qrPicObject.etag != null) {
            xmlSerializer.startTag("", "ETag");
            xmlSerializer.text(String.valueOf(qrPicObject.etag));
            xmlSerializer.endTag("", "ETag");
        }
        xmlSerializer.endTag("", str2);
    }
}
