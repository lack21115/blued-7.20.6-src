package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.IntelligentTieringConfiguration;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/IntelligentTieringConfiguration$Transition$$XmlAdapter.class */
public class IntelligentTieringConfiguration$Transition$$XmlAdapter implements IXmlAdapter<IntelligentTieringConfiguration.Transition> {
    private HashMap<String, ChildElementBinder<IntelligentTieringConfiguration.Transition>> childElementBinders;

    public IntelligentTieringConfiguration$Transition$$XmlAdapter() {
        HashMap<String, ChildElementBinder<IntelligentTieringConfiguration.Transition>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Days", new ChildElementBinder<IntelligentTieringConfiguration.Transition>() { // from class: com.tencent.cos.xml.model.tag.IntelligentTieringConfiguration$Transition$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, IntelligentTieringConfiguration.Transition transition, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                transition.days = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("RequestFrequent", new ChildElementBinder<IntelligentTieringConfiguration.Transition>() { // from class: com.tencent.cos.xml.model.tag.IntelligentTieringConfiguration$Transition$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, IntelligentTieringConfiguration.Transition transition, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                transition.requestFrequent = Integer.parseInt(xmlPullParser.getText());
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public IntelligentTieringConfiguration.Transition fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        IntelligentTieringConfiguration.Transition transition = new IntelligentTieringConfiguration.Transition();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return transition;
            }
            if (i == 2) {
                ChildElementBinder<IntelligentTieringConfiguration.Transition> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, transition, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Transition" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return transition;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, IntelligentTieringConfiguration.Transition transition, String str) throws IOException, XmlPullParserException {
        if (transition == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Transition";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "Days");
        xmlSerializer.text(String.valueOf(transition.days));
        xmlSerializer.endTag("", "Days");
        xmlSerializer.startTag("", "RequestFrequent");
        xmlSerializer.text(String.valueOf(transition.requestFrequent));
        xmlSerializer.endTag("", "RequestFrequent");
        xmlSerializer.endTag("", str2);
    }
}
