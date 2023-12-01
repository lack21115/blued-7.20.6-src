package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.RefererConfiguration;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/RefererConfiguration$Domain$$XmlAdapter.class */
public class RefererConfiguration$Domain$$XmlAdapter implements IXmlAdapter<RefererConfiguration.Domain> {
    private HashMap<String, ChildElementBinder<RefererConfiguration.Domain>> childElementBinders;

    public RefererConfiguration$Domain$$XmlAdapter() {
        HashMap<String, ChildElementBinder<RefererConfiguration.Domain>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Domain", new ChildElementBinder<RefererConfiguration.Domain>() { // from class: com.tencent.cos.xml.model.tag.RefererConfiguration$Domain$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, RefererConfiguration.Domain domain, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                domain.domain = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public RefererConfiguration.Domain fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        RefererConfiguration.Domain domain = new RefererConfiguration.Domain();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return domain;
            }
            if (i == 2) {
                ChildElementBinder<RefererConfiguration.Domain> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, domain, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Domain" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return domain;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, RefererConfiguration.Domain domain, String str) throws IOException, XmlPullParserException {
        if (domain == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Domain";
        }
        xmlSerializer.startTag("", str2);
        if (domain.domain != null) {
            xmlSerializer.text(String.valueOf(domain.domain));
        }
        xmlSerializer.endTag("", str2);
    }
}
