package org.commonmark.node;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/node/Block.class */
public abstract class Block extends Node {
    @Override // org.commonmark.node.Node
    /* renamed from: a */
    public Block b() {
        return (Block) super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.commonmark.node.Node
    public void a(Node node) {
        if (!(node instanceof Block)) {
            throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
        }
        super.a(node);
    }
}
