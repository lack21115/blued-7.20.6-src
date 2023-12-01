package io.noties.markwon;

import io.noties.markwon.MarkwonVisitor;
import org.commonmark.node.SoftLineBreak;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/SoftBreakAddsNewLinePlugin.class */
public class SoftBreakAddsNewLinePlugin extends AbstractMarkwonPlugin {
    public static SoftBreakAddsNewLinePlugin create() {
        return new SoftBreakAddsNewLinePlugin();
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.on(SoftLineBreak.class, new MarkwonVisitor.NodeVisitor<SoftLineBreak>() { // from class: io.noties.markwon.SoftBreakAddsNewLinePlugin.1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public void visit(MarkwonVisitor markwonVisitor, SoftLineBreak softLineBreak) {
                markwonVisitor.ensureNewLine();
            }
        });
    }
}
