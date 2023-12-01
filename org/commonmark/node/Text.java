package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Text.class */
public class Text extends Node {

    /* renamed from: a  reason: collision with root package name */
    private String f44068a;

    public Text() {
    }

    public Text(String str) {
        this.f44068a = str;
    }

    public String a() {
        return this.f44068a;
    }

    public void a(String str) {
        this.f44068a = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    @Override // org.commonmark.node.Node
    protected String aF_() {
        return "literal=" + this.f44068a;
    }
}
