package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/GetBucketDPState$$XmlAdapter.class */
public class GetBucketDPState$$XmlAdapter implements IXmlAdapter<GetBucketDPState> {
    private HashMap<String, ChildElementBinder<GetBucketDPState>> childElementBinders;

    public GetBucketDPState$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetBucketDPState>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("RequestId", new ChildElementBinder<GetBucketDPState>() { // from class: com.tencent.cos.xml.model.tag.GetBucketDPState$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetBucketDPState getBucketDPState, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                getBucketDPState.RequestId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DocBucketList", new ChildElementBinder<GetBucketDPState>() { // from class: com.tencent.cos.xml.model.tag.GetBucketDPState$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetBucketDPState getBucketDPState, String str) throws IOException, XmlPullParserException {
                getBucketDPState.DocBucketList = (BucketDocumentPreviewState) QCloudXml.fromXml(xmlPullParser, BucketDocumentPreviewState.class, "DocBucketList");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetBucketDPState fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetBucketDPState getBucketDPState = new GetBucketDPState();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return getBucketDPState;
            }
            if (i == 2) {
                ChildElementBinder<GetBucketDPState> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, getBucketDPState, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return getBucketDPState;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetBucketDPState getBucketDPState, String str) throws IOException, XmlPullParserException {
        if (getBucketDPState == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (getBucketDPState.RequestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(getBucketDPState.RequestId));
            xmlSerializer.endTag("", "RequestId");
        }
        if (getBucketDPState.DocBucketList != null) {
            QCloudXml.toXml(xmlSerializer, getBucketDPState.DocBucketList, "DocBucketList");
        }
        xmlSerializer.endTag("", str2);
    }
}
