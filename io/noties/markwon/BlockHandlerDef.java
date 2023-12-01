package io.noties.markwon;

import io.noties.markwon.MarkwonVisitor;
import org.commonmark.node.Node;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/BlockHandlerDef.class */
public class BlockHandlerDef implements MarkwonVisitor.BlockHandler {
    @Override // io.noties.markwon.MarkwonVisitor.BlockHandler
    public void blockEnd(MarkwonVisitor markwonVisitor, Node node) {
        if (markwonVisitor.hasNext(node)) {
            markwonVisitor.ensureNewLine();
            markwonVisitor.forceNewLine();
        }
    }

    @Override // io.noties.markwon.MarkwonVisitor.BlockHandler
    public void blockStart(MarkwonVisitor markwonVisitor, Node node) {
        markwonVisitor.ensureNewLine();
    }
}
