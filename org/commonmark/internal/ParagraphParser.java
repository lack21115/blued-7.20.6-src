package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.Block;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/ParagraphParser.class */
public class ParagraphParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    private final Paragraph f44037a = new Paragraph();
    private LinkReferenceDefinitionParser b = new LinkReferenceDefinitionParser();

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        return !parserState.g() ? BlockContinue.a(parserState.c()) : BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void a(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void a(InlineParser inlineParser) {
        CharSequence a2 = this.b.a();
        if (a2.length() > 0) {
            inlineParser.parse(a2.toString(), this.f44037a);
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean aE_() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void b() {
        if (this.b.a().length() == 0) {
            this.f44037a.l();
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.f44037a;
    }

    public CharSequence e() {
        return this.b.a();
    }

    public List<LinkReferenceDefinition> f() {
        return this.b.b();
    }
}
