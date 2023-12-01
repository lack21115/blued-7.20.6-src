package org.commonmark.internal.renderer;

import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/renderer/NodeRendererMap.class */
public class NodeRendererMap {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends Node>, NodeRenderer> f44042a = new HashMap(32);

    public void a(Node node) {
        NodeRenderer nodeRenderer = this.f44042a.get(node.getClass());
        if (nodeRenderer != null) {
            nodeRenderer.b(node);
        }
    }
}
