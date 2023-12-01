package org.commonmark.internal;

import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/BlockStartImpl.class */
public class BlockStartImpl extends BlockStart {

    /* renamed from: a  reason: collision with root package name */
    private final BlockParser[] f44005a;
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f44006c = -1;
    private boolean d = false;

    public BlockStartImpl(BlockParser... blockParserArr) {
        this.f44005a = blockParserArr;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public BlockStart a(int i) {
        this.b = i;
        return this;
    }

    public BlockParser[] a() {
        return this.f44005a;
    }

    public int b() {
        return this.b;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public BlockStart b(int i) {
        this.f44006c = i;
        return this;
    }

    public int c() {
        return this.f44006c;
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
