package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/LinkReferenceDefinition.class */
public class LinkReferenceDefinition extends Node {
    private String a;
    private String b;
    private String c;

    public LinkReferenceDefinition() {
    }

    public LinkReferenceDefinition(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String a() {
        return this.a;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public String c() {
        return this.b;
    }

    public String e() {
        return this.c;
    }
}
