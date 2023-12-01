package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Document.class */
public class Document extends Block {
    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
