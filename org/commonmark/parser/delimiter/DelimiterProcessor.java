package org.commonmark.parser.delimiter;

import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/delimiter/DelimiterProcessor.class */
public interface DelimiterProcessor {
    char getClosingCharacter();

    int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2);

    int getMinLength();

    char getOpeningCharacter();

    void process(Text text, Text text2, int i);
}
