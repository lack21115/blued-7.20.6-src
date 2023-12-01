package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.node.Node;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/EntityInlineProcessor.class */
public class EntityInlineProcessor extends InlineProcessor {
    private static final Pattern ENTITY_HERE = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        String match = match(ENTITY_HERE);
        if (match != null) {
            return text(Html5Entities.a(match));
        }
        return null;
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '&';
    }
}
