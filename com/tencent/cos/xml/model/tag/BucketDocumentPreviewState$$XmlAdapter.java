package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/BucketDocumentPreviewState$$XmlAdapter.class */
public class BucketDocumentPreviewState$$XmlAdapter implements IXmlAdapter<BucketDocumentPreviewState> {
    private HashMap<String, ChildElementBinder<BucketDocumentPreviewState>> childElementBinders;

    public BucketDocumentPreviewState$$XmlAdapter() {
        HashMap<String, ChildElementBinder<BucketDocumentPreviewState>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Name", new ChildElementBinder<BucketDocumentPreviewState>() { // from class: com.tencent.cos.xml.model.tag.BucketDocumentPreviewState$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, BucketDocumentPreviewState bucketDocumentPreviewState, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                bucketDocumentPreviewState.Name = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreateTime", new ChildElementBinder<BucketDocumentPreviewState>() { // from class: com.tencent.cos.xml.model.tag.BucketDocumentPreviewState$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, BucketDocumentPreviewState bucketDocumentPreviewState, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                bucketDocumentPreviewState.CreateTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Region", new ChildElementBinder<BucketDocumentPreviewState>() { // from class: com.tencent.cos.xml.model.tag.BucketDocumentPreviewState$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, BucketDocumentPreviewState bucketDocumentPreviewState, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                bucketDocumentPreviewState.Region = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("BucketId", new ChildElementBinder<BucketDocumentPreviewState>() { // from class: com.tencent.cos.xml.model.tag.BucketDocumentPreviewState$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, BucketDocumentPreviewState bucketDocumentPreviewState, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                bucketDocumentPreviewState.BucketId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public BucketDocumentPreviewState fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        BucketDocumentPreviewState bucketDocumentPreviewState = new BucketDocumentPreviewState();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return bucketDocumentPreviewState;
            }
            if (i == 2) {
                ChildElementBinder<BucketDocumentPreviewState> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, bucketDocumentPreviewState, null);
                }
            } else if (i == 3) {
                if ((str == null ? "BucketDocumentPreviewState" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return bucketDocumentPreviewState;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, BucketDocumentPreviewState bucketDocumentPreviewState, String str) throws IOException, XmlPullParserException {
        if (bucketDocumentPreviewState == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "BucketDocumentPreviewState";
        }
        xmlSerializer.startTag("", str2);
        if (bucketDocumentPreviewState.Name != null) {
            xmlSerializer.startTag("", "Name");
            xmlSerializer.text(String.valueOf(bucketDocumentPreviewState.Name));
            xmlSerializer.endTag("", "Name");
        }
        if (bucketDocumentPreviewState.CreateTime != null) {
            xmlSerializer.startTag("", "CreateTime");
            xmlSerializer.text(String.valueOf(bucketDocumentPreviewState.CreateTime));
            xmlSerializer.endTag("", "CreateTime");
        }
        if (bucketDocumentPreviewState.Region != null) {
            xmlSerializer.startTag("", "Region");
            xmlSerializer.text(String.valueOf(bucketDocumentPreviewState.Region));
            xmlSerializer.endTag("", "Region");
        }
        if (bucketDocumentPreviewState.BucketId != null) {
            xmlSerializer.startTag("", "BucketId");
            xmlSerializer.text(String.valueOf(bucketDocumentPreviewState.BucketId));
            xmlSerializer.endTag("", "BucketId");
        }
        xmlSerializer.endTag("", str2);
    }
}
