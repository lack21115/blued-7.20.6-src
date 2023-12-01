package org.commonmark.parser;

import java.util.List;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/InlineParserContext.class */
public interface InlineParserContext {
    List<DelimiterProcessor> a();

    LinkReferenceDefinition a(String str);
}
