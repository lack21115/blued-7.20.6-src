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

    /* renamed from: a  reason: collision with root package name */
    private final List<BlockParserFactory> f44069a;
    private final List<DelimiterProcessor> b;

    /* renamed from: c  reason: collision with root package name */
    private final InlineParserFactory f44070c;
    private final List<PostProcessor> d;

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/parser/Parser$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<BlockParserFactory> f44071a = new ArrayList();
        private final List<DelimiterProcessor> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<PostProcessor> f44072c = new ArrayList();
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
        this.f44069a = DocumentParser.a(builder.f44071a, builder.d);
        this.f44070c = builder.b();
        this.d = builder.f44072c;
        List<DelimiterProcessor> list = builder.b;
        this.b = list;
        this.f44070c.create(new InlineParserContextImpl(list, Collections.emptyMap()));
    }

    private DocumentParser a() {
        return new DocumentParser(this.f44069a, this.f44070c, this.b);
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
