package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.AuditOcrResults;
import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter.class */
public class GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter implements IXmlAdapter<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo> {
    private HashMap<String, ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo>> childElementBinders;

    public GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Label", new ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo snapshotAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshotAuditScenarioInfo.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("HitFlag", new ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo snapshotAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshotAuditScenarioInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo snapshotAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshotAuditScenarioInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("SubLabel", new ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo snapshotAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshotAuditScenarioInfo.subLabel = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("OcrResults", new ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo snapshotAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                if (snapshotAuditScenarioInfo.ocrResults == null) {
                    snapshotAuditScenarioInfo.ocrResults = new ArrayList();
                }
                snapshotAuditScenarioInfo.ocrResults.add(QCloudXml.fromXml(xmlPullParser, AuditOcrResults.class, "OcrResults"));
            }
        });
        this.childElementBinders.put("ObjectResults", new ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$SnapshotAuditScenarioInfo$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo snapshotAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                if (snapshotAuditScenarioInfo.objectResults == null) {
                    snapshotAuditScenarioInfo.objectResults = new ArrayList();
                }
                snapshotAuditScenarioInfo.objectResults.add(QCloudXml.fromXml(xmlPullParser, ImageAuditScenarioInfo.ObjectResults.class, "ObjectResults"));
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetVideoAuditJobResponse.SnapshotAuditScenarioInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetVideoAuditJobResponse.SnapshotAuditScenarioInfo snapshotAuditScenarioInfo = new GetVideoAuditJobResponse.SnapshotAuditScenarioInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return snapshotAuditScenarioInfo;
            }
            if (i == 2) {
                ChildElementBinder<GetVideoAuditJobResponse.SnapshotAuditScenarioInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, snapshotAuditScenarioInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "SnapshotAuditScenarioInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return snapshotAuditScenarioInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo snapshotAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
        if (snapshotAuditScenarioInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "SnapshotAuditScenarioInfo";
        }
        xmlSerializer.startTag("", str2);
        if (snapshotAuditScenarioInfo.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(snapshotAuditScenarioInfo.label));
            xmlSerializer.endTag("", "Label");
        }
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(snapshotAuditScenarioInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(snapshotAuditScenarioInfo.score));
        xmlSerializer.endTag("", "Score");
        if (snapshotAuditScenarioInfo.subLabel != null) {
            xmlSerializer.startTag("", "SubLabel");
            xmlSerializer.text(String.valueOf(snapshotAuditScenarioInfo.subLabel));
            xmlSerializer.endTag("", "SubLabel");
        }
        xmlSerializer.startTag("", "OcrResults");
        if (snapshotAuditScenarioInfo.ocrResults != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= snapshotAuditScenarioInfo.ocrResults.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, snapshotAuditScenarioInfo.ocrResults.get(i2), "OcrResults");
                i = i2 + 1;
            }
        }
        xmlSerializer.endTag("", "OcrResults");
        xmlSerializer.startTag("", "ObjectResults");
        if (snapshotAuditScenarioInfo.objectResults != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= snapshotAuditScenarioInfo.objectResults.size()) {
                    break;
                }
                QCloudXml.toXml(xmlSerializer, snapshotAuditScenarioInfo.objectResults.get(i4), "ObjectResults");
                i3 = i4 + 1;
            }
        }
        xmlSerializer.endTag("", "ObjectResults");
        xmlSerializer.endTag("", str2);
    }
}
