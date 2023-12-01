package io.noties.markwon.core.factory;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.spans.CodeBlockSpan;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/factory/CodeBlockSpanFactory.class */
public class CodeBlockSpanFactory implements SpanFactory {
    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new CodeBlockSpan(markwonConfiguration.theme());
    }
}
