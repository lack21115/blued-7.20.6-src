package com.android.internal.util.cm.palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/palette/Palette.class */
public final class Palette {
    private static final int CALCULATE_BITMAP_MIN_DIMENSION = 100;
    private static final int DEFAULT_CALCULATE_NUMBER_COLORS = 16;
    private static final float MAX_DARK_LUMA = 0.45f;
    private static final float MAX_MUTED_SATURATION = 0.4f;
    private static final float MAX_NORMAL_LUMA = 0.7f;
    private static final float MIN_CONTRAST_BODY_TEXT = 4.5f;
    private static final float MIN_CONTRAST_TITLE_TEXT = 3.0f;
    private static final float MIN_LIGHT_LUMA = 0.55f;
    private static final float MIN_NORMAL_LUMA = 0.3f;
    private static final float MIN_VIBRANT_SATURATION = 0.35f;
    private static final float TARGET_DARK_LUMA = 0.26f;
    private static final float TARGET_LIGHT_LUMA = 0.74f;
    private static final float TARGET_MUTED_SATURATION = 0.3f;
    private static final float TARGET_NORMAL_LUMA = 0.5f;
    private static final float TARGET_VIBRANT_SATURATION = 1.0f;
    private static final float WEIGHT_LUMA = 6.0f;
    private static final float WEIGHT_POPULATION = 1.0f;
    private static final float WEIGHT_SATURATION = 3.0f;
    private final List<Swatch> mSwatches;
    private final int mHighestPopulation = findMaxPopulation();
    private Swatch mVibrantSwatch = findColor(TARGET_NORMAL_LUMA, 0.3f, MAX_NORMAL_LUMA, 1.0f, MIN_VIBRANT_SATURATION, 1.0f);
    private Swatch mLightVibrantSwatch = findColor(TARGET_LIGHT_LUMA, MIN_LIGHT_LUMA, 1.0f, 1.0f, MIN_VIBRANT_SATURATION, 1.0f);
    private Swatch mDarkVibrantSwatch = findColor(TARGET_DARK_LUMA, 0.0f, MAX_DARK_LUMA, 1.0f, MIN_VIBRANT_SATURATION, 1.0f);
    private Swatch mMutedSwatch = findColor(TARGET_NORMAL_LUMA, 0.3f, MAX_NORMAL_LUMA, 0.3f, 0.0f, MAX_MUTED_SATURATION);
    private Swatch mLightMutedColor = findColor(TARGET_LIGHT_LUMA, MIN_LIGHT_LUMA, 1.0f, 0.3f, 0.0f, MAX_MUTED_SATURATION);
    private Swatch mDarkMutedSwatch = findColor(TARGET_DARK_LUMA, 0.0f, MAX_DARK_LUMA, 0.3f, 0.0f, MAX_MUTED_SATURATION);

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/palette/Palette$PaletteAsyncListener.class */
    public interface PaletteAsyncListener {
        void onGenerated(Palette palette);
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/palette/Palette$Swatch.class */
    public static final class Swatch {
        private final int mBlue;
        private int mBodyTextColor;
        private boolean mGeneratedTextColors;
        private final int mGreen;
        private float[] mHsl;
        private final int mPopulation;
        private final int mRed;
        private final int mRgb;
        private int mTitleTextColor;

        public Swatch(int i, int i2) {
            this.mRed = Color.red(i);
            this.mGreen = Color.green(i);
            this.mBlue = Color.blue(i);
            this.mRgb = i;
            this.mPopulation = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Swatch(int i, int i2, int i3, int i4) {
            this.mRed = i;
            this.mGreen = i2;
            this.mBlue = i3;
            this.mRgb = Color.rgb(i, i2, i3);
            this.mPopulation = i4;
        }

        private void ensureTextColorsGenerated() {
            if (this.mGeneratedTextColors) {
                return;
            }
            int textColorForBackground = ColorUtils.getTextColorForBackground(this.mRgb, -1, Palette.MIN_CONTRAST_BODY_TEXT);
            int textColorForBackground2 = ColorUtils.getTextColorForBackground(this.mRgb, -1, 3.0f);
            if (textColorForBackground != -1 && textColorForBackground2 != -1) {
                this.mBodyTextColor = textColorForBackground;
                this.mTitleTextColor = textColorForBackground2;
                this.mGeneratedTextColors = true;
                return;
            }
            int textColorForBackground3 = ColorUtils.getTextColorForBackground(this.mRgb, View.MEASURED_STATE_MASK, Palette.MIN_CONTRAST_BODY_TEXT);
            int textColorForBackground4 = ColorUtils.getTextColorForBackground(this.mRgb, View.MEASURED_STATE_MASK, 3.0f);
            if (textColorForBackground3 != -1 && textColorForBackground3 != -1) {
                this.mBodyTextColor = textColorForBackground3;
                this.mTitleTextColor = textColorForBackground4;
                this.mGeneratedTextColors = true;
                return;
            }
            if (textColorForBackground == -1) {
                textColorForBackground = textColorForBackground3;
            }
            this.mBodyTextColor = textColorForBackground;
            this.mTitleTextColor = textColorForBackground2 != -1 ? textColorForBackground2 : textColorForBackground4;
            this.mGeneratedTextColors = true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            return this.mPopulation == swatch.mPopulation && this.mRgb == swatch.mRgb;
        }

        public int getBodyTextColor() {
            ensureTextColorsGenerated();
            return this.mBodyTextColor;
        }

        public float[] getHsl() {
            if (this.mHsl == null) {
                this.mHsl = new float[3];
                ColorUtils.RGBtoHSL(this.mRed, this.mGreen, this.mBlue, this.mHsl);
            }
            return this.mHsl;
        }

        public int getPopulation() {
            return this.mPopulation;
        }

        public int getRgb() {
            return this.mRgb;
        }

        public int getTitleTextColor() {
            ensureTextColorsGenerated();
            return this.mTitleTextColor;
        }

        public int hashCode() {
            return (this.mRgb * 31) + this.mPopulation;
        }

        public String toString() {
            return getClass().getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.mPopulation + "] [Title Text: #" + Integer.toHexString(this.mTitleTextColor) + "] [Body Text: #" + Integer.toHexString(this.mBodyTextColor) + ']';
        }
    }

    private Palette(List<Swatch> list) {
        this.mSwatches = list;
        generateEmptySwatches();
    }

    private static void checkAsyncListenerParam(PaletteAsyncListener paletteAsyncListener) {
        if (paletteAsyncListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
    }

    private static void checkBitmapParam(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bitmap can not be null");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap can not be recycled");
        }
    }

    private static void checkNumberColorsParam(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("numColors must be 1 of greater");
        }
    }

    private static float[] copyHslValues(Swatch swatch) {
        float[] fArr = new float[3];
        System.arraycopy(swatch.getHsl(), 0, fArr, 0, 3);
        return fArr;
    }

    private static float createComparisonValue(float f, float f2, float f3, float f4, int i, int i2) {
        return weightedMean(invertDiff(f, f2), 3.0f, invertDiff(f3, f4), WEIGHT_LUMA, i / i2, 1.0f);
    }

    private Swatch findColor(float f, float f2, float f3, float f4, float f5, float f6) {
        Swatch swatch = null;
        float f7 = 0.0f;
        for (Swatch swatch2 : this.mSwatches) {
            float f8 = swatch2.getHsl()[1];
            float f9 = swatch2.getHsl()[2];
            if (f8 >= f5 && f8 <= f6 && f9 >= f2 && f9 <= f3 && !isAlreadySelected(swatch2)) {
                float createComparisonValue = createComparisonValue(f8, f4, f9, f, swatch2.getPopulation(), this.mHighestPopulation);
                if (swatch == null || createComparisonValue > f7) {
                    swatch = swatch2;
                    f7 = createComparisonValue;
                }
            }
        }
        return swatch;
    }

    private int findMaxPopulation() {
        int i = 0;
        for (Swatch swatch : this.mSwatches) {
            i = Math.max(i, swatch.getPopulation());
        }
        return i;
    }

    public static Palette from(List<Swatch> list) {
        if (list == null) {
            return null;
        }
        return new Palette(list);
    }

    public static Palette generate(Bitmap bitmap) {
        return generate(bitmap, 16);
    }

    public static Palette generate(Bitmap bitmap, int i) {
        checkBitmapParam(bitmap);
        checkNumberColorsParam(i);
        Bitmap scaleBitmapDown = scaleBitmapDown(bitmap);
        ColorCutQuantizer fromBitmap = ColorCutQuantizer.fromBitmap(scaleBitmapDown, i);
        if (scaleBitmapDown != bitmap) {
            scaleBitmapDown.recycle();
        }
        return new Palette(fromBitmap.getQuantizedColors());
    }

    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, final int i, final PaletteAsyncListener paletteAsyncListener) {
        checkBitmapParam(bitmap);
        checkNumberColorsParam(i);
        checkAsyncListenerParam(paletteAsyncListener);
        AsyncTask<Bitmap, Void, Palette> asyncTask = new AsyncTask<Bitmap, Void, Palette>() { // from class: com.android.internal.util.cm.palette.Palette.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Palette doInBackground(Bitmap... bitmapArr) {
                return Palette.generate(bitmapArr[0], i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Palette palette) {
                paletteAsyncListener.onGenerated(palette);
            }
        };
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, bitmap);
        return asyncTask;
    }

    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        return generateAsync(bitmap, 16, paletteAsyncListener);
    }

    private void generateEmptySwatches() {
        if (this.mVibrantSwatch == null && this.mDarkVibrantSwatch != null) {
            float[] copyHslValues = copyHslValues(this.mDarkVibrantSwatch);
            copyHslValues[2] = 0.5f;
            this.mVibrantSwatch = new Swatch(ColorUtils.HSLtoRGB(copyHslValues), 0);
        }
        if (this.mDarkVibrantSwatch != null || this.mVibrantSwatch == null) {
            return;
        }
        float[] copyHslValues2 = copyHslValues(this.mVibrantSwatch);
        copyHslValues2[2] = 0.26f;
        this.mDarkVibrantSwatch = new Swatch(ColorUtils.HSLtoRGB(copyHslValues2), 0);
    }

    private static float invertDiff(float f, float f2) {
        return 1.0f - Math.abs(f - f2);
    }

    private boolean isAlreadySelected(Swatch swatch) {
        return this.mVibrantSwatch == swatch || this.mDarkVibrantSwatch == swatch || this.mLightVibrantSwatch == swatch || this.mMutedSwatch == swatch || this.mDarkMutedSwatch == swatch || this.mLightMutedColor == swatch;
    }

    private static Bitmap scaleBitmapDown(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        if (min <= 100) {
            return bitmap;
        }
        float f = 100.0f / min;
        return Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f), Math.round(bitmap.getHeight() * f), false);
    }

    private static float weightedMean(float... fArr) {
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                return f / f2;
            }
            float f3 = fArr[i2];
            float f4 = fArr[i2 + 1];
            f += f3 * f4;
            f2 += f4;
            i = i2 + 2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Palette palette = (Palette) obj;
        if (this.mSwatches != null) {
            if (!this.mSwatches.equals(palette.mSwatches)) {
                return false;
            }
        } else if (palette.mSwatches != null) {
            return false;
        }
        if (this.mDarkMutedSwatch != null) {
            if (!this.mDarkMutedSwatch.equals(palette.mDarkMutedSwatch)) {
                return false;
            }
        } else if (palette.mDarkMutedSwatch != null) {
            return false;
        }
        if (this.mDarkVibrantSwatch != null) {
            if (!this.mDarkVibrantSwatch.equals(palette.mDarkVibrantSwatch)) {
                return false;
            }
        } else if (palette.mDarkVibrantSwatch != null) {
            return false;
        }
        if (this.mLightMutedColor != null) {
            if (!this.mLightMutedColor.equals(palette.mLightMutedColor)) {
                return false;
            }
        } else if (palette.mLightMutedColor != null) {
            return false;
        }
        if (this.mLightVibrantSwatch != null) {
            if (!this.mLightVibrantSwatch.equals(palette.mLightVibrantSwatch)) {
                return false;
            }
        } else if (palette.mLightVibrantSwatch != null) {
            return false;
        }
        if (this.mMutedSwatch != null) {
            if (!this.mMutedSwatch.equals(palette.mMutedSwatch)) {
                return false;
            }
        } else if (palette.mMutedSwatch != null) {
            return false;
        }
        return this.mVibrantSwatch != null ? this.mVibrantSwatch.equals(palette.mVibrantSwatch) : palette.mVibrantSwatch == null;
    }

    public int getDarkMutedColor(int i) {
        if (this.mDarkMutedSwatch != null) {
            i = this.mDarkMutedSwatch.getRgb();
        }
        return i;
    }

    public Swatch getDarkMutedSwatch() {
        return this.mDarkMutedSwatch;
    }

    public int getDarkVibrantColor(int i) {
        if (this.mDarkVibrantSwatch != null) {
            i = this.mDarkVibrantSwatch.getRgb();
        }
        return i;
    }

    public Swatch getDarkVibrantSwatch() {
        return this.mDarkVibrantSwatch;
    }

    public int getLightMutedColor(int i) {
        if (this.mLightMutedColor != null) {
            i = this.mLightMutedColor.getRgb();
        }
        return i;
    }

    public Swatch getLightMutedSwatch() {
        return this.mLightMutedColor;
    }

    public int getLightVibrantColor(int i) {
        if (this.mLightVibrantSwatch != null) {
            i = this.mLightVibrantSwatch.getRgb();
        }
        return i;
    }

    public Swatch getLightVibrantSwatch() {
        return this.mLightVibrantSwatch;
    }

    public int getMutedColor(int i) {
        if (this.mMutedSwatch != null) {
            i = this.mMutedSwatch.getRgb();
        }
        return i;
    }

    public Swatch getMutedSwatch() {
        return this.mMutedSwatch;
    }

    public List<Swatch> getSwatches() {
        return Collections.unmodifiableList(this.mSwatches);
    }

    public int getVibrantColor(int i) {
        if (this.mVibrantSwatch != null) {
            i = this.mVibrantSwatch.getRgb();
        }
        return i;
    }

    public Swatch getVibrantSwatch() {
        return this.mVibrantSwatch;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.mSwatches != null ? this.mSwatches.hashCode() : 0;
        int hashCode2 = this.mVibrantSwatch != null ? this.mVibrantSwatch.hashCode() : 0;
        int hashCode3 = this.mMutedSwatch != null ? this.mMutedSwatch.hashCode() : 0;
        int hashCode4 = this.mDarkVibrantSwatch != null ? this.mDarkVibrantSwatch.hashCode() : 0;
        int hashCode5 = this.mDarkMutedSwatch != null ? this.mDarkMutedSwatch.hashCode() : 0;
        int hashCode6 = this.mLightVibrantSwatch != null ? this.mLightVibrantSwatch.hashCode() : 0;
        if (this.mLightMutedColor != null) {
            i = this.mLightMutedColor.hashCode();
        }
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i;
    }
}
