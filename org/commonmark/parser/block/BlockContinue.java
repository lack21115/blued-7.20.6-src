package org.commonmark.parser.block;

import org.commonmark.internal.BlockContinueImpl;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/block/BlockContinue.class */
public class BlockContinue {
    public static BlockContinue a(int i) {
        return new BlockContinueImpl(i, -1, false);
    }

    public static BlockContinue b(int i) {
        return new BlockContinueImpl(-1, i, false);
    }

    public static BlockContinue d() {
        return null;
    }

    public static BlockContinue e() {
        return new BlockContinueImpl(-1, -1, true);
    }
}
