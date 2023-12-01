package com.tencent.cos.xml.model.tag;

import com.google.common.net.HttpHeaders;
import com.tencent.cos.xml.model.tag.ListAllMyBuckets;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket$$XmlAdapter.class */
public class ListAllMyBuckets$Bucket$$XmlAdapter implements IXmlAdapter<ListAllMyBuckets.Bucket> {
    private HashMap<String, ChildElementBinder<ListAllMyBuckets.Bucket>> childElementBinders;

    public ListAllMyBuckets$Bucket$$XmlAdapter() {
        HashMap<String, ChildElementBinder<ListAllMyBuckets.Bucket>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Name", new ChildElementBinder<ListAllMyBuckets.Bucket>() { // from class: com.tencent.cos.xml.model.tag.ListAllMyBuckets$Bucket$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ListAllMyBuckets.Bucket bucket, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                bucket.name = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put(HttpHeaders.LOCATION, new ChildElementBinder<ListAllMyBuckets.Bucket>() { // from class: com.tencent.cos.xml.model.tag.ListAllMyBuckets$Bucket$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ListAllMyBuckets.Bucket bucket, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                bucket.location = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationDate", new ChildElementBinder<ListAllMyBuckets.Bucket>() { // from class: com.tencent.cos.xml.model.tag.ListAllMyBuckets$Bucket$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ListAllMyBuckets.Bucket bucket, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                bucket.createDate = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Type", new ChildElementBinder<ListAllMyBuckets.Bucket>() { // from class: com.tencent.cos.xml.model.tag.ListAllMyBuckets$Bucket$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, ListAllMyBuckets.Bucket bucket, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                bucket.type = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public ListAllMyBuckets.Bucket fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        ListAllMyBuckets.Bucket bucket = new ListAllMyBuckets.Bucket();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return bucket;
            }
            if (i == 2) {
                ChildElementBinder<ListAllMyBuckets.Bucket> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, bucket, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Bucket" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return bucket;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, ListAllMyBuckets.Bucket bucket, String str) throws IOException, XmlPullParserException {
        if (bucket == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Bucket";
        }
        xmlSerializer.startTag("", str2);
        if (bucket.name != null) {
            xmlSerializer.startTag("", "Name");
            xmlSerializer.text(String.valueOf(bucket.name));
            xmlSerializer.endTag("", "Name");
        }
        if (bucket.location != null) {
            xmlSerializer.startTag("", HttpHeaders.LOCATION);
            xmlSerializer.text(String.valueOf(bucket.location));
            xmlSerializer.endTag("", HttpHeaders.LOCATION);
        }
        if (bucket.createDate != null) {
            xmlSerializer.startTag("", "CreationDate");
            xmlSerializer.text(String.valueOf(bucket.createDate));
            xmlSerializer.endTag("", "CreationDate");
        }
        if (bucket.type != null) {
            xmlSerializer.startTag("", "Type");
            xmlSerializer.text(String.valueOf(bucket.type));
            xmlSerializer.endTag("", "Type");
        }
        xmlSerializer.endTag("", str2);
    }
}
