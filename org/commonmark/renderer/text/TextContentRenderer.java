package org.commonmark.renderer.text;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.Extension;
import org.commonmark.internal.renderer.NodeRendererMap;
import org.commonmark.node.Node;
import org.commonmark.renderer.Renderer;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/text/TextContentRenderer.class */
public class TextContentRenderer implements Renderer {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f44086a;

    /* renamed from: org.commonmark.renderer.text.TextContentRenderer$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/text/TextContentRenderer$1.class */
    class AnonymousClass1 implements TextContentNodeRendererFactory {
    }

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/text/TextContentRenderer$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f44087a = false;
        private List<TextContentNodeRendererFactory> b = new ArrayList();
    }

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/text/TextContentRenderer$RendererContext.class */
    class RendererContext implements TextContentNodeRendererContext {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextContentRenderer f44088a;
        private final NodeRendererMap b;

        @Override // org.commonmark.renderer.text.TextContentNodeRendererContext
        public void a(Node node) {
            this.b.a(node);
        }

        @Override // org.commonmark.renderer.text.TextContentNodeRendererContext
        public boolean a() {
            return this.f44088a.f44086a;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/text/TextContentRenderer$TextContentRendererExtension.class */
    public interface TextContentRendererExtension extends Extension {
    }
}
