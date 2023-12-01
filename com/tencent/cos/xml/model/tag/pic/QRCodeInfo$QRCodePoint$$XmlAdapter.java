package com.tencent.cos.xml.model.tag.pic;

import com.tencent.cos.xml.model.tag.pic.QRCodeInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/QRCodeInfo$QRCodePoint$$XmlAdapter.class */
public class QRCodeInfo$QRCodePoint$$XmlAdapter implements IXmlAdapter<QRCodeInfo.QRCodePoint> {
    private HashMap<String, ChildElementBinder<QRCodeInfo.QRCodePoint>> childElementBinders;

    public QRCodeInfo$QRCodePoint$$XmlAdapter() {
        HashMap<String, ChildElementBinder<QRCodeInfo.QRCodePoint>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Point", new ChildElementBinder<QRCodeInfo.QRCodePoint>() { // from class: com.tencent.cos.xml.model.tag.pic.QRCodeInfo$QRCodePoint$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeInfo.QRCodePoint qRCodePoint, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qRCodePoint.point = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public QRCodeInfo.QRCodePoint fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        QRCodeInfo.QRCodePoint qRCodePoint = new QRCodeInfo.QRCodePoint();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return qRCodePoint;
            }
            if (i == 2) {
                ChildElementBinder<QRCodeInfo.QRCodePoint> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, qRCodePoint, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Point" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return qRCodePoint;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, QRCodeInfo.QRCodePoint qRCodePoint, String str) throws IOException, XmlPullParserException {
        if (qRCodePoint == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Point";
        }
        xmlSerializer.startTag("", str2);
        if (qRCodePoint.point != null) {
            xmlSerializer.text(String.valueOf(qRCodePoint.point));
        }
        xmlSerializer.endTag("", str2);
    }
}
