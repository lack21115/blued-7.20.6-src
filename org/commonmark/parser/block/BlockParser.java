package org.commonmark.parser.block;

import org.commonmark.node.Block;
import org.commonmark.parser.InlineParser;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/block/BlockParser.class */
public interface BlockParser {
    BlockContinue a(ParserState parserState);

    void a(CharSequence charSequence);

    void a(InlineParser inlineParser);

    boolean a();

    boolean a(Block block);

    boolean aE_();

    void b();

    Block c();
}
