package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/BlockQuoteParser.class */
public class BlockQuoteParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    private final BlockQuote f44004a = new BlockQuote();

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/BlockQuoteParser$Factory.class */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int d = parserState.d();
            if (BlockQuoteParser.b(parserState, d)) {
                int e = parserState.e() + parserState.f() + 1;
                int i = e;
                if (Parsing.c(parserState.b(), d + 1)) {
                    i = e + 1;
                }
                return BlockStart.a(new BlockQuoteParser()).b(i);
            }
            return BlockStart.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(ParserState parserState, int i) {
        CharSequence b = parserState.b();
        return parserState.f() < Parsing.f44049a && i < b.length() && b.charAt(i) == '>';
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        int d = parserState.d();
        if (b(parserState, d)) {
            int e = parserState.e() + parserState.f() + 1;
            int i = e;
            if (Parsing.c(parserState.b(), d + 1)) {
                i = e + 1;
            }
            return BlockContinue.b(i);
        }
        return BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean a() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean a(Block block) {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    /* renamed from: aC_ */
    public BlockQuote c() {
        return this.f44004a;
    }
}
