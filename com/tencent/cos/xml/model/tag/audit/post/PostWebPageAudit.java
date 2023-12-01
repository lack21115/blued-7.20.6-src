package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditConf;
import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostWebPageAudit.class */
public class PostWebPageAudit {
    public AuditInput input = new AuditInput();
    public WebPageAuditConf conf = new WebPageAuditConf();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostWebPageAudit$WebPageAuditConf.class */
    public static class WebPageAuditConf extends AuditConf {
        public boolean returnHighlightHtml;
    }
}
