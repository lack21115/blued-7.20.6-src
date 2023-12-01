package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/AuditJobsDetail$$XmlAdapter.class */
public class AuditJobsDetail$$XmlAdapter implements IXmlAdapter<AuditJobsDetail> {
    private HashMap<String, ChildElementBinder<AuditJobsDetail>> childElementBinders;

    public AuditJobsDetail$$XmlAdapter() {
        HashMap<String, ChildElementBinder<AuditJobsDetail>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("Code", new ChildElementBinder<AuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditJobsDetail.code = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Message", new ChildElementBinder<AuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditJobsDetail.message = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Result", new ChildElementBinder<AuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditJobsDetail.result = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<AuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditJobsDetail.label = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("JobId", new ChildElementBinder<AuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail$$XmlAdapter.5
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditJobsDetail.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("State", new ChildElementBinder<AuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail$$XmlAdapter.6
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditJobsDetail.state = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationTime", new ChildElementBinder<AuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail$$XmlAdapter.7
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditJobsDetail.creationTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<AuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail$$XmlAdapter.8
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                auditJobsDetail.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public AuditJobsDetail fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        AuditJobsDetail auditJobsDetail = new AuditJobsDetail();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return auditJobsDetail;
            }
            if (i == 2) {
                ChildElementBinder<AuditJobsDetail> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, auditJobsDetail, null);
                }
            } else if (i == 3) {
                if ((str == null ? "JobsDetail" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return auditJobsDetail;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, AuditJobsDetail auditJobsDetail, String str) throws IOException, XmlPullParserException {
        if (auditJobsDetail == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "JobsDetail";
        }
        xmlSerializer.startTag("", str2);
        if (auditJobsDetail.code != null) {
            xmlSerializer.startTag("", "Code");
            xmlSerializer.text(String.valueOf(auditJobsDetail.code));
            xmlSerializer.endTag("", "Code");
        }
        if (auditJobsDetail.message != null) {
            xmlSerializer.startTag("", "Message");
            xmlSerializer.text(String.valueOf(auditJobsDetail.message));
            xmlSerializer.endTag("", "Message");
        }
        if (auditJobsDetail.result != null) {
            xmlSerializer.startTag("", "Result");
            xmlSerializer.text(String.valueOf(auditJobsDetail.result));
            xmlSerializer.endTag("", "Result");
        }
        if (auditJobsDetail.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(auditJobsDetail.label));
            xmlSerializer.endTag("", "Label");
        }
        if (auditJobsDetail.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(auditJobsDetail.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        if (auditJobsDetail.state != null) {
            xmlSerializer.startTag("", "State");
            xmlSerializer.text(String.valueOf(auditJobsDetail.state));
            xmlSerializer.endTag("", "State");
        }
        if (auditJobsDetail.creationTime != null) {
            xmlSerializer.startTag("", "CreationTime");
            xmlSerializer.text(String.valueOf(auditJobsDetail.creationTime));
            xmlSerializer.endTag("", "CreationTime");
        }
        if (auditJobsDetail.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(auditJobsDetail.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
