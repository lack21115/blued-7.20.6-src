package io.noties.markwon.image;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/ImageSize.class */
public class ImageSize {
    public final Dimension height;
    public final Dimension width;

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/ImageSize$Dimension.class */
    public static class Dimension {
        public final String unit;
        public final float value;

        public Dimension(float f, String str) {
            this.value = f;
            this.unit = str;
        }

        public String toString() {
            return "Dimension{value=" + this.value + ", unit='" + this.unit + "'}";
        }
    }

    public ImageSize(Dimension dimension, Dimension dimension2) {
        this.width = dimension;
        this.height = dimension2;
    }

    public String toString() {
        return "ImageSize{width=" + this.width + ", height=" + this.height + '}';
    }
}
