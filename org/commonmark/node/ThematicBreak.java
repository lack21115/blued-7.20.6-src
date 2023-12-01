package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/ThematicBreak.class */
public class ThematicBreak extends Block {
    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
