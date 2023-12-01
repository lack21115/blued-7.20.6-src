package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.graphics.ColorUtils;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ThemeUtils.class */
public class ThemeUtils {
    private static final ThreadLocal<TypedValue> i = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1891a = {-16842910};
    static final int[] b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1892c = {16843518};
    static final int[] d = {16842919};
    static final int[] e = {16842912};
    static final int[] f = {16842913};
    static final int[] g = {-16842919, -16842908};
    static final int[] h = new int[0];
    private static final int[] j = new int[1];

    private ThemeUtils() {
    }

    static int a(Context context, int i2, float f2) {
        int themeAttrColor = getThemeAttrColor(context, i2);
        return ColorUtils.setAlphaComponent(themeAttrColor, Math.round(Color.alpha(themeAttrColor) * f2));
    }

    private static TypedValue a() {
        TypedValue typedValue = i.get();
        TypedValue typedValue2 = typedValue;
        if (typedValue == null) {
            typedValue2 = new TypedValue();
            i.set(typedValue2);
        }
        return typedValue2;
    }

    public static void checkAppCompatTheme(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [int[], int[][]] */
    public static ColorStateList createDisabledStateList(int i2, int i3) {
        return new ColorStateList(new int[]{f1891a, h}, new int[]{i3, i2});
    }

    public static int getDisabledThemeAttrColor(Context context, int i2) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i2);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            TypedValue a2 = a();
            context.getTheme().resolveAttribute(16842803, a2, true);
            return a(context, i2, a2.getFloat());
        }
        return themeAttrColorStateList.getColorForState(f1891a, themeAttrColorStateList.getDefaultColor());
    }

    public static int getThemeAttrColor(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
