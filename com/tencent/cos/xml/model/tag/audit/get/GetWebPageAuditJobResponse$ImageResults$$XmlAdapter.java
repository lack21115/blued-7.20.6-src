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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$ImageResults$$XmlAdapter.class */
public class GetWebPageAuditJobResponse$ImageResults$$XmlAdapter implements IXmlAdapter<GetWebPageAuditJobResponse.ImageResults> {
    private HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.ImageResults>> childElementBinders;

    public GetWebPageAuditJobResponse$ImageResults$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetWebPageAuditJobResponse.ImageResults>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Results", new ChildElementBinder<GetWebPageAuditJobResponse.ImageResults>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetWebPageAuditJobResponse$ImageResults$$XmlAdapter.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetWebPageAuditJobResponse.ImageResults imageResults, String str) throws IOException, XmlPullParserException {
                if (imageResults.results == null) {
                    imageResults.results = new ArrayList();
                }
                imageResults.results.add(QCloudXml.fromXml(xmlPullParser, GetWebPageAuditJobResponse.ImageResult.class, "Results"));
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetWebPageAuditJobResponse.ImageResults fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetWebPageAuditJobResponse.ImageResults imageResults = new GetWebPageAuditJobResponse.ImageResults();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return imageResults;
            }
            if (i == 2) {
                ChildElementBinder<GetWebPageAuditJobResponse.ImageResults> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, imageResults, null);
                }
            } else if (i == 3) {
                if ((str == null ? "ImageResults" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return imageResults;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetWebPageAuditJobResponse.ImageResults imageResults, String str) throws IOException, XmlPullParserException {
        if (imageResults == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "ImageResults";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Results");
        if (imageResults.results != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= imageResults.results.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, imageResults.results.get(i2), "Results");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "Results");
        xmlSerializer.endTag("", str2);
    }
}
