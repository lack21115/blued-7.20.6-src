package com.tencent.cos.xml.model.tag;

import com.google.common.net.HttpHeaders;
import com.tencent.cos.xml.model.tag.pic.ImageInfo;
import com.tencent.cos.xml.model.tag.pic.PicObject;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/CompleteMultipartUploadResult$$XmlAdapter.class */
public class CompleteMultipartUploadResult$$XmlAdapter implements IXmlAdapter<CompleteMultipartUploadResult> {
    private HashMap<String, ChildElementBinder<CompleteMultipartUploadResult>> childElementBinders;

    public CompleteMultipartUploadResult$$XmlAdapter() {
        HashMap<String, ChildElementBinder<CompleteMultipartUploadResult>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Key", new ChildElementBinder<CompleteMultipartUploadResult>() { // from class: com.tencent.cos.xml.model.tag.CompleteMultipartUploadResult$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, CompleteMultipartUploadResult completeMultipartUploadResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                completeMultipartUploadResult.key = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put(HttpHeaders.LOCATION, new ChildElementBinder<CompleteMultipartUploadResult>() { // from class: com.tencent.cos.xml.model.tag.CompleteMultipartUploadResult$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, CompleteMultipartUploadResult completeMultipartUploadResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                completeMultipartUploadResult.location = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("ETag", new ChildElementBinder<CompleteMultipartUploadResult>() { // from class: com.tencent.cos.xml.model.tag.CompleteMultipartUploadResult$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, CompleteMultipartUploadResult completeMultipartUploadResult, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                completeMultipartUploadResult.eTag = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("ImageInfo", new ChildElementBinder<CompleteMultipartUploadResult>() { // from class: com.tencent.cos.xml.model.tag.CompleteMultipartUploadResult$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, CompleteMultipartUploadResult completeMultipartUploadResult, String str) throws IOException, XmlPullParserException {
                completeMultipartUploadResult.imageInfo = (ImageInfo) QCloudXml.fromXml(xmlPullParser, ImageInfo.class, "ImageInfo");
            }
        });
        this.childElementBinders.put("ProcessResults", new ChildElementBinder<CompleteMultipartUploadResult>() { // from class: com.tencent.cos.xml.model.tag.CompleteMultipartUploadResult$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, CompleteMultipartUploadResult completeMultipartUploadResult, String str) throws IOException, XmlPullParserException {
                if (completeMultipartUploadResult.processResults == null) {
                    completeMultipartUploadResult.processResults = new ArrayList();
                }
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    int i = eventType;
                    if (i == 1) {
                        return;
                    }
                    if (i == 2) {
                        completeMultipartUploadResult.processResults.add(QCloudXml.fromXml(xmlPullParser, PicObject.class, "Object"));
                    } else if (i == 3 && "ProcessResults".equalsIgnoreCase(xmlPullParser.getName())) {
                        return;
                    }
                    eventType = xmlPullParser.next();
                }
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public CompleteMultipartUploadResult fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        CompleteMultipartUploadResult completeMultipartUploadResult = new CompleteMultipartUploadResult();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return completeMultipartUploadResult;
            }
            if (i == 2) {
                ChildElementBinder<CompleteMultipartUploadResult> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, completeMultipartUploadResult, null);
                }
            } else if (i == 3) {
                if ((str == null ? "CompleteMultipartUploadResult" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return completeMultipartUploadResult;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, CompleteMultipartUploadResult completeMultipartUploadResult, String str) throws IOException, XmlPullParserException {
        if (completeMultipartUploadResult == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "CompleteMultipartUploadResult";
        }
        xmlSerializer.startTag("", str2);
        if (completeMultipartUploadResult.key != null) {
            xmlSerializer.startTag("", "Key");
            xmlSerializer.text(String.valueOf(completeMultipartUploadResult.key));
            xmlSerializer.endTag("", "Key");
        }
        if (completeMultipartUploadResult.location != null) {
            xmlSerializer.startTag("", HttpHeaders.LOCATION);
            xmlSerializer.text(String.valueOf(completeMultipartUploadResult.location));
            xmlSerializer.endTag("", HttpHeaders.LOCATION);
        }
        if (completeMultipartUploadResult.eTag != null) {
            xmlSerializer.startTag("", "ETag");
            xmlSerializer.text(String.valueOf(completeMultipartUploadResult.eTag));
            xmlSerializer.endTag("", "ETag");
        }
        if (completeMultipartUploadResult.imageInfo != null) {
            QCloudXml.toXml(xmlSerializer, completeMultipartUploadResult.imageInfo, "ImageInfo");
        }
        xmlSerializer.startTag("", "ProcessResults");
        if (completeMultipartUploadResult.processResults != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= completeMultipartUploadResult.processResults.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, completeMultipartUploadResult.processResults.get(i2), "ProcessResults");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "ProcessResults");
        xmlSerializer.endTag("", str2);
    }
}
