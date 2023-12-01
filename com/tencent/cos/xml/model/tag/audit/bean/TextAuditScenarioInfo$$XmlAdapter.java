package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/TextAuditScenarioInfo$$XmlAdapter.class */
public class TextAuditScenarioInfo$$XmlAdapter implements IXmlAdapter<TextAuditScenarioInfo> {
    private HashMap<String, ChildElementBinder<TextAuditScenarioInfo>> childElementBinders;

    public TextAuditScenarioInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<TextAuditScenarioInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("HitFlag", new ChildElementBinder<TextAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.TextAuditScenarioInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditScenarioInfo textAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditScenarioInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<TextAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.TextAuditScenarioInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditScenarioInfo textAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditScenarioInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Keywords", new ChildElementBinder<TextAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.TextAuditScenarioInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, TextAuditScenarioInfo textAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                textAuditScenarioInfo.keywords = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public TextAuditScenarioInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        TextAuditScenarioInfo textAuditScenarioInfo = new TextAuditScenarioInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return textAuditScenarioInfo;
            }
            if (i == 2) {
                ChildElementBinder<TextAuditScenarioInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, textAuditScenarioInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "TextAuditScenarioInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return textAuditScenarioInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, TextAuditScenarioInfo textAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
        if (textAuditScenarioInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "TextAuditScenarioInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(textAuditScenarioInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(textAuditScenarioInfo.score));
        xmlSerializer.endTag("", "Score");
        if (textAuditScenarioInfo.keywords != null) {
            xmlSerializer.startTag("", "Keywords");
            xmlSerializer.text(String.valueOf(textAuditScenarioInfo.keywords));
            xmlSerializer.endTag("", "Keywords");
        }
        xmlSerializer.endTag("", str2);
    }
}
