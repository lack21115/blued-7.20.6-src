package android.content.res;

import android.content.pm.ApplicationInfo;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.alipay.sdk.util.i;
import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/CompatibilityInfo.class */
public class CompatibilityInfo implements Parcelable {
    private static final int ALWAYS_NEEDS_COMPAT = 2;
    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    public static final float MAXIMUM_ASPECT_RATIO = 1.7791667f;
    private static final int NEEDS_SCREEN_COMPAT = 8;
    private static final int NEVER_NEEDS_COMPAT = 4;
    private static final int SCALING_REQUIRED = 1;
    public final int applicationDensity;
    public final float applicationInvertedScale;
    public final float applicationScale;
    private final int mCompatibilityFlags;
    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() { // from class: android.content.res.CompatibilityInfo.1
    };
    public static final Parcelable.Creator<CompatibilityInfo> CREATOR = new Parcelable.Creator<CompatibilityInfo>() { // from class: android.content.res.CompatibilityInfo.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompatibilityInfo createFromParcel(Parcel parcel) {
            return new CompatibilityInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompatibilityInfo[] newArray(int i) {
            return new CompatibilityInfo[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/CompatibilityInfo$Translator.class */
    public class Translator {
        public final float applicationInvertedScale;
        public final float applicationScale;
        private Rect mContentInsetsBuffer;
        private Region mTouchableAreaBuffer;
        private Rect mVisibleInsetsBuffer;

        Translator(CompatibilityInfo compatibilityInfo) {
            this(compatibilityInfo.applicationScale, compatibilityInfo.applicationInvertedScale);
        }

        Translator(float f, float f2) {
            this.mContentInsetsBuffer = null;
            this.mVisibleInsetsBuffer = null;
            this.mTouchableAreaBuffer = null;
            this.applicationScale = f;
            this.applicationInvertedScale = f2;
        }

        public Rect getTranslatedContentInsets(Rect rect) {
            if (this.mContentInsetsBuffer == null) {
                this.mContentInsetsBuffer = new Rect();
            }
            this.mContentInsetsBuffer.set(rect);
            translateRectInAppWindowToScreen(this.mContentInsetsBuffer);
            return this.mContentInsetsBuffer;
        }

        public Region getTranslatedTouchableArea(Region region) {
            if (this.mTouchableAreaBuffer == null) {
                this.mTouchableAreaBuffer = new Region();
            }
            this.mTouchableAreaBuffer.set(region);
            this.mTouchableAreaBuffer.scale(this.applicationScale);
            return this.mTouchableAreaBuffer;
        }

        public Rect getTranslatedVisibleInsets(Rect rect) {
            if (this.mVisibleInsetsBuffer == null) {
                this.mVisibleInsetsBuffer = new Rect();
            }
            this.mVisibleInsetsBuffer.set(rect);
            translateRectInAppWindowToScreen(this.mVisibleInsetsBuffer);
            return this.mVisibleInsetsBuffer;
        }

        public void translateCanvas(Canvas canvas) {
            if (this.applicationScale == 1.5f) {
                canvas.translate(0.0026143792f, 0.0026143792f);
            }
            canvas.scale(this.applicationScale, this.applicationScale);
        }

        public void translateEventInScreenToAppWindow(MotionEvent motionEvent) {
            motionEvent.scale(this.applicationInvertedScale);
        }

        public void translateLayoutParamsInAppWindowToScreen(WindowManager.LayoutParams layoutParams) {
            layoutParams.scale(this.applicationScale);
        }

        public void translatePointInScreenToAppWindow(PointF pointF) {
            float f = this.applicationInvertedScale;
            if (f != 1.0f) {
                pointF.x *= f;
                pointF.y *= f;
            }
        }

        public void translateRectInAppWindowToScreen(Rect rect) {
            rect.scale(this.applicationScale);
        }

        public void translateRectInScreenToAppWinFrame(Rect rect) {
            rect.scale(this.applicationInvertedScale);
        }

        public void translateRectInScreenToAppWindow(Rect rect) {
            rect.scale(this.applicationInvertedScale);
        }

        public void translateRegionInWindowToScreen(Region region) {
            region.scale(this.applicationScale);
        }

        public void translateWindowLayout(WindowManager.LayoutParams layoutParams) {
            layoutParams.scale(this.applicationScale);
        }
    }

    private CompatibilityInfo() {
        this(4, DisplayMetrics.DENSITY_DEVICE, 1.0f, 1.0f);
    }

    private CompatibilityInfo(int i, int i2, float f, float f2) {
        this.mCompatibilityFlags = i;
        this.applicationDensity = i2;
        this.applicationScale = f;
        this.applicationInvertedScale = f2;
    }

    public CompatibilityInfo(ApplicationInfo applicationInfo, int i, int i2, boolean z) {
        int i3;
        if (applicationInfo.requiresSmallestWidthDp == 0 && applicationInfo.compatibleWidthLimitDp == 0 && applicationInfo.largestWidthLimitDp == 0) {
            boolean z2 = false;
            boolean z3 = false;
            if ((applicationInfo.flags & 2048) != 0) {
                boolean z4 = false | true;
                z3 = true;
                z2 = z4;
                if (!z) {
                    z2 = z4 | true;
                    z3 = true;
                }
            }
            boolean z5 = z3;
            boolean z6 = z2;
            if ((applicationInfo.flags & 524288) != 0) {
                z5 = true;
                z6 = z2;
                if (!z) {
                    z6 = z2 | true;
                    z5 = true;
                }
            }
            boolean z7 = z6;
            if ((applicationInfo.flags & 4096) != 0) {
                z5 = true;
                z7 = z6 | true;
            }
            boolean z8 = z ? z7 & true : z7;
            int i4 = 0 | 8;
            switch (i & 15) {
                case 3:
                    int i5 = (z8 && true) ? i4 & (-9) : i4;
                    i4 = i5;
                    if ((applicationInfo.flags & 2048) != 0) {
                        i4 = i5 | 4;
                        break;
                    }
                    break;
                case 4:
                    int i6 = (z8 && true) ? i4 & (-9) : i4;
                    i4 = i6;
                    if ((applicationInfo.flags & 524288) != 0) {
                        i4 = i6 | 4;
                        break;
                    }
                    break;
            }
            if ((268435456 & i) == 0) {
                i3 = (i4 & (-9)) | 4;
            } else if (z8 && true) {
                i3 = i4 & (-9);
            } else {
                i3 = i4;
                if (!z5) {
                    i3 = i4 | 2;
                }
            }
            if ((applicationInfo.flags & 8192) != 0) {
                this.applicationDensity = DisplayMetrics.DENSITY_DEVICE;
                this.applicationScale = 1.0f;
                this.applicationInvertedScale = 1.0f;
            } else {
                this.applicationDensity = 160;
                this.applicationScale = DisplayMetrics.DENSITY_DEVICE / 160.0f;
                this.applicationInvertedScale = 1.0f / this.applicationScale;
                i3 |= 1;
            }
        } else {
            int i7 = applicationInfo.requiresSmallestWidthDp != 0 ? applicationInfo.requiresSmallestWidthDp : applicationInfo.compatibleWidthLimitDp;
            int i8 = i7 == 0 ? applicationInfo.largestWidthLimitDp : i7;
            int i9 = applicationInfo.compatibleWidthLimitDp != 0 ? applicationInfo.compatibleWidthLimitDp : i8;
            int i10 = i9 < i8 ? i8 : i9;
            int i11 = applicationInfo.largestWidthLimitDp;
            if (i8 > 320) {
                i3 = 0 | 4;
            } else if (i11 != 0 && i2 > i11) {
                i3 = 0 | 10;
            } else if (i10 >= i2) {
                i3 = 0 | 4;
            } else {
                i3 = 0;
                if (z) {
                    i3 = 0 | 8;
                }
            }
            this.applicationDensity = DisplayMetrics.DENSITY_DEVICE;
            this.applicationScale = 1.0f;
            this.applicationInvertedScale = 1.0f;
        }
        this.mCompatibilityFlags = i3;
    }

    private CompatibilityInfo(Parcel parcel) {
        this.mCompatibilityFlags = parcel.readInt();
        this.applicationDensity = parcel.readInt();
        this.applicationScale = parcel.readFloat();
        this.applicationInvertedScale = parcel.readFloat();
    }

    public static float computeCompatibleScaling(DisplayMetrics displayMetrics, DisplayMetrics displayMetrics2) {
        int i;
        int i2;
        int i3;
        int i4 = displayMetrics.noncompatWidthPixels;
        int i5 = displayMetrics.noncompatHeightPixels;
        if (i4 < i5) {
            i = i4;
            i2 = i5;
        } else {
            i = i5;
            i2 = i4;
        }
        int i6 = (int) ((320.0f * displayMetrics.density) + 0.5f);
        float f = i2 / i;
        float f2 = f;
        if (f > 1.7791667f) {
            f2 = 1.7791667f;
        }
        int i7 = (int) ((i6 * f2) + 0.5f);
        if (i4 < i5) {
            i3 = i6;
            i6 = i7;
        } else {
            i3 = i7;
        }
        float f3 = i4 / i3;
        float f4 = i5 / i6;
        if (f3 >= f4) {
            f3 = f4;
        }
        float f5 = f3;
        if (f3 < 1.0f) {
            f5 = 1.0f;
        }
        if (displayMetrics2 != null) {
            displayMetrics2.widthPixels = i3;
            displayMetrics2.heightPixels = i6;
        }
        return f5;
    }

    public boolean alwaysSupportsScreen() {
        return (this.mCompatibilityFlags & 4) != 0;
    }

    public void applyToConfiguration(int i, Configuration configuration) {
        if (!supportsScreen()) {
            configuration.screenLayout = (configuration.screenLayout & (-16)) | 2;
            configuration.screenWidthDp = configuration.compatScreenWidthDp;
            configuration.screenHeightDp = configuration.compatScreenHeightDp;
            configuration.smallestScreenWidthDp = configuration.compatSmallestScreenWidthDp;
        }
        configuration.densityDpi = i;
        if (isScalingRequired()) {
            configuration.densityDpi = (int) ((configuration.densityDpi * this.applicationInvertedScale) + 0.5f);
        }
    }

    public void applyToDisplayMetrics(DisplayMetrics displayMetrics) {
        if (supportsScreen()) {
            displayMetrics.widthPixels = displayMetrics.noncompatWidthPixels;
            displayMetrics.heightPixels = displayMetrics.noncompatHeightPixels;
        } else {
            computeCompatibleScaling(displayMetrics, displayMetrics);
        }
        if (isScalingRequired()) {
            float f = this.applicationInvertedScale;
            displayMetrics.density = displayMetrics.noncompatDensity * f;
            displayMetrics.densityDpi = (int) ((displayMetrics.noncompatDensityDpi * f) + 0.5f);
            displayMetrics.scaledDensity = displayMetrics.noncompatScaledDensity * f;
            displayMetrics.xdpi = displayMetrics.noncompatXdpi * f;
            displayMetrics.ydpi = displayMetrics.noncompatYdpi * f;
            displayMetrics.widthPixels = (int) ((displayMetrics.widthPixels * f) + 0.5f);
            displayMetrics.heightPixels = (int) ((displayMetrics.heightPixels * f) + 0.5f);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            CompatibilityInfo compatibilityInfo = (CompatibilityInfo) obj;
            if (this.mCompatibilityFlags == compatibilityInfo.mCompatibilityFlags && this.applicationDensity == compatibilityInfo.applicationDensity && this.applicationScale == compatibilityInfo.applicationScale) {
                return this.applicationInvertedScale == compatibilityInfo.applicationInvertedScale;
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Translator getTranslator() {
        if (isScalingRequired()) {
            return new Translator(this);
        }
        return null;
    }

    public int hashCode() {
        return ((((((this.mCompatibilityFlags + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.applicationDensity) * 31) + Float.floatToIntBits(this.applicationScale)) * 31) + Float.floatToIntBits(this.applicationInvertedScale);
    }

    public boolean isScalingRequired() {
        return (this.mCompatibilityFlags & 1) != 0;
    }

    public boolean neverSupportsScreen() {
        return (this.mCompatibilityFlags & 2) != 0;
    }

    public boolean supportsScreen() {
        return (this.mCompatibilityFlags & 8) == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("{");
        sb.append(this.applicationDensity);
        sb.append("dpi");
        if (isScalingRequired()) {
            sb.append(" ");
            sb.append(this.applicationScale);
            sb.append("x");
        }
        if (!supportsScreen()) {
            sb.append(" resizing");
        }
        if (neverSupportsScreen()) {
            sb.append(" never-compat");
        }
        if (alwaysSupportsScreen()) {
            sb.append(" always-compat");
        }
        sb.append(i.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCompatibilityFlags);
        parcel.writeInt(this.applicationDensity);
        parcel.writeFloat(this.applicationScale);
        parcel.writeFloat(this.applicationInvertedScale);
    }
}
