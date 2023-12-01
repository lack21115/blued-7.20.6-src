package com.tencent.cos.xml.model.tag.audit.post;

import com.tencent.cos.xml.model.tag.audit.bean.AuditConf;
import com.tencent.cos.xml.model.tag.audit.bean.AuditInput;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostTextAudit.class */
public class PostTextAudit {
    public TextAuditInput input = new TextAuditInput();
    public TextAuditConf conf = new TextAuditConf();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostTextAudit$TextAuditConf.class */
    public static class TextAuditConf extends AuditConf {
        public String callbackVersion;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/audit/post/PostTextAudit$TextAuditInput.class */
    public static class TextAuditInput extends AuditInput {
        public String content;
    }
}
