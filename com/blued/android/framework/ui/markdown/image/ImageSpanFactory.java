package com.blued.android.framework.ui.markdown.image;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.image.ImageProps;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/image/ImageSpanFactory.class */
public class ImageSpanFactory implements SpanFactory {
    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new AsyncDrawableSpan(markwonConfiguration.theme(), new AsyncDrawable(ImageProps.DESTINATION.require(renderProps), markwonConfiguration.asyncDrawableLoader(), markwonConfiguration.imageSizeResolver(), ImageProps.IMAGE_SIZE.get(renderProps)), 2, ImageProps.REPLACEMENT_TEXT_IS_LINK.get(renderProps, false).booleanValue());
    }
}
