package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$TextResults$$XmlAdapter.class */
public class GetWebPageAuditJobResponse$TextResults$$XmlAdapter implements IXmlAdapter<GetWebPageAuditJobResponse.TextResults> {
    private HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.TextResults>> childElementBinders;

    public GetWebPageAuditJobResponse$TextResults$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.TextResults>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Results", new ChildElementBinder<GetWebPageAuditJobResponse.TextResults>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$TextResults$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.TextResults textResults, String str) throws IOException, XmlPullParserException {
                if (textResults.results == null) {
                    textResults.results = new ArrayList();
                }
                textResults.results.add(QCloudXml.fromXml(xmlPullParser, GetWebPageAuditJobResponse.TextResult.class, "Results"));
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetWebPageAuditJobResponse.TextResults fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetWebPageAuditJobResponse.TextResults textResults = new GetWebPageAuditJobResponse.TextResults();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return textResults;
            }
            if (i == 2) {
                ChildElementBinder<GetWebPageAuditJobResponse.TextResults> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, textResults, null);
                }
            } else if (i == 3) {
                if ((str == null ? "TextResults" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return textResults;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetWebPageAuditJobResponse.TextResults textResults, String str) throws IOException, XmlPullParserException {
        if (textResults == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "TextResults";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Results");
        if (textResults.results != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= textResults.results.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, textResults.results.get(i2), "Results");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "Results");
        xmlSerializer.endTag("", str2);
    }
}
