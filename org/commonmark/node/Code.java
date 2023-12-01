package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Code.class */
public class Code extends Node {

    /* renamed from: a  reason: collision with root package name */
    private String f44051a;

    public String a() {
        return this.f44051a;
    }

    public void a(String str) {
        this.f44051a = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
