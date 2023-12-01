package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/IndentedCodeBlock.class */
public class IndentedCodeBlock extends Block {

    /* renamed from: a  reason: collision with root package name */
    private String f44059a;

    public void a(String str) {
        this.f44059a = str;
    }

    @Override // org.commonmark.node.Node
    public void a(Visitor visitor) {
        visitor.visit(this);
    }

    public String c() {
        return this.f44059a;
    }
}
