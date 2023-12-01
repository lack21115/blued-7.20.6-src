package org.commonmark.internal;

import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/FencedCodeBlockParser.class */
public class FencedCodeBlockParser extends AbstractBlockParser {
    private String b;
    private final FencedCodeBlock a = new FencedCodeBlock();
    private StringBuilder c = new StringBuilder();

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/FencedCodeBlockParser$Factory.class */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int f = parserState.f();
            if (f >= Parsing.a) {
                return BlockStart.f();
            }
            int d = parserState.d();
            FencedCodeBlockParser b = FencedCodeBlockParser.b(parserState.b(), d, f);
            return b != null ? BlockStart.a(b).a(d + b.a.d()) : BlockStart.f();
        }
    }

    public FencedCodeBlockParser(char c, int i, int i2) {
        this.a.a(c);
        this.a.a(i);
        this.a.b(i2);
    }

    private boolean a(CharSequence charSequence, int i) {
        char c = this.a.c();
        int d = this.a.d();
        int a = Parsing.a(c, charSequence, i, charSequence.length()) - i;
        boolean z = false;
        if (a < d) {
            return false;
        }
        if (Parsing.a(charSequence, i + a, charSequence.length()) == charSequence.length()) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FencedCodeBlockParser b(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = i; i5 < length; i5++) {
            char charAt = charSequence.charAt(i5);
            if (charAt == '`') {
                i3++;
            } else if (charAt != '~') {
                break;
            } else {
                i4++;
            }
        }
        if (i3 >= 3 && i4 == 0) {
            if (Parsing.a('`', charSequence, i + i3) != -1) {
                return null;
            }
            return new FencedCodeBlockParser('`', i3, i2);
        } else if (i4 < 3 || i3 != 0) {
            return null;
        } else {
            return new FencedCodeBlockParser('~', i4, i2);
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        int d = parserState.d();
        int c = parserState.c();
        CharSequence b = parserState.b();
        if (parserState.f() < Parsing.a && a(b, d)) {
            return BlockContinue.e();
        }
        int length = b.length();
        for (int e = this.a.e(); e > 0 && c < length && b.charAt(c) == ' '; e--) {
            c++;
        }
        return BlockContinue.a(c);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void a(CharSequence charSequence) {
        if (this.b == null) {
            this.b = charSequence.toString();
            return;
        }
        this.c.append(charSequence);
        this.c.append('\n');
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void b() {
        this.a.a(Escaping.b(this.b.trim()));
        this.a.b(this.c.toString());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.a;
    }
}
