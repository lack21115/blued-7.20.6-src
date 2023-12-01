package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/BackslashInlineProcessor.class */
public class BackslashInlineProcessor extends InlineProcessor {
    private static final Pattern ESCAPABLE = MarkwonInlineParser.ESCAPABLE;

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        this.index++;
        if (peek() == '\n') {
            HardLineBreak hardLineBreak = new HardLineBreak();
            this.index++;
            return hardLineBreak;
        } else if (this.index >= this.input.length() || !ESCAPABLE.matcher(this.input.substring(this.index, this.index + 1)).matches()) {
            return text("\\");
        } else {
            Text text = text(this.input, this.index, this.index + 1);
            this.index++;
            return text;
        }
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '\\';
    }
}
