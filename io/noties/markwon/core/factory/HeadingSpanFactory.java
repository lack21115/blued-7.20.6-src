package io.noties.markwon.core.factory;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.HeadingSpan;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/factory/HeadingSpanFactory.class */
public class HeadingSpanFactory implements SpanFactory {
    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new HeadingSpan(markwonConfiguration.theme(), CoreProps.HEADING_LEVEL.require(renderProps).intValue());
    }
}
