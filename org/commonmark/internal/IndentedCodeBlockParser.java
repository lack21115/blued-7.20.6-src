package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/IndentedCodeBlockParser.class */
public class IndentedCodeBlockParser extends AbstractBlockParser {
    private final IndentedCodeBlock a = new IndentedCodeBlock();
    private final List<CharSequence> b = new ArrayList();

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/IndentedCodeBlockParser$Factory.class */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            return (parserState.f() < Parsing.a || parserState.g() || (parserState.h().c() instanceof Paragraph)) ? BlockStart.f() : BlockStart.a(new IndentedCodeBlockParser()).b(parserState.e() + Parsing.a);
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        return parserState.f() >= Parsing.a ? BlockContinue.b(parserState.e() + Parsing.a) : parserState.g() ? BlockContinue.a(parserState.d()) : BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void a(CharSequence charSequence) {
        this.b.add(charSequence);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void b() {
        int i;
        int size = this.b.size();
        while (true) {
            i = size - 1;
            if (i < 0 || !Parsing.a(this.b.get(i))) {
                break;
            }
            size = i;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i + 1) {
                this.a.a(sb.toString());
                return;
            }
            sb.append(this.b.get(i3));
            sb.append('\n');
            i2 = i3 + 1;
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.a;
    }
}
