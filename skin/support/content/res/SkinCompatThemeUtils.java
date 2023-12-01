package skin.support.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import skin.support.graphics.ColorUtils;

/* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatThemeUtils.class */
public class SkinCompatThemeUtils {
    private static final ThreadLocal<TypedValue> o = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    static final int[] f44225a = {-16842910};
    static final int[] b = {16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f44226c = {16842909};
    static final int[] d = {16842908};
    static final int[] e = {16843518};
    static final int[] f = {16843547};
    static final int[] g = {16843623};
    static final int[] h = {16843624};
    static final int[] i = {16843625};
    static final int[] j = {16842919};
    static final int[] k = {16842912};
    static final int[] l = {16842913};
    static final int[] m = {-16842919, -16842908};
    static final int[] n = new int[0];
    private static final int[] p = new int[1];

    public static int a(Context context) {
        return a(context, new int[]{16842806});
    }

    public static int a(Context context, int i2) {
        int[] iArr = p;
        iArr[0] = i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                return SkinCompatResources.c(context, resourceId);
            }
            obtainStyledAttributes.recycle();
            return 0;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int a(Context context, int i2, float f2) {
        int a2 = a(context, i2);
        return ColorUtils.a(a2, Math.round(Color.alpha(a2) * f2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static TypedValue a() {
        TypedValue typedValue = o.get();
        TypedValue typedValue2 = typedValue;
        if (typedValue == null) {
            typedValue2 = new TypedValue();
            o.set(typedValue2);
        }
        return typedValue2;
    }

    public static int b(Context context) {
        return a(context, new int[]{16842836});
    }

    public static ColorStateList b(Context context, int i2) {
        int[] iArr = p;
        iArr[0] = i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                return SkinCompatResources.d(context, resourceId);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int c(Context context, int i2) {
        ColorStateList b2 = b(context, i2);
        if (b2 == null || !b2.isStateful()) {
            TypedValue a2 = a();
            context.getTheme().resolveAttribute(16842803, a2, true);
            return a(context, i2, a2.getFloat());
        }
        return b2.getColorForState(f44225a, b2.getDefaultColor());
    }
}
