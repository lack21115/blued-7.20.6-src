package com.google.common.html;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/html/HtmlEscapers.class */
public final class HtmlEscapers {
    private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape('\"', "&quot;").addEscape('\'', "&#39;").addEscape('&', "&amp;").addEscape('<', "&lt;").addEscape('>', "&gt;").build();

    private HtmlEscapers() {
    }

    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }
}
