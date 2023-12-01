package android.graphics;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/graphics/LayerRasterizer.class */
public class LayerRasterizer extends Rasterizer {
    public LayerRasterizer() {
        this.native_instance = nativeConstructor();
    }

    private static native void nativeAddLayer(long j, long j2, float f, float f2);

    private static native long nativeConstructor();

    public void addLayer(Paint paint) {
        nativeAddLayer(this.native_instance, paint.mNativePaint, 0.0f, 0.0f);
    }

    public void addLayer(Paint paint, float f, float f2) {
        nativeAddLayer(this.native_instance, paint.mNativePaint, f, f2);
    }
}
