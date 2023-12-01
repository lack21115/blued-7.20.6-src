package com.tencent.cos.xml.model.tag;

import com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/DescribeMediaBucketsResult$$XmlAdapter.class */
public class DescribeMediaBucketsResult$$XmlAdapter implements IXmlAdapter<DescribeMediaBucketsResult> {
    private HashMap<String, ChildElementBinder<DescribeMediaBucketsResult>> childElementBinders;

    public DescribeMediaBucketsResult$$XmlAdapter() {
        HashMap<String, ChildElementBinder<DescribeMediaBucketsResult>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("RequestId", new ChildElementBinder<DescribeMediaBucketsResult>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult describeMediaBucketsResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                describeMediaBucketsResult.requestId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("TotalCount", new ChildElementBinder<DescribeMediaBucketsResult>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult describeMediaBucketsResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                describeMediaBucketsResult.totalCount = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PageNumber", new ChildElementBinder<DescribeMediaBucketsResult>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult describeMediaBucketsResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                describeMediaBucketsResult.pageNumber = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("PageSize", new ChildElementBinder<DescribeMediaBucketsResult>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult describeMediaBucketsResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                describeMediaBucketsResult.pageSize = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("MediaBucketList", new ChildElementBinder<DescribeMediaBucketsResult>() { // from class: com.tencent.cos.xml.model.tag.DescribeMediaBucketsResult$$XmlAdapter.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, DescribeMediaBucketsResult describeMediaBucketsResult, String str) throws IOException, XmlPullParserException {
                if (describeMediaBucketsResult.mediaBucketList == null) {
                    describeMediaBucketsResult.mediaBucketList = new ArrayList();
                }
                describeMediaBucketsResult.mediaBucketList.add(QCloudXml.fromXml(xmlPullParser, DescribeMediaBucketsResult.MediaBucketList.class, "MediaBucketList"));
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public DescribeMediaBucketsResult fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        DescribeMediaBucketsResult describeMediaBucketsResult = new DescribeMediaBucketsResult();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return describeMediaBucketsResult;
            }
            if (i == 2) {
                ChildElementBinder<DescribeMediaBucketsResult> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, describeMediaBucketsResult, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return describeMediaBucketsResult;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, DescribeMediaBucketsResult describeMediaBucketsResult, String str) throws IOException, XmlPullParserException {
        if (describeMediaBucketsResult == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (describeMediaBucketsResult.requestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(describeMediaBucketsResult.requestId));
            xmlSerializer.endTag("", "RequestId");
        }
        xmlSerializer.startTag("", "TotalCount");
        xmlSerializer.text(String.valueOf(describeMediaBucketsResult.totalCount));
        xmlSerializer.endTag("", "TotalCount");
        xmlSerializer.startTag("", "PageNumber");
        xmlSerializer.text(String.valueOf(describeMediaBucketsResult.pageNumber));
        xmlSerializer.endTag("", "PageNumber");
        xmlSerializer.startTag("", "PageSize");
        xmlSerializer.text(String.valueOf(describeMediaBucketsResult.pageSize));
        xmlSerializer.endTag("", "PageSize");
        xmlSerializer.startTag("", "MediaBucketList");
        if (describeMediaBucketsResult.mediaBucketList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= describeMediaBucketsResult.mediaBucketList.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, describeMediaBucketsResult.mediaBucketList.get(i2), "MediaBucketList");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "MediaBucketList");
        xmlSerializer.endTag("", str2);
    }
}
