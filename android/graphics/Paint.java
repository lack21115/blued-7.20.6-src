package android.graphics;

import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Paint.class */
public class Paint {
    public static final int ANTI_ALIAS_FLAG = 1;
    public static final int AUTO_HINTING_TEXT_FLAG = 2048;
    public static final int BIDI_DEFAULT_LTR = 2;
    public static final int BIDI_DEFAULT_RTL = 3;
    private static final int BIDI_FLAG_MASK = 7;
    public static final int BIDI_FORCE_LTR = 4;
    public static final int BIDI_FORCE_RTL = 5;
    public static final int BIDI_LTR = 0;
    private static final int BIDI_MAX_FLAG_VALUE = 5;
    public static final int BIDI_RTL = 1;
    public static final int CURSOR_AFTER = 0;
    public static final int CURSOR_AT = 4;
    public static final int CURSOR_AT_OR_AFTER = 1;
    public static final int CURSOR_AT_OR_BEFORE = 3;
    public static final int CURSOR_BEFORE = 2;
    private static final int CURSOR_OPT_MAX_VALUE = 4;
    static final int DEFAULT_PAINT_FLAGS = 1280;
    public static final int DEV_KERN_TEXT_FLAG = 256;
    public static final int DIRECTION_LTR = 0;
    public static final int DIRECTION_RTL = 1;
    public static final int DITHER_FLAG = 4;
    public static final int EMBEDDED_BITMAP_TEXT_FLAG = 1024;
    public static final int FAKE_BOLD_TEXT_FLAG = 32;
    public static final int FILTER_BITMAP_FLAG = 2;
    public static final int HINTING_OFF = 0;
    public static final int HINTING_ON = 1;
    public static final int LCD_RENDER_TEXT_FLAG = 512;
    public static final int LINEAR_TEXT_FLAG = 64;
    public static final int STRIKE_THRU_TEXT_FLAG = 16;
    public static final int SUBPIXEL_TEXT_FLAG = 128;
    public static final int UNDERLINE_TEXT_FLAG = 8;
    public static final int VERTICAL_TEXT_FLAG = 4096;
    public int mBidiFlags;
    private ColorFilter mColorFilter;
    private float mCompatScaling;
    private String mFontFeatureSettings;
    private boolean mHasCompatScaling;
    private float mInvCompatScaling;
    private Locale mLocale;
    private MaskFilter mMaskFilter;
    public long mNativePaint;
    public long mNativeTypeface;
    private PathEffect mPathEffect;
    private Rasterizer mRasterizer;
    private Shader mShader;
    private Typeface mTypeface;
    private Xfermode mXfermode;
    static final Style[] sStyleArray = {Style.FILL, Style.STROKE, Style.FILL_AND_STROKE};
    static final Cap[] sCapArray = {Cap.BUTT, Cap.ROUND, Cap.SQUARE};
    static final Join[] sJoinArray = {Join.MITER, Join.ROUND, Join.BEVEL};
    static final Align[] sAlignArray = {Align.LEFT, Align.CENTER, Align.RIGHT};

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Paint$Align.class */
    public enum Align {
        LEFT(0),
        CENTER(1),
        RIGHT(2);
        
        final int nativeInt;

        Align(int i) {
            this.nativeInt = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Paint$Cap.class */
    public enum Cap {
        BUTT(0),
        ROUND(1),
        SQUARE(2);
        
        final int nativeInt;

        Cap(int i) {
            this.nativeInt = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Paint$FontMetrics.class */
    public static class FontMetrics {
        public float ascent;
        public float bottom;
        public float descent;
        public float leading;
        public float top;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Paint$FontMetricsInt.class */
    public static class FontMetricsInt {
        public int ascent;
        public int bottom;
        public int descent;
        public int leading;
        public int top;

        public String toString() {
            return "FontMetricsInt: top=" + this.top + " ascent=" + this.ascent + " descent=" + this.descent + " bottom=" + this.bottom + " leading=" + this.leading;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Paint$Join.class */
    public enum Join {
        MITER(0),
        ROUND(1),
        BEVEL(2);
        
        final int nativeInt;

        Join(int i) {
            this.nativeInt = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Paint$Style.class */
    public enum Style {
        FILL(0),
        STROKE(1),
        FILL_AND_STROKE(2);
        
        final int nativeInt;

        Style(int i) {
            this.nativeInt = i;
        }
    }

    public Paint() {
        this(0);
    }

    public Paint(int i) {
        this.mBidiFlags = 2;
        this.mNativePaint = native_init();
        setFlags(i | 1280);
        this.mInvCompatScaling = 1.0f;
        this.mCompatScaling = 1.0f;
        setTextLocale(Locale.getDefault());
    }

    public Paint(Paint paint) {
        this.mBidiFlags = 2;
        this.mNativePaint = native_initWithPaint(paint.mNativePaint);
        setClassVariablesFrom(paint);
    }

    private static native void finalizer(long j);

    private static native void nativeGetCharArrayBounds(long j, long j2, char[] cArr, int i, int i2, int i3, Rect rect);

    private static native void nativeGetStringBounds(long j, long j2, String str, int i, int i2, int i3, Rect rect);

    private static native int native_breakText(long j, long j2, String str, boolean z, float f, int i, float[] fArr);

    private static native int native_breakText(long j, long j2, char[] cArr, int i, int i2, float f, int i3, float[] fArr);

    private static native boolean native_getFillPath(long j, long j2, long j3);

    private static native float native_getLetterSpacing(long j);

    private static native int native_getStrokeCap(long j);

    private static native int native_getStrokeJoin(long j);

    private static native int native_getStyle(long j);

    private static native int native_getTextAlign(long j);

    private static native int native_getTextGlyphs(long j, String str, int i, int i2, int i3, int i4, int i5, char[] cArr);

    private static native void native_getTextPath(long j, long j2, int i, String str, int i2, int i3, float f, float f2, long j3);

    private static native void native_getTextPath(long j, long j2, int i, char[] cArr, int i2, int i3, float f, float f2, long j3);

    private static native float native_getTextRunAdvances(long j, long j2, String str, int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5);

    private static native float native_getTextRunAdvances(long j, long j2, char[] cArr, int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5);

    private native int native_getTextRunCursor(long j, String str, int i, int i2, int i3, int i4, int i5);

    private native int native_getTextRunCursor(long j, char[] cArr, int i, int i2, int i3, int i4, int i5);

    private static native int native_getTextWidths(long j, long j2, String str, int i, int i2, int i3, float[] fArr);

    private static native int native_getTextWidths(long j, long j2, char[] cArr, int i, int i2, int i3, float[] fArr);

    private static native boolean native_hasShadowLayer(long j);

    private static native long native_init();

    private static native long native_initWithPaint(long j);

    private native float native_measureText(String str, int i);

    private native float native_measureText(String str, int i, int i2, int i3);

    private native float native_measureText(char[] cArr, int i, int i2, int i3);

    private static native void native_reset(long j);

    private static native void native_set(long j, long j2);

    private static native long native_setColorFilter(long j, long j2);

    private static native void native_setFontFeatureSettings(long j, String str);

    private static native void native_setLetterSpacing(long j, float f);

    private static native long native_setMaskFilter(long j, long j2);

    private static native long native_setPathEffect(long j, long j2);

    private static native long native_setRasterizer(long j, long j2);

    private static native long native_setShader(long j, long j2);

    private static native void native_setShadowLayer(long j, float f, float f2, float f3, int i);

    private static native void native_setStrokeCap(long j, int i);

    private static native void native_setStrokeJoin(long j, int i);

    private static native void native_setStyle(long j, int i);

    private static native void native_setTextAlign(long j, int i);

    private static native void native_setTextLocale(long j, String str);

    private static native long native_setTypeface(long j, long j2);

    private static native long native_setXfermode(long j, long j2);

    private void setClassVariablesFrom(Paint paint) {
        this.mColorFilter = paint.mColorFilter;
        this.mMaskFilter = paint.mMaskFilter;
        this.mPathEffect = paint.mPathEffect;
        this.mRasterizer = paint.mRasterizer;
        if (paint.mShader != null) {
            this.mShader = paint.mShader.copy();
        } else {
            this.mShader = null;
        }
        this.mTypeface = paint.mTypeface;
        this.mNativeTypeface = paint.mNativeTypeface;
        this.mXfermode = paint.mXfermode;
        this.mHasCompatScaling = paint.mHasCompatScaling;
        this.mCompatScaling = paint.mCompatScaling;
        this.mInvCompatScaling = paint.mInvCompatScaling;
        this.mBidiFlags = paint.mBidiFlags;
        this.mLocale = paint.mLocale;
        this.mFontFeatureSettings = paint.mFontFeatureSettings;
    }

    public native float ascent();

    public int breakText(CharSequence charSequence, int i, int i2, boolean z, float f, float[] fArr) {
        if (charSequence == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((i | i2 | (i2 - i) | (charSequence.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (charSequence.length() == 0 || i == i2) {
            return 0;
        }
        if (i == 0 && (charSequence instanceof String) && i2 == charSequence.length()) {
            return breakText((String) charSequence, z, f, fArr);
        }
        char[] obtain = TemporaryBuffer.obtain(i2 - i);
        TextUtils.getChars(charSequence, i, i2, obtain, 0);
        int breakText = z ? breakText(obtain, 0, i2 - i, f, fArr) : breakText(obtain, 0, -(i2 - i), f, fArr);
        TemporaryBuffer.recycle(obtain);
        return breakText;
    }

    public int breakText(String str, boolean z, float f, float[] fArr) {
        int i;
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (str.length() == 0) {
            i = 0;
        } else if (!this.mHasCompatScaling) {
            return native_breakText(this.mNativePaint, this.mNativeTypeface, str, z, f, this.mBidiFlags, fArr);
        } else {
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            int native_breakText = native_breakText(this.mNativePaint, this.mNativeTypeface, str, z, f * this.mCompatScaling, this.mBidiFlags, fArr);
            setTextSize(textSize);
            i = native_breakText;
            if (fArr != null) {
                fArr[0] = fArr[0] * this.mInvCompatScaling;
                return native_breakText;
            }
        }
        return i;
    }

    public int breakText(char[] cArr, int i, int i2, float f, float[] fArr) {
        int i3;
        if (cArr == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (i < 0 || cArr.length - i < Math.abs(i2)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (cArr.length == 0 || i2 == 0) {
            i3 = 0;
        } else if (!this.mHasCompatScaling) {
            return native_breakText(this.mNativePaint, this.mNativeTypeface, cArr, i, i2, f, this.mBidiFlags, fArr);
        } else {
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            int native_breakText = native_breakText(this.mNativePaint, this.mNativeTypeface, cArr, i, i2, f * this.mCompatScaling, this.mBidiFlags, fArr);
            setTextSize(textSize);
            i3 = native_breakText;
            if (fArr != null) {
                fArr[0] = fArr[0] * this.mInvCompatScaling;
                return native_breakText;
            }
        }
        return i3;
    }

    public void clearShadowLayer() {
        setShadowLayer(0.0f, 0.0f, 0.0f, 0);
    }

    public native float descent();

    protected void finalize() throws Throwable {
        try {
            finalizer(this.mNativePaint);
        } finally {
            super.finalize();
        }
    }

    public native int getAlpha();

    public int getBidiFlags() {
        return this.mBidiFlags;
    }

    public native int getColor();

    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    public boolean getFillPath(Path path, Path path2) {
        return native_getFillPath(this.mNativePaint, path.ni(), path2.ni());
    }

    public native int getFlags();

    public String getFontFeatureSettings() {
        return this.mFontFeatureSettings;
    }

    public native float getFontMetrics(FontMetrics fontMetrics);

    public FontMetrics getFontMetrics() {
        FontMetrics fontMetrics = new FontMetrics();
        getFontMetrics(fontMetrics);
        return fontMetrics;
    }

    public native int getFontMetricsInt(FontMetricsInt fontMetricsInt);

    public FontMetricsInt getFontMetricsInt() {
        FontMetricsInt fontMetricsInt = new FontMetricsInt();
        getFontMetricsInt(fontMetricsInt);
        return fontMetricsInt;
    }

    public float getFontSpacing() {
        return getFontMetrics(null);
    }

    public native int getHinting();

    public float getLetterSpacing() {
        return native_getLetterSpacing(this.mNativePaint);
    }

    public MaskFilter getMaskFilter() {
        return this.mMaskFilter;
    }

    public PathEffect getPathEffect() {
        return this.mPathEffect;
    }

    @Deprecated
    public Rasterizer getRasterizer() {
        return this.mRasterizer;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public Cap getStrokeCap() {
        return sCapArray[native_getStrokeCap(this.mNativePaint)];
    }

    public Join getStrokeJoin() {
        return sJoinArray[native_getStrokeJoin(this.mNativePaint)];
    }

    public native float getStrokeMiter();

    public native float getStrokeWidth();

    public Style getStyle() {
        return sStyleArray[native_getStyle(this.mNativePaint)];
    }

    public Align getTextAlign() {
        return sAlignArray[native_getTextAlign(this.mNativePaint)];
    }

    public void getTextBounds(String str, int i, int i2, Rect rect) {
        if ((i | i2 | (i2 - i) | (str.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (rect == null) {
            throw new NullPointerException("need bounds Rect");
        }
        nativeGetStringBounds(this.mNativePaint, this.mNativeTypeface, str, i, i2, this.mBidiFlags, rect);
    }

    public void getTextBounds(char[] cArr, int i, int i2, Rect rect) {
        if ((i | i2) < 0 || i + i2 > cArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (rect == null) {
            throw new NullPointerException("need bounds Rect");
        }
        nativeGetCharArrayBounds(this.mNativePaint, this.mNativeTypeface, cArr, i, i2, this.mBidiFlags, rect);
    }

    public Locale getTextLocale() {
        return this.mLocale;
    }

    public void getTextPath(String str, int i, int i2, float f, float f2, Path path) {
        if ((i | i2 | (i2 - i) | (str.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        native_getTextPath(this.mNativePaint, this.mNativeTypeface, this.mBidiFlags, str, i, i2, f, f2, path.ni());
    }

    public void getTextPath(char[] cArr, int i, int i2, float f, float f2, Path path) {
        if ((i | i2) < 0 || i + i2 > cArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_getTextPath(this.mNativePaint, this.mNativeTypeface, this.mBidiFlags, cArr, i, i2, f, f2, path.ni());
    }

    public float getTextRunAdvances(CharSequence charSequence, int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5) {
        if (charSequence == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (((fArr == null ? 0 : (fArr.length - i5) - (i2 - i)) | (charSequence.length() - i4) | i | i2 | i3 | i4 | i5 | (i2 - i) | (i - i3) | (i4 - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (charSequence instanceof String) {
            return getTextRunAdvances((String) charSequence, i, i2, i3, i4, z, fArr, i5);
        }
        if ((charSequence instanceof SpannedString) || (charSequence instanceof SpannableString)) {
            return getTextRunAdvances(charSequence.toString(), i, i2, i3, i4, z, fArr, i5);
        }
        if (charSequence instanceof GraphicsOperations) {
            return ((GraphicsOperations) charSequence).getTextRunAdvances(i, i2, i3, i4, z, fArr, i5, this);
        }
        if (charSequence.length() == 0 || i2 == i) {
            return 0.0f;
        }
        int i6 = i4 - i3;
        char[] obtain = TemporaryBuffer.obtain(i6);
        TextUtils.getChars(charSequence, i3, i4, obtain, 0);
        float textRunAdvances = getTextRunAdvances(obtain, i - i3, i2 - i, 0, i6, z, fArr, i5);
        TemporaryBuffer.recycle(obtain);
        return textRunAdvances;
    }

    public float getTextRunAdvances(String str, int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (((fArr == null ? 0 : (fArr.length - i5) - (i2 - i)) | (str.length() - i4) | i | i2 | i3 | i4 | i5 | (i2 - i) | (i - i3) | (i4 - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (str.length() == 0 || i == i2) {
            return 0.0f;
        }
        if (this.mHasCompatScaling) {
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            float native_getTextRunAdvances = native_getTextRunAdvances(this.mNativePaint, this.mNativeTypeface, str, i, i2, i3, i4, z, fArr, i5);
            setTextSize(textSize);
            if (fArr != null) {
                int i6 = i5;
                while (true) {
                    int i7 = i6;
                    if (i7 >= i5 + (i2 - i)) {
                        break;
                    }
                    fArr[i7] = fArr[i7] * this.mInvCompatScaling;
                    i6 = i7 + 1;
                }
            }
            return this.mInvCompatScaling * native_getTextRunAdvances;
        }
        return native_getTextRunAdvances(this.mNativePaint, this.mNativeTypeface, str, i, i2, i3, i4, z, fArr, i5);
    }

    public float getTextRunAdvances(char[] cArr, int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5) {
        if (cArr == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (((fArr == null ? 0 : fArr.length - (i5 + i2)) | (cArr.length - (i3 + i4)) | i | i2 | i3 | i4 | i5 | (i - i3) | (i4 - i2) | ((i3 + i4) - (i + i2))) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (cArr.length == 0 || i2 == 0) {
            return 0.0f;
        }
        if (this.mHasCompatScaling) {
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            float native_getTextRunAdvances = native_getTextRunAdvances(this.mNativePaint, this.mNativeTypeface, cArr, i, i2, i3, i4, z, fArr, i5);
            setTextSize(textSize);
            if (fArr != null) {
                int i6 = i5;
                while (true) {
                    int i7 = i6;
                    if (i7 >= i5 + i2) {
                        break;
                    }
                    fArr[i7] = fArr[i7] * this.mInvCompatScaling;
                    i6 = i7 + 1;
                }
            }
            return this.mInvCompatScaling * native_getTextRunAdvances;
        }
        return native_getTextRunAdvances(this.mNativePaint, this.mNativeTypeface, cArr, i, i2, i3, i4, z, fArr, i5);
    }

    public int getTextRunCursor(CharSequence charSequence, int i, int i2, int i3, int i4, int i5) {
        if ((charSequence instanceof String) || (charSequence instanceof SpannedString) || (charSequence instanceof SpannableString)) {
            return getTextRunCursor(charSequence.toString(), i, i2, i3, i4, i5);
        }
        if (charSequence instanceof GraphicsOperations) {
            return ((GraphicsOperations) charSequence).getTextRunCursor(i, i2, i3, i4, i5, this);
        }
        int i6 = i2 - i;
        char[] obtain = TemporaryBuffer.obtain(i6);
        TextUtils.getChars(charSequence, i, i2, obtain, 0);
        int textRunCursor = getTextRunCursor(obtain, 0, i6, i3, i4 - i, i5);
        TemporaryBuffer.recycle(obtain);
        return textRunCursor;
    }

    public int getTextRunCursor(String str, int i, int i2, int i3, int i4, int i5) {
        if ((i | i2 | i4 | (i2 - i) | (i4 - i) | (i2 - i4) | (str.length() - i2) | i5) < 0 || i5 > 4) {
            throw new IndexOutOfBoundsException();
        }
        return native_getTextRunCursor(this.mNativePaint, str, i, i2, i3, i4, i5);
    }

    public int getTextRunCursor(char[] cArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = i + i2;
        if ((i | i6 | i4 | (i6 - i) | (i4 - i) | (i6 - i4) | (cArr.length - i6) | i5) < 0 || i5 > 4) {
            throw new IndexOutOfBoundsException();
        }
        return native_getTextRunCursor(this.mNativePaint, cArr, i, i2, i3, i4, i5);
    }

    public native float getTextScaleX();

    public native float getTextSize();

    public native float getTextSkewX();

    public int getTextWidths(CharSequence charSequence, int i, int i2, float[] fArr) {
        if (charSequence == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((i | i2 | (i2 - i) | (charSequence.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 - i > fArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (charSequence.length() == 0 || i == i2) {
            return 0;
        }
        if (charSequence instanceof String) {
            return getTextWidths((String) charSequence, i, i2, fArr);
        }
        if ((charSequence instanceof SpannedString) || (charSequence instanceof SpannableString)) {
            return getTextWidths(charSequence.toString(), i, i2, fArr);
        }
        if (charSequence instanceof GraphicsOperations) {
            return ((GraphicsOperations) charSequence).getTextWidths(i, i2, fArr, this);
        }
        char[] obtain = TemporaryBuffer.obtain(i2 - i);
        TextUtils.getChars(charSequence, i, i2, obtain, 0);
        int textWidths = getTextWidths(obtain, 0, i2 - i, fArr);
        TemporaryBuffer.recycle(obtain);
        return textWidths;
    }

    public int getTextWidths(String str, int i, int i2, float[] fArr) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((i | i2 | (i2 - i) | (str.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 - i > fArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (str.length() != 0 && i != i2) {
            if (!this.mHasCompatScaling) {
                return native_getTextWidths(this.mNativePaint, this.mNativeTypeface, str, i, i2, this.mBidiFlags, fArr);
            }
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            int native_getTextWidths = native_getTextWidths(this.mNativePaint, this.mNativeTypeface, str, i, i2, this.mBidiFlags, fArr);
            setTextSize(textSize);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i3 = native_getTextWidths;
                if (i5 >= native_getTextWidths) {
                    break;
                }
                fArr[i5] = fArr[i5] * this.mInvCompatScaling;
                i4 = i5 + 1;
            }
        } else {
            i3 = 0;
        }
        return i3;
    }

    public int getTextWidths(String str, float[] fArr) {
        return getTextWidths(str, 0, str.length(), fArr);
    }

    public int getTextWidths(char[] cArr, int i, int i2, float[] fArr) {
        int i3;
        if (cArr == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((i | i2) < 0 || i + i2 > cArr.length || i2 > fArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (cArr.length != 0 && i2 != 0) {
            if (!this.mHasCompatScaling) {
                return native_getTextWidths(this.mNativePaint, this.mNativeTypeface, cArr, i, i2, this.mBidiFlags, fArr);
            }
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            int native_getTextWidths = native_getTextWidths(this.mNativePaint, this.mNativeTypeface, cArr, i, i2, this.mBidiFlags, fArr);
            setTextSize(textSize);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i3 = native_getTextWidths;
                if (i5 >= native_getTextWidths) {
                    break;
                }
                fArr[i5] = fArr[i5] * this.mInvCompatScaling;
                i4 = i5 + 1;
            }
        } else {
            i3 = 0;
        }
        return i3;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public Xfermode getXfermode() {
        return this.mXfermode;
    }

    public boolean hasShadowLayer() {
        return native_hasShadowLayer(this.mNativePaint);
    }

    public final boolean isAntiAlias() {
        return (getFlags() & 1) != 0;
    }

    public final boolean isDither() {
        return (getFlags() & 4) != 0;
    }

    public native boolean isElegantTextHeight();

    public final boolean isFakeBoldText() {
        return (getFlags() & 32) != 0;
    }

    public final boolean isFilterBitmap() {
        return (getFlags() & 2) != 0;
    }

    public final boolean isLinearText() {
        return (getFlags() & 64) != 0;
    }

    public final boolean isStrikeThruText() {
        return (getFlags() & 16) != 0;
    }

    public final boolean isSubpixelText() {
        return (getFlags() & 128) != 0;
    }

    public final boolean isUnderlineText() {
        return (getFlags() & 8) != 0;
    }

    public float measureText(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((i | i2 | (i2 - i) | (charSequence.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (charSequence.length() == 0 || i == i2) {
            return 0.0f;
        }
        if (charSequence instanceof String) {
            return measureText((String) charSequence, i, i2);
        }
        if ((charSequence instanceof SpannedString) || (charSequence instanceof SpannableString)) {
            return measureText(charSequence.toString(), i, i2);
        }
        if (charSequence instanceof GraphicsOperations) {
            return ((GraphicsOperations) charSequence).measureText(i, i2, this);
        }
        char[] obtain = TemporaryBuffer.obtain(i2 - i);
        TextUtils.getChars(charSequence, i, i2, obtain, 0);
        float measureText = measureText(obtain, 0, i2 - i);
        TemporaryBuffer.recycle(obtain);
        return measureText;
    }

    public float measureText(String str) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if (str.length() == 0) {
            return 0.0f;
        }
        if (this.mHasCompatScaling) {
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            float native_measureText = native_measureText(str, this.mBidiFlags);
            setTextSize(textSize);
            return (float) Math.ceil(this.mInvCompatScaling * native_measureText);
        }
        return (float) Math.ceil(native_measureText(str, this.mBidiFlags));
    }

    public float measureText(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((i | i2 | (i2 - i) | (str.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (str.length() == 0 || i == i2) {
            return 0.0f;
        }
        if (this.mHasCompatScaling) {
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            float native_measureText = native_measureText(str, i, i2, this.mBidiFlags);
            setTextSize(textSize);
            return (float) Math.ceil(this.mInvCompatScaling * native_measureText);
        }
        return (float) Math.ceil(native_measureText(str, i, i2, this.mBidiFlags));
    }

    public float measureText(char[] cArr, int i, int i2) {
        if (cArr == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((i | i2) < 0 || i + i2 > cArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (cArr.length == 0 || i2 == 0) {
            return 0.0f;
        }
        if (this.mHasCompatScaling) {
            float textSize = getTextSize();
            setTextSize(this.mCompatScaling * textSize);
            float native_measureText = native_measureText(cArr, i, i2, this.mBidiFlags);
            setTextSize(textSize);
            return (float) Math.ceil(this.mInvCompatScaling * native_measureText);
        }
        return (float) Math.ceil(native_measureText(cArr, i, i2, this.mBidiFlags));
    }

    public void reset() {
        native_reset(this.mNativePaint);
        setFlags(1280);
        this.mColorFilter = null;
        this.mMaskFilter = null;
        this.mPathEffect = null;
        this.mRasterizer = null;
        this.mShader = null;
        this.mTypeface = null;
        this.mNativeTypeface = 0L;
        this.mXfermode = null;
        this.mHasCompatScaling = false;
        this.mCompatScaling = 1.0f;
        this.mInvCompatScaling = 1.0f;
        this.mBidiFlags = 2;
        setTextLocale(Locale.getDefault());
        setElegantTextHeight(false);
        this.mFontFeatureSettings = null;
    }

    public void set(Paint paint) {
        if (this != paint) {
            native_set(this.mNativePaint, paint.mNativePaint);
            setClassVariablesFrom(paint);
        }
    }

    public void setARGB(int i, int i2, int i3, int i4) {
        setColor((i << 24) | (i2 << 16) | (i3 << 8) | i4);
    }

    public native void setAlpha(int i);

    public native void setAntiAlias(boolean z);

    public void setBidiFlags(int i) {
        int i2 = i & 7;
        if (i2 > 5) {
            throw new IllegalArgumentException("unknown bidi flag: " + i2);
        }
        this.mBidiFlags = i2;
    }

    public native void setColor(int i);

    public ColorFilter setColorFilter(ColorFilter colorFilter) {
        long j = 0;
        if (colorFilter != null) {
            j = colorFilter.native_instance;
        }
        native_setColorFilter(this.mNativePaint, j);
        this.mColorFilter = colorFilter;
        return colorFilter;
    }

    public void setCompatibilityScaling(float f) {
        if (f == 1.0d) {
            this.mHasCompatScaling = false;
            this.mInvCompatScaling = 1.0f;
            this.mCompatScaling = 1.0f;
            return;
        }
        this.mHasCompatScaling = true;
        this.mCompatScaling = f;
        this.mInvCompatScaling = 1.0f / f;
    }

    public native void setDither(boolean z);

    public native void setElegantTextHeight(boolean z);

    public native void setFakeBoldText(boolean z);

    public native void setFilterBitmap(boolean z);

    public native void setFlags(int i);

    public void setFontFeatureSettings(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.equals("")) {
                str2 = null;
            }
        }
        if (str2 == null && this.mFontFeatureSettings == null) {
            return;
        }
        if (str2 == null || !str2.equals(this.mFontFeatureSettings)) {
            this.mFontFeatureSettings = str2;
            native_setFontFeatureSettings(this.mNativePaint, str2);
        }
    }

    public native void setHinting(int i);

    public void setLetterSpacing(float f) {
        native_setLetterSpacing(this.mNativePaint, f);
    }

    public native void setLinearText(boolean z);

    public MaskFilter setMaskFilter(MaskFilter maskFilter) {
        long j = 0;
        if (maskFilter != null) {
            j = maskFilter.native_instance;
        }
        native_setMaskFilter(this.mNativePaint, j);
        this.mMaskFilter = maskFilter;
        return maskFilter;
    }

    public PathEffect setPathEffect(PathEffect pathEffect) {
        long j = 0;
        if (pathEffect != null) {
            j = pathEffect.native_instance;
        }
        native_setPathEffect(this.mNativePaint, j);
        this.mPathEffect = pathEffect;
        return pathEffect;
    }

    @Deprecated
    public Rasterizer setRasterizer(Rasterizer rasterizer) {
        long j = 0;
        if (rasterizer != null) {
            j = rasterizer.native_instance;
        }
        native_setRasterizer(this.mNativePaint, j);
        this.mRasterizer = rasterizer;
        return rasterizer;
    }

    public Shader setShader(Shader shader) {
        long j = 0;
        if (shader != null) {
            j = shader.getNativeInstance();
        }
        native_setShader(this.mNativePaint, j);
        this.mShader = shader;
        return shader;
    }

    public void setShadowLayer(float f, float f2, float f3, int i) {
        native_setShadowLayer(this.mNativePaint, f, f2, f3, i);
    }

    public native void setStrikeThruText(boolean z);

    public void setStrokeCap(Cap cap) {
        native_setStrokeCap(this.mNativePaint, cap.nativeInt);
    }

    public void setStrokeJoin(Join join) {
        native_setStrokeJoin(this.mNativePaint, join.nativeInt);
    }

    public native void setStrokeMiter(float f);

    public native void setStrokeWidth(float f);

    public void setStyle(Style style) {
        native_setStyle(this.mNativePaint, style.nativeInt);
    }

    public native void setSubpixelText(boolean z);

    public void setTextAlign(Align align) {
        native_setTextAlign(this.mNativePaint, align.nativeInt);
    }

    public void setTextLocale(Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("locale cannot be null");
        }
        if (locale.equals(this.mLocale)) {
            return;
        }
        this.mLocale = locale;
        native_setTextLocale(this.mNativePaint, locale.toString());
    }

    public native void setTextScaleX(float f);

    public native void setTextSize(float f);

    public native void setTextSkewX(float f);

    public Typeface setTypeface(Typeface typeface) {
        long j = 0;
        if (typeface != null) {
            j = typeface.native_instance;
        }
        native_setTypeface(this.mNativePaint, j);
        this.mTypeface = typeface;
        this.mNativeTypeface = j;
        return typeface;
    }

    public native void setUnderlineText(boolean z);

    public Xfermode setXfermode(Xfermode xfermode) {
        long j = 0;
        if (xfermode != null) {
            j = xfermode.native_instance;
        }
        native_setXfermode(this.mNativePaint, j);
        this.mXfermode = xfermode;
        return xfermode;
    }
}
