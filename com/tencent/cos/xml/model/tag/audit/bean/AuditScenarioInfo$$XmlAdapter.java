package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/AuditScenarioInfo$$XmlAdapter.class */
public class AuditScenarioInfo$$XmlAdapter implements IXmlAdapter<AuditScenarioInfo> {
    private HashMap<String, ChildElementBinder<AuditScenarioInfo>> childElementBinders;

    public AuditScenarioInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<AuditScenarioInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("HitFlag", new ChildElementBinder<AuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditScenarioInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditScenarioInfo auditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditScenarioInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Count", new ChildElementBinder<AuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditScenarioInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditScenarioInfo auditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditScenarioInfo.count = Integer.parseInt(xmlPullParser.getText());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public AuditScenarioInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        AuditScenarioInfo auditScenarioInfo = new AuditScenarioInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return auditScenarioInfo;
            }
            if (i == 2) {
                ChildElementBinder<AuditScenarioInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, auditScenarioInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "AuditScenarioInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return auditScenarioInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, AuditScenarioInfo auditScenarioInfo, String str) throws IOException, XmlPullParserException {
        if (auditScenarioInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "AuditScenarioInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(auditScenarioInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Count");
        xmlSerializer.text(String.valueOf(auditScenarioInfo.count));
        xmlSerializer.endTag("", "Count");
        xmlSerializer.endTag("", str2);
    }
}
