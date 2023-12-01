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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$TerroristInfo$$XmlAdapter.class */
public class RecognitionResult$TerroristInfo$$XmlAdapter implements IXmlAdapter<RecognitionResult.TerroristInfo> {
    private HashMap<String, ChildElementBinder<RecognitionResult.TerroristInfo>> childElementBinders;

    public RecognitionResult$TerroristInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<RecognitionResult.TerroristInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Code", new ChildElementBinder<RecognitionResult.TerroristInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$TerroristInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.TerroristInfo terroristInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                terroristInfo.code = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Msg", new ChildElementBinder<RecognitionResult.TerroristInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$TerroristInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.TerroristInfo terroristInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                terroristInfo.msg = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("HitFlag", new ChildElementBinder<RecognitionResult.TerroristInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$TerroristInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.TerroristInfo terroristInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                terroristInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<RecognitionResult.TerroristInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$TerroristInfo$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.TerroristInfo terroristInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                terroristInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<RecognitionResult.TerroristInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$TerroristInfo$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.TerroristInfo terroristInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                terroristInfo.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<RecognitionResult.TerroristInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$TerroristInfo$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.TerroristInfo terroristInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                terroristInfo.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("OcrResults", new ChildElementBinder<RecognitionResult.TerroristInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$TerroristInfo$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.TerroristInfo terroristInfo, String str) throws IOException, XmlPullParserException {
                terroristInfo.ocrResults = (AuditOcrResults) QCloudXml.fromXml(xmlPullParser, AuditOcrResults.class, "OcrResults");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public RecognitionResult.TerroristInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        RecognitionResult.TerroristInfo terroristInfo = new RecognitionResult.TerroristInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return terroristInfo;
            }
            if (i == 2) {
                ChildElementBinder<RecognitionResult.TerroristInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, terroristInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "TerroristInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return terroristInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, RecognitionResult.TerroristInfo terroristInfo, String str) throws IOException, XmlPullParserException {
        if (terroristInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "TerroristInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Code");
        xmlSerializer.text(String.valueOf(terroristInfo.code));
        xmlSerializer.endTag("", "Code");
        if (terroristInfo.msg != null) {
            xmlSerializer.startTag("", "Msg");
            xmlSerializer.text(String.valueOf(terroristInfo.msg));
            xmlSerializer.endTag("", "Msg");
        }
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(terroristInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(terroristInfo.score));
        xmlSerializer.endTag("", "Score");
        if (terroristInfo.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(terroristInfo.label));
            xmlSerializer.endTag("", "Label");
        }
        if (terroristInfo.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(terroristInfo.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        if (terroristInfo.ocrResults != null) {
            QCloudXml.toXml(xmlSerializer, terroristInfo.ocrResults, "OcrResults");
        }
        xmlSerializer.endTag("", str2);
    }
}
