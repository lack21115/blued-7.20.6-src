package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$DocumentAuditScenarioInfo$$XmlAdapter.class */
public class GetDocumentAuditJobResponse$DocumentAuditScenarioInfo$$XmlAdapter implements IXmlAdapter<GetDocumentAuditJobResponse.DocumentAuditScenarioInfo> {
    private HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditScenarioInfo>> childElementBinders;

    public GetDocumentAuditJobResponse$DocumentAuditScenarioInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditScenarioInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("HitFlag", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditScenarioInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditScenarioInfo documentAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditScenarioInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$DocumentAuditScenarioInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.DocumentAuditScenarioInfo documentAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                documentAuditScenarioInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetDocumentAuditJobResponse.DocumentAuditScenarioInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetDocumentAuditJobResponse.DocumentAuditScenarioInfo documentAuditScenarioInfo = new GetDocumentAuditJobResponse.DocumentAuditScenarioInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return documentAuditScenarioInfo;
            }
            if (i == 2) {
                ChildElementBinder<GetDocumentAuditJobResponse.DocumentAuditScenarioInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, documentAuditScenarioInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "DocumentAuditScenarioInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return documentAuditScenarioInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetDocumentAuditJobResponse.DocumentAuditScenarioInfo documentAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
        if (documentAuditScenarioInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "DocumentAuditScenarioInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(documentAuditScenarioInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(documentAuditScenarioInfo.score));
        xmlSerializer.endTag("", "Score");
        xmlSerializer.endTag("", str2);
    }
}
