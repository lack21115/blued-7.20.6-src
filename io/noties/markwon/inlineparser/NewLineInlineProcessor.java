package io.noties.markwon.inlineparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/NewLineInlineProcessor.class */
public class NewLineInlineProcessor extends InlineProcessor {
    private static final Pattern FINAL_SPACE = Pattern.compile(" *$");

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        this.index++;
        Node k = this.block.k();
        if (k instanceof Text) {
            Text text = (Text) k;
            if (text.a().endsWith(" ")) {
                String a2 = text.a();
                Matcher matcher = FINAL_SPACE.matcher(a2);
                int end = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (end > 0) {
                    text.a(a2.substring(0, a2.length() - end));
                }
                return end >= 2 ? new HardLineBreak() : new SoftLineBreak();
            }
        }
        return new SoftLineBreak();
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '\n';
    }
}
