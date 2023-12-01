package org.commonmark.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.commonmark.Extension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.InlineParserContextImpl;
import org.commonmark.internal.InlineParserImpl;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/Parser.class */
public class Parser {
    private final List<BlockParserFactory> a;
    private final List<DelimiterProcessor> b;
    private final InlineParserFactory c;
    private final List<PostProcessor> d;

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/Parser$Builder.class */
    public static class Builder {
        private final List<BlockParserFactory> a = new ArrayList();
        private final List<DelimiterProcessor> b = new ArrayList();
        private final List<PostProcessor> c = new ArrayList();
        private Set<Class<? extends Block>> d = DocumentParser.a();
        private InlineParserFactory e;

        /* JADX INFO: Access modifiers changed from: private */
        public InlineParserFactory b() {
            InlineParserFactory inlineParserFactory = this.e;
            return inlineParserFactory != null ? inlineParserFactory : new InlineParserFactory() { // from class: org.commonmark.parser.Parser.Builder.1
                @Override // org.commonmark.parser.InlineParserFactory
                public InlineParser create(InlineParserContext inlineParserContext) {
                    return new InlineParserImpl(inlineParserContext);
                }
            };
        }

        public Builder a(Set<Class<? extends Block>> set) {
            if (set != null) {
                this.d = set;
                return this;
            }
            throw new NullPointerException("enabledBlockTypes must not be null");
        }

        public Builder a(InlineParserFactory inlineParserFactory) {
            this.e = inlineParserFactory;
            return this;
        }

        public Builder a(DelimiterProcessor delimiterProcessor) {
            if (delimiterProcessor != null) {
                this.b.add(delimiterProcessor);
                return this;
            }
            throw new NullPointerException("delimiterProcessor must not be null");
        }

        public Parser a() {
            return new Parser(this);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/Parser$ParserExtension.class */
    public interface ParserExtension extends Extension {
    }

    private Parser(Builder builder) {
        this.a = DocumentParser.a(builder.a, builder.d);
        this.c = builder.b();
        this.d = builder.c;
        List<DelimiterProcessor> list = builder.b;
        this.b = list;
        this.c.create(new InlineParserContextImpl(list, Collections.emptyMap()));
    }

    private DocumentParser a() {
        return new DocumentParser(this.a, this.c, this.b);
    }

    private Node a(Node node) {
        for (PostProcessor postProcessor : this.d) {
            node = postProcessor.a(node);
        }
        return node;
    }

    public Node a(String str) {
        if (str != null) {
            return a(a().a(str));
        }
        throw new NullPointerException("input must not be null");
    }
}
