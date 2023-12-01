package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail;
import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse.class */
public class GetDocumentAuditJobResponse {
    public DocumentAuditJobsDetail jobsDetail;
    public String requestId;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$DocumentAuditJobsDetail.class */
    public static class DocumentAuditJobsDetail extends AuditJobsDetail {
        public Labels labels;
        public String object;
        public int pageCount;
        public PageSegment pageSegment;
        public int suggestion;
        public String url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$DocumentAuditScenarioInfo.class */
    public static class DocumentAuditScenarioInfo {
        public int hitFlag;
        public int score;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$Labels.class */
    public static class Labels {
        public DocumentAuditScenarioInfo adsInfo;
        public DocumentAuditScenarioInfo politicsInfo;
        public DocumentAuditScenarioInfo pornInfo;
        public DocumentAuditScenarioInfo terrorismInfo;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$PageSegment.class */
    public static class PageSegment {
        public List<Results> results;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetDocumentAuditJobResponse$Results.class */
    public static class Results {
        public ImageAuditScenarioInfo adsInfo;
        public String label;
        public int pageNumber;
        public ImageAuditScenarioInfo politicsInfo;
        public ImageAuditScenarioInfo pornInfo;
        public int sheetNumber;
        public int suggestion;
        public ImageAuditScenarioInfo terrorismInfo;
        public String text;
        public String url;
    }
}
