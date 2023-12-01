package org.commonmark.renderer.html;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.commonmark.Extension;
import org.commonmark.internal.renderer.NodeRendererMap;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Node;
import org.commonmark.renderer.Renderer;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/HtmlRenderer.class */
public class HtmlRenderer implements Renderer {

    /* renamed from: a  reason: collision with root package name */
    private final String f44076a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f44077c;

    /* renamed from: org.commonmark.renderer.html.HtmlRenderer$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/HtmlRenderer$1.class */
    class AnonymousClass1 implements HtmlNodeRendererFactory {
    }

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/HtmlRenderer$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f44078a = "\n";
        private boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f44079c = false;
        private List<AttributeProviderFactory> d = new ArrayList();
        private List<HtmlNodeRendererFactory> e = new ArrayList();
    }

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/HtmlRenderer$HtmlRendererExtension.class */
    public interface HtmlRendererExtension extends Extension {
    }

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/HtmlRenderer$RendererContext.class */
    class RendererContext implements AttributeProviderContext, HtmlNodeRendererContext {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HtmlRenderer f44080a;
        private final List<AttributeProvider> b;

        /* renamed from: c  reason: collision with root package name */
        private final NodeRendererMap f44081c;

        private void b(Node node, String str, Map<String, String> map) {
            for (AttributeProvider attributeProvider : this.b) {
                attributeProvider.a(node, str, map);
            }
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public String a() {
            return this.f44080a.f44076a;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public String a(String str) {
            String str2 = str;
            if (this.f44080a.f44077c) {
                str2 = Escaping.c(str);
            }
            return str2;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public Map<String, String> a(Node node, String str, Map<String, String> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            b(node, str, linkedHashMap);
            return linkedHashMap;
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public void a(Node node) {
            this.f44081c.a(node);
        }

        @Override // org.commonmark.renderer.html.HtmlNodeRendererContext
        public boolean b() {
            return this.f44080a.b;
        }
    }
}
