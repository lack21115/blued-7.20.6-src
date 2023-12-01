package com.tencent.cos.xml.model.tag.audit.bean;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/ImageAuditScenarioInfo.class */
public class ImageAuditScenarioInfo {
    public int hitFlag;
    public List<ObjectResults> objectResults;
    public List<AuditOcrResults> ocrResults;
    public int score;
    public String subLabel;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/bean/ImageAuditScenarioInfo$ObjectResults.class */
    public static class ObjectResults {
        public AuditOcrLocation location;
        public String name;
    }
}
