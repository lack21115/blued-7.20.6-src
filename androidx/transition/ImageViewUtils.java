package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ImageViewUtils.class */
class ImageViewUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3454a = true;
    private static Field b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3455c;

    private ImageViewUtils() {
    }

    private static void a() {
        if (f3455c) {
            return;
        }
        try {
            Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
            b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
        f3455c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
        } else if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            b(imageView, matrix);
        } else {
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                Matrix matrix2 = null;
                a();
                Field field = b;
                if (field != null) {
                    matrix2 = null;
                    try {
                        Matrix matrix3 = (Matrix) field.get(imageView);
                        if (matrix3 == null) {
                            try {
                                Matrix matrix4 = new Matrix();
                                matrix2 = matrix4;
                                b.set(imageView, matrix4);
                                matrix2 = matrix4;
                            } catch (IllegalAccessException e) {
                            }
                        }
                        matrix2 = matrix3;
                    } catch (IllegalAccessException e2) {
                    }
                }
                if (matrix2 != null) {
                    matrix2.set(matrix);
                }
                imageView.invalidate();
            }
        }
    }

    private static void b(ImageView imageView, Matrix matrix) {
        if (f3454a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError e) {
                f3454a = false;
            }
        }
    }
}
