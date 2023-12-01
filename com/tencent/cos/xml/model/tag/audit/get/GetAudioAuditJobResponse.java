package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail;
import com.tencent.cos.xml.model.tag.audit.bean.AuditSection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetAudioAuditJobResponse.class */
public class GetAudioAuditJobResponse {
    public AudioAuditJobsDetail jobsDetail;
    public String requestId;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetAudioAuditJobResponse$AudioAuditJobsDetail.class */
    public static class AudioAuditJobsDetail extends AuditJobsDetail {
        public AudioAuditScenarioInfo adsInfo;
        public String audioText;
        public String object;
        public AudioAuditScenarioInfo politicsInfo;
        public AudioAuditScenarioInfo pornInfo;
        public List<AudioSection> section;
        public AudioAuditScenarioInfo terrorismInfo;
        public String url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetAudioAuditJobResponse$AudioAuditScenarioInfo.class */
    public static class AudioAuditScenarioInfo {
        public int hitFlag;
        public String label;
        public int score;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetAudioAuditJobResponse$AudioSection.class */
    public static class AudioSection extends AuditSection {
        public int duration;
        public String label;
        public int offsetTime;
        public int result;
        public String text;
        public String url;
    }
}
