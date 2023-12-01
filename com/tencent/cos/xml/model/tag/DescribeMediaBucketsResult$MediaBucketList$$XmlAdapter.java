package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/DescribeMediaBucketsResult$MediaBucketList$$XmlAdapter.class */
public class DescribeMediaBucketsResult$MediaBucketList$$XmlAdapter implements IXmlAdapter<DescribeMediaBucketsResult.MediaBucketList> {
    private HashMap<String, ChildElementBinder<DescribeMediaBucketsResult.MediaBucketList>> childElementBinders;

    public DescribeMediaBucketsResult$MediaBucketList$$XmlAdapter() {
        HashMap<String, ChildElementBinder<DescribeMediaBucketsResult.MediaBucketList>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("BucketId", new ChildElementBinder<DescribeMediaBucketsResult.MediaBucketList>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$MediaBucketList$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult.MediaBucketList mediaBucketList, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                mediaBucketList.bucketId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Name", new ChildElementBinder<DescribeMediaBucketsResult.MediaBucketList>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$MediaBucketList$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult.MediaBucketList mediaBucketList, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                mediaBucketList.name = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Region", new ChildElementBinder<DescribeMediaBucketsResult.MediaBucketList>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$MediaBucketList$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult.MediaBucketList mediaBucketList, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                mediaBucketList.region = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreateTime", new ChildElementBinder<DescribeMediaBucketsResult.MediaBucketList>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$MediaBucketList$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult.MediaBucketList mediaBucketList, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                mediaBucketList.createTime = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public DescribeMediaBucketsResult.MediaBucketList fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        DescribeMediaBucketsResult.MediaBucketList mediaBucketList = new DescribeMediaBucketsResult.MediaBucketList();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return mediaBucketList;
            }
            if (i == 2) {
                ChildElementBinder<DescribeMediaBucketsResult.MediaBucketList> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, mediaBucketList, null);
                }
            } else if (i == 3) {
                if ((str == null ? "MediaBucketList" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return mediaBucketList;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, DescribeMediaBucketsResult.MediaBucketList mediaBucketList, String str) throws IOException, XmlPullParserException {
        if (mediaBucketList == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "MediaBucketList";
        }
        xmlSerializer.startTag("", str2);
        if (mediaBucketList.bucketId != null) {
            xmlSerializer.startTag("", "BucketId");
            xmlSerializer.text(String.valueOf(mediaBucketList.bucketId));
            xmlSerializer.endTag("", "BucketId");
        }
        if (mediaBucketList.name != null) {
            xmlSerializer.startTag("", "Name");
            xmlSerializer.text(String.valueOf(mediaBucketList.name));
            xmlSerializer.endTag("", "Name");
        }
        if (mediaBucketList.region != null) {
            xmlSerializer.startTag("", "Region");
            xmlSerializer.text(String.valueOf(mediaBucketList.region));
            xmlSerializer.endTag("", "Region");
        }
        if (mediaBucketList.createTime != null) {
            xmlSerializer.startTag("", "CreateTime");
            xmlSerializer.text(String.valueOf(mediaBucketList.createTime));
            xmlSerializer.endTag("", "CreateTime");
        }
        xmlSerializer.endTag("", str2);
    }
}
