package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.RecognitionResult;
import com.tencent.cos.xml.model.tag.audit.bean.AuditOcrResults;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$AdsInfo$$XmlAdapter.class */
public class RecognitionResult$AdsInfo$$XmlAdapter implements IXmlAdapter<RecognitionResult.AdsInfo> {
    private HashMap<String, ChildElementBinder<RecognitionResult.AdsInfo>> childElementBinders;

    public RecognitionResult$AdsInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<RecognitionResult.AdsInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Code", new ChildElementBinder<RecognitionResult.AdsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$AdsInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.AdsInfo adsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                adsInfo.code = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Msg", new ChildElementBinder<RecognitionResult.AdsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$AdsInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.AdsInfo adsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                adsInfo.msg = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("HitFlag", new ChildElementBinder<RecognitionResult.AdsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$AdsInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.AdsInfo adsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                adsInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<RecognitionResult.AdsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$AdsInfo$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.AdsInfo adsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                adsInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<RecognitionResult.AdsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$AdsInfo$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.AdsInfo adsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                adsInfo.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<RecognitionResult.AdsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$AdsInfo$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.AdsInfo adsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                adsInfo.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("OcrResults", new ChildElementBinder<RecognitionResult.AdsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$AdsInfo$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.AdsInfo adsInfo, String str) throws IOException, XmlPullParserException {
                adsInfo.ocrResults = (AuditOcrResults) QCloudXml.fromXml(xmlPullParser, AuditOcrResults.class, "OcrResults");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public RecognitionResult.AdsInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        RecognitionResult.AdsInfo adsInfo = new RecognitionResult.AdsInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return adsInfo;
            }
            if (i == 2) {
                ChildElementBinder<RecognitionResult.AdsInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, adsInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "AdsInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return adsInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, RecognitionResult.AdsInfo adsInfo, String str) throws IOException, XmlPullParserException {
        if (adsInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "AdsInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Code");
        xmlSerializer.text(String.valueOf(adsInfo.code));
        xmlSerializer.endTag("", "Code");
        if (adsInfo.msg != null) {
            xmlSerializer.startTag("", "Msg");
            xmlSerializer.text(String.valueOf(adsInfo.msg));
            xmlSerializer.endTag("", "Msg");
        }
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(adsInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(adsInfo.score));
        xmlSerializer.endTag("", "Score");
        if (adsInfo.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(adsInfo.label));
            xmlSerializer.endTag("", "Label");
        }
        if (adsInfo.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(adsInfo.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        if (adsInfo.ocrResults != null) {
            QCloudXml.toXml(xmlSerializer, adsInfo.ocrResults, "OcrResults");
        }
        xmlSerializer.endTag("", str2);
    }
}
