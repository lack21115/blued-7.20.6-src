package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse;
import com.tencent.qcloud.qcloudxml.core.ChildElementBinder;
import com.tencent.qcloud.qcloudxml.core.IXmlAdapter;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetAudioAuditJobResponse$AudioAuditScenarioInfo$$XmlAdapter.class */
public class GetAudioAuditJobResponse$AudioAuditScenarioInfo$$XmlAdapter implements IXmlAdapter<GetAudioAuditJobResponse.AudioAuditScenarioInfo> {
    private HashMap<String, ChildElementBinder<GetAudioAuditJobResponse.AudioAuditScenarioInfo>> childElementBinders;

    public GetAudioAuditJobResponse$AudioAuditScenarioInfo$$XmlAdapter() {
        HashMap<String, ChildElementBinder<GetAudioAuditJobResponse.AudioAuditScenarioInfo>> hashMap = new HashMap<>();
        this.childElementBinders = hashMap;
        hashMap.put("HitFlag", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditScenarioInfo$$XmlAdapter.1
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditScenarioInfo audioAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditScenarioInfo.hitFlag = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Score", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditScenarioInfo$$XmlAdapter.2
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditScenarioInfo audioAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditScenarioInfo.score = Integer.parseInt(xmlPullParser.getText());
            }
        });
        this.childElementBinders.put("Label", new ChildElementBinder<GetAudioAuditJobResponse.AudioAuditScenarioInfo>() { // from class: com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse$AudioAuditScenarioInfo$$XmlAdapter.3
            @Override // com.tencent.qcloud.qcloudxml.core.ChildElementBinder
            public void fromXml(XmlPullParser xmlPullParser, GetAudioAuditJobResponse.AudioAuditScenarioInfo audioAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
                xmlPullParser.next();
                audioAuditScenarioInfo.label = xmlPullParser.getText();
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public GetAudioAuditJobResponse.AudioAuditScenarioInfo fromXml(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        GetAudioAuditJobResponse.AudioAuditScenarioInfo audioAuditScenarioInfo = new GetAudioAuditJobResponse.AudioAuditScenarioInfo();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i = eventType;
            if (i == 1) {
                return audioAuditScenarioInfo;
            }
            if (i == 2) {
                ChildElementBinder<GetAudioAuditJobResponse.AudioAuditScenarioInfo> childElementBinder = this.childElementBinders.get(xmlPullParser.getName());
                if (childElementBinder != null) {
                    childElementBinder.fromXml(xmlPullParser, audioAuditScenarioInfo, null);
                }
            } else if (i == 3) {
                if ((str == null ? "AudioAuditScenarioInfo" : str).equalsIgnoreCase(xmlPullParser.getName())) {
                    return audioAuditScenarioInfo;
                }
            } else {
                continue;
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // com.tencent.qcloud.qcloudxml.core.IXmlAdapter
    public void toXml(XmlSerializer xmlSerializer, GetAudioAuditJobResponse.AudioAuditScenarioInfo audioAuditScenarioInfo, String str) throws IOException, XmlPullParserException {
        if (audioAuditScenarioInfo == null) {
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "AudioAuditScenarioInfo";
        }
        xmlSerializer.startTag("", str2);
        xmlSerializer.startTag("", "HitFlag");
        xmlSerializer.text(String.valueOf(audioAuditScenarioInfo.hitFlag));
        xmlSerializer.endTag("", "HitFlag");
        xmlSerializer.startTag("", "Score");
        xmlSerializer.text(String.valueOf(audioAuditScenarioInfo.score));
        xmlSerializer.endTag("", "Score");
        if (audioAuditScenarioInfo.label != null) {
            xmlSerializer.startTag("", "Label");
            xmlSerializer.text(String.valueOf(audioAuditScenarioInfo.label));
            xmlSerializer.endTag("", "Label");
        }
        xmlSerializer.endTag("", str2);
    }
}
