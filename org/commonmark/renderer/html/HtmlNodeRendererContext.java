package org.commonmark.renderer.html;

import java.util.Map;
import org.commonmark.node.Node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/HtmlNodeRendererContext.class */
public interface HtmlNodeRendererContext {
    String a();

    String a(String str);

    Map<String, String> a(Node node, String str, Map<String, String> map);

    void a(Node node);

    boolean b();
}
