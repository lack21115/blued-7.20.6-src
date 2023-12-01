package io.noties.markwon.inlineparser;

import org.commonmark.internal.Bracket;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/OpenBracketInlineProcessor.class */
public class OpenBracketInlineProcessor extends InlineProcessor {
    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        int i = this.index;
        this.index++;
        Text text = text("[");
        addBracket(Bracket.a(text, i, lastBracket(), lastDelimiter()));
        return text;
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '[';
    }
}
