package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/WebsiteConfiguration.class */
public class WebsiteConfiguration {
    public ErrorDocument errorDocument;
    public IndexDocument indexDocument;
    public RedirectAllRequestTo redirectAllRequestTo;
    public List<RoutingRule> routingRules;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/WebsiteConfiguration$Contidion.class */
    public static class Contidion {
        public int httpErrorCodeReturnedEquals = -1;
        public String keyPrefixEquals;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/WebsiteConfiguration$ErrorDocument.class */
    public static class ErrorDocument {
        public String key;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/WebsiteConfiguration$IndexDocument.class */
    public static class IndexDocument {
        public String suffix;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/WebsiteConfiguration$Redirect.class */
    public static class Redirect {
        public String protocol;
        public String replaceKeyPrefixWith;
        public String replaceKeyWith;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/WebsiteConfiguration$RedirectAllRequestTo.class */
    public static class RedirectAllRequestTo {
        public String protocol;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/WebsiteConfiguration$RoutingRule.class */
    public static class RoutingRule {
        public Contidion contidion;
        public Redirect redirect;
    }
}
