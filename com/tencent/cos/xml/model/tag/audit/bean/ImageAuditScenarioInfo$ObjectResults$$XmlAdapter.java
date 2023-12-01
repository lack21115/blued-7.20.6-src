package com.tencent.cos.xml.model.tag.audit.bean;

import com.google.common.net.HttpHeaders;
import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/ImageAuditScenarioInfo$ObjectResults$$XmlAdapter.class */
public class ImageAuditScenarioInfo$ObjectResults$$XmlAdapter implements IXmlAdapter<ImageAuditScenarioInfo.ObjectResults> {
    private HashMap<String, ChildElementBinder<ImageAuditScenarioInfo.ObjectResults>> childElementBinders;

    public ImageAuditScenarioInfo$ObjectResults$$XmlAdapter() {
        HashMap<String, ChildElementBinder<ImageAuditScenarioInfo.ObjectResults>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Name", new ChildElementBinder<ImageAuditScenarioInfo.ObjectResults>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo$ObjectResults$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditScenarioInfo.ObjectResults objectResults, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                objectResults.name = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put(HttpHeaders.LOCATION, new ChildElementBinder<ImageAuditScenarioInfo.ObjectResults>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo$ObjectResults$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ImageAuditScenarioInfo.ObjectResults objectResults, String str) throws IOException, XmlPullParserException {
                objectResults.location = (AuditOcrLocation) QCloudXml.fromXml(xmlPullParser, AuditOcrLocation.class, HttpHeaders.LOCATION);
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public ImageAuditScenarioInfo.ObjectResults fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        ImageAuditScenarioInfo.ObjectResults objectResults = new ImageAuditScenarioInfo.ObjectResults();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return objectResults;
            }
            if (i == 2) {
                ChildElementBinder<ImageAuditScenarioInfo.ObjectResults> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, objectResults, null);
                }
            } else if (i == 3) {
                if ((str == null ? "ObjectResults" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return objectResults;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, ImageAuditScenarioInfo.ObjectResults objectResults, String str) throws IOException, XmlPullParserException {
        if (objectResults == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "ObjectResults";
        }
        xmlSerializer.startTag("", str2);
        if (objectResults.name != null) {
            xmlSerializer.startTag("", "Name");
            xmlSerializer.text(String.valueOf(objectResults.name));
            xmlSerializer.endTag("", "Name");
        }
        if (objectResults.location != null) {
            QCloudXml.toXml(xmlSerializer, objectResults.location, HttpHeaders.LOCATION);
        }
        xmlSerializer.endTag("", str2);
    }
}
