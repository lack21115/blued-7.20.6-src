package io.noties.markwon.inlineparser;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.inlineparser.MarkwonInlineParser;
import org.commonmark.parser.Parser;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParserPlugin.class */
public class MarkwonInlineParserPlugin extends AbstractMarkwonPlugin {
    private final MarkwonInlineParser.FactoryBuilder factoryBuilder;

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/inlineparser/MarkwonInlineParserPlugin$BuilderConfigure.class */
    public interface BuilderConfigure<B extends MarkwonInlineParser.FactoryBuilder> {
        void configureBuilder(B b);
    }

    MarkwonInlineParserPlugin(MarkwonInlineParser.FactoryBuilder factoryBuilder) {
        this.factoryBuilder = factoryBuilder;
    }

    public static MarkwonInlineParserPlugin create() {
        return create(MarkwonInlineParser.factoryBuilder());
    }

    public static MarkwonInlineParserPlugin create(MarkwonInlineParser.FactoryBuilder factoryBuilder) {
        return new MarkwonInlineParserPlugin(factoryBuilder);
    }

    public static <B extends MarkwonInlineParser.FactoryBuilder> MarkwonInlineParserPlugin create(B b, BuilderConfigure<B> builderConfigure) {
        builderConfigure.configureBuilder(b);
        return new MarkwonInlineParserPlugin(b);
    }

    public static MarkwonInlineParserPlugin create(BuilderConfigure<MarkwonInlineParser.FactoryBuilder> builderConfigure) {
        MarkwonInlineParser.FactoryBuilder factoryBuilder = MarkwonInlineParser.factoryBuilder();
        builderConfigure.configureBuilder(factoryBuilder);
        return new MarkwonInlineParserPlugin(factoryBuilder);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
        builder.a(this.factoryBuilder.build());
    }

    public MarkwonInlineParser.FactoryBuilder factoryBuilder() {
        return this.factoryBuilder;
    }
}
