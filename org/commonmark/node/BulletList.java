package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/BulletList.class */
public class BulletList extends ListBlock {
    private char a;

    public void a(char c) {
        this.a = c;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public char c() {
        return this.a;
    }
}
