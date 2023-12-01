package org.commonmark.internal;

import java.util.List;
import java.util.Map;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/internal/InlineParserContextImpl.class */
public class InlineParserContextImpl implements InlineParserContext {
    private final List<DelimiterProcessor> a;
    private final Map<String, LinkReferenceDefinition> b;

    public InlineParserContextImpl(List<DelimiterProcessor> list, Map<String, LinkReferenceDefinition> map) {
        this.a = list;
        this.b = map;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public List<DelimiterProcessor> a() {
        return this.a;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public LinkReferenceDefinition a(String str) {
        return this.b.get(str);
    }
}
