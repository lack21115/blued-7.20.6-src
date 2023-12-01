package com.tencent.cos.xml.model.tag.audit.bean;

import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/BaseAuditJobsDetail$$XmlAdapter.class */
public class BaseAuditJobsDetail$$XmlAdapter implements IXmlAdapter<BaseAuditJobsDetail> {
    private HashMap<String, ChildElementBinder<BaseAuditJobsDetail>> childElementBinders;

    public BaseAuditJobsDetail$$XmlAdapter() {
        HashMap<String, ChildElementBinder<BaseAuditJobsDetail>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("JobId", new ChildElementBinder<BaseAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.BaseAuditJobsDetail$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, BaseAuditJobsDetail baseAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                baseAuditJobsDetail.jobId = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("State", new ChildElementBinder<BaseAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.BaseAuditJobsDetail$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, BaseAuditJobsDetail baseAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                baseAuditJobsDetail.state = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("CreationTime", new ChildElementBinder<BaseAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.BaseAuditJobsDetail$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, BaseAuditJobsDetail baseAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                baseAuditJobsDetail.creationTime = xmlPullParser.getText();
            }
        });
        this.childElementBinders.put("DataId", new ChildElementBinder<BaseAuditJobsDetail>() { // from class: com.tencent.cos.xml.model.tag.audit.bean.BaseAuditJobsDetail$$XmlAdapter.4
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, BaseAuditJobsDetail baseAuditJobsDetail, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                baseAuditJobsDetail.dataId = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public BaseAuditJobsDetail fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        BaseAuditJobsDetail baseAuditJobsDetail = new BaseAuditJobsDetail();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return baseAuditJobsDetail;
            }
            if (i == 2) {
                ChildElementBinder<BaseAuditJobsDetail> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, baseAuditJobsDetail, null);
                }
            } else if (i == 3) {
                if ((str == null ? "JobsDetail" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return baseAuditJobsDetail;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, BaseAuditJobsDetail baseAuditJobsDetail, String str) throws IOException, XmlPullParserException {
        if (baseAuditJobsDetail == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "JobsDetail";
        }
        xmlSerializer.startTag("", str2);
        if (baseAuditJobsDetail.jobId != null) {
            xmlSerializer.startTag("", "JobId");
            xmlSerializer.text(String.valueOf(baseAuditJobsDetail.jobId));
            xmlSerializer.endTag("", "JobId");
        }
        if (baseAuditJobsDetail.state != null) {
            xmlSerializer.startTag("", "State");
            xmlSerializer.text(String.valueOf(baseAuditJobsDetail.state));
            xmlSerializer.endTag("", "State");
        }
        if (baseAuditJobsDetail.creationTime != null) {
            xmlSerializer.startTag("", "CreationTime");
            xmlSerializer.text(String.valueOf(baseAuditJobsDetail.creationTime));
            xmlSerializer.endTag("", "CreationTime");
        }
        if (baseAuditJobsDetail.dataId != null) {
            xmlSerializer.startTag("", "DataId");
            xmlSerializer.text(String.valueOf(baseAuditJobsDetail.dataId));
            xmlSerializer.endTag("", "DataId");
        }
        xmlSerializer.endTag("", str2);
    }
}
