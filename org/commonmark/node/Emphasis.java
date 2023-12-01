package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Emphasis.class */
public class Emphasis extends Node implements Delimited {
    private String a;

    public Emphasis() {
    }

    public Emphasis(String str) {
        this.a = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }
}
