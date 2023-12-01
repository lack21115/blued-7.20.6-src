package com.tencent.cos.xml.model.tag.audit.get;

import com.tencent.cos.xml.model.tag.audit.bean.AuditJobsDetail;
import com.tencent.cos.xml.model.tag.audit.bean.ImageAuditScenarioInfo;
import com.tencent.cos.xml.model.tag.audit.bean.TextAuditScenarioInfo;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse.class */
public class GetWebPageAuditJobResponse {
    public WebPageAuditJobsDetail jobsDetail;
    public String requestId;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$ImageResult.class */
    public static class ImageResult {
        public ImageAuditScenarioInfo adsInfo;
        public String label;
        public ImageAuditScenarioInfo politicsInfo;
        public ImageAuditScenarioInfo pornInfo;
        public int suggestion;
        public ImageAuditScenarioInfo terrorismInfo;
        public String text;
        public String url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$ImageResults.class */
    public static class ImageResults {
        public List<ImageResult> results;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$Labels.class */
    public static class Labels {
        public WebPageAuditScenarioInfo adsInfo;
        public WebPageAuditScenarioInfo politicsInfo;
        public WebPageAuditScenarioInfo pornInfo;
        public WebPageAuditScenarioInfo terrorismInfo;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$TextResult.class */
    public static class TextResult {
        public TextAuditScenarioInfo adsInfo;
        public String label;
        public TextAuditScenarioInfo politicsInfo;
        public TextAuditScenarioInfo pornInfo;
        public int suggestion;
        public TextAuditScenarioInfo terrorismInfo;
        public String text;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$TextResults.class */
    public static class TextResults {
        public List<TextResult> results;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$WebPageAuditJobsDetail.class */
    public static class WebPageAuditJobsDetail extends AuditJobsDetail {
        public String highlightHtml;
        public Labels labels;
        public int pageCount;
        public ImageResults pageSegment;
        public int suggestion;
        public TextResults textResults;
        public String url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/get/GetWebPageAuditJobResponse$WebPageAuditScenarioInfo.class */
    public static class WebPageAuditScenarioInfo {
        public int hitFlag;
        public int score;
    }
}
