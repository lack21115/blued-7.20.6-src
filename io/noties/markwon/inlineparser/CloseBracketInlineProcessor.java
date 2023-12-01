package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/CloseBracketInlineProcessor.class */
public class CloseBracketInlineProcessor extends InlineProcessor {
    private static final Pattern WHITESPACE = MarkwonInlineParser.WHITESPACE;

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cd  */
    @Override // io.noties.markwon.inlineparser.InlineProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected org.commonmark.node.Node parse() {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.noties.markwon.inlineparser.CloseBracketInlineProcessor.parse():org.commonmark.node.Node");
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return ']';
    }
}
