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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$PoliticsInfo$$XmlAdapter.class */
public class RecognitionResult$PoliticsInfo$$XmlAdapter implements IXmlAdapter<RecognitionResult.PoliticsInfo> {
    private HashMap<String, ChildElementBinder<RecognitionResult.PoliticsInfo>> childElementBinders;

    public RecognitionResult$PoliticsInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<RecognitionResult.PoliticsInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Code", new ChildElementBinder<RecognitionResult.PoliticsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PoliticsInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PoliticsInfo politicsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                politicsInfo.code = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Msg", new ChildElementBinder<RecognitionResult.PoliticsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PoliticsInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PoliticsInfo politicsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                politicsInfo.msg = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("HitFlag", new ChildElementBinder<RecognitionResult.PoliticsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PoliticsInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PoliticsInfo politicsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                politicsInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<RecognitionResult.PoliticsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PoliticsInfo$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PoliticsInfo politicsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                politicsInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<RecognitionResult.PoliticsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PoliticsInfo$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PoliticsInfo politicsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                politicsInfo.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<RecognitionResult.PoliticsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PoliticsInfo$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PoliticsInfo politicsInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                politicsInfo.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("OcrResults", new ChildElementBinder<RecognitionResult.PoliticsInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PoliticsInfo$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PoliticsInfo politicsInfo, String str) throws IOException, XmlPullParserException {
                politicsInfo.ocrResults = (AuditOcrResults) QCloudXml.fromXml(xmlPullParser, AuditOcrResults.class, "OcrResults");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public RecognitionResult.PoliticsInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        RecognitionResult.PoliticsInfo politicsInfo = new RecognitionResult.PoliticsInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return politicsInfo;
            }
            if (i == 2) {
                ChildElementBinder<RecognitionResult.PoliticsInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, politicsInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "PoliticsInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return politicsInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, RecognitionResult.PoliticsInfo politicsInfo, String str) throws IOException, XmlPullParserException {
        if (politicsInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "PoliticsInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Code");
        xmlSerializer.text(String.valueOf(politicsInfo.code));
        xmlSerializer.endTag("", "Code");
        if (politicsInfo.msg != null) {
            xmlSerializer.startTag("", "Msg");
            xmlSerializer.text(String.valueOf(politicsInfo.msg));
            xmlSerializer.endTag("", "Msg");
        }
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(politicsInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(politicsInfo.score));
        xmlSerializer.endTag("", "Score");
        if (politicsInfo.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(politicsInfo.label));
            xmlSerializer.endTag("", "Label");
        }
        if (politicsInfo.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(politicsInfo.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        if (politicsInfo.ocrResults != null) {
            QCloudXml.toXml(xmlSerializer, politicsInfo.ocrResults, "OcrResults");
        }
        xmlSerializer.endTag("", str2);
    }
}
