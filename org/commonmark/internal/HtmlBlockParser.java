package org.commonmark.internal;

import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/HtmlBlockParser.class */
public class HtmlBlockParser extends AbstractBlockParser {
    private static final Pattern[][] a = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};
    private final HtmlBlock b;
    private final Pattern c;
    private boolean d;
    private BlockContent e;

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/HtmlBlockParser$Factory.class */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int d = parserState.d();
            CharSequence b = parserState.b();
            if (parserState.f() < 4 && b.charAt(d) == '<') {
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 > 7) {
                        break;
                    }
                    if (i2 != 7 || !(matchedBlockParser.a().c() instanceof Paragraph)) {
                        Pattern pattern = HtmlBlockParser.a[i2][0];
                        Pattern pattern2 = HtmlBlockParser.a[i2][1];
                        if (pattern.matcher(b.subSequence(d, b.length())).find()) {
                            return BlockStart.a(new HtmlBlockParser(pattern2)).a(parserState.c());
                        }
                    }
                    i = i2 + 1;
                }
            }
            return BlockStart.f();
        }
    }

    private HtmlBlockParser(Pattern pattern) {
        this.b = new HtmlBlock();
        this.d = false;
        this.e = new BlockContent();
        this.c = pattern;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        return this.d ? BlockContinue.d() : (parserState.g() && this.c == null) ? BlockContinue.d() : BlockContinue.a(parserState.c());
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void a(CharSequence charSequence) {
        this.e.a(charSequence);
        Pattern pattern = this.c;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.d = true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void b() {
        this.b.a(this.e.a());
        this.e = null;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.b;
    }
}
