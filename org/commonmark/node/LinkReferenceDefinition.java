package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/LinkReferenceDefinition.class */
public class LinkReferenceDefinition extends Node {

    /* renamed from: a  reason: collision with root package name */
    private String f44061a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f44062c;

    public LinkReferenceDefinition() {
    }

    public LinkReferenceDefinition(String str, String str2, String str3) {
        this.f44061a = str;
        this.b = str2;
        this.f44062c = str3;
    }

    public String a() {
        return this.f44061a;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public String c() {
        return this.b;
    }

    public String e() {
        return this.f44062c;
    }
}
