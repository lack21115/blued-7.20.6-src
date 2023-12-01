package android.util;

import com.android.internal.util.Preconditions;

/* loaded from: source-9557208-dex2jar.jar:android/util/SizeF.class */
public final class SizeF {
    private final float mHeight;
    private final float mWidth;

    public SizeF(float f, float f2) {
        this.mWidth = Preconditions.checkArgumentFinite(f, "width");
        this.mHeight = Preconditions.checkArgumentFinite(f2, "height");
    }

    private static NumberFormatException invalidSizeF(String str) {
        throw new NumberFormatException("Invalid SizeF: \"" + str + "\"");
    }

    public static SizeF parseSizeF(String str) throws NumberFormatException {
        Preconditions.checkNotNull(str, "string must not be null");
        int indexOf = str.indexOf(42);
        int i = indexOf;
        if (indexOf < 0) {
            i = str.indexOf(120);
        }
        if (i < 0) {
            throw invalidSizeF(str);
        }
        try {
            return new SizeF(Float.parseFloat(str.substring(0, i)), Float.parseFloat(str.substring(i + 1)));
        } catch (NumberFormatException e) {
            throw invalidSizeF(str);
        } catch (IllegalArgumentException e2) {
            throw invalidSizeF(str);
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
        if (obj instanceof SizeF) {
            SizeF sizeF = (SizeF) obj;
            if (this.mWidth != sizeF.mWidth || this.mHeight != sizeF.mHeight) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.mWidth) ^ Float.floatToIntBits(this.mHeight);
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
