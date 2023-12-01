package org.commonmark.parser.block;

import org.commonmark.node.Block;
import org.commonmark.parser.InlineParser;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/block/AbstractBlockParser.class */
public abstract class AbstractBlockParser implements BlockParser {
    @Override // org.commonmark.parser.block.BlockParser
    public void a(CharSequence charSequence) {
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void a(InlineParser inlineParser) {
    }

    @Override // org.commonmark.parser.block.BlockParser
    public boolean a() {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public boolean a(Block block) {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public boolean aE_() {
        return false;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public void b() {
    }
}
