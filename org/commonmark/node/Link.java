package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Link.class */
public class Link extends Node {
    private String a;
    private String b;

    public Link() {
    }

    public Link(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    @Override // org.commonmark.node.Node
    protected String aF_() {
        return "destination=" + this.a + ", title=" + this.b;
    }

    public String c() {
        return this.b;
    }
}
