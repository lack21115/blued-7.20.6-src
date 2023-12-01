package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/OrderedList.class */
public class OrderedList extends ListBlock {

    /* renamed from: a  reason: collision with root package name */
    private int f44066a;
    private char b;

    public void a(char c2) {
        this.b = c2;
    }

    public void a(int i) {
        this.f44066a = i;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public int c() {
        return this.f44066a;
    }

    public char f() {
        return this.b;
    }
}
