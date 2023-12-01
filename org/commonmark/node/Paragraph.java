package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Paragraph.class */
public class Paragraph extends Block {
    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
