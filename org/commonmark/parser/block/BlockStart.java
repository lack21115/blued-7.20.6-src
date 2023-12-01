package org.commonmark.parser.block;

import org.commonmark.internal.BlockStartImpl;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/block/BlockStart.class */
public abstract class BlockStart {
    public static BlockStart a(BlockParser... blockParserArr) {
        return new BlockStartImpl(blockParserArr);
    }

    public static BlockStart f() {
        return null;
    }

    public abstract BlockStart a(int i);

    public abstract BlockStart b(int i);

    public abstract BlockStart e();
}
