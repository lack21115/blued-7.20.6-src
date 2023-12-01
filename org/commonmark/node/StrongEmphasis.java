package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/StrongEmphasis.class */
public class StrongEmphasis extends Node implements Delimited {
    private String a;

    public StrongEmphasis() {
    }

    public StrongEmphasis(String str) {
        this.a = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
