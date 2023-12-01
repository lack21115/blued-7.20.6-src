package org.commonmark.internal;

import org.commonmark.parser.block.BlockContinue;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/BlockContinueImpl.class */
public class BlockContinueImpl extends BlockContinue {
    private final int a;
    private final int b;
    private final boolean c;

    public BlockContinueImpl(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }
}
