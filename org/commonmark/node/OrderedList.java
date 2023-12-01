package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/OrderedList.class */
public class OrderedList extends ListBlock {
    private int a;
    private char b;

    public void a(char c) {
        this.b = c;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public int c() {
        return this.a;
    }

    public char f() {
        return this.b;
    }
}
