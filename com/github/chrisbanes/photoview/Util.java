package com.github.chrisbanes.photoview;

import android.widget.ImageView;

/* loaded from: source-8110460-dex2jar.jar:com/github/chrisbanes/photoview/Util.class */
class Util {

    /* renamed from: com.github.chrisbanes.photoview.Util$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/chrisbanes/photoview/Util$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8448a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f8448a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    Util() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        return (i & 65280) >> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f2 >= f3) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (AnonymousClass1.f8448a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ImageView imageView) {
        return imageView.getDrawable() != null;
    }
}
