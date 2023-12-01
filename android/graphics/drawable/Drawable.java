package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Insets;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.os.BatteryManager;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/Drawable.class */
public abstract class Drawable {
    private int mLayoutDirection;
    private static final Rect ZERO_BOUNDS_RECT = new Rect();
    static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private int[] mStateSet = StateSet.WILD_CARD;
    private int mLevel = 0;
    private int mChangingConfigurations = 0;
    private Rect mBounds = ZERO_BOUNDS_RECT;
    private WeakReference<Callback> mCallback = null;
    private boolean mVisible = true;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/Drawable$Callback.class */
    public interface Callback {
        void invalidateDrawable(Drawable drawable);

        void scheduleDrawable(Drawable drawable, Runnable runnable, long j);

        void unscheduleDrawable(Drawable drawable, Runnable runnable);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/Drawable$ConstantState.class */
    public static abstract class ConstantState {
        public int addAtlasableBitmaps(Collection<Bitmap> collection) {
            return 0;
        }

        public boolean canApplyTheme() {
            return false;
        }

        public abstract int getChangingConfigurations();

        /* JADX INFO: Access modifiers changed from: protected */
        public final boolean isAtlasable(Bitmap bitmap) {
            return bitmap != null && bitmap.getConfig() == Bitmap.Config.ARGB_8888;
        }

        public abstract Drawable newDrawable();

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            return newDrawable(null);
        }
    }

    public static Drawable createFromPath(String str) {
        if (str == null) {
            return null;
        }
        Trace.traceBegin(8192L, str);
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (decodeFile == null) {
                Trace.traceEnd(8192L);
                return null;
            }
            Drawable drawableFromBitmap = drawableFromBitmap(null, decodeFile, null, null, null, str);
            Trace.traceEnd(8192L);
            return drawableFromBitmap;
        } catch (Throwable th) {
            Trace.traceEnd(8192L);
            throw th;
        }
    }

    public static Drawable createFromResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, String str) {
        Trace.traceBegin(8192L, str != null ? str : "Unknown drawable");
        try {
            Drawable createFromResourceStream = createFromResourceStream(resources, typedValue, inputStream, str, null);
            Trace.traceEnd(8192L);
            return createFromResourceStream;
        } catch (Throwable th) {
            Trace.traceEnd(8192L);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (android.graphics.NinePatch.isNinePatchChunk(r0) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable createFromResourceStream(android.content.res.Resources r7, android.util.TypedValue r8, java.io.InputStream r9, java.lang.String r10, android.graphics.BitmapFactory.Options r11) {
        /*
            r0 = r9
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            android.graphics.Rect r0 = new android.graphics.Rect
            r1 = r0
            r1.<init>()
            r14 = r0
            r0 = r11
            r13 = r0
            r0 = r11
            if (r0 != 0) goto L21
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r1 = r0
            r1.<init>()
            r13 = r0
        L21:
            r0 = r7
            if (r0 == 0) goto L80
            r0 = r7
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.noncompatDensityDpi
            r12 = r0
        L2e:
            r0 = r13
            r1 = r12
            r0.inScreenDensity = r1
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r14
            r4 = r13
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResourceStream(r0, r1, r2, r3, r4)
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L88
            r0 = r13
            byte[] r0 = r0.getNinePatchChunk()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L60
            r0 = r11
            r8 = r0
            r0 = r14
            r9 = r0
            r0 = r11
            boolean r0 = android.graphics.NinePatch.isNinePatchChunk(r0)
            if (r0 != 0) goto L64
        L60:
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
        L64:
            android.graphics.Rect r0 = new android.graphics.Rect
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r13
            r1 = r11
            r0.getOpticalInsets(r1)
            r0 = r7
            r1 = r13
            r2 = r8
            r3 = r9
            r4 = r11
            r5 = r10
            android.graphics.drawable.Drawable r0 = drawableFromBitmap(r0, r1, r2, r3, r4, r5)
            return r0
        L80:
            r0 = 160(0xa0, float:2.24E-43)
            r12 = r0
            goto L2e
        L88:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.graphics.drawable.Drawable.createFromResourceStream(android.content.res.Resources, android.util.TypedValue, java.io.InputStream, java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.drawable.Drawable");
    }

    public static Drawable createFromStream(InputStream inputStream, String str) {
        Trace.traceBegin(8192L, str != null ? str : "Unknown drawable");
        try {
            Drawable createFromResourceStream = createFromResourceStream(null, null, inputStream, str);
            Trace.traceEnd(8192L);
            return createFromResourceStream;
        } catch (Throwable th) {
            Trace.traceEnd(8192L);
            throw th;
        }
    }

    public static Drawable createFromXml(Resources resources, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createFromXml(resources, xmlPullParser, null);
    }

    public static Drawable createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        Drawable createFromXmlInner = createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        if (createFromXmlInner == null) {
            throw new RuntimeException("Unknown initial tag: " + xmlPullParser.getName());
        }
        return createFromXmlInner;
    }

    public static Drawable createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        return createFromXmlInner(resources, xmlPullParser, attributeSet, null);
    }

    public static Drawable createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        String name = xmlPullParser.getName();
        boolean z = true;
        switch (name.hashCode()) {
            case -1724158635:
                if (name.equals("transition")) {
                    z = true;
                    break;
                }
                break;
            case -1671889043:
                if (name.equals("nine-patch")) {
                    z = true;
                    break;
                }
                break;
            case -1493546681:
                if (name.equals("animation-list")) {
                    z = true;
                    break;
                }
                break;
            case -1388777169:
                if (name.equals("bitmap")) {
                    z = true;
                    break;
                }
                break;
            case -930826704:
                if (name.equals("ripple")) {
                    z = true;
                    break;
                }
                break;
            case -925180581:
                if (name.equals("rotate")) {
                    z = true;
                    break;
                }
                break;
            case -820387517:
                if (name.equals("vector")) {
                    z = true;
                    break;
                }
                break;
            case -510364471:
                if (name.equals("animated-selector")) {
                    z = true;
                    break;
                }
                break;
            case -94197862:
                if (name.equals("layer-list")) {
                    z = true;
                    break;
                }
                break;
            case 3056464:
                if (name.equals("clip")) {
                    z = true;
                    break;
                }
                break;
            case 94842723:
                if (name.equals("color")) {
                    z = true;
                    break;
                }
                break;
            case 100360477:
                if (name.equals("inset")) {
                    z = true;
                    break;
                }
                break;
            case 109250890:
                if (name.equals(BatteryManager.EXTRA_SCALE)) {
                    z = true;
                    break;
                }
                break;
            case 109399969:
                if (name.equals("shape")) {
                    z = true;
                    break;
                }
                break;
            case 160680263:
                if (name.equals("level-list")) {
                    z = true;
                    break;
                }
                break;
            case 1191572447:
                if (name.equals("selector")) {
                    z = false;
                    break;
                }
                break;
            case 2013827269:
                if (name.equals("animated-rotate")) {
                    z = true;
                    break;
                }
                break;
            case 2118620333:
                if (name.equals("animated-vector")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                drawable = new StateListDrawable();
                break;
            case true:
                drawable = new AnimatedStateListDrawable();
                break;
            case true:
                drawable = new LevelListDrawable();
                break;
            case true:
                drawable = new LayerDrawable();
                break;
            case true:
                drawable = new TransitionDrawable();
                break;
            case true:
                drawable = new RippleDrawable();
                break;
            case true:
                drawable = new ColorDrawable();
                break;
            case true:
                drawable = new GradientDrawable();
                break;
            case true:
                drawable = new VectorDrawable();
                break;
            case true:
                drawable = new AnimatedVectorDrawable();
                break;
            case true:
                drawable = new ScaleDrawable();
                break;
            case true:
                drawable = new ClipDrawable();
                break;
            case true:
                drawable = new RotateDrawable();
                break;
            case true:
                drawable = new AnimatedRotateDrawable();
                break;
            case true:
                drawable = new AnimationDrawable();
                break;
            case true:
                drawable = new InsetDrawable();
                break;
            case true:
                Drawable bitmapDrawable = new BitmapDrawable(resources);
                drawable = bitmapDrawable;
                if (resources != null) {
                    ((BitmapDrawable) bitmapDrawable).setTargetDensity(resources.getDisplayMetrics());
                    drawable = bitmapDrawable;
                    break;
                }
                break;
            case true:
                Drawable ninePatchDrawable = new NinePatchDrawable();
                drawable = ninePatchDrawable;
                if (resources != null) {
                    ((NinePatchDrawable) ninePatchDrawable).setTargetDensity(resources.getDisplayMetrics());
                    drawable = ninePatchDrawable;
                    break;
                }
                break;
            default:
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid drawable tag " + name);
        }
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        return drawable;
    }

    private static Drawable drawableFromBitmap(Resources resources, Bitmap bitmap, byte[] bArr, Rect rect, Rect rect2, String str) {
        return bArr != null ? new NinePatchDrawable(resources, bitmap, bArr, rect, rect2, str) : new BitmapDrawable(resources, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
        }
    }

    public static int resolveOpacity(int i, int i2) {
        if (i == i2) {
            return i;
        }
        if (i == 0 || i2 == 0) {
            return 0;
        }
        if (i == -3 || i2 == -3) {
            return -3;
        }
        return (i == -2 || i2 == -2) ? -2 : -1;
    }

    public void applyTheme(Resources.Theme theme) {
    }

    public boolean canApplyTheme() {
        return false;
    }

    public void clearColorFilter() {
        setColorFilter(null);
    }

    public void clearMutated() {
    }

    public final Rect copyBounds() {
        return new Rect(this.mBounds);
    }

    public final void copyBounds(Rect rect) {
        rect.set(this.mBounds);
    }

    public abstract void draw(Canvas canvas);

    public int getAlpha() {
        return 255;
    }

    public final Rect getBounds() {
        if (this.mBounds == ZERO_BOUNDS_RECT) {
            this.mBounds = new Rect();
        }
        return this.mBounds;
    }

    public Callback getCallback() {
        if (this.mCallback != null) {
            return this.mCallback.get();
        }
        return null;
    }

    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public ColorFilter getColorFilter() {
        return null;
    }

    public ConstantState getConstantState() {
        return null;
    }

    public Drawable getCurrent() {
        return this;
    }

    public Rect getDirtyBounds() {
        return getBounds();
    }

    public void getHotspotBounds(Rect rect) {
        rect.set(getBounds());
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public int getLayoutDirection() {
        return this.mLayoutDirection;
    }

    public final int getLevel() {
        return this.mLevel;
    }

    public int getMinimumHeight() {
        int intrinsicHeight = getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            return intrinsicHeight;
        }
        return 0;
    }

    public int getMinimumWidth() {
        int intrinsicWidth = getIntrinsicWidth();
        if (intrinsicWidth > 0) {
            return intrinsicWidth;
        }
        return 0;
    }

    public abstract int getOpacity();

    public Insets getOpticalInsets() {
        return Insets.NONE;
    }

    public void getOutline(Outline outline) {
        outline.setRect(getBounds());
        outline.setAlpha(0.0f);
    }

    public boolean getPadding(Rect rect) {
        rect.set(0, 0, 0, 0);
        return false;
    }

    public int[] getState() {
        return this.mStateSet;
    }

    public Region getTransparentRegion() {
        return null;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.Drawable, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.Drawable);
        inflateWithAttributes(resources, xmlPullParser, obtainStyledAttributes, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void inflateWithAttributes(Resources resources, XmlPullParser xmlPullParser, TypedArray typedArray, int i) throws XmlPullParserException, IOException {
        this.mVisible = typedArray.getBoolean(i, this.mVisible);
    }

    public void invalidateSelf() {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return false;
    }

    public boolean isProjected() {
        return false;
    }

    public boolean isStateful() {
        return false;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public void jumpToCurrentState() {
    }

    public Drawable mutate() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return false;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public abstract void setAlpha(int i);

    public void setAutoMirrored(boolean z) {
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.mBounds;
        Rect rect2 = rect;
        if (rect == ZERO_BOUNDS_RECT) {
            rect2 = new Rect();
            this.mBounds = rect2;
        }
        if (rect2.left == i && rect2.top == i2 && rect2.right == i3 && rect2.bottom == i4) {
            return;
        }
        if (!rect2.isEmpty()) {
            invalidateSelf();
        }
        this.mBounds.set(i, i2, i3, i4);
        onBoundsChange(this.mBounds);
    }

    public void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void setCallback(Callback callback) {
        this.mCallback = new WeakReference<>(callback);
    }

    public void setChangingConfigurations(int i) {
        this.mChangingConfigurations = i;
    }

    public void setColorFilter(int i, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(i, mode));
    }

    public abstract void setColorFilter(ColorFilter colorFilter);

    public void setDither(boolean z) {
    }

    public void setFilterBitmap(boolean z) {
    }

    public void setHotspot(float f, float f2) {
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
    }

    public void setLayoutDirection(int i) {
        if (getLayoutDirection() != i) {
            this.mLayoutDirection = i;
        }
    }

    public final boolean setLevel(int i) {
        if (this.mLevel != i) {
            this.mLevel = i;
            return onLevelChange(i);
        }
        return false;
    }

    public boolean setState(int[] iArr) {
        if (Arrays.equals(this.mStateSet, iArr)) {
            return false;
        }
        this.mStateSet = iArr;
        return onStateChange(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
    }

    public void setTintMode(PorterDuff.Mode mode) {
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = this.mVisible != z;
        if (z3) {
            this.mVisible = z;
            invalidateSelf();
        }
        return z3;
    }

    public void setXfermode(Xfermode xfermode) {
    }

    public void unscheduleSelf(Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (porterDuffColorFilter == null) {
            return new PorterDuffColorFilter(colorForState, mode);
        }
        porterDuffColorFilter.setColor(colorForState);
        porterDuffColorFilter.setMode(mode);
        return porterDuffColorFilter;
    }
}
