package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.ListAllMyBuckets;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListAllMyBuckets$$XmlAdapter.class */
public class ListAllMyBuckets$$XmlAdapter implements IXmlAdapter<ListAllMyBuckets> {
    private HashMap<String, ChildElementBinder<ListAllMyBuckets>> childElementBinders;

    public ListAllMyBuckets$$XmlAdapter() {
        HashMap<String, ChildElementBinder<ListAllMyBuckets>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Owner", new ChildElementBinder<ListAllMyBuckets>() { // from class: com.tencent.cos.xml.model.tag.ListAllMyBuckets$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ListAllMyBuckets listAllMyBuckets, String str) throws IOException, XmlPullParserException {
                listAllMyBuckets.owner = (ListAllMyBuckets.Owner) QCloudXml.fromXml(xmlPullParser, ListAllMyBuckets.Owner.class, "Owner");
            }
        });
        this.childElementBinders.put("Buckets", new ChildElementBinder<ListAllMyBuckets>() { // from class: com.tencent.cos.xml.model.tag.ListAllMyBuckets$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ListAllMyBuckets listAllMyBuckets, String str) throws IOException, XmlPullParserException {
                if (listAllMyBuckets.buckets == null) {
                    listAllMyBuckets.buckets = new ArrayList();
                }
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    int i = eventType;
                    if (i == 1) {
                        return;
                    }
                    if (i == 2) {
                        listAllMyBuckets.buckets.add(QCloudXml.fromXml(xmlPullParser, ListAllMyBuckets.Bucket.class, "Bucket"));
                    } else if (i == 3 && "Buckets".equalsIgnoreCase(xmlPullParser.getName())) {
                        return;
                    }
                    eventType = xmlPullParser.next();
                }
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public ListAllMyBuckets fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        ListAllMyBuckets listAllMyBuckets = new ListAllMyBuckets();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return listAllMyBuckets;
            }
            if (i == 2) {
                ChildElementBinder<ListAllMyBuckets> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, listAllMyBuckets, null);
                }
            } else if (i == 3) {
                if ((str == null ? "ListAllMyBucketsResult" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return listAllMyBuckets;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, ListAllMyBuckets listAllMyBuckets, String str) throws IOException, XmlPullParserException {
        if (listAllMyBuckets == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "ListAllMyBucketsResult";
        }
        xmlSerializer.startTag("", str2);
        if (listAllMyBuckets.owner != null) {
            QCloudXml.toXml(xmlSerializer, listAllMyBuckets.owner, "Owner");
        }
        xmlSerializer.startTag("", "Buckets");
        if (listAllMyBuckets.buckets != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= listAllMyBuckets.buckets.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, listAllMyBuckets.buckets.get(i2), "Buckets");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "Buckets");
        xmlSerializer.endTag("", str2);
    }
}
