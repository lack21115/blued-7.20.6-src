package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditConf;
import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostDocumentAudit.class */
public class PostDocumentAudit {
    public DocumentAuditInput input = new DocumentAuditInput();
    public AuditConf conf = new AuditConf();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostDocumentAudit$DocumentAuditInput.class */
    public static class DocumentAuditInput extends AuditInput {
        public String type;
    }
}
