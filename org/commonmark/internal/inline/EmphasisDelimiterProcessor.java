package org.commonmark.internal.inline;

import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/inline/EmphasisDelimiterProcessor.class */
public abstract class EmphasisDelimiterProcessor implements DelimiterProcessor {
    private final char a;

    /* JADX INFO: Access modifiers changed from: protected */
    public EmphasisDelimiterProcessor(char c) {
        this.a = c;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return this.a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        if ((delimiterRun.b() || delimiterRun2.a()) && delimiterRun2.d() % 3 != 0 && (delimiterRun.d() + delimiterRun2.d()) % 3 == 0) {
            return 0;
        }
        return (delimiterRun.c() < 2 || delimiterRun2.c() < 2) ? 1 : 2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return 1;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return this.a;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text text, Text text2, int i) {
        Emphasis strongEmphasis;
        String valueOf = String.valueOf(getOpeningCharacter());
        if (i == 1) {
            strongEmphasis = new Emphasis(valueOf);
        } else {
            strongEmphasis = new StrongEmphasis(valueOf + valueOf);
        }
        Node h = text.h();
        while (true) {
            Node node = h;
            if (node == null || node == text2) {
                break;
            }
            Node h2 = node.h();
            strongEmphasis.b(node);
            h = h2;
        }
        text.c(strongEmphasis);
    }
}
