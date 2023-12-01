package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/HeadingParser.class */
public class HeadingParser extends AbstractBlockParser {
    private final Heading a;
    private final String b;

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/HeadingParser$Factory.class */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            CharSequence b;
            if (parserState.f() >= Parsing.a) {
                return BlockStart.f();
            }
            CharSequence b2 = parserState.b();
            int d = parserState.d();
            HeadingParser c = HeadingParser.c(b2, d);
            if (c != null) {
                return BlockStart.a(c).a(b2.length());
            }
            int d2 = HeadingParser.d(b2, d);
            return (d2 <= 0 || (b = matchedBlockParser.b()) == null) ? BlockStart.f() : BlockStart.a(new HeadingParser(d2, b.toString())).a(b2.length()).e();
        }
    }

    public HeadingParser(int i, String str) {
        Heading heading = new Heading();
        this.a = heading;
        heading.a(i);
        this.b = str;
    }

    private static boolean a(CharSequence charSequence, int i, char c) {
        return Parsing.a(charSequence, Parsing.a(c, charSequence, i, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HeadingParser c(CharSequence charSequence, int i) {
        int a = Parsing.a('#', charSequence, i, charSequence.length()) - i;
        if (a == 0 || a > 6) {
            return null;
        }
        int i2 = i + a;
        if (i2 >= charSequence.length()) {
            return new HeadingParser(a, "");
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == ' ' || charAt == '\t') {
            int b = Parsing.b(charSequence, charSequence.length() - 1, i2);
            int b2 = Parsing.b('#', charSequence, b, i2);
            int b3 = Parsing.b(charSequence, b2, i2);
            return b3 != b2 ? new HeadingParser(a, charSequence.subSequence(i2, b3 + 1).toString()) : new HeadingParser(a, charSequence.subSequence(i2, b + 1).toString());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        if (charAt != '-') {
            if (charAt != '=') {
                return 0;
            }
            if (a(charSequence, i + 1, '=')) {
                return 1;
            }
        }
        return a(charSequence, i + 1, '-') ? 2 : 0;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        return BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void a(InlineParser inlineParser) {
        inlineParser.parse(this.b, this.a);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.a;
    }
}
