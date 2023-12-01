package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifViewUtils.class */
final class GifViewUtils {
    static final List<String> a = Arrays.asList("raw", "drawable", "mipmap");

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifViewUtils$InitResult.class */
    static class InitResult {
        final int a;
        final int b;
        final boolean c;

        InitResult(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    private GifViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = 160;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 <= 0 || i3 <= 0) {
            return 1.0f;
        }
        return i3 / i2;
    }

    private static int a(ImageView imageView, AttributeSet attributeSet, boolean z) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
        if (attributeResourceValue > 0) {
            if (!a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) || a(imageView, z, attributeResourceValue)) {
                return 0;
            }
            return attributeResourceValue;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InitResult a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        return (attributeSet == null || imageView.isInEditMode()) ? new InitResult(0, 0, false) : new InitResult(a(imageView, attributeSet, true), a(imageView, attributeSet, false), a((View) imageView, attributeSet, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new GifDrawable(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                GifDrawable gifDrawable = new GifDrawable(resources, i);
                if (z) {
                    imageView.setImageDrawable(gifDrawable);
                    return true;
                } else if (Build.VERSION.SDK_INT >= 16) {
                    imageView.setBackground(gifDrawable);
                    return true;
                } else {
                    imageView.setBackgroundDrawable(gifDrawable);
                    return true;
                }
            } catch (Resources.NotFoundException | IOException e) {
                return false;
            }
        }
        return false;
    }
}
