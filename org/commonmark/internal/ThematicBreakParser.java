package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/ThematicBreakParser.class */
public class ThematicBreakParser extends AbstractBlockParser {
    private final ThematicBreak a = new ThematicBreak();

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/ThematicBreakParser$Factory.class */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.f() >= 4) {
                return BlockStart.f();
            }
            int d = parserState.d();
            CharSequence b = parserState.b();
            return ThematicBreakParser.b(b, d) ? BlockStart.a(new ThematicBreakParser()).a(b.length()) : BlockStart.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
        if (r6 == 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.lang.CharSequence r3, int r4) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.ThematicBreakParser.b(java.lang.CharSequence, int):boolean");
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        return BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.a;
    }
}
