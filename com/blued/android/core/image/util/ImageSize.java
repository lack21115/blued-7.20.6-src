package com.blued.android.core.image.util;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/util/ImageSize.class */
public final class ImageSize {
    private int a;
    private int b;

    public ImageSize() {
    }

    public ImageSize(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int a() {
        return this.a;
    }

    public void a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        boolean z = false;
        if (obj instanceof ImageSize) {
            ImageSize imageSize = (ImageSize) obj;
            z = false;
            if (this.a == imageSize.a) {
                z = false;
                if (this.b == imageSize.b) {
                    z = true;
                }
            }
        }
        return z;
    }

    public String toString() {
        return "[" + this.a + "x" + this.b + "]";
    }
}
