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

    /* renamed from: a  reason: collision with root package name */
    private final ListItem f44035a = new ListItem();
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f44036c;

    public ListItemParser(int i) {
        this.b = i;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue a(ParserState parserState) {
        if (!parserState.g()) {
            return parserState.f() >= this.b ? BlockContinue.b(parserState.e() + this.b) : BlockContinue.d();
        } else if (this.f44035a.j() == null) {
            return BlockContinue.d();
        } else {
            Block c2 = parserState.h().c();
            this.f44036c = (c2 instanceof Paragraph) || (c2 instanceof ListItem);
            return BlockContinue.a(parserState.d());
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean a() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean a(Block block) {
        if (this.f44036c) {
            Block a2 = this.f44035a.b();
            if (a2 instanceof ListBlock) {
                ((ListBlock) a2).a(false);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block c() {
        return this.f44035a;
    }
}
