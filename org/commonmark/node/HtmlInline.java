package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/HtmlInline.class */
public class HtmlInline extends Node {
    private String a;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
