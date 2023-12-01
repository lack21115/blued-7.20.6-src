package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.bumptech.glide.load.Option;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DownsampleStrategy.class */
public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f20947a = new AtLeast();
    public static final DownsampleStrategy b = new AtMost();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f20948c = new FitCenter();
    public static final DownsampleStrategy d = new CenterInside();
    public static final DownsampleStrategy e = new CenterOutside();
    public static final DownsampleStrategy f = new None();
    public static final DownsampleStrategy g;
    public static final Option<DownsampleStrategy> h;
    static final boolean i;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DownsampleStrategy$AtLeast.class */
    static class AtLeast extends DownsampleStrategy {
        AtLeast() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DownsampleStrategy$AtMost.class */
    static class AtMost extends DownsampleStrategy {
        AtMost() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            int max;
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int i5 = 1;
            if (Math.max(1, Integer.highestOneBit(ceil)) >= ceil) {
                i5 = 0;
            }
            return 1.0f / (max << i5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DownsampleStrategy$CenterInside.class */
    static class CenterInside extends DownsampleStrategy {
        CenterInside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, f20948c.a(i, i2, i3, i4));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return a(i, i2, i3, i4) == 1.0f ? SampleSizeRounding.QUALITY : f20948c.b(i, i2, i3, i4);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DownsampleStrategy$CenterOutside.class */
    static class CenterOutside extends DownsampleStrategy {
        CenterOutside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DownsampleStrategy$FitCenter.class */
    static class FitCenter extends DownsampleStrategy {
        FitCenter() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            if (i) {
                return Math.min(i3 / i, i4 / i2);
            }
            int max = Math.max(i2 / i4, i / i3);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(max);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return i ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DownsampleStrategy$None.class */
    static class None extends DownsampleStrategy {
        None() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DownsampleStrategy$SampleSizeRounding.class */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    static {
        DownsampleStrategy downsampleStrategy = e;
        g = downsampleStrategy;
        h = Option.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
        i = Build.VERSION.SDK_INT >= 19;
    }

    public abstract float a(int i2, int i3, int i4, int i5);

    public abstract SampleSizeRounding b(int i2, int i3, int i4, int i5);
}
