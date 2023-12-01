package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.Node;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/BackticksInlineProcessor.class */
public class BackticksInlineProcessor extends InlineProcessor {
    private static final Pattern TICKS = Pattern.compile("`+");
    private static final Pattern TICKS_HERE = Pattern.compile("^`+");

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        String match;
        String match2 = match(TICKS_HERE);
        if (match2 == null) {
            return null;
        }
        int i = this.index;
        do {
            match = match(TICKS);
            if (match == null) {
                this.index = i;
                return text(match2);
            }
        } while (!match.equals(match2));
        Code code = new Code();
        String replace = this.input.substring(i, this.index - match2.length()).replace('\n', ' ');
        String str = replace;
        if (replace.length() >= 3) {
            str = replace;
            if (replace.charAt(0) == ' ') {
                str = replace;
                if (replace.charAt(replace.length() - 1) == ' ') {
                    str = replace;
                    if (Parsing.b(replace)) {
                        str = replace.substring(1, replace.length() - 1);
                    }
                }
            }
        }
        code.a(str);
        return code;
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '`';
    }
}
