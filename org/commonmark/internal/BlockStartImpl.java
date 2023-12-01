package org.commonmark.internal;

import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/BlockStartImpl.class */
public class BlockStartImpl extends BlockStart {
    private final BlockParser[] a;
    private int b = -1;
    private int c = -1;
    private boolean d = false;

    public BlockStartImpl(BlockParser... blockParserArr) {
        this.a = blockParserArr;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public BlockStart a(int i) {
        this.b = i;
        return this;
    }

    public BlockParser[] a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public BlockStart b(int i) {
        this.c = i;
        return this;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public BlockStart e() {
        this.d = true;
        return this;
    }
}
