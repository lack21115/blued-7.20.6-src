package org.commonmark.internal.renderer;

import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/renderer/NodeRendererMap.class */
public class NodeRendererMap {
    private final Map<Class<? extends Node>, NodeRenderer> a = new HashMap(32);

    public void a(Node node) {
        NodeRenderer nodeRenderer = this.a.get(node.getClass());
        if (nodeRenderer != null) {
            nodeRenderer.b(node);
        }
    }
}
