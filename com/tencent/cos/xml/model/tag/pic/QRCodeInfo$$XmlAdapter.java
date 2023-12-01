package com.tencent.cos.xml.model.tag.pic;

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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/QRCodeInfo$$XmlAdapter.class */
public class QRCodeInfo$$XmlAdapter implements IXmlAdapter<QRCodeInfo> {
    private HashMap<String, ChildElementBinder<QRCodeInfo>> childElementBinders;

    public QRCodeInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<QRCodeInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("CodeUrl", new ChildElementBinder<QRCodeInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.QRCodeInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeInfo qRCodeInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                qRCodeInfo.codeUrl = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CodeLocation", new ChildElementBinder<QRCodeInfo>() { // from class: com.tencent.cos.xml.model.tag.pic.QRCodeInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, QRCodeInfo qRCodeInfo, String str) throws IOException, XmlPullParserException {
                if (qRCodeInfo.codeLocation == null) {
                    qRCodeInfo.codeLocation = new ArrayList();
                }
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    int i = eventType;
                    if (i == 1) {
                        return;
                    }
                    if (i == 2) {
                        qRCodeInfo.codeLocation.add(QCloudXml.fromXml(xmlPullParser, QRCodeInfo.QRCodePoint.class, "Point"));
                    } else if (i == 3 && "CodeLocation".equalsIgnoreCase(xmlPullParser.getName())) {
                        return;
                    }
                    eventType = xmlPullParser.next();
                }
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public QRCodeInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        QRCodeInfo qRCodeInfo = new QRCodeInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return qRCodeInfo;
            }
            if (i == 2) {
                ChildElementBinder<QRCodeInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, qRCodeInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "QRcodeInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return qRCodeInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, QRCodeInfo qRCodeInfo, String str) throws IOException, XmlPullParserException {
        if (qRCodeInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "QRcodeInfo";
        }
        xmlSerializer.startTag("", str2);
        if (qRCodeInfo.codeUrl != null) {
            xmlSerializer.startTag("", "CodeUrl");
            xmlSerializer.text(String.valueOf(qRCodeInfo.codeUrl));
            xmlSerializer.endTag("", "CodeUrl");
        }
        xmlSerializer.startTag("", "CodeLocation");
        if (qRCodeInfo.codeLocation != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= qRCodeInfo.codeLocation.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, qRCodeInfo.codeLocation.get(i2), "CodeLocation");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "CodeLocation");
        xmlSerializer.endTag("", str2);
    }
}
