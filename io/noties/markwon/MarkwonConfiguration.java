package io.noties.markwon;

import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.ImageSizeResolver;
import io.noties.markwon.image.ImageSizeResolverDef;
import io.noties.markwon.image.destination.ImageDestinationProcessor;
import io.noties.markwon.syntax.SyntaxHighlight;
import io.noties.markwon.syntax.SyntaxHighlightNoOp;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonConfiguration.class */
public class MarkwonConfiguration {
    private final AsyncDrawableLoader asyncDrawableLoader;
    private final ImageDestinationProcessor imageDestinationProcessor;
    private final ImageSizeResolver imageSizeResolver;
    private final LinkResolver linkResolver;
    private final MarkwonSpansFactory spansFactory;
    private final SyntaxHighlight syntaxHighlight;
    private final MarkwonTheme theme;

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonConfiguration$Builder.class */
    public static class Builder {
        private AsyncDrawableLoader asyncDrawableLoader;
        private ImageDestinationProcessor imageDestinationProcessor;
        private ImageSizeResolver imageSizeResolver;
        private LinkResolver linkResolver;
        private MarkwonSpansFactory spansFactory;
        private SyntaxHighlight syntaxHighlight;
        private MarkwonTheme theme;

        public Builder asyncDrawableLoader(AsyncDrawableLoader asyncDrawableLoader) {
            this.asyncDrawableLoader = asyncDrawableLoader;
            return this;
        }

        public MarkwonConfiguration build(MarkwonTheme markwonTheme, MarkwonSpansFactory markwonSpansFactory) {
            this.theme = markwonTheme;
            this.spansFactory = markwonSpansFactory;
            if (this.asyncDrawableLoader == null) {
                this.asyncDrawableLoader = AsyncDrawableLoader.noOp();
            }
            if (this.syntaxHighlight == null) {
                this.syntaxHighlight = new SyntaxHighlightNoOp();
            }
            if (this.linkResolver == null) {
                this.linkResolver = new LinkResolverDef();
            }
            if (this.imageDestinationProcessor == null) {
                this.imageDestinationProcessor = ImageDestinationProcessor.noOp();
            }
            if (this.imageSizeResolver == null) {
                this.imageSizeResolver = new ImageSizeResolverDef();
            }
            return new MarkwonConfiguration(this);
        }

        public Builder imageDestinationProcessor(ImageDestinationProcessor imageDestinationProcessor) {
            this.imageDestinationProcessor = imageDestinationProcessor;
            return this;
        }

        public Builder imageSizeResolver(ImageSizeResolver imageSizeResolver) {
            this.imageSizeResolver = imageSizeResolver;
            return this;
        }

        public Builder linkResolver(LinkResolver linkResolver) {
            this.linkResolver = linkResolver;
            return this;
        }

        public Builder syntaxHighlight(SyntaxHighlight syntaxHighlight) {
            this.syntaxHighlight = syntaxHighlight;
            return this;
        }
    }

    private MarkwonConfiguration(Builder builder) {
        this.theme = builder.theme;
        this.asyncDrawableLoader = builder.asyncDrawableLoader;
        this.syntaxHighlight = builder.syntaxHighlight;
        this.linkResolver = builder.linkResolver;
        this.imageDestinationProcessor = builder.imageDestinationProcessor;
        this.imageSizeResolver = builder.imageSizeResolver;
        this.spansFactory = builder.spansFactory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public AsyncDrawableLoader asyncDrawableLoader() {
        return this.asyncDrawableLoader;
    }

    public ImageDestinationProcessor imageDestinationProcessor() {
        return this.imageDestinationProcessor;
    }

    public ImageSizeResolver imageSizeResolver() {
        return this.imageSizeResolver;
    }

    public LinkResolver linkResolver() {
        return this.linkResolver;
    }

    public MarkwonSpansFactory spansFactory() {
        return this.spansFactory;
    }

    public SyntaxHighlight syntaxHighlight() {
        return this.syntaxHighlight;
    }

    public MarkwonTheme theme() {
        return this.theme;
    }
}
