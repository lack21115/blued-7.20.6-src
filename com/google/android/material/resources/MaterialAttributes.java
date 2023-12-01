package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/resources/MaterialAttributes.class */
public class MaterialAttributes {
    public static TypedValue resolve(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(Context context, int i, boolean z) {
        TypedValue resolve = resolve(context, i);
        boolean z2 = z;
        if (resolve != null) {
            z2 = z;
            if (resolve.type == 18) {
                if (resolve.data != 0) {
                    return true;
                }
                z2 = false;
            }
        }
        return z2;
    }

    public static boolean resolveBooleanOrThrow(Context context, int i, String str) {
        return resolveOrThrow(context, i, str) != 0;
    }

    public static int resolveDimension(Context context, int i, int i2) {
        TypedValue resolve = resolve(context, i);
        return (int) ((resolve == null || resolve.type != 5) ? context.getResources().getDimension(i2) : resolve.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static int resolveInteger(Context context, int i, int i2) {
        TypedValue resolve = resolve(context, i);
        int i3 = i2;
        if (resolve != null) {
            i3 = i2;
            if (resolve.type == 16) {
                i3 = resolve.data;
            }
        }
        return i3;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context context) {
        return resolveDimension(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(Context context, int i, String str) {
        TypedValue resolve = resolve(context, i);
        if (resolve != null) {
            return resolve.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static int resolveOrThrow(View view, int i) {
        return resolveOrThrow(view.getContext(), i, view.getClass().getCanonicalName());
    }
}
