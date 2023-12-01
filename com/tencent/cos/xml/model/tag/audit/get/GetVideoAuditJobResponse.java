package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail;
import com.tencent.cos.xml.model.tag.audit.bean.AuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.get.GetAudioAuditJobResponse;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetVideoAuditJobResponse.class */
public class GetVideoAuditJobResponse {
    public VideoAuditJobsDetail jobsDetail;
    public String requestId;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetVideoAuditJobResponse$Snapshot.class */
    public static class Snapshot {
        public SnapshotAuditScenarioInfo adsInfo;
        public SnapshotAuditScenarioInfo politicsInfo;
        public SnapshotAuditScenarioInfo pornInfo;
        public int snapshotTime;
        public SnapshotAuditScenarioInfo terrorismInfo;
        public String text;
        public String url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetVideoAuditJobResponse$SnapshotAuditScenarioInfo.class */
    public static class SnapshotAuditScenarioInfo extends ImageAuditScenarioInfo {
        public String label;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetVideoAuditJobResponse$VideoAuditJobsDetail.class */
    public static class VideoAuditJobsDetail extends AuditJobsDetail {
        public AuditScenarioInfo adsInfo;
        public List<GetAudioAuditJobResponse.AudioSection> audioSection;
        public String object;
        public AuditScenarioInfo politicsInfo;
        public AuditScenarioInfo pornInfo;
        public List<Snapshot> snapshot;
        public String snapshotCount;
        public AuditScenarioInfo terrorismInfo;
        public String url;
    }
}
