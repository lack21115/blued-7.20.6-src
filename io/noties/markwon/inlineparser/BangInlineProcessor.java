package io.noties.markwon.inlineparser;

import org.commonmark.internal.Bracket;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/BangInlineProcessor.class */
public class BangInlineProcessor extends InlineProcessor {
    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        int i = this.index;
        this.index++;
        if (peek() == '[') {
            this.index++;
            Text text = text("![");
            addBracket(Bracket.b(text, i + 1, lastBracket(), lastDelimiter()));
            return text;
        }
        return text("!");
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '!';
    }
}
