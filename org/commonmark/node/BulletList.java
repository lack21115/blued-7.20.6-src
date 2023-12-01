package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/BulletList.class */
public class BulletList extends ListBlock {

    /* renamed from: a  reason: collision with root package name */
    private char f44050a;

    public void a(char c2) {
        this.f44050a = c2;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public char c() {
        return this.f44050a;
    }
}
