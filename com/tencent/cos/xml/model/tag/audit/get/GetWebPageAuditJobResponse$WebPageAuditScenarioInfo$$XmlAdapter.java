package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$WebPageAuditScenarioInfo$$XmlAdapter.class */
public class GetWebPageAuditJobResponse$WebPageAuditScenarioInfo$$XmlAdapter implements IXmlAdapter<GetWebPageAuditJobResponse.WebPageAuditScenarioInfo> {
    private HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditScenarioInfo>> childElementBinders;

    public GetWebPageAuditJobResponse$WebPageAuditScenarioInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditScenarioInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("HitFlag", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditScenarioInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditScenarioInfo webPageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditScenarioInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$WebPageAuditScenarioInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.WebPageAuditScenarioInfo webPageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                webPageAuditScenarioInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetWebPageAuditJobResponse.WebPageAuditScenarioInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetWebPageAuditJobResponse.WebPageAuditScenarioInfo webPageAuditScenarioInfo = new GetWebPageAuditJobResponse.WebPageAuditScenarioInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return webPageAuditScenarioInfo;
            }
            if (i == 2) {
                ChildElementBinder<GetWebPageAuditJobResponse.WebPageAuditScenarioInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, webPageAuditScenarioInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "WebPageAuditScenarioInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return webPageAuditScenarioInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetWebPageAuditJobResponse.WebPageAuditScenarioInfo webPageAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
        if (webPageAuditScenarioInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "WebPageAuditScenarioInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(webPageAuditScenarioInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(webPageAuditScenarioInfo.score));
        xmlSerializer.endTag("", "Score");
        xmlSerializer.endTag("", str2);
    }
}
