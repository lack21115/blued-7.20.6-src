package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.internal.Bracket;
import org.commonmark.internal.Delimiter;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/InlineProcessor.class */
public abstract class InlineProcessor {
    protected Node block;
    protected MarkwonInlineParserContext context;
    protected int index;
    protected String input;

    /* JADX INFO: Access modifiers changed from: protected */
    public void addBracket(Bracket bracket) {
        this.context.addBracket(bracket);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bracket lastBracket() {
        return this.context.lastBracket();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Delimiter lastDelimiter() {
        return this.context.lastDelimiter();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String match(Pattern pattern) {
        this.context.setIndex(this.index);
        String match = this.context.match(pattern);
        this.index = this.context.index();
        return match;
    }

    protected abstract Node parse();

    public Node parse(MarkwonInlineParserContext markwonInlineParserContext) {
        this.context = markwonInlineParserContext;
        this.block = markwonInlineParserContext.block();
        this.input = markwonInlineParserContext.input();
        this.index = markwonInlineParserContext.index();
        Node parse = parse();
        markwonInlineParserContext.setIndex(this.index);
        return parse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String parseLinkDestination() {
        this.context.setIndex(this.index);
        String parseLinkDestination = this.context.parseLinkDestination();
        this.index = this.context.index();
        return parseLinkDestination;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int parseLinkLabel() {
        this.context.setIndex(this.index);
        int parseLinkLabel = this.context.parseLinkLabel();
        this.index = this.context.index();
        return parseLinkLabel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String parseLinkTitle() {
        this.context.setIndex(this.index);
        String parseLinkTitle = this.context.parseLinkTitle();
        this.index = this.context.index();
        return parseLinkTitle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public char peek() {
        this.context.setIndex(this.index);
        return this.context.peek();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processDelimiters(Delimiter delimiter) {
        this.context.setIndex(this.index);
        this.context.processDelimiters(delimiter);
        this.index = this.context.index();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeLastBracket() {
        this.context.removeLastBracket();
    }

    public abstract char specialCharacter();

    /* JADX INFO: Access modifiers changed from: protected */
    public void spnl() {
        this.context.setIndex(this.index);
        this.context.spnl();
        this.index = this.context.index();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Text text(String str) {
        return this.context.text(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Text text(String str, int i, int i2) {
        return this.context.text(str, i, i2);
    }
}
