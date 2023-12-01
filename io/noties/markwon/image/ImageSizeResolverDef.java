package io.noties.markwon.image;

import android.graphics.Rect;
import io.noties.markwon.image.ImageSize;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/ImageSizeResolverDef.class */
public class ImageSizeResolverDef extends ImageSizeResolver {
    protected static final String UNIT_EM = "em";
    protected static final String UNIT_PERCENT = "%";

    protected int resolveAbsolute(ImageSize.Dimension dimension, int i, float f) {
        return (int) ((UNIT_EM.equals(dimension.unit) ? dimension.value * f : dimension.value) + 0.5f);
    }

    @Override // io.noties.markwon.image.ImageSizeResolver
    public Rect resolveImageSize(AsyncDrawable asyncDrawable) {
        return resolveImageSize(asyncDrawable.getImageSize(), asyncDrawable.getResult().getBounds(), asyncDrawable.getLastKnownCanvasWidth(), asyncDrawable.getLastKnowTextSize());
    }

    protected Rect resolveImageSize(ImageSize imageSize, Rect rect, int i, float f) {
        Rect rect2;
        if (imageSize == null) {
            int width = rect.width();
            Rect rect3 = rect;
            if (width > i) {
                rect3 = new Rect(0, 0, i, (int) ((rect.height() / (width / i)) + 0.5f));
            }
            return rect3;
        }
        ImageSize.Dimension dimension = imageSize.width;
        ImageSize.Dimension dimension2 = imageSize.height;
        int width2 = rect.width();
        int height = rect.height();
        float f2 = width2 / height;
        if (dimension != null) {
            int resolveAbsolute = UNIT_PERCENT.equals(dimension.unit) ? (int) ((i * (dimension.value / 100.0f)) + 0.5f) : resolveAbsolute(dimension, width2, f);
            rect2 = new Rect(0, 0, resolveAbsolute, (dimension2 == null || UNIT_PERCENT.equals(dimension2.unit)) ? (int) ((resolveAbsolute / f2) + 0.5f) : resolveAbsolute(dimension2, height, f));
        } else {
            rect2 = rect;
            if (dimension2 != null) {
                rect2 = rect;
                if (!UNIT_PERCENT.equals(dimension2.unit)) {
                    int resolveAbsolute2 = resolveAbsolute(dimension2, height, f);
                    rect2 = new Rect(0, 0, (int) ((resolveAbsolute2 * f2) + 0.5f), resolveAbsolute2);
                }
            }
        }
        return rect2;
    }
}
