package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$PageSegment$$XmlAdapter.class */
public class GetDocumentAuditJobResponse$PageSegment$$XmlAdapter implements IXmlAdapter<GetDocumentAuditJobResponse.PageSegment> {
    private HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.PageSegment>> childElementBinders;

    public GetDocumentAuditJobResponse$PageSegment$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetDocumentAuditJobResponse.PageSegment>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Results", new ChildElementBinder<GetDocumentAuditJobResponse.PageSegment>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetDocumentAuditJobResponse$PageSegment$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetDocumentAuditJobResponse.PageSegment pageSegment, String str) throws IOException, XmlPullParserException {
                if (pageSegment.results == null) {
                    pageSegment.results = new ArrayList();
                }
                pageSegment.results.add(QCloudXml.fromXml(xmlPullParser, GetDocumentAuditJobResponse.Results.class, "Results"));
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetDocumentAuditJobResponse.PageSegment fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetDocumentAuditJobResponse.PageSegment pageSegment = new GetDocumentAuditJobResponse.PageSegment();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return pageSegment;
            }
            if (i == 2) {
                ChildElementBinder<GetDocumentAuditJobResponse.PageSegment> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, pageSegment, null);
                }
            } else if (i == 3) {
                if ((str == null ? "PageSegment" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return pageSegment;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetDocumentAuditJobResponse.PageSegment pageSegment, String str) throws IOException, XmlPullParserException {
        if (pageSegment == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "PageSegment";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Results");
        if (pageSegment.results != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pageSegment.results.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, pageSegment.results.get(i2), "Results");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "Results");
        xmlSerializer.endTag("", str2);
    }
}
