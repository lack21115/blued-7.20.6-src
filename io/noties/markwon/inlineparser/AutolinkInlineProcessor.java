package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/AutolinkInlineProcessor.class */
public class AutolinkInlineProcessor extends InlineProcessor {
    private static final Pattern EMAIL_AUTOLINK = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    private static final Pattern AUTOLINK = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>��- ]*>");

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        String match = match(EMAIL_AUTOLINK);
        if (match != null) {
            String substring = match.substring(1, match.length() - 1);
            Link link = new Link("mailto:" + substring, null);
            link.b(new Text(substring));
            return link;
        }
        String match2 = match(AUTOLINK);
        if (match2 != null) {
            String substring2 = match2.substring(1, match2.length() - 1);
            Link link2 = new Link(substring2, null);
            link2.b(new Text(substring2));
            return link2;
        }
        return null;
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '<';
    }
}
