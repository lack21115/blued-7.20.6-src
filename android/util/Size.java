package android.util;

import com.android.internal.util.Preconditions;

/* loaded from: source-9557208-dex2jar.jar:android/util/Size.class */
public final class Size {
    private final int mHeight;
    private final int mWidth;

    public Size(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    private static NumberFormatException invalidSize(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public static Size parseSize(String str) throws NumberFormatException {
        Preconditions.checkNotNull(str, "string must not be null");
        int indexOf = str.indexOf(42);
        int i = indexOf;
        if (indexOf < 0) {
            i = str.indexOf(120);
        }
        if (i < 0) {
            throw invalidSize(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, i)), Integer.parseInt(str.substring(i + 1)));
        } catch (NumberFormatException e) {
            throw invalidSize(str);
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.mWidth != size.mWidth || this.mHeight != size.mHeight) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return this.mHeight ^ ((this.mWidth << 16) | (this.mWidth >>> 16));
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
