package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/PutBucketDPState$$XmlAdapter.class */
public class PutBucketDPState$$XmlAdapter implements IXmlAdapter<PutBucketDPState> {
    private HashMap<String, ChildElementBinder<PutBucketDPState>> childElementBinders;

    public PutBucketDPState$$XmlAdapter() {
        HashMap<String, ChildElementBinder<PutBucketDPState>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("RequestId", new ChildElementBinder<PutBucketDPState>() { // from class: com.tencent.cos.xml.model.tag.PutBucketDPState$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PutBucketDPState putBucketDPState, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                putBucketDPState.RequestId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DocBucket", new ChildElementBinder<PutBucketDPState>() { // from class: com.tencent.cos.xml.model.tag.PutBucketDPState$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, PutBucketDPState putBucketDPState, String str) throws IOException, XmlPullParserException {
                putBucketDPState.DocBucket = (BucketDocumentPreviewState) QCloudXml.fromXml(xmlPullParser, BucketDocumentPreviewState.class, "DocBucket");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public PutBucketDPState fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        PutBucketDPState putBucketDPState = new PutBucketDPState();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return putBucketDPState;
            }
            if (i == 2) {
                ChildElementBinder<PutBucketDPState> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, putBucketDPState, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Response" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return putBucketDPState;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, PutBucketDPState putBucketDPState, String str) throws IOException, XmlPullParserException {
        if (putBucketDPState == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Response";
        }
        xmlSerializer.startTag("", str2);
        if (putBucketDPState.RequestId != null) {
            xmlSerializer.startTag("", "RequestId");
            xmlSerializer.text(String.valueOf(putBucketDPState.RequestId));
            xmlSerializer.endTag("", "RequestId");
        }
        if (putBucketDPState.DocBucket != null) {
            QCloudXml.toXml(xmlSerializer, putBucketDPState.DocBucket, "DocBucket");
        }
        xmlSerializer.endTag("", str2);
    }
}
