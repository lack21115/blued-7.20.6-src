package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/ListItemParser.class */
public class ListItemParser extends AbstractBlockParser {
    private final ListItem a = new ListItem();
    private int b;
    private boolean c;

    public ListItemParser(int i) {
        this.b = i;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        if (!parserState.g()) {
            return parserState.f() >= this.b ? BlockContinue.b(parserState.e() + this.b) : BlockContinue.d();
        } else if (this.a.j() == null) {
            return BlockContinue.d();
        } else {
            Block c = parserState.h().c();
            this.c = (c instanceof Paragraph) || (c instanceof ListItem);
            return BlockContinue.a(parserState.d());
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean a() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean a(Block block) {
        if (this.c) {
            Block a = this.a.b();
            if (a instanceof ListBlock) {
                ((ListBlock) a).a(false);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.a;
    }
}
