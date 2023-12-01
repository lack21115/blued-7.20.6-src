package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetVideoAuditJobResponse$Snapshot$$XmlAdapter.class */
public class GetVideoAuditJobResponse$Snapshot$$XmlAdapter implements IXmlAdapter<GetVideoAuditJobResponse.Snapshot> {
    private HashMap<String, ChildElementBinder<GetVideoAuditJobResponse.Snapshot>> childElementBinders;

    public GetVideoAuditJobResponse$Snapshot$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetVideoAuditJobResponse.Snapshot>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Url", new ChildElementBinder<GetVideoAuditJobResponse.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$Snapshot$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshot.url = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("SnapshotTime", new ChildElementBinder<GetVideoAuditJobResponse.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$Snapshot$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshot.snapshotTime = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Text", new ChildElementBinder<GetVideoAuditJobResponse.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$Snapshot$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                snapshot.text = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("PornInfo", new ChildElementBinder<GetVideoAuditJobResponse.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$Snapshot$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                snapshot.pornInfo = (GetVideoAuditJobResponse.SnapshotAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo.class, "PornInfo");
            }
        });
        this.childElementBinders.put("TerrorismInfo", new ChildElementBinder<GetVideoAuditJobResponse.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$Snapshot$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                snapshot.terrorismInfo = (GetVideoAuditJobResponse.SnapshotAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo.class, "TerrorismInfo");
            }
        });
        this.childElementBinders.put("PoliticsInfo", new ChildElementBinder<GetVideoAuditJobResponse.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$Snapshot$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                snapshot.politicsInfo = (GetVideoAuditJobResponse.SnapshotAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo.class, "PoliticsInfo");
            }
        });
        this.childElementBinders.put("AdsInfo", new ChildElementBinder<GetVideoAuditJobResponse.Snapshot>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetVideoAuditJobResponse$Snapshot$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetVideoAuditJobResponse.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
                snapshot.adsInfo = (GetVideoAuditJobResponse.SnapshotAuditScenarioInfo) QCloudXml.fromXml(xmlPullParser, GetVideoAuditJobResponse.SnapshotAuditScenarioInfo.class, "AdsInfo");
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetVideoAuditJobResponse.Snapshot fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetVideoAuditJobResponse.Snapshot snapshot = new GetVideoAuditJobResponse.Snapshot();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return snapshot;
            }
            if (i == 2) {
                ChildElementBinder<GetVideoAuditJobResponse.Snapshot> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, snapshot, null);
                }
            } else if (i == 3) {
                if ((str == null ? "Snapshot" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return snapshot;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetVideoAuditJobResponse.Snapshot snapshot, String str) throws IOException, XmlPullParserException {
        if (snapshot == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "Snapshot";
        }
        xmlSerializer.startTag("", str2);
        if (snapshot.url != null) {
            xmlSerializer.startTag("", "Url");
            xmlSerializer.text(String.valueOf(snapshot.url));
            xmlSerializer.endTag("", "Url");
        }
        xmlSerializer.startTag("", "SnapshotTime");
        xmlSerializer.text(String.valueOf(snapshot.snapshotTime));
        xmlSerializer.endTag("", "SnapshotTime");
        if (snapshot.text != null) {
            xmlSerializer.startTag("", "Text");
            xmlSerializer.text(String.valueOf(snapshot.text));
            xmlSerializer.endTag("", "Text");
        }
        if (snapshot.pornInfo != null) {
            QCloudXml.toXml(xmlSerializer, snapshot.pornInfo, "PornInfo");
        }
        if (snapshot.terrorismInfo != null) {
            QCloudXml.toXml(xmlSerializer, snapshot.terrorismInfo, "TerrorismInfo");
        }
        if (snapshot.politicsInfo != null) {
            QCloudXml.toXml(xmlSerializer, snapshot.politicsInfo, "PoliticsInfo");
        }
        if (snapshot.adsInfo != null) {
            QCloudXml.toXml(xmlSerializer, snapshot.adsInfo, "AdsInfo");
        }
        xmlSerializer.endTag("", str2);
    }
}
