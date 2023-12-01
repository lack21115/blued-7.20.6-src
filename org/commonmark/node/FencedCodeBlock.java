package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/FencedCodeBlock.class */
public class FencedCodeBlock extends Block {

    /* renamed from: a  reason: collision with root package name */
    private char f44053a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f44054c;
    private String d;
    private String e;

    public void a(char c2) {
        this.f44053a = c2;
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
        this.f44054c = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public char c() {
        return this.f44053a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.f44054c;
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }
}
