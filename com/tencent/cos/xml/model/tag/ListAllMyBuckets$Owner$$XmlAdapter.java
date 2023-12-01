package com.tencent.cos.xml.model.tag;

import com.opos.acs.st.STManager;
import com.tencent.cos.xml.model.tag.ListAllMyBuckets;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner$$XmlAdapter.class */
public class ListAllMyBuckets$Owner$$XmlAdapter implements IXmlAdapter<ListAllMyBuckets.Owner> {
    private HashMap<String, ChildElementBinder<ListAllMyBuckets.Owner>> childElementBinders;

    public ListAllMyBuckets$Owner$$XmlAdapter() {
        HashMap<String, ChildElementBinder<ListAllMyBuckets.Owner>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put(STManager.REGION_OF_ID, new ChildElementBinder<ListAllMyBuckets.Owner>() { // from class: com.tencent.cos.xml.model.tag.ListAllMyBuckets$Owner$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ListAllMyBuckets.Owner owner, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                owner.id = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DisplayName", new ChildElementBinder<ListAllMyBuckets.Owner>() { // from class: com.tencent.cos.xml.model.tag.ListAllMyBuckets$Owner$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ListAllMyBuckets.Owner owner, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                owner.disPlayName = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public ListAllMyBuckets.Owner fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        ListAllMyBuckets.Owner owner = new ListAllMyBuckets.Owner();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return owner;
            }
            if (i == 2) {
                ChildElementBinder<ListAllMyBuckets.Owner> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, owner, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Owner" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return owner;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, ListAllMyBuckets.Owner owner, String str) throws IOException, XmlPullParserException {
        if (owner == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Owner";
        }
        xmlSerializer.startTag("", str2);
        if (owner.id != null) {
            xmlSerializer.startTag("", STManager.REGION_OF_ID);
            xmlSerializer.text(String.valueOf(owner.id));
            xmlSerializer.endTag("", STManager.REGION_OF_ID);
        }
        if (owner.disPlayName != null) {
            xmlSerializer.startTag("", "DisplayName");
            xmlSerializer.text(String.valueOf(owner.disPlayName));
            xmlSerializer.endTag("", "DisplayName");
        }
        xmlSerializer.endTag("", str2);
    }
}
