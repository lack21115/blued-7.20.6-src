package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Text.class */
public class Text extends Node {
    private String a;

    public Text() {
    }

    public Text(String str) {
        this.a = str;
    }

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

    @Override // org.commonmark.node.Node
    protected String aF_() {
        return "literal=" + this.a;
    }
}
