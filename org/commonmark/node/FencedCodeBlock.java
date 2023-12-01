package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/FencedCodeBlock.class */
public class FencedCodeBlock extends Block {
    private char a;
    private int b;
    private int c;
    private String d;
    private String e;

    public void a(char c) {
        this.a = c;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public void b(int i) {
        this.c = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public char c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }
}
