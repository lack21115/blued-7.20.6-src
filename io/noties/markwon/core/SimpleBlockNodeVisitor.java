package io.noties.markwon.core;

import io.noties.markwon.MarkwonVisitor;
import org.commonmark.node.Node;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/SimpleBlockNodeVisitor.class */
public class SimpleBlockNodeVisitor implements MarkwonVisitor.NodeVisitor<Node> {
    @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
    public void visit(MarkwonVisitor markwonVisitor, Node node) {
        markwonVisitor.blockStart(node);
        int length = markwonVisitor.length();
        markwonVisitor.visitChildren(node);
        markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, length);
        markwonVisitor.blockEnd(node);
    }
}
