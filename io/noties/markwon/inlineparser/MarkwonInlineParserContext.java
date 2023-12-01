package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.internal.Bracket;
import org.commonmark.internal.Delimiter;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParserContext.class */
public interface MarkwonInlineParserContext {
    void addBracket(Bracket bracket);

    Node block();

    LinkReferenceDefinition getLinkReferenceDefinition(String str);

    int index();

    String input();

    Bracket lastBracket();

    Delimiter lastDelimiter();

    String match(Pattern pattern);

    String parseLinkDestination();

    int parseLinkLabel();

    String parseLinkTitle();

    char peek();

    void processDelimiters(Delimiter delimiter);

    void removeLastBracket();

    void setIndex(int i);

    void spnl();

    Text text(String str);

    Text text(String str, int i, int i2);
}
