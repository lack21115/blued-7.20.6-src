package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/Palette.class */
public final class Palette {

    /* renamed from: a  reason: collision with root package name */
    static final Filter f3188a = new Filter() { // from class: androidx.palette.graphics.Palette.1
        private boolean a(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private boolean b(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        private boolean c(float[] fArr) {
            boolean z = false;
            if (fArr[0] >= 10.0f) {
                z = false;
                if (fArr[0] <= 37.0f) {
                    z = false;
                    if (fArr[1] <= 0.82f) {
                        z = true;
                    }
                }
            }
            return z;
        }

        @Override // androidx.palette.graphics.Palette.Filter
        public boolean isAllowed(int i, float[] fArr) {
            return (b(fArr) || a(fArr) || c(fArr)) ? false : true;
        }
    };
    private final List<Swatch> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Target> f3189c;
    private final SparseBooleanArray e = new SparseBooleanArray();
    private final Map<Target, Swatch> d = new ArrayMap();
    private final Swatch f = b();

    /* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/Palette$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<Swatch> f3190a;
        private final Bitmap b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Target> f3191c = new ArrayList();
        private int d = 16;
        private int e = 12544;
        private int f = -1;
        private final List<Filter> g = new ArrayList();
        private Rect h;

        public Builder(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.g.add(Palette.f3188a);
            this.b = bitmap;
            this.f3190a = null;
            this.f3191c.add(Target.LIGHT_VIBRANT);
            this.f3191c.add(Target.VIBRANT);
            this.f3191c.add(Target.DARK_VIBRANT);
            this.f3191c.add(Target.LIGHT_MUTED);
            this.f3191c.add(Target.MUTED);
            this.f3191c.add(Target.DARK_MUTED);
        }

        public Builder(List<Swatch> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("List of Swatches is not valid");
            }
            this.g.add(Palette.f3188a);
            this.f3190a = list;
            this.b = null;
        }

        private int[] a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.h.height();
            int[] iArr2 = new int[width2 * height2];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= height2) {
                    return iArr2;
                }
                System.arraycopy((Object) iArr, ((this.h.top + i2) * width) + this.h.left, (Object) iArr2, i2 * width2, width2);
                i = i2 + 1;
            }
        }

        private Bitmap b(Bitmap bitmap) {
            double d;
            if (this.e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i = this.e;
                d = -1.0d;
                if (width > i) {
                    d = Math.sqrt(i / width);
                }
            } else {
                d = -1.0d;
                if (this.f > 0) {
                    int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
                    int i2 = this.f;
                    d = -1.0d;
                    if (max > i2) {
                        d = i2 / max;
                    }
                }
            }
            return d <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d), (int) Math.ceil(bitmap.getHeight() * d), false);
        }

        public Builder addFilter(Filter filter) {
            if (filter != null) {
                this.g.add(filter);
            }
            return this;
        }

        public Builder addTarget(Target target) {
            if (!this.f3191c.contains(target)) {
                this.f3191c.add(target);
            }
            return this;
        }

        public Builder clearFilters() {
            this.g.clear();
            return this;
        }

        public Builder clearRegion() {
            this.h = null;
            return this;
        }

        public Builder clearTargets() {
            List<Target> list = this.f3191c;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        public AsyncTask<Bitmap, Void, Palette> generate(final PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener != null) {
                return new AsyncTask<Bitmap, Void, Palette>() { // from class: androidx.palette.graphics.Palette.Builder.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public Palette doInBackground(Bitmap... bitmapArr) {
                        try {
                            return Builder.this.generate();
                        } catch (Exception e) {
                            Log.e("Palette", "Exception thrown during async generate", e);
                            return null;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public void onPostExecute(Palette palette) {
                        paletteAsyncListener.onGenerated(palette);
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.b);
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        public Palette generate() {
            List<Swatch> list;
            Filter[] filterArr;
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                Bitmap b = b(bitmap);
                Rect rect = this.h;
                if (b != this.b && rect != null) {
                    double width = b.getWidth() / this.b.getWidth();
                    rect.left = (int) Math.floor(rect.left * width);
                    rect.top = (int) Math.floor(rect.top * width);
                    rect.right = Math.min((int) Math.ceil(rect.right * width), b.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(rect.bottom * width), b.getHeight());
                }
                int[] a2 = a(b);
                int i = this.d;
                if (this.g.isEmpty()) {
                    filterArr = null;
                } else {
                    List<Filter> list2 = this.g;
                    filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                }
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(a2, i, filterArr);
                if (b != this.b) {
                    b.recycle();
                }
                list = colorCutQuantizer.a();
            } else {
                list = this.f3190a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            Palette palette = new Palette(list, this.f3191c);
            palette.a();
            return palette;
        }

        public Builder maximumColorCount(int i) {
            this.d = i;
            return this;
        }

        public Builder resizeBitmapArea(int i) {
            this.e = i;
            this.f = -1;
            return this;
        }

        @Deprecated
        public Builder resizeBitmapSize(int i) {
            this.f = i;
            this.e = -1;
            return this;
        }

        public Builder setRegion(int i, int i2, int i3, int i4) {
            if (this.b != null) {
                if (this.h == null) {
                    this.h = new Rect();
                }
                this.h.set(0, 0, this.b.getWidth(), this.b.getHeight());
                if (this.h.intersect(i, i2, i3, i4)) {
                    return this;
                }
                throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
            }
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/Palette$Filter.class */
    public interface Filter {
        boolean isAllowed(int i, float[] fArr);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/Palette$PaletteAsyncListener.class */
    public interface PaletteAsyncListener {
        void onGenerated(Palette palette);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/palette/graphics/Palette$Swatch.class */
    public static final class Swatch {

        /* renamed from: a  reason: collision with root package name */
        private final int f3193a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3194c;
        private final int d;
        private final int e;
        private boolean f;
        private int g;
        private int h;
        private float[] i;

        public Swatch(int i, int i2) {
            this.f3193a = Color.red(i);
            this.b = Color.green(i);
            this.f3194c = Color.blue(i);
            this.d = i;
            this.e = i2;
        }

        private void a() {
            if (this.f) {
                return;
            }
            int calculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(-1, this.d, 4.5f);
            int calculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(-1, this.d, 3.0f);
            if (calculateMinimumAlpha != -1 && calculateMinimumAlpha2 != -1) {
                this.h = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                this.g = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                this.f = true;
                return;
            }
            int calculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(-16777216, this.d, 4.5f);
            int calculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(-16777216, this.d, 3.0f);
            if (calculateMinimumAlpha3 == -1 || calculateMinimumAlpha4 == -1) {
                this.h = calculateMinimumAlpha != -1 ? ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha) : ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
                this.g = calculateMinimumAlpha2 != -1 ? ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2) : ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
                this.f = true;
                return;
            }
            this.h = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
            this.g = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
            this.f = true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            return this.e == swatch.e && this.d == swatch.d;
        }

        public int getBodyTextColor() {
            a();
            return this.h;
        }

        public float[] getHsl() {
            if (this.i == null) {
                this.i = new float[3];
            }
            ColorUtils.RGBToHSL(this.f3193a, this.b, this.f3194c, this.i);
            return this.i;
        }

        public int getPopulation() {
            return this.e;
        }

        public int getRgb() {
            return this.d;
        }

        public int getTitleTextColor() {
            a();
            return this.g;
        }

        public int hashCode() {
            return (this.d * 31) + this.e;
        }

        public String toString() {
            return getClass().getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.e + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
        }
    }

    Palette(List<Swatch> list, List<Target> list2) {
        this.b = list;
        this.f3189c = list2;
    }

    private Swatch a(Target target) {
        Swatch b = b(target);
        if (b != null && target.isExclusive()) {
            this.e.append(b.getRgb(), true);
        }
        return b;
    }

    private boolean a(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        return hsl[1] >= target.getMinimumSaturation() && hsl[1] <= target.getMaximumSaturation() && hsl[2] >= target.getMinimumLightness() && hsl[2] <= target.getMaximumLightness() && !this.e.get(swatch.getRgb());
    }

    private float b(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        Swatch swatch2 = this.f;
        int population = swatch2 != null ? swatch2.getPopulation() : 1;
        float f = 0.0f;
        float saturationWeight = target.getSaturationWeight() > 0.0f ? target.getSaturationWeight() * (1.0f - Math.abs(hsl[1] - target.getTargetSaturation())) : 0.0f;
        float lightnessWeight = target.getLightnessWeight() > 0.0f ? target.getLightnessWeight() * (1.0f - Math.abs(hsl[2] - target.getTargetLightness())) : 0.0f;
        if (target.getPopulationWeight() > 0.0f) {
            f = target.getPopulationWeight() * (swatch.getPopulation() / population);
        }
        return saturationWeight + lightnessWeight + f;
    }

    private Swatch b() {
        int size = this.b.size();
        int i = Integer.MIN_VALUE;
        Swatch swatch = null;
        int i2 = 0;
        while (i2 < size) {
            Swatch swatch2 = this.b.get(i2);
            int i3 = i;
            if (swatch2.getPopulation() > i) {
                i3 = swatch2.getPopulation();
                swatch = swatch2;
            }
            i2++;
            i = i3;
        }
        return swatch;
    }

    private Swatch b(Target target) {
        int size = this.b.size();
        float f = 0.0f;
        Swatch swatch = null;
        int i = 0;
        while (i < size) {
            Swatch swatch2 = this.b.get(i);
            float f2 = f;
            Swatch swatch3 = swatch;
            if (a(swatch2, target)) {
                float b = b(swatch2, target);
                if (swatch != null) {
                    f2 = f;
                    swatch3 = swatch;
                    if (b <= f) {
                    }
                }
                swatch3 = swatch2;
                f2 = b;
            }
            i++;
            f = f2;
            swatch = swatch3;
        }
        return swatch;
    }

    public static Builder from(Bitmap bitmap) {
        return new Builder(bitmap);
    }

    public static Palette from(List<Swatch> list) {
        return new Builder(list).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap) {
        return from(bitmap).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap, int i) {
        return from(bitmap).maximumColorCount(i).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, int i, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).maximumColorCount(i).generate(paletteAsyncListener);
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).generate(paletteAsyncListener);
    }

    void a() {
        int size = this.f3189c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.e.clear();
                return;
            }
            Target target = this.f3189c.get(i2);
            target.a();
            this.d.put(target, a(target));
            i = i2 + 1;
        }
    }

    public int getColorForTarget(Target target, int i) {
        Swatch swatchForTarget = getSwatchForTarget(target);
        if (swatchForTarget != null) {
            i = swatchForTarget.getRgb();
        }
        return i;
    }

    public int getDarkMutedColor(int i) {
        return getColorForTarget(Target.DARK_MUTED, i);
    }

    public Swatch getDarkMutedSwatch() {
        return getSwatchForTarget(Target.DARK_MUTED);
    }

    public int getDarkVibrantColor(int i) {
        return getColorForTarget(Target.DARK_VIBRANT, i);
    }

    public Swatch getDarkVibrantSwatch() {
        return getSwatchForTarget(Target.DARK_VIBRANT);
    }

    public int getDominantColor(int i) {
        Swatch swatch = this.f;
        if (swatch != null) {
            i = swatch.getRgb();
        }
        return i;
    }

    public Swatch getDominantSwatch() {
        return this.f;
    }

    public int getLightMutedColor(int i) {
        return getColorForTarget(Target.LIGHT_MUTED, i);
    }

    public Swatch getLightMutedSwatch() {
        return getSwatchForTarget(Target.LIGHT_MUTED);
    }

    public int getLightVibrantColor(int i) {
        return getColorForTarget(Target.LIGHT_VIBRANT, i);
    }

    public Swatch getLightVibrantSwatch() {
        return getSwatchForTarget(Target.LIGHT_VIBRANT);
    }

    public int getMutedColor(int i) {
        return getColorForTarget(Target.MUTED, i);
    }

    public Swatch getMutedSwatch() {
        return getSwatchForTarget(Target.MUTED);
    }

    public Swatch getSwatchForTarget(Target target) {
        return this.d.get(target);
    }

    public List<Swatch> getSwatches() {
        return Collections.unmodifiableList(this.b);
    }

    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.f3189c);
    }

    public int getVibrantColor(int i) {
        return getColorForTarget(Target.VIBRANT, i);
    }

    public Swatch getVibrantSwatch() {
        return getSwatchForTarget(Target.VIBRANT);
    }
}
