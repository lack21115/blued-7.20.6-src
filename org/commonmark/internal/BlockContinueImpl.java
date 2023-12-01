package org.commonmark.internal;

import org.commonmark.parser.block.BlockContinue;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/BlockContinueImpl.class */
public class BlockContinueImpl extends BlockContinue {

    /* renamed from: a  reason: collision with root package name */
    private final int f44002a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f44003c;

    public BlockContinueImpl(int i, int i2, boolean z) {
        this.f44002a = i;
        this.b = i2;
        this.f44003c = z;
    }

    public int a() {
        return this.f44002a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.f44003c;
    }
}
