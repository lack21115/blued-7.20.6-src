package android.graphics;

import android.graphics.PorterDuff;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PorterDuffColorFilter.class */
public class PorterDuffColorFilter extends ColorFilter {
    private int mColor;
    private PorterDuff.Mode mMode;

    public PorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        this.mColor = i;
        this.mMode = mode;
        update();
    }

    private static native long native_CreatePorterDuffFilter(int i, int i2);

    private void update() {
        destroyFilter(this.native_instance);
        this.native_instance = native_CreatePorterDuffFilter(this.mColor, this.mMode.nativeInt);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter) obj;
        return this.mColor == porterDuffColorFilter.mColor && this.mMode == porterDuffColorFilter.mMode;
    }

    public int getColor() {
        return this.mColor;
    }

    public PorterDuff.Mode getMode() {
        return this.mMode;
    }

    public int hashCode() {
        return (this.mMode.hashCode() * 31) + this.mColor;
    }

    public void setColor(int i) {
        this.mColor = i;
        update();
    }

    public void setMode(PorterDuff.Mode mode) {
        this.mMode = mode;
        update();
    }
}
