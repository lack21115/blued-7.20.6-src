package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/HtmlInline.class */
public class HtmlInline extends Node {

    /* renamed from: a  reason: collision with root package name */
    private String f44057a;

    public String a() {
        return this.f44057a;
    }

    public void a(String str) {
        this.f44057a = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
