package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/LightingColorFilter.class */
public class LightingColorFilter extends ColorFilter {
    private int mAdd;
    private int mMul;

    public LightingColorFilter(int i, int i2) {
        this.mMul = i;
        this.mAdd = i2;
        update();
    }

    private static native long native_CreateLightingFilter(int i, int i2);

    private void update() {
        destroyFilter(this.native_instance);
        this.native_instance = native_CreateLightingFilter(this.mMul, this.mAdd);
    }

    public int getColorAdd() {
        return this.mAdd;
    }

    public int getColorMultiply() {
        return this.mMul;
    }

    public void setColorAdd(int i) {
        this.mAdd = i;
        update();
    }

    public void setColorMultiply(int i) {
        this.mMul = i;
        update();
    }
}
