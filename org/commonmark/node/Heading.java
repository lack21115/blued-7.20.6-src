package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Heading.class */
public class Heading extends Block {

    /* renamed from: a  reason: collision with root package name */
    private int f44055a;

    public void a(int i) {
        this.f44055a = i;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public int c() {
        return this.f44055a;
    }
}
