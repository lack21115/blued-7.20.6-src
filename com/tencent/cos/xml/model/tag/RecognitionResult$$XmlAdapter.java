package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.RecognitionResult;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RecognitionResult$$XmlAdapter.class */
public class RecognitionResult$$XmlAdapter implements IXmlAdapter<RecognitionResult> {
    private HashMap<String, ChildElementBinder<RecognitionResult>> childElementBinders;

    public RecognitionResult$$XmlAdapter() {
        HashMap<String, ChildElementBinder<RecognitionResult>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobId", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                recognitionResult.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                recognitionResult.result = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                recognitionResult.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                recognitionResult.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                recognitionResult.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Text", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                recognitionResult.text = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CompressionResult", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                recognitionResult.compressionResult = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                recognitionResult.pornInfo = (RecognitionResult.PornInfo) QCloudXml.fromXml(xmlPullParser, RecognitionResult.PornInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.9
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                recognitionResult.politicsInfo = (RecognitionResult.PoliticsInfo) QCloudXml.fromXml(xmlPullParser, RecognitionResult.PoliticsInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("TerroristInfo", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.10
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                recognitionResult.terroristInfo = (RecognitionResult.TerroristInfo) QCloudXml.fromXml(xmlPullParser, RecognitionResult.TerroristInfo.class, "TerroristInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<RecognitionResult>() { // from class: com.tencent.cos.xml.model.tag.RecognitionResult$$XmlAdapter.11
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
                recognitionResult.adsInfo = (RecognitionResult.AdsInfo) QCloudXml.fromXml(xmlPullParser, RecognitionResult.AdsInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public RecognitionResult fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        RecognitionResult recognitionResult = new RecognitionResult();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return recognitionResult;
            }
            if (i == 2) {
                ChildElementBinder<RecognitionResult> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, recognitionResult, null);
                }
            } else if (i == 3) {
                if ((str == null ? "RecognitionResult" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return recognitionResult;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, RecognitionResult recognitionResult, String str) throws IOException, XmlPullParserException {
        if (recognitionResult == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "RecognitionResult";
        }
        xmlSerializer.startTag("", str2);
        if (recognitionResult.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(recognitionResult.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        xmlSerializer.startTag("", "Result");
        xmlSerializer.text(String.valueOf(recognitionResult.result));
        xmlSerializer.endTag("", "Result");
        if (recognitionResult.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(recognitionResult.label));
            xmlSerializer.endTag("", "Label");
        }
        if (recognitionResult.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(recognitionResult.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(recognitionResult.score));
        xmlSerializer.endTag("", "Score");
        if (recognitionResult.text != null) {
            xmlSerializer.startTag("", "Text");
            xmlSerializer.text(String.valueOf(recognitionResult.text));
            xmlSerializer.endTag("", "Text");
        }
        xmlSerializer.startTag("", "CompressionResult");
        xmlSerializer.text(String.valueOf(recognitionResult.compressionResult));
        xmlSerializer.endTag("", "CompressionResult");
        if (recognitionResult.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, recognitionResult.pornInfo, "PornInfo");
        }
        if (recognitionResult.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, recognitionResult.politicsInfo, "PoliticsInfo");
        }
        if (recognitionResult.terroristInfo != null) {
            QCloudXml.toXml(xmlSerializer, recognitionResult.terroristInfo, "TerroristInfo");
        }
        if (recognitionResult.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, recognitionResult.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
