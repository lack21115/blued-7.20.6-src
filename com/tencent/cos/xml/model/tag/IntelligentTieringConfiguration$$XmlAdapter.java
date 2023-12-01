package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.IntelligentTieringConfiguration;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/IntelligentTieringConfiguration$$XmlAdapter.class */
public class IntelligentTieringConfiguration$$XmlAdapter implements IXmlAdapter<IntelligentTieringConfiguration> {
    private HashMap<String, ChildElementBinder<IntelligentTieringConfiguration>> childElementBinders;

    public IntelligentTieringConfiguration$$XmlAdapter() {
        HashMap<String, ChildElementBinder<IntelligentTieringConfiguration>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Status", new ChildElementBinder<IntelligentTieringConfiguration>() { // from class: com.tencent.cos.xml.model.tag.IntelligentTieringConfiguration$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, IntelligentTieringConfiguration intelligentTieringConfiguration, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                intelligentTieringConfiguration.status = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Transition", new ChildElementBinder<IntelligentTieringConfiguration>() { // from class: com.tencent.cos.xml.model.tag.IntelligentTieringConfiguration$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, IntelligentTieringConfiguration intelligentTieringConfiguration, String str) throws IOException, XmlPullParserException {
                intelligentTieringConfiguration.transition = (IntelligentTieringConfiguration.Transition) QCloudXml.fromXml(xmlPullParser, IntelligentTieringConfiguration.Transition.class, "Transition");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public IntelligentTieringConfiguration fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        IntelligentTieringConfiguration intelligentTieringConfiguration = new IntelligentTieringConfiguration();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return intelligentTieringConfiguration;
            }
            if (i == 2) {
                ChildElementBinder<IntelligentTieringConfiguration> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, intelligentTieringConfiguration, null);
                }
            } else if (i == 3) {
                if ((str == null ? "IntelligentTieringConfiguration" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return intelligentTieringConfiguration;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, IntelligentTieringConfiguration intelligentTieringConfiguration, String str) throws IOException, XmlPullParserException {
        if (intelligentTieringConfiguration == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "IntelligentTieringConfiguration";
        }
        xmlSerializer.startTag("", str2);
        if (intelligentTieringConfiguration.status != null) {
            xmlSerializer.startTag("", "Status");
            xmlSerializer.text(String.valueOf(intelligentTieringConfiguration.status));
            xmlSerializer.endTag("", "Status");
        }
        if (intelligentTieringConfiguration.transition != null) {
            QCloudXml.toXml(xmlSerializer, intelligentTieringConfiguration.transition, "Transition");
        }
        xmlSerializer.endTag("", str2);
    }
}
