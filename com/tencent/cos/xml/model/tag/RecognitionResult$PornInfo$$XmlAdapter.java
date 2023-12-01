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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$PornInfo$$XmlAdapter.class */
public class RecognitionResult$PornInfo$$XmlAdapter implements IXmlAdapter<RecognitionResult.PornInfo> {
    private HashMap<String, ChildElementBinder<RecognitionResult.PornInfo>> childElementBinders;

    public RecognitionResult$PornInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<RecognitionResult.PornInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Code", new ChildElementBinder<RecognitionResult.PornInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PornInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PornInfo pornInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                pornInfo.code = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Msg", new ChildElementBinder<RecognitionResult.PornInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PornInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PornInfo pornInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                pornInfo.msg = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("HitFlag", new ChildElementBinder<RecognitionResult.PornInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PornInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PornInfo pornInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                pornInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<RecognitionResult.PornInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PornInfo$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PornInfo pornInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                pornInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<RecognitionResult.PornInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PornInfo$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PornInfo pornInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                pornInfo.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<RecognitionResult.PornInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PornInfo$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PornInfo pornInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                pornInfo.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("OcrResults", new ChildElementBinder<RecognitionResult.PornInfo>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$PornInfo$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult.PornInfo pornInfo, String str) throws IOException, XmlPullParserException {
                pornInfo.ocrResults = (AuditOcrResults) QCloudXml.fromXml(xmlPullParser, AuditOcrResults.class, "OcrResults");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public RecognitionResult.PornInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        RecognitionResult.PornInfo pornInfo = new RecognitionResult.PornInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return pornInfo;
            }
            if (i == 2) {
                ChildElementBinder<RecognitionResult.PornInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, pornInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "PornInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return pornInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, RecognitionResult.PornInfo pornInfo, String str) throws IOException, XmlPullParserException {
        if (pornInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "PornInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Code");
        xmlSerializer.text(String.valueOf(pornInfo.code));
        xmlSerializer.endTag("", "Code");
        if (pornInfo.msg != null) {
            xmlSerializer.startTag("", "Msg");
            xmlSerializer.text(String.valueOf(pornInfo.msg));
            xmlSerializer.endTag("", "Msg");
        }
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(pornInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(pornInfo.score));
        xmlSerializer.endTag("", "Score");
        if (pornInfo.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(pornInfo.label));
            xmlSerializer.endTag("", "Label");
        }
        if (pornInfo.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(pornInfo.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        if (pornInfo.ocrResults != null) {
            QCloudXml.toXml(xmlSerializer, pornInfo.ocrResults, "OcrResults");
        }
        xmlSerializer.endTag("", str2);
    }
}
