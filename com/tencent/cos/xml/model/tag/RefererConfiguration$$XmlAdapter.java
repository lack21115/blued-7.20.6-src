package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.RefererConfiguration;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RefererConfiguration$$XmlAdapter.class */
public class RefererConfiguration$$XmlAdapter implements IXmlAdapter<RefererConfiguration> {
    private HashMap<String, ChildElementBinder<RefererConfiguration>> childElementBinders;

    public RefererConfiguration$$XmlAdapter() {
        HashMap<String, ChildElementBinder<RefererConfiguration>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Status", new ChildElementBinder<RefererConfiguration>() { // from class: com.tencent.cos.xml.model.tag.RefererConfiguration$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RefererConfiguration refererConfiguration, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                refererConfiguration.status = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("RefererType", new ChildElementBinder<RefererConfiguration>() { // from class: com.tencent.cos.xml.model.tag.RefererConfiguration$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RefererConfiguration refererConfiguration, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                refererConfiguration.refererType = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DomainList", new ChildElementBinder<RefererConfiguration>() { // from class: com.tencent.cos.xml.model.tag.RefererConfiguration$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RefererConfiguration refererConfiguration, String str) throws IOException, XmlPullParserException {
                if (refererConfiguration.domainList == null) {
                    refererConfiguration.domainList = new ArrayList();
                }
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    int i = eventType;
                    if (i == 1) {
                        return;
                    }
                    if (i == 2) {
                        refererConfiguration.domainList.add(QCloudXml.fromXml(xmlPullParser, RefererConfiguration.Domain.class, "Domain"));
                    } else if (i == 3 && "DomainList".equalsIgnoreCase(xmlPullParser.getName())) {
                        return;
                    }
                    eventType = xmlPullParser.next();
                }
            }
        });
        this.childElementBinders.put("EmptyReferConfiguration", new ChildElementBinder<RefererConfiguration>() { // from class: com.tencent.cos.xml.model.tag.RefererConfiguration$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RefererConfiguration refererConfiguration, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                refererConfiguration.emptyReferConfiguration = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public RefererConfiguration fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        RefererConfiguration refererConfiguration = new RefererConfiguration();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return refererConfiguration;
            }
            if (i == 2) {
                ChildElementBinder<RefererConfiguration> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, refererConfiguration, null);
                }
            } else if (i == 3) {
                if ((str == null ? "RefererConfiguration" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return refererConfiguration;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, RefererConfiguration refererConfiguration, String str) throws IOException, XmlPullParserException {
        if (refererConfiguration == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "RefererConfiguration";
        }
        xmlSerializer.startTag("", str2);
        if (refererConfiguration.status != null) {
            xmlSerializer.startTag("", "Status");
            xmlSerializer.text(String.valueOf(refererConfiguration.status));
            xmlSerializer.endTag("", "Status");
        }
        if (refererConfiguration.refererType != null) {
            xmlSerializer.startTag("", "RefererType");
            xmlSerializer.text(String.valueOf(refererConfiguration.refererType));
            xmlSerializer.endTag("", "RefererType");
        }
        xmlSerializer.startTag("", "DomainList");
        if (refererConfiguration.domainList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= refererConfiguration.domainList.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, refererConfiguration.domainList.get(i2), "DomainList");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "DomainList");
        if (refererConfiguration.emptyReferConfiguration != null) {
            xmlSerializer.startTag("", "EmptyReferConfiguration");
            xmlSerializer.text(String.valueOf(refererConfiguration.emptyReferConfiguration));
            xmlSerializer.endTag("", "EmptyReferConfiguration");
        }
        xmlSerializer.endTag("", str2);
    }
}
