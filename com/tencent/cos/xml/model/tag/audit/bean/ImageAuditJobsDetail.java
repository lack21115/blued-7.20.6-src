package com.tencent.cos.xml.model.tag.audit.bean;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/ImageAuditJobsDetail.class */
public class ImageAuditJobsDetail extends AuditJobsDetail {
    public ImagesAuditScenarioInfo adsInfo;
    public int compressionResult;
    public String object;
    public ImagesAuditScenarioInfo politicsInfo;
    public ImagesAuditScenarioInfo pornInfo;
    public int score;
    public String subLabel;
    public ImagesAuditScenarioInfo terrorismInfo;
    public String text;
    public String url;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/ImageAuditJobsDetail$ImagesAuditScenarioInfo.class */
    public static class ImagesAuditScenarioInfo extends ImageAuditScenarioInfo {
        public int code;
        public String label;
        public String msg;
    }
}
