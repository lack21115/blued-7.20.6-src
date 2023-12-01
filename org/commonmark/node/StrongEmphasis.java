package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/StrongEmphasis.class */
public class StrongEmphasis extends Node implements Delimited {

    /* renamed from: a  reason: collision with root package name */
    private String f44067a;

    public StrongEmphasis() {
    }

    public StrongEmphasis(String str) {
        this.f44067a = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
